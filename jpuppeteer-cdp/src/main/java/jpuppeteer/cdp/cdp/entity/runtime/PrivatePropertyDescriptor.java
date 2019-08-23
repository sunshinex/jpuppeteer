package jpuppeteer.cdp.cdp.entity.runtime;

/**
* Object private field descriptor.
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class PrivatePropertyDescriptor {

    /**
    * Private property name.
    */
    private String name;

    /**
    * The value associated with the private property.
    */
    private jpuppeteer.cdp.cdp.entity.runtime.RemoteObject value;



}