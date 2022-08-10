package jpuppeteer.util;

import com.google.common.collect.Lists;
import io.netty.util.concurrent.EventExecutor;
import jpuppeteer.cdp.client.constant.input.DispatchKeyEventRequestType;
import jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestPointerType;
import jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestType;
import jpuppeteer.cdp.client.constant.input.DispatchTouchEventRequestType;
import jpuppeteer.cdp.client.entity.input.*;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.constant.USKeyboardDefinition;
import jpuppeteer.entity.Point;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings({"unchecked"})
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

    private final AtomicInteger mouseX;

    private final AtomicInteger mouseY;

    public Input(jpuppeteer.cdp.client.domain.Input input, EventExecutor executor) {
        this.input = input;
        this.executor = executor;
        this.pressedKeys = ConcurrentHashMap.newKeySet();
        this.pressedButtons = ConcurrentHashMap.newKeySet();
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

    public XFuture<?> enable() {
        return input.setIgnoreInputEvents(new SetIgnoreInputEventsRequest(false));
    }

    public XFuture<?> disable() {
        return input.setIgnoreInputEvents(new SetIgnoreInputEventsRequest(true));
    }
    
    public XFuture<?> keyDown(USKeyboardDefinition key) {
        pressedKeys.add(key);
        int keyModifiers = getModifier(pressedKeys);
        boolean shift = (keyModifiers & 8) == 8;
        String keyStr = shift && key.getShiftKey() != null ? key.getShiftKey() : key.getKey();

        DispatchKeyEventRequest request = new DispatchKeyEventRequest();
        request.setModifiers(keyModifiers);
        request.setWindowsVirtualKeyCode(shift && key.getShiftKeyCode() != null ? key.getShiftKeyCode() : key.getKeyCode());
        request.setCode(key.getCode());
        request.setKey(keyStr);
        request.setLocation(key.getLocation() != null ? key.getLocation() : 0);
        request.setIsKeypad(key.getLocation() != null && key.getLocation() == 3);
        request.setAutoRepeat(pressedKeys.contains(key));

        request.setType(DispatchKeyEventRequestType.RAWKEYDOWN);
        if (keyStr.length() == 1) {
            request.setText(keyStr);
            request.setUnmodifiedText(keyStr);
        }
        if ((keyModifiers & ~8) != 0) {
            request.setText(null);
            request.setUnmodifiedText(null);
        }
        request.setType(DispatchKeyEventRequestType.KEYDOWN);
        return input.dispatchKeyEvent(request);
    }

    
    public XFuture<?> keyUp(USKeyboardDefinition key) {
        int keyModifiers = getModifier(pressedKeys);
        boolean shift = (keyModifiers & 8) == 8;
        DispatchKeyEventRequest request = new DispatchKeyEventRequest();
        request.setModifiers(keyModifiers);
        request.setWindowsVirtualKeyCode(shift && key.getShiftKeyCode() != null ? key.getShiftKeyCode() : key.getKeyCode());
        request.setCode(key.getCode());
        request.setKey(shift && key.getShiftKey() != null ? key.getShiftKey() : key.getKey());
        request.setLocation(key.getLocation() != null ? key.getLocation() : 0);
        request.setIsKeypad(key.getLocation() != null && key.getLocation() == 3);
        request.setType(DispatchKeyEventRequestType.KEYUP);
        pressedKeys.remove(key);
        return input.dispatchKeyEvent(request);
    }

    
    public XFuture<?> press(USKeyboardDefinition key, int delay) {
        return keyDown(key)
                //此处单纯为了延迟，没啥鸟用
                .async(o -> executor.schedule(() -> o, delay, TimeUnit.MILLISECONDS))
                .async(o -> keyUp(key));
    }

    public XFuture<?> input(String text) {
        InsertTextRequest request = new InsertTextRequest(text);
        return input.insertText(request);
    }

    private DispatchMouseEventRequest mouseEventBuilder(MouseDefinition mouseDefinition, int x, int y) {
        int keyModifiers = getModifier(pressedKeys);
        DispatchMouseEventRequest request = new DispatchMouseEventRequest();
        request.setButton(mouseDefinition.getButton());
        request.setButtons(getButtons(pressedButtons));
        request.setModifiers(keyModifiers);
        request.setPointerType(DispatchMouseEventRequestPointerType.MOUSE);
        request.setX(BigDecimal.valueOf(x));
        request.setY(BigDecimal.valueOf(y));
        return request;
    }

    
    public XFuture<Point> mouseDown(MouseDefinition mouseDefinition) {
        return mouseDown(mouseDefinition, 1);
    }

    public XFuture<Point> mouseDown(MouseDefinition mouseDefinition, int count) {
        Point mousePosition = new Point(mouseX.get(), mouseY.get());
        pressedButtons.add(mouseDefinition);
        DispatchMouseEventRequest request = mouseEventBuilder(mouseDefinition, mousePosition.x, mousePosition.y);
        request.setType(DispatchMouseEventRequestType.MOUSEPRESSED);
        request.setClickCount(count);
        return input.dispatchMouseEvent(request)
                .sync(o -> mousePosition);
    }

    
    public XFuture<Point> mouseUp(MouseDefinition mouseDefinition) {
        return mouseUp(mouseDefinition, 1);
    }

    public XFuture<Point> mouseUp(MouseDefinition mouseDefinition, int count) {
        Point mousePosition = new Point(mouseX.get(), mouseY.get());
        DispatchMouseEventRequest request = mouseEventBuilder(mouseDefinition, mousePosition.x, mousePosition.y);
        request.setType(DispatchMouseEventRequestType.MOUSERELEASED);
        request.setClickCount(count);
        pressedButtons.remove(mouseDefinition);
        return input.dispatchMouseEvent(request)
                .sync(o -> mousePosition);
    }

    public XFuture<Point> click(MouseDefinition mouseDefinition, int delay) {
        Point mousePosition = new Point(mouseX.get(), mouseY.get());
        return mouseMove(mousePosition.x, mousePosition.y)
                .async(o -> mouseDown(mouseDefinition))
                //此处单纯为了延迟，没啥鸟用
                .async(o -> executor.schedule(() -> o, delay, TimeUnit.MILLISECONDS))
                .async(o -> mouseUp(mouseDefinition));
    }

    public XFuture<Point> mouseMove(int x, int y) {
        DispatchMouseEventRequest request = mouseEventBuilder(MouseDefinition.NONE, x, y);
        request.setType(DispatchMouseEventRequestType.MOUSEMOVED);
        request.setX(BigDecimal.valueOf(x));
        request.setY(BigDecimal.valueOf(y));
        mouseX.set(x);
        mouseY.set(y);
        return input.dispatchMouseEvent(request)
                .sync(o -> new Point(x, y));
    }

    public Point mousePosition() {
        return new Point(mouseX.get(), mouseY.get());
    }

    public XFuture<?> mouseWheel(int deltaX, int deltaY) {
        Point mousePosition = new Point(mouseX.get(), mouseY.get());
        DispatchMouseEventRequest request = mouseEventBuilder(MouseDefinition.NONE, mousePosition.x, mousePosition.y);
        request.setType(DispatchMouseEventRequestType.MOUSEWHEEL);
        request.setDeltaX(BigDecimal.valueOf(deltaX));
        request.setDeltaY(BigDecimal.valueOf(deltaY));
        return input.dispatchMouseEvent(request);
    }

    private DispatchTouchEventRequest touchEventBuilder(TouchPoint[] touchPoints) {
        DispatchTouchEventRequest builder = new DispatchTouchEventRequest();
        builder.setModifiers(getModifier(pressedKeys));
        if (touchPoints != null && touchPoints.length > 0) {
            builder.setTouchPoints(Lists.newArrayList(touchPoints));
        } else {
            builder.setTouchPoints(Collections.EMPTY_LIST);
        }
        return builder;
    }

    
    public XFuture<TouchPoint[]> touchStart(TouchPoint[] touchPoints) {
        DispatchTouchEventRequest request = touchEventBuilder(touchPoints);
        request.setType(DispatchTouchEventRequestType.TOUCHSTART);
        return input.dispatchTouchEvent(request)
                .sync(o -> touchPoints);
    }

    private TouchPoint createTouchPoint(int x, int y) {
        return new TouchPoint(BigDecimal.valueOf(x), BigDecimal.valueOf(y));
    }

    public XFuture<TouchPoint[]> touchStart(int x, int y) {
        return touchStart(new TouchPoint[]{createTouchPoint(x, y)});
    }

    public XFuture<?> touchEnd() {
        DispatchTouchEventRequest request = touchEventBuilder(null);
        request.setType(DispatchTouchEventRequestType.TOUCHEND);
        return input.dispatchTouchEvent(request);
    }

    
    public XFuture<TouchPoint[]> touchMove(TouchPoint[] touchPoints) {
        DispatchTouchEventRequest request = touchEventBuilder(touchPoints);
        request.setType(DispatchTouchEventRequestType.TOUCHMOVE);
        return input.dispatchTouchEvent(request)
                .sync(o -> touchPoints);
    }

    public XFuture<TouchPoint[]> touchMove(int x, int y) {
        return touchMove(new TouchPoint[]{createTouchPoint(x, y)});
    }

    public XFuture<?> touchCancel() {
        DispatchTouchEventRequest request = touchEventBuilder(null);
        request.setType(DispatchTouchEventRequestType.TOUCHCANCEL);
        return input.dispatchTouchEvent(request);
    }
    
}
