package business.logic;

import implementation.layer.FinishItem;
import implementation.layer.Menu;
import implementation.layer.MenuItem;
import business.extra.Helper;
import data.layer.MealItem;
import data.layer.SetMenu;
import data.layer.SetMenuCollection;
import data.layer.SetMenuCollectionFactory;
import data.layer.MealCollection;


public class CreateSetMenu extends MenuItem{
    private SetMenuCollection setMenuCollection;
    private MealCollection mealCollection;

    public CreateSetMenu(SetMenuCollection setMenuCollection, MealCollection mealCollection) {
        super("Create set Menu");
        this.setMenuCollection = setMenuCollection;
        this.mealCollection = mealCollection;
    }
    

    @Override
    public MenuItemReturnValue selected() {
        int ID = setMenuCollection.getUniqueID();
        String name = Helper.getStringFromUser("Enter New Set Menu Name:");

        SetMenu setMenu = new SetMenu(ID,name);

        Menu menu = new Menu(String.format("%s selected", setMenu));

        menu.add(new AddMealToSetMenu(setMenu, mealCollection));
        menu.add(new RemoveMealFromSetMenu(setMenu, mealCollection));
        menu.add(new FinishItem());

        menu.present();
        
        setMenuCollection.add(setMenu);
        SetMenuCollectionFactory.outputToFile(setMenuCollection);
        return MenuItemReturnValue.CONTINUE;
    }
}
