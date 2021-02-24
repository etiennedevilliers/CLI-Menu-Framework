package business.logic;

import data.layer.*;
import business.extra.*;


import implementation.layer.MenuItem;

/**
 * Business logic for adding users
 */
public class AddPerson extends MenuItem {
    People people;

    public AddPerson (People people) {
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
