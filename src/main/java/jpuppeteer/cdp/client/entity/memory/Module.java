package jpuppeteer.cdp.client.entity.memory;

/**
* Executable module information
* experimental
*/
public class Module {

    /**
    * Name of the module.
    */
    private String name;

    /**
    * UUID of the module.
    */
    private String uuid;

    /**
    * Base address where the module is loaded into memory. Encoded as a decimal or hexadecimal (0x prefixed) string.
    */
    private String baseAddress;

    /**
    * Size of the module in bytes.
    */
    private java.math.BigDecimal size;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setUuid (String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setBaseAddress (String baseAddress) {
        this.baseAddress = baseAddress;
    }

    public String getBaseAddress() {
        return this.baseAddress;
    }

    public void setSize (java.math.BigDecimal size) {
        this.size = size;
    }

    public java.math.BigDecimal getSize() {
        return this.size;
    }

    public Module(String name, String uuid, String baseAddress, java.math.BigDecimal size) {
        this.name = name;
        this.uuid = uuid;
        this.baseAddress = baseAddress;
        this.size = size;
    }

    public Module() {
    }

}