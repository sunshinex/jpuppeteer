package jpuppeteer.cdp.client.entity.fetch;

/**
* Response HTTP header entry
* experimental
*/
public class HeaderEntry {

    /**
    */
    public final String name;

    /**
    */
    public final String value;

    public HeaderEntry(String name, String value) {
        this.name = name;
        this.value = value;
    }

}