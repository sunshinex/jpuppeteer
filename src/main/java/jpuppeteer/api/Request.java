package jpuppeteer.api;

import io.netty.util.concurrent.Future;
import jpuppeteer.cdp.client.constant.network.ResourceType;

public interface Request {

    Frame frame();

    String requestId();

    String loaderId();

    String url();

    String method();

    HttpHeader[] headers();

    ResourceType resourceType();

    String location();

    Future<String> content();

}
