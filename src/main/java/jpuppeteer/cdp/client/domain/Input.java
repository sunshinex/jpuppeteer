package jpuppeteer.cdp.client.domain;

/**
*/
public class Input {

    private jpuppeteer.cdp.CDPSession session;

    public Input(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Dispatches a key event to the page.
    */
    public io.netty.util.concurrent.Future dispatchKeyEvent(jpuppeteer.cdp.client.entity.input.DispatchKeyEventRequest request) {
        return session.send("Input.dispatchKeyEvent", request);
    }


    /**
    * This method emulates inserting text that doesn't come from a key press, for example an emoji keyboard or an IME.
    * experimental
    */
    public io.netty.util.concurrent.Future insertText(jpuppeteer.cdp.client.entity.input.InsertTextRequest request) {
        return session.send("Input.insertText", request);
    }


    /**
    * Dispatches a mouse event to the page.
    */
    public io.netty.util.concurrent.Future dispatchMouseEvent(jpuppeteer.cdp.client.entity.input.DispatchMouseEventRequest request) {
        return session.send("Input.dispatchMouseEvent", request);
    }


    /**
    * Dispatches a touch event to the page.
    */
    public io.netty.util.concurrent.Future dispatchTouchEvent(jpuppeteer.cdp.client.entity.input.DispatchTouchEventRequest request) {
        return session.send("Input.dispatchTouchEvent", request);
    }


    /**
    * Emulates touch event from the mouse event parameters.
    * experimental
    */
    public io.netty.util.concurrent.Future emulateTouchFromMouseEvent(jpuppeteer.cdp.client.entity.input.EmulateTouchFromMouseEventRequest request) {
        return session.send("Input.emulateTouchFromMouseEvent", request);
    }


    /**
    * Ignores input events (useful while auditing page).
    */
    public io.netty.util.concurrent.Future setIgnoreInputEvents(jpuppeteer.cdp.client.entity.input.SetIgnoreInputEventsRequest request) {
        return session.send("Input.setIgnoreInputEvents", request);
    }


    /**
    * Synthesizes a pinch gesture over a time period by issuing appropriate touch events.
    * experimental
    */
    public io.netty.util.concurrent.Future synthesizePinchGesture(jpuppeteer.cdp.client.entity.input.SynthesizePinchGestureRequest request) {
        return session.send("Input.synthesizePinchGesture", request);
    }


    /**
    * Synthesizes a scroll gesture over a time period by issuing appropriate touch events.
    * experimental
    */
    public io.netty.util.concurrent.Future synthesizeScrollGesture(jpuppeteer.cdp.client.entity.input.SynthesizeScrollGestureRequest request) {
        return session.send("Input.synthesizeScrollGesture", request);
    }


    /**
    * Synthesizes a tap gesture over a time period by issuing appropriate touch events.
    * experimental
    */
    public io.netty.util.concurrent.Future synthesizeTapGesture(jpuppeteer.cdp.client.entity.input.SynthesizeTapGestureRequest request) {
        return session.send("Input.synthesizeTapGesture", request);
    }

}