package jpuppeteer.cdp.client.entity.page;

/**
*/
public class AddScriptToEvaluateOnNewDocumentRequest {

    /**
    */
    public final String source;

    /**
    * If specified, creates an isolated world with the given name and evaluates given script in it. This world name will be used as the ExecutionContextDescription::name when the corresponding event is emitted.
    */
    public final String worldName;

    /**
    * Specifies whether command line API should be available to the script, defaults to false.
    */
    public final Boolean includeCommandLineAPI;

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

}