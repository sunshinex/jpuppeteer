package jpuppeteer.chrome.event.type;

import jpuppeteer.cdp.cdp.entity.log.LogEntry;
import jpuppeteer.cdp.cdp.entity.page.LifecycleEvent;
import jpuppeteer.cdp.cdp.entity.runtime.ExceptionThrownEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetCrashedEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetInfo;
import jpuppeteer.chrome.ChromeFrame;
import jpuppeteer.chrome.ChromePage;
import jpuppeteer.chrome.event.*;

public enum ChromePageEvent {

    CHANGED(TargetInfo.class),

    CRASHED(TargetCrashedEvent.class),

    FRAMEATTACHED(ChromeFrame.class),

    FRAMEDETACHED(ChromeFrame.class),

    FRAMENAVIGATED(ChromeFrame.class),

    LIFECYCLEEVENT(LifecycleEvent.class),

    DOMCONTENTLOADED(Double.class),

    LOAD(Double.class),

    CONSOLE(LogEntry.class),

    DIALOG(Dialog.class),

    OPENPAGE(ChromePage.class),

    PAGEERROR(ExceptionThrownEvent.class),

    REQUEST(Request.class),

    RESPONSE(Response.class),

    REQUESTFAILED(RequestFailed.class),

    REQUESTFINISHED(RequestFinished.class),

    ;

    private Class clazz;

    ChromePageEvent(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }
}
