package jpuppeteer.cdp.client.constant.audits;

/**
* experimental
*/
public enum SharedArrayBufferIssueType implements jpuppeteer.cdp.client.CDPEnum {

    TRANSFERISSUE("TransferIssue"),
    CREATIONISSUE("CreationIssue"),
    ;

    private String value;

    SharedArrayBufferIssueType(String value) {
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

    public static SharedArrayBufferIssueType findByValue(String value) {
        for(SharedArrayBufferIssueType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}