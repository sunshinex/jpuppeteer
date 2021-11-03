package jpuppeteer.api.event.page;

import jpuppeteer.api.Page;
import jpuppeteer.api.event.PageEvent;
import jpuppeteer.chrome.ChromePage;
import jpuppeteer.entity.TargetBase;

/**
 * 此事件用于打开的新
 */
public class NewPageEvent extends PageEvent {

    private final TargetBase targetBase;

    public NewPageEvent(TargetBase targetBase) {
        this.targetBase = targetBase;
    }

    public Page page() {
        return new ChromePage(targetBase.getBrowserContext(), targetBase);
    }
}
