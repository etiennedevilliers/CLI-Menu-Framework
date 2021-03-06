package business.logic;

import java.util.ArrayList;
import java.util.List;

import business.logic.AddBooking.BookingStatus;
import data.layer.Booking;
import data.layer.BookingCollection;
import data.layer.BookingCollectionFactory;
import implementation.layer.*;

public class UpdateBookingStatuses extends MenuItem {
    BookingCollection bookingCollection;

    public UpdateBookingStatuses(BookingCollection bookingCollection) {
        super("Update booking statuses");
        this.bookingCollection = bookingCollection;
    }

    @Override
    public MenuItemReturnValue selected() {
        Menu menu = new Menu("Select booking to update: ");

        menu.presentDynamic(() -> {
            BookingCollectionFactory.outputToFile(bookingCollection);
            List<MenuItem> menuItems = new ArrayList<MenuItem>();
            
            for (Booking booking : bookingCollection) {
                menuItems.add(new UpdateBookingStatus(booking));
            }
            menuItems.add(new ReturnItem());

            return menuItems;
        });

        return MenuItemReturnValue.CONTINUE;
    }
    

    private class UpdateBookingStatus extends MenuItem {
        Booking booking;
        protected UpdateBookingStatus(Booking booking) {
            super(booking.toString());
            this.booking = booking;
        }

        @Override
        public MenuItemReturnValue selected() {
            Menu menu = new Menu("Select new status: ");
            menu.add(new RMenuItem("Confirmed", () -> { 
                booking.status = BookingStatus.Confirmed; 
                System.out.println("Client has been notified of status update.");
            }));
            menu.add(new RMenuItem("Canceled", () -> { 
                booking.status = BookingStatus.Cancelled; 
                System.out.println("Client has been notified of status update.");
            }));
            menu.add(new RMenuItem("Payed for", () -> { 
                booking.status = BookingStatus.PayedFor; 
                System.out.println("Client has been notified of status update.");
            }));
            menu.add(new RMenuItem("Unconfirmed", () -> { 
                booking.status = BookingStatus.Unconfirmed; 
                System.out.println("Client has been notified of status update.");
            }));
            menu.add(new ReturnItem());
            menu.present();

            return MenuItemReturnValue.CONTINUE;
        }
        
    }
}
