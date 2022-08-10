package jpuppeteer.cdp.client.entity.network;

/**
* Determines what type of Trust Token operation is executed and depending on the type, some additional parameters. The values are specified in third_party/blink/renderer/core/fetch/trust_token.idl.
*/
public class TrustTokenParams {

    /**
    */
    private jpuppeteer.cdp.client.constant.network.TrustTokenOperationType type;

    /**
    * Only set for "token-redemption" type and determine whether to request a fresh SRR or use a still valid cached SRR.
    */
    private jpuppeteer.cdp.client.constant.network.TrustTokenParamsRefreshPolicy refreshPolicy;

    /**
    * Origins of issuers from whom to request tokens or redemption records.
    */
    private java.util.List<String> issuers;

    public void setType (jpuppeteer.cdp.client.constant.network.TrustTokenOperationType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.network.TrustTokenOperationType getType() {
        return this.type;
    }

    public void setRefreshPolicy (jpuppeteer.cdp.client.constant.network.TrustTokenParamsRefreshPolicy refreshPolicy) {
        this.refreshPolicy = refreshPolicy;
    }

    public jpuppeteer.cdp.client.constant.network.TrustTokenParamsRefreshPolicy getRefreshPolicy() {
        return this.refreshPolicy;
    }

    public void setIssuers (java.util.List<String> issuers) {
        this.issuers = issuers;
    }

    public java.util.List<String> getIssuers() {
        return this.issuers;
    }

    public TrustTokenParams(jpuppeteer.cdp.client.constant.network.TrustTokenOperationType type, jpuppeteer.cdp.client.constant.network.TrustTokenParamsRefreshPolicy refreshPolicy, java.util.List<String> issuers) {
        this.type = type;
        this.refreshPolicy = refreshPolicy;
        this.issuers = issuers;
    }

    public TrustTokenParams(jpuppeteer.cdp.client.constant.network.TrustTokenOperationType type, jpuppeteer.cdp.client.constant.network.TrustTokenParamsRefreshPolicy refreshPolicy) {
        this.type = type;
        this.refreshPolicy = refreshPolicy;
        this.issuers = null;
    }

    public TrustTokenParams() {
    }

}