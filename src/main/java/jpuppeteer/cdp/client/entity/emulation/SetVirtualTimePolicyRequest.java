package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetVirtualTimePolicyRequest {

    /**
    */
    public final jpuppeteer.cdp.client.constant.emulation.VirtualTimePolicy policy;

    /**
    * If set, after this many virtual milliseconds have elapsed virtual time will be paused and a virtualTimeBudgetExpired event is sent.
    */
    public final java.math.BigDecimal budget;

    /**
    * If set this specifies the maximum number of tasks that can be run before virtual is forced forwards to prevent deadlock.
    */
    public final Integer maxVirtualTimeTaskStarvationCount;

    /**
    * If set the virtual time policy change should be deferred until any frame starts navigating. Note any previous deferred policy change is superseded.
    */
    public final Boolean waitForNavigation;

    /**
    * If set, base::Time::Now will be overridden to initially return this value.
    */
    public final java.math.BigDecimal initialVirtualTime;

    public SetVirtualTimePolicyRequest(jpuppeteer.cdp.client.constant.emulation.VirtualTimePolicy policy, java.math.BigDecimal budget, Integer maxVirtualTimeTaskStarvationCount, Boolean waitForNavigation, java.math.BigDecimal initialVirtualTime) {
        this.policy = policy;
        this.budget = budget;
        this.maxVirtualTimeTaskStarvationCount = maxVirtualTimeTaskStarvationCount;
        this.waitForNavigation = waitForNavigation;
        this.initialVirtualTime = initialVirtualTime;
    }

    public SetVirtualTimePolicyRequest(jpuppeteer.cdp.client.constant.emulation.VirtualTimePolicy policy) {
        this.policy = policy;
        this.budget = null;
        this.maxVirtualTimeTaskStarvationCount = null;
        this.waitForNavigation = null;
        this.initialVirtualTime = null;
    }

}