package jpuppeteer.cdp.client.constant.css;

/**
* experimental
*/
public enum CSSMediaSource implements jpuppeteer.cdp.client.CDPEnum {

    MEDIARULE("mediaRule"),
    IMPORTRULE("importRule"),
    LINKEDSHEET("linkedSheet"),
    INLINESHEET("inlineSheet"),
    ;

    private String value;

    CSSMediaSource(String value) {
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

    public static CSSMediaSource findByValue(String value) {
        for(CSSMediaSource val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}