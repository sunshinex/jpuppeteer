(function () {
  const attachShadow = Element.prototype.attachShadow;
  Element.prototype.attachShadow = function (options) {
    options.mode = 'open';
    return attachShadow.call(this, options);
  }
})();