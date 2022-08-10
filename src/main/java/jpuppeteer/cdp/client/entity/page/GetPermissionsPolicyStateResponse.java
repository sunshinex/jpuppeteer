package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetPermissionsPolicyStateResponse {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.page.PermissionsPolicyFeatureState> states;

    public void setStates (java.util.List<jpuppeteer.cdp.client.entity.page.PermissionsPolicyFeatureState> states) {
        this.states = states;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.page.PermissionsPolicyFeatureState> getStates() {
        return this.states;
    }

    public GetPermissionsPolicyStateResponse(java.util.List<jpuppeteer.cdp.client.entity.page.PermissionsPolicyFeatureState> states) {
        this.states = states;
    }

    public GetPermissionsPolicyStateResponse() {
    }

}