package jpuppeteer.cdp.client.entity.page;

/**
* Emitted only when `page.interceptFileChooser` is enabled.
*/
public class FileChooserOpenedEvent {

    /**
    * Id of the frame containing input node.
    */
    private String frameId;

    /**
    * Input node id.
    */
    private Integer backendNodeId;

    /**
    * Input mode.
    */
    private jpuppeteer.cdp.client.constant.page.FileChooserOpenedEventMode mode;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setMode (jpuppeteer.cdp.client.constant.page.FileChooserOpenedEventMode mode) {
        this.mode = mode;
    }

    public jpuppeteer.cdp.client.constant.page.FileChooserOpenedEventMode getMode() {
        return this.mode;
    }

    public FileChooserOpenedEvent(String frameId, Integer backendNodeId, jpuppeteer.cdp.client.constant.page.FileChooserOpenedEventMode mode) {
        this.frameId = frameId;
        this.backendNodeId = backendNodeId;
        this.mode = mode;
    }

    public FileChooserOpenedEvent() {
    }

}