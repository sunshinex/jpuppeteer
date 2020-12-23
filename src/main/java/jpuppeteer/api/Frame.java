package jpuppeteer.api;

import io.netty.util.concurrent.Future;

import java.util.concurrent.TimeUnit;

public interface Frame extends Isolate {

    Page page();

    Future<Element> owner();

    Future<Element> querySelector(String selector);

    Future<Element[]> querySelectorAll(String selector);

    Future<Element> waitSelector(String selector, long timeout, TimeUnit unit);

    String frameId();

    Frame parent();

    Future<String> title();

    Future<String> url();

    Future<String> navigate(String url, String referer);

    default Future<String> navigate(String url) {
        return navigate(url, null);
    }

    Future<Isolate> createIsolate(String isolateName);

    Future<String> html();

    Future html(String html);

}

