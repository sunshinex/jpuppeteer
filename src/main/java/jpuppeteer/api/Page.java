package jpuppeteer.api;

import com.google.common.collect.Lists;
import io.netty.util.concurrent.Future;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.api.event.PageEvent;
import jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration;
import jpuppeteer.cdp.client.constant.fetch.RequestStage;
import jpuppeteer.cdp.client.constant.page.CaptureScreenshotRequestFormat;
import jpuppeteer.cdp.client.entity.emulation.SetDeviceMetricsOverrideRequest;
import jpuppeteer.cdp.client.entity.emulation.SetUserAgentOverrideRequest;
import jpuppeteer.cdp.client.entity.fetch.EnableRequest;
import jpuppeteer.cdp.client.entity.fetch.RequestPattern;
import jpuppeteer.cdp.client.entity.input.TouchPoint;
import jpuppeteer.cdp.client.entity.page.CaptureScreenshotRequest;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.constant.USKeyboardDefinition;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public interface Page extends EventEmitter<PageEvent>, Frame {

    String name();

    Page opener();

    BrowserContext browserContext();

    Future bringToFront();

    Future<String> addScriptToEvaluateOnNewDocument(String script);

    Future removeScriptToEvaluateOnNewDocument(String scriptId);

    Future enableCache();

    Future disableCache();

    Future addBinding(String name, BindingFunction function);

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

    Future enableTouchEmulation(boolean enable, int maxTouchPoints);

    default Future enableTouchEmulation(boolean enable) {
        return enableTouchEmulation(enable, 1);
    }

    Future enableEmitTouchEventsForMouse(boolean enable, SetEmitTouchEventsForMouseRequestConfiguration configuration);

    default Future enableEmitTouchEventsForMouse(boolean enable) {
        return enableEmitTouchEventsForMouse(enable, SetEmitTouchEventsForMouseRequestConfiguration.MOBILE);
    }

    Future setHeaders(HttpHeader... headers);

    Future setGeolocation(double latitude, double longitude, double accuracy);

    Future setUserAgent(SetUserAgentOverrideRequest userAgent);

    default Future setUserAgent(String userAgent) {
        return setUserAgent(new SetUserAgentOverrideRequest(userAgent));
    }

    Future setDevice(SetDeviceMetricsOverrideRequest device);

    default Future setDevice(int width, int height, double scale, boolean isMobile) {
        return setDevice(new SetDeviceMetricsOverrideRequest(width, height, BigDecimal.valueOf(scale), isMobile));
    }

    default Future setDevice(int width, int height) {
        return setDevice(width, height, 1, false);
    }

    Future<byte[]> screenshot(CaptureScreenshotRequest request);

    default Future<byte[]> screenshot(Integer quality) {
        return screenshot(new CaptureScreenshotRequest(CaptureScreenshotRequestFormat.JPEG, quality, null, null));
    }

    default Future<byte[]> screenshot() {
        return screenshot(new CaptureScreenshotRequest());
    }

    Future stopLoading();

    //keyboard event;
    Future keyDown(USKeyboardDefinition key, USKeyboardDefinition... modifiers);

    Future keyUp(USKeyboardDefinition key, USKeyboardDefinition... modifiers);

    Future press(USKeyboardDefinition key, int delay, USKeyboardDefinition... modifiers);

    default Future press(USKeyboardDefinition key, USKeyboardDefinition... modifiers) {
        return press(key, 0, modifiers);
    }

    //mouse event
    Future mouseDown(MouseDefinition mouseDefinition, double x, double y, USKeyboardDefinition... modifiers);

    default Future mouseDown(double x, double y, USKeyboardDefinition... modifiers) {
        return mouseDown(MouseDefinition.LEFT, x, y, modifiers);
    }

    Future mouseUp(MouseDefinition mouseDefinition, double x, double y, USKeyboardDefinition... modifiers);

    default Future mouseUp(double x, double y, USKeyboardDefinition... modifiers) {
        return mouseUp(MouseDefinition.LEFT, x, y, modifiers);
    }

    Future mouseMove(double fromX, double fromY, double toX, double toY, int steps, USKeyboardDefinition... modifiers);

    default Future mouseMove(double fromX, double fromY, double toX, double toY, USKeyboardDefinition... modifiers) {
        return mouseMove(fromX, fromY, toX, toY, 1, modifiers);
    }

    //touch event
    Future touchStart(TouchPoint[] touchPoints, USKeyboardDefinition... modifiers);

    Future touchEnd(USKeyboardDefinition... modifiers);

    Future touchMove(TouchPoint[] touchPoints, USKeyboardDefinition... modifiers);

    Future touchCancel();

    Future close();

}
