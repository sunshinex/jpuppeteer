package jpuppeteer.cdp.client.entity.page;

/**
* The installability error
*/
public class InstallabilityError {

    /**
    * The error id (e.g. 'manifest-missing-suitable-icon').
    */
    public final String errorId;

    /**
    * The list of error arguments (e.g. {name:'minimum-icon-size-in-pixels', value:'64'}).
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.page.InstallabilityErrorArgument> errorArguments;

    public InstallabilityError(String errorId, java.util.List<jpuppeteer.cdp.client.entity.page.InstallabilityErrorArgument> errorArguments) {
        this.errorId = errorId;
        this.errorArguments = errorArguments;
    }

}