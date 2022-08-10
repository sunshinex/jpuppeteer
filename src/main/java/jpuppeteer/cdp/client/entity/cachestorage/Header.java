package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class Header {

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

    public Header(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Header() {
    }

}