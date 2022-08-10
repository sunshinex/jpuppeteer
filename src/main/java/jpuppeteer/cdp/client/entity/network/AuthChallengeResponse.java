package jpuppeteer.cdp.client.entity.network;

/**
* Response to an AuthChallenge.
*/
public class AuthChallengeResponse {

    /**
    * The decision on what to do in response to the authorization challenge.  Default means deferring to the default behavior of the net stack, which will likely either the Cancel authentication or display a popup dialog box.
    */
    private jpuppeteer.cdp.client.constant.network.AuthChallengeResponseResponse response;

    /**
    * The username to provide, possibly empty. Should only be set if response is ProvideCredentials.
    */
    private String username;

    /**
    * The password to provide, possibly empty. Should only be set if response is ProvideCredentials.
    */
    private String password;

    public void setResponse (jpuppeteer.cdp.client.constant.network.AuthChallengeResponseResponse response) {
        this.response = response;
    }

    public jpuppeteer.cdp.client.constant.network.AuthChallengeResponseResponse getResponse() {
        return this.response;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public AuthChallengeResponse(jpuppeteer.cdp.client.constant.network.AuthChallengeResponseResponse response, String username, String password) {
        this.response = response;
        this.username = username;
        this.password = password;
    }

    public AuthChallengeResponse(jpuppeteer.cdp.client.constant.network.AuthChallengeResponseResponse response) {
        this.response = response;
        this.username = null;
        this.password = null;
    }

    public AuthChallengeResponse() {
    }

}