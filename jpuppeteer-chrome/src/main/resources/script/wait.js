async function wait(expression, timeout) {
    return await new Promise(async (resolve, reject) => {
        const poll = new Function(expression);
        const timer = setInterval(function(){
            let result = poll();
            if (result === null || result === undefined) {
                return;
            }
            clearInterval(timer);
            resolve(result);
        }, 100);
        setTimeout(function(){
            reject(new Error("timeout"));
        }, timeout);
    });
}