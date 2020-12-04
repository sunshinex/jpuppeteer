package jpuppeteer.constant;

public enum LifecyclePhase {

    INIT("init"),
    FIRSTPAINT("firstPaint"),
    FIRSTCONTENTFULPAINT("firstContentfulPaint"),
    FIRSTMEANINGFULPAINTCANDIDATE("firstMeaningfulPaintCandidate"),
    FIRSTIMAGEPAINT("firstImagePaint"),
    DOMCONTENTLOADED("DOMContentLoaded"),
    LOAD("load"),
    NETWORKALMOSTIDLE("networkAlmostIdle"),
    FIRSTMEANINGFULPAINT("firstMeaningfulPaint"),
    NETWORKIDLE("networkIdle"),
    COMMIT("commit"),
    ;

    private String value;

    LifecyclePhase(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static LifecyclePhase findByValue(String value) {
        for(LifecyclePhase type : LifecyclePhase.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        return null;
    }
}
