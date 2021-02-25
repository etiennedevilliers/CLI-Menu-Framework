package business.logic;

import data.layer.MealItem;
import data.layer.SetMenu;
import data.layer.SetMenuCollection;
import implementation.layer.MenuItem;

public class ViewSetMenus extends MenuItem {
    private SetMenuCollection setMenuCollection;

    public ViewSetMenus(SetMenuCollection setMenuCollection){
        super("View Set Menus");
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


        return MenuItemReturnValue.CONTINUE;
    }
}


