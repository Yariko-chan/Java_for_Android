package Lesson12;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Diana on 19.06.2017.
 */
public class XmlParsing extends DefaultHandler{
    public static final String FILE_NAME = "test.xml";

    public static final String ROOT= "root";
    public static final String PEOPLE= "people";
    public static final String ELEMENT= "element";
    public static final String AGE= "age";
    public static final String ID= "id";
    public static final String IS_DEGREE= "isDegree";
    public static final String NAME= "name";
    public static final String SURNAME= "surname";

    private String currentElement = "";
    private Human currentHuman;

    private ArrayList<Human> humansList;

    public static void main(String[] args) {
        try {

            XMLReader xr = XMLReaderFactory.createXMLReader();
            XmlParsing handler = new XmlParsing();
            xr.setContentHandler(handler);
            xr.setErrorHandler(handler);

            FileReader r = new FileReader(FILE_NAME);
            xr.parse(new InputSource(r));

            for (Human h:handler.getHumansList()) {
                System.out.println(h.toString());
            }
        } catch (SAXException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public XmlParsing() {
        super();
    }

    public ArrayList<Human> getHumansList() {
        return humansList;
    }


    /**
     * document start-end
     */
    public void startDocument ()
    {
        // on document start
        // create vars here
        System.out.println("Start document");
        humansList = new ArrayList<>();
    }

    public void endDocument ()
    {
        // on document end in any case (even errors)
        System.out.println("End document");
    }


    /**
     * element start-end
     */
    public void startElement (String uri, String name,
                              String qName, Attributes atts)
    {
        currentElement = qName;
        if (currentElement.equals(ELEMENT)) {
            currentHuman = new Human();
        }
    }

    public void endElement (String uri, String name, String qName)
    {

        if (qName.equals(ELEMENT)) {
            humansList.add(currentHuman);
        }
        currentElement = "";
    }

    public void characters (char ch[], int start, int length)
    {
        switch(currentElement) {
            case ROOT: {
                break;
            }
            case PEOPLE: {
                break;
            }
            case ELEMENT: {
                break;
            }
            case AGE: {
                String sAge = new String(ch, start, length);
                currentHuman.setAge(new Integer(sAge));
                break;
            }
            case ID: {
                String sId = new String(ch, start, length);
                currentHuman.setId(new Integer(sId));
                break;
            }
            case IS_DEGREE: {
                currentHuman.setDegree(new Boolean(new String(ch, start, length)));
                break;
            }
            case NAME: {
                if (null != currentHuman) {
                    currentHuman.setName(new String(ch, start, length));
                }
                break;
            }
            case SURNAME: {
                currentHuman.setSurname(new String(ch, start, length));
                break;
            }
        }
    }
}
