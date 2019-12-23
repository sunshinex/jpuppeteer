package jpuppeteer.cdp.cdp.entity.page;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class HandleFileChooserRequest {

    /**
    */
    private String action;

    /**
    * Array of absolute file paths to set, only respected with `accept` action.
    */
    private java.util.List<String> files;



}