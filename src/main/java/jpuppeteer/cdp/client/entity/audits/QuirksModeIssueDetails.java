package jpuppeteer.cdp.client.entity.audits;

/**
* Details for issues about documents in Quirks Mode or Limited Quirks Mode that affects page layouting.
* experimental
*/
public class QuirksModeIssueDetails {

    /**
    * If false, it means the document's mode is "quirks" instead of "limited-quirks".
    */
    private Boolean isLimitedQuirksMode;

    /**
    */
    private Integer documentNodeId;

    /**
    */
    private String url;

    /**
    */
    private String frameId;

    /**
    */
    private String loaderId;

    public void setIsLimitedQuirksMode (Boolean isLimitedQuirksMode) {
        this.isLimitedQuirksMode = isLimitedQuirksMode;
    }

    public Boolean getIsLimitedQuirksMode() {
        return this.isLimitedQuirksMode;
    }

    public void setDocumentNodeId (Integer documentNodeId) {
        this.documentNodeId = documentNodeId;
    }

    public Integer getDocumentNodeId() {
        return this.documentNodeId;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setLoaderId (String loaderId) {
        this.loaderId = loaderId;
    }

    public String getLoaderId() {
        return this.loaderId;
    }

    public QuirksModeIssueDetails(Boolean isLimitedQuirksMode, Integer documentNodeId, String url, String frameId, String loaderId) {
        this.isLimitedQuirksMode = isLimitedQuirksMode;
        this.documentNodeId = documentNodeId;
        this.url = url;
        this.frameId = frameId;
        this.loaderId = loaderId;
    }

    public QuirksModeIssueDetails() {
    }

}