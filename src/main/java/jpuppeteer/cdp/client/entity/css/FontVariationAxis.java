package jpuppeteer.cdp.client.entity.css;

/**
* Information about font variation axes for variable fonts
* experimental
*/
public class FontVariationAxis {

    /**
    * The font-variation-setting tag (a.k.a. "axis tag").
    */
    public final String tag;

    /**
    * Human-readable variation name in the default language (normally, "en").
    */
    public final String name;

    /**
    * The minimum value (inclusive) the font supports for this tag.
    */
    public final java.math.BigDecimal minValue;

    /**
    * The maximum value (inclusive) the font supports for this tag.
    */
    public final java.math.BigDecimal maxValue;

    /**
    * The default value.
    */
    public final java.math.BigDecimal defaultValue;

    public FontVariationAxis(String tag, String name, java.math.BigDecimal minValue, java.math.BigDecimal maxValue, java.math.BigDecimal defaultValue) {
        this.tag = tag;
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.defaultValue = defaultValue;
    }

}