package jpuppeteer.cdp.client.constant.network;

/**
* Stages of the interception to begin intercepting. Request will intercept before the request is sent. Response will intercept after the response is received.
*/
public enum InterceptionStage implements jpuppeteer.cdp.client.CDPEnum {

    REQUEST("Request"),
    HEADERSRECEIVED("HeadersReceived"),
    ;

    private String value;

    InterceptionStage(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static InterceptionStage findByValue(String value) {
        for(InterceptionStage val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}