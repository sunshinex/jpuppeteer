package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetScriptSourceRequest {

    /**
    * Id of the script to edit.
    */
    public final String scriptId;

    /**
    * New content of the script.
    */
    public final String scriptSource;

    /**
    * If true the change will not actually be applied. Dry run may be used to get result description without actually modifying the code.
    */
    public final Boolean dryRun;

    public SetScriptSourceRequest(String scriptId, String scriptSource, Boolean dryRun) {
        this.scriptId = scriptId;
        this.scriptSource = scriptSource;
        this.dryRun = dryRun;
    }

    public SetScriptSourceRequest(String scriptId, String scriptSource) {
        this.scriptId = scriptId;
        this.scriptSource = scriptSource;
        this.dryRun = null;
    }

}