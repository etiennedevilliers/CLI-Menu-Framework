package business.logic;

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
        Cancelled
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

        this.bookingCollection.add(new Booking(newID, event, setMenu, deco, client));
        BookingCollectionFactory.outputToFile(bookingCollection);

        return MenuItemReturnValue.CONTINUE;
    }
}
