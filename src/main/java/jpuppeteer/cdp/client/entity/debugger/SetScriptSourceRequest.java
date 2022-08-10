package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetScriptSourceRequest {

    /**
    * Id of the script to edit.
    */
    private String scriptId;

    /**
    * New content of the script.
    */
    private String scriptSource;

    /**
    * If true the change will not actually be applied. Dry run may be used to get result description without actually modifying the code.
    */
    private Boolean dryRun;

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
    }

    public void setScriptSource (String scriptSource) {
        this.scriptSource = scriptSource;
    }

    public String getScriptSource() {
        return this.scriptSource;
    }

    public void setDryRun (Boolean dryRun) {
        this.dryRun = dryRun;
    }

    public Boolean getDryRun() {
        return this.dryRun;
    }

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

    public SetScriptSourceRequest() {
    }

}