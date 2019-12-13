package jpuppeteer.api.browser;

import jpuppeteer.api.constant.ResourceType;

import java.net.URL;
import java.util.List;

public interface Request {

    //暂不支持, 后续支持
    void abort() throws Exception;

    void continues(Request request) throws Exception;

    default void continues() throws Exception {
        continues(null);
    }

    void respond(int statusCode, List<Header> headers, byte[] body) throws Exception;

    default void respond(int statusCode) throws Exception {
        respond(statusCode, null, null);
    }

    Frame frame();

    List<Header> headers();

    boolean isNavigationRequest();

    String method();

    String postData();

//    /**
//     * @return 当前请求的重定向来源
//     */
//    <R extends Request> R prev();

    ResourceType resourceType();

    Response response();

    URL url();

}
