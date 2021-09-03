package jpuppeteer.cdp.client.entity.database;

/**
* experimental
*/
public class AddDatabaseEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.database.Database database;

    public AddDatabaseEvent(jpuppeteer.cdp.client.entity.database.Database database) {
        this.database = database;
    }

}