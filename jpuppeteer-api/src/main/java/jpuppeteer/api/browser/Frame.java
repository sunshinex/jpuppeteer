package jpuppeteer.api.browser;

import com.alibaba.fastjson.TypeReference;
import jpuppeteer.api.event.EventEmitter;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface Frame<T> extends EventEmitter, ExecutionContext<T> {

    String frameId();

    Frame parent();

    /**
     * child frames
     * @return
     */
    Frame[] children();

    String content() throws Exception;

    String name();

    void setContent(String content) throws Exception;

    String title() throws Exception;

    URL url() throws Exception;

    void navigate(String url, String referer) throws Exception;

    default void navigate(String url) throws Exception {
        navigate(url, null);
    }

    <R extends Element> R querySelector(String selector) throws Exception;

    <R extends Element> List<R> querySelectorAll(String selector) throws Exception;

    <R extends BrowserObject> R wait(String expression, int timeout, TimeUnit unit, T... args) throws Exception;

    <R> R wait(String expression, int timeout, TimeUnit unit, Class<R> clazz, T... args) throws Exception;

    <R> R wait(String expression, int timeout, TimeUnit unit, TypeReference<R> type, T... args) throws Exception;

    <R extends Element> R waitSelector(String selector, int timeout, TimeUnit unit) throws Exception;

}

