package jpuppeteer.cdp.client.entity.page;

/**
* Emitted only when `page.interceptFileChooser` is enabled.
*/
public class FileChooserOpenedEvent {

    /**
    * Id of the frame containing input node.
    */
    public final String frameId;

    /**
    * Input node id.
    */
    public final Integer backendNodeId;

    /**
    * Input mode.
    */
    public final jpuppeteer.cdp.client.constant.page.FileChooserOpenedEventMode mode;

    public FileChooserOpenedEvent(String frameId, Integer backendNodeId, jpuppeteer.cdp.client.constant.page.FileChooserOpenedEventMode mode) {
        this.frameId = frameId;
        this.backendNodeId = backendNodeId;
        this.mode = mode;
    }

}