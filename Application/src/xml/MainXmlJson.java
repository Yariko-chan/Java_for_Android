package xml;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 16.06.2017.
 */
public class MainXmlJson {
    public static final String FILE_URL = "C:\\Users\\user\\g.diana\\test.xml";

    public static void main(String[] args) {
        // DOMParser;
        // SAXParser; для более больших файлов

        DOMParser parser = new DOMParser();
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc  = db.parse(FILE_URL);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element root = doc.getDocumentElement();
        System.out.println(root.getTagName());

        NodeList nameNodeList = root.getElementsByTagName("name");
        Node nodeName = nameNodeList.item(0);
        System.out.println(nodeName.getNodeName());

        String name = nodeName.getFirstChild().getNodeValue();
        System.out.println(name);

    }

    private class Root {
        private String name;
        private ArrayList<Human> people;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<Human> getPeople() {
            return people;
        }

        public void setPeople(ArrayList<Human> people) {
            this.people = people;
        }
    }

    private class Human {
        private int age;
        private int id;
        private boolean isDegree;
        private String name;
        private String surname;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isDegree() {
            return isDegree;
        }

        public void setDegree(boolean degree) {
            isDegree = degree;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }
    }
}
