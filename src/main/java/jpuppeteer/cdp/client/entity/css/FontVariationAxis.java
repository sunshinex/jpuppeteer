package jpuppeteer.cdp.client.entity.css;

/**
* Information about font variation axes for variable fonts
* experimental
*/
public class FontVariationAxis {

    /**
    * The font-variation-setting tag (a.k.a. "axis tag").
    */
    private String tag;

    /**
    * Human-readable variation name in the default language (normally, "en").
    */
    private String name;

    /**
    * The minimum value (inclusive) the font supports for this tag.
    */
    private java.math.BigDecimal minValue;

    /**
    * The maximum value (inclusive) the font supports for this tag.
    */
    private java.math.BigDecimal maxValue;

    /**
    * The default value.
    */
    private java.math.BigDecimal defaultValue;

    public void setTag (String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return this.tag;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMinValue (java.math.BigDecimal minValue) {
        this.minValue = minValue;
    }

    public java.math.BigDecimal getMinValue() {
        return this.minValue;
    }

    public void setMaxValue (java.math.BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public java.math.BigDecimal getMaxValue() {
        return this.maxValue;
    }

    public void setDefaultValue (java.math.BigDecimal defaultValue) {
        this.defaultValue = defaultValue;
    }

    public java.math.BigDecimal getDefaultValue() {
        return this.defaultValue;
    }

    public FontVariationAxis(String tag, String name, java.math.BigDecimal minValue, java.math.BigDecimal maxValue, java.math.BigDecimal defaultValue) {
        this.tag = tag;
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.defaultValue = defaultValue;
    }

    public FontVariationAxis() {
    }

}