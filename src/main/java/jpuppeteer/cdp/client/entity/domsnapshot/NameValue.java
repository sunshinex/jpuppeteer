package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* A name/value pair.
* experimental
*/
public class NameValue {

    /**
    * Attribute/property name.
    */
    private String name;

    /**
    * Attribute/property value.
    */
    private String value;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public NameValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public NameValue() {
    }

}