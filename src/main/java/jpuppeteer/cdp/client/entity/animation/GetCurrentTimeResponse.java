package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class GetCurrentTimeResponse {

    /**
    * Current time of the page.
    */
    public final java.math.BigDecimal currentTime;

    public GetCurrentTimeResponse(java.math.BigDecimal currentTime) {
        this.currentTime = currentTime;
    }

}