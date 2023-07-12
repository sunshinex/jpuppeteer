(function watchElement(selector, watchFunctionName, unwatchFunctionName, timeout) {
    const watchFunction = window[watchFunctionName];
    if (!watchFunction || !(watchFunction instanceof Function)) {
        throw new Error("Parameter `onVisibilityChange` must be a function");
    }
    if (!timeout) {
        timeout = 0;
    }
    const visibleMap = new Map();
    const parent = this === window || this === document ? document.documentElement : this;

    let idCounter = 0;
    function onChange(observer, action, node) {
        const objectId = selector + ':' + (idCounter++) + ":" + Math.random();
        window[objectId] = node;
        watchFunction(JSON.stringify({action: action, nodeId: objectId}));
    }

    function onShow(observer, node) {
        onChange(observer, 'show', node);
    }

    function onHide(observer, node) {
        onChange(observer, 'hide', node);
    }

    function checkType(node) {
        return !(!node || !node.nodeType ||
          node.nodeType !== 1);
    }

    function checkVisible(node) {
        const computedStyle = window.getComputedStyle(node);
        return computedStyle.visibility !== 'hidden' && node.getClientRects().length > 0;
    }

    const observer = new MutationObserver(function (mutationsList, observer) {
        for (let mutation of mutationsList) {
            if (mutation.type === 'childList') {
                for (let node of mutation.addedNodes) {
                    if (!checkType(node)) {
                        continue;
                    }
                    const watchedEls = parent.querySelectorAll(selector);
                    //处理onShow
                    for(let watchedEl of watchedEls) {
                        if (!node.contains(watchedEl)) {
                            //如果增加的节点不包含watch的对象, 则不需要处理
                            continue;
                        }
                        const oldIsVisible = !!visibleMap.get(watchedEl);
                        const newIsVisible = checkVisible(watchedEl);
                        if (newIsVisible && !oldIsVisible) {
                            onShow(observer, watchedEl);
                        } else if (!newIsVisible && oldIsVisible) {
                            onHide(observer, watchedEl);
                        }
                        visibleMap.set(watchedEl, newIsVisible);
                    }
                }
                for (let node of mutation.removedNodes) {
                    if (!checkType(node)) {
                        continue;
                    }
                    visibleMap.forEach((oldIsVisible, watchedEl) => {
                        if (!node.contains(watchedEl)) {
                            //如果增加的节点不包含watch的对象, 则不需要处理
                            return;
                        }
                        if (oldIsVisible) {
                            onHide(observer, watchedEl);
                        }
                        visibleMap.delete(watchedEl);
                    });
                }
            } else if (mutation.type === 'attributes') {
                //判断onShow/onHide
                if (!checkType(mutation.target)) {
                    return;
                }
                //针对节点仍然存在于页面的情况
                const watchedEls = parent.querySelectorAll(selector);
                const watchElSet = new Set();
                for(let watchedEl of watchedEls) {
                    watchElSet.add(watchedEl);
                    if (!mutation.target.contains(watchedEl)) {
                        //如果target不包含watch的对象, 则不需要处理
                        continue;
                    }
                    const oldIsVisible = !!visibleMap.get(watchedEl);
                    const newIsVisible = checkVisible(watchedEl);
                    if (newIsVisible && !oldIsVisible) {
                        onShow(observer, watchedEl);
                    } else if (!newIsVisible && oldIsVisible) {
                        onHide(observer, watchedEl);
                    }
                    visibleMap.set(watchedEl, newIsVisible);
                }
                //针对节点已经不存在于页面上了, 则直接将节点置为不可见
                visibleMap.forEach((visible, node) => {
                   if (visible && !watchElSet.has(node)) {
                       visibleMap.set(node, false);
                       onHide(observer, node);
                   }
                });
            }
        }
    });

    observer.observe(parent, {
        childList: true,
        subtree: true,
        attributes: true,
        attributeFilter: ['style', 'class']
    });

    let timer;
    window[unwatchFunctionName] = function () {
        if (timer) {
            clearTimeout(timer);
        }
        return observer.disconnect();
    }

    if (timeout > 0) {
        timer = setTimeout(function (){
            observer.disconnect();
        }, timeout);
    }

    const watchedEls = parent.querySelectorAll(selector);
    for(let watchedEl of watchedEls) {
        const isVisible = checkVisible(watchedEl);
        if (isVisible) {
            onShow(observer, watchedEl);
        } else {
            onHide(observer, watchedEl);
        }
        visibleMap.set(watchedEl, isVisible);
    }
})