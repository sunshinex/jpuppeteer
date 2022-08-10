package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Data that is only present on rare nodes.
* experimental
*/
public class RareStringData {

    /**
    */
    private java.util.List<Integer> index;

    /**
    */
    private java.util.List<Integer> value;

    public void setIndex (java.util.List<Integer> index) {
        this.index = index;
    }

    public java.util.List<Integer> getIndex() {
        return this.index;
    }

    public void setValue (java.util.List<Integer> value) {
        this.value = value;
    }

    public java.util.List<Integer> getValue() {
        return this.value;
    }

    public RareStringData(java.util.List<Integer> index, java.util.List<Integer> value) {
        this.index = index;
        this.value = value;
    }

    public RareStringData() {
    }

}