package jpuppeteer.cdp.client.entity.css;

/**
* Data for a simple selector (these are delimited by commas in a selector list).
* experimental
*/
public class Value {

    /**
    * Value text.
    */
    public final String text;

    /**
    * Value range in the underlying resource (if available).
    */
    public final SourceRange range;

    public Value(String text, SourceRange range) {
        this.text = text;
        this.range = range;
    }

    public Value(String text) {
        this.text = text;
        this.range = null;
    }

}