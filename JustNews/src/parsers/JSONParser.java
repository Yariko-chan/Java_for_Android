package parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Root;

import java.io.File;
import java.io.IOException;

/**
 * Created by Diana on 29.06.2017.
 */
public class JSONParser implements Parser {
    @Override
    public entities.Root parse(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileName);
        Root root = mapper.readValue(file, Root.class);
        int a = 5;
        return root;
    }
}
