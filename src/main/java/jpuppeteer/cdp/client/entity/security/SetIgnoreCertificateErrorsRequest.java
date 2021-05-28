package jpuppeteer.cdp.client.entity.security;

/**
*/
public class SetIgnoreCertificateErrorsRequest {

    /**
    * If true, all certificate errors will be ignored.
    */
    public final Boolean ignore;

    public SetIgnoreCertificateErrorsRequest(Boolean ignore) {
        this.ignore = ignore;
    }

}