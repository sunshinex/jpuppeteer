package jpuppeteer.cdp.client.entity.security;

/**
* The security state of the page changed.
*/
public class VisibleSecurityStateChangedEvent {

    /**
    * Security state information about the page.
    */
    private jpuppeteer.cdp.client.entity.security.VisibleSecurityState visibleSecurityState;

    public void setVisibleSecurityState (jpuppeteer.cdp.client.entity.security.VisibleSecurityState visibleSecurityState) {
        this.visibleSecurityState = visibleSecurityState;
    }

    public jpuppeteer.cdp.client.entity.security.VisibleSecurityState getVisibleSecurityState() {
        return this.visibleSecurityState;
    }

    public VisibleSecurityStateChangedEvent(jpuppeteer.cdp.client.entity.security.VisibleSecurityState visibleSecurityState) {
        this.visibleSecurityState = visibleSecurityState;
    }

    public VisibleSecurityStateChangedEvent() {
    }

}