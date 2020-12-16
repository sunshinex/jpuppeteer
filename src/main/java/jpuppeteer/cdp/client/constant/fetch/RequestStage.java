package jpuppeteer.cdp.client.constant.fetch;

/**
* Stages of the request to handle. Request will intercept before the request is sent. Response will intercept after the response is received (but before response body is received.
* experimental
*/
public enum RequestStage implements jpuppeteer.cdp.client.CDPEnum {

    REQUEST("Request"),
    RESPONSE("Response"),
    ;

    private String value;

    RequestStage(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static RequestStage findByValue(String value) {
        for(RequestStage val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}