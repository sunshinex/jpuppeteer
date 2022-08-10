package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class SetDockTileRequest {

    /**
    */
    private String badgeLabel;

    /**
    * Png encoded image. (Encoded as a base64 string when passed over JSON)
    */
    private String image;

    public void setBadgeLabel (String badgeLabel) {
        this.badgeLabel = badgeLabel;
    }

    public String getBadgeLabel() {
        return this.badgeLabel;
    }

    public void setImage (String image) {
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }

    public SetDockTileRequest(String badgeLabel, String image) {
        this.badgeLabel = badgeLabel;
        this.image = image;
    }

    public SetDockTileRequest() {
        this.badgeLabel = null;
        this.image = null;
    }

}