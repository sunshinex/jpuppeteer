package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class ConsoleProfileFinishedEvent {

    /**
    */
    public final String id;

    /**
    * Location of console.profileEnd().
    */
    public final jpuppeteer.cdp.client.entity.debugger.Location location;

    /**
    */
    public final Profile profile;

    /**
    * Profile title passed as an argument to console.profile().
    */
    public final String title;

    public ConsoleProfileFinishedEvent(String id, jpuppeteer.cdp.client.entity.debugger.Location location, Profile profile, String title) {
        this.id = id;
        this.location = location;
        this.profile = profile;
        this.title = title;
    }

    public ConsoleProfileFinishedEvent(String id, jpuppeteer.cdp.client.entity.debugger.Location location, Profile profile) {
        this.id = id;
        this.location = location;
        this.profile = profile;
        this.title = null;
    }

}