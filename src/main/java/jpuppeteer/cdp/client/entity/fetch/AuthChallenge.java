package jpuppeteer.cdp.client.entity.fetch;

/**
* Authorization challenge for HTTP status code 401 or 407.
* experimental
*/
public class AuthChallenge {

    /**
    * Source of the authentication challenge.
    */
    public final jpuppeteer.cdp.client.constant.fetch.AuthChallengeSource source;

    /**
    * Origin of the challenger.
    */
    public final String origin;

    /**
    * The authentication scheme used, such as basic or digest
    */
    public final String scheme;

    /**
    * The realm of the challenge. May be empty.
    */
    public final String realm;

    public AuthChallenge(jpuppeteer.cdp.client.constant.fetch.AuthChallengeSource source, String origin, String scheme, String realm) {
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

}