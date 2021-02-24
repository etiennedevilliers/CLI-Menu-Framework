package business.extra;
import java.util.Scanner;

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
}
