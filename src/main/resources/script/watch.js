function watchSelector(selector, notifyFunctionName, once) {
    let counter = 0;
    const root = this === window || this === undefined ? document : this;
    function checkType(node) {
        return !(!node || !node.nodeType ||
          node.nodeType !== 1 || !node.matches ||
          !(node.matches instanceof Function));
    }
    function checkVisibility(node) {
        return node.getClientRects().length > 0;
    }
    function checkVisibilityChange(node) {
        let oldVisibility = node.__old_visibility__;
        if (!oldVisibility) {
            //如果没有检查过可见性的, 默认为不可见
            oldVisibility = false;
        }
        let newVisibility = checkVisibility(node);
        node.__old_visibility__ = newVisibility;
        return !!newVisibility && !oldVisibility;
    }
    function checkDone(node) {
        if (!checkType(node)) {
            return false;
        }
        if (node.matches(selector)) {
            //节点本身是目标节点
            if (checkVisibilityChange(node)) {
                //目标节点可见，完成
                notify(node);
                return true;
            } else {
                return false;
            }
        } else {
            //节点本身不是目标节点，也需要判断子节点是否存在目标节点
            const result = node.querySelector(selector);
            if (checkType(result) && checkVisibilityChange(result)) {
                notify(result);
                return true;
            } else {
                return false;
            }
        }
    }

    function notify(node) {
        const hash = notifyFunctionName + "_" + (++counter);
        window[hash] = node;
        window[notifyFunctionName](hash);
        if (once) {
            observer.disconnect();
        }
    }

    const observer = new MutationObserver(function(mutationsList, observer){
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
    });

    observer.observe(root, {
        childList: true,
        subtree: true,
        attributes: true
    });

    checkDone(root.querySelector(selector));
}