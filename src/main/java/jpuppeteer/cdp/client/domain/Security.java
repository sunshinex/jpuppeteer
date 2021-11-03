package jpuppeteer.cdp.client.domain;

/**
*/
public class Security {

    private jpuppeteer.cdp.CDPConnection connection;

    public Security(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Disables tracking security state changes.
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("Security.disable", null);
    }


    /**
    * Enables tracking security state changes.
    */
    public io.netty.util.concurrent.Future enable() {
        return connection.send("Security.enable", null);
    }


    /**
    * Enable/disable whether all certificate errors should be ignored.
    * experimental
    */
    public io.netty.util.concurrent.Future setIgnoreCertificateErrors(jpuppeteer.cdp.client.entity.security.SetIgnoreCertificateErrorsRequest request) {
        return connection.send("Security.setIgnoreCertificateErrors", request);
    }


    /**
    * Handles a certificate error that fired a certificateError event.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future handleCertificateError(jpuppeteer.cdp.client.entity.security.HandleCertificateErrorRequest request) {
        return connection.send("Security.handleCertificateError", request);
    }


    /**
    * Enable/disable overriding certificate errors. If enabled, all certificate error events need to be handled by the DevTools client and should be answered with `handleCertificateError` commands.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setOverrideCertificateErrors(jpuppeteer.cdp.client.entity.security.SetOverrideCertificateErrorsRequest request) {
        return connection.send("Security.setOverrideCertificateErrors", request);
    }

}