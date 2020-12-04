package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetBackgroundColorsResponse {

    /**
    * The range of background colors behind this element, if it contains any visible text. If no visible text is present, this will be undefined. In the case of a flat background color, this will consist of simply that color. In the case of a gradient, this will consist of each of the color stops. For anything more complicated, this will be an empty array. Images will be ignored (as if the image had failed to load).
    */
    public final java.util.List<String> backgroundColors;

    /**
    * The computed font size for this node, as a CSS computed value string (e.g. '12px').
    */
    public final String computedFontSize;

    /**
    * The computed font weight for this node, as a CSS computed value string (e.g. 'normal' or '100').
    */
    public final String computedFontWeight;

    public GetBackgroundColorsResponse(java.util.List<String> backgroundColors, String computedFontSize, String computedFontWeight) {
        this.backgroundColors = backgroundColors;
        this.computedFontSize = computedFontSize;
        this.computedFontWeight = computedFontWeight;
    }

    public GetBackgroundColorsResponse() {
        this.backgroundColors = null;
        this.computedFontSize = null;
        this.computedFontWeight = null;
    }

}