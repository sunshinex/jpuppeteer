package jpuppeteer.api;

import io.netty.util.concurrent.Future;

public interface Frame extends Isolate {

    Page page();

    Future<Element> querySelector(String selector);

    Future<Element[]> querySelectorAll(String selector);

    Future<Element> waitSelector(String selector, long timeout);

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

