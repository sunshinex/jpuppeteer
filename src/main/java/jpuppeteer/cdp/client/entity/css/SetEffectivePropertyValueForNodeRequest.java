package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetEffectivePropertyValueForNodeRequest {

    /**
    * The element id for which to set property.
    */
    private Integer nodeId;

    /**
    */
    private String propertyName;

    /**
    */
    private String value;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setPropertyName (String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public void setValue (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public SetEffectivePropertyValueForNodeRequest(Integer nodeId, String propertyName, String value) {
        this.nodeId = nodeId;
        this.propertyName = propertyName;
        this.value = value;
    }

    public SetEffectivePropertyValueForNodeRequest() {
    }

}