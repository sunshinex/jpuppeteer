package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBlackboxPatternsRequest {

    /**
    * Array of regexps that will be used to check script url for blackbox state.
    */
    public final java.util.List<String> patterns;

    public SetBlackboxPatternsRequest(java.util.List<String> patterns) {
        this.patterns = patterns;
    }

}