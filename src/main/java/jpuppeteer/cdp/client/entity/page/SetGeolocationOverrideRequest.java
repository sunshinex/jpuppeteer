package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetGeolocationOverrideRequest {

    /**
    * Mock latitude
    */
    private java.math.BigDecimal latitude;

    /**
    * Mock longitude
    */
    private java.math.BigDecimal longitude;

    /**
    * Mock accuracy
    */
    private java.math.BigDecimal accuracy;

    public void setLatitude (java.math.BigDecimal latitude) {
        this.latitude = latitude;
    }

    public java.math.BigDecimal getLatitude() {
        return this.latitude;
    }

    public void setLongitude (java.math.BigDecimal longitude) {
        this.longitude = longitude;
    }

    public java.math.BigDecimal getLongitude() {
        return this.longitude;
    }

    public void setAccuracy (java.math.BigDecimal accuracy) {
        this.accuracy = accuracy;
    }

    public java.math.BigDecimal getAccuracy() {
        return this.accuracy;
    }

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