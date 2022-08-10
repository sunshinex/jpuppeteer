package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetCertificateRequest {

    /**
    * Origin to get certificate for.
    */
    private String origin;

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public GetCertificateRequest(String origin) {
        this.origin = origin;
    }

    public GetCertificateRequest() {
    }

}