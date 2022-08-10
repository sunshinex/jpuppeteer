package jpuppeteer.cdp.client.constant.network;

/**
* Network level fetch failure reason.
*/
public enum ErrorReason implements jpuppeteer.cdp.client.CDPEnum {

    FAILED("Failed"),
    ABORTED("Aborted"),
    TIMEDOUT("TimedOut"),
    ACCESSDENIED("AccessDenied"),
    CONNECTIONCLOSED("ConnectionClosed"),
    CONNECTIONRESET("ConnectionReset"),
    CONNECTIONREFUSED("ConnectionRefused"),
    CONNECTIONABORTED("ConnectionAborted"),
    CONNECTIONFAILED("ConnectionFailed"),
    NAMENOTRESOLVED("NameNotResolved"),
    INTERNETDISCONNECTED("InternetDisconnected"),
    ADDRESSUNREACHABLE("AddressUnreachable"),
    BLOCKEDBYCLIENT("BlockedByClient"),
    BLOCKEDBYRESPONSE("BlockedByResponse"),
    ;

    private String value;

    ErrorReason(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static ErrorReason findByValue(String value) {
        for(ErrorReason val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}