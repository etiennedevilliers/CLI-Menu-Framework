package business.logic;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import business.logic.AddBooking.BookingStatus;
import data.layer.Booking;
import implementation.layer.*;
import business.extra.*;

public class MakePayment extends MenuItem {
    private Booking booking;
    public MakePayment(Booking booking) {
        super(String.format("Make payment for %s %s", booking.chosenEvent, booking.chosenSetMenu));
        this.booking = booking;
    }

    @Override
    public MenuItemReturnValue selected() {
        Date today = java.util.Calendar.getInstance().getTime();
        long daysBetween = Helper.getDateDiff(today, booking.date, TimeUnit.DAYS);

        if (daysBetween < 15) {
            System.out.println("Unfortunatly this bookig cannot be confirmed because it is <15 days from now.");
            return MenuItemReturnValue.CONTINUE;
        }

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
            booking.status = BookingStatus.PayedFor;
            System.out.println("Payment Confirm.");
            return MenuItemReturnValue.BACK;
        }
    }
    
}
