(function (root, factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD. Register as an anonymous module.
        define(['exports', 'echarts'], factory);
    } else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {
        // CommonJS
        factory(exports, require('echarts'));
    } else {
        // Browser globals
        factory({}, root.echarts);
    }
}(this, function (exports, echarts) {
    var log = function (msg) {
        if (typeof console !== 'undefined') {
            console && console.error && console.error(msg);
        }
    };
    if (!echarts) {
        log('ECharts is not Loaded');
        return;
    }
    echarts.registerTheme('theme', {
      "grid": {
        "containLabel": true
      },
      "color": [
        "#fc97af",
        "#87f7cf",
        "#f7f494",
        "#72ccff",
        "#f7c5a0",
        "#d4a4eb",
        "#d2f5a6",
        "#76f2f2"
      ],
      "backgroundColor": "transparent",
      "textStyle": {
        "fontFamily":"'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', '微软雅黑', Arial, sans-serif"
      },
      "legend": {
        "textStyle": {
          "color": "#c1c1c1"
        }
      },
      "categoryAxis": {
        "axisLine": {
          "show": true,
          "lineStyle": {
            "color": "#18315b"
          }
        },
        "axisTick": {
          "show": false,
          "lineStyle": {
            "color": "#18315b"
          }
        },
        "axisLabel": {
          "show": true,
          "textStyle": {
            "color": "#c1c1c1"
          }
        },
        "splitLine": {
          "show": false
        },
        "splitArea": {
          "show": false
        }
      },
      "valueAxis": {
        "nameTextStyle": {
          "color": "#eee"
        },
        "axisLine": {
          "show": true,
          "lineStyle": {
            "color": "#18315b"
          }
        },
        "axisTick": {
          "show": false,
          "lineStyle": {
            "color": "#18315b"
          }
        },
        "axisLabel": {
          "show": true,
          "textStyle": {
            "color": "#c1c1c1"
          }
        },
        "splitLine": {
          "show": true,
          "lineStyle": {
            "type": "dashed",
            "color": [
              "#11234f"
            ]
          }
        },
        "splitArea": {
          "show": false,
          "areaStyle": {
            "color": [
              "rgba(250,250,250,0.3)",
              "rgba(200,200,200,0.3)"
            ]
          }
        }
      },
      "bar": {
        "barMaxWidth": "30%",
        "itemStyle": {
          "normal": {
            "barBorderWidth": 0,
            "barBorderColor": "#ccc"
          },
          "emphasis": {
            "barBorderWidth": 0,
            "barBorderColor": "#ccc"
          }
        }
      }
    });
}));
