package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetEmulatedVisionDeficiencyRequest {

    /**
    * Vision deficiency to emulate.
    */
    private jpuppeteer.cdp.client.constant.emulation.SetEmulatedVisionDeficiencyRequestType type;

    public void setType (jpuppeteer.cdp.client.constant.emulation.SetEmulatedVisionDeficiencyRequestType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.emulation.SetEmulatedVisionDeficiencyRequestType getType() {
        return this.type;
    }

    public SetEmulatedVisionDeficiencyRequest(jpuppeteer.cdp.client.constant.emulation.SetEmulatedVisionDeficiencyRequestType type) {
        this.type = type;
    }

    public SetEmulatedVisionDeficiencyRequest() {
    }

}