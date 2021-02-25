package data.factoryClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import data.generalClasses.*;
import data.collectionClasses.*;
import java.io.IOException;


/**
 * PeopleFactory loads/saves People to and from files
 */
public class ClientCollectionFactory {
    public static String defaultFile = "clients.csv";
    /**
     * Loads People from specified file
     * @param fileName specified file name
     * @return People object containing data from file
     */
    public static ClientCollection loadFromFile(String fileName) {
        ClientCollection clientCollection = new ClientCollection();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.length() > 1) {
                    clientCollection.add(new Client(data));
                } 
            }

            System.out.println("People loaded");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return clientCollection;
    }

    /**
     * Loads People from defaultFile
     * @return People object containing data from file
     */
    public static ClientCollection loadFromFile() {
        return loadFromFile(defaultFile);
    }

    /**
     * Output data in people to specified file name
     * @param fileName file name
     * @param clientCollection
     */
    public static void outputToFile(String fileName, ClientCollection clientCollection) {
        try (FileWriter myWriter = new FileWriter(fileName)) {
            File myObj = new File(fileName);
            if (myObj.canWrite()) {                
                for (Client person : clientCollection) {
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

    /**
     * Output data in people to defaultFile
     * @param clientCollection
     */
    public static void outputToFile(ClientCollection clientCollection) {
        outputToFile(defaultFile, clientCollection);
    }
}
