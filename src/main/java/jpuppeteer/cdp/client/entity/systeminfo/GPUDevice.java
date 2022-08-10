package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Describes a single graphics processor (GPU).
* experimental
*/
public class GPUDevice {

    /**
    * PCI ID of the GPU vendor, if available; 0 otherwise.
    */
    private java.math.BigDecimal vendorId;

    /**
    * PCI ID of the GPU device, if available; 0 otherwise.
    */
    private java.math.BigDecimal deviceId;

    /**
    * Sub sys ID of the GPU, only available on Windows.
    */
    private java.math.BigDecimal subSysId;

    /**
    * Revision of the GPU, only available on Windows.
    */
    private java.math.BigDecimal revision;

    /**
    * String description of the GPU vendor, if the PCI ID is not available.
    */
    private String vendorString;

    /**
    * String description of the GPU device, if the PCI ID is not available.
    */
    private String deviceString;

    /**
    * String description of the GPU driver vendor.
    */
    private String driverVendor;

    /**
    * String description of the GPU driver version.
    */
    private String driverVersion;

    public void setVendorId (java.math.BigDecimal vendorId) {
        this.vendorId = vendorId;
    }

    public java.math.BigDecimal getVendorId() {
        return this.vendorId;
    }

    public void setDeviceId (java.math.BigDecimal deviceId) {
        this.deviceId = deviceId;
    }

    public java.math.BigDecimal getDeviceId() {
        return this.deviceId;
    }

    public void setSubSysId (java.math.BigDecimal subSysId) {
        this.subSysId = subSysId;
    }

    public java.math.BigDecimal getSubSysId() {
        return this.subSysId;
    }

    public void setRevision (java.math.BigDecimal revision) {
        this.revision = revision;
    }

    public java.math.BigDecimal getRevision() {
        return this.revision;
    }

    public void setVendorString (String vendorString) {
        this.vendorString = vendorString;
    }

    public String getVendorString() {
        return this.vendorString;
    }

    public void setDeviceString (String deviceString) {
        this.deviceString = deviceString;
    }

    public String getDeviceString() {
        return this.deviceString;
    }

    public void setDriverVendor (String driverVendor) {
        this.driverVendor = driverVendor;
    }

    public String getDriverVendor() {
        return this.driverVendor;
    }

    public void setDriverVersion (String driverVersion) {
        this.driverVersion = driverVersion;
    }

    public String getDriverVersion() {
        return this.driverVersion;
    }

    public GPUDevice(java.math.BigDecimal vendorId, java.math.BigDecimal deviceId, java.math.BigDecimal subSysId, java.math.BigDecimal revision, String vendorString, String deviceString, String driverVendor, String driverVersion) {
        this.vendorId = vendorId;
        this.deviceId = deviceId;
        this.subSysId = subSysId;
        this.revision = revision;
        this.vendorString = vendorString;
        this.deviceString = deviceString;
        this.driverVendor = driverVendor;
        this.driverVersion = driverVersion;
    }

    public GPUDevice(java.math.BigDecimal vendorId, java.math.BigDecimal deviceId, String vendorString, String deviceString, String driverVendor, String driverVersion) {
        this.vendorId = vendorId;
        this.deviceId = deviceId;
        this.subSysId = null;
        this.revision = null;
        this.vendorString = vendorString;
        this.deviceString = deviceString;
        this.driverVendor = driverVendor;
        this.driverVersion = driverVersion;
    }

    public GPUDevice() {
    }

}