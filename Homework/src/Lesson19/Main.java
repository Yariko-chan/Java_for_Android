package Lesson19;

/**
 * Created by Diana on 03.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        Doctor chiefDoctor = new Doctor("Robert  Kelso", "head");

        Hierarchy<Man> clinic = new Hierarchy<>(chiefDoctor);

        String physiciansDep = "Physicians";
        clinic.addDepartment(physiciansDep);
        clinic.addEmployee(new Doctor("John Michael Dorian"), physiciansDep);
        clinic.addEmployee(new Doctor("Elliot Reid"), physiciansDep);
        clinic.addEmployee(new Doctor("Perry Ulysses Cox"), physiciansDep);

        String surgeryDep = "Surgery";
        clinic.addDepartment(surgeryDep);
        clinic.addEmployee(new Doctor("Christopher Turk"), surgeryDep);
        clinic.addEmployee(new Doctor("Todd Quinlan"), surgeryDep);

        String nursesDep = "Nurses";
        clinic.addDepartment(nursesDep);
        clinic.addEmployee(new Doctor("Carla Espinosa"), nursesDep);
        clinic.addEmployee(new Doctor("Laverne Roberts"), nursesDep);

        String stuffDep = "Stuff";
        clinic.addDepartment(stuffDep);
        clinic.addEmployee(new Man("Glenn \"Janitor\" Matthews"), stuffDep);
        clinic.addEmployee(new Man("Theodore \"Ted\" Buckland"), stuffDep);
        clinic.addEmployee(new Man("Jordan Sullivan"), stuffDep);

        System.out.println(clinic.toString());
    }
}
