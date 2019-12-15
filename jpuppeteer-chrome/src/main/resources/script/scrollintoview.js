async function scrollIntoView(element) {
    return await new Promise((resolve, reject) => {
        //滚动事件
        let timer, lastTime = Date.now();
        function scroll(event) {
            lastTime = Date.now();
            if (!!timer) {
                clearTimeout(timer);
            }
            //超过100ms, 页面还没有任何滚动的话, 则触发一次滚动
            timer = setTimeout(function(){
                element.scrollIntoView();
            }, 100);
        }
        window.addEventListener("scroll", scroll, false);

        const observer = new IntersectionObserver(entries => {
            let entry = entries[0];
            if (entry.intersectionRatio > 0) {
                window.removeEventListener("scroll", scroll);
                observer.disconnect();
                return resolve(entry);
            }
        }, {
            threshold : [0, 0.1]
        });
        observer.observe(element);
        element.scrollIntoView({block: "center", inline:"center", behavior:"instant"});

        const timeout = setInterval(function(){
            if (Date.now() - lastTime > 1000) {
                clearInterval(timeout);
                window.removeEventListener("scroll", scroll);
                observer.disconnect();
                return reject(new Error("timeout"));
            }
        }, 100);
    });
}