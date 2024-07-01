package finalexam.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaperFactory {
    private List<Person> staff = new ArrayList<>();

    public void addPerson(Person p) {
        staff.add(p);
    }

    public boolean deletePerson(Person p) {
        return staff.remove(p);
    }

    public List<Person> getStaff() {
        return new ArrayList<>(staff);
    }

    public void saveStaffToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(staff);
        }
    }

    public void loadStaffFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            staff = (List<Person>) ois.readObject();
        }
    }
}
