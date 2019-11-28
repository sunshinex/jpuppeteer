package jpuppeteer.api.browser;

import jpuppeteer.api.constant.PermissionType;

import java.util.List;

public interface BrowserContext {

    //TODO 后续支持创建context之后, context需要支持事件, 暂时可不支持

    <R extends Browser> R browser();

    void resetPermissions() throws Exception;

    void grantPermissions(String origin, PermissionType... permissions) throws Exception;

    boolean isIncognito();

    /**
     * 等同于创建标签页
     */
    <R extends Page> R newPage() throws Exception;

    <R extends Page> List<R> pages() throws Exception;

}
