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
        String fileName = Helper.getStringFromUser("File name: ");
        this.people.clear();
        this.people.addAll(PeopleFactory.loadFromFile(fileName));

        return MenuItemReturnValue.CONTINUE;
    }
}
