package jpuppeteer.cdp.client.entity.page;

/**
*/
public class InstallabilityErrorArgument {

    /**
    * Argument name (e.g. name:'minimum-icon-size-in-pixels').
    */
    private String name;

    /**
    * Argument value (e.g. value:'64').
    */
    private String value;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public InstallabilityErrorArgument(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public InstallabilityErrorArgument() {
    }

}