package AppFunctions;

import DataLayer.PeopleFactory;
import DataLayer.Person;
import MenuFramework.MenuItem;

import java.util.List;

public class LoadFromFile extends MenuItem{
    private List<Person> people;
    
    public LoadFromFile(List<Person> people) {
        super("Load from file");
        this.people = people;
    }

    @Override
    public MenuItemReturnValue selected() {
        String fileName = Helper.getStringFromUser("File name (people.csv): ");
        this.people.clear();

        if (fileName.length() >= 0) {
            this.people.addAll(PeopleFactory.loadFromFile(fileName));
        } else {
            this.people.addAll(PeopleFactory.loadFromFile("people.csv"));
        }
        

        return MenuItemReturnValue.CONTINUE;
    }
}
