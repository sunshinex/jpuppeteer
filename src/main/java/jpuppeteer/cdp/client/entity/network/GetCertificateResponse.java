package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetCertificateResponse {

    /**
    */
    private java.util.List<String> tableNames;

    public void setTableNames (java.util.List<String> tableNames) {
        this.tableNames = tableNames;
    }

    public java.util.List<String> getTableNames() {
        return this.tableNames;
    }

    public GetCertificateResponse(java.util.List<String> tableNames) {
        this.tableNames = tableNames;
    }

    public GetCertificateResponse() {
    }

}