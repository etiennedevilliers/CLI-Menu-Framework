package data.layer;

/**
 * Client Object
 */
public class Client {
    public int ID;
    String name;
    String surname;

    public Client(int ID, String name, String surname) {
        this.ID = ID;
        this.name = name; 
        this.surname = surname;
    }
    /**
     * Constuct Client object from comma delimited string
     * @param line comma delimited String
     */
    public Client(String line) {
        String[] items = line.split(",");
        this.ID = Integer.parseInt(items[0]);
        this.name = items[1]; 
        this.surname = items[2];
    }

    /**
     * Construct comma delimited string from object data
     * @return comma delimited string
     */
    public String toLine() {
        return String.format("%s,%s,%s", ID, name, surname);
    }

    @Override
    public String toString() {
        return String.format("%s. %s %s", ID, name, surname);
    }
}
