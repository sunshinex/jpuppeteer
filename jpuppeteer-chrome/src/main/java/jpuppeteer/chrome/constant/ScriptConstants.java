package jpuppeteer.chrome.constant;

import jpuppeteer.chrome.util.ScriptUtils;

public class ScriptConstants {

    public static final String SCROLL = ScriptUtils.load("scroll.js");

    public static final String ELEMENT_SELECT = ScriptUtils.load("select.js");

    public static final String ELEMENT_IS_INTERSECTING_VIEWPORT = ScriptUtils.load("is_intersecting_viewport.js");

    public static final String ELEMENT_SCROLL_INTO_VIEW = ScriptUtils.load("scroll_into_view.js");

    public static final String WAIT = ScriptUtils.load("wait.js");

    public static final String SET_CONTENT = ScriptUtils.load("set_content.js");

    public static final String WAIT_SELECTOR = ScriptUtils.load("wait_selector.js");

    public static final String ELEMENT_HTML = ScriptUtils.load("element_html.js");

    public static final String ELEMENT_TEXT = ScriptUtils.load("element_text.js");

}
