package jpuppeteer.api.event.browser;

public class TargetCrashed extends BrowserEvent {

    public final String targetId;

    public final String status;

    public final Integer errorCode;

    public TargetCrashed(String targetId, String status, Integer errorCode) {
        this.targetId = targetId;
        this.status = status;
        this.errorCode = errorCode;
    }
}
