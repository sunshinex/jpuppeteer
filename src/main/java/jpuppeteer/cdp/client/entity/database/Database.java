package jpuppeteer.cdp.client.entity.database;

/**
* Database object.
* experimental
*/
public class Database {

    /**
    * Database ID.
    */
    private String id;

    /**
    * Database domain.
    */
    private String domain;

    /**
    * Database name.
    */
    private String name;

    /**
    * Database version.
    */
    private String version;

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setDomain (String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setVersion (String version) {
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }

    public Database(String id, String domain, String name, String version) {
        this.id = id;
        this.domain = domain;
        this.name = name;
        this.version = version;
    }

    public Database() {
    }

}