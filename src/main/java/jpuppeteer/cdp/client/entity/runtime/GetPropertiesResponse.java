package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class GetPropertiesResponse {

    /**
    * Object properties.
    */
    public final java.util.List<PropertyDescriptor> result;

    /**
    * Internal object properties (only of the element itself).
    */
    public final java.util.List<InternalPropertyDescriptor> internalProperties;

    /**
    * Object private properties.
    */
    public final java.util.List<PrivatePropertyDescriptor> privateProperties;

    /**
    * Exception details.
    */
    public final ExceptionDetails exceptionDetails;

    public GetPropertiesResponse(java.util.List<PropertyDescriptor> result, java.util.List<InternalPropertyDescriptor> internalProperties, java.util.List<PrivatePropertyDescriptor> privateProperties, ExceptionDetails exceptionDetails) {
        this.result = result;
        this.internalProperties = internalProperties;
        this.privateProperties = privateProperties;
        this.exceptionDetails = exceptionDetails;
    }

    public GetPropertiesResponse(java.util.List<PropertyDescriptor> result) {
        this.result = result;
        this.internalProperties = null;
        this.privateProperties = null;
        this.exceptionDetails = null;
    }

}