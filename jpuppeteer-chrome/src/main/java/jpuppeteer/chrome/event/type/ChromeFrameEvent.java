package jpuppeteer.chrome.event.type;

import jpuppeteer.cdp.cdp.entity.page.Frame;
import jpuppeteer.cdp.cdp.entity.page.LifecycleEvent;
import jpuppeteer.chrome.ChromeFrame;

public enum ChromeFrameEvent {

    LIFECYCLEEVENT(LifecycleEvent.class),

    FRAMEATTACHED(String.class),

    FRAMEDETACHED(ChromeFrame.class),

    FRAMENAVIGATED(Frame.class),

    ;

    private Class clazz;

    ChromeFrameEvent(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }
}
