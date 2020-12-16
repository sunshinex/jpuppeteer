package jpuppeteer.cdp.client.entity.log;

/**
* Issued when new message was logged.
*/
public class EntryAddedEvent {

    /**
    * The entry.
    */
    public final LogEntry entry;

    public EntryAddedEvent(LogEntry entry) {
        this.entry = entry;
    }

}