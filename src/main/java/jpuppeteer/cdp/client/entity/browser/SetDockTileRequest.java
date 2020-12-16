package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class SetDockTileRequest {

    /**
    */
    public final String badgeLabel;

    /**
    * Png encoded image.
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