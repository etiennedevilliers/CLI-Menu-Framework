package business.logic;

import data.factoryClasses.*;
import data.generalClasses.*;
import data.collectionClasses.*;
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
        int newID = this.meals.getUniqueID();

        System.out.println("Select the meal type: ");
        System.out.println("1. Adult Meal");
        System.out.println("2. Kiddies Meal");
        System.out.println("3. Desert");
        System.out.println("4. Beverage");

        int type = 0;

        while (type < 1 || type > 4) {
            type = Helper.getIntFromUser("meal type(1-4): ");
        }
        
        switch (type) {
            case 1:
                this.meals.add(new AdultMeal(newID, name, desc, price));
                break;
            case 2:
                this.meals.add(new KiddiesMeal(newID, name, desc, price));
                break;
            case 3:
                this.meals.add(new DesertMeal(newID, name, desc, price));
                break;
            case 4:
                this.meals.add(new BeverageMeal(newID, name, desc, price));
                break;
        
            default:
                break;
        }
        
        
        MealCollectionFactory.outputToFile(meals);

        return MenuItemReturnValue.CONTINUE;
    }
}
