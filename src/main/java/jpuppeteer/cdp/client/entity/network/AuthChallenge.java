package jpuppeteer.cdp.client.entity.network;

/**
* Authorization challenge for HTTP status code 401 or 407.
*/
public class AuthChallenge {

    /**
    * Source of the authentication challenge.
    */
    private jpuppeteer.cdp.client.constant.network.AuthChallengeSource source;

    /**
    * Origin of the challenger.
    */
    private String origin;

    /**
    * The authentication scheme used, such as basic or digest
    */
    private String scheme;

    /**
    * The realm of the challenge. May be empty.
    */
    private String realm;

    public void setSource (jpuppeteer.cdp.client.constant.network.AuthChallengeSource source) {
        this.source = source;
    }

    public jpuppeteer.cdp.client.constant.network.AuthChallengeSource getSource() {
        return this.source;
    }

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setScheme (String scheme) {
        this.scheme = scheme;
    }

    public String getScheme() {
        return this.scheme;
    }

    public void setRealm (String realm) {
        this.realm = realm;
    }

    public String getRealm() {
        return this.realm;
    }

    public AuthChallenge(jpuppeteer.cdp.client.constant.network.AuthChallengeSource source, String origin, String scheme, String realm) {
        this.source = source;
        this.origin = origin;
        this.scheme = scheme;
        this.realm = realm;
    }

    public AuthChallenge(String origin, String scheme, String realm) {
        this.source = null;
        this.origin = origin;
        this.scheme = scheme;
        this.realm = realm;
    }

    public AuthChallenge() {
    }

}