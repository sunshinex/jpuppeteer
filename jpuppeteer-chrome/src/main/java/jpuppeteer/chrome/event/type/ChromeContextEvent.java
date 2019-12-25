package jpuppeteer.chrome.event.type;

import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.cdp.entity.target.AttachedToTargetEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetCrashedEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetInfo;

public enum ChromeContextEvent {

    //target
    TARGETCREATED(TargetInfo.class),
    ATTACHEDTOTARGET(AttachedToTargetEvent.class),
    TARGETDESTROYED(String.class),
    TARGETINFOCHANGED(TargetInfo.class),
    TARGETCRASHED(TargetCrashedEvent.class),
//    DETACHEDFROMTARGET(CDPEventType.TARGET_DETACHEDFROMTARGET),
//    RECEIVEDMESSAGEFROMTARGET(CDPEventType.TARGET_RECEIVEDMESSAGEFROMTARGET),
//
    //page
    LIFECYCLEEVENT(CDPEvent.class),
    DOMCONTENTEVENTFIRED(CDPEvent.class),
    LOADEVENTFIRED(CDPEvent.class),
    FRAMEATTACHED(CDPEvent.class),
    FRAMEDETACHED(CDPEvent.class),
    FRAMENAVIGATED(CDPEvent.class),
    JAVASCRIPTDIALOGOPENING(CDPEvent.class),

    //network
    REQUESTWILLBESENT(CDPEvent.class),
    RESPONSERECEIVED(CDPEvent.class),
    LOADINGFAILED(CDPEvent.class),
    LOADINGFINISHED(CDPEvent.class),

    //runtime
    EXCEPTIONTHROWN(CDPEvent.class),
    EXECUTIONCONTEXTCREATED(CDPEvent.class),
    EXECUTIONCONTEXTDESTROYED(CDPEvent.class),
    EXECUTIONCONTEXTSCLEARED(CDPEvent.class),

    //fetch
    REQUESTPAUSED(CDPEvent.class),
    AUTHREQUIRED(CDPEvent.class),

    //log
    ENTRYADDED(CDPEvent.class),
    ;

    private Class clazz;

    ChromeContextEvent(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }
}
