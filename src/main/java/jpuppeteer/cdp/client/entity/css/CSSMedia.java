package jpuppeteer.cdp.client.entity.css;

/**
* CSS media rule descriptor.
* experimental
*/
public class CSSMedia {

    /**
    * Media query text.
    */
    private String text;

    /**
    * Source of the media query: "mediaRule" if specified by a @media rule, "importRule" if specified by an @import rule, "linkedSheet" if specified by a "media" attribute in a linked stylesheet's LINK tag, "inlineSheet" if specified by a "media" attribute in an inline stylesheet's STYLE tag.
    */
    private jpuppeteer.cdp.client.constant.css.CSSMediaSource source;

    /**
    * URL of the document containing the media query description.
    */
    private String sourceURL;

    /**
    * The associated rule (@media or @import) header range in the enclosing stylesheet (if available).
    */
    private jpuppeteer.cdp.client.entity.css.SourceRange range;

    /**
    * Identifier of the stylesheet containing this object (if exists).
    */
    private String styleSheetId;

    /**
    * Array of media queries.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.MediaQuery> mediaList;

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setSource (jpuppeteer.cdp.client.constant.css.CSSMediaSource source) {
        this.source = source;
    }

    public jpuppeteer.cdp.client.constant.css.CSSMediaSource getSource() {
        return this.source;
    }

    public void setSourceURL (String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getSourceURL() {
        return this.sourceURL;
    }

    public void setRange (jpuppeteer.cdp.client.entity.css.SourceRange range) {
        this.range = range;
    }

    public jpuppeteer.cdp.client.entity.css.SourceRange getRange() {
        return this.range;
    }

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public void setMediaList (java.util.List<jpuppeteer.cdp.client.entity.css.MediaQuery> mediaList) {
        this.mediaList = mediaList;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.MediaQuery> getMediaList() {
        return this.mediaList;
    }

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

    public CSSMedia() {
    }

}