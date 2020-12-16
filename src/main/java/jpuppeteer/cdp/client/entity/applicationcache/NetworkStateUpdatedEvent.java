package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class NetworkStateUpdatedEvent {

    /**
    */
    public final Boolean isNowOnline;

    public NetworkStateUpdatedEvent(Boolean isNowOnline) {
        this.isNowOnline = isNowOnline;
    }

}