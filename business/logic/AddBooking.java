package business.logic;

import business.extra.Helper;
import data.layer.*;
import implementation.layer.MenuItem;
import implementation.layer.MenuItem.MenuItemReturnValue;

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

    public AddBooking (BookingCollection bookingCollection) {
        super("Add Booking");
        this.bookingCollection = bookingCollection;
    }
    
    @Override
    public MenuItemReturnValue selected() {
        int newID = bookingCollection.getUniqueID();
        
        EventType event = Helper.getEventFromUser("Choose an Event: ");
        SetMenu setMenu = ;
        String deco = Helper.getStringFromUser("Specify all Decorations: ");

        this.bookingCollection.add(new Booking(newID, event, setMenu, deco));
        BookingCollectionFactory.outputToFile(bookingCollection);

        return MenuItemReturnValue.CONTINUE;
    }
}
