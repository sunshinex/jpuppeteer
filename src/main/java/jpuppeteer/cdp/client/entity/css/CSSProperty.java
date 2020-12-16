package jpuppeteer.cdp.client.entity.css;

/**
* CSS property declaration data.
* experimental
*/
public class CSSProperty {

    /**
    * The property name.
    */
    public final String name;

    /**
    * The property value.
    */
    public final String value;

    /**
    * Whether the property has "!important" annotation (implies `false` if absent).
    */
    public final Boolean important;

    /**
    * Whether the property is implicit (implies `false` if absent).
    */
    public final Boolean implicit;

    /**
    * The full property text as specified in the style.
    */
    public final String text;

    /**
    * Whether the property is understood by the browser (implies `true` if absent).
    */
    public final Boolean parsedOk;

    /**
    * Whether the property is disabled by the user (present for source-based properties only).
    */
    public final Boolean disabled;

    /**
    * The entire property range in the enclosing style declaration (if available).
    */
    public final SourceRange range;

    public CSSProperty(String name, String value, Boolean important, Boolean implicit, String text, Boolean parsedOk, Boolean disabled, SourceRange range) {
        this.name = name;
        this.value = value;
        this.important = important;
        this.implicit = implicit;
        this.text = text;
        this.parsedOk = parsedOk;
        this.disabled = disabled;
        this.range = range;
    }

    public CSSProperty(String name, String value) {
        this.name = name;
        this.value = value;
        this.important = null;
        this.implicit = null;
        this.text = null;
        this.parsedOk = null;
        this.disabled = null;
        this.range = null;
    }

}