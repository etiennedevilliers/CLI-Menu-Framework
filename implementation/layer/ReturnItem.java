package implementation.layer;

/**
 * A simple Back item for menus
 */
public class ReturnItem extends MenuItem {
    public ReturnItem () {
        super("Back");
    }

    @Override
    public MenuItemReturnValue selected() {
        return MenuItemReturnValue.BACK;
    }
}
