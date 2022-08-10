package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetVirtualTimePolicyRequest {

    /**
    */
    private jpuppeteer.cdp.client.constant.emulation.VirtualTimePolicy policy;

    /**
    * If set, after this many virtual milliseconds have elapsed virtual time will be paused and a virtualTimeBudgetExpired event is sent.
    */
    private java.math.BigDecimal budget;

    /**
    * If set this specifies the maximum number of tasks that can be run before virtual is forced forwards to prevent deadlock.
    */
    private Integer maxVirtualTimeTaskStarvationCount;

    /**
    * If set the virtual time policy change should be deferred until any frame starts navigating. Note any previous deferred policy change is superseded.
    */
    private Boolean waitForNavigation;

    /**
    * If set, base::Time::Now will be overridden to initially return this value.
    */
    private java.math.BigDecimal initialVirtualTime;

    public void setPolicy (jpuppeteer.cdp.client.constant.emulation.VirtualTimePolicy policy) {
        this.policy = policy;
    }

    public jpuppeteer.cdp.client.constant.emulation.VirtualTimePolicy getPolicy() {
        return this.policy;
    }

    public void setBudget (java.math.BigDecimal budget) {
        this.budget = budget;
    }

    public java.math.BigDecimal getBudget() {
        return this.budget;
    }

    public void setMaxVirtualTimeTaskStarvationCount (Integer maxVirtualTimeTaskStarvationCount) {
        this.maxVirtualTimeTaskStarvationCount = maxVirtualTimeTaskStarvationCount;
    }

    public Integer getMaxVirtualTimeTaskStarvationCount() {
        return this.maxVirtualTimeTaskStarvationCount;
    }

    public void setWaitForNavigation (Boolean waitForNavigation) {
        this.waitForNavigation = waitForNavigation;
    }

    public Boolean getWaitForNavigation() {
        return this.waitForNavigation;
    }

    public void setInitialVirtualTime (java.math.BigDecimal initialVirtualTime) {
        this.initialVirtualTime = initialVirtualTime;
    }

    public java.math.BigDecimal getInitialVirtualTime() {
        return this.initialVirtualTime;
    }

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

    public SetVirtualTimePolicyRequest() {
    }

}