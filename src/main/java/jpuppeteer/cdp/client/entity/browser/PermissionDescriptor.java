package jpuppeteer.cdp.client.entity.browser;

/**
* Definition of PermissionDescriptor defined in the Permissions API: https://w3c.github.io/permissions/#dictdef-permissiondescriptor.
*/
public class PermissionDescriptor {

    /**
    * Name of permission. See https://cs.chromium.org/chromium/src/third_party/blink/renderer/modules/permissions/permission_descriptor.idl for valid permission names.
    */
    private String name;

    /**
    * For "midi" permission, may also specify sysex control.
    */
    private Boolean sysex;

    /**
    * For "push" permission, may specify userVisibleOnly. Note that userVisibleOnly = true is the only currently supported type.
    */
    private Boolean userVisibleOnly;

    /**
    * For "clipboard" permission, may specify allowWithoutSanitization.
    */
    private Boolean allowWithoutSanitization;

    /**
    * For "camera" permission, may specify panTiltZoom.
    */
    private Boolean panTiltZoom;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSysex (Boolean sysex) {
        this.sysex = sysex;
    }

    public Boolean getSysex() {
        return this.sysex;
    }

    public void setUserVisibleOnly (Boolean userVisibleOnly) {
        this.userVisibleOnly = userVisibleOnly;
    }

    public Boolean getUserVisibleOnly() {
        return this.userVisibleOnly;
    }

    public void setAllowWithoutSanitization (Boolean allowWithoutSanitization) {
        this.allowWithoutSanitization = allowWithoutSanitization;
    }

    public Boolean getAllowWithoutSanitization() {
        return this.allowWithoutSanitization;
    }

    public void setPanTiltZoom (Boolean panTiltZoom) {
        this.panTiltZoom = panTiltZoom;
    }

    public Boolean getPanTiltZoom() {
        return this.panTiltZoom;
    }

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

    public PermissionDescriptor() {
    }

}