package jpuppeteer.chrome.event.type;

import jpuppeteer.cdp.cdp.entity.log.EntryAddedEvent;
import jpuppeteer.cdp.cdp.entity.log.LogEntry;
import jpuppeteer.cdp.cdp.entity.page.DomContentEventFiredEvent;
import jpuppeteer.cdp.cdp.entity.page.LoadEventFiredEvent;
import jpuppeteer.cdp.cdp.entity.runtime.ExceptionThrownEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetCrashedEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetDestroyedEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetInfo;
import jpuppeteer.chrome.*;
import jpuppeteer.chrome.event.Dialog;

public enum ChromePageEvent {

    CHANGED(TargetInfo.class),

    CRASHED(TargetCrashedEvent.class),

    CLOSED(TargetDestroyedEvent.class),

    DOMCONTENTLOADED(Double.class),

    LOAD(Double.class),

    CONSOLE(LogEntry.class),

    DIALOG(Dialog.class),

    OPENPAGE(ChromePage.class),

    PAGEERROR(ExceptionThrownEvent.class),

    REQUEST(ChromeRequest .class),

    RESPONSE(ChromeResponse .class),

    REQUESTFAILED(ChromeRequestFailed .class),

    REQUESTFINISHED(ChromeRequest.class),

    ;

    private Class clazz;

    ChromePageEvent(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }
}
