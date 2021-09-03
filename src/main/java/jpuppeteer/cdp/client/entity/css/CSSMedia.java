package jpuppeteer.cdp.client.entity.css;

/**
* CSS media rule descriptor.
* experimental
*/
public class CSSMedia {

    /**
    * Media query text.
    */
    public final String text;

    /**
    * Source of the media query: "mediaRule" if specified by a @media rule, "importRule" if specified by an @import rule, "linkedSheet" if specified by a "media" attribute in a linked stylesheet's LINK tag, "inlineSheet" if specified by a "media" attribute in an inline stylesheet's STYLE tag.
    */
    public final jpuppeteer.cdp.client.constant.css.CSSMediaSource source;

    /**
    * URL of the document containing the media query description.
    */
    public final String sourceURL;

    /**
    * The associated rule (@media or @import) header range in the enclosing stylesheet (if available).
    */
    public final jpuppeteer.cdp.client.entity.css.SourceRange range;

    /**
    * Identifier of the stylesheet containing this object (if exists).
    */
    public final String styleSheetId;

    /**
    * Array of media queries.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.MediaQuery> mediaList;

    public CSSMedia(String text, jpuppeteer.cdp.client.constant.css.CSSMediaSource source, String sourceURL, jpuppeteer.cdp.client.entity.css.SourceRange range, String styleSheetId, java.util.List<jpuppeteer.cdp.client.entity.css.MediaQuery> mediaList) {
        this.text = text;
        this.source = source;
        this.sourceURL = sourceURL;
        this.range = range;
        this.styleSheetId = styleSheetId;
        this.mediaList = mediaList;
    }

    public CSSMedia(String text, jpuppeteer.cdp.client.constant.css.CSSMediaSource source) {
        this.text = text;
        this.source = source;
        this.sourceURL = null;
        this.range = null;
        this.styleSheetId = null;
        this.mediaList = null;
    }

}