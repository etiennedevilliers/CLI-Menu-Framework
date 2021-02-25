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

    public MealItem getMealItemFromID(int id) {
        for (MealItem item :this) {
            if (item.ID == id )
            return item;
        }

        return null;
    }

    /**
     * Returns a list of matching MealItems
     * Example: allAdultMeals = this.getAllMatchingMealItems(AdultMeal.typeString);
     * 
     * @param typeString the typeString of the mea;
     * @return 
     */
    public ArrayList<MealItem> getAllMatchingMealItems(String typeString) {
        ArrayList<MealItem> mealItems = new ArrayList<MealItem>();

        for (MealItem mealItem : this) {
            if (mealItem.getTypeString().equals(typeString)) {
                mealItems.add(mealItem);
            }
        }

        return mealItems;
    }
}
