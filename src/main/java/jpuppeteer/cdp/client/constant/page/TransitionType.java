package jpuppeteer.cdp.client.constant.page;

/**
* Transition type.
*/
public enum TransitionType implements jpuppeteer.cdp.client.CDPEnum {

    LINK("link"),
    TYPED("typed"),
    ADDRESS_BAR("address_bar"),
    AUTO_BOOKMARK("auto_bookmark"),
    AUTO_SUBFRAME("auto_subframe"),
    MANUAL_SUBFRAME("manual_subframe"),
    GENERATED("generated"),
    AUTO_TOPLEVEL("auto_toplevel"),
    FORM_SUBMIT("form_submit"),
    RELOAD("reload"),
    KEYWORD("keyword"),
    KEYWORD_GENERATED("keyword_generated"),
    OTHER("other"),
    ;

    private String value;

    TransitionType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static TransitionType findByValue(String value) {
        for(TransitionType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}