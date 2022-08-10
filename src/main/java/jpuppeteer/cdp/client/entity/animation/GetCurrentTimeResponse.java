package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class GetCurrentTimeResponse {

    /**
    * Current time of the page.
    */
    private java.math.BigDecimal currentTime;

    public void setCurrentTime (java.math.BigDecimal currentTime) {
        this.currentTime = currentTime;
    }

    public java.math.BigDecimal getCurrentTime() {
        return this.currentTime;
    }

    public GetCurrentTimeResponse(java.math.BigDecimal currentTime) {
        this.currentTime = currentTime;
    }

    public GetCurrentTimeResponse() {
    }

}