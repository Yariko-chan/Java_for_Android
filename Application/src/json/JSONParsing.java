package json;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 19.06.2017.
 */
public class JSONParsing {
    public static final String FILE_NAME = "test.json";

    public static void main(String[] args) {
        ///Root root = parseRootJson(FILE_NAME);
        Root root = parseRootGson(FILE_NAME);
        System.out.println(root.toString());
    }

    private static Root parseRootGson(String fileName) {
        Root root = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            Gson gson = new Gson();

            root = gson.fromJson(reader, Root.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return root;
    }

    private static Root parseRootJson(String fileName) {
        Root root = new Root();
        try {
            JSONParser parser = new JSONParser();
            JSONObject rootObj = null;
            rootObj = (JSONObject) parser.parse(new FileReader(fileName));
            String name = (String)rootObj.get("name");
            root.setName(name);

            ArrayList<People> list = new ArrayList<>();
            JSONArray humanJsonArray = (JSONArray) rootObj.get("people");

            for (Object j: humanJsonArray) {
                JSONObject jsonHuman = (JSONObject) j;

                People h = new People();
                h.setName((String) jsonHuman.get("name"));
                h.setSurname((String) jsonHuman.get("surname"));
                h.setDegree((Boolean) jsonHuman.get("isDegree"));
                h.setAge((long)jsonHuman.get("age"));
                h.setId((long)jsonHuman.get("id"));
                list.add(h);
            }

            root.setPeople(list);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return root;
    }

    private static class Root {
        private String name;
        private ArrayList<People> people;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<People> getPeople() {
            return people;
        }

        public void setPeople(ArrayList<People> people) {
            this.people = people;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder(name);
            builder.append("\n");
            for (People h: people) {

                builder.append(h.toString() + "\n");
            }
            return builder.toString();
        }
    }
}
