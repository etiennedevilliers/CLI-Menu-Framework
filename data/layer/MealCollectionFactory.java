package data.layer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class MealCollectionFactory {    
    public static MealCollection loadFromFile(String fileName) {
        MealCollection meals = new MealCollection();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.length() > 1) {
                    meals.add(new MealItem(data));
                } 
            }

            System.out.println("Meals loaded");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return meals;
    }

    public static void outputToFile(String fileName, MealCollection meals) {
        try (FileWriter myWriter = new FileWriter(fileName)) {
            File myObj = new File(fileName);
            if (myObj.canWrite()) {                
                for (MealItem meal : meals) {
                    myWriter.write(String.format("%s%n", meal.toLine()));
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
