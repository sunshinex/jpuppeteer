package jpuppeteer.api.event.page;

import jpuppeteer.api.Page;
import jpuppeteer.api.event.PageEvent;

public class CreatedEvent extends PageEvent {

    private final Page page;

    public CreatedEvent(Page page) {
        this.page = page;
    }

    public Page page() {
        return page;
    }
}
