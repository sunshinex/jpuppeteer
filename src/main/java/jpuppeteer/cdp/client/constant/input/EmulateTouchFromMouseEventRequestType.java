package jpuppeteer.cdp.client.constant.input;

/**
*/
public enum EmulateTouchFromMouseEventRequestType implements jpuppeteer.cdp.client.CDPEnum {

    MOUSEPRESSED("mousePressed"),
    MOUSERELEASED("mouseReleased"),
    MOUSEMOVED("mouseMoved"),
    MOUSEWHEEL("mouseWheel"),
    ;

    private String value;

    EmulateTouchFromMouseEventRequestType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static EmulateTouchFromMouseEventRequestType findByValue(String value) {
        for(EmulateTouchFromMouseEventRequestType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}