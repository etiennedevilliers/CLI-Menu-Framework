package data.layer;

public class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name; this.surname = surname;
    }

    public Person(String line) {
        String[] items = line.split(",");
        this.name = items[0]; this.surname = items[1];
    }

    public String toLine() {
        return String.format("%s,%s", name, surname);
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, surname);
    }
}
