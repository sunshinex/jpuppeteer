package jpuppeteer.cdp.client.entity.profiler;

/**
* Sent when new profile recording is started using console.profile() call.
*/
public class ConsoleProfileStartedEvent {

    /**
    */
    public final String id;

    /**
    * Location of console.profile().
    */
    public final jpuppeteer.cdp.client.entity.debugger.Location location;

    /**
    * Profile title passed as an argument to console.profile().
    */
    public final String title;

    public ConsoleProfileStartedEvent(String id, jpuppeteer.cdp.client.entity.debugger.Location location, String title) {
        this.id = id;
        this.location = location;
        this.title = title;
    }

    public ConsoleProfileStartedEvent(String id, jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.id = id;
        this.location = location;
        this.title = null;
    }

}