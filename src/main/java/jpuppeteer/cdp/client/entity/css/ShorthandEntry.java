package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class ShorthandEntry {

    /**
    * Shorthand name.
    */
    private String name;

    /**
    * Shorthand value.
    */
    private String value;

    /**
    * Whether the property has "!important" annotation (implies `false` if absent).
    */
    private Boolean important;

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

    public void setImportant (Boolean important) {
        this.important = important;
    }

    public Boolean getImportant() {
        return this.important;
    }

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

    public ShorthandEntry() {
    }

}