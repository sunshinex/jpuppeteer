package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class ProfileSnapshotResponse {

    /**
    * The array of paint profiles, one per run.
    */
    public final java.util.List<java.util.List<java.math.BigDecimal>> timings;

    public ProfileSnapshotResponse(java.util.List<java.util.List<java.math.BigDecimal>> timings) {
        this.timings = timings;
    }

}