package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetNavigationHistoryResponse {

    /**
    * Index of the current navigation history entry.
    */
    private Integer currentIndex;

    /**
    * Array of navigation history entries.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.page.NavigationEntry> entries;

    public void setCurrentIndex (Integer currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Integer getCurrentIndex() {
        return this.currentIndex;
    }

    public void setEntries (java.util.List<jpuppeteer.cdp.client.entity.page.NavigationEntry> entries) {
        this.entries = entries;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.page.NavigationEntry> getEntries() {
        return this.entries;
    }

    public GetNavigationHistoryResponse(Integer currentIndex, java.util.List<jpuppeteer.cdp.client.entity.page.NavigationEntry> entries) {
        this.currentIndex = currentIndex;
        this.entries = entries;
    }

    public GetNavigationHistoryResponse() {
    }

}