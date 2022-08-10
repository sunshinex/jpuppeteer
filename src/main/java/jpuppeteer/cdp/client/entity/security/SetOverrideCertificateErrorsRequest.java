package jpuppeteer.cdp.client.entity.security;

/**
*/
public class SetOverrideCertificateErrorsRequest {

    /**
    * If true, certificate errors will be overridden.
    */
    private Boolean override;

    public void setOverride (Boolean override) {
        this.override = override;
    }

    public Boolean getOverride() {
        return this.override;
    }

    public SetOverrideCertificateErrorsRequest(Boolean override) {
        this.override = override;
    }

    public SetOverrideCertificateErrorsRequest() {
    }

}