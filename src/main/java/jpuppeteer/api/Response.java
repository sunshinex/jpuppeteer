package jpuppeteer.api;

import jpuppeteer.cdp.client.constant.network.ResourceType;
import jpuppeteer.util.XFuture;

import java.net.InetSocketAddress;

public interface Response {

    String requestId();

    String loaderId();

    Frame frame();

    ResourceType resourceType();

    String url();

    String protocol();

    int status();

    String statusText();

    String mimeType();

    HttpHeader[] headers();

    HttpHeader[] requestHeaders();

    boolean connectionReused();

    int connectionId();

    InetSocketAddress remoteAddress();

    boolean fromDiskCache();

    boolean fromServiceWorker();

    boolean fromPrefetchCache();

    int encodedDataLength();

    XFuture<byte[]> content();

}
