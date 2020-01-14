package jpuppeteer.chrome.constant;

public enum LifecycleEventType {

    UNKNOWN("unkonwn"),
    FIRSTPAINT("firstPaint"),
    FIRSTCONTENTFULPAINT("firstContentfulPaint"),
    FIRSTMEANINGFULPAINTCANDIDATE("firstMeaningfulPaintCandidate"),
    FIRSTIMAGEPAINT("firstImagePaint"),
    DOMCONTENTLOADED("DOMContentLoaded"),
    LOAD("load"),
    INIT("init"),
    NETWORKALMOSTIDLE("networkAlmostIdle"),
    FIRSTMEANINGFULPAINT("firstMeaningfulPaint"),
    NETWORKIDLE("networkIdle")
    ;

    public final String name;

    LifecycleEventType(String name) {
        this.name = name;
    }

    public static LifecycleEventType findByName(String name) {
        for(LifecycleEventType v : values()) {
            if (v.name.equals(name)) {
                return v;
            }
        }
        return UNKNOWN;
    }
}
