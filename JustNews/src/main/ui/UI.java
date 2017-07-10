package main.ui;

import entities.News;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Diana on 05.07.2017.
 */
public class UI {
    private JPanel mainPanel;
    private JFrame jFrame;
    private JTextField textField1;
    private JList<News> newsList;
    private JRadioButton jsonRadioButton;
    private JRadioButton xmlRadioButton;
    private JTextField fromDateField;
    private JTextField toDateField;
    private JButton refreshButton;
    private JRadioButton displayDayRB;
    private JRadioButton displayWeekRB;
    private JRadioButton displayMonthRB;
    private JRadioButton displayPeriodRB;
    private JTextArea errorLabel;
    private JScrollPane newsListScrollPane;
    private JRadioButton sortByDateRadioBtn;
    private JRadioButton sortByKeysRadioBtn;

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

    private void initComponents() {
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
                    errorLabel.setVisible(false);
                    listener.onRefreshBtnPressed();
                    refreshButton.setEnabled(false);
                }
            }
        });
    }


    public static UI getUI(OnUIActionListener listener) {
        if (null == ui) {
            ui = new UI();
        }
        ui.listeners.add(listener);
        return ui;
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

    public interface OnUIActionListener {


        void onJsonSelected();

        void onXmlSelected();

        void onRefreshBtnPressed();

        void onSortByDateSelected();

        void onSortByKeysSelected();
    }
}
