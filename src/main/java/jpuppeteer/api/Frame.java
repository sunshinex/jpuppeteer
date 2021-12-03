package jpuppeteer.api;

import io.netty.util.concurrent.Future;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.api.event.page.PageEvent;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public interface Frame extends EventEmitter<PageEvent>, Isolate {

    Page page();

    Frame parent();

    String frameId();

    String name();

    String loaderId();

    String url();

    Future<Element> querySelector(String selector);

    Future<Element[]> querySelectorAll(String selector);

    Future<Element> waitSelector(String selector, long timeout, TimeUnit unit);

    Future watch(String selector, Consumer<Element> watchFunction, boolean once);

    Future<String> navigate(String url, String referer);

    default Future<String> navigate(String url) {
        return navigate(url, null);
    }

    Future<Isolate> createIsolate(String isolateName);

    Future addBinding(String bindingName, BindingFunction function);

    Future<String> html();

    Future html(String html);

}

