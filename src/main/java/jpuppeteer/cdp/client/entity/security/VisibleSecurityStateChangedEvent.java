package jpuppeteer.cdp.client.entity.security;

/**
* The security state of the page changed.
*/
public class VisibleSecurityStateChangedEvent {

    /**
    * Security state information about the page.
    */
    public final VisibleSecurityState visibleSecurityState;

    public VisibleSecurityStateChangedEvent(VisibleSecurityState visibleSecurityState) {
        this.visibleSecurityState = visibleSecurityState;
    }

}