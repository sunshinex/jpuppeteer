package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetInstallabilityErrorsResponse {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.page.InstallabilityError> installabilityErrors;

    public void setInstallabilityErrors (java.util.List<jpuppeteer.cdp.client.entity.page.InstallabilityError> installabilityErrors) {
        this.installabilityErrors = installabilityErrors;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.page.InstallabilityError> getInstallabilityErrors() {
        return this.installabilityErrors;
    }

    public GetInstallabilityErrorsResponse(java.util.List<jpuppeteer.cdp.client.entity.page.InstallabilityError> installabilityErrors) {
        this.installabilityErrors = installabilityErrors;
    }

    public GetInstallabilityErrorsResponse() {
    }

}