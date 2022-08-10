package jpuppeteer.cdp.client.entity.fetch;

/**
* Response HTTP header entry
*/
public class HeaderEntry {

    /**
    */
    private String name;

    /**
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

    public HeaderEntry(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public HeaderEntry() {
    }

}