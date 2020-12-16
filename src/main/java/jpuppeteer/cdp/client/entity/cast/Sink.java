package jpuppeteer.cdp.client.entity.cast;

/**
* experimental
*/
public class Sink {

    /**
    */
    public final String name;

    /**
    */
    public final String id;

    /**
    * Text describing the current session. Present only if there is an active session on the sink.
    */
    public final String session;

    public Sink(String name, String id, String session) {
        this.name = name;
        this.id = id;
        this.session = session;
    }

    public Sink(String name, String id) {
        this.name = name;
        this.id = id;
        this.session = null;
    }

}