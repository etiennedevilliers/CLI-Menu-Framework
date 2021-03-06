package business.logic;

import java.util.Date;

import business.extra.Helper;
import data.layer.*;
import implementation.layer.*;

public class AddBooking extends MenuItem{
    public enum EventType{
        Wedding,
        Baptism,
        BarMitzvah,
        SweetSixteen,
        TwentyFirst,
        BabyShower,
        BridalShower,
        BachelorParty,
        KidParty,
        Funeral,
        EngagementParty
    }

    public enum BookingStatus{
        Confirmed, 
        Unconfirmed,
        Cancelled,
        PayedFor
    }
    
    BookingCollection bookingCollection;
    SetMenuCollection setMenuCollection;
    Client client;

    public AddBooking (BookingCollection bookingCollection, SetMenuCollection setMenuCollection, Client client) {
        super("Add Booking");
        this.bookingCollection = bookingCollection;
        this.setMenuCollection = setMenuCollection;
        this.client = client;
    }
    
    @Override
    public MenuItemReturnValue selected() {
        int newID = bookingCollection.getUniqueID();
        int id;
        SetMenu setMenu = null;
        
        EventType event = Helper.getEventFromUser("Choose an Event: ");

        do {
            System.out.println("Select a Set Menu: ");
            for (SetMenu sm : setMenuCollection) {
                System.out.println(String.format("\t%s", sm));
            }

            id = Helper.getIntFromUser("Set Menu ID: ");
            setMenu = setMenuCollection.getSetMenuFromID(id);
        } while (setMenu == null);

        String deco = Helper.getStringFromUser("Specify all Decorations: ");

        int numberOfAdults = Helper.getIntFromUser("Number of Adults: ");
        int numberOfKids = Helper.getIntFromUser("Number of Kids: ");

        String venue = Helper.getStringFromUser("Please Enter the venue for the event: ");

        Date date;
        Boolean dateOK = true;

        do {
            date = Helper.getDateFromUser("Event date: ");

            for (Booking b : bookingCollection) {
                if (b.date.equals(date)) {
                    dateOK = false;
                    System.out.println("This date has been taken");
                }
            }

        } while (!dateOK);

        this.bookingCollection.add(new Booking(newID, event, setMenu, deco, client, numberOfAdults, numberOfKids, date, venue));
        BookingCollectionFactory.outputToFile(bookingCollection);

        return MenuItemReturnValue.CONTINUE;
    }
}
