package jpuppeteer.cdp;

public enum TargetType {

    BROWSER("browser"),
    BACKGROUND_PAGE("background_page"),
    PAGE("page"),
    IFRAME("iframe"),
    OTHER("other");

    private final String value;

    TargetType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static TargetType findByType(String type) {
        for(TargetType val : values()) {
            if (val.value.equals(type)) {
                return val;
            }
        }
        return OTHER;
    }
}
