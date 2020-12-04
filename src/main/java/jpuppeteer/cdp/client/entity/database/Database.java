package jpuppeteer.cdp.client.entity.database;

/**
* Database object.
* experimental
*/
public class Database {

    /**
    * Database ID.
    */
    public final String id;

    /**
    * Database domain.
    */
    public final String domain;

    /**
    * Database name.
    */
    public final String name;

    /**
    * Database version.
    */
    public final String version;

    public Database(String id, String domain, String name, String version) {
        this.id = id;
        this.domain = domain;
        this.name = name;
        this.version = version;
    }

}