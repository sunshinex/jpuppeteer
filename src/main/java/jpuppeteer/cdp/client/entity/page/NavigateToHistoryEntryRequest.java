package jpuppeteer.cdp.client.entity.page;

/**
*/
public class NavigateToHistoryEntryRequest {

    /**
    * Unique id of the entry to navigate to.
    */
    public final Integer entryId;

    public NavigateToHistoryEntryRequest(Integer entryId) {
        this.entryId = entryId;
    }

}