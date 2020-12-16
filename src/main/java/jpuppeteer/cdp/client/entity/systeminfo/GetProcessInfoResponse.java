package jpuppeteer.cdp.client.entity.systeminfo;

/**
* experimental
*/
public class GetProcessInfoResponse {

    /**
    * An array of process info blocks.
    */
    public final java.util.List<ProcessInfo> processInfo;

    public GetProcessInfoResponse(java.util.List<ProcessInfo> processInfo) {
        this.processInfo = processInfo;
    }

}