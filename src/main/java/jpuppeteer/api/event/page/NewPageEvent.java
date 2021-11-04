package jpuppeteer.api.event.page;

import jpuppeteer.api.Page;
import jpuppeteer.api.event.PageEvent;
import jpuppeteer.chrome.ChromePage;

/**
 * 此事件用于打开的新页面
 */
public class NewPageEvent extends PageEvent {

    private final ChromePage page;

    public NewPageEvent(ChromePage page) {
        this.page = page;
    }

    public Page page() {
        page.attach();
        return page;
    }
}
