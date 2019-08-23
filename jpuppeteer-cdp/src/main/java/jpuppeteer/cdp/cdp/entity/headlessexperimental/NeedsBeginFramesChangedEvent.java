package jpuppeteer.cdp.cdp.entity.headlessexperimental;

/**
* Issued when the target starts or stops needing BeginFrames.
* experimental
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class NeedsBeginFramesChangedEvent {

    /**
    * True if BeginFrames are needed, false otherwise.
    */
    private Boolean needsBeginFrames;



}