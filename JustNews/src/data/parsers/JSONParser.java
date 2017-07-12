package data.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.entities.Root;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Diana on 29.06.2017.
 */
public class JSONParser extends Parser {
    @Override
    public data.entities.Root parse(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // parses string in JSON file to Date field in Entity class
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        mapper.setDateFormat(df);

        File file = new File(fileName);
        Root root = mapper.readValue(file, Root.class);
        int a = 5;
        return root;
    }
}
