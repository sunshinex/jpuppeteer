package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetBrowserCommandLineResponse {

    /**
    * Commandline parameters
    */
    private java.util.List<String> arguments;

    public void setArguments (java.util.List<String> arguments) {
        this.arguments = arguments;
    }

    public java.util.List<String> getArguments() {
        return this.arguments;
    }

    public GetBrowserCommandLineResponse(java.util.List<String> arguments) {
        this.arguments = arguments;
    }

    public GetBrowserCommandLineResponse() {
    }

}