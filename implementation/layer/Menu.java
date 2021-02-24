package implementation.layer;
import java.util.ArrayList;
import java.util.Scanner;

import implementation.layer.MenuItem.MenuItemReturnValue;

public class Menu extends ArrayList<MenuItem> {
    private static final long serialVersionUID = 1L;
    
    String title;

    public Menu(String title) {
        this.title = title;
    }

    public void display() {
        System.out.println(this.title);
        int i = 0;
        for (MenuItem menuItem : this) {
            System.out.println(String.format("\t%d. %s", i++, menuItem));
        }
    }

    public void run() {
        int selectedItem = -1;
        do {
            do {
                selectedItem = getUserSelection();
            } while (selectedItem < 0 || selectedItem >= this.size());
                
        } 
        while (this.get(selectedItem).selected() == MenuItemReturnValue.CONTINUE);
    }

    public int getUserSelection() {
        while (true) {
            try {
                @SuppressWarnings("resource")
                Scanner sc = new Scanner(System.in); 
                display();
                System.out.print(": ");
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid selection. Try again.");
            }
            
        }
    }

}
