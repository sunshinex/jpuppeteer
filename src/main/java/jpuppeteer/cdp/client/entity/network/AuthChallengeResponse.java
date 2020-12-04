package jpuppeteer.cdp.client.entity.network;

/**
* Response to an AuthChallenge.
*/
public class AuthChallengeResponse {

    /**
    * The decision on what to do in response to the authorization challenge.  Default means deferring to the default behavior of the net stack, which will likely either the Cancel authentication or display a popup dialog box.
    */
    public final String response;

    /**
    * The username to provide, possibly empty. Should only be set if response is ProvideCredentials.
    */
    public final String username;

    /**
    * The password to provide, possibly empty. Should only be set if response is ProvideCredentials.
    */
    public final String password;

    public AuthChallengeResponse(String response, String username, String password) {
        this.response = response;
        this.username = username;
        this.password = password;
    }

    public AuthChallengeResponse(String response) {
        this.response = response;
        this.username = null;
        this.password = null;
    }

}