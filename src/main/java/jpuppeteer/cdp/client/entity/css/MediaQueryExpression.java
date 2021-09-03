package jpuppeteer.cdp.client.entity.css;

/**
* Media query expression descriptor.
* experimental
*/
public class MediaQueryExpression {

    /**
    * Media query expression value.
    */
    public final java.math.BigDecimal value;

    /**
    * Media query expression units.
    */
    public final String unit;

    /**
    * Media query expression feature.
    */
    public final String feature;

    /**
    * The associated range of the value text in the enclosing stylesheet (if available).
    */
    public final jpuppeteer.cdp.client.entity.css.SourceRange valueRange;

    /**
    * Computed length of media query expression (if applicable).
    */
    public final java.math.BigDecimal computedLength;

    public MediaQueryExpression(java.math.BigDecimal value, String unit, String feature, jpuppeteer.cdp.client.entity.css.SourceRange valueRange, java.math.BigDecimal computedLength) {
        this.value = value;
        this.unit = unit;
        this.feature = feature;
        this.valueRange = valueRange;
        this.computedLength = computedLength;
    }

    public MediaQueryExpression(java.math.BigDecimal value, String unit, String feature) {
        this.value = value;
        this.unit = unit;
        this.feature = feature;
        this.valueRange = null;
        this.computedLength = null;
    }

}