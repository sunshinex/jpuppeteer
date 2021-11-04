package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum DownloadProgressEventState implements jpuppeteer.cdp.client.CDPEnum {

    INPROGRESS("inProgress"),
    COMPLETED("completed"),
    CANCELED("canceled"),
    ;

    private String value;

    DownloadProgressEventState(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static DownloadProgressEventState findByValue(String value) {
        for(DownloadProgressEventState val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}