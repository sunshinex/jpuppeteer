package jpuppeteer.cdp.client.entity.layertree;

/**
* Serialized fragment of layer picture along with its offset within the layer.
* experimental
*/
public class PictureTile {

    /**
    * Offset from owning layer left boundary
    */
    private java.math.BigDecimal x;

    /**
    * Offset from owning layer top boundary
    */
    private java.math.BigDecimal y;

    /**
    * Base64-encoded snapshot data. (Encoded as a base64 string when passed over JSON)
    */
    private String picture;

    public void setX (java.math.BigDecimal x) {
        this.x = x;
    }

    public java.math.BigDecimal getX() {
        return this.x;
    }

    public void setY (java.math.BigDecimal y) {
        this.y = y;
    }

    public java.math.BigDecimal getY() {
        return this.y;
    }

    public void setPicture (String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return this.picture;
    }

    public PictureTile(java.math.BigDecimal x, java.math.BigDecimal y, String picture) {
        this.x = x;
        this.y = y;
        this.picture = picture;
    }

    public PictureTile() {
    }

}