package jpuppeteer.cdp.client.entity.emulation;

/**
* Used to specify User Agent Cient Hints to emulate. See https://wicg.github.io/ua-client-hints Missing optional values will be filled in by the target with what it would normally use.
*/
public class UserAgentMetadata {

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.emulation.UserAgentBrandVersion> brands;

    /**
    */
    public final String fullVersion;

    /**
    */
    public final String platform;

    /**
    */
    public final String platformVersion;

    /**
    */
    public final String architecture;

    /**
    */
    public final String model;

    /**
    */
    public final Boolean mobile;

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

}