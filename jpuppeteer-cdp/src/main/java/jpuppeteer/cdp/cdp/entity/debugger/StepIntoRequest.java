package jpuppeteer.cdp.cdp.entity.debugger;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class StepIntoRequest {

    /**
    * Debugger will issue additional Debugger.paused notification if any async task is scheduled before next pause.
    */
    private Boolean breakOnAsyncCall;



}