package jpuppeteer.cdp.cdp.entity.target;

/**
* Issued when a target is destroyed.
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class TargetDestroyedEvent {

    /**
    */
    private String targetId;



}