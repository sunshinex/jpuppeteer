package jpuppeteer.api.event.page;

public class CrashedEvent extends PageEvent {

    private final int errorCode;

    private final String status;

    public CrashedEvent(int errorCode, String status) {
        this.errorCode = errorCode;
        this.status = status;
    }

    public String status() {
        return status;
    }

    public int errorCode() {
        return errorCode;
    }
}
