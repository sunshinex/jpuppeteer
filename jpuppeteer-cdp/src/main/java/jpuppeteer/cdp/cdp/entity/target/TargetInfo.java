package jpuppeteer.cdp.cdp.entity.target;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class TargetInfo {

    /**
    */
    private String targetId;

    /**
    */
    private String type;

    /**
    */
    private String title;

    /**
    */
    private String url;

    /**
    * Whether the target has an attached client.
    */
    private Boolean attached;

    /**
    * Opener target Id
    */
    private String openerId;

    /**
    */
    private String browserContextId;



}