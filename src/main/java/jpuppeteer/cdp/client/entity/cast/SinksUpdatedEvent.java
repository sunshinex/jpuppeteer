package jpuppeteer.cdp.client.entity.cast;

/**
* This is fired whenever the list of available sinks changes. A sink is a device or a software surface that you can cast to.
* experimental
*/
public class SinksUpdatedEvent {

    /**
    */
    public final java.util.List<Sink> sinks;

    public SinksUpdatedEvent(java.util.List<Sink> sinks) {
        this.sinks = sinks;
    }

}