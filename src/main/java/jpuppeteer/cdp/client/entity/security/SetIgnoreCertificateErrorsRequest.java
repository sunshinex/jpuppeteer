package jpuppeteer.cdp.client.entity.security;

/**
*/
public class SetIgnoreCertificateErrorsRequest {

    /**
    * If true, all certificate errors will be ignored.
    */
    private Boolean ignore;

    public void setIgnore (Boolean ignore) {
        this.ignore = ignore;
    }

    public Boolean getIgnore() {
        return this.ignore;
    }

    public SetIgnoreCertificateErrorsRequest(Boolean ignore) {
        this.ignore = ignore;
    }

    public SetIgnoreCertificateErrorsRequest() {
    }

}