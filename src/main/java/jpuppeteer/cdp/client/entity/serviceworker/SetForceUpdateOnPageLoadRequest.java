package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class SetForceUpdateOnPageLoadRequest {

    /**
    */
    private Boolean forceUpdateOnPageLoad;

    public void setForceUpdateOnPageLoad (Boolean forceUpdateOnPageLoad) {
        this.forceUpdateOnPageLoad = forceUpdateOnPageLoad;
    }

    public Boolean getForceUpdateOnPageLoad() {
        return this.forceUpdateOnPageLoad;
    }

    public SetForceUpdateOnPageLoadRequest(Boolean forceUpdateOnPageLoad) {
        this.forceUpdateOnPageLoad = forceUpdateOnPageLoad;
    }

    public SetForceUpdateOnPageLoadRequest() {
    }

}