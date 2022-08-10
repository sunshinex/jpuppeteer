package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class ProfileSnapshotResponse {

    /**
    * The array of paint profiles, one per run.
    */
    private java.util.List<java.util.List<java.math.BigDecimal>> timings;

    public void setTimings (java.util.List<java.util.List<java.math.BigDecimal>> timings) {
        this.timings = timings;
    }

    public java.util.List<java.util.List<java.math.BigDecimal>> getTimings() {
        return this.timings;
    }

    public ProfileSnapshotResponse(java.util.List<java.util.List<java.math.BigDecimal>> timings) {
        this.timings = timings;
    }

    public ProfileSnapshotResponse() {
    }

}