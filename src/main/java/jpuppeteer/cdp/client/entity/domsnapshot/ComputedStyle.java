package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* A subset of the full ComputedStyle as defined by the request whitelist.
* experimental
*/
public class ComputedStyle {

    /**
    * Name/value pairs of computed style properties.
    */
    public final java.util.List<NameValue> properties;

    public ComputedStyle(java.util.List<NameValue> properties) {
        this.properties = properties;
    }

}