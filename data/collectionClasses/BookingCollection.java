package data.collectionClasses;

import java.util.ArrayList;

import data.generalClasses.Booking;

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
}
