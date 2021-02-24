package data.layer;

/**
 * Person Object
 */
public class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name; this.surname = surname;
    }
    /**
     * Constuct Person object from comma delimited string
     * @param line comma delimited String
     */
    public Person(String line) {
        String[] items = line.split(",");
        this.name = items[0]; this.surname = items[1];
    }

    /**
     * Construct comma delimited string from object data
     * @return comma delimited string
     */
    public String toLine() {
        return String.format("%s,%s", name, surname);
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, surname);
    }
}
