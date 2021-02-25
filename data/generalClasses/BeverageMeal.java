package data.generalClasses;

public class BeverageMeal extends MealItem {
    public BeverageMeal(int ID, String ItemName, String Description, float PricePerUnit) {
        super(ID, ItemName, Description, PricePerUnit);
    }  
    
    public BeverageMeal() {}

    public static String typeString = "BEVERAGE";
    @Override
    public String getTypeString() {
        return typeString;
    }
}
