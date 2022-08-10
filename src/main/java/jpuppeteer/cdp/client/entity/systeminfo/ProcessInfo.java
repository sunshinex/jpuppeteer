package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Represents process info.
* experimental
*/
public class ProcessInfo {

    /**
    * Specifies process type.
    */
    private String type;

    /**
    * Specifies process id.
    */
    private Integer id;

    /**
    * Specifies cumulative CPU usage in seconds across all threads of the process since the process start.
    */
    private java.math.BigDecimal cpuTime;

    public void setType (String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setCpuTime (java.math.BigDecimal cpuTime) {
        this.cpuTime = cpuTime;
    }

    public java.math.BigDecimal getCpuTime() {
        return this.cpuTime;
    }

    public ProcessInfo(String type, Integer id, java.math.BigDecimal cpuTime) {
        this.type = type;
        this.id = id;
        this.cpuTime = cpuTime;
    }

    public ProcessInfo() {
    }

}