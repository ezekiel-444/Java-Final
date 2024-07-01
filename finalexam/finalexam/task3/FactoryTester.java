package finalexam.task3;

import java.io.IOException;

public class FactoryTester {
    public static void main(String[] args) {
        PaperFactory factory = new PaperFactory();

        Person person1 = new Person("Anakin", "Skywalker", "12345");
        Person person2 = new Person("Nina", "Smith", "67890");

        factory.addPerson(person1);
        factory.addPerson(person2);

        System.out.println("Staff after adding persons: ");
        for (Person p : factory.getStaff()) {
            System.out.println(p);
        }

        try {
            factory.saveStaffToFile("staff.dat");

            factory.deletePerson(person1);
            factory.deletePerson(person2);

            System.out.println("Staff after deleting all persons: ");
            for (Person p : factory.getStaff()) {
                System.out.println(p);
            }

            factory.loadStaffFromFile("staff.dat");

            System.out.println("Staff after loading from file: ");
            for (Person p : factory.getStaff()) {
                System.out.println(p);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

