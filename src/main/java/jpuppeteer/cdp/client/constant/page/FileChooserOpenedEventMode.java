package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum FileChooserOpenedEventMode implements jpuppeteer.cdp.client.CDPEnum {

    SELECTSINGLE("selectSingle"),
    SELECTMULTIPLE("selectMultiple"),
    ;

    private String value;

    FileChooserOpenedEventMode(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static FileChooserOpenedEventMode findByValue(String value) {
        for(FileChooserOpenedEventMode val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}