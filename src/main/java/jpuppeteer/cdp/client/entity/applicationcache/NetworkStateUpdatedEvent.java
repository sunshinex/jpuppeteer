package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class NetworkStateUpdatedEvent {

    /**
    */
    private Boolean isNowOnline;

    public void setIsNowOnline (Boolean isNowOnline) {
        this.isNowOnline = isNowOnline;
    }

    public Boolean getIsNowOnline() {
        return this.isNowOnline;
    }

    public NetworkStateUpdatedEvent(Boolean isNowOnline) {
        this.isNowOnline = isNowOnline;
    }

    public NetworkStateUpdatedEvent() {
    }

}