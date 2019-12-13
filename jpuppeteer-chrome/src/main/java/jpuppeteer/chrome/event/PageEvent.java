package jpuppeteer.chrome.event;


import jpuppeteer.cdp.cdp.entity.log.EntryAddedEvent;
import jpuppeteer.cdp.cdp.entity.page.DomContentEventFiredEvent;
import jpuppeteer.cdp.cdp.entity.page.LoadEventFiredEvent;
import jpuppeteer.cdp.cdp.entity.runtime.ExceptionThrownEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetCrashedEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetDestroyedEvent;
import jpuppeteer.chrome.ChromeDialog;
import jpuppeteer.chrome.ChromePage;

public final class PageEvent<E> extends FrameEvent<E> {

    public static final PageEvent<TargetCrashedEvent> ERROR = new PageEvent<>(TargetCrashedEvent.class);

    public static final PageEvent<TargetDestroyedEvent> CLOSE = new PageEvent<>(TargetDestroyedEvent.class);



    /**
     * 此事件只在主页面触发, iframe不会触发事件
     */
    public static final PageEvent<DomContentEventFiredEvent> DOMCONTENTLOADED = new PageEvent<>(DomContentEventFiredEvent.class);

    /**
     * 此事件只在主页面触发, iframe不会触发事件
     */
    public static final PageEvent<LoadEventFiredEvent> LOAD = new PageEvent<>(LoadEventFiredEvent.class);

    public static final PageEvent<EntryAddedEvent> CONSOLE = new PageEvent<>(EntryAddedEvent.class);

    public static final PageEvent<ChromeDialog> DIALOG = new PageEvent<>(ChromeDialog.class);

    public static final PageEvent<ChromePage> OPENPAGE = new PageEvent<>(ChromePage.class);

    public static final PageEvent<ExceptionThrownEvent> PAGEERROR = new PageEvent<>(ExceptionThrownEvent.class);

//    public static final PageEvent<CookieEvent> COOKIE = new PageEvent<>(CookieEvent.class);


    private PageEvent(Class<E> eventClass) {
        super(eventClass);
    }

    private PageEvent(String eventName, Class<E> eventClass) {
        super(eventName, eventClass);
    }

    @Override
    public String toString() {
        return "PageEvent{" +
                "eventName='" + eventName + '\'' +
                ", eventClass=" + eventClass +
                '}';
    }
}
