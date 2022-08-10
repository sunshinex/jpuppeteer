package jpuppeteer.cdp.client.entity.systeminfo;

/**
* experimental
*/
public class GetProcessInfoResponse {

    /**
    * An array of process info blocks.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.systeminfo.ProcessInfo> processInfo;

    public void setProcessInfo (java.util.List<jpuppeteer.cdp.client.entity.systeminfo.ProcessInfo> processInfo) {
        this.processInfo = processInfo;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.systeminfo.ProcessInfo> getProcessInfo() {
        return this.processInfo;
    }

    public GetProcessInfoResponse(java.util.List<jpuppeteer.cdp.client.entity.systeminfo.ProcessInfo> processInfo) {
        this.processInfo = processInfo;
    }

    public GetProcessInfoResponse() {
    }

}