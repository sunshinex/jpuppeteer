package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class ResumeRequest {

    /**
    * Set to true to terminate execution upon resuming execution. In contrast to Runtime.terminateExecution, this will allows to execute further JavaScript (i.e. via evaluation) until execution of the paused code is actually resumed, at which point termination is triggered. If execution is currently not paused, this parameter has no effect.
    */
    private Boolean terminateOnResume;

    public void setTerminateOnResume (Boolean terminateOnResume) {
        this.terminateOnResume = terminateOnResume;
    }

    public Boolean getTerminateOnResume() {
        return this.terminateOnResume;
    }

    public ResumeRequest(Boolean terminateOnResume) {
        this.terminateOnResume = terminateOnResume;
    }

    public ResumeRequest() {
        this.terminateOnResume = null;
    }

}