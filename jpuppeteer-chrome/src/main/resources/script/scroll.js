async function elementScroll(element, x, y) {
    if (element === null || element === undefined) {
        element = window;
    }
    return await new Promise((resolve, reject) => {
        let timer = null;

        function doTimer() {
            if (timer !== null) {
                clearTimeout(timer);
            }
            timer = setTimeout(function(){
                resolve({scrollX:element.scrollX, scrollY:element.scrollY});
                element.removeEventListener('scroll', doTimer);
            }, 30);
        }
        try {
            element.addEventListener('scroll', doTimer, false);
            element.scroll(x, y);
        } catch (e) {
            reject(e);
        }
    });
}