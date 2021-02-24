import implementation.layer.*;
import business.logic.*;
import data.layer.*;


public class Main {
    public static void main(String[] args) {
        People people = PeopleFactory.loadFromFile("people.csv");

        Menu m = new Menu("Main menu");

        m.add(new AddPerson(people));
        m.add(new ViewPeople(people));
        m.add(new OutputToFile(people));
        m.add(new LoadFromFile(people));


        m.add(new ExitItem());

        m.run();
    }
}

