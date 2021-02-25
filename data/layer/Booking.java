package data.layer;

import business.logic.AddBooking.*;

public class Booking {

    public int ID;
    EventType chosenEvent;
    public SetMenu chosenSetMenu;
    public String decorations;
    BookingStatus status;

    public Booking(int ID, EventType chosenEvent, SetMenu chosenSetMenu, String decorations){
        this.ID = ID;
        this.chosenEvent = chosenEvent;
        this.chosenSetMenu = chosenSetMenu;
        this.decorations = decorations;
        this.status = BookingStatus.Unconfirmed;
    }

    public Booking(String line, SetMenuCollection setMenuCollection) {
        String[] items = line.split(",");
        this.ID = Integer.parseInt(items[0]);

        EventType event[] = EventType.values();
        for(EventType eventItem: event) {            
            if(Integer.parseInt(items[1]) == eventItem.ordinal()){
                this.chosenEvent = eventItem;
            }
        }
        this.chosenSetMenu = setMenuCollection.getSetMenuFromID(Integer.parseInt(items[2]));
        this.decorations = items[3];

        BookingStatus status[] = BookingStatus.values();
        for(BookingStatus statusItem: status) {            
            if(Integer.parseInt(items[4]) == statusItem.ordinal()){
                this.status = statusItem;
            }
        }
    }

    public String toLine(){
        return String.format("%s,%s,%s,%s,%s", ID, chosenEvent.ordinal(), chosenSetMenu.ID, decorations, status.ordinal());
    }
}