package jpuppeteer.chrome.constant;

import jpuppeteer.chrome.util.ScriptUtils;

public class ScriptConstants {

    public static final String SCROLL = ScriptUtils.load("scroll.js");

    public static final String BROWSER_OBJECT_EVALUATE = ScriptUtils.load("browserobjectevaluate.js");

    public static final String ELEMENT_SELECT = ScriptUtils.load("select.js");

    public static final String ELEMENT_IS_INTERSECTING_VIEWPORT = ScriptUtils.load("isintersectingviewport.js");

    public static final String ELEMENT_SCROLL_INTO_VIEW = ScriptUtils.load("scrollintoview.js");

    public static final String WAIT = ScriptUtils.load("wait.js");

    public static final String SET_CONTENT = ScriptUtils.load("setcontent.js");

    public static final String WAIT_SELECTOR = ScriptUtils.load("waitselector.js");

}
