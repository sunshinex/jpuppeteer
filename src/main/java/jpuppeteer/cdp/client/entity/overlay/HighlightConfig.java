package jpuppeteer.cdp.client.entity.overlay;

/**
* Configuration data for the highlighting of page elements.
* experimental
*/
public class HighlightConfig {

    /**
    * Whether the node info tooltip should be shown (default: false).
    */
    private Boolean showInfo;

    /**
    * Whether the node styles in the tooltip (default: false).
    */
    private Boolean showStyles;

    /**
    * Whether the rulers should be shown (default: false).
    */
    private Boolean showRulers;

    /**
    * Whether the a11y info should be shown (default: true).
    */
    private Boolean showAccessibilityInfo;

    /**
    * Whether the extension lines from node to the rulers should be shown (default: false).
    */
    private Boolean showExtensionLines;

    /**
    * The content box highlight fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA contentColor;

    /**
    * The padding highlight fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA paddingColor;

    /**
    * The border highlight fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA borderColor;

    /**
    * The margin highlight fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA marginColor;

    /**
    * The event target element highlight fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA eventTargetColor;

    /**
    * The shape outside fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA shapeColor;

    /**
    * The shape margin fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA shapeMarginColor;

    /**
    * The grid layout color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA cssGridColor;

    /**
    * The color format used to format color styles (default: hex).
    */
    private jpuppeteer.cdp.client.constant.overlay.ColorFormat colorFormat;

    /**
    * The grid layout highlight configuration (default: all transparent).
    */
    private jpuppeteer.cdp.client.entity.overlay.GridHighlightConfig gridHighlightConfig;

    /**
    * The flex container highlight configuration (default: all transparent).
    */
    private jpuppeteer.cdp.client.entity.overlay.FlexContainerHighlightConfig flexContainerHighlightConfig;

    /**
    * The flex item highlight configuration (default: all transparent).
    */
    private jpuppeteer.cdp.client.entity.overlay.FlexItemHighlightConfig flexItemHighlightConfig;

    /**
    * The contrast algorithm to use for the contrast ratio (default: aa).
    */
    private jpuppeteer.cdp.client.constant.overlay.ContrastAlgorithm contrastAlgorithm;

    public void setShowInfo (Boolean showInfo) {
        this.showInfo = showInfo;
    }

    public Boolean getShowInfo() {
        return this.showInfo;
    }

    public void setShowStyles (Boolean showStyles) {
        this.showStyles = showStyles;
    }

    public Boolean getShowStyles() {
        return this.showStyles;
    }

    public void setShowRulers (Boolean showRulers) {
        this.showRulers = showRulers;
    }

    public Boolean getShowRulers() {
        return this.showRulers;
    }

    public void setShowAccessibilityInfo (Boolean showAccessibilityInfo) {
        this.showAccessibilityInfo = showAccessibilityInfo;
    }

    public Boolean getShowAccessibilityInfo() {
        return this.showAccessibilityInfo;
    }

    public void setShowExtensionLines (Boolean showExtensionLines) {
        this.showExtensionLines = showExtensionLines;
    }

    public Boolean getShowExtensionLines() {
        return this.showExtensionLines;
    }

    public void setContentColor (jpuppeteer.cdp.client.entity.dom.RGBA contentColor) {
        this.contentColor = contentColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getContentColor() {
        return this.contentColor;
    }

    public void setPaddingColor (jpuppeteer.cdp.client.entity.dom.RGBA paddingColor) {
        this.paddingColor = paddingColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getPaddingColor() {
        return this.paddingColor;
    }

    public void setBorderColor (jpuppeteer.cdp.client.entity.dom.RGBA borderColor) {
        this.borderColor = borderColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getBorderColor() {
        return this.borderColor;
    }

    public void setMarginColor (jpuppeteer.cdp.client.entity.dom.RGBA marginColor) {
        this.marginColor = marginColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getMarginColor() {
        return this.marginColor;
    }

    public void setEventTargetColor (jpuppeteer.cdp.client.entity.dom.RGBA eventTargetColor) {
        this.eventTargetColor = eventTargetColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getEventTargetColor() {
        return this.eventTargetColor;
    }

    public void setShapeColor (jpuppeteer.cdp.client.entity.dom.RGBA shapeColor) {
        this.shapeColor = shapeColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getShapeColor() {
        return this.shapeColor;
    }

    public void setShapeMarginColor (jpuppeteer.cdp.client.entity.dom.RGBA shapeMarginColor) {
        this.shapeMarginColor = shapeMarginColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getShapeMarginColor() {
        return this.shapeMarginColor;
    }

    public void setCssGridColor (jpuppeteer.cdp.client.entity.dom.RGBA cssGridColor) {
        this.cssGridColor = cssGridColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getCssGridColor() {
        return this.cssGridColor;
    }

    public void setColorFormat (jpuppeteer.cdp.client.constant.overlay.ColorFormat colorFormat) {
        this.colorFormat = colorFormat;
    }

    public jpuppeteer.cdp.client.constant.overlay.ColorFormat getColorFormat() {
        return this.colorFormat;
    }

    public void setGridHighlightConfig (jpuppeteer.cdp.client.entity.overlay.GridHighlightConfig gridHighlightConfig) {
        this.gridHighlightConfig = gridHighlightConfig;
    }

    public jpuppeteer.cdp.client.entity.overlay.GridHighlightConfig getGridHighlightConfig() {
        return this.gridHighlightConfig;
    }

    public void setFlexContainerHighlightConfig (jpuppeteer.cdp.client.entity.overlay.FlexContainerHighlightConfig flexContainerHighlightConfig) {
        this.flexContainerHighlightConfig = flexContainerHighlightConfig;
    }

    public jpuppeteer.cdp.client.entity.overlay.FlexContainerHighlightConfig getFlexContainerHighlightConfig() {
        return this.flexContainerHighlightConfig;
    }

    public void setFlexItemHighlightConfig (jpuppeteer.cdp.client.entity.overlay.FlexItemHighlightConfig flexItemHighlightConfig) {
        this.flexItemHighlightConfig = flexItemHighlightConfig;
    }

    public jpuppeteer.cdp.client.entity.overlay.FlexItemHighlightConfig getFlexItemHighlightConfig() {
        return this.flexItemHighlightConfig;
    }

    public void setContrastAlgorithm (jpuppeteer.cdp.client.constant.overlay.ContrastAlgorithm contrastAlgorithm) {
        this.contrastAlgorithm = contrastAlgorithm;
    }

    public jpuppeteer.cdp.client.constant.overlay.ContrastAlgorithm getContrastAlgorithm() {
        return this.contrastAlgorithm;
    }

    public HighlightConfig(Boolean showInfo, Boolean showStyles, Boolean showRulers, Boolean showAccessibilityInfo, Boolean showExtensionLines, jpuppeteer.cdp.client.entity.dom.RGBA contentColor, jpuppeteer.cdp.client.entity.dom.RGBA paddingColor, jpuppeteer.cdp.client.entity.dom.RGBA borderColor, jpuppeteer.cdp.client.entity.dom.RGBA marginColor, jpuppeteer.cdp.client.entity.dom.RGBA eventTargetColor, jpuppeteer.cdp.client.entity.dom.RGBA shapeColor, jpuppeteer.cdp.client.entity.dom.RGBA shapeMarginColor, jpuppeteer.cdp.client.entity.dom.RGBA cssGridColor, jpuppeteer.cdp.client.constant.overlay.ColorFormat colorFormat, jpuppeteer.cdp.client.entity.overlay.GridHighlightConfig gridHighlightConfig, jpuppeteer.cdp.client.entity.overlay.FlexContainerHighlightConfig flexContainerHighlightConfig, jpuppeteer.cdp.client.entity.overlay.FlexItemHighlightConfig flexItemHighlightConfig, jpuppeteer.cdp.client.constant.overlay.ContrastAlgorithm contrastAlgorithm) {
        this.showInfo = showInfo;
        this.showStyles = showStyles;
        this.showRulers = showRulers;
        this.showAccessibilityInfo = showAccessibilityInfo;
        this.showExtensionLines = showExtensionLines;
        this.contentColor = contentColor;
        this.paddingColor = paddingColor;
        this.borderColor = borderColor;
        this.marginColor = marginColor;
        this.eventTargetColor = eventTargetColor;
        this.shapeColor = shapeColor;
        this.shapeMarginColor = shapeMarginColor;
        this.cssGridColor = cssGridColor;
        this.colorFormat = colorFormat;
        this.gridHighlightConfig = gridHighlightConfig;
        this.flexContainerHighlightConfig = flexContainerHighlightConfig;
        this.flexItemHighlightConfig = flexItemHighlightConfig;
        this.contrastAlgorithm = contrastAlgorithm;
    }

    public HighlightConfig() {
        this.showInfo = null;
        this.showStyles = null;
        this.showRulers = null;
        this.showAccessibilityInfo = null;
        this.showExtensionLines = null;
        this.contentColor = null;
        this.paddingColor = null;
        this.borderColor = null;
        this.marginColor = null;
        this.eventTargetColor = null;
        this.shapeColor = null;
        this.shapeMarginColor = null;
        this.cssGridColor = null;
        this.colorFormat = null;
        this.gridHighlightConfig = null;
        this.flexContainerHighlightConfig = null;
        this.flexItemHighlightConfig = null;
        this.contrastAlgorithm = null;
    }

}