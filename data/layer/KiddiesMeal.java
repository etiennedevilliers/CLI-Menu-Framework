package data.layer;

public class KiddiesMeal extends MealItem {
    public KiddiesMeal(int ID, String ItemName, String Description, float PricePerUnit) {
        super(ID, ItemName, Description, PricePerUnit);
    }  
    
    public KiddiesMeal() {}

    public static String typeString = "KIDDIES";
    @Override
    public String getTypeString() {
        return typeString;
    }
}
