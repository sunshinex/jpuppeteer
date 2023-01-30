package jpuppeteer.api;

import com.google.common.collect.Lists;
import jpuppeteer.cdp.client.constant.browser.WindowState;
import jpuppeteer.cdp.client.constant.emulation.ScreenOrientationType;
import jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration;
import jpuppeteer.cdp.client.constant.fetch.RequestStage;
import jpuppeteer.cdp.client.constant.page.CaptureScreenshotRequestFormat;
import jpuppeteer.cdp.client.entity.browser.Bounds;
import jpuppeteer.cdp.client.entity.emulation.ScreenOrientation;
import jpuppeteer.cdp.client.entity.emulation.SetDeviceMetricsOverrideRequest;
import jpuppeteer.cdp.client.entity.emulation.SetUserAgentOverrideRequest;
import jpuppeteer.cdp.client.entity.fetch.EnableRequest;
import jpuppeteer.cdp.client.entity.fetch.RequestPattern;
import jpuppeteer.cdp.client.entity.input.TouchPoint;
import jpuppeteer.cdp.client.entity.network.Cookie;
import jpuppeteer.cdp.client.entity.network.CookieParam;
import jpuppeteer.cdp.client.entity.page.CaptureScreenshotRequest;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.constant.USKeyboardDefinition;
import jpuppeteer.entity.HttpResource;
import jpuppeteer.entity.Point;
import jpuppeteer.util.XFuture;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public interface Page extends Frame {

    String title();

    String targetId();

    XFuture<?> reload(Boolean ignoreCache, String scriptToEvaluateOnLoad);

    default XFuture<?> reload() {
        return reload(null, null);
    }

    Page opener();

    Frame openerFrame();

    BrowserContext browserContext();

    XFuture<?> setCookies(CookieParam... cookies);

    XFuture<?> clearCookies();

    XFuture<Cookie[]> getCookies(String... urls);

    XFuture<?> bringToFront();

    XFuture<String> addScriptToEvaluateOnNewDocument(String script);

    XFuture<?> removeScriptToEvaluateOnNewDocument(String scriptId);

    XFuture<?> enableNetwork(jpuppeteer.cdp.client.entity.network.EnableRequest request);

    default XFuture<?> enableNetwork() {
        return enableNetwork(new jpuppeteer.cdp.client.entity.network.EnableRequest());
    }

    XFuture<?> disableNetwork();

    XFuture<?> enableCache();

    XFuture<?> disableCache();

    XFuture<HttpResource> loadResource(String url, boolean disableCache);

    default XFuture<HttpResource> loadResource(String url) {
        return loadResource(url, false);
    }

    XFuture<?> removeBinding(String name);

    default XFuture<?> enableAuthentication(Consumer<Authenticator> consumer) {
        return enableRequestInterception(new EnableRequest(
                Lists.newArrayList(
                        new RequestPattern("*", null, RequestStage.REQUEST)
                ),
                true
        ), new Interceptor<InterceptedRequest>() {
            @Override
            public void intercept(InterceptedRequest request) {
                request.continues();
            }

            @Override
            public void authenticate(Authenticator authenticator) {
                consumer.accept(authenticator);
            }
        });
    }

    XFuture<?> enableRequestInterception(EnableRequest request, Interceptor<? extends InterceptedResponse> interceptor);

    default XFuture<?> enableRequestInterception(Consumer<InterceptedRequest> interceptor) {
        return enableRequestInterception(new EnableRequest(
                Lists.newArrayList(
                        new RequestPattern("*", null, RequestStage.REQUEST)
                ),
                false
        ), (Interceptor<InterceptedRequest>) interceptor::accept);
    }

    default XFuture<?> enableRequestInterception(Consumer<InterceptedRequest> interceptor, String... urlPatterns) {
        List<RequestPattern> requestPatterns = Arrays.stream(urlPatterns)
                .map(pattern -> new RequestPattern(pattern, null, RequestStage.REQUEST))
                .collect(Collectors.toList());
        return enableRequestInterception(
                new EnableRequest(requestPatterns, false),
                (Interceptor<InterceptedRequest>) interceptor::accept);
    }

    default XFuture<?> enableResponseInterception(Consumer<InterceptedResponse> interceptor) {
        return enableRequestInterception(new EnableRequest(
                Lists.newArrayList(
                        new RequestPattern("*", null, RequestStage.RESPONSE)
                ),
                false
        ), interceptor::accept);
    }

    default XFuture<?> enableResponseInterception(Consumer<InterceptedResponse> interceptor, String... urlPatterns) {
        List<RequestPattern> requestPatterns = Arrays.stream(urlPatterns)
                .map(pattern -> new RequestPattern(pattern, null, RequestStage.RESPONSE))
                .collect(Collectors.toList());
        return enableRequestInterception(
                new EnableRequest(requestPatterns, false),
                interceptor::accept);
    }

    XFuture<?> disableRequestInterception();

    XFuture<?> enableTouchEmulation(boolean enable, Integer maxTouchPoints);

    default XFuture<?> enableTouchEmulation(boolean enable) {
        return enableTouchEmulation(enable, null);
    }

    XFuture<?> enableEmitTouchEventsForMouse(boolean enable, SetEmitTouchEventsForMouseRequestConfiguration configuration);

    default XFuture<?> enableEmitTouchEventsForMouse(boolean enable) {
        return enableEmitTouchEventsForMouse(enable, null);
    }

    XFuture<?> setHeaders(HttpHeader... headers);

    XFuture<?> setGeolocation(double latitude, double longitude, double accuracy);

    XFuture<?> setUserAgent(SetUserAgentOverrideRequest userAgent);

    default XFuture<?> setUserAgent(String userAgent) {
        return setUserAgent(new SetUserAgentOverrideRequest(userAgent, "zh-CN,zh;q=0.9", "Win32", null));
    }

    XFuture<?> setDevice(SetDeviceMetricsOverrideRequest device);

    default XFuture<?> setDevice(ScreenOrientationType screenOrientation, int width, int height, int screenWidth, int screenHeight, double scale, boolean isMobile) {
        SetDeviceMetricsOverrideRequest request = new SetDeviceMetricsOverrideRequest();
        request.setDeviceScaleFactor(BigDecimal.valueOf(scale));
        request.setWidth(width);
        request.setHeight(height);
        request.setMobile(isMobile);
        request.setScreenWidth(screenWidth);
        request.setScreenHeight(screenHeight);
        request.setScreenOrientation(new ScreenOrientation(screenOrientation, 0));
        return setDevice(request);
    }

    XFuture<?> setOrientation(double alpha, double beta, double gamma);

    XFuture<?> setWindow(Bounds bounds);

    default XFuture<?> setWindow(int width, int height) {
        return setWindow(new Bounds(null, null, width, height, null));
    }

    default XFuture<?> setWindow(WindowState state) {
        return setWindow(new Bounds(null, null, null, null, state));
    }

    XFuture<byte[]> screenshot(CaptureScreenshotRequest request);

    default XFuture<byte[]> screenshot(Integer quality) {
        return screenshot(new CaptureScreenshotRequest(CaptureScreenshotRequestFormat.JPEG, quality, null, null, null));
    }

    default XFuture<byte[]> screenshot() {
        return screenshot(new CaptureScreenshotRequest());
    }

    XFuture<?> stopLoading();

    XFuture<?> enableInput();

    XFuture<?> disableInput();

    XFuture<?> activate();

    XFuture<?> close();

    //keyboard event;
    XFuture<?> keyDown(USKeyboardDefinition key);

    XFuture<?> keyUp(USKeyboardDefinition key);

    XFuture<?> press(USKeyboardDefinition key, int delay);

    default XFuture<?> press(USKeyboardDefinition key) {
        return press(key, 0);
    }

    //mouse event
    XFuture<?> mouseDown(MouseDefinition mouseDefinition);

    default XFuture<?> mouseDown() {
        return mouseDown(MouseDefinition.LEFT);
    }

    XFuture<?> mouseUp(MouseDefinition mouseDefinition);

    default XFuture<?> mouseUp() {
        return mouseUp(MouseDefinition.LEFT);
    }

    XFuture<?> click(MouseDefinition mouseDefinition, int delay);

    XFuture<?> mouseMove(int x, int y);

    Point mousePosition();

    XFuture<?> mouseWheel(int deltaX, int deltaY);

    //touch event
    XFuture<?> touchStart(TouchPoint[] touchPoints);

    XFuture<?> touchStart(int x, int y);

    XFuture<?> touchEnd();

    XFuture<?> touchMove(TouchPoint[] touchPoints);

    XFuture<?> touchMove(int x, int y);

    XFuture<?> touchCancel();

}
