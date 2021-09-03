package jpuppeteer.cdp.client.constant.network;

/**
*/
public enum TrustTokenOperationDoneEventStatus implements jpuppeteer.cdp.client.CDPEnum {

    OK("Ok"),
    INVALIDARGUMENT("InvalidArgument"),
    FAILEDPRECONDITION("FailedPrecondition"),
    RESOURCEEXHAUSTED("ResourceExhausted"),
    ALREADYEXISTS("AlreadyExists"),
    UNAVAILABLE("Unavailable"),
    BADRESPONSE("BadResponse"),
    INTERNALERROR("InternalError"),
    UNKNOWNERROR("UnknownError"),
    FULFILLEDLOCALLY("FulfilledLocally"),
    ;

    private String value;

    TrustTokenOperationDoneEventStatus(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static TrustTokenOperationDoneEventStatus findByValue(String value) {
        for(TrustTokenOperationDoneEventStatus val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}