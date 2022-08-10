package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class LowTextContrastIssueDetails {

    /**
    */
    private Integer violatingNodeId;

    /**
    */
    private String violatingNodeSelector;

    /**
    */
    private java.math.BigDecimal contrastRatio;

    /**
    */
    private java.math.BigDecimal thresholdAA;

    /**
    */
    private java.math.BigDecimal thresholdAAA;

    /**
    */
    private String fontSize;

    /**
    */
    private String fontWeight;

    public void setViolatingNodeId (Integer violatingNodeId) {
        this.violatingNodeId = violatingNodeId;
    }

    public Integer getViolatingNodeId() {
        return this.violatingNodeId;
    }

    public void setViolatingNodeSelector (String violatingNodeSelector) {
        this.violatingNodeSelector = violatingNodeSelector;
    }

    public String getViolatingNodeSelector() {
        return this.violatingNodeSelector;
    }

    public void setContrastRatio (java.math.BigDecimal contrastRatio) {
        this.contrastRatio = contrastRatio;
    }

    public java.math.BigDecimal getContrastRatio() {
        return this.contrastRatio;
    }

    public void setThresholdAA (java.math.BigDecimal thresholdAA) {
        this.thresholdAA = thresholdAA;
    }

    public java.math.BigDecimal getThresholdAA() {
        return this.thresholdAA;
    }

    public void setThresholdAAA (java.math.BigDecimal thresholdAAA) {
        this.thresholdAAA = thresholdAAA;
    }

    public java.math.BigDecimal getThresholdAAA() {
        return this.thresholdAAA;
    }

    public void setFontSize (String fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontSize() {
        return this.fontSize;
    }

    public void setFontWeight (String fontWeight) {
        this.fontWeight = fontWeight;
    }

    public String getFontWeight() {
        return this.fontWeight;
    }

    public LowTextContrastIssueDetails(Integer violatingNodeId, String violatingNodeSelector, java.math.BigDecimal contrastRatio, java.math.BigDecimal thresholdAA, java.math.BigDecimal thresholdAAA, String fontSize, String fontWeight) {
        this.violatingNodeId = violatingNodeId;
        this.violatingNodeSelector = violatingNodeSelector;
        this.contrastRatio = contrastRatio;
        this.thresholdAA = thresholdAA;
        this.thresholdAAA = thresholdAAA;
        this.fontSize = fontSize;
        this.fontWeight = fontWeight;
    }

    public LowTextContrastIssueDetails() {
    }

}