package jpuppeteer.cdp.client.constant.network;

/**
*/
public enum PrivateNetworkRequestPolicy implements jpuppeteer.cdp.client.CDPEnum {

    ALLOW("Allow"),
    BLOCKFROMINSECURETOMOREPRIVATE("BlockFromInsecureToMorePrivate"),
    WARNFROMINSECURETOMOREPRIVATE("WarnFromInsecureToMorePrivate"),
    ;

    private String value;

    PrivateNetworkRequestPolicy(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static PrivateNetworkRequestPolicy findByValue(String value) {
        for(PrivateNetworkRequestPolicy val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}