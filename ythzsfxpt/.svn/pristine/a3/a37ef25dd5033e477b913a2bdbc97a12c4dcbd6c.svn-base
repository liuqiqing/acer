//市直占比和区县占比
var szqxzbUrl = ctx + "/libLicenseController/szqxzb";
//证照颁发情况柱形图
var zzbfqkzxt = ctx + "/libLicenseController/zzbfqkzxt";
//证照情况
var bfdwzsUrl = ctx + "/libLicenseController/bfdwzs";
//个人证照总数
var grzzzsUrl = ctx + "/libLicenseController/grzzzs";
//教师资格证
var jszgzUrl  = ctx + "/libLicenseController/jszgz";
//旅行社经营许可
var lxsjyxkUrl = ctx + "/libLicenseController/lxsjyxk";
//事业单位法人证书
var sydwfrzsUrl = ctx + "/libLicenseController/sydwfrzs";
//残疾人证书
var cjrzsUrl = ctx + "/libLicenseController/cjrzs";
//法人证照总数
var frzzslUrl = ctx + "/libLicenseController/frzzsl";
//证照状态总数
var zzlxzsUrl = ctx + "/libLicenseController/zzlxzs";
//数据来源饼图
var zzztPieUrl = ctx + "/libLicenseController/zzztPie";
//建设工程规划许可证
var jsgcghxkzUrl = ctx + "/libLicenseController/jsgcghxkz";
//企业、个人工商营业执照
var qygrgsyyzzUrl = ctx + "/libLicenseController/qygrgsyyzz";
//部门证照数量
var bmzzslUrl = ctx + "/libLicenseController/bmzzsl";
//济南市电子证照总数
var jnsdzzzUrl = ctx + "/libLicenseController/jnsdzzz";
//市区证照情况
var sqzzqkUrl = ctx + "/libLicenseController/sqzzqk";


$(function(){
    //市直占比和区县占比
    $.ajax({
        type : "get",
        async : true,
        url:szqxzbUrl,
        success:function (result) {
            $("#szzb").text(result.szPercent);
            $("#qxzb").text(result.qxPercent);


        }

    });

    //证照颁发情况柱形图
    $.ajax({
        type : "get",
        async : true,
        url:zzbfqkzxt,
        success:function(result){
            var zzbfqkzxt = echarts.init(document.getElementById('zzbfqkzxt'));

            var nameList = [];
            var totalList = [];
            for(var i=0;i<result.length;i++){
                for(var key in result[i]){
                    if(key == 'LICENSE_TYPE_NAME'){
                        nameList.push(result[i][key]);
                    }else if(key == 'SL'){
                        totalList.push(result[i][key]);
                    }
                }
            }
            zzbfqkzxt.setOption({
                color: ['#3dd3ba'],
                grid: {
                    top: 20,
                    right: 0,
                    left: 20,
                    bottom: 0,
                    containLabel: true
                },
                tooltip: {
                    trigger: 'item',
                    position: 'right'
                },
                xAxis: {
                    type: 'category',
                    data: nameList,
                    axisLabel: {
                        interval: 0,
                        rotate: 30,
                        textStyle: {
                            color: '#e5f8ff'
                        },
                        formatter: function (name) {
                            return (name.length > 5 ? (name.slice(0,5)+"...") : name );
                        },
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: {
                        show: false
                    },
                    axisLabel: {
                        textStyle: {
                            color: '#e5f8ff',
                            fontSize: 8,
                        }
                    },
                    splitLine:{
                        lineStyle:{
                            type: 'dashed',
                            color: '#2e3450',
                        }
                    }
                },
                series: [
                    {
                        name: '证照颁发情况',
                        type: 'bar',
                        barWidth: 10,
                        itemStyle: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: '#59e9fe'
                            }, {
                                offset: 1,
                                color: '#0ca2ff'
                            }]),
                            barBorderRadius: 5
                        },
                        data: totalList
                    }
                ]
            });

        },
        error : function(errorMsg) {

        }

    });

    //颁发单位总数
    $.ajax({
        type : "get",
        async : true,
        url:bfdwzsUrl,
        success:function (result) {

            $("#bfdwzs").text(result.bfdwzs);

        },
        error : function(errorMsg) {
        }

    });

    //个人证照总数
    $.ajax({
        type : "get",
        async : true,
        url:grzzzsUrl,
        success:function (result) {
            $("#grzzzs").text(result.grzzzs);
        },
        error : function(errorMsg) {
        }

    });
    //教师资格证
    $.ajax({
        type : "get",
        async : true,
        url:jszgzUrl,
        success:function (result) {
            $("#jszgz").text(result.jszgz);
        },
        error : function(errorMsg) {
        }

    });
    //旅行社经营许可证书
    $.ajax({
        type : "get",
        async : true,
        url:lxsjyxkUrl,
        success:function (result) {
            $("#lxsjyxk").text(result.lxsjyxk);
        },
        error : function(errorMsg) {
        }

    });
    //事业单位法人证书
    $.ajax({
        type : "get",
        async : true,
        url:sydwfrzsUrl,
        success:function (result) {
            $("#sydwfrzs").text(result.sydwfrzs);
        },
        error : function(errorMsg) {
        }

    });
    //残疾人证书
    $.ajax({
        type : "get",
        async : true,
        url:cjrzsUrl,
        success:function (result) {
            $("#cjrzs").text(result.cjrzs);
        },
        error : function(errorMsg) {
        }

    });
    //法人证照总数
    $.ajax({
        type : "get",
        async : true,
        url:frzzslUrl,
        success:function (result) {
            $("#frzzsl").text(result.frzzsl);
        },
        error : function(errorMsg) {
        }

    });
    //证照类型总数
    $.ajax({
        type : "get",
        async : true,
        url:zzlxzsUrl,
        success:function (result) {
            $("#zzlxzs").text(result.zzlxzs);
        },
        error : function(errorMsg) {
        }

    });

    //证照状态饼图
    $.ajax({
        type : "get",
        async : true,
        url:zzztPieUrl,
        success:function(result){
            var zzztPieDiv = echarts.init(document.getElementById('zzztPie'));
            zzztPieDiv.setOption({
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c} ({d}%)"
                },
                legend: {
                    type: 'scroll',
                    orient: 'vertical',
                    textStyle:{
                        fontSize:'16',
                        color:'#FFF'
                    },
                    x: 'left',
                    data:['注销','废止','签章','超期']
                },
                series: [
                    {
                        name:'证照状态',
                        type:'pie',
                        radius: ['40%', '70%'],
                        center:['60%','50%'],
                        avoidLabelOverlap: false,
                        label: {
                            normal: {
                                show: false,
                                position: 'center'
                            },
                            emphasis: {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'bold'
                                }
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            }
                        },
                        data:result
                    }
                ]


            });

        },
        error : function(errorMsg) {

        }

    });


    //建设工程规划许可证情况
    $.ajax({
        type : "get",
        async : true,
        url:jsgcghxkzUrl,
        success:function(result){
            var jsgcghxkzqkDiv = echarts.init(document.getElementById('jsgcghxkzqk'));

            jsgcghxkzqkDiv.setOption({
                grid: {
                    top: 30,
                    left: 0,
                    right: 0,
                    bottom: 0,
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    data: result.xList,
                    axisLabel: {
                        interval:0,
                        rotate:30,
                        textStyle: {
                            color: '#e5f8ff'
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            color: '#42456a'
                        }
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: {
                        show: false
                    },
                    axisLabel: {
                        textStyle: {
                            color: '#e5f8ff'
                        }
                    },
                    splitLine:{
                        lineStyle:{
                            type: 'dashed',
                            color: '#2e3450',
                        }
                    }
                },
                legend: {
                    data: ['建设工程规划许可证情况'],
                    right: 0,
                    itemGap: 10,
                    textStyle: {
                        color: '#e5f8ff'
                    }
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'line'
                    }
                },
                series: [{
                    type: 'line',
                    name: '建设工程规划许可证情况',
                    data: result.yList,
                    color: '#0094fb',
                }]


            });

        },
        error : function(errorMsg) {

        }

    });

    //企业、个人工商营业执照
    $.ajax({
        type : "get",
        async : true,
        url:qygrgsyyzzUrl,
        success:function(result){
            var qygrgsyyzzDiv = echarts.init(document.getElementById('qygrgsyyzz'));
            qygrgsyyzzDiv.setOption({
                grid: {
                    top: 30,
                    left: 0,
                    right: 0,
                    bottom: 0,
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    data: result.xList,
                    axisLabel: {
                        interval:0,
                        rotate:30,
                        textStyle: {
                            color: '#e5f8ff'
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            color: '#42456a'
                        }
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: {
                        show: false
                    },
                    axisLabel: {
                        textStyle: {
                            color: '#e5f8ff'
                        }
                    },
                    splitLine:{
                        lineStyle:{
                            type: 'dashed',
                            color: '#2e3450',
                        }
                    }
                },
                legend: {
                    data: ['济南市营业执照'],
                    right: 0,
                    itemGap: 10,
                    textStyle: {
                        color: '#e5f8ff'
                    }
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'line'
                    }
                },
                series: [{
                    type: 'line',
                    name: '济南市营业执照',
                    data: result.yList,
                    color: '#0094fb',
                }]


            });

        },
        error : function(errorMsg) {

        }

    });


    //部门证照数量
    $.ajax({
        type : "get",
        async : true,
        url:bmzzslUrl,
        success:function(result){
            var bmzzslDiv = echarts.init(document.getElementById('bmzzsl'));
            var nameList = [];
            var slList = [];
            for(var i=0;i<result.length;i++){
                for(var key in result[i]){
                    if(key == 'DEPT_NAME'){
                        nameList.push(result[i][key]);
                    }else if(key == 'SL'){
                        slList.push(result[i][key]);
                    }
                }
            }
            bmzzslDiv.setOption({
                color: ['#3dd3ba'],
                grid: {
                    top: 20,
                    right: 0,
                    left: 20,
                    bottom: 0,
                    containLabel: true
                },
                tooltip: {
                    trigger: 'item',
                    position: 'left'
                },
                xAxis: {
                    type: 'category',
                    data: nameList,
                    axisLabel: {
                        interval: 0,
                        rotate: 30,
                        textStyle: {
                            color: '#e5f8ff'
                        },
                        formatter: function (name) {
                            return (name.length > 5 ? (name.slice(0,5)+"...") : name );
                        },
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: {
                        show: false
                    },
                    axisLabel: {
                        textStyle: {
                            color: '#e5f8ff',
                            fontSize: 8,
                        }
                    },
                    splitLine:{
                        lineStyle:{
                            type: 'dashed',
                            color: '#2e3450',
                        }
                    }
                },
                series: [
                    {
                        name: '部门证照数量',
                        type: 'bar',
                        barWidth: 10,
                        itemStyle: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: '#59e9fe'
                            }, {
                                offset: 1,
                                color: '#0ca2ff'
                            }]),
                            barBorderRadius: 5
                        },
                        data: slList
                    }
                ]
            });

        },
        error : function(errorMsg) {

        }

    });

    //济南市电子证照颁发总数
    $.ajax({
        type : "get",
        async : true,
        url:jnsdzzzUrl,
        success:function(result){
            var dzzzbfzsDiv = echarts.init(document.getElementById('dzzzbfzs-real-time'));
            dzzzbfzsDiv.setOption({
                title: {
                    text: '',
                    left: '15',
                    bottom: 0,
                    textStyle: {
                        color: '#fff',
                        fontSize: 15,
                        fontWeight:'normal'
                    }
                },
                legend: {
                    show: false
                },
                series: [
                    {
                        type: 'pie',
                        center: ['50%', '50%'],
                        radius: ['60%', '100%'],
                        hoverAnimation: false,
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        },
                        data: [
                            {
                                value: result.jnsdzzz,
                                label: {
                                    show: true,
                                    color: '#fff',
                                    position: 'center',
                                    fontSize: 20,
                                    formatter: '{c}'
                                },
                                itemStyle: {
                                    color: {
                                        type: 'linear',
                                        x: 0,
                                        y: 0,
                                        x2: 0,
                                        y2: 1,
                                        colorStops: [
                                            {
                                                offset: 0, color: '#bd1bff'
                                            }, {
                                                offset: 1, color: '#07baff'
                                            }
                                        ]
                                    }
                                }
                            },
                            {
                                value: 54,
                                itemStyle: {
                                    color: '#808183',
                                }
                            }
                        ]
                    }
                ]
            });

        }

    });

    //市区证照情况
    $.ajax({
        type : "get",
        async : true,
        url:sqzzqkUrl,
        success:function(result){
            var dlysjyxkqkDiv = echarts.init(document.getElementById('dlysjyxkqk'));
            var nameList = [];
            var slList = [];
            for(var i=0;i<result.length;i++){
                for(var key in result[i]){
                    if(key == 'DEPT_NAME'){
                        nameList.push(result[i][key]);
                    }else if(key == 'SL'){
                        slList.push(result[i][key]);
                    }
                }
            }
            dlysjyxkqkDiv.setOption({
                color: ['#3dd3ba'],
                grid: {
                    top: 20,
                    right: 0,
                    left: 20,
                    bottom: 0,
                    containLabel: true
                },
                tooltip: {
                    trigger: 'item',
                    position: 'left'
                },
                xAxis: {
                    type: 'category',
                    data: nameList,
                    axisLabel: {
                        interval: 0,
                        rotate: 45,
                        textStyle: {
                            color: '#e5f8ff'
                        },
                        /*formatter: function (name) {
                            return (name.length > 5 ? (name.slice(0,5)+"...") : name );
                        },*/
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: {
                        show: false
                    },
                    axisLabel: {
                        textStyle: {
                            color: '#e5f8ff',
                            fontSize: 8,
                        }
                    },
                    splitLine:{
                        lineStyle:{
                            type: 'dashed',
                            color: '#2e3450',
                        }
                    }
                },
                series: [
                    {
                        name: '道路运输经营许可情况',
                        type: 'bar',
                        barWidth: 10,
                        itemStyle: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: '#59e9fe'
                            }, {
                                offset: 1,
                                color: '#0ca2ff'
                            }]),
                            barBorderRadius: 5
                        },
                        data: slList
                    }
                ]
            });

        },
        error : function(errorMsg) {

        }

    });


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
                color: '#0181af',
                opacity: 0.5,
                borderWidth: 1,
                borderColor: '#0181af'
            },
            label: {
                show: true,
                textStyle: {
                    color: '#fff', //地图初始化区域字体颜色
                    fontSize: 14,
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
                        fontSize: 18,
                        backgroundColor: 'rgba(0,23,11,0)'
                    }
                }
            },
            light: { //光照阴影
                main: {
                    color: '#004469', //光照颜色
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