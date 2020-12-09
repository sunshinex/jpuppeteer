async function waitSelector(selector, timeout) {
    const root = this === window || this === undefined ? document : this;
    return new Promise(function(resolve, reject){
        const target = document.querySelector(selector);
        if (target != null && target.getClientRects().length > 0) {
            return resolve(target);
        }
        function checkNode(node) {
            if (!node.nodeType || node.nodeType != 1 || !node.matches || !(node.matches instanceof Function)) {
                return;
            }
            if (node.matches(selector) && node.getClientRects().length > 0) {
                observer.disconnect();
                clearTimeout(timer);
                resolve(node);
                return true;
            }
        }
        const observer = new MutationObserver(function(mutationsList, observer){
            try {
                OUTER:
                for (let mutation of mutationsList) {
                    if (mutation.type === 'childList') {
                        for (let node of mutation.addedNodes) {
                            if (!!checkNode(node)) {
                                break OUTER;
                            }
                        }
                    } else if (mutation.type === "attributes") {
                        if (!!checkNode(mutation.target)) {
                            break;
                        }
                    }
                }
            } catch (e) {
                observer.disconnect();
                reject(e);
            }
        });

        observer.observe(root, {
            childList: true,
            subtree: true,
            attributes: true
        });

        const timer = setTimeout(function(){
            observer.disconnect();
            reject(new Error("timeout"));
        }, timeout);
    });
}