package jpuppeteer.api.event.browser;

import jpuppeteer.cdp.client.entity.target.TargetInfo;

public class TargetInfoChanged extends BrowserEvent {

    public final TargetInfo targetInfo;

    public TargetInfoChanged(TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }
}
