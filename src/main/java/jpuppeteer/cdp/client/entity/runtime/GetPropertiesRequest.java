package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class GetPropertiesRequest {

    /**
    * Identifier of the object to return properties for.
    */
    private String objectId;

    /**
    * If true, returns properties belonging only to the element itself, not to its prototype chain.
    */
    private Boolean ownProperties;

    /**
    * If true, returns accessor properties (with getter/setter) only; internal properties are not returned either.
    */
    private Boolean accessorPropertiesOnly;

    /**
    * Whether preview should be generated for the results.
    */
    private Boolean generatePreview;

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setOwnProperties (Boolean ownProperties) {
        this.ownProperties = ownProperties;
    }

    public Boolean getOwnProperties() {
        return this.ownProperties;
    }

    public void setAccessorPropertiesOnly (Boolean accessorPropertiesOnly) {
        this.accessorPropertiesOnly = accessorPropertiesOnly;
    }

    public Boolean getAccessorPropertiesOnly() {
        return this.accessorPropertiesOnly;
    }

    public void setGeneratePreview (Boolean generatePreview) {
        this.generatePreview = generatePreview;
    }

    public Boolean getGeneratePreview() {
        return this.generatePreview;
    }

    public GetPropertiesRequest(String objectId, Boolean ownProperties, Boolean accessorPropertiesOnly, Boolean generatePreview) {
        this.objectId = objectId;
        this.ownProperties = ownProperties;
        this.accessorPropertiesOnly = accessorPropertiesOnly;
        this.generatePreview = generatePreview;
    }

    public GetPropertiesRequest(String objectId) {
        this.objectId = objectId;
        this.ownProperties = null;
        this.accessorPropertiesOnly = null;
        this.generatePreview = null;
    }

    public GetPropertiesRequest() {
    }

}