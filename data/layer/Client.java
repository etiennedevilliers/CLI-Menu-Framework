package data.layer;

/**
 * Client Object
 */
public class Client {
    public int ID;
    String name;
    String surname;
    String cellNo;
    String email;

    public Client(int iD, String name, String surname, String cellNo, String email) {
        ID = iD;
        this.name = name;
        this.surname = surname;
        this.cellNo = cellNo;
        this.email = email;
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
        this.cellNo = items[3];
        this.email = items[4];
    }

    /**
     * Construct comma delimited string from object data
     * @return comma delimited string
     */
    public String toLine() {
        return String.format("%s,%s,%s,%s,%s", ID, name, surname,cellNo,email);
    }

    @Override
    public String toString() {
        return String.format("%s. %s %s,%s,%s", ID, name, surname,cellNo,email);
    }

    
}
