package data.layer;
import java.util.ArrayList;

public class SetMenuCollection extends ArrayList<SetMenu>{
    private static final long serialVersionUID = 1L;

    /**
     * Get a unique id for new SetMenus.
     * @return unique ID
     */
    public int getUniqueID() {
        int high = 0;

        for (SetMenu item : this) {
            if (item.ID > high) 
                high = item.ID;
        };

        return high + 1;
    }

    public SetMenu getSetMenuFromID(int id) {
        for (SetMenu setMenu : this) {
            if (setMenu.ID == id) {
                return setMenu;
            }
        }
        return null;
    }
}
