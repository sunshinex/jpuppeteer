package jpuppeteer.cdp.cdp.entity.target;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class ExposeDevToolsProtocolRequest {

    /**
    */
    private String targetId;

    /**
    * Binding name, 'cdp' if not specified.
    */
    private String bindingName;



}