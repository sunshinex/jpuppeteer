package jpuppeteer.api.event.browser;

import jpuppeteer.cdp.client.constant.browser.DownloadProgressEventState;
import jpuppeteer.cdp.client.entity.browser.DownloadProgressEvent;

public class DownloadProgress extends BrowserEvent {

    public final String guid;

    public final DownloadProgressEventState state;

    public final long totalBytes;

    public final long receivedBytes;

    public DownloadProgress(DownloadProgressEvent event) {
        this.guid = event.getGuid();
        this.state = event.getState();
        this.totalBytes = event.getTotalBytes().longValue();
        this.receivedBytes = event.getReceivedBytes().longValue();
    }
}
