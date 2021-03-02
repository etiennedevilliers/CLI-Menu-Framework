import implementation.layer.*;
import business.logic.*;
import business.logic.EditBookingStatus.UpdateBookingStatus;
import data.layer.*;


public class Main {
    public static void main(String[] args) {
        ClientCollection people = ClientCollectionFactory.loadFromFile();
        MealCollection meals = MealCollectionFactory.loadFromFile();
        SetMenuCollection setMenuCollection = SetMenuCollectionFactory.loadFromFile(meals);
        BookingCollection bookings = BookingCollectionFactory.loadFromFile(setMenuCollection);

        Menu mainMenu = new Menu("Main menu");
        mainMenu.add(new AddClient(people));
        mainMenu.add(new ViewClients(people));
        mainMenu.add(new AddMeal(meals));
        mainMenu.add(new ViewMeals(meals));
        mainMenu.add(new ViewSetMenus(setMenuCollection));
        mainMenu.add(new CreateSetMenu(setMenuCollection, meals));
        mainMenu.add(new EditSetMenu(setMenuCollection, meals));
        mainMenu.add(new AddBooking(bookings, setMenuCollection));
        mainMenu.add(new ViewBookings(bookings));
        mainMenu.add(new UpdateBookingStatus(bookings));
        mainMenu.add(new ExitItem());


        mainMenu.present();
    }
}