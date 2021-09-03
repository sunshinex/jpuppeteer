package jpuppeteer.cdp.client.entity.browser;

/**
* Definition of PermissionDescriptor defined in the Permissions API: https://w3c.github.io/permissions/#dictdef-permissiondescriptor.
*/
public class PermissionDescriptor {

    /**
    * Name of permission. See https://cs.chromium.org/chromium/src/third_party/blink/renderer/modules/permissions/permission_descriptor.idl for valid permission names.
    */
    public final String name;

    /**
    * For "midi" permission, may also specify sysex control.
    */
    public final Boolean sysex;

    /**
    * For "push" permission, may specify userVisibleOnly. Note that userVisibleOnly = true is the only currently supported type.
    */
    public final Boolean userVisibleOnly;

    /**
    * For "clipboard" permission, may specify allowWithoutSanitization.
    */
    public final Boolean allowWithoutSanitization;

    /**
    * For "camera" permission, may specify panTiltZoom.
    */
    public final Boolean panTiltZoom;

    public PermissionDescriptor(String name, Boolean sysex, Boolean userVisibleOnly, Boolean allowWithoutSanitization, Boolean panTiltZoom) {
        this.name = name;
        this.sysex = sysex;
        this.userVisibleOnly = userVisibleOnly;
        this.allowWithoutSanitization = allowWithoutSanitization;
        this.panTiltZoom = panTiltZoom;
    }

    public PermissionDescriptor(String name) {
        this.name = name;
        this.sysex = null;
        this.userVisibleOnly = null;
        this.allowWithoutSanitization = null;
        this.panTiltZoom = null;
    }

}