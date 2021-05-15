package jpuppeteer.util;

import com.google.common.collect.Lists;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import jpuppeteer.cdp.client.constant.input.DispatchKeyEventRequestType;
import jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestPointerType;
import jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestType;
import jpuppeteer.cdp.client.constant.input.DispatchTouchEventRequestType;
import jpuppeteer.cdp.client.entity.input.InsertTextRequest;
import jpuppeteer.cdp.client.entity.input.SetIgnoreInputEventsRequest;
import jpuppeteer.cdp.client.entity.input.TouchPoint;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.constant.USKeyboardDefinition;
import jpuppeteer.entity.Point;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Input {
    
    private final jpuppeteer.cdp.client.domain.Input input;
    
    private final EventExecutor executor;

    /**
     * 页面上按下的键盘
     */
    private final Set<USKeyboardDefinition> pressedKeys;

    /**
     * 页面上按下的鼠标按键
     */
    private final Set<MouseDefinition> pressedButtons;

    private final EventExecutor inputExecutor;

    private final AtomicInteger mouseX;

    private final AtomicInteger mouseY;

    public Input(jpuppeteer.cdp.client.domain.Input input, EventExecutor executor) {
        this.input = input;
        this.executor = executor;
        this.pressedKeys = ConcurrentHashMap.newKeySet();
        this.pressedButtons = ConcurrentHashMap.newKeySet();
        this.inputExecutor = new DefaultEventExecutor(r -> {
            return new Thread(r, "INPUT-THREAD");
        });
        this.mouseX = new AtomicInteger(0);
        this.mouseY = new AtomicInteger(0);
    }

    private static int getModifier(Set<USKeyboardDefinition> modifiers) {
        int mod = 0;
        for(USKeyboardDefinition key : modifiers) {
            switch (key) {
                case ALTLEFT:
                case ALTRIGHT:
                case ALT:
                    mod |= 1;
                    break;

                case CONTROLLEFT:
                case CONTROLRIGHT:
                case CONTROL:
                    mod |= 2;
                    break;

                case METALEFT:
                case METARIGHT:
                case META:
                    mod |= 4;
                    break;

                case SHIFTLEFT:
                case SHIFTRIGHT:
                case SHIFT:
                    mod |= 8;
                    break;
            }
        }

        return mod;
    }

    private static int getButtons(Set<MouseDefinition> buttons) {
        int mod = 0;
        for(MouseDefinition btn : buttons) {
            mod |= btn.getCode();
        }
        return mod;
    }

    public Future enable() {
        return input.setIgnoreInputEvents(new SetIgnoreInputEventsRequest(false));
    }

    public Future disable() {
        return input.setIgnoreInputEvents(new SetIgnoreInputEventsRequest(true));
    }
    
    public Future keyDown(USKeyboardDefinition key) {
        pressedKeys.add(key);
        int keyModifiers = getModifier(pressedKeys);
        boolean shift = (keyModifiers & 8) == 8;
        String keyStr = shift && key.getShiftKey() != null ? key.getShiftKey() : key.getKey();

        DispatchKeyEventRequestBuilder builder = new DispatchKeyEventRequestBuilder();
        builder.modifiers(keyModifiers);
        builder.windowsVirtualKeyCode(shift && key.getShiftKeyCode() != null ? key.getShiftKeyCode() : key.getKeyCode());
        builder.code(key.getCode());
        builder.key(keyStr);
        builder.location(key.getLocation() != null ? key.getLocation() : 0);
        builder.isKeypad(key.getLocation() != null && key.getLocation() == 3);
        builder.autoRepeat(pressedKeys.contains(key));

        builder.type(DispatchKeyEventRequestType.RAWKEYDOWN);
        if (keyStr.length() == 1) {
            builder.text(keyStr);
            builder.unmodifiedText(keyStr);
        }
        if ((keyModifiers & ~8) != 0) {
            builder.text(null);
            builder.unmodifiedText(null);
        }
        if (keyStr != null) {
            builder.type(DispatchKeyEventRequestType.KEYDOWN);
        }
        return input.dispatchKeyEvent(builder.build());
    }

    
    public Future keyUp(USKeyboardDefinition key) {
        int keyModifiers = getModifier(pressedKeys);
        boolean shift = (keyModifiers & 8) == 8;
        DispatchKeyEventRequestBuilder builder = new DispatchKeyEventRequestBuilder();
        builder.modifiers(keyModifiers);
        builder.windowsVirtualKeyCode(shift && key.getShiftKeyCode() != null ? key.getShiftKeyCode() : key.getKeyCode());
        builder.code(key.getCode());
        builder.key(shift && key.getShiftKey() != null ? key.getShiftKey() : key.getKey());
        builder.location(key.getLocation() != null ? key.getLocation() : 0);
        builder.isKeypad(key.getLocation() != null && key.getLocation() == 3);
        builder.type(DispatchKeyEventRequestType.KEYUP);
        pressedKeys.remove(key);
        return input.dispatchKeyEvent(builder.build());
    }

    
    public Future press(USKeyboardDefinition key, int delay) {
        return SeriesFuture
                .wrap(keyDown(key))
                //此处单纯为了延迟，没啥鸟用
                .async(o -> executor.schedule(() -> o, delay, TimeUnit.MILLISECONDS))
                .async(o -> keyUp(key));
    }

    public Future input(String text) {
        InsertTextRequest request = new InsertTextRequest(text);
        return input.insertText(request);
    }

    private DispatchMouseEventRequestBuilder mouseEventBuilder(MouseDefinition mouseDefinition, int x, int y) {
        int keyModifiers = getModifier(pressedKeys);
        DispatchMouseEventRequestBuilder builder = new DispatchMouseEventRequestBuilder();
        builder.button(mouseDefinition.getButton());
        builder.buttons(getButtons(pressedButtons));
        builder.modifiers(keyModifiers);
        builder.pointerType(DispatchMouseEventRequestPointerType.MOUSE);
        builder.x(BigDecimal.valueOf(x));
        builder.y(BigDecimal.valueOf(y));
        return builder;
    }

    
    public Future<Point> mouseDown(MouseDefinition mouseDefinition) {
        return mouseDown(mouseDefinition, 1);
    }

    public Future<Point> mouseDown(MouseDefinition mouseDefinition, int count) {
        Point mousePosition = new Point(mouseX.get(), mouseY.get());
        pressedButtons.add(mouseDefinition);
        DispatchMouseEventRequestBuilder builder = mouseEventBuilder(mouseDefinition, mousePosition.x, mousePosition.y);
        builder.type(DispatchMouseEventRequestType.MOUSEPRESSED);
        builder.clickCount(count);
        return SeriesFuture
                .wrap(input.dispatchMouseEvent(builder.build()))
                .sync(o -> mousePosition);
    }

    
    public Future<Point> mouseUp(MouseDefinition mouseDefinition) {
        return mouseUp(mouseDefinition, 1);
    }

    public Future<Point> mouseUp(MouseDefinition mouseDefinition, int count) {
        Point mousePosition = new Point(mouseX.get(), mouseY.get());
        DispatchMouseEventRequestBuilder builder = mouseEventBuilder(mouseDefinition, mousePosition.x, mousePosition.y);
        builder.type(DispatchMouseEventRequestType.MOUSERELEASED);
        builder.clickCount(count);
        pressedButtons.remove(mouseDefinition);
        return SeriesFuture
                .wrap(input.dispatchMouseEvent(builder.build()))
                .sync(o -> mousePosition);
    }

    public Future<Point> click(MouseDefinition mouseDefinition, int delay) {
        Point mousePosition = new Point(mouseX.get(), mouseY.get());
        return SeriesFuture
                .wrap(mouseMove(mousePosition.x, mousePosition.y))
                .async(o -> mouseDown(mouseDefinition))
                //此处单纯为了延迟，没啥鸟用
                .async(o -> executor.schedule(() -> o, delay, TimeUnit.MILLISECONDS))
                .async(o -> mouseUp(mouseDefinition));
    }

    public Future<Point> mouseMove(int x, int y) {
        DispatchMouseEventRequestBuilder builder = mouseEventBuilder(MouseDefinition.NONE, x, y);
        builder.type(DispatchMouseEventRequestType.MOUSEMOVED);
        builder.x(BigDecimal.valueOf(x));
        builder.y(BigDecimal.valueOf(y));
        return SeriesFuture
                .wrap(input.dispatchMouseEvent(builder.build()))
                .sync(o -> {
                    mouseX.set(x);
                    mouseY.set(y);
                    return new Point(x, y);
                });
    }

    public Point mousePosition() {
        return new Point(mouseX.get(), mouseY.get());
    }

    public Future mouseWheel(int deltaX, int deltaY) {
        Point mousePosition = new Point(mouseX.get(), mouseY.get());
        DispatchMouseEventRequestBuilder builder = mouseEventBuilder(MouseDefinition.NONE, mousePosition.x, mousePosition.y);
        builder.type(DispatchMouseEventRequestType.MOUSEWHEEL)
                .deltaX(BigDecimal.valueOf(deltaX))
                .deltaY(BigDecimal.valueOf(deltaY));
        return input.dispatchMouseEvent(builder.build());
    }

    private DispatchTouchEventRequestBuilder touchEventBuilder(TouchPoint[] touchPoints) {
        DispatchTouchEventRequestBuilder builder = new DispatchTouchEventRequestBuilder();
        builder.modifiers(getModifier(pressedKeys));
        if (touchPoints != null && touchPoints.length > 0) {
            builder.touchPoints(Lists.newArrayList(touchPoints));
        } else {
            builder.touchPoints(Collections.EMPTY_LIST);
        }
        return builder;
    }

    
    public Future<TouchPoint[]> touchStart(TouchPoint[] touchPoints) {
        DispatchTouchEventRequestBuilder builder = touchEventBuilder(touchPoints);
        builder.type(DispatchTouchEventRequestType.TOUCHSTART);
        return SeriesFuture
                .wrap(input.dispatchTouchEvent(builder.build()))
                .sync(o -> touchPoints);
    }

    private TouchPoint createTouchPoint(int x, int y) {
        return new TouchPoint(BigDecimal.valueOf(x), BigDecimal.valueOf(y));
    }

    public Future<TouchPoint[]> touchStart(int x, int y) {
        return touchStart(new TouchPoint[]{createTouchPoint(x, y)});
    }

    public Future touchEnd() {
        DispatchTouchEventRequestBuilder builder = touchEventBuilder(null);
        builder.type(DispatchTouchEventRequestType.TOUCHEND);
        return input.dispatchTouchEvent(builder.build());
    }

    
    public Future<TouchPoint[]> touchMove(TouchPoint[] touchPoints) {
        DispatchTouchEventRequestBuilder builder = touchEventBuilder(touchPoints);
        builder.type(DispatchTouchEventRequestType.TOUCHMOVE);
        return SeriesFuture
                .wrap(input.dispatchTouchEvent(builder.build()))
                .sync(o -> touchPoints);
    }

    public Future<TouchPoint[]> touchMove(int x, int y) {
        return touchMove(new TouchPoint[]{createTouchPoint(x, y)});
    }

    public Future touchCancel() {
        DispatchTouchEventRequestBuilder builder = touchEventBuilder(null);
        builder.type(DispatchTouchEventRequestType.TOUCHCANCEL);
        return input.dispatchTouchEvent(builder.build());
    }
    
}
