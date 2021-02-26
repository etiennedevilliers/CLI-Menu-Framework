package business.logic;

import data.layer.Booking;
import data.layer.BookingCollection;
import implementation.layer.MenuItem;

public class ViewBookings extends MenuItem {

    private BookingCollection bookingCollection;

    public ViewBookings(BookingCollection bookingCollection){
        super("ViewBookings");
        this.bookingCollection = bookingCollection;
    }
    

    @Override
    public MenuItemReturnValue selected() {
        System.out.println("Bookings: ");
        for (Booking booking : bookingCollection) {
            System.out.println(String.format("\t%s",booking));
        }


        return MenuItemReturnValue.CONTINUE;
    }
    
}
