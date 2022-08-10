package jpuppeteer.cdp.client.constant.audits;

/**
* experimental
*/
public enum MixedContentResourceType implements jpuppeteer.cdp.client.CDPEnum {

    AUDIO("Audio"),
    BEACON("Beacon"),
    CSPREPORT("CSPReport"),
    DOWNLOAD("Download"),
    EVENTSOURCE("EventSource"),
    FAVICON("Favicon"),
    FONT("Font"),
    FORM("Form"),
    FRAME("Frame"),
    IMAGE("Image"),
    IMPORT("Import"),
    MANIFEST("Manifest"),
    PING("Ping"),
    PLUGINDATA("PluginData"),
    PLUGINRESOURCE("PluginResource"),
    PREFETCH("Prefetch"),
    RESOURCE("Resource"),
    SCRIPT("Script"),
    SERVICEWORKER("ServiceWorker"),
    SHAREDWORKER("SharedWorker"),
    STYLESHEET("Stylesheet"),
    TRACK("Track"),
    VIDEO("Video"),
    WORKER("Worker"),
    XMLHTTPREQUEST("XMLHttpRequest"),
    XSLT("XSLT"),
    ;

    private String value;

    MixedContentResourceType(String value) {
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

    public static MixedContentResourceType findByValue(String value) {
        for(MixedContentResourceType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}