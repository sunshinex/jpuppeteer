package jpuppeteer.chrome.util;

import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;

public class ArgUtils {

    public static CallArgument createFromValue(Object value) {
        CallArgument argument = new CallArgument();
        argument.setValue(value);
        return argument;
    }

    public static CallArgument createFromObjectId(String objectId) {
        CallArgument argument = new CallArgument();
        argument.setObjectId(objectId);
        return argument;
    }
}
