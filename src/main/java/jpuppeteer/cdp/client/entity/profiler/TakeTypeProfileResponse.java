package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class TakeTypeProfileResponse {

    /**
    * Type profile for all scripts since startTypeProfile() was turned on.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptTypeProfile> result;

    public void setResult (java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptTypeProfile> result) {
        this.result = result;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptTypeProfile> getResult() {
        return this.result;
    }

    public TakeTypeProfileResponse(java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptTypeProfile> result) {
        this.result = result;
    }

    public TakeTypeProfileResponse() {
    }

}