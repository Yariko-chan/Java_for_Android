package data.parsers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import data.entities.Root;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Diana on 29.06.2017.
 */
public class XMLParser implements Parser {
    @Override
    public Root parse(String fileName) throws IOException {
        XmlMapper mapper = new XmlMapper();

        // parses string to date field
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        mapper.setDateFormat(df);

        File file = new File(fileName);
        Root root = mapper.readValue(file, Root.class);
        int a = 5;
        return root;
    }
}
