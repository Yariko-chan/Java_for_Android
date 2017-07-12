package ui;

import data.entities.News;
import org.jdesktop.swingx.JXDatePicker;
import utils.Period;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Diana on 05.07.2017.
 */
public class UI {
    private JPanel mainPanel;
    private JFrame jFrame;
    private JTextField searchField;
    private JButton searchButton;
    private JScrollPane newsListScrollPane;
    private JList<News> newsList;
    private JRadioButton jsonRadioButton;
    private JRadioButton xmlRadioButton;
    private JRadioButton sortByDateRadioBtn;
    private JRadioButton sortByKeysRadioBtn;
    private JRadioButton displayDayRB;
    private JRadioButton displayWeekRB;
    private JRadioButton displayMonthRB;
    private JRadioButton displayPeriodRB;
    private JXDatePicker fromDateField;
    private JXDatePicker toDateField;
    private JTextArea errorLabel;
    private JButton refreshButton;
    private JPanel searchPanel;
    private JRadioButton displayAllRB;
    private JLabel fromLabel;
    private JLabel toLabel;

    private ArrayList<OnUIActionListener> listeners = new ArrayList<>();

    private static UI ui;

    private UI() {
        jFrame = new JFrame("Just News");
        jFrame.setContentPane(this.mainPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

        initComponents();
    }

    public static UI getUI(OnUIActionListener listener) {
        if (null == ui) {
            ui = new UI();
        }
        ui.listeners.add(listener);
        return ui;
    }

    private void initComponents() {
        // search
        jFrame.getRootPane().setDefaultButton(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String query = searchField.getText();
                if (null == query || "" == query) return;
                for (OnUIActionListener listener: listeners) {
                    listener.onSearchBtnPressed(query);
                }
            }
        });

        // JSON/XML radioButtons
        ButtonGroup selectFileTypeGroup = new ButtonGroup();
        selectFileTypeGroup.add(jsonRadioButton);
        selectFileTypeGroup.add(xmlRadioButton);
        jsonRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (OnUIActionListener listener: listeners) {
                    listener.onJsonSelected();
                }
            }
        });
        xmlRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (OnUIActionListener listener: listeners) {
                    listener.onXmlSelected();
                }
            }
        });

        // period radioButtons
        fromDateField.setDate(new Date());
        toDateField.setDate(new Date());
        ButtonGroup selectPeriodGroup = new ButtonGroup();
        selectPeriodGroup.add(displayAllRB);
        selectPeriodGroup.add(displayDayRB);
        selectPeriodGroup.add(displayWeekRB);
        selectPeriodGroup.add(displayMonthRB);
        selectPeriodGroup.add(displayPeriodRB);

        displayAllRB.addActionListener(selectPeriodListener);
        displayDayRB.addActionListener(selectPeriodListener);
        displayWeekRB.addActionListener(selectPeriodListener);
        displayMonthRB.addActionListener(selectPeriodListener);
        fromDateField.addActionListener(selectPeriodListener);
        toDateField.addActionListener(selectPeriodListener);

        // doesn't select a period, just enables DatePickers
        displayPeriodRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fromLabel.setEnabled(true);
                toLabel.setEnabled(true);
                fromDateField.setEnabled(true);
                toDateField.setEnabled(true);
            }
        });

        // sort radioButtons
        ButtonGroup selectSortGroup = new ButtonGroup();
        selectSortGroup.add(sortByDateRadioBtn);
        selectSortGroup.add(sortByKeysRadioBtn);
        sortByDateRadioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (OnUIActionListener listener: listeners) {
                    listener.onSortByDateSelected();
                }
            }
        });
        sortByKeysRadioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (OnUIActionListener listener: listeners) {
                    listener.onSortByKeysSelected();
                }
            }
        });

        // refresh button
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (OnUIActionListener listener: listeners) {
                    // if datePickers was filled by hands and Enter wasn't pressed at the end
                    // then selectPeriodListener doesn't catch new period
                    // so should check it here
                    if (fromDateField.isEnabled() || toDateField.isEnabled()) {
                        Date from = fromDateField.getDate();
                        Date to = toDateField.getDate();

                        try {
                            Period period = Period.newBuilder()
                                    .setFromDate(from)
                                    .setToDate(to)
                                    .build();
                            listener.onPeriodSelected(period);
                        } catch (Period.IncorrectPeriodException e) {
                            displayError(e.getMessage());
                            listener.onPeriodSelected(null); // null Period will not filter news
                        }
                    }

                    errorLabel.setVisible(false);
                    listener.onRefreshBtnPressed();
                    refreshButton.setEnabled(false);
                }
            }
        });
    }

    public void displayData(ArrayList<News> jsonList) {

        DefaultListModel<News> model = new DefaultListModel<>();
        for(News val : jsonList)
            model.addElement(val);

        newsList = new JList(model);
        newsList.setLayoutOrientation(JList.VERTICAL);
        newsList.setCellRenderer(new NewsRenderer());

        newsListScrollPane.setViewportView(newsList);

        refreshButton.setEnabled(true);
    }

    public void displayError(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);

        refreshButton.setEnabled(true);
    }

    private ActionListener selectPeriodListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Date from = new Date();
            Date to = new Date();
            switch (actionEvent.getActionCommand()) {
                case "all": {
                    disableDatePickers();

                    from = null;
                    to = null;
                    break;
                } case "for a day": {
                    disableDatePickers();

                    // from set to week later
                    Calendar calendar = GregorianCalendar.getInstance();
                    calendar.setTime(from);
                    calendar.add(Calendar.DATE, -1); // DATE = 1 day
                    from = calendar.getTime();
                    break;
                } case "for a week": {
                    disableDatePickers();

                    // from set to week earlier
                    Calendar calendar = GregorianCalendar.getInstance();
                    calendar.setTime(from);
                    calendar.add(Calendar.DATE, -7); // DATE = 1 day
                    from = calendar.getTime();
                    break;
                } case "for a month": {
                    disableDatePickers();

                    // from set to month earlier
                    Calendar calendar = GregorianCalendar.getInstance();
                    calendar.setTime(from);
                    calendar.add(Calendar.MONTH, -1);
                    from = calendar.getTime();
                    break;
                } case "datePickerCommit" : { // both datePickers have same actionCommand
                    from = fromDateField.getDate();
                    to = toDateField.getDate();
                }
                default:
                    from = null;
                    to = null;
                    break;
            }

            try {
                Period period = Period.newBuilder()
                        .setFromDate(from)
                        .setToDate(to)
                        .build();
                for (OnUIActionListener listener: listeners) {
                    listener.onPeriodSelected(period);
                }
            } catch (Period.IncorrectPeriodException e) {
                for (OnUIActionListener listener: listeners) {
                    listener.onPeriodSelected(null); // null Period will not filter news
                }
            }
        }

        private void disableDatePickers() {
            fromLabel.setEnabled(false);
            toLabel.setEnabled(false);
            fromDateField.setEnabled(false);
            toDateField.setEnabled(false);
        }
    };

    public interface OnUIActionListener {


        void onJsonSelected();

        void onXmlSelected();

        void onRefreshBtnPressed();

        void onSortByDateSelected();

        void onSortByKeysSelected();

        void onSearchBtnPressed(String query);

        void onPeriodSelected(Period period);
    }
}
