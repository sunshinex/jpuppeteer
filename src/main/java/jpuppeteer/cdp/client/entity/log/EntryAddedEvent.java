package jpuppeteer.cdp.client.entity.log;

/**
* Issued when new message was logged.
*/
public class EntryAddedEvent {

    /**
    * The entry.
    */
    private jpuppeteer.cdp.client.entity.log.LogEntry entry;

    public void setEntry (jpuppeteer.cdp.client.entity.log.LogEntry entry) {
        this.entry = entry;
    }

    public jpuppeteer.cdp.client.entity.log.LogEntry getEntry() {
        return this.entry;
    }

    public EntryAddedEvent(jpuppeteer.cdp.client.entity.log.LogEntry entry) {
        this.entry = entry;
    }

    public EntryAddedEvent() {
    }

}