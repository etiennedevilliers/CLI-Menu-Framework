package AppFunctions;

import java.util.List;

import AppObject.*;


import MenuFramework.MenuItem;

public class AddPerson extends MenuItem {
    List<Person> people;

    public AddPerson (List<Person> people) {
        super("Add Person");
        this.people = people;
    }
    
    @Override
    public MenuItemReturnValue selected() {
        String name = Helper.getStringFromUser("Name: ");
        String surname = Helper.getStringFromUser("Surname: ");
        
        this.people.add(new Person(name, surname));

        return MenuItemReturnValue.CONTINUE;
    }
}
