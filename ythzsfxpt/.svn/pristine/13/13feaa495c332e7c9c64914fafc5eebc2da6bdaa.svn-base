$(function(){
    // 智慧旅游
    // 当鼠标指针在元素内部移动时重复的触发 mosemove;
    function showTip() {
        document.onmousemove=function(even) {
            var scrollTop=document.documentElement.scrollTop||document.body.scrollTop;
            var scrollLeft=document.documentElement.scrollLeft||document.body.scrollLeft;
            var oEvent=even||event;
            $(".pop-container").css("top",scrollTop+oEvent.clientY-30+"px");
            $(".pop-container").css("left",scrollLeft+oEvent.clientX-60+"px");
        };
    }
    $(".bar-percentage").mouseover(function (){
        $(".pop-container").css("display","block");
        showTip();
    }).mouseout(function (){
        $(".pop-container").css("display","none");
    });


    //综合调度指挥中心tab切换
    $("body").on("click",".panel-hori .center-tab>ul>li",function(){
        //顺序div div ul li
        var $this = $(this);
        var $titleDiv = $this.parent().parent();
        var $outerDiv = $titleDiv.parent();

        var $contentDiv = $outerDiv.children("div:last");
        // 当前tab索引
        var index = $this.parent().children("li").index($this);
        // 当前的加上样式，其他的去掉样式
        $this.addClass('center-tab-active').siblings().removeClass('center-tab-active');
        // 找到内容div并显示出来，其他内容div隐藏
        $contentDiv.children("div:eq(" + index +")").show().siblings().hide();

    });

    //综合调度指挥中心map

    var geoJinan = {
        "槐荫区":[116.901607,36.658407],
        "历下区":[117.082705,36.675081],
        "市中区":[116.998768,36.653311],
        "天桥区":[116.999289,36.704903],
        "历城区":[117.201803,36.818529],
        "章丘":[117.546366,36.601673],
        "长清区":[116.675028,36.523101],

    };


    var mapChart = echarts.init(document.getElementById('center-map'), 'theme');
    var myOption = {
        tooltip: {
            show:true,
        },
        geo3D: {
            map: 'jinan',
            name: '济南市',
            roam: true,
            regionHeight: 3,
            itemStyle: {
                color: '#0241ad',
                opacity: 0.5,
                borderWidth: 1,
                borderColor: '#0181af'
            },
            label: {
                show: true,
                textStyle: {
                    color: '#fff', //地图初始化区域字体颜色
                    fontSize: 12,
                    opacity: 1,
                    backgroundColor: 'transparent'
                }
            },
            emphasis: { //当鼠标放上去  地区区域是否显示名称
                itemStyle: {
                    areaColor: '#298bd6'
                },
                label: {
                    show: true,
                    textStyle: {
                        color: '#fff',
                        fontSize: 14,
                        backgroundColor: 'rgba(0,23,11,0)'
                    }
                }
            },
            light: { //光照阴影
                main: {
                    color: '#fff', //光照颜色
                    intensity: 1, //光照强度
                    shadowQuality: 'high', //阴影亮度
                    shadow: false, //是否显示阴影
                    alpha: 55,
                    beta: 10

                },
                ambient: {
                    intensity: 0.3
                }
            },
            viewControl: {			// 用于鼠标的旋转，缩放等视角控制。
                distance: 140,					// [ default: 100 ] 默认视角距离主体的距离，对于 grid3D 和 geo3D 等其它组件来说是距离中心原点的距离,对于 globe 来说是距离地球表面的距离。在 projection 为'perspective'的时候有效。
                alpha: 60, 						// 视角绕 x 轴，即上下旋转的角度。配合 beta 可以控制视角的方向。[ default: 40 ]
                beta: 10,						// 视角绕 y 轴，即左右旋转的角度。[ default: 0 ]

                center: [0,0,0]				// 视角中心点，旋转也会围绕这个中心点旋转，默认为[0,0,0]。
            }
        },
        series: [
            {
                name: 'lines3D',
                type: 'lines3D',
                coordinateSystem: 'geo3D',
                effect: {
                    show: true
                },
                blendMode: 'lighter',
                lineStyle: {
                    width: 2,
                    color: '#06c2f3',
                    opacity: .8
                },
                data: [
                    {
                        coords: [geoJinan['历下区'], geoJinan['市中区']]
                    },
                    {
                        coords: [geoJinan['历下区'], geoJinan['槐荫区']]
                    },
                    {
                        coords: [geoJinan['历下区'], geoJinan['天桥区']]
                    },
                    {
                        coords: [geoJinan['历下区'], geoJinan['章丘']]
                    },
                    {
                        coords: [geoJinan['历下区'], geoJinan['长清区']]
                    }
                ],
                zlevel: 2,
                silent: false
            },
        ]
    };

    mapChart.setOption(myOption);

    //医疗服务
    var servLipChart1 = echarts.init(document.getElementById('service-chart1'), 'theme');
    var servLipOption1 = {
        series: [{
            type: 'liquidFill',
            data: [{
                name: '0.1% ↓',
            },0.01,0.01],
            center: ['50%', '50%'],
            radius: '85%',
            color: [
                new echarts.graphic.LinearGradient(
                    0, 0, 0, 1,
                    [
                        {offset: 0, color: '#4cebf0'},
                        {offset: 1, color: '#4d7ae7'}
                    ]
                ),
                new echarts.graphic.LinearGradient(
                    0, 0, 0, 1,
                    [
                        {offset: 0, color: '#4cebf0'},
                        {offset: 1, color: '#4d7ae7'}
                    ]
                )],
            label: {
                show: true,
                color: '#c0495a',
                fontFamily: 'numThin',
                insideColor: '#fff',
                fontSize: 16
            },
            backgroundStyle: {
                color: 'rgba(10, 47, 115, 0.4)'
            },
            itemStyle: {
                opacity: 1,
                shadowBlur: 50,
                shadowColor: 'rgba(0, 0, 0, 0.4)'
            },
            outline: {
                show: true,
                borderDistance: 3,
                itemStyle: {
                    color: '#114597',
                    borderColor: 'none',
                    borderWidth: 2,
                    shadowBlur: 10,
                    shadowColor: 'rgba(17, 50, 76, 0.85)'
                }
            }
        }]
    };
    servLipChart1.setOption(servLipOption1);

    var servLipChart2 = echarts.init(document.getElementById('service-chart2'), 'theme');
    var servLipOption2 = {
        series: [{
            type: 'liquidFill',
            data: [{
                name: '0.0% ↑',
            },0.05,0.05],
            center: ['50%', '50%'],
            radius: '85%',
            color: [
                new echarts.graphic.LinearGradient(
                    0, 0, 0, 1,
                    [
                        {offset: 0, color: '#4cebf0'},
                        {offset: 1, color: '#4d7ae7'}
                    ]
                ),
                new echarts.graphic.LinearGradient(
                    0, 0, 0, 1,
                    [
                        {offset: 0, color: '#4cebf0'},
                        {offset: 1, color: '#4d7ae7'}
                    ]
                )],
            label: {
                show: true,
                color: '#42ca83',
                fontFamily: 'numThin',
                insideColor: '#fff',
                fontSize: 16
            },
            backgroundStyle: {
                color: 'rgba(10, 47, 115, 0.4)'
            },
            itemStyle: {
                opacity: 1,
                shadowBlur: 50,
                shadowColor: 'rgba(0, 0, 0, 0.4)'
            },
            outline: {
                show: true,
                borderDistance: 3,
                itemStyle: {
                    color: '#114597',
                    borderColor: 'none',
                    borderWidth: 2,
                    shadowBlur: 10,
                    shadowColor: 'rgba(17, 50, 76, 0.85)'
                }
            }
        }]
    };
    servLipChart2.setOption(servLipOption2);

    var servLipChart4 = echarts.init(document.getElementById('service-chart4'), 'theme');
    var servLipOption4 = {
        series: [{
            type: 'liquidFill',
            data: [{
                name: '2.7% ↑'
            },0.02,0.02],
            center: ['50%', '50%'],
            radius: '85%',
            color: [
                new echarts.graphic.LinearGradient(
                    0, 0, 0, 1,
                    [
                        {offset: 0, color: '#4cebf0'},
                        {offset: 1, color: '#4d7ae7'}
                    ]
                ),
                new echarts.graphic.LinearGradient(
                    0, 0, 0, 1,
                    [
                        {offset: 0, color: '#4cebf0'},
                        {offset: 1, color: '#4d7ae7'}
                    ]
                )],
            label: {
                show: true,
                color: '#42ca83',
                fontFamily: 'numThin',
                insideColor: '#fff',
                fontSize: 16
            },
            backgroundStyle: {
                color: 'rgba(10, 47, 115, 0.4)'
            },
            itemStyle: {
                opacity: 1,
                shadowBlur: 50,
                shadowColor: 'rgba(0, 0, 0, 0.4)'
            },
            outline: {
                show: true,
                borderDistance: 3,
                itemStyle: {
                    color: '#114597',
                    borderColor: 'none',
                    borderWidth: 2,
                    shadowBlur: 10,
                    shadowColor: 'rgba(17, 50, 76, 0.85)'
                }
            }
        }]
    };
    servLipChart4.setOption(servLipOption4);

    var servLipChart5 = echarts.init(document.getElementById('service-chart5'), 'theme');
    var servLipOption5 = {
        series: [{
            type: 'liquidFill',
            data: [{
                name: '16.6% ↑',
            },0.16,0.16],
            center: ['50%', '50%'],
            radius: '85%',
            color: [
                new echarts.graphic.LinearGradient(
                    0, 0, 0, 1,
                    [
                        {offset: 0, color: '#4cebf0'},
                        {offset: 1, color: '#4d7ae7'}
                    ]
                ),
                new echarts.graphic.LinearGradient(
                    0, 0, 0, 1,
                    [
                        {offset: 0, color: '#4cebf0'},
                        {offset: 1, color: '#4d7ae7'}
                    ]
                )],
            label: {
                show: true,
                color: '#42ca83',
                fontFamily: 'numThin',
                insideColor: '#fff',
                fontSize: 16
            },
            backgroundStyle: {
                color: 'rgba(10, 47, 115, 0.4)'
            },
            itemStyle: {
                opacity: 1,
                shadowBlur: 50,
                shadowColor: 'rgba(0, 0, 0, 0.4)'
            },
            outline: {
                show: true,
                borderDistance: 3,
                itemStyle: {
                    color: '#114597',
                    borderColor: 'none',
                    borderWidth: 2,
                    shadowBlur: 10,
                    shadowColor: 'rgba(17, 50, 76, 0.85)'
                }
            }
        }]
    };
    servLipChart5.setOption(servLipOption5);


    initNicScroll();
    function initNicScroll(){
        $('.table-content').niceScroll({
            cursoropacitymin: 0,
            cursorcolor:"#0d57ab",
            cursorborder: '#0d57ab'
        });
        $('.table-content').getNiceScroll().resize();
    }
});