package data.layer;

public class MealItem {
    public int ID;
    public String itemName, description;
    public float pricePerUnit;

    public static String typeString = "undefined";

    public MealItem(int ID, String itemName, String description, float pricePerUnit){
        this.ID = ID;
        this.itemName = itemName;
        this.description = description;
        this.pricePerUnit = pricePerUnit;        
    }

    public MealItem() {}

    /**
     * Creates the meal item from a comma delimited file
     * Will pick the correct sub class of MealItem (AdutltMeal, Beverage, etc.)
     * @param line
     * @return (AdutltMeal, BeverageMeal, etc.)
     */
    public static MealItem CreateFromData(String line) {
        String[] items = line.split(",");
        MealItem i;

        if (items[4].equals(AdultMeal.typeString)) {
            i = new AdultMeal();
        } else if (items[4].equals(BeverageMeal.typeString)) {
            i = new BeverageMeal();
        } else if (items[4].equals(DesertMeal.typeString)) {
            i = new DesertMeal();
        } else if (items[4].equals(KiddiesMeal.typeString)) {
            i = new KiddiesMeal();
        } else {
            i = new MealItem();
            System.out.println("Undefined meal created: "+ items[4]);
        }
        

        i.ID = Integer.parseInt(items[0]);
        i.itemName = items[1];
        i.description = items[2];
        i.pricePerUnit = Float.parseFloat(items[3]);

        return i;
    }

    public String getTypeString() {
        return typeString;
    }

    public String toLine(){
        return String.format("%s,%s,%s,%s,%s", ID, itemName, description, pricePerUnit,getTypeString());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", ID, itemName, description, pricePerUnit,getTypeString());
    }
}
