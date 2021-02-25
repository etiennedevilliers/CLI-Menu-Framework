package business.logic;

import business.extra.Helper;
import data.layer.MealCollection;
import data.layer.MealItem;
import data.layer.SetMenu;
import implementation.layer.MenuItem;

public class AddMealToSetMenu extends MenuItem {
    private SetMenu setMenu;
    private MealCollection mealCollection;

    public AddMealToSetMenu (SetMenu setMenu, MealCollection mealCollection) {
        super("Add Meal to Set Menu");
        this.setMenu = setMenu;
        this.mealCollection = mealCollection;
        
    }

    @Override
    public MenuItemReturnValue selected() {
        int mealID;
        MealItem mealItem = null;
        while (mealItem == null) {
            System.out.println("All meals:");
            for (MealItem mi : mealCollection) {
                System.out.println(String.format("\t%s", mi));
            }
            mealID = Helper.getIntFromUser("Item to add: ");
            mealItem = mealCollection.getMealItemFromID(mealID);
        }

        System.out.println(String.format("Added %s to %s", mealItem, setMenu));
        setMenu.add(mealItem);

        return MenuItemReturnValue.CONTINUE;
    }
    
}
