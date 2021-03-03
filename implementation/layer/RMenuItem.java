package implementation.layer;

/**
 * An MenuItem that will execute a Runnable 
 */
public class RMenuItem extends MenuItem {
    private Runnable runnable;
    public RMenuItem(String title, Runnable runnable) {
        super(title);
        this.runnable = runnable;
    }

    @Override
    public MenuItemReturnValue selected() {
        runnable.run();
        return MenuItemReturnValue.CONTINUE;
    }
    
}
