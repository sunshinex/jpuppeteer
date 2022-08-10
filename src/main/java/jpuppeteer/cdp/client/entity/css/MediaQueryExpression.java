package jpuppeteer.cdp.client.entity.css;

/**
* Media query expression descriptor.
* experimental
*/
public class MediaQueryExpression {

    /**
    * Media query expression value.
    */
    private java.math.BigDecimal value;

    /**
    * Media query expression units.
    */
    private String unit;

    /**
    * Media query expression feature.
    */
    private String feature;

    /**
    * The associated range of the value text in the enclosing stylesheet (if available).
    */
    private jpuppeteer.cdp.client.entity.css.SourceRange valueRange;

    /**
    * Computed length of media query expression (if applicable).
    */
    private java.math.BigDecimal computedLength;

    public void setValue (java.math.BigDecimal value) {
        this.value = value;
    }

    public java.math.BigDecimal getValue() {
        return this.value;
    }

    public void setUnit (String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setFeature (String feature) {
        this.feature = feature;
    }

    public String getFeature() {
        return this.feature;
    }

    public void setValueRange (jpuppeteer.cdp.client.entity.css.SourceRange valueRange) {
        this.valueRange = valueRange;
    }

    public jpuppeteer.cdp.client.entity.css.SourceRange getValueRange() {
        return this.valueRange;
    }

    public void setComputedLength (java.math.BigDecimal computedLength) {
        this.computedLength = computedLength;
    }

    public java.math.BigDecimal getComputedLength() {
        return this.computedLength;
    }

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

    public MediaQueryExpression() {
    }

}