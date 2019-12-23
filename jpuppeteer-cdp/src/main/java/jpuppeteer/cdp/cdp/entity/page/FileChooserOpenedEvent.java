package jpuppeteer.cdp.cdp.entity.page;

/**
* Emitted only when `page.interceptFileChooser` is enabled.
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class FileChooserOpenedEvent {

    /**
    */
    private String mode;



}