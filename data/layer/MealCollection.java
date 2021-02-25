package data.layer;

import java.util.ArrayList;

public class MealCollection extends ArrayList<MealItem> {
    private static final long serialVersionUID = 1L;

    /**
     * Get a unique id for new meals.
     * @return unique ID
     */
    public int getUniqueID() {
        int high = 0;

        for (MealItem item : this) {
            if (item.ID > high) 
                high = item.ID;
        };

        return high + 1;
    }
}
