package business.logic;

import data.layer.*;
import business.extra.*;


import implementation.layer.MenuItem;

/**
 * Business logic for adding users
 */
public class AddClient extends MenuItem {
    ClientCollection clientCollection;

    public AddClient (ClientCollection clientCollection) {
        super("Add Client");
        this.clientCollection = clientCollection;
    }
    
    @Override
    public MenuItemReturnValue selected() {
        String name = Helper.getStringFromUser("Name: ");
        String surname = Helper.getStringFromUser("Surname: ");
        int newID = clientCollection.getUniqueID();
        this.clientCollection.add(new Client(newID, name, surname));
        ClientCollectionFactory.outputToFile(clientCollection);

        return MenuItemReturnValue.CONTINUE;
    }
}
