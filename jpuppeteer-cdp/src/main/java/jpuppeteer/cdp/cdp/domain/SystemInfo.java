package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.systeminfo.GetInfoResponse getInfo(int timeout) throws Exception {
        return session.send("SystemInfo.getInfo", null, jpuppeteer.cdp.cdp.entity.systeminfo.GetInfoResponse.class, timeout);
    }


    /**
    * Returns information about all running processes.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.systeminfo.GetProcessInfoResponse getProcessInfo(int timeout) throws Exception {
        return session.send("SystemInfo.getProcessInfo", null, jpuppeteer.cdp.cdp.entity.systeminfo.GetProcessInfoResponse.class, timeout);
    }

}