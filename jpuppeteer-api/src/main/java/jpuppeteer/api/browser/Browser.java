package jpuppeteer.api.browser;

import jpuppeteer.api.event.EventEmitter;

import java.net.URI;
import java.util.List;

public interface Browser extends EventEmitter {

    void close() throws Exception;

//    @TODO 暂不支持创建上下文, 先屏蔽这些接口
//    List<BrowserContext> browserContexts();
//
//    /**
//     * 等同于创建隐私窗口
//     * @return
//     */
//    BrowserContext createIncognitoContext();
//
//    /**
//     * 等同于创建普通窗口
//     * @return
//     */
//    BrowserContext createContext();

    /**
     * 如果浏览器存在默认的上下文, 则返回默认的上下文, 否则返回null
     * @return
     */
    <R extends BrowserContext> R defaultContext();

    //@TODO 目前只支持集成启动命令行的模式, 不需要connect, 先屏蔽
//    void disconnect() throws Exception;
//
//    boolean isConnected();

    String userAgent() throws Exception;

    String version() throws Exception;

    URI wsEndpoint();

    /**
     * 如果是通过websocket连接的话, 返回null
     * @return
     */
    Process process();

    void setCookie(Cookie... cookies) throws Exception;

    void deleteCookie(Cookie... cookies) throws Exception;

    void clearCookie() throws Exception;

    List<Cookie> cookies() throws Exception;

}
