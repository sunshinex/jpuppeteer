package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class LowTextContrastIssueDetails {

    /**
    */
    public final Integer violatingNodeId;

    /**
    */
    public final String violatingNodeSelector;

    /**
    */
    public final java.math.BigDecimal contrastRatio;

    /**
    */
    public final java.math.BigDecimal thresholdAA;

    /**
    */
    public final java.math.BigDecimal thresholdAAA;

    /**
    */
    public final String fontSize;

    /**
    */
    public final String fontWeight;

    public LowTextContrastIssueDetails(Integer violatingNodeId, String violatingNodeSelector, java.math.BigDecimal contrastRatio, java.math.BigDecimal thresholdAA, java.math.BigDecimal thresholdAAA, String fontSize, String fontWeight) {
        this.violatingNodeId = violatingNodeId;
        this.violatingNodeSelector = violatingNodeSelector;
        this.contrastRatio = contrastRatio;
        this.thresholdAA = thresholdAA;
        this.thresholdAAA = thresholdAAA;
        this.fontSize = fontSize;
        this.fontWeight = fontWeight;
    }

}