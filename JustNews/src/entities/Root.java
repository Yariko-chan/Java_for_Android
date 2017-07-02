package entities;

import java.util.ArrayList;

/**
 * Created by Diana on 30.06.2017.
 */
public class Root {
    private String location;
    private String name;
    private ArrayList<News> news;

    public ArrayList<News> getNews() {
        return news;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNews(ArrayList<News> news) {
        this.news = news;
    }
}
