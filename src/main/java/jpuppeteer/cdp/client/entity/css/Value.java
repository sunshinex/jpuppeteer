package jpuppeteer.cdp.client.entity.css;

/**
* Data for a simple selector (these are delimited by commas in a selector list).
* experimental
*/
public class Value {

    /**
    * Value text.
    */
    private String text;

    /**
    * Value range in the underlying resource (if available).
    */
    private jpuppeteer.cdp.client.entity.css.SourceRange range;

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setRange (jpuppeteer.cdp.client.entity.css.SourceRange range) {
        this.range = range;
    }

    public jpuppeteer.cdp.client.entity.css.SourceRange getRange() {
        return this.range;
    }

    public Value(String text, jpuppeteer.cdp.client.entity.css.SourceRange range) {
        this.text = text;
        this.range = range;
    }

    public Value(String text) {
        this.text = text;
        this.range = null;
    }

    public Value() {
    }

}