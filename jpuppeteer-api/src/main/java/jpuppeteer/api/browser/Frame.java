package jpuppeteer.api.browser;

import com.alibaba.fastjson.TypeReference;
import jpuppeteer.api.event.EventEmitter;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface Frame<P> extends EventEmitter, ExecutionContext<P> {

    String frameId();

    Frame<P> parent();

    /**
     * child frames
     * @return
     */
    Frame<P>[] children();

    String content() throws Exception;

    String name();

    void setContent(String content) throws Exception;

    String title() throws Exception;

    URL url() throws Exception;

    void navigate(String url, String referer) throws Exception;

    default void navigate(String url) throws Exception {
        navigate(url, null);
    }

    Element<P> querySelector(String selector) throws Exception;

    List<? extends Element<P>> querySelectorAll(String selector) throws Exception;

    BrowserObject<P> wait(String expression, int timeout, TimeUnit unit, P... args) throws Exception;

    <R> R wait(String expression, int timeout, TimeUnit unit, Class<R> clazz, P... args) throws Exception;

    <R> R wait(String expression, int timeout, TimeUnit unit, TypeReference<R> type, P... args) throws Exception;

    Element<P> waitSelector(String selector, int timeout, TimeUnit unit) throws Exception;

}

