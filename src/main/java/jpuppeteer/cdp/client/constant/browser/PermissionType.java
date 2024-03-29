package jpuppeteer.cdp.client.constant.browser;

/**
*/
public enum PermissionType implements jpuppeteer.cdp.client.CDPEnum {

    ACCESSIBILITYEVENTS("accessibilityEvents"),
    AUDIOCAPTURE("audioCapture"),
    BACKGROUNDSYNC("backgroundSync"),
    BACKGROUNDFETCH("backgroundFetch"),
    CLIPBOARDREADWRITE("clipboardReadWrite"),
    CLIPBOARDSANITIZEDWRITE("clipboardSanitizedWrite"),
    DISPLAYCAPTURE("displayCapture"),
    DURABLESTORAGE("durableStorage"),
    FLASH("flash"),
    GEOLOCATION("geolocation"),
    MIDI("midi"),
    MIDISYSEX("midiSysex"),
    NFC("nfc"),
    NOTIFICATIONS("notifications"),
    PAYMENTHANDLER("paymentHandler"),
    PERIODICBACKGROUNDSYNC("periodicBackgroundSync"),
    PROTECTEDMEDIAIDENTIFIER("protectedMediaIdentifier"),
    SENSORS("sensors"),
    VIDEOCAPTURE("videoCapture"),
    VIDEOCAPTUREPANTILTZOOM("videoCapturePanTiltZoom"),
    IDLEDETECTION("idleDetection"),
    WAKELOCKSCREEN("wakeLockScreen"),
    WAKELOCKSYSTEM("wakeLockSystem"),
    ;

    private String value;

    PermissionType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static PermissionType findByValue(String value) {
        for(PermissionType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}