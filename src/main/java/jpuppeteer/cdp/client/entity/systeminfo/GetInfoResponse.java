package jpuppeteer.cdp.client.entity.systeminfo;

/**
* experimental
*/
public class GetInfoResponse {

    /**
    * Information about the GPUs on the system.
    */
    private jpuppeteer.cdp.client.entity.systeminfo.GPUInfo gpu;

    /**
    * A platform-dependent description of the model of the machine. On Mac OS, this is, for example, 'MacBookPro'. Will be the empty string if not supported.
    */
    private String modelName;

    /**
    * A platform-dependent description of the version of the machine. On Mac OS, this is, for example, '10.1'. Will be the empty string if not supported.
    */
    private String modelVersion;

    /**
    * The command line string used to launch the browser. Will be the empty string if not supported.
    */
    private String commandLine;

    public void setGpu (jpuppeteer.cdp.client.entity.systeminfo.GPUInfo gpu) {
        this.gpu = gpu;
    }

    public jpuppeteer.cdp.client.entity.systeminfo.GPUInfo getGpu() {
        return this.gpu;
    }

    public void setModelName (String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setModelVersion (String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public String getModelVersion() {
        return this.modelVersion;
    }

    public void setCommandLine (String commandLine) {
        this.commandLine = commandLine;
    }

    public String getCommandLine() {
        return this.commandLine;
    }

    public GetInfoResponse(jpuppeteer.cdp.client.entity.systeminfo.GPUInfo gpu, String modelName, String modelVersion, String commandLine) {
        this.gpu = gpu;
        this.modelName = modelName;
        this.modelVersion = modelVersion;
        this.commandLine = commandLine;
    }

    public GetInfoResponse() {
    }

}