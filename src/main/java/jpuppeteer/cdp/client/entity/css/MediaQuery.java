package jpuppeteer.cdp.client.entity.css;

/**
* Media query descriptor.
* experimental
*/
public class MediaQuery {

    /**
    * Array of media query expressions.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.MediaQueryExpression> expressions;

    /**
    * Whether the media query condition is satisfied.
    */
    private Boolean active;

    public void setExpressions (java.util.List<jpuppeteer.cdp.client.entity.css.MediaQueryExpression> expressions) {
        this.expressions = expressions;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.MediaQueryExpression> getExpressions() {
        return this.expressions;
    }

    public void setActive (Boolean active) {
        this.active = active;
    }

    public Boolean getActive() {
        return this.active;
    }

    public MediaQuery(java.util.List<jpuppeteer.cdp.client.entity.css.MediaQueryExpression> expressions, Boolean active) {
        this.expressions = expressions;
        this.active = active;
    }

    public MediaQuery() {
    }

}