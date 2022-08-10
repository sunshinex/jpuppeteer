package jpuppeteer.cdp.client.entity.emulation;

/**
* Used to specify User Agent Cient Hints to emulate. See https://wicg.github.io/ua-client-hints
*/
public class UserAgentBrandVersion {

    /**
    */
    private String brand;

    /**
    */
    private String version;

    public void setBrand (String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setVersion (String version) {
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }

    public UserAgentBrandVersion(String brand, String version) {
        this.brand = brand;
        this.version = version;
    }

    public UserAgentBrandVersion() {
    }

}