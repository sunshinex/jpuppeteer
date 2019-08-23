package jpuppeteer.api.constant;

public enum PermissionType {

    GEOLOCATION("geolocation"),
    MIDI("midi"),
    MIDI_SYSEX("midi-sysex"),
    PUSH("push"),
    CAMERA("camera"),
    MICROPHONE("microphone"),
    BACKGROUND_SYNC("background-sync"),
    AMBIENT_LIGHT_SENSOR("ambient-light-sensor"),
    ACCELEROMETER("accelerometer"),
    GYROSCOPE("gyroscope"),
    MAGNETOMETER("magnetometer"),
    ACCESSIBILITY_EVENTS("accessibility-events"),
    CLIPBOARD_READ("clipboard-read"),
    CLIPBOARD_WRITE("clipboard-write"),
    PAYMENT_HANDLER("payment-handler")
    ;

    private String value;

    PermissionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
