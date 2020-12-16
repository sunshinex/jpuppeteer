package jpuppeteer.cdp.client.entity.profiler;

/**
* Collected counter information.
*/
public class CounterInfo {

    /**
    * Counter name.
    */
    public final String name;

    /**
    * Counter value.
    */
    public final Integer value;

    public CounterInfo(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

}