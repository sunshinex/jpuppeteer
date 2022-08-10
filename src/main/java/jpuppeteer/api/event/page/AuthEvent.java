package jpuppeteer.api.event.page;

import jpuppeteer.api.Authenticator;
import jpuppeteer.api.Frame;
import jpuppeteer.api.HttpHeader;
import jpuppeteer.api.Request;
import jpuppeteer.cdp.client.constant.fetch.AuthChallengeResponseResponse;
import jpuppeteer.cdp.client.constant.fetch.AuthChallengeSource;
import jpuppeteer.cdp.client.constant.network.ResourceType;
import jpuppeteer.cdp.client.domain.Fetch;
import jpuppeteer.cdp.client.entity.fetch.AuthChallenge;
import jpuppeteer.cdp.client.entity.fetch.AuthChallengeResponse;
import jpuppeteer.cdp.client.entity.fetch.ContinueWithAuthRequest;
import jpuppeteer.util.XFuture;

public class AuthEvent extends FrameEvent implements Authenticator {

    private final Fetch fetch;

    private final String interceptorId;

    private final String origin;

    private final String scheme;

    private final String realm;

    private final AuthChallengeSource source;

    private final Request request;

    public AuthEvent(Frame frame, Fetch fetch, String interceptorId, AuthChallenge challenge, Request request) {
        super(frame);
        this.fetch = fetch;
        this.interceptorId = interceptorId;
        this.origin = challenge.getOrigin();
        this.scheme = challenge.getScheme();
        this.realm = challenge.getRealm();
        this.source = challenge.getSource();
        this.request = request;
    }

    @Override
    public String interceptorId() {
        return interceptorId;
    }

    @Override
    public AuthChallengeSource source() {
        return source;
    }

    @Override
    public String origin() {
        return origin;
    }

    @Override
    public String scheme() {
        return scheme;
    }

    @Override
    public String realm() {
        return realm;
    }

    private ContinueWithAuthRequest createRequest(AuthChallengeResponseResponse resp, String username, String password) {
        AuthChallengeResponse authChallengeResp;
        if (username != null) {
            authChallengeResp = new AuthChallengeResponse(resp, username, password);
        } else {
            authChallengeResp = new AuthChallengeResponse(resp);
        }

        return new ContinueWithAuthRequest(interceptorId, authChallengeResp);
    }

    @Override
    public XFuture<?> accept(String username, String password) {
        ContinueWithAuthRequest request = createRequest(AuthChallengeResponseResponse.PROVIDECREDENTIALS, username, password);
        return fetch.continueWithAuth(request);
    }

    @Override
    public XFuture<?> cancel() {
        ContinueWithAuthRequest request = createRequest(AuthChallengeResponseResponse.CANCELAUTH, null, null);
        return fetch.continueWithAuth(request);
    }

    @Override
    public String requestId() {
        return request.requestId();
    }

    @Override
    public String loaderId() {
        return request.loaderId();
    }

    @Override
    public String url() {
        return request.url();
    }

    @Override
    public String method() {
        return request.method();
    }

    @Override
    public HttpHeader[] headers() {
        return request.headers();
    }

    @Override
    public ResourceType resourceType() {
        return request.resourceType();
    }

    @Override
    public String location() {
        return request.location();
    }

    @Override
    public XFuture<String> content() {
        return request.content();
    }
}
