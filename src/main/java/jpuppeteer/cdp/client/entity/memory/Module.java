package jpuppeteer.cdp.client.entity.memory;

/**
* Executable module information
* experimental
*/
public class Module {

    /**
    * Name of the module.
    */
    public final String name;

    /**
    * UUID of the module.
    */
    public final String uuid;

    /**
    * Base address where the module is loaded into memory. Encoded as a decimal or hexadecimal (0x prefixed) string.
    */
    public final String baseAddress;

    /**
    * Size of the module in bytes.
    */
    public final java.math.BigDecimal size;

    public Module(String name, String uuid, String baseAddress, java.math.BigDecimal size) {
        this.name = name;
        this.uuid = uuid;
        this.baseAddress = baseAddress;
        this.size = size;
    }

}