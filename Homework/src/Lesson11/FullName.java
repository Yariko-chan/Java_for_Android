package Lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Diana on 15.06.2017.
 */
public class FullName {
    private String firstName;
    private String secondName;
    private String patronymic;

    public static void main(String[] args) {
        ArrayList<FullName> man = new ArrayList<>();
        man.add(new FullName("Alexandr", "Macedonskiy", "Argeadovich"));
        man.add(new FullName("Kim", "Chen", "Ir"));
        man.add(new FullName("Napoleon", "Bonapart", "Carlovich"));

        ArrayList<FullName> woman = new ArrayList<>();
        woman.add(new FullName("Maria", "Skłodowska", "Curie"));
        woman.add(new FullName("Jeanne", "Antoinette", "Poisson"));
        woman.add(new FullName("Valentina", "Tereshkova", "Vladimirovna"));

        HashMap<String, ArrayList> map = new HashMap<>();
        map.put("man", man);
        map.put("woman", woman);

        System.out.println("Enter 0 to get man full name or 1 to get woman full name:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 0) {
            Random r = new Random();
            int index = r.nextInt(man.size() - 1);
            System.out.println(map.get("man").get(index).toString());
        } else {
            Random r = new Random();
            int index = r.nextInt(woman.size() - 1);
            System.out.println(map.get("woman").get(index).toString());
        }
    }

    public FullName(String firstName, String secondName, String patronymic) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
