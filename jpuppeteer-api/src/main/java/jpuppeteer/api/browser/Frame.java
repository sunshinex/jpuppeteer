package jpuppeteer.api.browser;

import com.alibaba.fastjson.TypeReference;
import jpuppeteer.api.event.EventEmitter;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface Frame<E extends Enum<E>, P> extends EventEmitter<E>, ExecutionContext<P> {

    String frameId();

    Frame<E, P> parent();

    /**
     * child frames
     * @return
     */
    Frame<E, P>[] children();

    String content() throws Exception;

    String name();

    void setContent(String content) throws Exception;

    String title() throws Exception;

    URL url() throws Exception;

    void navigate(String url, String referer) throws Exception;

    default void navigate(String url) throws Exception {
        navigate(url, null);
    }

    Element<E, P> querySelector(String selector) throws Exception;

    List<? extends Element<E, P>> querySelectorAll(String selector) throws Exception;

    BrowserObject<P> wait(String expression, int timeout, TimeUnit unit, P... args) throws Exception;

    <R> R wait(String expression, int timeout, TimeUnit unit, Class<R> clazz, P... args) throws Exception;

    <R> R wait(String expression, int timeout, TimeUnit unit, TypeReference<R> type, P... args) throws Exception;

    Element<E, P> waitSelector(String selector, int timeout, TimeUnit unit) throws Exception;

}

