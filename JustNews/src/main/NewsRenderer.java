package main;

import com.ctc.wstx.util.StringUtil;
import com.sun.deploy.util.StringUtils;
import entities.News;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

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

        dateLabel.setText(getFormattedDate(news.getDate()));

        // if title void set beginning of description + "..."
        String title = (null == news.getTitle()) ? getTitleFromDescription(news.getDescription()) : news.getTitle();
        titleLabel.setText(title);

        descriptionLabel.setText(news.getDescription());
        keysLabel.setText(getKeywordsString(news.getKeywords()));

        JPanel view = this.viewPanel;
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
        return viewPanel;
    }

    private String getFormattedDate(Date date) {
        if (null == date) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        return sdf.format(date);
    }

    // return first @count words from @description
    private String getTitleFromDescription(String description) {
        int count = 8; // count of words to title

        // find index of space №count, e.g. 8th space sign
        int index = 0;
        for (int i = 0; i < count; i++){
            index = description.indexOf(" ", index + 1);
        }
        String title = description.substring(0, index) + "...";
        return title;
    }

    private String getKeywordsString(String[] keywords) {
        String result = Arrays.stream(keywords).collect(Collectors.joining(" "));
        return  result;
    }
}
