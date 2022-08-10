package jpuppeteer.cdp.client.entity.profiler;

/**
* Collected counter information.
*/
public class CounterInfo {

    /**
    * Counter name.
    */
    private String name;

    /**
    * Counter value.
    */
    private Integer value;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue (Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public CounterInfo(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public CounterInfo() {
    }

}