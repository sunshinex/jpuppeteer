package jpuppeteer.cdp.client.constant.overlay;

/**
* experimental
*/
public enum InspectMode implements jpuppeteer.cdp.client.CDPEnum {

    SEARCHFORNODE("searchForNode"),
    SEARCHFORUASHADOWDOM("searchForUAShadowDOM"),
    CAPTUREAREASCREENSHOT("captureAreaScreenshot"),
    SHOWDISTANCES("showDistances"),
    NONE("none"),
    ;

    private String value;

    InspectMode(String value) {
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

    public static InspectMode findByValue(String value) {
        for(InspectMode val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}