package business.logic;

import java.util.ArrayList;

import data.layer.Booking;
import data.layer.BookingCollection;
import implementation.layer.MenuItem;

public class ViewBookings extends MenuItem {

    private ArrayList<Booking> arrayBookings;

    public ViewBookings(BookingCollection bookingCollection){
        super("View Bookings");
        arrayBookings = new ArrayList<Booking>();
        arrayBookings.addAll(bookingCollection);
    }

    public ViewBookings(ArrayList<Booking> bookings) {
        super("View Bookings");
        arrayBookings = bookings;
    }
    

    @Override
    public MenuItemReturnValue selected() {
        System.out.println("Bookings: ");
        for (Booking booking : arrayBookings) {
            System.out.println(String.format("\t%s",booking));
        }


        return MenuItemReturnValue.CONTINUE;
    }
    
}
