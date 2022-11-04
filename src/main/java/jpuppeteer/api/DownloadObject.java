package jpuppeteer.api;

import jpuppeteer.cdp.client.constant.browser.DownloadProgressEventState;
import jpuppeteer.util.XFuture;

public interface DownloadObject {

    String guid();

    String url();

    String filename();

    DownloadProgressEventState state();

    long totalBytes();

    long receivedBytes();

    XFuture<?> cancel();

}
