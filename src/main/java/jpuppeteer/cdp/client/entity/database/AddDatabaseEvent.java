package jpuppeteer.cdp.client.entity.database;

/**
* experimental
*/
public class AddDatabaseEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.database.Database database;

    public void setDatabase (jpuppeteer.cdp.client.entity.database.Database database) {
        this.database = database;
    }

    public jpuppeteer.cdp.client.entity.database.Database getDatabase() {
        return this.database;
    }

    public AddDatabaseEvent(jpuppeteer.cdp.client.entity.database.Database database) {
        this.database = database;
    }

    public AddDatabaseEvent() {
    }

}