package jpuppeteer.api.event.browser;

public class TargetClosed extends BrowserEvent {

    public final String targetId;

    public TargetClosed(String targetId) {
        this.targetId = targetId;
    }
}
