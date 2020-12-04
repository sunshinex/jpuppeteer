package jpuppeteer.api.event.page;

import jpuppeteer.api.event.PageEvent;
import jpuppeteer.cdp.client.entity.target.TargetInfo;

public class ChangedEvent extends PageEvent {

    private final TargetInfo info;

    public ChangedEvent(TargetInfo info) {
        this.info = info;
    }

    public TargetInfo info() {
        return info;
    }
}
