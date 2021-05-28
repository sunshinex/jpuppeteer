package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class GetPropertiesResponse {

    /**
    * Object properties.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.runtime.PropertyDescriptor> result;

    /**
    * Internal object properties (only of the element itself).
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.runtime.InternalPropertyDescriptor> internalProperties;

    /**
    * Object private properties.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.runtime.PrivatePropertyDescriptor> privateProperties;

    /**
    * Exception details.
    */
    public final jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails;

    public GetPropertiesResponse(java.util.List<jpuppeteer.cdp.client.entity.runtime.PropertyDescriptor> result, java.util.List<jpuppeteer.cdp.client.entity.runtime.InternalPropertyDescriptor> internalProperties, java.util.List<jpuppeteer.cdp.client.entity.runtime.PrivatePropertyDescriptor> privateProperties, jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.result = result;
        this.internalProperties = internalProperties;
        this.privateProperties = privateProperties;
        this.exceptionDetails = exceptionDetails;
    }

    public GetPropertiesResponse(java.util.List<jpuppeteer.cdp.client.entity.runtime.PropertyDescriptor> result) {
        this.result = result;
        this.internalProperties = null;
        this.privateProperties = null;
        this.exceptionDetails = null;
    }

}