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
        super("Register");
        this.clientCollection = clientCollection;
    }
    
    @Override
    public MenuItemReturnValue selected() {
        String name = Helper.getStringFromUser("Name: ");
        String surname = Helper.getStringFromUser("Surname: ");
        String cellno = Helper.getStringFromUser("Cell Number: ");
        String email = Helper.getStringFromUser("Email: ");
        int newID = clientCollection.getUniqueID();
        this.clientCollection.add(new Client(newID, name, surname,cellno,email));
        ClientCollectionFactory.outputToFile(clientCollection);

        return MenuItemReturnValue.CONTINUE;
    }
}
