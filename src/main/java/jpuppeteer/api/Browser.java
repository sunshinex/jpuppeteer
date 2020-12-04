package jpuppeteer.api;

import io.netty.util.concurrent.Future;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.client.entity.browser.GetVersionResponse;

public interface Browser extends EventEmitter<CDPEvent> {

    String name();

    Future<GetVersionResponse> version();

    BrowserContext[] browserContexts();

    Future<BrowserContext> createContext();

    BrowserContext defaultContext();

    Future close();

}
