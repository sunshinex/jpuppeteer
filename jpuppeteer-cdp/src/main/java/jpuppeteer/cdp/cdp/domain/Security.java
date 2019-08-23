package jpuppeteer.cdp.cdp.domain;

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
    public void disable(int timeout) throws Exception {
        session.send("Security.disable", null, timeout);
    }


    /**
    * Enables tracking security state changes.
    */
    public void enable(int timeout) throws Exception {
        session.send("Security.enable", null, timeout);
    }


    /**
    * Enable/disable whether all certificate errors should be ignored.
    */
    public void setIgnoreCertificateErrors(jpuppeteer.cdp.cdp.entity.security.SetIgnoreCertificateErrorsRequest request, int timeout) throws Exception {
        session.send("Security.setIgnoreCertificateErrors", request, timeout);
    }


    /**
    * Handles a certificate error that fired a certificateError event.
    */
    public void handleCertificateError(jpuppeteer.cdp.cdp.entity.security.HandleCertificateErrorRequest request, int timeout) throws Exception {
        session.send("Security.handleCertificateError", request, timeout);
    }


    /**
    * Enable/disable overriding certificate errors. If enabled, all certificate error events need to be handled by the DevTools client and should be answered with `handleCertificateError` commands.
    */
    public void setOverrideCertificateErrors(jpuppeteer.cdp.cdp.entity.security.SetOverrideCertificateErrorsRequest request, int timeout) throws Exception {
        session.send("Security.setOverrideCertificateErrors", request, timeout);
    }

}