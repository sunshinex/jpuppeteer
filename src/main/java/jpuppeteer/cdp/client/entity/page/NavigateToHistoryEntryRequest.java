package jpuppeteer.cdp.client.entity.page;

/**
*/
public class NavigateToHistoryEntryRequest {

    /**
    * Unique id of the entry to navigate to.
    */
    private Integer entryId;

    public void setEntryId (Integer entryId) {
        this.entryId = entryId;
    }

    public Integer getEntryId() {
        return this.entryId;
    }

    public NavigateToHistoryEntryRequest(Integer entryId) {
        this.entryId = entryId;
    }

    public NavigateToHistoryEntryRequest() {
    }

}