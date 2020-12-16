package jpuppeteer.cdp.client.entity.css;

/**
* Media query descriptor.
* experimental
*/
public class MediaQuery {

    /**
    * Array of media query expressions.
    */
    public final java.util.List<MediaQueryExpression> expressions;

    /**
    * Whether the media query condition is satisfied.
    */
    public final Boolean active;

    public MediaQuery(java.util.List<MediaQueryExpression> expressions, Boolean active) {
        this.expressions = expressions;
        this.active = active;
    }

}