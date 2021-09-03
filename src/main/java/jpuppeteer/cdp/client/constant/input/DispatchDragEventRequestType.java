package jpuppeteer.cdp.client.constant.input;

/**
*/
public enum DispatchDragEventRequestType implements jpuppeteer.cdp.client.CDPEnum {

    DRAGENTER("dragEnter"),
    DRAGOVER("dragOver"),
    DROP("drop"),
    DRAGCANCEL("dragCancel"),
    ;

    private String value;

    DispatchDragEventRequestType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static DispatchDragEventRequestType findByValue(String value) {
        for(DispatchDragEventRequestType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}