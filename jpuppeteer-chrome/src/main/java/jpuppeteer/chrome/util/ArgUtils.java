package jpuppeteer.chrome.util;

import jpuppeteer.api.browser.Browser;
import jpuppeteer.api.browser.BrowserObject;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import jpuppeteer.chrome.ChromeBrowser;
import jpuppeteer.chrome.ChromeBrowserObject;

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

    public static <T extends ChromeBrowserObject> CallArgument createFromObject(T object) {
        return createFromObjectId(object.getObjectId());
    }
}
