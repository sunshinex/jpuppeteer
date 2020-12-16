package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetGeolocationOverrideRequest {

    /**
    * Mock latitude
    */
    public final java.math.BigDecimal latitude;

    /**
    * Mock longitude
    */
    public final java.math.BigDecimal longitude;

    /**
    * Mock accuracy
    */
    public final java.math.BigDecimal accuracy;

    public SetGeolocationOverrideRequest(java.math.BigDecimal latitude, java.math.BigDecimal longitude, java.math.BigDecimal accuracy) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracy = accuracy;
    }

    public SetGeolocationOverrideRequest() {
        this.latitude = null;
        this.longitude = null;
        this.accuracy = null;
    }

}