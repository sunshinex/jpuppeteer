package jpuppeteer.constant;

import jpuppeteer.cdp.client.constant.input.MouseButton;

public enum MouseDefinition {

    NONE(null, 0),
    LEFT(MouseButton.LEFT, 1),
    RIGHT(MouseButton.RIGHT, 2),
    MIDDLE(MouseButton.MIDDLE, 4),
    BACK(MouseButton.BACK, 8),
    FORWARD(MouseButton.FORWARD, 16),

    ;

    private MouseButton button;

    private Integer code;

    MouseDefinition(MouseButton button, Integer code) {
        this.button = button;
        this.code = code;
    }

    public MouseButton getButton() {
        return button;
    }

    public Integer getCode() {
        return code;
    }


}
