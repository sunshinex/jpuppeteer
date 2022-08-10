package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum ClientNavigationDisposition implements jpuppeteer.cdp.client.CDPEnum {

    CURRENTTAB("currentTab"),
    NEWTAB("newTab"),
    NEWWINDOW("newWindow"),
    DOWNLOAD("download"),
    ;

    private String value;

    ClientNavigationDisposition(String value) {
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

    public static ClientNavigationDisposition findByValue(String value) {
        for(ClientNavigationDisposition val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}