package jpuppeteer.api.browser;

import jpuppeteer.api.constant.PermissionType;
import jpuppeteer.api.event.EventEmitter;

import java.util.List;

public interface BrowserContext {

    //TODO 后续支持创建context之后, context需要支持事件, 暂时可不支持

    Browser browser();

    void resetPermissions() throws Exception;

    void grantPermissions(String origin, PermissionType... permissions) throws Exception;

    /**
     * 等同于创建标签页
     */
    Page newPage() throws Exception;

    Page[] pages() throws Exception;

    void setCookies(Cookie... cookies) throws Exception;

    void clearCookies() throws Exception;

    Cookie[] cookies() throws Exception;

}
