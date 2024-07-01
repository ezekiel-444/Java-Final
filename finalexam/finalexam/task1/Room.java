package finalexam.task1;

public class Room {
    private String name;
    private double area;
    private int capacity;

    public Room(String name, double area, int capacity) {
        this.name = name;
        this.area = area;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room [name=" + name + ", area=" + area + " sqm, capacity=" + capacity + "]";
    }
}
