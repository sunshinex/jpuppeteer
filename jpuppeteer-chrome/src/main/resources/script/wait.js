async function wait(expression, timeout) {
    return await new Promise(async (resolve, reject) => {
        let isTimeout = false;
        const args = Array.prototype.slice.call(arguments, 2);
        const func = eval("(" + expression + ")");
        if (!func instanceof Function) {
            return reject("expression is not a vaild function");
        }
        async function handler() {
            let result = undefined;
            try {
                if (func.constructor.name == "AsyncFunction") {
                    result = await func.apply(undefined, args);
                } else {
                    result = func.apply(undefined, args);
                }
                if (isTimeout) {
                    //执行超时, 不需要往后执行
                    return;
                }
                if (result === null || result === undefined) {
                    //未取得结果, 需要继续轮询
                    return setTimeout(handler, 100);
                }
                //成功取得轮询结果
                return resolve(result);
            } catch (e) {
                //执行异常
                return reject(e);
            }
        }
        setTimeout(handler, 100);
        setTimeout(function(){
            isTimeout = true;
            reject(new Error("timeout"));
        }, timeout);
    });
}