package jpuppeteer.cdp.client.constant.page;

/**
* All Permissions Policy features. This enum should match the one defined in third_party/blink/renderer/core/permissions_policy/permissions_policy_features.json5.
*/
public enum PermissionsPolicyFeature implements jpuppeteer.cdp.client.CDPEnum {

    ACCELEROMETER("accelerometer"),
    AMBIENT_LIGHT_SENSOR("ambient-light-sensor"),
    ATTRIBUTION_REPORTING("attribution-reporting"),
    AUTOPLAY("autoplay"),
    CAMERA("camera"),
    CH_DPR("ch-dpr"),
    CH_DEVICE_MEMORY("ch-device-memory"),
    CH_DOWNLINK("ch-downlink"),
    CH_ECT("ch-ect"),
    CH_LANG("ch-lang"),
    CH_PREFERS_COLOR_SCHEME("ch-prefers-color-scheme"),
    CH_RTT("ch-rtt"),
    CH_UA("ch-ua"),
    CH_UA_ARCH("ch-ua-arch"),
    CH_UA_PLATFORM("ch-ua-platform"),
    CH_UA_MODEL("ch-ua-model"),
    CH_UA_MOBILE("ch-ua-mobile"),
    CH_UA_FULL_VERSION("ch-ua-full-version"),
    CH_UA_PLATFORM_VERSION("ch-ua-platform-version"),
    CH_VIEWPORT_WIDTH("ch-viewport-width"),
    CH_WIDTH("ch-width"),
    CLIPBOARD_READ("clipboard-read"),
    CLIPBOARD_WRITE("clipboard-write"),
    CROSS_ORIGIN_ISOLATED("cross-origin-isolated"),
    DIRECT_SOCKETS("direct-sockets"),
    DISPLAY_CAPTURE("display-capture"),
    DOCUMENT_DOMAIN("document-domain"),
    ENCRYPTED_MEDIA("encrypted-media"),
    EXECUTION_WHILE_OUT_OF_VIEWPORT("execution-while-out-of-viewport"),
    EXECUTION_WHILE_NOT_RENDERED("execution-while-not-rendered"),
    FOCUS_WITHOUT_USER_ACTIVATION("focus-without-user-activation"),
    FULLSCREEN("fullscreen"),
    FROBULATE("frobulate"),
    GAMEPAD("gamepad"),
    GEOLOCATION("geolocation"),
    GYROSCOPE("gyroscope"),
    HID("hid"),
    IDLE_DETECTION("idle-detection"),
    INTEREST_COHORT("interest-cohort"),
    MAGNETOMETER("magnetometer"),
    MICROPHONE("microphone"),
    MIDI("midi"),
    OTP_CREDENTIALS("otp-credentials"),
    PAYMENT("payment"),
    PICTURE_IN_PICTURE("picture-in-picture"),
    PUBLICKEY_CREDENTIALS_GET("publickey-credentials-get"),
    SCREEN_WAKE_LOCK("screen-wake-lock"),
    SERIAL("serial"),
    SHARED_AUTOFILL("shared-autofill"),
    STORAGE_ACCESS_API("storage-access-api"),
    SYNC_XHR("sync-xhr"),
    TRUST_TOKEN_REDEMPTION("trust-token-redemption"),
    USB("usb"),
    VERTICAL_SCROLL("vertical-scroll"),
    WEB_SHARE("web-share"),
    WINDOW_PLACEMENT("window-placement"),
    XR_SPATIAL_TRACKING("xr-spatial-tracking"),
    ;

    private String value;

    PermissionsPolicyFeature(String value) {
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

    public static PermissionsPolicyFeature findByValue(String value) {
        for(PermissionsPolicyFeature val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}