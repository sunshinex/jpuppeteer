package jpuppeteer.cdp.client.entity.webaudio;

/**
* Protocol object for AudioParam
* experimental
*/
public class AudioParam {

    /**
    */
    public final String paramId;

    /**
    */
    public final String nodeId;

    /**
    */
    public final String contextId;

    /**
    */
    public final String paramType;

    /**
    */
    public final String rate;

    /**
    */
    public final java.math.BigDecimal defaultValue;

    /**
    */
    public final java.math.BigDecimal minValue;

    /**
    */
    public final java.math.BigDecimal maxValue;

    public AudioParam(String paramId, String nodeId, String contextId, String paramType, String rate, java.math.BigDecimal defaultValue, java.math.BigDecimal minValue, java.math.BigDecimal maxValue) {
        this.paramId = paramId;
        this.nodeId = nodeId;
        this.contextId = contextId;
        this.paramType = paramType;
        this.rate = rate;
        this.defaultValue = defaultValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

}