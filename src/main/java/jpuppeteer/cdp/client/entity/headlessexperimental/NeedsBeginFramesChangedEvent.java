package jpuppeteer.cdp.client.entity.headlessexperimental;

/**
* Issued when the target starts or stops needing BeginFrames. Deprecated. Issue beginFrame unconditionally instead and use result from beginFrame to detect whether the frames were suppressed.
* experimental
*/
public class NeedsBeginFramesChangedEvent {

    /**
    * True if BeginFrames are needed, false otherwise.
    */
    public final Boolean needsBeginFrames;

    public NeedsBeginFramesChangedEvent(Boolean needsBeginFrames) {
        this.needsBeginFrames = needsBeginFrames;
    }

}