package Lesson4;

import java.util.Scanner;

/**
 * Created by Diana on 01.06.2017.
 */
public class Clinic {

    public static void main(String[] args) {
        int count = 3;
        Patient[] pList = new Patient[count];

        System.out.printf("Enter data for %d patients: \n", count);
        for (int i = 0; i < count; i++) {
            pList[i] = inputPatient();
        }
        printPatientList(pList);

        String choice;
        Scanner sc = new Scanner(System.in);
        do { /* print menu until input is correct (1 or 2) */
            System.out.println("\nSelect a way to find a patient: ");
            System.out.println("1 Find by name ");
            System.out.println("2 Find by age ");
            choice = sc.nextLine();
        } while (!(choice.equals("1") || choice.equals("2")));

        if (choice.equals("1")) {
            findPatientByName(pList);
        } else {
            findPatientByAge(pList);
        }
    }

    private static void findPatientByAge(Patient[] pList) {
        System.out.println("\nFind patient by age");
        System.out.println("Enter age: ");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        for (int i = 0; i < pList.length; i++) {
            if (pList[i].getAge() == key)
                printPatient(pList[i]);
        }
    }

    private static void findPatientByName(Patient[] pList) {
        System.out.println("\nFind patient by name");
        System.out.println("Enter name: ");
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        for (int i = 0; i < pList.length; i++) {
            if (pList[i].getName().contains(key))
                printPatient(pList[i]);
        }

    }

    private static void printPatientList(Patient[] pList) {
        System.out.println("\n      PATIENTS LIST");
        for (int i = 0; i < pList.length; i++) {
            printPatient(pList[i]);
        }
    }

    private static void printPatient(Patient patient) {
        System.out.printf("Patient %15s Age = %3d\n", patient.getName(), patient.getAge());
    }

    private static Patient inputPatient() {
        Patient p = new Patient();
        Scanner sc = new Scanner(System.in);

        System.out.print("Name and Surname: ");
        p.setName(sc.nextLine());

        System.out.print("Age: ");
        p.setAge(sc.nextInt());

        sc = new Scanner(System.in); // without this will read \n instead of new string
        System.out.print("Gender (m/f): ");
        if (sc.nextLine().equals("m"))
            p.setGender(true);
        else
            p.setGender(false);

        System.out.print("Diagnosis: ");
        p.setDiagnosis(sc.nextLine());

        System.out.println();

        return p;
    }
}
