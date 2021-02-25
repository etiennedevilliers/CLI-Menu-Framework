package business.logic;

import data.generalClasses.*;
import data.collectionClasses.*;
import implementation.layer.MenuItem;

/**
 * Business logic for viewing People
 */
public class ViewClients extends MenuItem {
    private ClientCollection clientCollection;

    public ViewClients (ClientCollection clientCollection){
        super("View Clients");
        this.clientCollection = clientCollection;
    }

    @Override
    public MenuItemReturnValue selected() {
        System.out.println("People: ");
        for (Client person : clientCollection) {
            System.out.println(String.format("\t%s",person));
        }

        return MenuItemReturnValue.CONTINUE;
    }
}
