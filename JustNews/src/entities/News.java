package entities;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Diana on 29.06.2017.
 */
public class News {
    private int id;
    private String title;
    private String description;
    private Date date;
    private String[] keywords;
    private boolean visible;

    public static Comparator<News> dateComparator = new Comparator<News>() {
        @Override
        public int compare(News n1, News n2) {
            // latest news first
            return -(n1.getDate().compareTo(n2.getDate()));
        }
    };

    public static Comparator<News> keysComparator = new Comparator<News>() {
        @Override
        public int compare(News n1, News n2) {
            // in alphabetical order
            String n1FirstKey = (n1.getKeywords().length == 0) ? "" : n1.getKeywords()[0];
            String n2FirstKey = (n2.getKeywords().length == 0) ? "" : n2.getKeywords()[0];
            return n1FirstKey.compareTo(n2FirstKey);
        }
    };

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String[] getKeywords() {
        Arrays.sort(keywords);
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
