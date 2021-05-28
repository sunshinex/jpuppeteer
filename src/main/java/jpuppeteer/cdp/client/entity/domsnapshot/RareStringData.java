package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Data that is only present on rare nodes.
* experimental
*/
public class RareStringData {

    /**
    */
    public final java.util.List<Integer> index;

    /**
    */
    public final java.util.List<Integer> value;

    public RareStringData(java.util.List<Integer> index, java.util.List<Integer> value) {
        this.index = index;
        this.value = value;
    }

}