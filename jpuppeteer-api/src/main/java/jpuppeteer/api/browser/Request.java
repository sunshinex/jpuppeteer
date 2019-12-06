package jpuppeteer.api.browser;

import jpuppeteer.api.constant.ResourceType;

import java.net.URL;
import java.util.List;

public interface Request {

    //暂不支持, 后续支持
    void abort();

    void continues();

    void failure();

    <R extends Frame> R frame();

    List<Header> headers();

    boolean isNavigationRequest();

    String method();

    String postData();

    /**
     * @return 当前请求的重定向来源
     */
    <R extends Request> R prev();

    ResourceType resourceType();

    <R extends Response> R response();

    URL url();

}
