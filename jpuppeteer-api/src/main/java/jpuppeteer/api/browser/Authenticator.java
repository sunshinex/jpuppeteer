package jpuppeteer.api.browser;

import jpuppeteer.api.constant.AuthChallengeSourceType;

public interface Authenticator {

    AuthChallengeSourceType source();

    String origin();

    String scheme();

    String realm();

    void accept(String username, String password) throws Exception;

    void cancel() throws Exception;

}
