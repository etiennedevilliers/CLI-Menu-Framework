package business.extra;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import business.logic.AddBooking.EventType;

/**
 * Helper function conatining extra methods
 * used on business.logic
 */
public class Helper {
    /**
     * Helper function to get
     * input from user.
     * 
     * @param  q   (The question that will be asked)
     */
    public static String getStringFromUser(String q) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print(q);
        return sc.nextLine();
    }

    public static Float getFloatFromUser(String q) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print(q);
        return Float.parseFloat(sc.nextLine());
    }

    public static Date getDateFromUser(String q) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                @SuppressWarnings("resource")
                Scanner sc = new Scanner(System.in); 
                System.out.print(q);
                System.out.print("[dd/MM/yyyy]: ");

                String dateString = sc.nextLine();

                return formatter.parse(dateString);
            } catch (Exception e) {
                System.out.println("Invalid format. Try again.");
            }
        }
    }

    @SuppressWarnings({"resource"}) 
    public static EventType getEventFromUser(String q) {
        while(true) {
            
            Scanner sc = new Scanner(System.in);
            System.out.print(q);
    
            int i = 0;
            EventType event[] = EventType.values();
            for(EventType eventItem: event) {            
                System.out.println(i + ": " + eventItem.name());
                i++;
            }
    
            int index = sc.nextInt();
    
            for(EventType eventItem: event) {            
                if(index == eventItem.ordinal()){
                    return eventItem;
                }
            }
        }
    }


    public static int getIntFromUser(String q) {
        while (true) {
            try {
                @SuppressWarnings("resource")
                Scanner sc = new Scanner(System.in); 
                System.out.print(q);
                System.out.print(": ");
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid selection. Try again.");
            }
        }
    }
}
