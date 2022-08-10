package jpuppeteer.cdp.client.entity.cast;

/**
* experimental
*/
public class Sink {

    /**
    */
    private String name;

    /**
    */
    private String id;

    /**
    * Text describing the current session. Present only if there is an active session on the sink.
    */
    private String session;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setSession (String session) {
        this.session = session;
    }

    public String getSession() {
        return this.session;
    }

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

    public Sink() {
    }

}