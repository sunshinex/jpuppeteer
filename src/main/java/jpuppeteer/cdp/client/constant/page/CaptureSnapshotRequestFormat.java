package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum CaptureSnapshotRequestFormat implements jpuppeteer.cdp.client.CDPEnum {

    MHTML("mhtml"),
    ;

    private String value;

    CaptureSnapshotRequestFormat(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static CaptureSnapshotRequestFormat findByValue(String value) {
        for(CaptureSnapshotRequestFormat val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}