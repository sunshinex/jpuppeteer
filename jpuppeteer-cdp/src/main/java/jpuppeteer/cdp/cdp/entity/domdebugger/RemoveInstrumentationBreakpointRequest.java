package jpuppeteer.cdp.cdp.entity.domdebugger;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class RemoveInstrumentationBreakpointRequest {

    /**
    * Instrumentation name to stop on.
    */
    private String eventName;



}