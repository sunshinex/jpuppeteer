package jpuppeteer.cdp.client.entity.network;

/**
*/
public class ClientSecurityState {

    /**
    */
    public final Boolean initiatorIsSecureContext;

    /**
    */
    public final jpuppeteer.cdp.client.constant.network.IPAddressSpace initiatorIPAddressSpace;

    /**
    */
    public final jpuppeteer.cdp.client.constant.network.PrivateNetworkRequestPolicy privateNetworkRequestPolicy;

    public ClientSecurityState(Boolean initiatorIsSecureContext, jpuppeteer.cdp.client.constant.network.IPAddressSpace initiatorIPAddressSpace, jpuppeteer.cdp.client.constant.network.PrivateNetworkRequestPolicy privateNetworkRequestPolicy) {
        this.initiatorIsSecureContext = initiatorIsSecureContext;
        this.initiatorIPAddressSpace = initiatorIPAddressSpace;
        this.privateNetworkRequestPolicy = privateNetworkRequestPolicy;
    }

}