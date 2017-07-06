package main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Diana on 05.07.2017.
 */
public class UI {
    public JPanel mainPanel;
    private JTextField textField1;
    private JList list1;
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
    private JRadioButton периодRadioButton;


    private static UI ui;

    private UI() {
        JFrame jFrame = new JFrame("Just News");
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

}
