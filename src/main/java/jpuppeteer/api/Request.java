package jpuppeteer.api;

import jpuppeteer.cdp.client.constant.network.ResourceType;
import jpuppeteer.constant.HttpMethod;
import jpuppeteer.util.XFuture;

public interface Request {

    Frame frame();

    String requestId();

    String loaderId();

    String url();

    HttpMethod method();

    HttpHeader[] requestHeaders();

    ResourceType resourceType();

    String location();

    XFuture<String> content();

}
