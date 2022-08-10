package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* If heap objects tracking has been started then backend may send update for one or more fragments
* experimental
*/
public class HeapStatsUpdateEvent {

    /**
    * An array of triplets. Each triplet describes a fragment. The first integer is the fragment index, the second integer is a total count of objects for the fragment, the third integer is a total size of the objects for the fragment.
    */
    private java.util.List<Integer> statsUpdate;

    public void setStatsUpdate (java.util.List<Integer> statsUpdate) {
        this.statsUpdate = statsUpdate;
    }

    public java.util.List<Integer> getStatsUpdate() {
        return this.statsUpdate;
    }

    public HeapStatsUpdateEvent(java.util.List<Integer> statsUpdate) {
        this.statsUpdate = statsUpdate;
    }

    public HeapStatsUpdateEvent() {
    }

}