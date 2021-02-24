package AppFunctions;
import java.util.Scanner;

public class Helper {
    public static String getStringFromUser(String q) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print(q);
        return sc.nextLine();
    }
}
