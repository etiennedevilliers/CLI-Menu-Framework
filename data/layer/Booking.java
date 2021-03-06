package data.layer;

import java.text.SimpleDateFormat;
import java.util.Date;

import business.logic.AddBooking.*;

public class Booking {

    public int ID;
    public EventType chosenEvent;
    public SetMenu chosenSetMenu;
    public String decorations;
    public BookingStatus status;
    public Client client;
    public int numberOfAdults;
    public int numberOfKids;
    public String venue;
    public Date date;

    public Booking(int ID, EventType chosenEvent, SetMenu chosenSetMenu, String decorations, Client client, int numberOfAdults, int numberOfKids, Date date, String venue){
        this.ID = ID;
        this.chosenEvent = chosenEvent;
        this.chosenSetMenu = chosenSetMenu;
        this.decorations = decorations;
        this.status = BookingStatus.Unconfirmed;
        this.client = client;
        this.numberOfAdults = numberOfAdults;
        this.numberOfKids = numberOfKids;
        this.date = date;
        this.venue = venue;
    }

    public Booking(String line, SetMenuCollection setMenuCollection, ClientCollection clientCollection) {
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

        this.client = clientCollection.getClientFromID(Integer.parseInt(items[5]));

        this.numberOfAdults = Integer.parseInt(items[6]);
        this.numberOfKids = Integer.parseInt(items[7]);
        try {
            this.date = new SimpleDateFormat("dd/MM/yyyy").parse(items[8]);   
        } catch (Exception e) {
            System.out.println(String.format("failed to load booking date for %s", ID));
        }

        this.venue = items[9];
        
    }

    public String toLine(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", 
        ID, chosenEvent.ordinal(), chosenSetMenu.ID, decorations, status.ordinal(), client.ID, numberOfAdults, numberOfKids, formatter.format(date), venue);
    }

    @Override
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%s. %s %s %s %s %s %s Adults:%s Kids:%s %s %s", 
            ID, 
            client.name, 
            client.surname,
            formatter.format(date),
            chosenEvent, 
            chosenSetMenu.name, 
            decorations,
            numberOfAdults, 
            numberOfKids, 
            status,
            venue
        );

    }
}