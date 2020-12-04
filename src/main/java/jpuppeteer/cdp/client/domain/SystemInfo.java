package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class SystemInfo {

    private jpuppeteer.cdp.CDPSession session;

    public SystemInfo(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Returns information about the system.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.systeminfo.GetInfoResponse> getInfo() {
        return session.send("SystemInfo.getInfo", null, jpuppeteer.cdp.client.entity.systeminfo.GetInfoResponse.class);
    }


    /**
    * Returns information about all running processes.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.systeminfo.GetProcessInfoResponse> getProcessInfo() {
        return session.send("SystemInfo.getProcessInfo", null, jpuppeteer.cdp.client.entity.systeminfo.GetProcessInfoResponse.class);
    }

}