package jpuppeteer.entity;

import jpuppeteer.cdp.TargetType;
import jpuppeteer.chrome.ChromeContext;
import jpuppeteer.chrome.ChromeFrame;

public class TargetBase {

    private String targetId;

    private TargetType type;

    private String title;

    private String url;

    private Boolean attached;

    private TargetBase opener;

    private Boolean canAccessOpener;

    private String openerFrameId;

    private ChromeContext browserContext;

    private ChromeFrame frame;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public TargetType getType() {
        return type;
    }

    public void setType(TargetType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getAttached() {
        return attached;
    }

    public void setAttached(Boolean attached) {
        this.attached = attached;
    }

    public TargetBase getOpener() {
        return opener;
    }

    public void setOpener(TargetBase opener) {
        this.opener = opener;
    }

    public Boolean getCanAccessOpener() {
        return canAccessOpener;
    }

    public void setCanAccessOpener(Boolean canAccessOpener) {
        this.canAccessOpener = canAccessOpener;
    }

    public String getOpenerFrameId() {
        return openerFrameId;
    }

    public void setOpenerFrameId(String openerFrameId) {
        this.openerFrameId = openerFrameId;
    }

    public ChromeContext getBrowserContext() {
        return browserContext;
    }

    public void setBrowserContext(ChromeContext browserContext) {
        this.browserContext = browserContext;
    }

    public ChromeFrame getFrame() {
        return frame;
    }

    public void setFrame(ChromeFrame frame) {
        this.frame = frame;
    }
}
