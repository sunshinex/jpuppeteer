package jpuppeteer.api;

import jpuppeteer.constant.WatchAction;

@FunctionalInterface
public interface WatchFunction {

    void onVisibilityChanged(String id, WatchAction action, Element element);

}
