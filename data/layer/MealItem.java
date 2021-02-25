package data.layer;

public class MealItem {
    public int ID;
    public String itemName, description;
    public float pricePerUnit;

    public MealItem(int ID, String itemName, String description, float pricePerUnit){
        this.ID = ID;
        this.itemName = itemName;
        this.description = description;
        this.pricePerUnit = pricePerUnit;        
    }

    public MealItem(String line){
        String[] items = line.split(",");
        ID = Integer.parseInt(items[0]);
        itemName = items[1];
        description = items[2];
        pricePerUnit = Float.parseFloat(items[3]);
    }

    public String toLine(){
        return String.format("%s,%s,%s,%s", ID, itemName, description, pricePerUnit);
    }
}
