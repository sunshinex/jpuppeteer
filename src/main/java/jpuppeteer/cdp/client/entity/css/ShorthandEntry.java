package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class ShorthandEntry {

    /**
    * Shorthand name.
    */
    public final String name;

    /**
    * Shorthand value.
    */
    public final String value;

    /**
    * Whether the property has "!important" annotation (implies `false` if absent).
    */
    public final Boolean important;

    public ShorthandEntry(String name, String value, Boolean important) {
        this.name = name;
        this.value = value;
        this.important = important;
    }

    public ShorthandEntry(String name, String value) {
        this.name = name;
        this.value = value;
        this.important = null;
    }

}