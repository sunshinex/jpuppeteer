package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* A subset of the full ComputedStyle as defined by the request whitelist.
* experimental
*/
public class ComputedStyle {

    /**
    * Name/value pairs of computed style properties.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.NameValue> properties;

    public void setProperties (java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.NameValue> properties) {
        this.properties = properties;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.NameValue> getProperties() {
        return this.properties;
    }

    public ComputedStyle(java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.NameValue> properties) {
        this.properties = properties;
    }

    public ComputedStyle() {
    }

}