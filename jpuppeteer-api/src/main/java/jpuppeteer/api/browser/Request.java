package jpuppeteer.api.browser;

import jpuppeteer.api.constant.ResourceType;

import java.net.URL;
import java.util.List;

public interface Request {

    //暂不支持, 后续支持
//    void abort();
//
//    void continues();
//
//    void failure();

    Frame frame();

    List<Header> headers();

    boolean isNavigationRequest();

    String method();

    String postData();

    /**
     * @return 当前请求的重定向来源
     */
    Request prev();

    ResourceType resourceType();

    Response response();

    URL url();

}
