package business.logic;

import data.layer.PeopleFactory;
import data.layer.People;
import implementation.layer.MenuItem;

public class OutputToFile extends MenuItem {
    private People people;

    public OutputToFile(People people) {
        super("Output to File");
        this.people = people;
    }

    @Override
    public MenuItemReturnValue selected() {
        String fileName = Helper.getStringFromUser("File name (people.csv): ");
        if (fileName.length() > 0) {
            PeopleFactory.outputToFile(fileName, this.people);
        } else {
            PeopleFactory.outputToFile("people.csv", this.people);
        }
        

        return MenuItemReturnValue.CONTINUE;
    }
}
