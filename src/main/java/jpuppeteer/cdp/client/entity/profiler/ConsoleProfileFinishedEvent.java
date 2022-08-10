package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class ConsoleProfileFinishedEvent {

    /**
    */
    private String id;

    /**
    * Location of console.profileEnd().
    */
    private jpuppeteer.cdp.client.entity.debugger.Location location;

    /**
    */
    private jpuppeteer.cdp.client.entity.profiler.Profile profile;

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

    public void setProfile (jpuppeteer.cdp.client.entity.profiler.Profile profile) {
        this.profile = profile;
    }

    public jpuppeteer.cdp.client.entity.profiler.Profile getProfile() {
        return this.profile;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public ConsoleProfileFinishedEvent(String id, jpuppeteer.cdp.client.entity.debugger.Location location, jpuppeteer.cdp.client.entity.profiler.Profile profile, String title) {
        this.id = id;
        this.location = location;
        this.profile = profile;
        this.title = title;
    }

    public ConsoleProfileFinishedEvent(String id, jpuppeteer.cdp.client.entity.debugger.Location location, jpuppeteer.cdp.client.entity.profiler.Profile profile) {
        this.id = id;
        this.location = location;
        this.profile = profile;
        this.title = null;
    }

    public ConsoleProfileFinishedEvent() {
    }

}