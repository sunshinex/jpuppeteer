package jpuppeteer.cdp.client.entity.layertree;

/**
* Serialized fragment of layer picture along with its offset within the layer.
* experimental
*/
public class PictureTile {

    /**
    * Offset from owning layer left boundary
    */
    public final java.math.BigDecimal x;

    /**
    * Offset from owning layer top boundary
    */
    public final java.math.BigDecimal y;

    /**
    * Base64-encoded snapshot data.
    */
    public final String picture;

    public PictureTile(java.math.BigDecimal x, java.math.BigDecimal y, String picture) {
        this.x = x;
        this.y = y;
        this.picture = picture;
    }

}