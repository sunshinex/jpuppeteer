package jpuppeteer.cdp.client.entity.schema;

/**
* Description of the protocol domain.
*/
public class Domain {

    /**
    * Domain name.
    */
    private String name;

    /**
    * Domain version.
    */
    private String version;

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

    public Domain(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public Domain() {
    }

}