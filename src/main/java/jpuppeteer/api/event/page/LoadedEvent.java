package jpuppeteer.api.event.page;

import java.math.BigDecimal;

public class LoadedEvent extends PageEvent {

    private final BigDecimal timestamp;

    public LoadedEvent(BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal timestamp() {
        return timestamp;
    }

}
