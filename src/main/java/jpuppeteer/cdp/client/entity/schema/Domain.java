package jpuppeteer.cdp.client.entity.schema;

/**
* Description of the protocol domain.
*/
public class Domain {

    /**
    * Domain name.
    */
    public final String name;

    /**
    * Domain version.
    */
    public final String version;

    public Domain(String name, String version) {
        this.name = name;
        this.version = version;
    }

}