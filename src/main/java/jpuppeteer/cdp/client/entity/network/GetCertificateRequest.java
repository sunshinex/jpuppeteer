package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetCertificateRequest {

    /**
    * Origin to get certificate for.
    */
    public final String origin;

    public GetCertificateRequest(String origin) {
        this.origin = origin;
    }

}