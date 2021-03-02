package data.layer;

import java.util.ArrayList;

public class BookingCollection extends ArrayList<Booking> {
    private static final long serialVersionUID = 1L;

    public int getUniqueID() {
        int high = 0;

        for (Booking item : this) {
            if (item.ID > high) 
                high = item.ID;
        };

        return high + 1;
    }

    public ArrayList<Booking> getBookingsForClient(Client client) {
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        for (Booking b : this) {
            if (b.client.equals(client)) {
                bookings.add(b);
            }
        }

        return bookings;
    }
}
