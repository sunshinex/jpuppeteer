package jpuppeteer.cdp.client.entity.debugger;

/**
* Fired when virtual machine parses script. This event is also fired for all known and uncollected scripts upon enabling debugger.
*/
public class ScriptParsedEvent {

    /**
    * Identifier of the script parsed.
    */
    public final String scriptId;

    /**
    * URL or name of the script parsed (if any).
    */
    public final String url;

    /**
    * Line offset of the script within the resource with given URL (for script tags).
    */
    public final Integer startLine;

    /**
    * Column offset of the script within the resource with given URL.
    */
    public final Integer startColumn;

    /**
    * Last line of the script.
    */
    public final Integer endLine;

    /**
    * Length of the last line of the script.
    */
    public final Integer endColumn;

    /**
    * Specifies script creation context.
    */
    public final Integer executionContextId;

    /**
    * Content hash of the script.
    */
    public final String hash;

    /**
    * Embedder-specific auxiliary data.
    */
    public final java.util.Map<String, Object> executionContextAuxData;

    /**
    * True, if this script is generated as a result of the live edit operation.
    */
    public final Boolean isLiveEdit;

    /**
    * URL of source map associated with script (if any).
    */
    public final String sourceMapURL;

    /**
    * True, if this script has sourceURL.
    */
    public final Boolean hasSourceURL;

    /**
    * True, if this script is ES6 module.
    */
    public final Boolean isModule;

    /**
    * This script length.
    */
    public final Integer length;

    /**
    * JavaScript top stack frame of where the script parsed event was triggered if available.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace;

    /**
    * If the scriptLanguage is WebAssembly, the code section offset in the module.
    */
    public final Integer codeOffset;

    /**
    * The language of the script.
    */
    public final jpuppeteer.cdp.client.constant.debugger.ScriptLanguage scriptLanguage;

    /**
    * If the scriptLanguage is WebASsembly, the source of debug symbols for the module.
    */
    public final jpuppeteer.cdp.client.entity.debugger.DebugSymbols debugSymbols;

    /**
    * The name the embedder supplied for this script.
    */
    public final String embedderName;

    public ScriptParsedEvent(String scriptId, String url, Integer startLine, Integer startColumn, Integer endLine, Integer endColumn, Integer executionContextId, String hash, java.util.Map<String, Object> executionContextAuxData, Boolean isLiveEdit, String sourceMapURL, Boolean hasSourceURL, Boolean isModule, Integer length, jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace, Integer codeOffset, jpuppeteer.cdp.client.constant.debugger.ScriptLanguage scriptLanguage, jpuppeteer.cdp.client.entity.debugger.DebugSymbols debugSymbols, String embedderName) {
        this.scriptId = scriptId;
        this.url = url;
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
        this.executionContextId = executionContextId;
        this.hash = hash;
        this.executionContextAuxData = executionContextAuxData;
        this.isLiveEdit = isLiveEdit;
        this.sourceMapURL = sourceMapURL;
        this.hasSourceURL = hasSourceURL;
        this.isModule = isModule;
        this.length = length;
        this.stackTrace = stackTrace;
        this.codeOffset = codeOffset;
        this.scriptLanguage = scriptLanguage;
        this.debugSymbols = debugSymbols;
        this.embedderName = embedderName;
    }

    public ScriptParsedEvent(String scriptId, String url, Integer startLine, Integer startColumn, Integer endLine, Integer endColumn, Integer executionContextId, String hash) {
        this.scriptId = scriptId;
        this.url = url;
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
        this.executionContextId = executionContextId;
        this.hash = hash;
        this.executionContextAuxData = null;
        this.isLiveEdit = null;
        this.sourceMapURL = null;
        this.hasSourceURL = null;
        this.isModule = null;
        this.length = null;
        this.stackTrace = null;
        this.codeOffset = null;
        this.scriptLanguage = null;
        this.debugSymbols = null;
        this.embedderName = null;
    }

}