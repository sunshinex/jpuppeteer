package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetNodeForLocationRequest {

    /**
    * X coordinate.
    */
    private Integer x;

    /**
    * Y coordinate.
    */
    private Integer y;

    /**
    * False to skip to the nearest non-UA shadow root ancestor (default: false).
    */
    private Boolean includeUserAgentShadowDOM;

    /**
    * Whether to ignore pointer-events: none on elements and hit test them.
    */
    private Boolean ignorePointerEventsNone;

    public void setX (Integer x) {
        this.x = x;
    }

    public Integer getX() {
        return this.x;
    }

    public void setY (Integer y) {
        this.y = y;
    }

    public Integer getY() {
        return this.y;
    }

    public void setIncludeUserAgentShadowDOM (Boolean includeUserAgentShadowDOM) {
        this.includeUserAgentShadowDOM = includeUserAgentShadowDOM;
    }

    public Boolean getIncludeUserAgentShadowDOM() {
        return this.includeUserAgentShadowDOM;
    }

    public void setIgnorePointerEventsNone (Boolean ignorePointerEventsNone) {
        this.ignorePointerEventsNone = ignorePointerEventsNone;
    }

    public Boolean getIgnorePointerEventsNone() {
        return this.ignorePointerEventsNone;
    }

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

    public GetNodeForLocationRequest() {
    }

}