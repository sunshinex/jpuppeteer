package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class TakeTypeProfileResponse {

    /**
    * Type profile for all scripts since startTypeProfile() was turned on.
    */
    public final java.util.List<ScriptTypeProfile> result;

    public TakeTypeProfileResponse(java.util.List<ScriptTypeProfile> result) {
        this.result = result;
    }

}