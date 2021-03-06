package business.logic;

import business.logic.AddBooking.BookingStatus;
import data.layer.Booking;
import implementation.layer.*;

public class MakePayment extends MenuItem {
    private Booking booking;
    public MakePayment(Booking booking) {
        super(String.format("Make payment for %s %s", booking.chosenEvent, booking.chosenSetMenu));
        this.booking = booking;
    }

    @Override
    public MenuItemReturnValue selected() {
        if (booking.status == BookingStatus.Confirmed) {
            System.out.println("This booking has already been confirmed and payed for");
            return MenuItemReturnValue.BACK;
        }

        float cost = booking.chosenSetMenu.calculateCost(
            booking.numberOfAdults,
            booking.numberOfKids
        );

        Menu menu;

        if (booking.numberOfAdults + booking.numberOfKids >= 40) {
            menu = new Menu(String.format("Total cost is %s, 15%% discount applied", cost));
        } else {
            menu = new Menu(String.format("Total cost is %s, 15%% discount not applied", cost));
        }

        menu.add(new Confirm(booking));
        menu.add(new ReturnItem());

        menu.present();
        
        return MenuItemReturnValue.CONTINUE;
    }

    class Confirm extends MenuItem {
        private Booking booking;

        public Confirm(Booking booking) {
            super("Confirm");
            this.booking = booking;
        }

        @Override
        public MenuItemReturnValue selected() {
            booking.status = BookingStatus.Confirmed;
            System.out.println("Payment recieved and booking confirmed!");
            return MenuItemReturnValue.BACK;
        }
    }
    
}
