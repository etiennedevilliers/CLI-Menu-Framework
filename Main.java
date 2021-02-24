import implementation.layer.*;
import business.logic.*;
import data.layer.*;


public class Main {
    public static void main(String[] args) {
        People people = PeopleFactory.loadFromFile("people.csv");
        MealCollection meals = MealCollectionFactory.loadFromFile("meals.csv");

        Menu fileMenu = new Menu("File Handling Stuff");
        fileMenu.add(new OutputToFile(people));
        fileMenu.add(new LoadFromFile(people));
        fileMenu.add(new ReturnItem());

        Menu mainMenu = new Menu("Main menu");
        mainMenu.add(new AddPerson(people));
        mainMenu.add(new ViewPeople(people));
        mainMenu.add(new SubMenu(fileMenu));
        mainMenu.add(new AddMeal(meals));
        mainMenu.add(new ExitItem());

        mainMenu.present();
    }
}

