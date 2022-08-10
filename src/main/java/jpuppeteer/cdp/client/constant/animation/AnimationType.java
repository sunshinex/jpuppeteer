package jpuppeteer.cdp.client.constant.animation;

/**
* experimental
*/
public enum AnimationType implements jpuppeteer.cdp.client.CDPEnum {

    CSSTRANSITION("CSSTransition"),
    CSSANIMATION("CSSAnimation"),
    WEBANIMATION("WebAnimation"),
    ;

    private String value;

    AnimationType(String value) {
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

    public static AnimationType findByValue(String value) {
        for(AnimationType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}