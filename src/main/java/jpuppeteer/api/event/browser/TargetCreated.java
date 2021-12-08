package jpuppeteer.api.event.browser;

import jpuppeteer.cdp.client.entity.target.TargetInfo;

public class TargetCreated extends BrowserEvent {

    public final TargetInfo targetInfo;

    public TargetCreated(TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }
}
