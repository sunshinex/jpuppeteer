package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.api.DownloadListener;
import jpuppeteer.api.DownloadObject;
import jpuppeteer.api.Page;
import jpuppeteer.cdp.client.constant.browser.PermissionType;
import jpuppeteer.cdp.client.constant.browser.SetDownloadBehaviorRequestBehavior;
import jpuppeteer.cdp.client.entity.browser.CancelDownloadRequest;
import jpuppeteer.cdp.client.entity.browser.GrantPermissionsRequest;
import jpuppeteer.cdp.client.entity.browser.ResetPermissionsRequest;
import jpuppeteer.cdp.client.entity.browser.SetDownloadBehaviorRequest;
import jpuppeteer.cdp.client.entity.network.Cookie;
import jpuppeteer.cdp.client.entity.network.CookieParam;
import jpuppeteer.cdp.client.entity.storage.ClearCookiesRequest;
import jpuppeteer.cdp.client.entity.storage.GetCookiesRequest;
import jpuppeteer.cdp.client.entity.storage.SetCookiesRequest;
import jpuppeteer.cdp.client.entity.target.CloseTargetRequest;
import jpuppeteer.cdp.client.entity.target.CreateTargetRequest;
import jpuppeteer.cdp.client.entity.target.DisposeBrowserContextRequest;
import jpuppeteer.cdp.client.entity.target.TargetInfo;
import jpuppeteer.util.XFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ChromeContext implements BrowserContext {

    private static final Logger logger = LoggerFactory.getLogger(ChromeContext.class);

    private final ChromeBrowser browser;

    private final String browserContextId;

    private volatile DownloadListener downloadListener;

    public ChromeContext(ChromeBrowser browser, String browserContextId) {
        this.browser = browser;
        this.browserContextId = browserContextId;
    }

    private XFuture<?> setDownloadBehavior(SetDownloadBehaviorRequest request) {
        return this.browser().connection().browser.setDownloadBehavior(request);
    }

    protected void onDownloadStart(DownloadObject downloadObject) {
        DownloadListener listener = this.downloadListener;
        if (listener == null) {
            return;
        }
        listener.onStart(downloadObject);
    }

    protected void onDownloadProgress(DownloadObject downloadObject) {
        DownloadListener listener = this.downloadListener;
        if (listener == null) {
            return;
        }
        switch (downloadObject.state()) {

            case INPROGRESS:
                listener.onProgress(downloadObject);
                break;

            case COMPLETED:
                listener.onComplete(downloadObject);
                break;

            case CANCELED:
                listener.onCancel(downloadObject);
                break;
        }
    }

    @Override
    public String browserContextId() {
        return browserContextId;
    }

    @Override
    public ChromeBrowser browser() {
        return browser;
    }

    @Override
    public XFuture<?> grantPermissions(String origin, PermissionType... permissions) {
        GrantPermissionsRequest request = new GrantPermissionsRequest(Lists.newArrayList(permissions), origin, browserContextId());
        return browser().connection().browser.grantPermissions(request);
    }

    @Override
    public XFuture<?> resetPermissions() {
        ResetPermissionsRequest request = new ResetPermissionsRequest(browserContextId());
        return browser().connection().browser.resetPermissions(request);
    }

    @Override
    public XFuture<Page> newPage(String url, Integer width, Integer height) {
        CreateTargetRequest request = new CreateTargetRequest(
                url, width, height, browserContextId(),
                null, null, true);
        return browser().connection().target.createTarget(request)
                .async(o -> {
                    TargetInfo targetInfo = new TargetInfo(
                            o.getTargetId(), "page", "", url,
                            false, false
                    );
                    ChromePage page = new ChromePage(this, targetInfo);
                    return page.attach().addListener(f0 -> {
                        if (!f0.isSuccess()) {
                            browser().connection().target.closeTarget(new CloseTargetRequest(o.getTargetId()))
                                    .addListener(f1 -> {
                                        if (!f1.isSuccess()) {
                                            logger.warn("attach failed and close target failed, targetId={}", o.getTargetId(), f1.cause());
                                        }
                                    });
                        }
                    });
                });
    }

    @Override
    public XFuture<?> setCookies(CookieParam... cookies) {
        SetCookiesRequest request = new SetCookiesRequest(Lists.newArrayList(cookies), browserContextId());
        return browser().connection().storage.setCookies(request);
    }

    @Override
    public XFuture<?> clearCookies() {
        ClearCookiesRequest request = new ClearCookiesRequest(browserContextId());
        return browser().connection().storage.clearCookies(request);
    }

    @Override
    public XFuture<Cookie[]> getCookies() {
        return browser().connection().storage.getCookies(new GetCookiesRequest(browserContextId()))
                .sync(o -> {
                    Cookie[] cookies = new Cookie[o.getCookies().size()];
                    o.getCookies().toArray(cookies);
                    return cookies;
                });
    }

    @Override
    public XFuture<?> enableDownloader(String downloadPath, DownloadListener downloadListener) {
        SetDownloadBehaviorRequest request = new SetDownloadBehaviorRequest();
        request.setBrowserContextId(browserContextId());
        request.setBehavior(SetDownloadBehaviorRequestBehavior.ALLOW);
        request.setEventsEnabled(true);
        request.setDownloadPath(downloadPath);
        this.downloadListener = downloadListener;
        return setDownloadBehavior(request);
    }

    @Override
    public XFuture<?> disableDownloader() {
        SetDownloadBehaviorRequest request = new SetDownloadBehaviorRequest();
        request.setBrowserContextId(browserContextId());
        request.setBehavior(SetDownloadBehaviorRequestBehavior.DENY);
        this.downloadListener = null;
        return setDownloadBehavior(request);
    }

    @Override
    public XFuture<?> cancelDownload(String guid) {
        CancelDownloadRequest request = new CancelDownloadRequest();
        request.setBrowserContextId(browserContextId());
        request.setGuid(guid);
        return this.browser().connection().browser.cancelDownload(request);
    }

    @Override
    public void close() {
        try {
            DisposeBrowserContextRequest request = new DisposeBrowserContextRequest(browserContextId());
            browser().connection().target.disposeBrowserContext(request).get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new RuntimeException("close context failed", e);
        }
    }

}
