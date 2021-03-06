package business.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import business.extra.*;
import data.layer.Booking;
import data.layer.BookingCollection;
import data.layer.BookingCollectionFactory;
import data.layer.SetMenu;
import data.layer.SetMenuCollection;
import implementation.layer.Menu;
import implementation.layer.MenuItem;
import implementation.layer.RMenuItem;
import implementation.layer.ReturnItem;

public class UpdateBooking extends MenuItem {
    Booking booking;
    SetMenuCollection setMenuCollection;
    BookingCollection bookingCollection;

    public UpdateBooking(Booking booking, SetMenuCollection setMenuCollection, BookingCollection bookingCollection) {
        super(String.format("Update booking info for %s %s", booking.chosenEvent, booking.chosenSetMenu));
        this.booking = booking;
        this.bookingCollection = bookingCollection;
    }   

    @Override
    public MenuItemReturnValue selected() {
        Menu menu = new Menu("Select property to edit: ");

        menu.presentDynamic(() -> {
            List<MenuItem> menuItems = new ArrayList<MenuItem>();

            menuItems.add(new RMenuItem(String.format("Chosen event [%s]", booking.chosenEvent), () -> {
                booking.chosenEvent = Helper.getEventFromUser("Choose an Event: ");;
            }));

            menuItems.add(new RMenuItem(String.format("Set menu [%s]", booking.chosenSetMenu), () -> {
                booking.chosenSetMenu = getSetMenu();
            }));

            menuItems.add(new RMenuItem(String.format("Decorations [%s]", booking.decorations), () -> {
                booking.decorations = Helper.getStringFromUser("Specify all Decorations: ");
            }));

            menuItems.add(new RMenuItem(String.format("Adults [%s]", booking.numberOfAdults), () -> {
                booking.numberOfAdults = Helper.getIntFromUser("Number of Adults: ");
            }));

            menuItems.add(new RMenuItem(String.format("Kids [%s]", booking.numberOfKids), () -> {
                booking.numberOfKids = Helper.getIntFromUser("Number of Kids: ");
            }));

            menuItems.add(new RMenuItem(String.format("Venue [%s]", booking.venue), () -> {
                booking.venue = Helper.getStringFromUser("Please Enter the venue for the event: ");
            }));

            menuItems.add(new RMenuItem(String.format("Date [%s]", booking.date), () -> {
                
                Date date;
                Boolean dateOK;
        
                do {
                    dateOK = true;
                    date = Helper.getDateFromUser("Event date: ");
        
                    for (Booking b : bookingCollection) {
                        if (b.date.equals(date)) {
                            dateOK = false;
                            System.out.println("This date has been taken");
                        }
                    }
        
                } while (!dateOK);
        

                booking.date = date;
            }));

            menuItems.add(new ReturnItem());


            return menuItems;
        });

        BookingCollectionFactory.outputToFile(bookingCollection);

        return MenuItemReturnValue.CONTINUE;
    }

    private SetMenu getSetMenu() {
        SetMenu setMenu;
        int id = 0;
        do {
            System.out.println("Select a Set Menu: ");
            for (SetMenu sm : setMenuCollection) {
                System.out.println(String.format("\t%s", sm));
            }

            id = Helper.getIntFromUser("Set Menu ID: ");
            setMenu = setMenuCollection.getSetMenuFromID(id);
        } while (setMenu == null);

        return setMenu;
    }
    
}
