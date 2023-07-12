package jpuppeteer.constant;

public enum WatchAction {

    SHOW("show"),
    HIDE("hide"),
    ;

    private final String action;

    WatchAction(String action) {
        this.action = action;
    }

    public static WatchAction findByValue(String value) {
        for(WatchAction watchAction : values()) {
            if (watchAction.action.equals(value)) {
                return watchAction;
            }
        }
        return null;
    }
}
