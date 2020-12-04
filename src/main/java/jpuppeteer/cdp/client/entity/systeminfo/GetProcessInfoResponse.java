package jpuppeteer.cdp.client.entity.systeminfo;

/**
* experimental
*/
public class GetProcessInfoResponse {

    /**
    * An array of process info blocks.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.systeminfo.ProcessInfo> processInfo;

    public GetProcessInfoResponse(java.util.List<jpuppeteer.cdp.client.entity.systeminfo.ProcessInfo> processInfo) {
        this.processInfo = processInfo;
    }

}