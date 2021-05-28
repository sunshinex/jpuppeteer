package jpuppeteer.cdp.client.entity.console;

/**
* Issued when new console message is added.
*/
public class MessageAddedEvent {

    /**
    * Console message that has been added.
    */
    public final jpuppeteer.cdp.client.entity.console.ConsoleMessage message;

    public MessageAddedEvent(jpuppeteer.cdp.client.entity.console.ConsoleMessage message) {
        this.message = message;
    }

}