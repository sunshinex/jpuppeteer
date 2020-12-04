package jpuppeteer.cdp.client.entity.security;

/**
*/
public class SetOverrideCertificateErrorsRequest {

    /**
    * If true, certificate errors will be overridden.
    */
    public final Boolean override;

    public SetOverrideCertificateErrorsRequest(Boolean override) {
        this.override = override;
    }

}