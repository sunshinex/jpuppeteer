package jpuppeteer.cdp.client.entity.accessibility;

/**
* A single source for a computed AX property.
* experimental
*/
public class AXValueSource {

    /**
    * What type of source this is.
    */
    private jpuppeteer.cdp.client.constant.accessibility.AXValueSourceType type;

    /**
    * The value of this property source.
    */
    private jpuppeteer.cdp.client.entity.accessibility.AXValue value;

    /**
    * The name of the relevant attribute, if any.
    */
    private String attribute;

    /**
    * The value of the relevant attribute, if any.
    */
    private jpuppeteer.cdp.client.entity.accessibility.AXValue attributeValue;

    /**
    * Whether this source is superseded by a higher priority source.
    */
    private Boolean superseded;

    /**
    * The native markup source for this value, e.g. a <label> element.
    */
    private jpuppeteer.cdp.client.constant.accessibility.AXValueNativeSourceType nativeSource;

    /**
    * The value, such as a node or node list, of the native source.
    */
    private jpuppeteer.cdp.client.entity.accessibility.AXValue nativeSourceValue;

    /**
    * Whether the value for this property is invalid.
    */
    private Boolean invalid;

    /**
    * Reason for the value being invalid, if it is.
    */
    private String invalidReason;

    public void setType (jpuppeteer.cdp.client.constant.accessibility.AXValueSourceType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.accessibility.AXValueSourceType getType() {
        return this.type;
    }

    public void setValue (jpuppeteer.cdp.client.entity.accessibility.AXValue value) {
        this.value = value;
    }

    public jpuppeteer.cdp.client.entity.accessibility.AXValue getValue() {
        return this.value;
    }

    public void setAttribute (String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void setAttributeValue (jpuppeteer.cdp.client.entity.accessibility.AXValue attributeValue) {
        this.attributeValue = attributeValue;
    }

    public jpuppeteer.cdp.client.entity.accessibility.AXValue getAttributeValue() {
        return this.attributeValue;
    }

    public void setSuperseded (Boolean superseded) {
        this.superseded = superseded;
    }

    public Boolean getSuperseded() {
        return this.superseded;
    }

    public void setNativeSource (jpuppeteer.cdp.client.constant.accessibility.AXValueNativeSourceType nativeSource) {
        this.nativeSource = nativeSource;
    }

    public jpuppeteer.cdp.client.constant.accessibility.AXValueNativeSourceType getNativeSource() {
        return this.nativeSource;
    }

    public void setNativeSourceValue (jpuppeteer.cdp.client.entity.accessibility.AXValue nativeSourceValue) {
        this.nativeSourceValue = nativeSourceValue;
    }

    public jpuppeteer.cdp.client.entity.accessibility.AXValue getNativeSourceValue() {
        return this.nativeSourceValue;
    }

    public void setInvalid (Boolean invalid) {
        this.invalid = invalid;
    }

    public Boolean getInvalid() {
        return this.invalid;
    }

    public void setInvalidReason (String invalidReason) {
        this.invalidReason = invalidReason;
    }

    public String getInvalidReason() {
        return this.invalidReason;
    }

    public AXValueSource(jpuppeteer.cdp.client.constant.accessibility.AXValueSourceType type, jpuppeteer.cdp.client.entity.accessibility.AXValue value, String attribute, jpuppeteer.cdp.client.entity.accessibility.AXValue attributeValue, Boolean superseded, jpuppeteer.cdp.client.constant.accessibility.AXValueNativeSourceType nativeSource, jpuppeteer.cdp.client.entity.accessibility.AXValue nativeSourceValue, Boolean invalid, String invalidReason) {
        this.type = type;
        this.value = value;
        this.attribute = attribute;
        this.attributeValue = attributeValue;
        this.superseded = superseded;
        this.nativeSource = nativeSource;
        this.nativeSourceValue = nativeSourceValue;
        this.invalid = invalid;
        this.invalidReason = invalidReason;
    }

    public AXValueSource(jpuppeteer.cdp.client.constant.accessibility.AXValueSourceType type) {
        this.type = type;
        this.value = null;
        this.attribute = null;
        this.attributeValue = null;
        this.superseded = null;
        this.nativeSource = null;
        this.nativeSourceValue = null;
        this.invalid = null;
        this.invalidReason = null;
    }

    public AXValueSource() {
    }

}