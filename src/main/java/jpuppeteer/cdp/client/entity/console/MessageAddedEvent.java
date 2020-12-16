package jpuppeteer.cdp.client.entity.console;

/**
* Issued when new console message is added.
*/
public class MessageAddedEvent {

    /**
    * Console message that has been added.
    */
    public final ConsoleMessage message;

    public MessageAddedEvent(ConsoleMessage message) {
        this.message = message;
    }

}