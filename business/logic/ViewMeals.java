package business.logic;
import data.generalClasses.*;
import data.collectionClasses.*;
import implementation.layer.MenuItem;

/**
 * Business logic for viewing People
 */
public class ViewMeals extends MenuItem {
    private MealCollection meals;

    public ViewMeals (MealCollection meals){
        super("View Meals");
        this.meals = meals;
    }

    @Override
    public MenuItemReturnValue selected() {
        System.out.println("Meals: ");
        for (MealItem meal : meals) {
            System.out.println(String.format("\t%s",meal));
        }

        return MenuItemReturnValue.CONTINUE;
    }
}
