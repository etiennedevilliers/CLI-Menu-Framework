package AppFunctions;

import AppObject.Person;
import MenuFramework.MenuItem;

import java.util.List;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class LoadFromFile extends MenuItem{
    private List<Person> people;
    
    public LoadFromFile(List<Person> people) {
        super("Load from file");
        this.people = people;
    }

    @Override
    public MenuItemReturnValue selected() {
        String fileName = Helper.getStringFromUser("File name: ");
        this.people.clear();

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.length() > 1) {
                    this.people.add(new Person(data));
                } 
            }

            System.out.println("People loaded");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return MenuItemReturnValue.CONTINUE;
    }
}
