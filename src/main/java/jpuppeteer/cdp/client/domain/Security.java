package jpuppeteer.cdp.client.domain;

/**
*/
public class Security {

    private jpuppeteer.cdp.CDPSession session;

    public Security(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Disables tracking security state changes.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Security.disable", null);
    }


    /**
    * Enables tracking security state changes.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Security.enable", null);
    }


    /**
    * Enable/disable whether all certificate errors should be ignored.
    * experimental
    */
    public io.netty.util.concurrent.Future setIgnoreCertificateErrors(jpuppeteer.cdp.client.entity.security.SetIgnoreCertificateErrorsRequest request) {
        return session.send("Security.setIgnoreCertificateErrors", request);
    }


    /**
    * Handles a certificate error that fired a certificateError event.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future handleCertificateError(jpuppeteer.cdp.client.entity.security.HandleCertificateErrorRequest request) {
        return session.send("Security.handleCertificateError", request);
    }


    /**
    * Enable/disable overriding certificate errors. If enabled, all certificate error events need to be handled by the DevTools client and should be answered with `handleCertificateError` commands.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setOverrideCertificateErrors(jpuppeteer.cdp.client.entity.security.SetOverrideCertificateErrorsRequest request) {
        return session.send("Security.setOverrideCertificateErrors", request);
    }

}