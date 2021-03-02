package business.logic;

import data.layer.Booking;
import implementation.layer.MenuItem;

public class MakePayment extends MenuItem {
    private Booking booking;
    public MakePayment(Booking booking) {
        super("Make payment for %s");
        this.booking = booking;
    }

    @Override
    public MenuItemReturnValue selected() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
