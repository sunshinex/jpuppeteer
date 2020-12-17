package jpuppeteer.util;

import com.google.common.collect.Lists;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import jpuppeteer.cdp.client.constant.input.DispatchKeyEventRequestType;
import jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestPointerType;
import jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestType;
import jpuppeteer.cdp.client.constant.input.DispatchTouchEventRequestType;
import jpuppeteer.cdp.client.entity.input.InsertTextRequest;
import jpuppeteer.cdp.client.entity.input.TouchPoint;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.constant.USKeyboardDefinition;
import jpuppeteer.entity.Coordinate;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Input {
    
    private final jpuppeteer.cdp.client.domain.Input input;
    
    private final EventExecutor executor;

    public Input(jpuppeteer.cdp.client.domain.Input input, EventExecutor executor) {
        this.input = input;
        this.executor = executor;
    }

    private static int getModifier(USKeyboardDefinition... modifiers) {
        int mod = 0;
        for(USKeyboardDefinition key : modifiers) {
            switch (key) {
                case ALTLEFT:
                case ALTRIGHT:
                case ALT:
                    mod &= ~1;
                    break;

                case CONTROLLEFT:
                case CONTROLRIGHT:
                case CONTROL:
                    mod &= ~2;
                    break;

                case METALEFT:
                case METARIGHT:
                case META:
                    mod &= ~4;
                    break;

                case SHIFTLEFT:
                case SHIFTRIGHT:
                case SHIFT:
                    mod &= ~8;
                    break;
            }
        }

        return mod;
    }

    
    public Future keyDown(USKeyboardDefinition key, USKeyboardDefinition... modifiers) {
        int keyModifiers = getModifier(modifiers);
        boolean shift = (keyModifiers & 8) == 8;
        String keyStr = shift && key.getShiftKey() != null ? key.getShiftKey() : key.getKey();

        DispatchKeyEventRequestBuilder builder = new DispatchKeyEventRequestBuilder();
        builder.modifiers(keyModifiers);
        builder.windowsVirtualKeyCode(shift && key.getShiftKeyCode() != null ? key.getShiftKeyCode() : key.getKeyCode());
        builder.code(key.getCode());
        builder.key(keyStr);
        builder.location(key.getLocation() != null ? key.getLocation() : 0);
        builder.isKeypad(key.getLocation() != null && key.getLocation() == 3);
        builder.autoRepeat(false);

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

    
    public Future keyUp(USKeyboardDefinition key, USKeyboardDefinition... modifiers) {
        int keyModifiers = getModifier(modifiers);
        boolean shift = (keyModifiers & 8) == 8;
        DispatchKeyEventRequestBuilder builder = new DispatchKeyEventRequestBuilder();
        builder.modifiers(keyModifiers);
        builder.windowsVirtualKeyCode(shift && key.getShiftKeyCode() != null ? key.getShiftKeyCode() : key.getKeyCode());
        builder.code(key.getCode());
        builder.key(shift && key.getShiftKey() != null ? key.getShiftKey() : key.getKey());
        builder.location(key.getLocation() != null ? key.getLocation() : 0);
        builder.isKeypad(key.getLocation() != null && key.getLocation() == 3);
        builder.type(DispatchKeyEventRequestType.KEYUP);
        return input.dispatchKeyEvent(builder.build());
    }

    
    public Future press(USKeyboardDefinition key, int delay, USKeyboardDefinition... modifiers) {
        return SeriesFuture
                .wrap(keyDown(key, modifiers))
                .async(o -> executor.schedule(
                        () -> keyUp(key, modifiers),
                        delay,
                        TimeUnit.MILLISECONDS
                ));
    }

    public Future input(String text) {
        InsertTextRequest request = new InsertTextRequest(text);
        return input.insertText(request);
    }

    private DispatchMouseEventRequestBuilder mouseEventBuilder(MouseDefinition mouseDefinition, double x, double y, USKeyboardDefinition... modifiers) {
        int keyModifiers = getModifier(modifiers);
        DispatchMouseEventRequestBuilder builder = new DispatchMouseEventRequestBuilder();
        builder.button(mouseDefinition.getButton());
        builder.buttons(mouseDefinition.getCode());
        builder.modifiers(keyModifiers);
        builder.pointerType(DispatchMouseEventRequestPointerType.MOUSE);
        builder.x(BigDecimal.valueOf(x));
        builder.y(BigDecimal.valueOf(y));
        return builder;
    }

    private Future<Coordinate> doMouseDown(MouseDefinition mouseDefinition, double x, double y, int count, USKeyboardDefinition... modifiers) {
        DispatchMouseEventRequestBuilder builder = mouseEventBuilder(mouseDefinition, x, y, modifiers);
        builder.type(DispatchMouseEventRequestType.MOUSEPRESSED);
        builder.clickCount(count);
        return SeriesFuture
                .wrap(input.dispatchMouseEvent(builder.build()))
                .sync(o -> new Coordinate(x, y));
    }

    private Future<Coordinate> doMouseUp(MouseDefinition mouseDefinition, double x, double y, int count, USKeyboardDefinition... modifiers) {
        DispatchMouseEventRequestBuilder builder = mouseEventBuilder(mouseDefinition, x, y, modifiers);
        builder.type(DispatchMouseEventRequestType.MOUSERELEASED);
        builder.clickCount(count);
        return SeriesFuture
                .wrap(input.dispatchMouseEvent(builder.build()))
                .sync(o -> new Coordinate(x, y));
    }

    private Future<Coordinate> doMouseMove(double x, double y, USKeyboardDefinition... modifiers) {
        DispatchMouseEventRequestBuilder builder = mouseEventBuilder(MouseDefinition.NONE, x, y, modifiers);
        builder.type(DispatchMouseEventRequestType.MOUSEMOVED);
        builder.x(BigDecimal.valueOf(x));
        builder.y(BigDecimal.valueOf(y));
        return SeriesFuture
                .wrap(input.dispatchMouseEvent(builder.build()))
                .sync(o -> new Coordinate(x, y));
    }

    
    public Future<Coordinate> mouseDown(MouseDefinition mouseDefinition, double x, double y, USKeyboardDefinition... modifiers) {
        return doMouseDown(mouseDefinition, x, y, 1, modifiers);
    }

    
    public Future<Coordinate> mouseUp(MouseDefinition mouseDefinition, double x, double y, USKeyboardDefinition... modifiers) {
        return doMouseUp(mouseDefinition, x, y, 1, modifiers);
    }

    
    public Future<Coordinate> mouseMove(double fromX, double fromY, double toX, double toY, int steps, USKeyboardDefinition... modifiers) {
        double stepX = (toX - fromX) / steps;
        double stepY = (toY - fromY) / steps;
        //初始化位置从0开始
        SeriesFuture next = SeriesFuture.wrap(doMouseMove(0, 0, modifiers));
        for(int i = 0; i<steps; i++) {
            double x = fromX + stepX * i;
            double y = fromY + stepY * i;
            next = next.async(o -> doMouseMove(x, y, modifiers));
        }
        return next.async(o ->doMouseMove(toX, toY, modifiers));
    }

    private DispatchTouchEventRequestBuilder touchEventBuilder(TouchPoint[] touchPoints, USKeyboardDefinition... modifiers) {
        DispatchTouchEventRequestBuilder builder = new DispatchTouchEventRequestBuilder();
        builder.modifiers(getModifier(modifiers));
        if (touchPoints != null && touchPoints.length > 0) {
            builder.touchPoints(Lists.newArrayList(touchPoints));
        } else {
            builder.touchPoints(Collections.EMPTY_LIST);
        }
        return builder;
    }

    
    public Future<TouchPoint[]> touchStart(TouchPoint[] touchPoints, USKeyboardDefinition... modifiers) {
        DispatchTouchEventRequestBuilder builder = touchEventBuilder(touchPoints, modifiers);
        builder.type(DispatchTouchEventRequestType.TOUCHSTART);
        return SeriesFuture
                .wrap(input.dispatchTouchEvent(builder.build()))
                .sync(o -> touchPoints);
    }

    private TouchPoint createTouchPoint(double x, double y) {
        return new TouchPoint(BigDecimal.valueOf(x), BigDecimal.valueOf(y));
    }

    public Future<TouchPoint[]> touchStart(int x, int y, USKeyboardDefinition... modifiers) {
        return touchStart(new TouchPoint[]{createTouchPoint(x, y)}, modifiers);
    }

    
    public Future touchEnd(USKeyboardDefinition... modifiers) {
        DispatchTouchEventRequestBuilder builder = touchEventBuilder(null, modifiers);
        builder.type(DispatchTouchEventRequestType.TOUCHEND);
        return input.dispatchTouchEvent(builder.build());
    }

    
    public Future<TouchPoint[]> touchMove(TouchPoint[] touchPoints, USKeyboardDefinition... modifiers) {
        DispatchTouchEventRequestBuilder builder = touchEventBuilder(touchPoints, modifiers);
        builder.type(DispatchTouchEventRequestType.TOUCHMOVE);
        return SeriesFuture
                .wrap(input.dispatchTouchEvent(builder.build()))
                .sync(o -> touchPoints);
    }

    public Future<TouchPoint[][]> touchMove(int fromX, int fromY, int toX, int toY, int steps, USKeyboardDefinition... modifiers) {
        TouchPoint[][] tracks = new TouchPoint[steps][1];
        TouchPoint[] start = new TouchPoint[]{createTouchPoint(fromX, fromY)};
        tracks[0] = start;
        double stepX = Math.ceil((toX - fromX) / steps);
        double stepY = Math.ceil((toY - fromY) / steps);
        //初始化位置
        SeriesFuture future = SeriesFuture
                .wrap(touchMove(start, modifiers));
        //开始移动
        for(int i=1; i<steps; i++) {
            double x = fromX + stepX * i;
            double y = fromY + stepY * i;
            TouchPoint[] point = new TouchPoint[]{createTouchPoint(x, y)};
            tracks[i] = point;
            future = future.async(o -> touchMove(point, modifiers));
        }

        return future.sync(o -> tracks);
    }

    
    public Future touchCancel(USKeyboardDefinition... modifiers) {
        DispatchTouchEventRequestBuilder builder = touchEventBuilder(null, modifiers);
        builder.type(DispatchTouchEventRequestType.TOUCHCANCEL);
        return input.dispatchTouchEvent(builder.build());
    }
    
}
