package data.layer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class SetMenuCollectionFactory {

    public static String defaultFile = "setMenu.csv";
    /**
     * Loads setMenu from specified file
     * @param fileName specified file name
     * @param mc mealCollection file; needed to load relevant meals
     * @return SetMenu object containing data from file
     */
    public static SetMenuCollection loadFromFile(String fileName, MealCollection mc) {
        SetMenuCollection setMenuCollection = new SetMenuCollection();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.length() > 1) {
                    setMenuCollection.add(new SetMenu(data, mc));
                } 
            }

            System.out.println("SetMenus loaded");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return setMenuCollection;
    }

    /**
     * Loads People from defaultFile
     * @return People object containing data from file
     */
    public static SetMenuCollection loadFromFile(MealCollection mc) {
        return loadFromFile(defaultFile, mc);
    }

    /**
     * Output data in people to specified file name
     * @param fileName file name
     * @param clientCollection
     */
    public static void outputToFile(String fileName, SetMenuCollection setMenuCollection) {
        try (FileWriter myWriter = new FileWriter(fileName)) {
            File myObj = new File(fileName);
            if (myObj.canWrite()) {                
                for (SetMenu setMenu : setMenuCollection) {
                    myWriter.write(String.format("%s%n", setMenu.toLine()));
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
    public static void outputToFile(SetMenuCollection setMenuCollection) {
        outputToFile(defaultFile, setMenuCollection);
    }
    
}
