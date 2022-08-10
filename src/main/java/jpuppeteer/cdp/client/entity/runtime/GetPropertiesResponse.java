package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class GetPropertiesResponse {

    /**
    * Object properties.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.runtime.PropertyDescriptor> result;

    /**
    * Internal object properties (only of the element itself).
    */
    private java.util.List<jpuppeteer.cdp.client.entity.runtime.InternalPropertyDescriptor> internalProperties;

    /**
    * Object private properties.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.runtime.PrivatePropertyDescriptor> privateProperties;

    /**
    * Exception details.
    */
    private jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails;

    public void setResult (java.util.List<jpuppeteer.cdp.client.entity.runtime.PropertyDescriptor> result) {
        this.result = result;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.runtime.PropertyDescriptor> getResult() {
        return this.result;
    }

    public void setInternalProperties (java.util.List<jpuppeteer.cdp.client.entity.runtime.InternalPropertyDescriptor> internalProperties) {
        this.internalProperties = internalProperties;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.runtime.InternalPropertyDescriptor> getInternalProperties() {
        return this.internalProperties;
    }

    public void setPrivateProperties (java.util.List<jpuppeteer.cdp.client.entity.runtime.PrivatePropertyDescriptor> privateProperties) {
        this.privateProperties = privateProperties;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.runtime.PrivatePropertyDescriptor> getPrivateProperties() {
        return this.privateProperties;
    }

    public void setExceptionDetails (jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.exceptionDetails = exceptionDetails;
    }

    public jpuppeteer.cdp.client.entity.runtime.ExceptionDetails getExceptionDetails() {
        return this.exceptionDetails;
    }

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

    public GetPropertiesResponse() {
    }

}