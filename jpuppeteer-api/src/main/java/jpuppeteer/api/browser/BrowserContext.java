package jpuppeteer.api.browser;

import jpuppeteer.api.constant.PermissionType;
import jpuppeteer.api.event.EventEmitter;

import java.util.List;

public interface BrowserContext extends EventEmitter {

    //TODO 后续支持创建context之后, context需要支持事件, 暂时可不支持

    Browser browser();

    void resetPermissions() throws Exception;

    void grantPermissions(String origin, PermissionType... permissions) throws Exception;

    boolean isIncognito();

    /**
     * 等同于创建标签页
     */
    Page newPage() throws Exception;

    List<Page> pages() throws Exception;

}
