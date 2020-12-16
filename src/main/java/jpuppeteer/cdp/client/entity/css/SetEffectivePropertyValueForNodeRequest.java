package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetEffectivePropertyValueForNodeRequest {

    /**
    * The element id for which to set property.
    */
    public final Integer nodeId;

    /**
    */
    public final String propertyName;

    /**
    */
    public final String value;

    public SetEffectivePropertyValueForNodeRequest(Integer nodeId, String propertyName, String value) {
        this.nodeId = nodeId;
        this.propertyName = propertyName;
        this.value = value;
    }

}