package jpuppeteer.cdp.cdp.entity.dom;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
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



}