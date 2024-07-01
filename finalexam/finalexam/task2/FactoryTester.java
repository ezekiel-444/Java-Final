package finalexam.task2;

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

        factory.deletePerson(person1);

        System.out.println("Staff after deleting person1: ");
        for (Person p : factory.getStaff()) {
            System.out.println(p);
        }
    }
}
