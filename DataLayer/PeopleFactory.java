package DataLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PeopleFactory {
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
}
