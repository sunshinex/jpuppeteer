package jpuppeteer.cdp.client.entity.page;

/**
*/
public class AddScriptToEvaluateOnNewDocumentRequest {

    /**
    */
    private String source;

    /**
    * If specified, creates an isolated world with the given name and evaluates given script in it. This world name will be used as the ExecutionContextDescription::name when the corresponding event is emitted.
    */
    private String worldName;

    /**
    * Specifies whether command line API should be available to the script, defaults to false.
    */
    private Boolean includeCommandLineAPI;

    public void setSource (String source) {
        this.source = source;
    }

    public String getSource() {
        return this.source;
    }

    public void setWorldName (String worldName) {
        this.worldName = worldName;
    }

    public String getWorldName() {
        return this.worldName;
    }

    public void setIncludeCommandLineAPI (Boolean includeCommandLineAPI) {
        this.includeCommandLineAPI = includeCommandLineAPI;
    }

    public Boolean getIncludeCommandLineAPI() {
        return this.includeCommandLineAPI;
    }

    public AddScriptToEvaluateOnNewDocumentRequest(String source, String worldName, Boolean includeCommandLineAPI) {
        this.source = source;
        this.worldName = worldName;
        this.includeCommandLineAPI = includeCommandLineAPI;
    }

    public AddScriptToEvaluateOnNewDocumentRequest(String source) {
        this.source = source;
        this.worldName = null;
        this.includeCommandLineAPI = null;
    }

    public AddScriptToEvaluateOnNewDocumentRequest() {
    }

}