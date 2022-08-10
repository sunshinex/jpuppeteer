package jpuppeteer.cdp.client.entity.network;

/**
*/
public class ClientSecurityState {

    /**
    */
    private Boolean initiatorIsSecureContext;

    /**
    */
    private jpuppeteer.cdp.client.constant.network.IPAddressSpace initiatorIPAddressSpace;

    /**
    */
    private jpuppeteer.cdp.client.constant.network.PrivateNetworkRequestPolicy privateNetworkRequestPolicy;

    public void setInitiatorIsSecureContext (Boolean initiatorIsSecureContext) {
        this.initiatorIsSecureContext = initiatorIsSecureContext;
    }

    public Boolean getInitiatorIsSecureContext() {
        return this.initiatorIsSecureContext;
    }

    public void setInitiatorIPAddressSpace (jpuppeteer.cdp.client.constant.network.IPAddressSpace initiatorIPAddressSpace) {
        this.initiatorIPAddressSpace = initiatorIPAddressSpace;
    }

    public jpuppeteer.cdp.client.constant.network.IPAddressSpace getInitiatorIPAddressSpace() {
        return this.initiatorIPAddressSpace;
    }

    public void setPrivateNetworkRequestPolicy (jpuppeteer.cdp.client.constant.network.PrivateNetworkRequestPolicy privateNetworkRequestPolicy) {
        this.privateNetworkRequestPolicy = privateNetworkRequestPolicy;
    }

    public jpuppeteer.cdp.client.constant.network.PrivateNetworkRequestPolicy getPrivateNetworkRequestPolicy() {
        return this.privateNetworkRequestPolicy;
    }

    public ClientSecurityState(Boolean initiatorIsSecureContext, jpuppeteer.cdp.client.constant.network.IPAddressSpace initiatorIPAddressSpace, jpuppeteer.cdp.client.constant.network.PrivateNetworkRequestPolicy privateNetworkRequestPolicy) {
        this.initiatorIsSecureContext = initiatorIsSecureContext;
        this.initiatorIPAddressSpace = initiatorIPAddressSpace;
        this.privateNetworkRequestPolicy = privateNetworkRequestPolicy;
    }

    public ClientSecurityState() {
    }

}