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

    public AddScriptToEvaluateOnNewDocumentRequest(String source, String worldName) {
        this.source = source;
        this.worldName = worldName;
    }

    public AddScriptToEvaluateOnNewDocumentRequest(String source) {
        this.source = source;
        this.worldName = null;
    }

}