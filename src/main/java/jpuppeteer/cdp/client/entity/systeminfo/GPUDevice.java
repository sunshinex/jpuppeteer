package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Describes a single graphics processor (GPU).
* experimental
*/
public class GPUDevice {

    /**
    * PCI ID of the GPU vendor, if available; 0 otherwise.
    */
    public final java.math.BigDecimal vendorId;

    /**
    * PCI ID of the GPU device, if available; 0 otherwise.
    */
    public final java.math.BigDecimal deviceId;

    /**
    * Sub sys ID of the GPU, only available on Windows.
    */
    public final java.math.BigDecimal subSysId;

    /**
    * Revision of the GPU, only available on Windows.
    */
    public final java.math.BigDecimal revision;

    /**
    * String description of the GPU vendor, if the PCI ID is not available.
    */
    public final String vendorString;

    /**
    * String description of the GPU device, if the PCI ID is not available.
    */
    public final String deviceString;

    /**
    * String description of the GPU driver vendor.
    */
    public final String driverVendor;

    /**
    * String description of the GPU driver version.
    */
    public final String driverVersion;

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

}