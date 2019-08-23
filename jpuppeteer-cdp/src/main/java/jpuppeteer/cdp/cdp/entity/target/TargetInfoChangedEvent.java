package jpuppeteer.cdp.cdp.entity.target;

/**
* Issued when some information about a target has changed. This only happens between `targetCreated` and `targetDestroyed`.
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class TargetInfoChangedEvent {

    /**
    */
    private jpuppeteer.cdp.cdp.entity.target.TargetInfo targetInfo;



}