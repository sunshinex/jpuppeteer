package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetEmulatedVisionDeficiencyRequest {

    /**
    * Vision deficiency to emulate.
    */
    public final jpuppeteer.cdp.client.constant.emulation.SetEmulatedVisionDeficiencyRequestType type;

    public SetEmulatedVisionDeficiencyRequest(jpuppeteer.cdp.client.constant.emulation.SetEmulatedVisionDeficiencyRequestType type) {
        this.type = type;
    }

}