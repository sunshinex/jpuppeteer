package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when object should be inspected (for example, as a result of inspect() command line API call).
*/
public class InspectRequestedEvent {

    /**
    */
    public final RemoteObject object;

    /**
    */
    public final java.util.Map<String, Object> hints;

    public InspectRequestedEvent(RemoteObject object, java.util.Map<String, Object> hints) {
        this.object = object;
        this.hints = hints;
    }

}