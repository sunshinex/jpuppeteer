package jpuppeteer.cdp.client.entity.webaudio;

/**
* Protocol object for AudioParam
* experimental
*/
public class AudioParam {

    /**
    */
    private String paramId;

    /**
    */
    private String nodeId;

    /**
    */
    private String contextId;

    /**
    */
    private String paramType;

    /**
    */
    private jpuppeteer.cdp.client.constant.webaudio.AutomationRate rate;

    /**
    */
    private java.math.BigDecimal defaultValue;

    /**
    */
    private java.math.BigDecimal minValue;

    /**
    */
    private java.math.BigDecimal maxValue;

    public void setParamId (String paramId) {
        this.paramId = paramId;
    }

    public String getParamId() {
        return this.paramId;
    }

    public void setNodeId (String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public void setContextId (String contextId) {
        this.contextId = contextId;
    }

    public String getContextId() {
        return this.contextId;
    }

    public void setParamType (String paramType) {
        this.paramType = paramType;
    }

    public String getParamType() {
        return this.paramType;
    }

    public void setRate (jpuppeteer.cdp.client.constant.webaudio.AutomationRate rate) {
        this.rate = rate;
    }

    public jpuppeteer.cdp.client.constant.webaudio.AutomationRate getRate() {
        return this.rate;
    }

    public void setDefaultValue (java.math.BigDecimal defaultValue) {
        this.defaultValue = defaultValue;
    }

    public java.math.BigDecimal getDefaultValue() {
        return this.defaultValue;
    }

    public void setMinValue (java.math.BigDecimal minValue) {
        this.minValue = minValue;
    }

    public java.math.BigDecimal getMinValue() {
        return this.minValue;
    }

    public void setMaxValue (java.math.BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public java.math.BigDecimal getMaxValue() {
        return this.maxValue;
    }

    public AudioParam(String paramId, String nodeId, String contextId, String paramType, jpuppeteer.cdp.client.constant.webaudio.AutomationRate rate, java.math.BigDecimal defaultValue, java.math.BigDecimal minValue, java.math.BigDecimal maxValue) {
        this.paramId = paramId;
        this.nodeId = nodeId;
        this.contextId = contextId;
        this.paramType = paramType;
        this.rate = rate;
        this.defaultValue = defaultValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public AudioParam() {
    }

}