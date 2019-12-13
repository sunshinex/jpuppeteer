async function evaluate(self, expression) {
    return await new Promise(async (resolve, reject) => {
        const args = Array.prototype.slice.call(arguments, 2);
        const func = eval("(" + expression + ")");
        if (!func instanceof Function) {
            return reject("expression is not a vaild function");
        }
        if (func.constructor.name == "AsyncFunction") {
            result = await func.apply(self, args);
        } else {
            result = func.apply(self, args);
        }
        resolve(result);
    });
}