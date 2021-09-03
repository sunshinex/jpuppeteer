package jpuppeteer.cdp.client.entity.page;

/**
*/
public class InstallabilityErrorArgument {

    /**
    * Argument name (e.g. name:'minimum-icon-size-in-pixels').
    */
    public final String name;

    /**
    * Argument value (e.g. value:'64').
    */
    public final String value;

    public InstallabilityErrorArgument(String name, String value) {
        this.name = name;
        this.value = value;
    }

}