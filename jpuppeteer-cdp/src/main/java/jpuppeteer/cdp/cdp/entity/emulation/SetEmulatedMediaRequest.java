package jpuppeteer.cdp.cdp.entity.emulation;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class SetEmulatedMediaRequest {

    /**
    * Media type to emulate. Empty string disables the override.
    */
    private String media;



}