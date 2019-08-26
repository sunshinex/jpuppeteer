async function wait(expression, timeout) {
    return await new Promise(async (resolve, reject) => {
        const args = Array.prototype.slice.call(arguments, 2);
        const func = eval("(" + expression + ")");
        if (!func instanceof Function) {
            return reject("expression is not a vaild function");
        }
        const timer = setInterval(async function(){
            let result;
            if (func.constructor.name == "AsyncFunction") {
                result = await func.apply(undefined, args);
            } else {
                result = func.apply(undefined, args);
            }
            if (result === null || result === undefined) {
                return;
            }
            clearInterval(timer);
            resolve(result);
        }, 100);
        setTimeout(function(){
            clearInterval(timer);
            reject(new Error("timeout"));
        }, timeout);
    });
}