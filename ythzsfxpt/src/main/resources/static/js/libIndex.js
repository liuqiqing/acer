$(function () {
  //户籍人口与流动人口
  var card1 = echarts.init(document.getElementById('card-type1'));
  var type1 = {
    grid: {
      top: 10,
      left: 0,
      right: 0,
      bottom: 0,
      containLabel: true
    },
    tooltip: {
      trigger: 'axis',
      formatter: function (param) {
        return param[0].name + ':' + param[0].value;
      }
    },
    xAxis: {
      type: 'value',
      show: false,
      min: 0
    },
    yAxis: {
      type: 'category',
      inverse: true,
      data: ['线下办理事项'],
      axisLine: {
        show: false
      },
      axisLabel: {
        show:false,
        textStyle: {
          fontSize: 16,
          color: '#e5f8ff'
        }
      }
    },
    series: [
      {
        name: '数量',
        type: 'bar',
        z: 2,
        barWidth: 6,
        itemStyle: {
          color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
            offset: 0,
            color: '#3cc5ff'
          }, {
            offset: 1,
            color: '#3cc5ff'
          }]),
          barBorderRadius: 5
        },
        data: [151]
      },
      {
        name: '总量',
        type: 'bar',
        z: 1,
        barWidth: 3,
        barGap:'-70%',
        itemStyle: {
          color: '#4d6071'
        },
        data: [170]
      }
    ]
  };
  card1.setOption(type1);

  var card2 = echarts.init(document.getElementById('card-type2'));
  var type2 = {
    grid: {
      top: 10,
      left: 0,
      right: 0,
      bottom: 0,
      containLabel: true
    },
    tooltip: {
      trigger: 'axis',
      formatter: function (param) {
        return param[0].name + ':' + param[0].value;
      }
    },
    xAxis: {
      type: 'value',
      show: false,
      min: 0
    },
    yAxis: {
      type: 'category',
      inverse: true,
      data: ['线上办理事项'],
      axisLine: {
        show: false
      },
      axisLabel: {
        show:false,
        textStyle: {
          fontSize: 16,
          color: '#e5f8ff'
        }
      }
    },
    series: [
      {
        name: '数量',
        type: 'bar',
        z: 2,
        barWidth: 6,
        itemStyle: {
          color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
            offset: 0,
            color: '#3cc5ff'
          }, {
            offset: 1,
            color: '#3cc5ff'
          }]),
          barBorderRadius: 5
        },
        data: [19]
      },
      {
        name: '总量',
        type: 'bar',
        z: 1,
        barWidth: 3,
        barGap:'-70%',
        itemStyle: {
          color: '#4d6071'
        },
        data: [170]
      }
    ]
  };
  card2.setOption(type2);

  //法人类型
  var menu = echarts.init(document.getElementById('legal-type'));
  var chart = {
    legend: {
      show: false
    },
    series: [
      {
        type: 'pie',
        center: ['55%', '50%'],
        radius: ['55%', '70%'],
        hoverAnimation: true,
        label: {
          show: true,
          position:'outside',
          formatter:'{b} \n{d}%{c}个',
        },
        labelLine: {
          show: true
        },
        data: [
          {
            name:'社会团体法人',
            value: 250,
            itemStyle: {
              color: '#ffbe37'
            }
          },
          {
            name:'企业法人',
            value: 250,
            itemStyle: {
              color: '#21beff'
            }
          },
          {
            name:'事业单位法人  ',
            value: 250,
            itemStyle: {
              color: '#8b80f4'
            }
          },
          {
            name:'行政机关法人',
            value: 250,
            itemStyle: {
              color: '#65f5fe'
            }
          }
        ]
      }
    ]
  };
  menu.setOption(chart);

  //个人证照与企业证照
  var pic1 = echarts.init(document.getElementById('pic-type1'));
  var pic1option = {
    grid: {
      top: 10,
      left: 0,
      right: 0,
      bottom: 0,
      containLabel: true
    },
    tooltip: {
      trigger: 'axis',
      formatter: function (param) {
        return param[0].name + ':' + param[0].value;
      }
    },
    xAxis: {
      type: 'value',
      show: false,
      min: 0
    },
    yAxis: {
      type: 'category',
      inverse: true,
      data: ['线下办理事项'],
      axisLine: {
        show: false
      },
      axisLabel: {
        show:false,
        textStyle: {
          fontSize: 16,
          color: '#e5f8ff'
        }
      }
    },
    series: [
      {
        name: '数量',
        type: 'bar',
        z: 2,
        barWidth: 6,
        itemStyle: {
          color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
            offset: 0,
            color: '#efa541'
          }, {
            offset: 1,
            color: '#f5d452'
          }]),
          barBorderRadius: 5
        },
        data: [19]
      },
      {
        name: '总量',
        type: 'bar',
        z: 1,
        barWidth: 3,
        barGap:'-70%',
        itemStyle: {
          color: '#4d6071'
        },
        data: [170]
      }
    ]
  };
  pic1.setOption(pic1option);

  var pic2 = echarts.init(document.getElementById('pic-type2'));
  var pic2Option = {
    grid: {
      top: 10,
      left: 0,
      right: 0,
      bottom: 0,
      containLabel: true
    },
    tooltip: {
      trigger: 'axis',
      formatter: function (param) {
        return param[0].name + ':' + param[0].value;
      }
    },
    xAxis: {
      type: 'value',
      show: false,
      min: 0
    },
    yAxis: {
      type: 'category',
      inverse: true,
      data: ['线上办理事项'],
      axisLine: {
        show: false
      },
      axisLabel: {
        show:false,
        textStyle: {
          fontSize: 16,
          color: '#e5f8ff'
        }
      }
    },
    series: [
      {
        name: '数量',
        type: 'bar',
        z: 2,
        barWidth: 6,
        itemStyle: {
          color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
            offset: 0,
            color: '#efa541'
          }, {
            offset: 1,
            color: '#f5d452'
          }]),
          barBorderRadius: 5
        },
        data: [151]
      },
      {
        name: '总量',
        type: 'bar',
        z: 1,
        barWidth: 3,
        barGap:'-70%',
        itemStyle: {
          color: '#4d6071'
        },
        data: [170]
      }
    ]
  };
  pic2.setOption(pic2Option);

  //数据目录总数
  var direData = "221";
  var direList = splitWord(direData);
  direList += "<li><span class='text'>个</span></li>";
  $(".data-dire-list .num-list ul").html(direList);

  function splitWord(str){
      var strArr = str.split('');
      var strList = '';

      for(var i = 0; i < strArr.length; i++){
          strList += "<li><span class='num'>" + strArr[i] + "</span></li>";
      }
      return strList;
  }

  //电子证照库上报目录情况
    $('.data-monitor-scroll').vTicker({
        speed: 700,
        pause: 3000,
        showItems: 5,
        animation: 'fade',
        mousePause: true,
        height: 0,
        direction: 'up'
    });

  //数据提供单位数--table内容滚动条
    $('.data-unit-table .data-unit-content .niceScroll').niceScroll({
        cursoropacitymin: 0,
        cursorcolor:"#bfebf2",
        cursorborder: '#bfebf2'
    });

    //数据提供单位数--tab切换
    $('body').on('click','.data-unit-table .data-unit-title span',function () {
        var $this = $(this);
        $this.addClass('active').siblings().removeClass('active');

        var index = $this.parent().children("span").index($this);
        var $outDiv = $this.parent().parent();
        var $tabDiv = $outDiv.children("div:last");
        $tabDiv.children("div:eq(" + index +")").show().siblings().hide();
        $('.data-unit-table .data-unit-content .niceScroll').getNiceScroll().resize();
    })
});
