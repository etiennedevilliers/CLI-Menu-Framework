package data.layer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;


/**
 * PeopleFactory loads/saves People to and from files
 */
public class PeopleFactory {
    /**
     * Loads People from specified file
     * @param fileName specified file name
     * @return People object containing data from file
     */
    public static People loadFromFile(String fileName) {
        People people = new People();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.length() > 1) {
                    people.add(new Person(data));
                } 
            }

            System.out.println("People loaded");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return people;
    }

    /**
     * Output data in people to specified file name
     * @param fileName file name
     * @param people
     */
    public static void outputToFile(String fileName, People people) {
        try (FileWriter myWriter = new FileWriter(fileName)) {
            File myObj = new File(fileName);
            if (myObj.canWrite()) {                
                for (Person person : people) {
                    myWriter.write(String.format("%s%n", person.toLine()));
                }
            } else {
                System.out.println("Can't write to file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
