package data.layer;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class SetMenu extends ArrayList<MealItem> {
    private static final long serialVersionUID = 1L;

    int ID;
    public String name;

    public SetMenu(String line, MealCollection mc) { //line.split(",")
        List<String> items = Arrays.asList(line.split(","));
        
        Iterator<String> ii = items.iterator();


        this.ID = Integer.parseInt(ii.next());
        this.name = ii.next();
        
        while (ii.hasNext()) {
            this.add(mc.getMealItemFromID(Integer.parseInt(ii.next())));
        }
    }

    public SetMenu(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public float calculateCost(int numberOfAdults, int numberOfKids) {
        float total = 0;
        int peopleAmount = numberOfAdults + numberOfKids;

        for (MealItem mealItem : this) {
            if (mealItem.getClass() == AdultMeal.class) {
                total += mealItem.pricePerUnit * numberOfAdults;
            } else if (mealItem.getClass() == KiddiesMeal.class) {
                total += mealItem.pricePerUnit * numberOfKids;
            } else {
                total += mealItem.pricePerUnit * (numberOfAdults + numberOfKids);
            }
        }
        if (peopleAmount >= 40) {
            return total * 0.85f;
        } else {
            return total;
        }
        
    }

    public String toLine() {
        String buffer = String.format("%s,%s", ID, name);
        
        for (MealItem mealItem : this) {
            buffer = String.format("%s,%s", buffer, mealItem.ID);
        };
        
        return buffer;
    }

    @Override
    public String toString(){
        return String.format("%s. %s", ID, name);

    }



    
}
