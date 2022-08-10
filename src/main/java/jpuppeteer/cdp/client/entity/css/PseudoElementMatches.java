package jpuppeteer.cdp.client.entity.css;

/**
* CSS rule collection for a single pseudo style.
* experimental
*/
public class PseudoElementMatches {

    /**
    * Pseudo element type.
    */
    private jpuppeteer.cdp.client.constant.dom.PseudoType pseudoType;

    /**
    * Matches of CSS rules applicable to the pseudo style.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matches;

    public void setPseudoType (jpuppeteer.cdp.client.constant.dom.PseudoType pseudoType) {
        this.pseudoType = pseudoType;
    }

    public jpuppeteer.cdp.client.constant.dom.PseudoType getPseudoType() {
        return this.pseudoType;
    }

    public void setMatches (java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matches) {
        this.matches = matches;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> getMatches() {
        return this.matches;
    }

    public PseudoElementMatches(jpuppeteer.cdp.client.constant.dom.PseudoType pseudoType, java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matches) {
        this.pseudoType = pseudoType;
        this.matches = matches;
    }

    public PseudoElementMatches() {
    }

}