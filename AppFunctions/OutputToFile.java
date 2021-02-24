package AppFunctions;

import java.util.List;

import DataLayer.Person;
import MenuFramework.MenuItem;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

public class OutputToFile extends MenuItem {
    private List<Person> people;

    public OutputToFile(List<Person> people) {
        super("Output to File");
        this.people = people;
    }

    @Override
    public MenuItemReturnValue selected() {
        String fileName = Helper.getStringFromUser("File name: ");

        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            
                FileWriter myWriter = new FileWriter(fileName);
                
                for (Person person : people) {
                    myWriter.write(String.format("%s\n", person.toLine()));
                }

                myWriter.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return MenuItemReturnValue.CONTINUE;
    }
}
