package jpuppeteer.cdp.client.entity.debugger;

/**
* Fired when virtual machine fails to parse the script.
*/
public class ScriptFailedToParseEvent {

    /**
    * Identifier of the script parsed.
    */
    private String scriptId;

    /**
    * URL or name of the script parsed (if any).
    */
    private String url;

    /**
    * Line offset of the script within the resource with given URL (for script tags).
    */
    private Integer startLine;

    /**
    * Column offset of the script within the resource with given URL.
    */
    private Integer startColumn;

    /**
    * Last line of the script.
    */
    private Integer endLine;

    /**
    * Length of the last line of the script.
    */
    private Integer endColumn;

    /**
    * Specifies script creation context.
    */
    private Integer executionContextId;

    /**
    * Content hash of the script.
    */
    private String hash;

    /**
    * Embedder-specific auxiliary data.
    */
    private java.util.Map<String, Object> executionContextAuxData;

    /**
    * URL of source map associated with script (if any).
    */
    private String sourceMapURL;

    /**
    * True, if this script has sourceURL.
    */
    private Boolean hasSourceURL;

    /**
    * True, if this script is ES6 module.
    */
    private Boolean isModule;

    /**
    * This script length.
    */
    private Integer length;

    /**
    * JavaScript top stack frame of where the script parsed event was triggered if available.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace;

    /**
    * If the scriptLanguage is WebAssembly, the code section offset in the module.
    */
    private Integer codeOffset;

    /**
    * The language of the script.
    */
    private jpuppeteer.cdp.client.constant.debugger.ScriptLanguage scriptLanguage;

    /**
    * The name the embedder supplied for this script.
    */
    private String embedderName;

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setStartLine (Integer startLine) {
        this.startLine = startLine;
    }

    public Integer getStartLine() {
        return this.startLine;
    }

    public void setStartColumn (Integer startColumn) {
        this.startColumn = startColumn;
    }

    public Integer getStartColumn() {
        return this.startColumn;
    }

    public void setEndLine (Integer endLine) {
        this.endLine = endLine;
    }

    public Integer getEndLine() {
        return this.endLine;
    }

    public void setEndColumn (Integer endColumn) {
        this.endColumn = endColumn;
    }

    public Integer getEndColumn() {
        return this.endColumn;
    }

    public void setExecutionContextId (Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public Integer getExecutionContextId() {
        return this.executionContextId;
    }

    public void setHash (String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return this.hash;
    }

    public void setExecutionContextAuxData (java.util.Map<String, Object> executionContextAuxData) {
        this.executionContextAuxData = executionContextAuxData;
    }

    public java.util.Map<String, Object> getExecutionContextAuxData() {
        return this.executionContextAuxData;
    }

    public void setSourceMapURL (String sourceMapURL) {
        this.sourceMapURL = sourceMapURL;
    }

    public String getSourceMapURL() {
        return this.sourceMapURL;
    }

    public void setHasSourceURL (Boolean hasSourceURL) {
        this.hasSourceURL = hasSourceURL;
    }

    public Boolean getHasSourceURL() {
        return this.hasSourceURL;
    }

    public void setIsModule (Boolean isModule) {
        this.isModule = isModule;
    }

    public Boolean getIsModule() {
        return this.isModule;
    }

    public void setLength (Integer length) {
        this.length = length;
    }

    public Integer getLength() {
        return this.length;
    }

    public void setStackTrace (jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace) {
        this.stackTrace = stackTrace;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTrace getStackTrace() {
        return this.stackTrace;
    }

    public void setCodeOffset (Integer codeOffset) {
        this.codeOffset = codeOffset;
    }

    public Integer getCodeOffset() {
        return this.codeOffset;
    }

    public void setScriptLanguage (jpuppeteer.cdp.client.constant.debugger.ScriptLanguage scriptLanguage) {
        this.scriptLanguage = scriptLanguage;
    }

    public jpuppeteer.cdp.client.constant.debugger.ScriptLanguage getScriptLanguage() {
        return this.scriptLanguage;
    }

    public void setEmbedderName (String embedderName) {
        this.embedderName = embedderName;
    }

    public String getEmbedderName() {
        return this.embedderName;
    }

    public ScriptFailedToParseEvent(String scriptId, String url, Integer startLine, Integer startColumn, Integer endLine, Integer endColumn, Integer executionContextId, String hash, java.util.Map<String, Object> executionContextAuxData, String sourceMapURL, Boolean hasSourceURL, Boolean isModule, Integer length, jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace, Integer codeOffset, jpuppeteer.cdp.client.constant.debugger.ScriptLanguage scriptLanguage, String embedderName) {
        this.scriptId = scriptId;
        this.url = url;
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
        this.executionContextId = executionContextId;
        this.hash = hash;
        this.executionContextAuxData = executionContextAuxData;
        this.sourceMapURL = sourceMapURL;
        this.hasSourceURL = hasSourceURL;
        this.isModule = isModule;
        this.length = length;
        this.stackTrace = stackTrace;
        this.codeOffset = codeOffset;
        this.scriptLanguage = scriptLanguage;
        this.embedderName = embedderName;
    }

    public ScriptFailedToParseEvent(String scriptId, String url, Integer startLine, Integer startColumn, Integer endLine, Integer endColumn, Integer executionContextId, String hash) {
        this.scriptId = scriptId;
        this.url = url;
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
        this.executionContextId = executionContextId;
        this.hash = hash;
        this.executionContextAuxData = null;
        this.sourceMapURL = null;
        this.hasSourceURL = null;
        this.isModule = null;
        this.length = null;
        this.stackTrace = null;
        this.codeOffset = null;
        this.scriptLanguage = null;
        this.embedderName = null;
    }

    public ScriptFailedToParseEvent() {
    }

}