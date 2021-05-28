package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* A name/value pair.
* experimental
*/
public class NameValue {

    /**
    * Attribute/property name.
    */
    public final String name;

    /**
    * Attribute/property value.
    */
    public final String value;

    public NameValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

}