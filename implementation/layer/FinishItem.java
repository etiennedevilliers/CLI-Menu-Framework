package implementation.layer;

/**
 * A simple Back item for menus
 */
public class FinishItem extends MenuItem {
    public FinishItem () {
        super("Finish");
    }

    @Override
    public MenuItemReturnValue selected() {
        return MenuItemReturnValue.BACK;
    }
}
