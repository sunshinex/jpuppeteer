package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBlackboxPatternsRequest {

    /**
    * Array of regexps that will be used to check script url for blackbox state.
    */
    private java.util.List<String> patterns;

    public void setPatterns (java.util.List<String> patterns) {
        this.patterns = patterns;
    }

    public java.util.List<String> getPatterns() {
        return this.patterns;
    }

    public SetBlackboxPatternsRequest(java.util.List<String> patterns) {
        this.patterns = patterns;
    }

    public SetBlackboxPatternsRequest() {
    }

}