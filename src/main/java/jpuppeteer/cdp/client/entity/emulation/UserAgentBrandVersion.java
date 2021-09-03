package jpuppeteer.cdp.client.entity.emulation;

/**
* Used to specify User Agent Cient Hints to emulate. See https://wicg.github.io/ua-client-hints
*/
public class UserAgentBrandVersion {

    /**
    */
    public final String brand;

    /**
    */
    public final String version;

    public UserAgentBrandVersion(String brand, String version) {
        this.brand = brand;
        this.version = version;
    }

}