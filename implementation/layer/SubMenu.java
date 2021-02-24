package implementation.layer;

/**
 * A MenuItem that will launch a menu when selected. 
 * Title of this menu item matches Menu
 */
public class SubMenu extends MenuItem {
    private Menu menu;

    /**
     * Construct SubMenu
     * @param menu The sub menu
     */
    public SubMenu(Menu menu) {
        super(menu.title);
        this.menu = menu;
    }

    @Override
    public MenuItemReturnValue selected() {
        menu.present();
        return MenuItemReturnValue.CONTINUE;
    }
}
