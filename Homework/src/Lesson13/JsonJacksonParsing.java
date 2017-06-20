package Lesson13;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Diana on 20.06.2017.
 */
public class JsonJacksonParsing {
    public static final String FILE_NAME = "test.json";
    public static final String FILE_COPY_NAME = "test_copy.json";

    public static void main(String[] args) {
        try {
            // json file parsing
            ObjectMapper mapper = new ObjectMapper();
            Root root = mapper.readValue(new File(FILE_NAME), Root.class);
            System.out.println(root.toString());

            // json file creating
            mapper.writeValue(new File(FILE_COPY_NAME), root);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
