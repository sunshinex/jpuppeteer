package jpuppeteer.cdp.client.entity.emulation;

/**
* Used to specify User Agent Cient Hints to emulate. See https://wicg.github.io/ua-client-hints Missing optional values will be filled in by the target with what it would normally use.
*/
public class UserAgentMetadata {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.emulation.UserAgentBrandVersion> brands;

    /**
    */
    private String fullVersion;

    /**
    */
    private String platform;

    /**
    */
    private String platformVersion;

    /**
    */
    private String architecture;

    /**
    */
    private String model;

    /**
    */
    private Boolean mobile;

    public void setBrands (java.util.List<jpuppeteer.cdp.client.entity.emulation.UserAgentBrandVersion> brands) {
        this.brands = brands;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.emulation.UserAgentBrandVersion> getBrands() {
        return this.brands;
    }

    public void setFullVersion (String fullVersion) {
        this.fullVersion = fullVersion;
    }

    public String getFullVersion() {
        return this.fullVersion;
    }

    public void setPlatform (String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatformVersion (String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getPlatformVersion() {
        return this.platformVersion;
    }

    public void setArchitecture (String architecture) {
        this.architecture = architecture;
    }

    public String getArchitecture() {
        return this.architecture;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setMobile (Boolean mobile) {
        this.mobile = mobile;
    }

    public Boolean getMobile() {
        return this.mobile;
    }

    public UserAgentMetadata(java.util.List<jpuppeteer.cdp.client.entity.emulation.UserAgentBrandVersion> brands, String fullVersion, String platform, String platformVersion, String architecture, String model, Boolean mobile) {
        this.brands = brands;
        this.fullVersion = fullVersion;
        this.platform = platform;
        this.platformVersion = platformVersion;
        this.architecture = architecture;
        this.model = model;
        this.mobile = mobile;
    }

    public UserAgentMetadata(String platform, String platformVersion, String architecture, String model, Boolean mobile) {
        this.brands = null;
        this.fullVersion = null;
        this.platform = platform;
        this.platformVersion = platformVersion;
        this.architecture = architecture;
        this.model = model;
        this.mobile = mobile;
    }

    public UserAgentMetadata() {
    }

}