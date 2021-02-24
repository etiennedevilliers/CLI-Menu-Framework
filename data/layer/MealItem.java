package data.layer;

public class MealItem {
    public int ID, count;
    public String itemName, description;
    public float pricePerUnit;

    public MealItem(String itemName, String description, float pricePerUnit){
        this.itemName = itemName;
        this.description = description;
        this.pricePerUnit = pricePerUnit;        
    }

    public MealItem(String line){
        String[] items = line.split(",");
        itemName = items[0];
        description = items[1];
        pricePerUnit = Float.parseFloat(items[2]);
    }

    public String toLine(){
        return String.format("%s,%s,%s", itemName, description, pricePerUnit);
    }
}
