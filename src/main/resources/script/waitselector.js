async function waitSelector(selector, timeout) {
    return new Promise(function(resolve, reject){
        const target = document.querySelector(selector);
        if (target != null && target.getClientRects().length > 0) {
            return resolve(target);
        }
        const observer = new MutationObserver(function(mutationsList, observer){
            for(let mutation of mutationsList) {
                if (mutation.type === 'childList') {
                    for (let node of mutation.addedNodes) {
                        if (node.matches(selector) && node.getClientRects().length > 0) {
                            observer.disconnect();
                            clearTimeout(timer);
                            resolve(mutation.target);
                        }
                    }
                } else if (mutation.type === "attributes") {
                    if (mutation.target.matches(selector) && mutation.target.getClientRects().length > 0) {
                        //对象可见
                        observer.disconnect();
                        clearTimeout(timer);
                        resolve(mutation.target);
                    }
                }
            }
        });

        observer.observe(this === window ? document : this, {
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