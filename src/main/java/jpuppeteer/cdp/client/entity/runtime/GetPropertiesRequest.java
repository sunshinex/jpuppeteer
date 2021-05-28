package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class GetPropertiesRequest {

    /**
    * Identifier of the object to return properties for.
    */
    public final String objectId;

    /**
    * If true, returns properties belonging only to the element itself, not to its prototype chain.
    */
    public final Boolean ownProperties;

    /**
    * If true, returns accessor properties (with getter/setter) only; internal properties are not returned either.
    */
    public final Boolean accessorPropertiesOnly;

    /**
    * Whether preview should be generated for the results.
    */
    public final Boolean generatePreview;

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

}