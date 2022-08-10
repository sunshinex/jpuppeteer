package jpuppeteer.cdp.client.entity.profiler;

/**
* Specifies a number of samples attributed to a certain source position.
*/
public class PositionTickInfo {

    /**
    * Source line number (1-based).
    */
    private Integer line;

    /**
    * Number of samples attributed to the source line.
    */
    private Integer ticks;

    public void setLine (Integer line) {
        this.line = line;
    }

    public Integer getLine() {
        return this.line;
    }

    public void setTicks (Integer ticks) {
        this.ticks = ticks;
    }

    public Integer getTicks() {
        return this.ticks;
    }

    public PositionTickInfo(Integer line, Integer ticks) {
        this.line = line;
        this.ticks = ticks;
    }

    public PositionTickInfo() {
    }

}