import java.util.ArrayList;
import java.util.List;

import MenuFramework.*;
import AppFunctions.*;
import DataLayer.*;


public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();

        Menu m = new Menu("Main menu");

        m.add(new AddPerson(people));
        m.add(new ViewPeople(people));
        m.add(new OutputToFile(people));
        m.add(new LoadFromFile(people));


        m.add(new ExitItem());

        m.run();
    }
}

