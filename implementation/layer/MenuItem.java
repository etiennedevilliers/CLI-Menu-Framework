package implementation.layer;;

/**
 * An Abstarct MenuItem. 
 */
public abstract class MenuItem {
    public enum MenuItemReturnValue {
        EXIT,
        CONTINUE,
        BACK
    }
    String title;

    protected MenuItem(String title) {
        this.title = title;
    }

    public String toString() {
        return this.title;
    }

    /**
     * Code that will run when user selects this menu item
     * @return MenuItemReturnValue
     */
    public abstract MenuItemReturnValue selected();
} 
