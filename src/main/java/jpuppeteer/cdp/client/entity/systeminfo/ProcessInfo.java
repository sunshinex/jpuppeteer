package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Represents process info.
* experimental
*/
public class ProcessInfo {

    /**
    * Specifies process type.
    */
    public final String type;

    /**
    * Specifies process id.
    */
    public final Integer id;

    /**
    * Specifies cumulative CPU usage in seconds across all threads of the process since the process start.
    */
    public final java.math.BigDecimal cpuTime;

    public ProcessInfo(String type, Integer id, java.math.BigDecimal cpuTime) {
        this.type = type;
        this.id = id;
        this.cpuTime = cpuTime;
    }

}