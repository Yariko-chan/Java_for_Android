package main;

import entities.News;
import org.jdesktop.swingx.JXTextArea;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Diana on 08.07.2017.
 */
public class NewsRenderer extends JLabel implements ListCellRenderer<News>{
    private JPanel viewPanel;

    private JTextArea dateLabel;
    private JTextArea titleLabel;
    private JTextArea descriptionLabel;
    private JTextArea keysLabel;

    public NewsRenderer() {
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends News> jList, News news, int i, boolean b, boolean b1) {

        dateLabel.setText(news.getDate());
        titleLabel.setText(news.getTitle());
        descriptionLabel.setText(news.getDescription());

        JPanel view = this.viewPanel;
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));//new GridLayout(4, 1)); //
        //view.add(dateLabel);
        //view.add(titleLabel);
        //view.add(descriptionLabel);
        return viewPanel;
    }
}
