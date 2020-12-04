package jpuppeteer.cdp.client.entity.systeminfo;

/**
* experimental
*/
public class GetInfoResponse {

    /**
    * Information about the GPUs on the system.
    */
    public final jpuppeteer.cdp.client.entity.systeminfo.GPUInfo gpu;

    /**
    * A platform-dependent description of the model of the machine. On Mac OS, this is, for example, 'MacBookPro'. Will be the empty string if not supported.
    */
    public final String modelName;

    /**
    * A platform-dependent description of the version of the machine. On Mac OS, this is, for example, '10.1'. Will be the empty string if not supported.
    */
    public final String modelVersion;

    /**
    * The command line string used to launch the browser. Will be the empty string if not supported.
    */
    public final String commandLine;

    public GetInfoResponse(jpuppeteer.cdp.client.entity.systeminfo.GPUInfo gpu, String modelName, String modelVersion, String commandLine) {
        this.gpu = gpu;
        this.modelName = modelName;
        this.modelVersion = modelVersion;
        this.commandLine = commandLine;
    }

}