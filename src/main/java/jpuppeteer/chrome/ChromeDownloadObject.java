package jpuppeteer.chrome;

import jpuppeteer.api.DownloadObject;
import jpuppeteer.api.Frame;
import jpuppeteer.cdp.client.constant.browser.DownloadProgressEventState;
import jpuppeteer.util.XFuture;

public class ChromeDownloadObject implements DownloadObject {

    private final Frame frame;

    private final String guid;

    private final String url;

    private final String suggestedFilename;

    private volatile DownloadProgressEventState state;

    private volatile long totalBytes;

    private volatile long receivedBytes;

    public ChromeDownloadObject(Frame frame, String guid, String url, String suggestedFilename) {
        this.frame = frame;
        this.guid = guid;
        this.url = url;
        this.suggestedFilename = suggestedFilename;
    }

    public Frame frame() {
        return frame;
    }

    @Override
    public String guid() {
        return guid;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public String filename() {
        return suggestedFilename;
    }

    @Override
    public DownloadProgressEventState state() {
        return state;
    }

    public void setState(DownloadProgressEventState state) {
        this.state = state;
    }

    @Override
    public long totalBytes() {
        return totalBytes;
    }

    public void setTotalBytes(long totalBytes) {
        this.totalBytes = totalBytes;
    }

    @Override
    public long receivedBytes() {
        return receivedBytes;
    }

    public void setReceivedBytes(long receivedBytes) {
        this.receivedBytes = receivedBytes;
    }

    @Override
    public XFuture<?> cancel() {
        return frame.page().browserContext().cancelDownload(guid);
    }
}
