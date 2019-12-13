package jpuppeteer.api.browser;

import com.alibaba.fastjson.TypeReference;
import jpuppeteer.api.event.EventEmitter;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface Frame<P> extends EventEmitter, ExecutionContext<P> {

    String frameId();

    <R extends Frame<P>> R parent();

    /**
     * child frames
     * @return
     */
    <R extends Frame<P>> R[] children();

    String content() throws Exception;

    String name();

    void setContent(String content) throws Exception;

    String title() throws Exception;

    URL url() throws Exception;

    void navigate(String url, String referer) throws Exception;

    default void navigate(String url) throws Exception {
        navigate(url, null);
    }

    <R extends Element<P>> R querySelector(String selector) throws Exception;

    <R extends Element<P>> List<R> querySelectorAll(String selector) throws Exception;

    <R extends BrowserObject<P>> R wait(String expression, int timeout, TimeUnit unit, P... args) throws Exception;

    <R> R wait(String expression, int timeout, TimeUnit unit, Class<R> clazz, P... args) throws Exception;

    <R> R wait(String expression, int timeout, TimeUnit unit, TypeReference<R> type, P... args) throws Exception;

    <R extends Element<P>> R waitSelector(String selector, int timeout, TimeUnit unit) throws Exception;

}

