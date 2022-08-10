package jpuppeteer.cdp.client.entity.cast;

/**
* This is fired whenever the list of available sinks changes. A sink is a device or a software surface that you can cast to.
* experimental
*/
public class SinksUpdatedEvent {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.cast.Sink> sinks;

    public void setSinks (java.util.List<jpuppeteer.cdp.client.entity.cast.Sink> sinks) {
        this.sinks = sinks;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.cast.Sink> getSinks() {
        return this.sinks;
    }

    public SinksUpdatedEvent(java.util.List<jpuppeteer.cdp.client.entity.cast.Sink> sinks) {
        this.sinks = sinks;
    }

    public SinksUpdatedEvent() {
    }

}