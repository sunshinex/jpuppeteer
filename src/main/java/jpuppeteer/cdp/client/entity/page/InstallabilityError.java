package jpuppeteer.cdp.client.entity.page;

/**
* The installability error
*/
public class InstallabilityError {

    /**
    * The error id (e.g. 'manifest-missing-suitable-icon').
    */
    private String errorId;

    /**
    * The list of error arguments (e.g. {name:'minimum-icon-size-in-pixels', value:'64'}).
    */
    private java.util.List<jpuppeteer.cdp.client.entity.page.InstallabilityErrorArgument> errorArguments;

    public void setErrorId (String errorId) {
        this.errorId = errorId;
    }

    public String getErrorId() {
        return this.errorId;
    }

    public void setErrorArguments (java.util.List<jpuppeteer.cdp.client.entity.page.InstallabilityErrorArgument> errorArguments) {
        this.errorArguments = errorArguments;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.page.InstallabilityErrorArgument> getErrorArguments() {
        return this.errorArguments;
    }

    public InstallabilityError(String errorId, java.util.List<jpuppeteer.cdp.client.entity.page.InstallabilityErrorArgument> errorArguments) {
        this.errorId = errorId;
        this.errorArguments = errorArguments;
    }

    public InstallabilityError() {
    }

}