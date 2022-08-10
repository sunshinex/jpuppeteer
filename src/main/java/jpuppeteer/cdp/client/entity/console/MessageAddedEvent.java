package jpuppeteer.cdp.client.entity.console;

/**
* Issued when new console message is added.
*/
public class MessageAddedEvent {

    /**
    * Console message that has been added.
    */
    private jpuppeteer.cdp.client.entity.console.ConsoleMessage message;

    public void setMessage (jpuppeteer.cdp.client.entity.console.ConsoleMessage message) {
        this.message = message;
    }

    public jpuppeteer.cdp.client.entity.console.ConsoleMessage getMessage() {
        return this.message;
    }

    public MessageAddedEvent(jpuppeteer.cdp.client.entity.console.ConsoleMessage message) {
        this.message = message;
    }

    public MessageAddedEvent() {
    }

}