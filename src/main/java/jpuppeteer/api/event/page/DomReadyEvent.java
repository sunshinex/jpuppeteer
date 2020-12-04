package jpuppeteer.api.event.page;

import jpuppeteer.api.event.PageEvent;

import java.math.BigDecimal;

public class DomReadyEvent extends PageEvent {

    private final BigDecimal timestamp;

    public DomReadyEvent(BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal timestamp() {
        return timestamp;
    }
}
