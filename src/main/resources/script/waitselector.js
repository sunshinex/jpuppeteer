async function waitSelector(selector, timeout) {
    const root = this === window || this === undefined ? document : this;
    return new Promise(function(resolve, reject){
        function checkType(node) {
            if (!node || !node.nodeType ||
                node.nodeType !== 1 || !node.matches ||
                !(node.matches instanceof Function)) {
                return false;
            }
            return true;
        }
        function checkVisible(node) {
            return node.getClientRects().length > 0;
        }
        function checkDone(node) {
            if (!checkType(node)) {
                return false;
            }
            if (node.matches(selector)) {
                //节点本身是目标节点
                if (checkVisible(node)) {
                    //目标节点可见，完成
                    done(node);
                    return true;
                } else {
                    return false;
                }
            } else {
                //节点本身不是目标节点，也需要判断子节点是否存在目标节点
                const result = node.querySelector(selector);
                if (checkType(result) && checkVisible(result)) {
                    done(result);
                    return true;
                } else {
                    return false;
                }
            }
        }

        function done(node) {
            observer.disconnect();
            clearTimeout(timer);
            resolve(node);
        }

        function fail(e) {
            observer.disconnect();
            clearTimeout(timer);
            reject(e);
        }

        const observer = new MutationObserver(function(mutationsList, observer){
            try {
                OUTER:
                for (let mutation of mutationsList) {
                    if (mutation.type === 'childList') {
                        for (let node of mutation.addedNodes) {
                            if (!!checkDone(node)) {
                                break OUTER;
                            }
                        }
                    } else if (mutation.type === "attributes") {
                        if (!!checkDone(mutation.target)) {
                            break;
                        }
                    }
                }
            } catch (e) {
                fail(e);
            }
        });

        observer.observe(root, {
            childList: true,
            subtree: true,
            attributes: true
        });

        const timer = setTimeout(function(){
            fail(new Error("timeout"));
        }, timeout);

        checkDone(root.querySelector(selector));
    });
}