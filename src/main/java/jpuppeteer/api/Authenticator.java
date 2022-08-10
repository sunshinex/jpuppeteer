package jpuppeteer.api;

import jpuppeteer.cdp.client.constant.fetch.AuthChallengeSource;
import jpuppeteer.util.XFuture;

public interface Authenticator extends Request {

    String interceptorId();

    AuthChallengeSource source();

    String origin();

    String scheme();

    String realm();

    XFuture<?> accept(String username, String password);

    XFuture<?> cancel();

}
