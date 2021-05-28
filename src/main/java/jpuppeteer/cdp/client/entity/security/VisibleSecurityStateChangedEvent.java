package jpuppeteer.cdp.client.entity.security;

/**
* The security state of the page changed.
*/
public class VisibleSecurityStateChangedEvent {

    /**
    * Security state information about the page.
    */
    public final jpuppeteer.cdp.client.entity.security.VisibleSecurityState visibleSecurityState;

    public VisibleSecurityStateChangedEvent(jpuppeteer.cdp.client.entity.security.VisibleSecurityState visibleSecurityState) {
        this.visibleSecurityState = visibleSecurityState;
    }

}