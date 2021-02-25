package data.layer;

public class DesertMeal extends MealItem {
    public DesertMeal(int ID, String ItemName, String Description, float PricePerUnit) {
        super(ID, ItemName, Description, PricePerUnit);
    }  
    
    public DesertMeal() {}

    public static String typeString = "DESERT";
    @Override
    public String getTypeString() {
        return typeString;
    }
}
