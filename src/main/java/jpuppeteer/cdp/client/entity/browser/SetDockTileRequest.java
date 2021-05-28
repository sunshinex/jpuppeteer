package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class SetDockTileRequest {

    /**
    */
    public final String badgeLabel;

    /**
    * Png encoded image. (Encoded as a base64 string when passed over JSON)
    */
    public final String image;

    public SetDockTileRequest(String badgeLabel, String image) {
        this.badgeLabel = badgeLabel;
        this.image = image;
    }

    public SetDockTileRequest() {
        this.badgeLabel = null;
        this.image = null;
    }

}