package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class GetMetadataResponse {

    /**
    * the entries count
    */
    public final java.math.BigDecimal entriesCount;

    /**
    * the current value of key generator, to become the next inserted key into the object store. Valid if objectStore.autoIncrement is true.
    */
    public final java.math.BigDecimal keyGeneratorValue;

    public GetMetadataResponse(java.math.BigDecimal entriesCount, java.math.BigDecimal keyGeneratorValue) {
        this.entriesCount = entriesCount;
        this.keyGeneratorValue = keyGeneratorValue;
    }

}