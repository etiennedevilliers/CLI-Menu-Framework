package implementation.layer;

public class SubMenu extends MenuItem {
    private Menu menu;

    public SubMenu(Menu menu) {
        super(menu.title);
        this.menu = menu;
    }

    @Override
    public MenuItemReturnValue selected() {
        menu.run();
        
        return MenuItemReturnValue.CONTINUE;
    }
}
