package jpuppeteer.cdp.client.entity.css;

/**
* CSS rule collection for a single pseudo style.
* experimental
*/
public class PseudoElementMatches {

    /**
    * Pseudo element type.
    */
    public final String pseudoType;

    /**
    * Matches of CSS rules applicable to the pseudo style.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matches;

    public PseudoElementMatches(String pseudoType, java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matches) {
        this.pseudoType = pseudoType;
        this.matches = matches;
    }

}