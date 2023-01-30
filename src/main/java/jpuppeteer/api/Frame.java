package jpuppeteer.api;

import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.api.event.page.PageEvent;
import jpuppeteer.util.XFuture;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public interface Frame extends EventEmitter<PageEvent>, Isolate {

    Page page();

    Frame parent();

    String frameId();

    String name();

    String loaderId();

    String url();

    XFuture<Element> querySelector(String selector);

    XFuture<Element[]> querySelectorAll(String selector);

    XFuture<Element> waitSelector(String selector, long timeout, TimeUnit unit);

    XFuture<?> watch(String selector, Consumer<Element> watchFunction, boolean once);

    default XFuture<?> watch(String selector, Consumer<Element> watchFunction) {
        return watch(selector, watchFunction, false);
    }

    XFuture<String> navigate(String url, String referer);

    default XFuture<String> navigate(String url) {
        return navigate(url, null);
    }

    XFuture<Isolate> createIsolate(String isolateName);

    XFuture<?> addBinding(String bindingName, BindingFunction function);

    XFuture<String> html();

    XFuture<?> html(String html);

}

