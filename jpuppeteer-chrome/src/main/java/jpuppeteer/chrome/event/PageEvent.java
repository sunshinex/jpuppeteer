package jpuppeteer.chrome.event;


import jpuppeteer.api.browser.Page;
import jpuppeteer.cdp.cdp.entity.log.EntryAddedEvent;
import jpuppeteer.cdp.cdp.entity.page.DomContentEventFiredEvent;
import jpuppeteer.cdp.cdp.entity.page.JavascriptDialogOpeningEvent;
import jpuppeteer.cdp.cdp.entity.page.LoadEventFiredEvent;
import jpuppeteer.cdp.cdp.entity.runtime.ExceptionThrownEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetCrashedEvent;
import jpuppeteer.cdp.cdp.entity.target.TargetDestroyedEvent;
import jpuppeteer.chrome.entity.CookieEvent;

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

    public static final PageEvent<JavascriptDialogOpeningEvent> DIALOG = new PageEvent<>(JavascriptDialogOpeningEvent.class);

    public static final PageEvent<Page> OPENPAGE = new PageEvent<>(Page.class);

    public static final PageEvent<ExceptionThrownEvent> PAGEERROR = new PageEvent<>(ExceptionThrownEvent.class);

    public static final PageEvent<CookieEvent> COOKIE = new PageEvent<>(CookieEvent.class);


    private PageEvent(Class<E> eventClass) {
        super(eventClass);
    }

    @Override
    public String toString() {
        return "PageEvent{" +
                "eventClass=" + eventClass +
                '}';
    }
}
