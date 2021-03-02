package business.logic.EditBookingStatus;

import implementation.layer.Menu;
import implementation.layer.MenuItem;
import implementation.layer.ReturnItem;
import data.layer.BookingCollection;
import data.layer.Booking;

public class UpdateBookingStatus extends MenuItem {
    private BookingCollection bookingCollection;
    private boolean isClient;

    /**
     * Edit the Booking status of a booking.
     * @param bookingCollection
     * @param isClient Clients cannot set status to "Confirmed"
     */
    public UpdateBookingStatus(BookingCollection bookingCollection) {
        super("Confirm/Deny bookings");
        this.bookingCollection = bookingCollection;
    }

    @Override
    public MenuItemReturnValue selected() {
        Menu menu = new Menu("Pick booking to edit");
        for (Booking booking : bookingCollection) {
            menu.add(new EditBookingStatus(booking));
        }
        menu.add(new ReturnItem());
        menu.present();

        return MenuItemReturnValue.CONTINUE;
    }
    
}
