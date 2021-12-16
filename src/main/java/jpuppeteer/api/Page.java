package jpuppeteer.api;

import com.google.common.collect.Lists;
import io.netty.util.concurrent.Future;
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
import jpuppeteer.util.SetDeviceMetricsOverrideRequestBuilder;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public interface Page extends Frame {

    String title();

    String targetId();

    Future reload(Boolean ignoreCache, String scriptToEvaluateOnLoad);

    default Future reload() {
        return reload(null, null);
    }

    Page opener();

    Frame openerFrame();

    BrowserContext browserContext();

    Future setCookies(CookieParam... cookies);

    Future clearCookies();

    Future<Cookie[]> getCookies(String... urls);

    Future bringToFront();

    Future<String> addScriptToEvaluateOnNewDocument(String script);

    Future removeScriptToEvaluateOnNewDocument(String scriptId);

    Future watch(String selector, Consumer<Element> watchFunction, boolean once);

    default Future watch(String selector, Consumer<Element> watchFunction) {
        return watch(selector, watchFunction, false);
    }

    Future enableNetwork(jpuppeteer.cdp.client.entity.network.EnableRequest request);

    default Future enableNetwork() {
        return enableNetwork(new jpuppeteer.cdp.client.entity.network.EnableRequest());
    }

    Future disableNetwork();

    Future enableCache();

    Future disableCache();

    Future<HttpResource> loadResource(String url, boolean disableCache);

    default Future<HttpResource> loadResource(String url) {
        return loadResource(url, false);
    }

    Future removeBinding(String name);

    default Future enableAuthentication(Consumer<Authenticator> consumer) {
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

    Future enableRequestInterception(EnableRequest request, Interceptor<? extends InterceptedResponse> interceptor);

    default Future enableRequestInterception(Consumer<InterceptedRequest> interceptor) {
        return enableRequestInterception(new EnableRequest(
                Lists.newArrayList(
                        new RequestPattern("*", null, RequestStage.REQUEST)
                ),
                false
        ), (Interceptor<InterceptedRequest>) request -> interceptor.accept(request));
    }

    default Future enableRequestInterception(Consumer<InterceptedRequest> interceptor, String... urlPatterns) {
        List<RequestPattern> requestPatterns = Arrays.stream(urlPatterns)
                .map(pattern -> new RequestPattern(pattern, null, RequestStage.REQUEST))
                .collect(Collectors.toList());
        return enableRequestInterception(
                new EnableRequest(requestPatterns, false),
                (Interceptor<InterceptedRequest>) request -> interceptor.accept(request));
    }

    default Future enableResponseInterception(Consumer<InterceptedResponse> interceptor) {
        return enableRequestInterception(new EnableRequest(
                Lists.newArrayList(
                        new RequestPattern("*", null, RequestStage.RESPONSE)
                ),
                false
        ), request -> interceptor.accept(request));
    }

    default Future enableResponseInterception(Consumer<InterceptedResponse> interceptor, String... urlPatterns) {
        List<RequestPattern> requestPatterns = Arrays.stream(urlPatterns)
                .map(pattern -> new RequestPattern(pattern, null, RequestStage.RESPONSE))
                .collect(Collectors.toList());
        return enableRequestInterception(
                new EnableRequest(requestPatterns, false),
                request -> interceptor.accept(request));
    }

    Future disableRequestInterception();

    Future enableTouchEmulation(boolean enable, Integer maxTouchPoints);

    default Future enableTouchEmulation(boolean enable) {
        return enableTouchEmulation(enable, null);
    }

    Future enableEmitTouchEventsForMouse(boolean enable, SetEmitTouchEventsForMouseRequestConfiguration configuration);

    default Future enableEmitTouchEventsForMouse(boolean enable) {
        return enableEmitTouchEventsForMouse(enable, null);
    }

    Future setHeaders(HttpHeader... headers);

    Future setGeolocation(double latitude, double longitude, double accuracy);

    Future setUserAgent(SetUserAgentOverrideRequest userAgent);

    default Future setUserAgent(String userAgent) {
        return setUserAgent(new SetUserAgentOverrideRequest(userAgent, "zh-CN,zh;q=0.9", "Win32", null));
    }

    Future setDevice(SetDeviceMetricsOverrideRequest device);

    default Future setDevice(ScreenOrientationType screenOrientation, int width, int height, int screenWidth, int screenHeight, double scale, boolean isMobile) {
        SetDeviceMetricsOverrideRequest request = SetDeviceMetricsOverrideRequestBuilder.newBuilder()
                .deviceScaleFactor(BigDecimal.valueOf(scale))
                .width(width)
                .height(height)
                .mobile(isMobile)
                .screenWidth(screenWidth)
                .screenHeight(screenHeight)
                .screenOrientation(new ScreenOrientation(screenOrientation, 0))
                .build();
        return setDevice(request);
    }

    Future setWindow(Bounds bounds);

    default Future setWindow(int width, int height) {
        return setWindow(new Bounds(null, null, width, height, null));
    }

    default Future setWindow(WindowState state) {
        return setWindow(new Bounds(null, null, null, null, state));
    }

    Future<byte[]> screenshot(CaptureScreenshotRequest request);

    default Future<byte[]> screenshot(Integer quality) {
        return screenshot(new CaptureScreenshotRequest(CaptureScreenshotRequestFormat.JPEG, quality, null, null, null));
    }

    default Future<byte[]> screenshot() {
        return screenshot(new CaptureScreenshotRequest());
    }

    Future stopLoading();

    Future enableInput();

    Future disableInput();

    Future activate();

    Future close();

    //keyboard event;
    Future keyDown(USKeyboardDefinition key);

    Future keyUp(USKeyboardDefinition key);

    Future press(USKeyboardDefinition key, int delay);

    default Future press(USKeyboardDefinition key) {
        return press(key, 0);
    }

    //mouse event
    Future mouseDown(MouseDefinition mouseDefinition);

    default Future mouseDown() {
        return mouseDown(MouseDefinition.LEFT);
    }

    Future mouseUp(MouseDefinition mouseDefinition);

    default Future mouseUp() {
        return mouseUp(MouseDefinition.LEFT);
    }

    Future click(MouseDefinition mouseDefinition, int delay);

    Future mouseMove(int x, int y);

    Point mousePosition();

    Future mouseWheel(int deltaX, int deltaY);

    //touch event
    Future touchStart(TouchPoint[] touchPoints);

    Future touchStart(int x, int y);

    Future touchEnd();

    Future touchMove(TouchPoint[] touchPoints);

    Future touchMove(int x, int y);

    Future touchCancel();

}
