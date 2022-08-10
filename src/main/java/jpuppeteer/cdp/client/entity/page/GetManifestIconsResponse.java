package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetManifestIconsResponse {

    /**
    */
    private String primaryIcon;

    public void setPrimaryIcon (String primaryIcon) {
        this.primaryIcon = primaryIcon;
    }

    public String getPrimaryIcon() {
        return this.primaryIcon;
    }

    public GetManifestIconsResponse(String primaryIcon) {
        this.primaryIcon = primaryIcon;
    }

    public GetManifestIconsResponse() {
        this.primaryIcon = null;
    }

}