package jpuppeteer.cdp.client.entity.accessibility;

/**
* A single source for a computed AX property.
* experimental
*/
public class AXValueSource {

    /**
    * What type of source this is.
    */
    public final jpuppeteer.cdp.client.constant.accessibility.AXValueSourceType type;

    /**
    * The value of this property source.
    */
    public final jpuppeteer.cdp.client.entity.accessibility.AXValue value;

    /**
    * The name of the relevant attribute, if any.
    */
    public final String attribute;

    /**
    * The value of the relevant attribute, if any.
    */
    public final jpuppeteer.cdp.client.entity.accessibility.AXValue attributeValue;

    /**
    * Whether this source is superseded by a higher priority source.
    */
    public final Boolean superseded;

    /**
    * The native markup source for this value, e.g. a <label> element.
    */
    public final jpuppeteer.cdp.client.constant.accessibility.AXValueNativeSourceType nativeSource;

    /**
    * The value, such as a node or node list, of the native source.
    */
    public final jpuppeteer.cdp.client.entity.accessibility.AXValue nativeSourceValue;

    /**
    * Whether the value for this property is invalid.
    */
    public final Boolean invalid;

    /**
    * Reason for the value being invalid, if it is.
    */
    public final String invalidReason;

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

}