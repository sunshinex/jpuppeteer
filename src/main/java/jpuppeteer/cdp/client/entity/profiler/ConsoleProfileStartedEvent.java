package jpuppeteer.cdp.client.entity.profiler;

/**
* Sent when new profile recording is started using console.profile() call.
*/
public class ConsoleProfileStartedEvent {

    /**
    */
    private String id;

    /**
    * Location of console.profile().
    */
    private jpuppeteer.cdp.client.entity.debugger.Location location;

    /**
    * Profile title passed as an argument to console.profile().
    */
    private String title;

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setLocation (jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.location = location;
    }

    public jpuppeteer.cdp.client.entity.debugger.Location getLocation() {
        return this.location;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

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

    public ConsoleProfileStartedEvent() {
    }

}