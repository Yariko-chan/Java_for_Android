package parsers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import entities.Root;

import java.io.File;
import java.io.IOException;

/**
 * Created by Diana on 29.06.2017.
 */
public class XMLParser implements Parser {
    @Override
    public Root parse(String fileName) throws IOException {
        XmlMapper mapper = new XmlMapper();
        File file = new File(fileName);
        Root root = mapper.readValue(file, Root.class);
        int a = 5;
        return root;
    }
}
