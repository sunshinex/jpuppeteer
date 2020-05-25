package jpuppeteer.api.browser;

import java.util.List;

public interface RequestHandler extends Request {

    void abort() throws Exception;

    void continues(Request request) throws Exception;

    default void continues() throws Exception {
        continues(null);
    }

    void respond(int statusCode, List<Header> headers, byte[] body) throws Exception;

    default void respond(int statusCode) throws Exception {
        respond(statusCode, null, null);
    }

}
