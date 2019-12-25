package jpuppeteer.cdp.cdp.entity.target;

/**
* Issued when a possible inspection target is created.
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class TargetCreatedEvent {

    /**
    */
    private jpuppeteer.cdp.cdp.entity.target.TargetInfo targetInfo;



}