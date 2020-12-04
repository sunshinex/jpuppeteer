package jpuppeteer.cdp.client.entity.log;

/**
* Issued when new message was logged.
*/
public class EntryAddedEvent {

    /**
    * The entry.
    */
    public final jpuppeteer.cdp.client.entity.log.LogEntry entry;

    public EntryAddedEvent(jpuppeteer.cdp.client.entity.log.LogEntry entry) {
        this.entry = entry;
    }

}