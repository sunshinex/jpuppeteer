package jpuppeteer.cdp.client.entity.profiler;

/**
* Specifies a number of samples attributed to a certain source position.
*/
public class PositionTickInfo {

    /**
    * Source line number (1-based).
    */
    public final Integer line;

    /**
    * Number of samples attributed to the source line.
    */
    public final Integer ticks;

    public PositionTickInfo(Integer line, Integer ticks) {
        this.line = line;
        this.ticks = ticks;
    }

}