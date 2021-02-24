package MenuFramework;

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
