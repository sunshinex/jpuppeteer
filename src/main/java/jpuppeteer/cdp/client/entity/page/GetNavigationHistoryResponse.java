package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetNavigationHistoryResponse {

    /**
    * Index of the current navigation history entry.
    */
    public final Integer currentIndex;

    /**
    * Array of navigation history entries.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.page.NavigationEntry> entries;

    public GetNavigationHistoryResponse(Integer currentIndex, java.util.List<jpuppeteer.cdp.client.entity.page.NavigationEntry> entries) {
        this.currentIndex = currentIndex;
        this.entries = entries;
    }

}