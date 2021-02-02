document.addEventListener('DOMContentLoaded', function(ev){
    'use strict';
    function trackMouse(doc) {
        doc.addEventListener('mousemove', function(ev){
            console.log(ev);
            let node = doc.createElement('div');
            node.style='width:2px;height:2px;background:#f00;position:fixed;left:'+(ev.clientX+2)+'px;top:'+(ev.clientY+2)+'px;z-index:99999';
            doc.body.appendChild(node);
            setTimeout(function(){
                doc.body.removeChild(node);
            }, 100);
        }, false);

        const observer = new MutationObserver(function(mutationsList, observer){
            OUTER:
                for (let mutation of mutationsList) {
                    if (mutation.type === 'childList') {
                        for (let node of mutation.addedNodes) {
                            if (!node || !node.nodeType ||
                                node.nodeType !== 1 || !node.matches ||
                                !(node.matches instanceof Function)) {
                                continue;
                            }
                            if (node.nodeName === "IFRAME") {
                                trackMouse(node.contentDocument);
                            }
                        }
                    }
                }
        });

        observer.observe(doc, {
            childList: true,
            subtree: true,
        });
    }

    trackMouse(document);
}, false);