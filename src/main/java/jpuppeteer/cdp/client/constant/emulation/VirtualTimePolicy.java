package jpuppeteer.cdp.client.constant.emulation;

/**
* advance: If the scheduler runs out of immediate work, the virtual time base may fast forward to allow the next delayed task (if any) to run; pause: The virtual time base may not advance; pauseIfNetworkFetchesPending: The virtual time base may not advance if there are any pending resource fetches.
*/
public enum VirtualTimePolicy implements jpuppeteer.cdp.client.CDPEnum {

    ADVANCE("advance"),
    PAUSE("pause"),
    PAUSEIFNETWORKFETCHESPENDING("pauseIfNetworkFetchesPending"),
    ;

    private String value;

    VirtualTimePolicy(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static VirtualTimePolicy findByValue(String value) {
        for(VirtualTimePolicy val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}