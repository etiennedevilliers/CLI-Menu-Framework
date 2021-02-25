import implementation.layer.*;
import business.logic.*;
import data.layer.*;


public class Main {
    public static void main(String[] args) {
        ClientCollection people = ClientCollectionFactory.loadFromFile();
        MealCollection meals = MealCollectionFactory.loadFromFile();
        SetMenuCollection setMenuCollection = SetMenuCollectionFactory.loadFromFile(meals);


        Menu mainMenu = new Menu("Main menu");
        mainMenu.add(new AddClient(people));
        mainMenu.add(new ViewClients(people));
        mainMenu.add(new AddMeal(meals));
        mainMenu.add(new ViewMeals(meals));
        mainMenu.add(new ExitItem());

        mainMenu.present();
    }
}