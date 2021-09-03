package jpuppeteer.cdp.client.constant.emulation;

/**
*/
public enum SetEmulatedVisionDeficiencyRequestType implements jpuppeteer.cdp.client.CDPEnum {

    NONE("none"),
    ACHROMATOPSIA("achromatopsia"),
    BLURREDVISION("blurredVision"),
    DEUTERANOPIA("deuteranopia"),
    PROTANOPIA("protanopia"),
    TRITANOPIA("tritanopia"),
    ;

    private String value;

    SetEmulatedVisionDeficiencyRequestType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static SetEmulatedVisionDeficiencyRequestType findByValue(String value) {
        for(SetEmulatedVisionDeficiencyRequestType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}