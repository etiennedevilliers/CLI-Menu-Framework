import implementation.layer.*;
import business.logic.*;
import business.logic.AddBooking.BookingStatus;
import business.logic.EditBookingStatus.UpdateBookingStatus;
import data.layer.*;


public class Main {
    public static ClientCollection clientCollection = ClientCollectionFactory.loadFromFile();
    public static MealCollection meals = MealCollectionFactory.loadFromFile();
    public static SetMenuCollection setMenuCollection = SetMenuCollectionFactory.loadFromFile(meals);
    public static BookingCollection bookings = BookingCollectionFactory.loadFromFile(setMenuCollection, clientCollection);

    

    public static void main(String[] args) {
        
        Menu clientMenu = new Menu("Client Stuff");
        clientMenu.add(new AddClient(clientCollection));
        clientMenu.add(new RMenuItem( "Login", () -> { LoginMenu(); }));
        clientMenu.add(new ReturnItem());

        Menu adminMenu = new Menu("Admin Stuff");
        adminMenu.add(new ViewBookings(bookings));
        adminMenu.add(new UpdateBookingStatus(bookings));
        adminMenu.add(new ViewClients(clientCollection));
        adminMenu.add(new AddMeal(meals));
        adminMenu.add(new ViewMeals(meals));
        adminMenu.add(new ViewSetMenus(setMenuCollection));
        adminMenu.add(new CreateSetMenu(setMenuCollection, meals));
        adminMenu.add(new EditSetMenu(setMenuCollection, meals));
        adminMenu.add(new ReturnItem());

        Menu mainMenu = new Menu("Main menu");
        mainMenu.add(new SubMenu(clientMenu));
        mainMenu.add(new SubMenu(adminMenu));
        mainMenu.add(new ExitItem());

        mainMenu.present();
    }

    public static void LoginMenu() {
        Menu menu = new Menu("Select user: ");
        for (Client client : clientCollection) {
            menu.add(new RMenuItem(
                String.format("%s %s", client.name, client.surname),
                () -> { ClientMenu(client); }
            ));
        }
        menu.presentOnce();
    }

    public static void ClientMenu(Client client) {
        Menu menu = new Menu(String.format("Select action %s: ", client.name));

        for (Booking b : bookings.getBookingsForClient(client)) {
            if (b.status == BookingStatus.Unconfirmed) {
                menu.add(new MakePayment(b));
            }
        }

        menu.add(new ViewBookings(bookings.getBookingsForClient(client)));
        menu.add(new AddBooking(bookings, setMenuCollection, client));
        menu.add(new ReturnItem());
        menu.present();

        BookingCollectionFactory.outputToFile(bookings);
    }

}