package main;

import entities.News;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Diana on 05.07.2017.
 */
public class UI {
    private JPanel mainPanel;
    private JFrame jFrame;
    private JTextField textField1;
    private JList<News> newsList;
    private JRadioButton JSONRadioButton;
    private JRadioButton XMLRadioButton;
    private JTextField fromDateField;
    private JTextField toDateField;
    private JTextField filtersField;
    private JButton refreshButton;
    private JButton button1;
    private JRadioButton displayDayRB;
    private JRadioButton displayWeekRB;
    private JRadioButton displayMonthRB;
    private JRadioButton displayPeriodRB;
    private JLabel errorLabel;
    private JScrollPane newsListScrollPane;


    private static UI ui;

    private UI() {
        jFrame = new JFrame("Just News");
        jFrame.setContentPane(this.mainPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        
    }


    public static UI createUI() {
        if (null == ui) {
            ui = new UI();
        }
        return ui;
    }

    public void displayData(ArrayList<News> jsonList) {

        DefaultListModel<News> model = new DefaultListModel<>();
//        ArrayList<String> test = new ArrayList<>();
//        test.add("bngnbsf");
//        test.add("gndhngh");
//        test.add("gfsbgfbngfhn");
        for(News val : jsonList)
            model.addElement(val);

        newsList = new JList(model);
        newsList.setLayoutOrientation(JList.VERTICAL);
        newsList.setCellRenderer(new NewsRenderer());

        newsListScrollPane.setViewportView(newsList);
    }
}
