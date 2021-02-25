package business.logic;

import business.extra.Helper;
import data.layer.MealCollection;
import data.layer.MealItem;
import data.layer.SetMenu;
import implementation.layer.MenuItem;


public class RemoveMealFromSetMenu extends MenuItem{
    private SetMenu setMenu;
    private MealCollection mealCollection;

    public RemoveMealFromSetMenu (SetMenu setMenu, MealCollection mealCollection) {
        super("Remove Meal From Set Menu");
        this.setMenu = setMenu;
        this.mealCollection = mealCollection;
    }

    @Override
    public MenuItemReturnValue selected() {
        int mealID;
        MealItem mealItem = null;
        while (mealItem == null) {
            System.out.println(String.format("Meals in %S", setMenu.name));
            for (MealItem mi : setMenu) {
                System.out.println(String.format("\t%s", mi));
            }
            mealID = Helper.getIntFromUser("Item to remove: ");
            mealItem = mealCollection.getMealItemFromID(mealID);
        }

        System.out.println(String.format("Removed %s from %s", mealItem, setMenu));
        setMenu.remove(mealItem);

        return MenuItemReturnValue.CONTINUE;
    }
}
