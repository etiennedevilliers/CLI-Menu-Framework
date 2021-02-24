package business.logic;

import business.extra.*;
import data.layer.PeopleFactory;
import data.layer.People;
import implementation.layer.MenuItem;


/**
 * Business logic for Loading People from file.
 */
public class LoadFromFile extends MenuItem{
    private People people;
    
    public LoadFromFile(People people) {
        super("Load from file");
        this.people = people;
    }

    @Override
    public MenuItemReturnValue selected() {
        String fileName = Helper.getStringFromUser("File name (people.csv): ");
        this.people.clear();

        if (fileName.length() > 0) {
            this.people.addAll(PeopleFactory.loadFromFile(fileName));
        } else {
            this.people.addAll(PeopleFactory.loadFromFile("people.csv"));
        }
        

        return MenuItemReturnValue.CONTINUE;
    }
}
