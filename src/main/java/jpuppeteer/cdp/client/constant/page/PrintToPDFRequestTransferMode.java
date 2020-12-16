package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum PrintToPDFRequestTransferMode implements jpuppeteer.cdp.client.CDPEnum {

    RETURNASBASE64("ReturnAsBase64"),
    RETURNASSTREAM("ReturnAsStream"),
    ;

    private String value;

    PrintToPDFRequestTransferMode(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static PrintToPDFRequestTransferMode findByValue(String value) {
        for(PrintToPDFRequestTransferMode val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}