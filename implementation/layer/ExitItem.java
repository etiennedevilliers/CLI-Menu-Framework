package implementation.layer;

/**
 * An Exit Menu item that will stop the program when selected
 */
public class ExitItem extends MenuItem {
    public ExitItem () {
        super("Exit");
    }

    @Override
    public MenuItemReturnValue selected() {
        System.exit(0);
        return MenuItemReturnValue.EXIT;
    }
}
