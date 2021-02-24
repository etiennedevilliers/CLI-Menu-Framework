package implementation.layer;

public class ReturnItem extends MenuItem {
    public ReturnItem () {
        super("Back");
    }

    @Override
    public MenuItemReturnValue selected() {
        return MenuItemReturnValue.BACK;
    }
}
