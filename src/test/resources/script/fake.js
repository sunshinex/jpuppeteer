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
  //伪造屏幕高度
  Object.defineProperty(Screen.prototype, "availHeight", {
    get: function(){
      return this.height - 40;
    }
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
  //伪造webgl信息
  try {
    const config = {
      "random": {
        "value": function () {
          return window.fakeRandom;
        },
        "item": function (e) {
          let rand = e.length * config.random.value();
          return e[Math.floor(rand)];
        },
        "number": function (power) {
          let tmp = [];
          for (let i = 0; i < power.length; i++) {
            tmp.push(Math.pow(2, power[i]));
          }
          /*  */
          return config.random.item(tmp);
        },
        "int": function (power) {
          let tmp = [];
          for (let i = 0; i < power.length; i++) {
            let n = Math.pow(2, power[i]);
            tmp.push(new Int32Array([n, n]));
          }
          /*  */
          return config.random.item(tmp);
        },
        "float": function (power) {
          let tmp = [];
          for (let i = 0; i < power.length; i++) {
            let n = Math.pow(2, power[i]);
            tmp.push(new Float32Array([1, n]));
          }
          /*  */
          return config.random.item(tmp);
        }
      }
    };
    function fakeBufferData(target) {
      const proto = target.prototype ? target.prototype : target.__proto__;
      const bufferData = proto.bufferData;
      Object.defineProperty(proto, "bufferData", {
        "value": function () {
          let index = Math.floor(config.random.value() * arguments[1].length);
          let noise = arguments[1][index] !== undefined ? 0.1 * config.random.value() * arguments[1][index] : 0;
          arguments[1][index] = arguments[1][index] + noise;
          return bufferData.apply(this, arguments);
        }
      });
    }
    function fakeGetParameter(target) {
      const proto = target.prototype ? target.prototype : target.__proto__;
      const getParameter = proto.getParameter;
      Object.defineProperty(proto, "getParameter", {
        "value": function () {
          let val;
          switch (arguments[0]) {
            case WebGLRenderingContext.ALIASED_POINT_SIZE_RANGE:
              val = new Float32Array([1, 1024]);
              break;
            case WebGLRenderingContext.MAX_CUBE_MAP_TEXTURE_SIZE:
              val = 16384;
              break;
            case WebGLRenderingContext.MAX_FRAGMENT_UNIFORM_VECTORS:
              val = 1024;
              break;
            case WebGLRenderingContext.MAX_TEXTURE_SIZE:
              val = 16384;
              break;
            case WebGLRenderingContext.MAX_VARYING_VECTORS:
              val = 30;
              break;
            case WebGLRenderingContext.MAX_VERTEX_ATTRIBS:
              val = 16;
              break;
            case WebGLRenderingContext.MAX_VERTEX_UNIFORM_VECTORS:
              val = 4096;
              break;
            case WebGLRenderingContext.MAX_VIEWPORT_DIMS:
              val = new Float32Array([32767, 32767]);
              break;
            case WebGLRenderingContext.STENCIL_BACK_VALUE_MASK:
              val = 2147483647;
              break;
            case WebGLRenderingContext.STENCIL_WRITEMASK:
              val = 2147483647;
              break;
            case 37446:
              val = config.random.item([
                "ANGLE (Intel(R) UHD Graphics 620 Direct3D11 vs_5_0 ps_5_0)",
                "ANGLE (AMD Radeon HD 7300 Series Direct3D11 vs_5_0 ps_5_0)",
                "ANGLE (AMD Radeon RX 6000 Series Direct3D11 vs_5_0 ps_5_0)",
                "ANGLE (AMD Radeon RX 6800 Series Direct3D11 vs_5_0 ps_5_0)",
                "ANGLE (AMD Radeon RX 5000 Series Direct3D11 vs_5_0 ps_5_0)",
                "ANGLE (AMD Radeon RX 500 Series Direct3D11 vs_5_0 ps_5_0)",
                "ANGLE (AMD Radeon RX 6900 Series Direct3D11 vs_5_0 ps_5_0)",
                "ANGLE (NVIDIA GEFORCE RTX 30 Series Direct3D11 vs_5_0 ps_5_0)"
              ]);
              break;
            default:
              let args = Array.prototype.slice.call(arguments);
              val = getParameter.apply(this, args);
          }
          return val;
        }
      });
    }
    function fakeGetSupportedExtensions(target) {
      const proto = target.prototype ? target.prototype : target.__proto__;
      const getSupportedExtensions = proto.getSupportedExtensions;
      Object.defineProperty(proto, "getSupportedExtensions", {
        value: function(){
          return [
            "ANGLE_instanced_arrays","EXT_blend_minmax",
            "EXT_color_buffer_half_float","EXT_disjoint_timer_query",
            "EXT_float_blend","EXT_frag_depth",
            "EXT_shader_texture_lod","EXT_texture_compression_bptc",
            "EXT_texture_compression_rgtc","EXT_texture_filter_anisotropic",
            "WEBKIT_EXT_texture_filter_anisotropic",
            "EXT_sRGB","KHR_parallel_shader_compile",
            "OES_element_index_uint","OES_fbo_render_mipmap",
            "OES_standard_derivatives","OES_texture_float",
            "OES_texture_float_linear","OES_texture_half_float",
            "OES_texture_half_float_linear","OES_vertex_array_object",
            "WEBGL_color_buffer_float","WEBGL_compressed_texture_s3tc",
            "WEBKIT_WEBGL_compressed_texture_s3tc",
            "WEBGL_compressed_texture_s3tc_srgb",
            "WEBGL_debug_renderer_info","WEBGL_debug_shaders",
            "WEBGL_depth_texture","WEBKIT_WEBGL_depth_texture",
            "WEBGL_draw_buffers","WEBGL_lose_context",
            "WEBKIT_WEBGL_lose_context","WEBGL_multi_draw"
          ];
        }
      });
    }
    fakeBufferData(WebGLRenderingContext);
    fakeGetParameter(WebGLRenderingContext);
    fakeGetSupportedExtensions(WebGLRenderingContext);
    fakeBufferData(WebGL2RenderingContext);
    fakeGetParameter(WebGL2RenderingContext);
    fakeGetSupportedExtensions(WebGL2RenderingContext);
  } catch (err) {xconsole.log(err)}
  //伪造Canvas
  try {
    const toBlob = HTMLCanvasElement.prototype.toBlob;
    const toDataURL = HTMLCanvasElement.prototype.toDataURL;
    const getImageData = CanvasRenderingContext2D.prototype.getImageData;
    //
    const noisify = function (canvas, context) {
      if (context) {
        const shift = {
          'r': Math.floor(window.fakeRandom * 10) - 5,
          'g': Math.floor(window.fakeRandom * 10) - 5,
          'b': Math.floor(window.fakeRandom * 10) - 5,
          'a': Math.floor(window.fakeRandom * 10) - 5
        };
        //
        const width = canvas.width;
        const height = canvas.height;
        if (width && height) {
          const imageData = getImageData.apply(context, [0, 0, width, height]);
          for (let i = 0; i < height; i++) {
            for (let j = 0; j < width; j++) {
              const n = ((i * (width * 4)) + (j * 4));
              imageData.data[n + 0] = imageData.data[n + 0] + shift.r;
              imageData.data[n + 1] = imageData.data[n + 1] + shift.g;
              imageData.data[n + 2] = imageData.data[n + 2] + shift.b;
              imageData.data[n + 3] = imageData.data[n + 3] + shift.a;
            }
          }
          //
          context.putImageData(imageData, 0, 0);
        }
      }
    };

    Object.defineProperty(HTMLCanvasElement.prototype, "toBlob", {
      "value": function () {
        noisify(this, this.getContext("2d"));
        return toBlob.apply(this, arguments);
      }
    });

    Object.defineProperty(HTMLCanvasElement.prototype, "toDataURL", {
      "value": function () {
        noisify(this, this.getContext("2d"));
        return toDataURL.apply(this, arguments);
      }
    });

    Object.defineProperty(CanvasRenderingContext2D.prototype, "getImageData", {
      "value": function () {
        noisify(this.canvas, this);
        return getImageData.apply(this, arguments);
      }
    });
  } catch (err) {xconsole.log(err)}
  //伪造AudioContext指纹
  try {
    const context = {
      "BUFFER": null,
      "getChannelData": function (e) {
        const getChannelData = e.prototype.getChannelData;
        Object.defineProperty(e.prototype, "getChannelData", {
          "value": function () {
            const results_1 = getChannelData.apply(this, arguments);
            if (context.BUFFER !== results_1) {
              context.BUFFER = results_1;
              for (let i = 0; i < results_1.length; i += 100) {
                let index = Math.floor(window.fakeRandom * i);
                results_1[index] = results_1[index] + window.fakeRandom * 0.0000001;
              }
            }
            return results_1;
          }
        });
      },
      "createAnalyser": function (e) {
        const createAnalyser = e.prototype.__proto__.createAnalyser;
        Object.defineProperty(e.prototype.__proto__, "createAnalyser", {
          "value": function () {
            const results_2 = createAnalyser.apply(this, arguments);
            const getFloatFrequencyData = results_2.__proto__.getFloatFrequencyData;
            Object.defineProperty(results_2.__proto__, "getFloatFrequencyData", {
              "value": function () {
                const results_3 = getFloatFrequencyData.apply(this, arguments);
                for (let i = 0; i < arguments[0].length; i += 100) {
                  let index = Math.floor(window.fakeRandom * i);
                  arguments[0][index] = arguments[0][index] + window.fakeRandom * 0.1;
                }
                return results_3;
              }
            });
            return results_2;
          }
        });
      }
    };

    context.getChannelData(AudioBuffer);
    context.createAnalyser(AudioContext);
    context.getChannelData(OfflineAudioContext);
    context.createAnalyser(OfflineAudioContext);
  } catch (err) {xconsole.log(err)}

  //伪造DOMRect, DOMRectReadOnly
  try {
    function fakeDOMRectReadonly(name) {
      const prop = Object.getOwnPropertyDescriptor(DOMRectReadOnly.prototype, name);
      Object.defineProperty(DOMRectReadOnly.prototype, name, {
        get: function () {
          let val = prop.get.call(this);
          if (val !== 0) {
            val += (window.fakeRandom / 1000);
          }
          return val;
        }
      })
    }

    function fakeDOMRect(name) {
      const prop = Object.getOwnPropertyDescriptor(DOMRect.prototype, name);
      Object.defineProperty(DOMRect.prototype, name, {
        set: function (val) {
          return prop.set.call(this, val);
        },
        get: function () {
          let val = prop.get.call(this);
          if (val !== 0) {
            val += (window.fakeRandom / 1000);
          }
          return val;
        }
      })
    }

    fakeDOMRectReadonly("x");
    fakeDOMRectReadonly("y");
    fakeDOMRectReadonly("width");
    fakeDOMRectReadonly("height");
    fakeDOMRectReadonly("left");
    fakeDOMRectReadonly("right");
    fakeDOMRectReadonly("top");
    fakeDOMRectReadonly("bottom");
    const toJSONProp = Object.getOwnPropertyDescriptor(DOMRectReadOnly.prototype, "toJSON");
    Object.defineProperty(DOMRectReadOnly.prototype, "toJSON", {
      value: function () {
        let json = toJSONProp.value.call(this);
        json.x = this.x;
        json.y = this.y;
        json.width = this.width;
        json.height = this.height;
        json.left = this.left;
        json.right = this.right;
        json.top = this.top;
        json.bottom = this.bottom;
        return json;
      }
    });

    fakeDOMRect("x");
    fakeDOMRect("y");
    fakeDOMRect("width");
    fakeDOMRect("height");
  } catch (err) {xconsole.log(err)}
})();