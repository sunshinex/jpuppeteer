package jpuppeteer.cdp.client.entity.console;

/**
* Console message.
*/
public class ConsoleMessage {

    /**
    * Message source.
    */
    public final String source;

    /**
    * Message severity.
    */
    public final String level;

    /**
    * Message text.
    */
    public final String text;

    /**
    * URL of the message origin.
    */
    public final String url;

    /**
    * Line number in the resource that generated this message (1-based).
    */
    public final Integer line;

    /**
    * Column number in the resource that generated this message (1-based).
    */
    public final Integer column;

    public ConsoleMessage(String source, String level, String text, String url, Integer line, Integer column) {
        this.source = source;
        this.level = level;
        this.text = text;
        this.url = url;
        this.line = line;
        this.column = column;
    }

    public ConsoleMessage(String source, String level, String text) {
        this.source = source;
        this.level = level;
        this.text = text;
        this.url = null;
        this.line = null;
        this.column = null;
    }

}