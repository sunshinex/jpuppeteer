package jpuppeteer.api.event.browser;

import jpuppeteer.cdp.client.entity.browser.DownloadWillBeginEvent;

public class DownloadWillBegin extends BrowserEvent {

    public final String frameId;

    public final String guid;

    public final String url;

    public final String suggestedFilename;

    public DownloadWillBegin(DownloadWillBeginEvent event) {
        this.frameId = event.getFrameId();
        this.guid = event.getGuid();
        this.url = event.getUrl();
        this.suggestedFilename = event.getSuggestedFilename();
    }
}
