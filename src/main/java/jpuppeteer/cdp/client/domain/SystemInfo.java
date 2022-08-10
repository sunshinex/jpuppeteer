package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class SystemInfo {

    private jpuppeteer.cdp.CDPConnection connection;

    public SystemInfo(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Returns information about the system.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.systeminfo.GetInfoResponse> getInfo() {
        return connection.send("SystemInfo.getInfo", null, jpuppeteer.cdp.client.entity.systeminfo.GetInfoResponse.class);
    }


    /**
    * Returns information about all running processes.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.systeminfo.GetProcessInfoResponse> getProcessInfo() {
        return connection.send("SystemInfo.getProcessInfo", null, jpuppeteer.cdp.client.entity.systeminfo.GetProcessInfoResponse.class);
    }

}