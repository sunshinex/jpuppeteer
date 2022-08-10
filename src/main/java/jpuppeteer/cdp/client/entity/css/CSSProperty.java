package jpuppeteer.cdp.client.entity.css;

/**
* CSS property declaration data.
* experimental
*/
public class CSSProperty {

    /**
    * The property name.
    */
    private String name;

    /**
    * The property value.
    */
    private String value;

    /**
    * Whether the property has "!important" annotation (implies `false` if absent).
    */
    private Boolean important;

    /**
    * Whether the property is implicit (implies `false` if absent).
    */
    private Boolean implicit;

    /**
    * The full property text as specified in the style.
    */
    private String text;

    /**
    * Whether the property is understood by the browser (implies `true` if absent).
    */
    private Boolean parsedOk;

    /**
    * Whether the property is disabled by the user (present for source-based properties only).
    */
    private Boolean disabled;

    /**
    * The entire property range in the enclosing style declaration (if available).
    */
    private jpuppeteer.cdp.client.entity.css.SourceRange range;

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

    public void setImplicit (Boolean implicit) {
        this.implicit = implicit;
    }

    public Boolean getImplicit() {
        return this.implicit;
    }

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setParsedOk (Boolean parsedOk) {
        this.parsedOk = parsedOk;
    }

    public Boolean getParsedOk() {
        return this.parsedOk;
    }

    public void setDisabled (Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getDisabled() {
        return this.disabled;
    }

    public void setRange (jpuppeteer.cdp.client.entity.css.SourceRange range) {
        this.range = range;
    }

    public jpuppeteer.cdp.client.entity.css.SourceRange getRange() {
        return this.range;
    }

    public CSSProperty(String name, String value, Boolean important, Boolean implicit, String text, Boolean parsedOk, Boolean disabled, jpuppeteer.cdp.client.entity.css.SourceRange range) {
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

    public CSSProperty() {
    }

}