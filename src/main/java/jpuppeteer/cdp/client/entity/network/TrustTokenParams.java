package jpuppeteer.cdp.client.entity.network;

/**
* Determines what type of Trust Token operation is executed and depending on the type, some additional parameters. The values are specified in third_party/blink/renderer/core/fetch/trust_token.idl.
*/
public class TrustTokenParams {

    /**
    */
    public final jpuppeteer.cdp.client.constant.network.TrustTokenOperationType type;

    /**
    * Only set for "token-redemption" type and determine whether to request a fresh SRR or use a still valid cached SRR.
    */
    public final jpuppeteer.cdp.client.constant.network.TrustTokenParamsRefreshPolicy refreshPolicy;

    /**
    * Origins of issuers from whom to request tokens or redemption records.
    */
    public final java.util.List<String> issuers;

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

}