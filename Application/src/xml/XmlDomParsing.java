package xml;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;

/**
 * Created by user on 16.06.2017.
 */
public class XmlDomParsing {
    public static final String FILE_URL = "test.xml";
    public static final String FILE_COPY_URL = "test_copy.xml";

    public static void main(String[] args) {

        DOMParser parser = new DOMParser();
        Document doc = null;
        try {
            doc = getDocument();
            Root root = parseDocument(doc);
            System.out.println(root.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Document getDocument() throws Exception {
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            doc  = builder.parse(FILE_URL);
        } catch (Exception e) {
            String message = "XML parsing error!";
            throw new Exception(message);
        }
        return doc;
    }

    private static Root parseDocument(Document doc) {
        Root root = new Root();

        Element rootElement = doc.getDocumentElement();

        NodeList nameNodeList = rootElement.getElementsByTagName("name");
        root.setName(nameNodeList.item(0).getFirstChild().getNodeValue());

        NodeList peopleNodeList = rootElement.getElementsByTagName("people").item(0).getChildNodes();
        ArrayList<Human> humanList = new ArrayList<>();

        for (int i = 0; i < peopleNodeList.getLength(); i++) {
            Node node = peopleNodeList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Element peopleElement = (Element) node;
            Human human = new Human();

            Element name = (Element) peopleElement.getElementsByTagName("name").item(0);
            human.setName(name.getFirstChild().getNodeValue());

            Element surname = (Element) peopleElement.getElementsByTagName("surname").item(0);
            human.setSurname(surname.getFirstChild().getNodeValue());

            Element age = (Element) peopleElement.getElementsByTagName("age").item(0);
            human.setAge(Integer.parseInt(age.getFirstChild().getNodeValue()));

            Element id = (Element) peopleElement.getElementsByTagName("id").item(0);
            human.setId(Integer.parseInt(id.getFirstChild().getNodeValue()));

            Element isDegree = (Element) peopleElement.getElementsByTagName("name").item(0);
            human.setDegree(Boolean.parseBoolean(isDegree.getFirstChild().getNodeValue()));

            humanList.add(human);
        }

        root.setPeople(humanList);
        return root;
    }

    private static class Root {
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

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder(name);
            builder.append("\n");
            for (Human h: people) {

                builder.append(h.toString() + "\n");
            }
            return builder.toString();
        }
    }

    private static class Human {
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

        @Override
        public String toString() {
            return "Human{" +
                    "age=" + age +
                    ", id=" + id +
                    ", isDegree=" + isDegree +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }
    }
}
