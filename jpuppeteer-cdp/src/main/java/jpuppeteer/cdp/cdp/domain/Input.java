package jpuppeteer.cdp.cdp.domain;

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
    public void dispatchKeyEvent(jpuppeteer.cdp.cdp.entity.input.DispatchKeyEventRequest request, int timeout) throws Exception {
        session.send("Input.dispatchKeyEvent", request, timeout);
    }


    /**
    * This method emulates inserting text that doesn't come from a key press, for example an emoji keyboard or an IME.
    */
    public void insertText(jpuppeteer.cdp.cdp.entity.input.InsertTextRequest request, int timeout) throws Exception {
        session.send("Input.insertText", request, timeout);
    }


    /**
    * Dispatches a mouse event to the page.
    */
    public void dispatchMouseEvent(jpuppeteer.cdp.cdp.entity.input.DispatchMouseEventRequest request, int timeout) throws Exception {
        session.send("Input.dispatchMouseEvent", request, timeout);
    }


    /**
    * Dispatches a touch event to the page.
    */
    public void dispatchTouchEvent(jpuppeteer.cdp.cdp.entity.input.DispatchTouchEventRequest request, int timeout) throws Exception {
        session.send("Input.dispatchTouchEvent", request, timeout);
    }


    /**
    * Emulates touch event from the mouse event parameters.
    */
    public void emulateTouchFromMouseEvent(jpuppeteer.cdp.cdp.entity.input.EmulateTouchFromMouseEventRequest request, int timeout) throws Exception {
        session.send("Input.emulateTouchFromMouseEvent", request, timeout);
    }


    /**
    * Ignores input events (useful while auditing page).
    */
    public void setIgnoreInputEvents(jpuppeteer.cdp.cdp.entity.input.SetIgnoreInputEventsRequest request, int timeout) throws Exception {
        session.send("Input.setIgnoreInputEvents", request, timeout);
    }


    /**
    * Synthesizes a pinch gesture over a time period by issuing appropriate touch events.
    */
    public void synthesizePinchGesture(jpuppeteer.cdp.cdp.entity.input.SynthesizePinchGestureRequest request, int timeout) throws Exception {
        session.send("Input.synthesizePinchGesture", request, timeout);
    }


    /**
    * Synthesizes a scroll gesture over a time period by issuing appropriate touch events.
    */
    public void synthesizeScrollGesture(jpuppeteer.cdp.cdp.entity.input.SynthesizeScrollGestureRequest request, int timeout) throws Exception {
        session.send("Input.synthesizeScrollGesture", request, timeout);
    }


    /**
    * Synthesizes a tap gesture over a time period by issuing appropriate touch events.
    */
    public void synthesizeTapGesture(jpuppeteer.cdp.cdp.entity.input.SynthesizeTapGestureRequest request, int timeout) throws Exception {
        session.send("Input.synthesizeTapGesture", request, timeout);
    }

}