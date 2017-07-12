package data.entities;

import utils.Period;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by Diana on 29.06.2017.
 */
public class News {
    private int id;
    private String title = "";
    private String description = "";
    private Date date;
    private String[] keywords = {};
    private boolean visible;

    public static Comparator<News> dateComparator = new Comparator<News>() {
        @Override
        public int compare(News n1, News n2) {
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

    // in title, description or keys
    public static void filter(ArrayList<News> result, String query) {
        // create regular expression from query
        // to find all words with 0..any count of symbols
        // before, after and between them
        String[] words = query.split(" ");
        String anySymbols = "(.|\n)*";
        String caseInsensive = "(?i)";
        StringBuilder builder =  new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            builder.append("(").append(anySymbols).append("").append(caseInsensive).append(words[i]).append(anySymbols).append(")");
            builder.append("||");
        }
        // append last word without ||
        builder.append("(").append(anySymbols).append(caseInsensive).append(words[words.length - 1]).append(anySymbols).append(")");
        Pattern pattern = Pattern.compile(builder.toString());

        // remove News from list if
        // it's description, title and keys doesn't contain query
        result.removeIf(n -> // predicate
                !(
                        pattern.matcher(n.getTitle()).matches()
                                || pattern.matcher(n.getDescription()).matches()
                                || pattern.matcher(Arrays.toString(n.getKeywords())).matches() // convert String[] keys to one String
                )
        );
        result.trimToSize();
    }

    // delete all News,
    // which isn't inside period
    public static void filter(ArrayList<News> result, Period period) {
        result.removeIf(n -> // predicate
                (
                        !period.isDateInside(n.getDate())
                )
        );
        result.trimToSize();
    }
}
