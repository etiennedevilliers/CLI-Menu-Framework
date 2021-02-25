package data.layer;

import java.util.ArrayList;

/**
 * A wrapper around Client. There are no extra functions currently.
 * Acts like a ArrayList<Client> but with extra function
 */
public class ClientCollection extends ArrayList<Client> {
    private static final long serialVersionUID = 1L;

    /**
     * Get a unique id for new Client.
     * @return unique ID
     */
    public int getUniqueID() {
        int high = 0;

        for (Client item : this) {
            if (item.ID > high) 
                high = item.ID;
        };

        return high + 1;
    }
}
