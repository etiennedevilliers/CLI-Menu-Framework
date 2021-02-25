package data.generalClasses;

public class AdultMeal extends MealItem {
    public AdultMeal(int ID, String ItemName, String Description, float PricePerUnit) {
        super(ID, ItemName, Description, PricePerUnit);
    }  
    
    public AdultMeal() {}

    public static String typeString = "ADULT";
    @Override
    public String getTypeString() {
        return typeString;
    }
}
