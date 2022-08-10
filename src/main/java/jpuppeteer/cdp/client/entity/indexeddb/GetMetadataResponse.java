package jpuppeteer.cdp.client.entity.indexeddb;

/**
* experimental
*/
public class GetMetadataResponse {

    /**
    * the entries count
    */
    private java.math.BigDecimal entriesCount;

    /**
    * the current value of key generator, to become the next inserted key into the object store. Valid if objectStore.autoIncrement is true.
    */
    private java.math.BigDecimal keyGeneratorValue;

    public void setEntriesCount (java.math.BigDecimal entriesCount) {
        this.entriesCount = entriesCount;
    }

    public java.math.BigDecimal getEntriesCount() {
        return this.entriesCount;
    }

    public void setKeyGeneratorValue (java.math.BigDecimal keyGeneratorValue) {
        this.keyGeneratorValue = keyGeneratorValue;
    }

    public java.math.BigDecimal getKeyGeneratorValue() {
        return this.keyGeneratorValue;
    }

    public GetMetadataResponse(java.math.BigDecimal entriesCount, java.math.BigDecimal keyGeneratorValue) {
        this.entriesCount = entriesCount;
        this.keyGeneratorValue = keyGeneratorValue;
    }

    public GetMetadataResponse() {
    }

}