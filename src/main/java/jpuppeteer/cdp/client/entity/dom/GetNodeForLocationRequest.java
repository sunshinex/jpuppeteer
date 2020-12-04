package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetNodeForLocationRequest {

    /**
    * X coordinate.
    */
    public final Integer x;

    /**
    * Y coordinate.
    */
    public final Integer y;

    /**
    * False to skip to the nearest non-UA shadow root ancestor (default: false).
    */
    public final Boolean includeUserAgentShadowDOM;

    /**
    * Whether to ignore pointer-events: none on elements and hit test them.
    */
    public final Boolean ignorePointerEventsNone;

    public GetNodeForLocationRequest(Integer x, Integer y, Boolean includeUserAgentShadowDOM, Boolean ignorePointerEventsNone) {
        this.x = x;
        this.y = y;
        this.includeUserAgentShadowDOM = includeUserAgentShadowDOM;
        this.ignorePointerEventsNone = ignorePointerEventsNone;
    }

    public GetNodeForLocationRequest(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.includeUserAgentShadowDOM = null;
        this.ignorePointerEventsNone = null;
    }

}