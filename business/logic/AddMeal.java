package business.logic;

import data.layer.*;
import business.extra.*;
import implementation.layer.MenuItem;

public class AddMeal extends MenuItem {
    MealCollection meals;

    public AddMeal (MealCollection meals) {
        super("Add Meal");
        this.meals = meals;
    }
    
    @Override
    public MenuItemReturnValue selected() {
        String name = Helper.getStringFromUser("Meal Name: ");
        String desc = Helper.getStringFromUser("Description: ");
        Float price = Helper.getFloatFromUser("Price Per Unit: ");
        
        this.meals.add(new MealItem(name, desc, price));
        MealCollectionFactory.outputToFile("meals.csv", meals);

        return MenuItemReturnValue.CONTINUE;
    }
}
