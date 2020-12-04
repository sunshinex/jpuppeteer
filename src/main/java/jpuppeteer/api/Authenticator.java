package jpuppeteer.api;

import io.netty.util.concurrent.Future;
import jpuppeteer.cdp.client.constant.fetch.AuthChallengeSource;

public interface Authenticator extends Request {

    String interceptorId();

    AuthChallengeSource source();

    String origin();

    String scheme();

    String realm();

    Future accept(String username, String password);

    Future cancel();

}
