package jpuppeteer.util;

import jpuppeteer.cdp.client.entity.runtime.EvaluateRequest;

import java.math.BigDecimal;

public final class EvaluateRequestBuilder {
    private String expression;
    private String objectGroup;
    private Boolean includeCommandLineAPI;
    private Boolean silent;
    private Integer contextId;
    private Boolean returnByValue;
    private Boolean generatePreview;
    private Boolean userGesture;
    private Boolean awaitPromise;
    private Boolean throwOnSideEffect;
    private java.math.BigDecimal timeout;
    private Boolean disableBreaks;
    private Boolean replMode;
    private Boolean allowUnsafeEvalBlockedByCSP;
    private String uniqueContextId;

    private EvaluateRequestBuilder() {
    }

    public static EvaluateRequestBuilder newBuilder() {
        return new EvaluateRequestBuilder();
    }

    public EvaluateRequestBuilder expression(String expression) {
        this.expression = expression;
        return this;
    }

    public EvaluateRequestBuilder objectGroup(String objectGroup) {
        this.objectGroup = objectGroup;
        return this;
    }

    public EvaluateRequestBuilder includeCommandLineAPI(Boolean includeCommandLineAPI) {
        this.includeCommandLineAPI = includeCommandLineAPI;
        return this;
    }

    public EvaluateRequestBuilder silent(Boolean silent) {
        this.silent = silent;
        return this;
    }

    public EvaluateRequestBuilder contextId(Integer contextId) {
        this.contextId = contextId;
        return this;
    }

    public EvaluateRequestBuilder returnByValue(Boolean returnByValue) {
        this.returnByValue = returnByValue;
        return this;
    }

    public EvaluateRequestBuilder generatePreview(Boolean generatePreview) {
        this.generatePreview = generatePreview;
        return this;
    }

    public EvaluateRequestBuilder userGesture(Boolean userGesture) {
        this.userGesture = userGesture;
        return this;
    }

    public EvaluateRequestBuilder awaitPromise(Boolean awaitPromise) {
        this.awaitPromise = awaitPromise;
        return this;
    }

    public EvaluateRequestBuilder throwOnSideEffect(Boolean throwOnSideEffect) {
        this.throwOnSideEffect = throwOnSideEffect;
        return this;
    }

    public EvaluateRequestBuilder timeout(BigDecimal timeout) {
        this.timeout = timeout;
        return this;
    }

    public EvaluateRequestBuilder disableBreaks(Boolean disableBreaks) {
        this.disableBreaks = disableBreaks;
        return this;
    }

    public EvaluateRequestBuilder replMode(Boolean replMode) {
        this.replMode = replMode;
        return this;
    }

    public EvaluateRequestBuilder allowUnsafeEvalBlockedByCSP(Boolean allowUnsafeEvalBlockedByCSP) {
        this.allowUnsafeEvalBlockedByCSP = allowUnsafeEvalBlockedByCSP;
        return this;
    }

    public EvaluateRequestBuilder uniqueContextId(String uniqueContextId) {
        this.uniqueContextId = uniqueContextId;
        return this;
    }

    public EvaluateRequest build() {
        return new EvaluateRequest(expression, objectGroup, includeCommandLineAPI, silent, contextId, returnByValue, generatePreview, userGesture, awaitPromise, throwOnSideEffect, timeout, disableBreaks, replMode, allowUnsafeEvalBlockedByCSP, uniqueContextId);
    }
}
