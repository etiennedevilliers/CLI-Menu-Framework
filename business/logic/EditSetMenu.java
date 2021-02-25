package business.logic;

import business.extra.Helper;
import data.layer.*;
import implementation.layer.Menu;
import implementation.layer.MenuItem;
import implementation.layer.ReturnItem;

public class EditSetMenu extends MenuItem {
    private SetMenuCollection setMenuCollection;
    private MealCollection mealCollection;

    public EditSetMenu(SetMenuCollection setMenuCollection, MealCollection mealCollection) {
        super("Edit Set Menu");
        this.setMenuCollection = setMenuCollection;
        this.mealCollection = mealCollection;
    }

    @Override
    public MenuItemReturnValue selected() {
        int id;
        SetMenu setMenu = null;

        do {
            System.out.println("Select a Set Menu to edit:");
            for (SetMenu sm : setMenuCollection) {
                System.out.println(String.format("\t%s", sm));
            }

            id = Helper.getIntFromUser("Set Menu ID: ");
            setMenu = setMenuCollection.getSetMenuFromID(id);
        } while (setMenu == null);
        
        Menu menu = new Menu(String.format("%s selected", setMenu));

        menu.add(new AddMealToSetMenu(setMenu, mealCollection));
        menu.add(new ReturnItem());

        menu.present();

        return MenuItemReturnValue.CONTINUE;
    }
}
