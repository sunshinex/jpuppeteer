package jpuppeteer.cdp.client.entity.database;

/**
* experimental
*/
public class AddDatabaseEvent {

    /**
    */
    public final Database database;

    public AddDatabaseEvent(Database database) {
        this.database = database;
    }

}