package jpuppeteer.chrome.event.page;

import jpuppeteer.cdp.cdp.entity.log.LogEntry;
import jpuppeteer.chrome.ChromePage;

public class Console extends PageEvent {

    private final LogEntry entry;

    public Console(ChromePage page, LogEntry entry) {
        super(page);
        this.entry = entry;
    }

    public LogEntry entry() {
        return entry;
    }
}
