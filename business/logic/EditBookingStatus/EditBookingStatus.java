package business.logic.EditBookingStatus;

import implementation.layer.Menu;
import implementation.layer.MenuItem;
import implementation.layer.ReturnItem;
import business.logic.AddBooking.BookingStatus;
import data.layer.Booking;



class EditBookingStatus extends MenuItem {

    class SetBookingStatus extends MenuItem {
        private Booking booking;
        private BookingStatus bookingStatus;
        
        public SetBookingStatus(Booking booking, BookingStatus bookingStatus) {
            super(bookingStatus.toString());
            this.booking = booking;
            this.bookingStatus = bookingStatus;
            
        }

        @Override
        public MenuItemReturnValue selected() {
            booking.status = bookingStatus;
            System.out.println(String.format("Booking status for %s set to %s", booking.ID, bookingStatus));
            return MenuItemReturnValue.BACK;
        }

    }

    private Booking booking;
    /**
     * Edit the Booking status of a booking.
     * @param booking
     * @param isClient Clients cannot set status to "Confirmed"
     */
    public EditBookingStatus(Booking booking) {
        super(booking.toString());
        this.booking = booking;
    }

    @Override
    public MenuItemReturnValue selected() {
        Menu menu = new Menu(String.format("Set status of %s %s to: ", booking.ID, booking.chosenEvent));
        menu.add(new SetBookingStatus(booking, BookingStatus.Cancelled));
        menu.add(new SetBookingStatus(booking, BookingStatus.Confirmed));
        menu.add(new SetBookingStatus(booking, BookingStatus.Unconfirmed));
        menu.add(new ReturnItem());
        menu.presentOnce();
        return MenuItemReturnValue.BACK;
    }

}