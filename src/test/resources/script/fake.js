(function () {
  /**
   * 适配chrome 89
   * @see https://www.browserling.com/blog/5620-chrome-89-released
   * 直接删除webdriver定义
   */
  delete Navigator.prototype.webdriver;
  window.xconsole = {};
  Object.assign(window.xconsole, window.console);
  //针对所有的控制台都不输出
  const context = console.context();
  const csl = {
    debug : {
      value: function(){}
    },
    error : {
      value: function(){}
    },
    log : {
      value: function(){}
    },
    warn : {
      value: function(){}
    },
    dir : {
      value: function(){}
    },
    dirxml : {
      value: function(){}
    },
    table : {
      value: function(){}
    },
    trace : {
      value: function(){}
    },
    group : {
      value: function(){}
    },
    groupCollapsed : {
      value: function(){}
    },
    groupEnd : {
      value: function(){}
    },
    clear : {
      value: function(){}
    },
    count : {
      value: function(){}
    },
    countReset : {
      value: function(){}
    },
    assert : {
      value: function(){}
    },
    profile : {
      value: function(){}
    },
    profileEnd : {
      value: function(){}
    },
    time : {
      value: function(){}
    },
    timeLog : {
      value: function(){}
    },
    timeEnd : {
      value: function(){}
    },
    timeStamp : {
      value: function(){}
    },
    context : {
      value: function(){
        return context;
      }
    }
  }
  Object.defineProperties(context, csl);
  Object.defineProperties(console, csl);
  //伪造电池信息
  Object.defineProperty(BatteryManager.prototype, "charging", {
    get: () => true
  });
  Object.defineProperty(BatteryManager.prototype, "level", {
    get: () => (0.90 + 0.1 * window.fakeRandom).toFixed(2) * 1
  });
  Object.defineProperty(BatteryManager.prototype, "chargingTime", {
    get: () => Infinity
  });
  //伪造history
  Object.defineProperty(History.prototype, "length", {
    get: () => Math.round(20 * window.fakeRandom)
  });
  //伪造硬件信息
  const allCpus = [2, 4, 8, 16];
  const cpuIndex = Math.ceil(100 * window.fakeRandom) % allCpus.length;
  const cpu = allCpus[cpuIndex];
  Object.defineProperty(Navigator.prototype, "hardwareConcurrency", {
    get: () => cpu
  });
  Object.defineProperty(Navigator.prototype, "deviceMemory", {
    get: () => cpu * 2
  });
  Object.defineProperty(Navigator.prototype, "maxTouchPoints", {
    get: () => 20
  });
})();