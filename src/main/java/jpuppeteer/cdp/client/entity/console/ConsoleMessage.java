package jpuppeteer.cdp.client.entity.console;

/**
* Console message.
*/
public class ConsoleMessage {

    /**
    * Message source.
    */
    private jpuppeteer.cdp.client.constant.console.ConsoleMessageSource source;

    /**
    * Message severity.
    */
    private jpuppeteer.cdp.client.constant.console.ConsoleMessageLevel level;

    /**
    * Message text.
    */
    private String text;

    /**
    * URL of the message origin.
    */
    private String url;

    /**
    * Line number in the resource that generated this message (1-based).
    */
    private Integer line;

    /**
    * Column number in the resource that generated this message (1-based).
    */
    private Integer column;

    public void setSource (jpuppeteer.cdp.client.constant.console.ConsoleMessageSource source) {
        this.source = source;
    }

    public jpuppeteer.cdp.client.constant.console.ConsoleMessageSource getSource() {
        return this.source;
    }

    public void setLevel (jpuppeteer.cdp.client.constant.console.ConsoleMessageLevel level) {
        this.level = level;
    }

    public jpuppeteer.cdp.client.constant.console.ConsoleMessageLevel getLevel() {
        return this.level;
    }

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setLine (Integer line) {
        this.line = line;
    }

    public Integer getLine() {
        return this.line;
    }

    public void setColumn (Integer column) {
        this.column = column;
    }

    public Integer getColumn() {
        return this.column;
    }

    public ConsoleMessage(jpuppeteer.cdp.client.constant.console.ConsoleMessageSource source, jpuppeteer.cdp.client.constant.console.ConsoleMessageLevel level, String text, String url, Integer line, Integer column) {
        this.source = source;
        this.level = level;
        this.text = text;
        this.url = url;
        this.line = line;
        this.column = column;
    }

    public ConsoleMessage(jpuppeteer.cdp.client.constant.console.ConsoleMessageSource source, jpuppeteer.cdp.client.constant.console.ConsoleMessageLevel level, String text) {
        this.source = source;
        this.level = level;
        this.text = text;
        this.url = null;
        this.line = null;
        this.column = null;
    }

    public ConsoleMessage() {
    }

}