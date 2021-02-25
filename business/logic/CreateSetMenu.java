package business.logic;

import implementation.layer.MenuItem;
import business.extra.Helper;
import data.layer.MealItem;
import data.layer.SetMenu;
import data.layer.SetMenuCollection;
import data.layer.SetMenuCollectionFactory;


public class CreateSetMenu extends MenuItem{
    private SetMenuCollection setMenuCollection;

    public CreateSetMenu(SetMenuCollection setMenuCollection){
        super("Create set Menu");
        this.setMenuCollection = setMenuCollection;
    }
    

    @Override
    public MenuItemReturnValue selected() {
        System.out.println("Set Menus: ");
        for (SetMenu setMenu : setMenuCollection) {
            System.out.println(String.format("\t%s",setMenu));
            for (MealItem mealItem : setMenu) {
                System.out.println(String.format("\t\t%s", mealItem));
            }
        }

        int ID = setMenuCollection.getUniqueID();
        String name = Helper.getStringFromUser("Enter New Set Menu Name:");

        SetMenu setMenu = new SetMenu(ID,name);
        
        setMenuCollection.add(setMenu);
        SetMenuCollectionFactory.outputToFile(setMenuCollection);
        return MenuItemReturnValue.CONTINUE;
    }
}
