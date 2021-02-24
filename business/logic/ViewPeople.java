package business.logic;

import java.util.List;

import data.layer.Person;
import MenuFramework.MenuItem;

public class ViewPeople extends MenuItem {
    private List<Person> people;

    public ViewPeople (List<Person> people){
        super("View People");
        this.people = people;
    }

    @Override
    public MenuItemReturnValue selected() {
        System.out.println("People: ");
        for (Person person : people) {
            System.out.println(String.format("\t%s",person));
        }

        return MenuItemReturnValue.CONTINUE;
    }
}
