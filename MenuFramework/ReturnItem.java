package MenuFramework;

public class ReturnItem extends MenuItem {
    public ReturnItem () {
        super("Back");
    }

    @Override
    public MenuItemReturnValue selected() {
        return MenuItemReturnValue.EXIT;
    }
}
