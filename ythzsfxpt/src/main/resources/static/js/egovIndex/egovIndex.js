/* 事项总览 */
var sxzlUrl = ctx + "/egovIndexController/sxzl";
/* 可网上办理事项 */
var xsblsxUrl = ctx + "/egovIndexController/xsblsx";
/* 不可网上办理事项 */
var xxblsxUrl = ctx + "/egovIndexController/xxblsx";
//var xsxxblsxUrl = ctx + "/egovIndexController/xsxxblsx";
/* 事项级别 */
var xsjbUrl = ctx + "/egovIndexController/sxjbjn";
/* 事项性质 */
var sxxzUrl = ctx + "/egovIndexController/sxxz";
/* 事项性质 当日线上受理业务数量 */
var sxxzdrxsslywslUrl = ctx + "/egovIndexController/sxxzdrxsslbjywsl";
/* 事项性质 当日线下受理业务数量 */
var sxxzdrxxslywslUrl = ctx + "/egovIndexController/sxxzdrxxslbjywsl";
/* 事项性质 当月线上受理业务数量 */
var sxxzdyxsslywslUrl = ctx + "/egovIndexController/sxxzdyxsslbjywsl";
/* 事项性质 当月线下受理业务数量 */
var sxxzdyxxslywslUrl = ctx + "/egovIndexController/sxxzdyxxslbjywsl";
/* 事项性质 当年线上受理业务数量 */
var sxxzdnxsslywslUrl = ctx + "/egovIndexController/sxxzdnxsslbjywsl";
/* 事项性质 当年线下受理业务数量 */
var sxxzdnxxslywslUrl = ctx + "/egovIndexController/sxxzdnxxslbjywsl";
/* 事项性质 线上受理业务总数 */
var sxxzxsslywzslUrl = ctx + "/egovIndexController/sxxzxsslbjywzsl";
/* 事项性质 线下受理业务总数 */
var sxxzxxslywzslUrl = ctx + "/egovIndexController/sxxzxxslbjywzsl";
/* 事项性质内页 底部办件量数据表格 */
var bjlTableUrl = ctx  + "/egovIndexController/bjlTableData";

/* 业务办理变化趋势 更多页面 start */
//部门列表
var orgListUrl = ctx + "/egovIndexController/org_list";
//线上
var onlineUrlDay = ctx + "/egovIndexController/day_online";
var onlineUrlMonth = ctx + "/egovIndexController/month_online";
var onlineUrlYear = ctx + "/egovIndexController/year_online";
//线下
var offlineUrlDay = ctx + "/egovIndexController/day_offline";
var offlineUrlMonth = ctx + "/egovIndexController/month_offline";
var offlineUrlYear = ctx + "/egovIndexController/year_offline";
/* 业务办理变化趋势 更多页面 end */


var bmslpmUrl = ctx + "/egovIndexController/bmslpm";
var bmbjpmUrl = ctx + "/egovIndexController/bmbjpm";
var sxslqsmUrl = ctx + "/egovIndexController/sxslqsm";
var sxbjqsmUrl = ctx + "/egovIndexController/sxbjqsm";
var xsdrblcsUrl = ctx + "/egovIndexController/xsdrblcs";
var xsdyblcsUrl = ctx + "/egovIndexController/xsdyblcs";
var xsdnblcsUrl = ctx + "/egovIndexController/xsdnblcs";
var xxdrblcsUrl = ctx + "/egovIndexController/xxdrblcs";
var xxdyblcsUrl = ctx + "/egovIndexController/xxdyblcs";
var xxdnblcsUrl = ctx + "/egovIndexController/xxdnblcs";
var bmyjhongpaiUrl = ctx + "/egovIndexController/bmyjhongpai";
var bmyjhuangpaiUrl = ctx + "/egovIndexController/bmyjhuangpai";
var szbmsxgszztUrl = ctx + "/egovIndexController/szbmsxgszzt";
var szbmsxgszztxqbgUrl = ctx + "/egovIndexController/szbmsxgszztxqbg";
var qxbmsxgszztxqbgUrl = ctx + "/egovIndexController/qxbmsxgszztxqbg";
var szbmsxgsbztUrl = ctx + "/egovIndexController/szbmsxgsbzt";
var qxbmsxgszztUrl = ctx + "/egovIndexController/qxbmsxgszzt";
var qxbmsxgsbztUrl = ctx + "/egovIndexController/qxbmsxgsbzt";

//顶部echarts和底部数据表格之间的四个值
var zlxsxxswlUrl = ctx + "/egovIndexController/zlxsxxswl";
//事项受理本日	author zxp
var sxslbrUrl = ctx + "/egovIndexController/sxslbr";
//事项办结本日	author zxp
var sxbjbrUrl = ctx + "/egovIndexController/sxbjbr";
//事项受理本月	author zxp
var sxslbyUrl = ctx + "/egovIndexController/sxslby";
//事项办结本月	author zxp
var sxbjbyUrl = ctx + "/egovIndexController/sxbjby";
//事项受理本年	author zxp
var sxslbnUrl = ctx + "/egovIndexController/sxslbn";
//事项办结本年	author zxp
var sxbjbnUrl = ctx + "/egovIndexController/sxbjbn";
//事项受理全部	author zxp
var sxslqbUrl = ctx + "/egovIndexController/sxslqb";
//事项办结全部	author zxp
var sxbjqbUrl = ctx + "/egovIndexController/sxbjqb";
//事项部门受理办结数据表格	author zxp	修改
var sxbmslbjTableDataUrl = ctx + '/egovIndexController/sxbmslbjTableData';
//事项统计详细数据表格	author zxp
var sxtjxxTableUrl = ctx + '/egovIndexController/sxtjxxTableData';
//事项统计详细三级页面	author zxp
var toThirdPageUrl = ctx + '/egovIndexController/toThirdPage';
//部门受理今日	author zxp
var bmsljrUrl = ctx + '/egovIndexController/bmsljr';
//部门办结今日	author zxp
var bmbjjrUrl = ctx + '/egovIndexController/bmbjjr';
//部门受理本月	author zxp
var bmslbyUrl = ctx + '/egovIndexController/bmslby';
//部门办结本月	author zxp
var bmbjbyUrl = ctx + '/egovIndexController/bmbjby';
//部门受理本年	author zxp
var bmslbnUrl = ctx + '/egovIndexController/bmslbn';
//部门办结本年	author zxp
var bmbjbnUrl = ctx + '/egovIndexController/bmbjbn';
//部门受理全部	author zxp
var bmslqbUrl = ctx + '/egovIndexController/bmslqb';
//部门办结全部	author zxp
var bmbjqbUrl = ctx + '/egovIndexController/bmbjqb';



var direData = '0';
//线上线下事项
var card1 = echarts.init(document.getElementById('card-type1'));
var card2 = echarts.init(document.getElementById('card-type2'));
//var card3 = echarts.init(document.getElementById('card-type3'));
//事项级别
var menu = echarts.init(document.getElementById('pieChart'));
//事项性质
var shareRankingChart = echarts.init(document.getElementById('prop-chart'));
//部门受理办结排名
var rankingChart = echarts.init(document.getElementById('depart-ranking-chart'));
//事项前十名
var topTen = echarts.init(document.getElementById('top-ten'));
//事项办结前十名
//var handleTopChart = echarts.init(document.getElementById('handle-top-ten'));
//业务办理变化趋势线上
var xsChart = echarts.init(document.getElementById('pro1'));
//业务办理变化趋势线下
var xxChart = echarts.init(document.getElementById('pro2'));
//事项性质接口
var sxxzTableDateUrl = ctx + "/egovIndexController/sxxzTableDate";

var sxxzChartUrl = ctx + "/egovIndexController/sxxzChart";

/* 事项总览 */
jQuery.sxzl = function(){
	$.ajax({
		type : "get",
	    async : true,   
		url:sxzlUrl,
		success:function(result){
			direData = result.sxzl;
			var strArr = direData.toString().split('');
		    var strList = '';
		    for(var i = 0; i < strArr.length; i++){
		        strList += "<li><span class='num'>" + strArr[i] + "</span></li>";
		    }
		    strList += "<li><span class='text'>个</span></li>";
		    $(".item-list .num-list ul").html(strList);
		},
		error : function(errorMsg) {

	    }
	});
}

/* 可网上办理事项 */
jQuery.xsblsx = function(){
	$.ajax({
		type : "get",
	    async : true,   
		url:xsblsxUrl,
		success:function(result){
			var zl = result.sxzl;
			var sl = result.xsblsx;
			//$("#tdxssl").html(sl);
			var bl = (sl/zl)*100;
			$("#xsblsl").html(bl.toFixed(2) + "%");
			card1.setOption({
				grid: {
				    top: 10,
				    left: 0,
					width:'auto',
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
				          color: '#efa542'
				        }, {
				          offset: 1,
				          color: '#f6d553'
				        }]),
				        barBorderRadius: 5
				      },
				      data: [sl]
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
				      data: [zl]
				    }
				  ]
			});		
		},
		error : function(errorMsg) {
	       //alert("今日办结受理数量调用失败！");
	    }
	});
}

/* 不可网上办理事项 */
jQuery.xxblsx = function(){
	$.ajax({
		type : "get",
	    async : true,   
		url:xxblsxUrl,
		success:function(result){
			//事项总量
			var zl = result.sxzl;
			//线下办理事项
			var sl = result.xxblsx;
			//$("#tdxxsl").html(sl);
			//计算上网率
			var swl = (parseInt($("#tdxssl").html())/parseInt(zl) * 100);
			//$("#tdswl").html(swl.toFixed(2) + "%");
			//线下办理数量
			var bl = (sl/zl)*100;
			$("#xxblsl").html(bl.toFixed(2) + "%");
			card2.setOption({
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
			            color: '#efa542'
			          }, {
			            offset: 1,
			            color: '#f6d553'
			          }]),
			          barBorderRadius: 5
			        },
			        data: [sl]
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
			        data: [zl]
			      }
			    ]
			});
		},
		error : function(errorMsg) {
	       //alert("今日办结受理数量调用失败！");
	    }
	});
}

/* 事项总览弹出层 市直部门事项柱状图 */
jQuery.szbmsxgszzt = function(sxlx,startTime,endTime){
    $.ajax({
        type : "get",
        async : true,
        data:{'sxlx':sxlx,'startTime':startTime,'endTime':endTime},
        url:szbmsxgszztUrl,
        success:function(result){
            var szbmsxgszzt = echarts.init(document.getElementById('szbmsxgs'));
            var bmmc = [];
            var sxsl = [];
            var sl = 0;

            if (result.length >= 10){
                for(var i=0;i<10;i++){
                    bmmc.push(result[i].ORG_NAME);
                    sxsl.push(result[i].SL);
                }
            } else {
                for(var i=0;i<result.length;i++){
                    bmmc.push(result[i].ORG_NAME);
                    sxsl.push(result[i].SL);
                }
            }

            for(var i=0;i<result.length;i++){
                sl +=result[i].SL;
            }
            $("#szbmsxgsdiv").html("市直部门事项个数：" + sl);
            szbmsxgszzt.setOption({
                color: ['#3dd3ba'],
                grid: {
                    top: 20,
                    right: 0,
                    left: 20,
                    bottom: 0,
                    containLabel: true
                },
                tooltip: {
                    trigger: 'item', position: 'right'
                },
                xAxis: {
                    type: 'category',
                    data: bmmc,
                    axisLabel: {
                        interval: 0,
                        rotate: 55,
                        formatter:function(value)
                        {
                            return value.substring(0,5);
                        },
                        textStyle: {
                            color: '#e5f8ff'
                        }
                    }
                },
                yAxis: {
                    type: 'value',
                    splitNumber:2,
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
                series: [
                    {
                        name: '事项个数',
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
                        data: sxsl
                    }
                ]
            });
        }
    });
}

/* 事项总览弹出层 区县部门事项个数柱状图 */
jQuery.qxbmsxgszzt = function(sxlx,startTime,endTime){
    var bmmc = [];
    var sxsl = [];
    var sl = 0;
    $.ajax({
        type : "get",
        async : true,
        data:{'sxlx':sxlx,'startTime':startTime,'endTime':endTime},
        url:qxbmsxgszztUrl,
        success:function(result){
            var qxbmsxgszzt = echarts.init(document.getElementById('qxbmsxgs'));
            for(var i=0;i<result.length;i++){
                var bm = result[i].REGION_NAME;
                bmmc.push(bm);
                /*switch (bmcode){
                    case "370181000000":
                        bmmc.push("章丘区");
                        break;
                    case "370126000000":
                        bmmc.push("商河县");
                        break;
                    case "370105000000":
                        bmmc.push("天桥区");
                        break;
                    case "370112000000":
                        bmmc.push("历城区");
                        break;
                    case "370103000000":
                        bmmc.push("市中区");
                        break;
                    case "370125000000":
                        bmmc.push("济阳区");
                        break;
                    case "370124000000":
                        bmmc.push("平阴县");
                        break;
                    case "370113000000":
                        bmmc.push("长清区");
                        break;
                    case "370104000000":
                        bmmc.push("槐荫区");
                        break;
                    case "370102000000":
                        bmmc.push("历下区");
                        break;
                    case "370190000000":
                        bmmc.push("高新区");
                        break;
                    default:
                        break;

                }*/
                sxsl.push(result[i].SL);
            }
            for(var i=0;i<result.length;i++){
                sl+=result[i].SL;
            }
            $("#qxbmsxgsdiv").html("区县级事项个数：" + sl);
            qxbmsxgszzt.setOption({
                color: ['#3dd3ba'],
                grid: {
                    top: 20,
                    right: 0,
                    left: 20,
                    bottom: 0,
                    containLabel: true
                },
                tooltip: {
                    trigger: 'axis'
                },
                xAxis: {
                    type: 'category',
                    data: bmmc,
                    axisLabel: {
                        interval: 0,
                        rotate: 55,
                        formatter:function(value)
                        {
                            return value.substring(0,5);
                        },
                        textStyle: {
                            color: '#e5f8ff'
                        }
                    }
                },
                yAxis: {
                    type: 'value',
                    splitNumber:2,
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
                series: [
                    {
                        name: '事项个数',
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
                        data: sxsl
                    }
                ]
            });
        }
    });
}

/* 事项总览弹出层 市直部门事项个数饼状图 */
jQuery.szbmsxgsbzt = function(sxlx,startTime,endTime){
    var szbmsxgsbzt = echarts.init(document.getElementById('szbmwbsd'));
    var xssl = 0;
    var xxsl = 0;
    var xsxxsl = 0;
    $.ajax({
        type : "get",
        data:{'sxlx':sxlx,'startTime':startTime,'endTime':endTime},
        async : true,
        url:szbmsxgsbztUrl,
        success:function(result){
            for(key in result){
                if(key == 'xssl'){
                    xssl = result[key];
                }else if(key == 'xxsl'){
                    xxsl = result[key];
                }
            }
            szbmsxgsbzt.setOption({
                grid: {
                    left: '0%',
                    top: '10%',
                    containLabel: true
                },
                tooltip : {
                    show: true,
                },
                legend: {
                    show: true,
                    orient: 'vertical',
                    show: true,
                    right: '30',
                    top: '20',
                    bottom: '20',
                    textStyle: {
                        color:'#ffffff',
                        fontSize: 12
                    },
                },
                series: [
                    {
                        type: 'pie',
                        center: ['25%', '50%'],
                        radius: ['68%', '83%'],
                        hoverAnimation: true,
                        label: {
                            show: false,
                            position:'outside',
                            formatter:'{b} \n{d}%\n{c}个',
                        },
                        labelLine: {
                            show: false
                        },
                        data: [
                            {
                                name:'可网上办理',
                                value: xssl,
                                itemStyle: {
                                    color: '#ffbe37'
                                },
                                url: ctx + '/egovIndexController/'
                            },
                            {
                                name:'不可网上办理',
                                value: xxsl,
                                itemStyle: {
                                    color: '#21beff'
                                }
                            }

                        ]
                    }
                ]
            });
        }
    });

    //饼状图的点击事件
    szbmsxgsbzt.on('click', function (params) {
        var value = params.name;

        if(value == '可网上办理'){
            jQuery.szbmsxgsbztxqbg(1);
            clickFlag = true;
            $("#downloadValue").val("szbmsxgsbzt-xssx");
        }else if(value == '不可网上办理'){
            jQuery.szbmsxgsbztxqbg(2);
            clickFlag = true;
            $("#downloadValue").val("szbmsxgsbzt-xxsx");
        }
    });

}

/* 事项总览弹出层 区县部门事项个数饼状图 */
jQuery.qxbmsxgsbzt = function(sxlx,startTime,endTime){
    var qxbmsxgsbzt = echarts.init(document.getElementById('qxbmwbsd'));
    var xssl = 0;
    var xxsl = 0;
    $.ajax({
        type : "get",
        async : true,
        data:{'sxlx':sxlx,'startTime':startTime,'endTime':endTime},
        url:qxbmsxgsbztUrl,
        success:function(result){

            for(key in result){
                if(key == 'xssl'){
                    xssl = result[key];
                }else if(key == 'xxsl'){
                    xxsl = result[key];
                }
            }
            qxbmsxgsbzt.setOption({
                grid: {
                    left: '0%',
                    top: '10%',
                    containLabel: true
                },
                tooltip : {
                    show: true,
                },
                legend: {
                    show: true,
                    orient: 'vertical',
                    show: true,
                    right: '30',
                    top: '20',
                    bottom: '20',
                    textStyle: {
                        color:'#ffffff',
                        fontSize: 12
                    },
                },
                series: [
                    {
                        type: 'pie',
                        center: ['25%', '50%'],
                        radius: ['68%', '83%'],
                        hoverAnimation: true,
                        label: {
                            show: false,
                            position:'outside',
                            formatter:'{b} \n{d}%\n{c}个',
                        },
                        labelLine: {
                            show: false
                        },
                        data: [
                            {
                                name:'可网上办理',
                                value: xssl,
                                itemStyle: {
                                    color: '#ffbe37'
                                }
                            },
                            {
                                name:'不可网上办理',
                                value: xxsl,
                                itemStyle: {
                                    color: '#21beff'
                                }
                            }
                        ]
                    }
                ]
            });
        }
    });

    //饼状图点击事件
    qxbmsxgsbzt.on('click', function (params) {
        var value = params.name;
        if(value == '可网上办理'){
            jQuery.qxbmsxgsbztxqbg(1);
            clickFlag = true;
            $("#downloadValue").val("qxbmsxgsbzt-xssx");
        }else if(value == '不可网上办理'){
            jQuery.qxbmsxgsbztxqbg(2);
            clickFlag = true;
            $("#downloadValue").val("qxbmsxgsbzt-xxsx");
        }
    });

}

/* 事项总览弹出层 事项性质柱状图 */
jQuery.sxxzChart = function(sxlx,startTime,endTime){
    var sxxzChart = echarts.init(document.getElementById('sxxz-chart'));
    $.ajax({
        type : "get",
        async : true,
        data:{'sxlx':sxlx,'startTime':startTime,'endTime':endTime},
        url:sxxzChartUrl,
        success:function(result){
            var sxxzlb = [];
            var sxxzsl = [];
            for(var i=0;i<result.length;i++){
                for(var key in result[i]){
                    if(key == 'TYPE'){
                        switch(result[i][key])
                        {
                            case 'JL':
                                sxxzlb.push('行政奖励');
                                break;
                            case 'ZS':
                                sxxzlb.push('行政征收');
                                break;
                            case 'QT':
                                sxxzlb.push('其它权力');
                                break;
                            case 'CJ':
                                sxxzlb.push('行政裁决');
                                break;
                            case 'GG':
                                sxxzlb.push('公共服务');
                                break;
                            case 'JF':
                                sxxzlb.push('行政给付');
                                break;
                            case 'JD':
                                sxxzlb.push('行政监督');
                                break;
                            case 'XK':
                                sxxzlb.push('行政许可');
                                break;
                            case 'QR':
                                sxxzlb.push('行政确认');
                                break;
                            case 'CF':
                                sxxzlb.push('行政处罚');
                                break;
                            case 'ZJJG':
                                sxxzlb.push('中介机构');
                                break;
                            case 'SX':
                                sxxzlb.push('服务事项');
                                break;
                            case 'QZ':
                                sxxzlb.push('行政强制');
                                break;
                            default:
                        }
                    }else if(key == 'SXSL'){
                        sxxzsl.push(result[i][key]);
                    }
                }
            }
            sxxzChart.setOption({
                color: ['#3dd3ba'],
                grid: {
                    top: 20,
                    right: 0,
                    left: 20,
                    bottom: 0,
                    containLabel: true
                },
                tooltip: {
                    trigger: 'axis'
                },
                xAxis: {
                    type: 'category',
                    data: sxxzlb,
                    axisLabel: {
                        interval: 0,
                        rotate: 0,
                        textStyle: {
                            color: '#e5f8ff'
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
                series: [
                    {
                        name: '事项性质',
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
                        data:sxxzsl
                    }
                ]
            });

        }
    });

}

/* 事项总览弹出层，点击echarts图形显示数据表格 */
//定义一个点击开关，当柱形图被点击的时候，开关打开（true），默认关闭（false）
var clickFlag = false;
//事项总览弹出框四个图型初始化
//事项总览弹出层，市直部门和区县部门柱形图的点击事件。
$(".chart").click(function(){
    var id = $(this).prop("id");
    if(id == 'szbmsxgs'){
        //如果点击“市直部门事项个数”
        clickFlag = true;
        $("#downloadValue").val("szbmsxgs");
        //获取更多页面顶部4个按钮中，选中的那一个
        var id;
        $(".mask-panel .box .panel-header a").each(function (index,item) {
            if($(this).hasClass('sxzlactive')){
                id = $(this).attr('id');
            }
        });

        //获取时间
        var startTime = $("#start-time").val();
        var endTime = $("#end-time").val();

        jQuery.szbmsxgszztxqbg(id,startTime,endTime);
    }else if(id == 'qxbmsxgs'){
        //如果点击“区县部门事项个数”
        clickFlag = true;
        $("#downloadValue").val("qxbmsxgs");
        var id;
        $(".mask-panel .box .panel-header a").each(function (index,item) {
            if($(this).hasClass('sxzlactive')){
                id = $(this).attr('id');
            }
        });
        //获取时间
        var startTime = $("#start-time").val();
        var endTime = $("#end-time").val();

        jQuery.qxbmsxgszztxqbg(id,startTime,endTime);

    }else if (id == 'sxxz-chart'){

        //如果点击“事项性质柱状图”
        clickFlag = true;
        $("#downloadValue").val("sxxz-chart");
        var id;
        $(".mask-panel .box .panel-header a").each(function (index,item) {
            if($(this).hasClass('sxzlactive')){
                id = $(this).attr('id');
            }
        });
        //获取时间
        var startTime = $("#start-time").val();
        var endTime = $("#end-time").val();
        //事项性质chart详情表格
        jQuery.sxxzchartxqbg(id,startTime,endTime);

    }
    initNicScroll();
});

//事项总览弹出层下载按钮点击事件
$("#egovIndexSXZLDownload").on('click',function(){
    //判断是否生成数据表格，即判断点击开关的状态
    if(clickFlag){//如果为true,可以下载
        //获取事项类型
        var sxType;
        $(".mask-panel .box .panel-header a").each(function (index,item) {
            if($(this).hasClass('sxzlactive')){
                sxType = $(this).attr('id');
            }
        });
        //获取时间
        var startTime = $("#start-time").val();
        var endTime = $("#end-time").val();
        //判断数据表格的数据由哪个echarts触发生成
        var downloadValue = $("#downloadValue").val();
        //请求后台，进行下载数据表格
        window.location.href = ctx + "/egovIndexController/sxzlDownload?sxType="+sxType+"&downloadValue="+downloadValue+"&startTime="+startTime+"&endTime="+endTime;

    }else {
        //为false，禁止下载
        layer.msg("当前没有表格可下载");
    }
});

//市直部门事项个数柱状图详情表格
jQuery.szbmsxgszztxqbg = function(sxlx,startTime,endTime){
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#dataGrid'
            ,url:ctx + "/egovIndexController/szbmsxgszztxqbg?sxlx="+sxlx+"&startTime="+startTime+"&endTime="+endTime
            ,cols: [[
                {field:'ORDER_NUM', width:140, title: '序号', sort: true}
                ,{field:'REGION_NAME', width:150, title: '地区名称'}
                ,{field:'ORG_NAME', width:850, title: '单位名称'}
                ,{field:'SL', width:150, title: '数量', sort: true,event:'BMSL'}
            ]]
            ,page: true
            ,limit:5
            ,limits:[5]

        });

    });

}


//区县部门事项个数柱状图详情表格
jQuery.qxbmsxgszztxqbg = function(sxlx,startTime,endTime){
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem : '#dataGrid'
            ,url : ctx + "/egovIndexController/qxbmsxgszztxqbg?sxlx="+sxlx+"&startTime="+startTime+"&endTime="+endTime
            ,cols: [[
                {field:'ROWNUM', width:140, title: '序号', sort: true}
                ,{field:'REGION_NAME', width:150, title: '地区名称'}
                ,{field:'ORG_NAME', width:850, title: '单位名称'}
                ,{field:'SL', width:150, title: '数量', sort: true}

            ]]
            ,page: true
            ,limit:5
            ,limits:[5]


        });
    });
}

//事项性质详情表格
jQuery.sxxzchartxqbg = function(sxlx,startTime,endTime){
    layui.use('table',function () {
        var table = layui.table;
        table.render({
            elem : '#dataGrid'
            ,url : ctx + "/egovIndexController/sxxzchartxqbg?sxlx="+sxlx+"&startTime="+startTime+"&endTime="+endTime
            ,cols: [[
                {field:'ORDER_NUM', width:80, title: '序号'}
                ,{field:'REGION_NAME', width:100, title: '地区名称'}
                ,{field:'ORG_NAME', width:200, title: '单位名称'}
                ,{field:'MAIN_ITEM_NAME', width:250, title: '主项名称'}
                ,{field:'ITEM_NAME', width:250, title: '事项名称'}
                ,{field:'ITEM_TYPE', width:250, title: '事项性质',
                    templet: function(res){
                        if(res.ITEM_TYPE=="XK"){
                            return "行政许可";
                        }else if(res.ITEM_TYPE=="ZS"){
                            return "行政征收";
                        }else if(res.ITEM_TYPE=="QR"){
                            return "行政确认";
                        }else if(res.ITEM_TYPE=="JF"){
                            return "行政给付";
                        }else if(res.ITEM_TYPE=="JL"){
                            return "行政奖励";
                        }else if(res.ITEM_TYPE=="CJ"){
                            return "行政裁决";
                        }else if(res.ITEM_TYPE=="QT"){
                            return "其它权力";
                        }else if(res.ITEM_TYPE=="GG"){
                            return "公共服务";
                        }else if(res.ITEM_TYPE=="JD"){
                            return "行政监督";
                        }else if(res.ITEM_TYPE=="QZ"){
                            return "行政强制";
                        }else if(res.ITEM_TYPE=="CF"){
                            return "行政处罚";
                        }else if(res.ITEM_TYPE=="ZJJG"){
                            return "中介机构";
                        }else if(res.ITEM_TYPE=="SX"){
                            return "服务事项";
                        }else {
                            return "";
                        }

                    }
                }
                ,{field:'CONDUCT_DEPTH', width:120, title: '网办深度',
                    templet: function(res){
                        if(res.CONDUCT_DEPTH=="1"){
                            return "全程网办";
                        }else if(res.CONDUCT_DEPTH == "2"){
                            return "在线预审";
                        }else if(res.CONDUCT_DEPTH == "3"){
                            return "事项公开";
                        }else if(res.CONDUCT_DEPTH == "4"){
                            return "在线申办";
                        }else {
                            return "";
                        }

                    }
                }
                ,{field:'SUB_TYPE', width:120, title: '是否依申请',
                    templet: function(res){
                        if(res.SUB_TYPE=="2"){
                            return "否";
                        }else {
                            return "是";
                        }

                    }
                }

            ]]
            ,page: true
            ,limit:5
            ,limits:[5]

        });


    });


}

//市直部门饼状图详情表格
jQuery.szbmsxgsbztxqbg = function(param){
    var sxlx;
    $(".mask-panel .box .panel-header a").each(function (index,item) {
        if($(this).hasClass('sxzlactive')){
            sxlx = $(this).attr('id');
        }
    });

    //获取时间
    var startTime = $("#start-time").val();
    var endTime = $("#end-time").val();

    var szbmsxgsbztxqbgurl = ctx + "/egovIndexController/szbmsxgsbztxqbg?sxlx="+sxlx+"&param="+param+"&startTime="+startTime+"&endTime="+endTime;

    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#dataGrid'
            ,url:szbmsxgsbztxqbgurl
            ,cols: [[
                {field:'ORDER_NUM', width:140, title: '序号', sort: true}
                ,{field:'REGION_NAME', width:150, title: '地区名称'}
                ,{field:'ORG_NAME', width:850, title: '单位名称'}
                ,{field:'SL', width:150, title: '数量', sort: true}

            ]]
            ,page: true,limit:5,limits:[5]

        });
    });
}


//区县部门饼状图详情表格
jQuery.qxbmsxgsbztxqbg = function(param){
    var sxlx;
    $(".mask-panel .box .panel-header a").each(function (index,item) {
        if($(this).hasClass('sxzlactive')){
            sxlx = $(this).attr('id');
        }
    });
    //获取时间
    var startTime = $("#start-time").val();
    var endTime = $("#end-time").val();
    var qxbmsxgsbztxqbgurl = ctx + "/egovIndexController/qxbmsxgsbztxqbg?sxlx="+sxlx+"&param="+param+"&startTime="+startTime+"&endTime="+endTime;

    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#dataGrid'
            ,url:qxbmsxgsbztxqbgurl
            ,cols: [[
                {field:'ORDER_NUM', width:140, title: '序号', sort: true}
                ,{field:'REGION_NAME', width:150, title: '地区名称'}
                ,{field:'ORG_NAME', width:850, title: '单位名称'}
                ,{field:'SL', width:150, title: '数量', sort: true}

            ]]
            ,page: true,limit:5,limits:[5]

        });
    });
}

/* 事项总览弹出层（全部事项-政务服务事项-依申请事项-试点事项）点击切换 */
$("body").on("click",".mask-panel .box .panel-header a",function(){
    //点击的元素添加sxzlactive属性，它的同胞元素移除sxzlactive属性
    $(this).addClass('sxzlactive').siblings().removeClass('sxzlactive');
    var id = $(this).attr("id");
    if(id == 'qbsx'){
        jQuery.szbmsxgszzt('qbsx','','');
        jQuery.qxbmsxgszzt('qbsx','','');
        jQuery.szbmsxgsbzt('qbsx','','');
        jQuery.qxbmsxgsbzt('qbsx','','');
        jQuery.sxxzChart('qbsx','','');
    }else if(id == 'zwfwsx'){
        jQuery.szbmsxgszzt('zwfwsx','','');
        jQuery.qxbmsxgszzt('zwfwsx','','');
        jQuery.szbmsxgsbzt('zwfwsx','','');
        jQuery.qxbmsxgsbzt('zwfwsx','','');
        jQuery.sxxzChart('zwfwsx','','');
    }else if(id == 'ysqsx'){
        jQuery.szbmsxgszzt('ysqsx','','');
        jQuery.qxbmsxgszzt('ysqsx','','');
        jQuery.szbmsxgsbzt('ysqsx','','');
        jQuery.qxbmsxgsbzt('ysqsx','','');
        jQuery.sxxzChart('ysqsx','','');
    }else if(id == 'sdsx'){
        jQuery.szbmsxgszzt('sdsx','','');
        jQuery.qxbmsxgszzt('sdsx','','');
        jQuery.szbmsxgsbzt('sdsx','','');
        jQuery.qxbmsxgsbzt('sdsx','','');
        jQuery.sxxzChart('sdsx','','');
    }
});

/* 开始日期和结束日期 */
layui.use('laydate', function(){

    var laydate = layui.laydate;

    var endDate = laydate.render({
        elem: '#end-time',//选择器结束时间
        type: 'date',
        min:"1970-1-1",//设置min默认最小值
        done: function(value,date){
            startDate.config.max={
                year:date.year,
                month:date.month-1,//关键
                date: date.date,
            }
        }

    });

    var startDate=laydate.render({
        elem: '#start-time',
        type: 'date',
        max:"2099-12-31",//设置一个默认最大值
        done: function(value, date){
            endDate.config.min ={
                year:date.year,
                month:date.month-1, //关键
                date: date.date,
            };
        }
    });

});

//zxp today
$("#searchCreateTime").click(function () {
    //获取时间
    var startTime = $("#start-time").val();
    var endTime = $("#end-time").val();

    //获取选中的点击按钮
    var id;
    $(".sxlx").each(function (index,element) {
        if($(this).hasClass('sxzlactive')){
            id = $(this).attr("id");
        }
    });

    if(id == 'qbsx'){
        jQuery.szbmsxgszzt('qbsx',startTime,endTime);
        jQuery.qxbmsxgszzt('qbsx',startTime,endTime);
        jQuery.szbmsxgsbzt('qbsx',startTime,endTime);
        jQuery.qxbmsxgsbzt('qbsx',startTime,endTime);
        jQuery.sxxzChart('qbsx',startTime,endTime);
    }else if(id == 'zwfwsx'){
        jQuery.szbmsxgszzt('zwfwsx',startTime,endTime);
        jQuery.qxbmsxgszzt('zwfwsx',startTime,endTime);
        jQuery.szbmsxgsbzt('zwfwsx',startTime,endTime);
        jQuery.qxbmsxgsbzt('zwfwsx',startTime,endTime);
        jQuery.sxxzChart('zwfwsx',startTime,endTime);
    }else if(id == 'ysqsx'){
        jQuery.szbmsxgszzt('ysqsx',startTime,endTime);
        jQuery.qxbmsxgszzt('ysqsx',startTime,endTime);
        jQuery.szbmsxgsbzt('ysqsx',startTime,endTime);
        jQuery.qxbmsxgsbzt('ysqsx',startTime,endTime);
        jQuery.sxxzChart('ysqsx',startTime,endTime);
    }else if(id == 'sdsx'){
        jQuery.szbmsxgszzt('sdsx',startTime,endTime);
        jQuery.qxbmsxgszzt('sdsx',startTime,endTime);
        jQuery.szbmsxgsbzt('sdsx',startTime,endTime);
        jQuery.qxbmsxgsbzt('sdsx',startTime,endTime);
        jQuery.sxxzChart('sdsx',startTime,endTime);
    }


});



//事项级别
jQuery.xsjb = function(){
	$.ajax({
		type : "get",
	    async : true,   
		url:xsjbUrl,
		success:function(result){
			menu.setOption({
				legend: {
				      show: false
				    },
				    series: [
				      {
				        type: 'pie',
				        center: ['50%', '50%'],
				        radius: ['55%', '70%'],
				        hoverAnimation: true,
				        label: {
				          show: true,
				          position:'outside',
			              fontSize:'13',
				          formatter:'\n\n{b}\n{c}个\n{d}%',
				        },
				        labelLine: {
				          show: true
				        },
				        data: [
				          {
				            name:'市级',
				            value: result.jnsxsl,
				            itemStyle: {
				              color: '#ffbe37'
				            }
				          },
				          {
				            name:'区县',
				            value: result.jnqxsxsl,
				            itemStyle: {
				              color: '#21beff'
				            }
				          }
				        ]
				      }
				    ]
			});
		},
		error : function(errorMsg) {
		       //alert("今日办结受理数量调用失败！");
		}
	});
}

var sxxzlb = [];
var sxxzsl = [];
//事项性质
jQuery.sxxz = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:sxxzUrl,
		success:function(result){
		   for(var i=0;i<result.length;i++){
			  for(var key in result[i]){
				  if(key == 'TYPE'){
					  switch(result[i][key])
					  {
					  case 'JL':
						sxxzlb.push('行政奖励');
					    break;
					  case 'ZS':
						sxxzlb.push('行政征收');
					    break;
					  case 'QT':
						sxxzlb.push('其它权力');
						break;
					  case 'CJ':
						sxxzlb.push('行政裁决');
						break;
					  case 'GG':
						sxxzlb.push('公共服务');
						break;
					  case 'JF':
						sxxzlb.push('行政给付');
						break;
					  case 'JD':
						sxxzlb.push('行政监督');
						break;
					  case 'XK':
					    sxxzlb.push('行政许可');
						break;
					  case 'QR':
						sxxzlb.push('行政确认');
					    break;
					  default:
					    
					  }
				  }else if(key == 'SXSL'){
					  sxxzsl.push(result[i][key]);
				  }
			  }
		   }
		   shareRankingChart.setOption({
			   color: ['#3dd3ba'],
			    grid: {
			      top: 20,
			      right: 0,
			      left: 20,
			      bottom: 0,
			      containLabel: true
			    },
			    tooltip: {
			      trigger: 'axis'
			    },
			    xAxis: {
			      type: 'category',
			      data: sxxzlb,
			      axisLabel: {
			        interval: 0,
			        rotate: 55,
			        textStyle: {
			          color: '#e5f8ff'
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
			    series: [
			      {
			        name: '事项性质',
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
			        data:sxxzsl
			      }
			    ]
		   });  
		   sxxzlb = [];
		   sxxzsl = [];
		}
	 });
}

//事项性质弹出框--受理/办结tab切换
$("body").on("click",".depart-ranking-title span",function(){
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    switch($(this).prop("id"))
    {
        case 'sxxzdrxsywsl':
            jQuery.sxxzdrxsslbjywsl();
            break;
        case 'sxxzdrxxywsl':
            jQuery.sxxzdrxxslbjywsl();
            break;
        case 'sxxzdyxsywsl':
            jQuery.sxxzdyxsslbjywsl();
            break;
        case 'sxxzdyxxywsl':
            jQuery.sxxzdyxxslbjywsl();
            break;
        case 'sxxzdnxsywsl':
            jQuery.sxxzdnxsslbjywsl();
            break;
        case 'sxxzdnxxywsl':
            jQuery.sxxzdnxxslbjywsl();
            break;
        case 'sxxzxszywsl':
            jQuery.sxxzxsslbjywzsl();
            break;
        case 'sxxzxxzywsl':
            jQuery.sxxzxxslbjywzsl();
            break;
        default:

    }
});

//事项性质弹出框四个图型初始化
function initsxxztck(){
    var sxxzdrywslzzt = echarts.init(document.getElementById('sxxzdrsl'));
    var sxxzdyywslzzt = echarts.init(document.getElementById('sxxzdysl'));
    var sxxzdnywslzzt = echarts.init(document.getElementById('sxxzdnsl'));
    var sxxzywzslzzt = echarts.init(document.getElementById('sxxzzsl'));
    /*var sxxzdrywslzztOption = {
              color: ['#3dd3ba'],
              grid: {
                top: 0,
                right: 0,
                left: 0,
                bottom: 0,
                containLabel: true
              },
              tooltip: {
                trigger: 'axis'
              },
              xAxis: {
                type: 'category',
                data: [],
                axisLabel: {
                  interval: 0,
                  rotate: 55,
                  textStyle: {
                    color: '#e5f8ff'
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
              series: [
                {
                  name: '事项性质',
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
                  data: []
                }
              ]
    };*/

    var sxxzdyywslzztOption = {
        color: ['#3dd3ba'],
        grid: {
            top: 0,
            right: 0,
            left: 0,
            bottom: 0,
            containLabel: true
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            type: 'category',
            data: [],
            axisLabel: {
                interval: 0,
                rotate: 55,
                textStyle: {
                    color: '#e5f8ff'
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
        series: [
            {
                name: '事项性质',
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
                data: []
            }
        ]
    };

    var sxxzdnywslzztOption = {
        color: ['#3dd3ba'],
        grid: {
            top: 0,
            right: 0,
            left: 0,
            bottom: 0,
            containLabel: true
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            type: 'category',
            data: [],
            axisLabel: {
                interval: 0,
                rotate: 55,
                textStyle: {
                    color: '#e5f8ff'
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
        series: [
            {
                name: '受理数量',
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
                data: []
            }
        ]
    };

    var sxxzywzslzztOption = {
        color: ['#3dd3ba'],
        grid: {
            top: 0,
            right: 0,
            left: 0,
            bottom: 0,
            containLabel: true
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            type: 'category',
            data: [],
            axisLabel: {
                interval: 0,
                rotate: 55,
                textStyle: {
                    color: '#e5f8ff'
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
        series: [
            {
                name: '受理数量',
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
                data: []
            }
        ]
    };

    //按事项性质分类当日线上受理办结业务数量
    jQuery.sxxzdrxsslbjywsl = function(){
        var sxlb = [];
        var slywsl = [];
        var bjywsl = [];
        var slywslCount = 0;
        var bjywslCount = 0;
        $.ajax({
            type : "post",
            async : true,
            url:sxxzdrxsslywslUrl,
            success:function(result){
                for(var i=0;i<result.slList.length;i++){
                    slywsl.push(result.slList[i].SL);
                    switch(result.slList[i].TYPE)
                    {
                        case 'JL':
                            sxlb.push('行政奖励');
                            break;
                        case 'ZS':
                            sxlb.push('行政奖励');
                            break;
                        case 'QT':
                            sxlb.push('其它权力');
                            break;
                        case 'GG':
                            sxlb.push('公共服务');
                            break;
                        case 'JF':
                            sxlb.push('行政给付');
                            break;
                        case 'JD':
                            sxlb.push('行政监督');
                            break;
                        case 'XK':
                            sxlb.push('行政许可');
                            break;
                        case 'QR':
                            sxlb.push('行政确认');
                            break;
                        case 'CJ':
                            sxlb.push('行政裁决');
                            break;
                        default:

                    }
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywsl.push(result.bjList[i].SL);
                }
                for(var i=0;i<result.slList.length;i++){
                    slywslCount+=result.slList[i].SL;
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywslCount+=result.bjList[i].SL;
                }
                $("#sxxzdrsldiv").html("当日线上受理数量：" + slywslCount + "<br/>" + "当日线上办结数量：" + bjywslCount);
                sxxzdrywslzzt.setOption({
                    color: ['#3dd3ba'],
                    grid: {
                        top: 20,
                        right: 0,
                        left: 20,
                        bottom: 0,
                        containLabel: true
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    xAxis: {
                        type: 'category',
                        data: sxlb,
                        axisLabel: {
                            interval: 0,
                            rotate: 55,
                            formatter:function(value)
                            {
                                return value.substring(0,5);
                            },
                            textStyle: {
                                color: '#e5f8ff'
                            }
                        }
                    },
                    yAxis: {
                        type: 'value',
                        splitNumber:2,
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
                    series: [
                        {
                            name: '受理数量',
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
                            data:slywsl

                        },{
                            name: '办结数量',
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
                            data:bjywsl

                        }
                    ]
                });
            }
        });
    }

    //按事项性质分类当日线下受理办结业务数量
    jQuery.sxxzdrxxslbjywsl = function(){
        var sxlb = [];
        var slywsl = [];
        var bjywsl = [];
        var slywslCount = 0;
        var bjywslCount = 0;
        $.ajax({
            type : "post",
            async : true,
            url:sxxzdrxxslywslUrl,
            success:function(result){
                for(var i=0;i<result.slList.length;i++){
                    slywsl.push(result.slList[i].SL);
                    switch(result.slList[i].TYPE)
                    {
                        case 'JL':
                            sxlb.push('行政奖励');
                            break;
                        case 'ZS':
                            sxlb.push('行政奖励');
                            break;
                        case 'QT':
                            sxlb.push('其它权力');
                            break;
                        case 'GG':
                            sxlb.push('公共服务');
                            break;
                        case 'JF':
                            sxlb.push('行政给付');
                            break;
                        case 'JD':
                            sxlb.push('行政监督');
                            break;
                        case 'XK':
                            sxlb.push('行政许可');
                            break;
                        case 'QR':
                            sxlb.push('行政确认');
                            break;
                        case 'CJ':
                            sxlb.push('行政裁决');
                        default:

                    }
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywsl.push(result.bjList[i].SL);
                }
                for(var i=0;i<result.slList.length;i++){
                    slywslCount+=result.slList[i].SL;
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywslCount+=result.bjList[i].SL;
                }
                $("#sxxzdrsldiv").html("当日线下受理数量：" + slywslCount + "<br/>" + "当日线下办结数量：" + bjywslCount);
                sxxzdrywslzzt.setOption({
                    color: ['#3dd3ba'],
                    grid: {
                        top: 20,
                        right: 0,
                        left: 20,
                        bottom: 0,
                        containLabel: true
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    xAxis: {
                        type: 'category',
                        data: sxlb,
                        axisLabel: {
                            interval: 0,
                            rotate: 55,
                            formatter:function(value)
                            {
                                return value.substring(0,5);
                            },
                            textStyle: {
                                color: '#e5f8ff'
                            }
                        }
                    },
                    yAxis: {
                        type: 'value',
                        splitNumber:2,
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
                    series: [
                        {
                            name: '受理数量',
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
                            data:slywsl

                        },{
                            name: '办结数量',
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
                            data:bjywsl

                        }
                    ]
                });
            }
        });
    }

    //按事项性质分类当月线上受理办结业务数量
    jQuery.sxxzdyxsslbjywsl = function(){
        var sxlb = [];
        var slywsl = [];
        var bjywsl = [];
        var slywslCount = 0;
        var bjywslCount = 0;
        $.ajax({
            type : "post",
            async : true,
            url:sxxzdyxsslywslUrl,
            success:function(result){
                for(var i=0;i<result.slList.length;i++){
                    slywsl.push(result.slList[i].SL);
                    switch(result.slList[i].TYPE)
                    {
                        case 'JL':
                            sxlb.push('行政奖励');
                            break;
                        case 'ZS':
                            sxlb.push('行政奖励');
                            break;
                        case 'QT':
                            sxlb.push('其它权力');
                            break;
                        case 'GG':
                            sxlb.push('公共服务');
                            break;
                        case 'JF':
                            sxlb.push('行政给付');
                            break;
                        case 'JD':
                            sxlb.push('行政监督');
                            break;
                        case 'XK':
                            sxlb.push('行政许可');
                            break;
                        case 'QR':
                            sxlb.push('行政确认');
                            break;
                        case 'CJ':
                            sxlb.push('行政裁决');
                        default:

                    }
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywsl.push(result.bjList[i].SL);
                }
                for(var i=0;i<result.slList.length;i++){
                    slywslCount+=result.slList[i].SL;
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywslCount+=result.bjList[i].SL;
                }
                $("#sxxzdysldiv").html("当月线上受理数量：" + slywslCount + "<br/>" + "当月线上办结数量：" + bjywslCount);
                sxxzdyywslzzt.setOption({
                    color: ['#3dd3ba'],
                    grid: {
                        top: 20,
                        right: 0,
                        left: 20,
                        bottom: 0,
                        containLabel: true
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    xAxis: {
                        type: 'category',
                        data: sxlb,
                        axisLabel: {
                            interval: 0,
                            rotate: 55,
                            formatter:function(value)
                            {
                                return value.substring(0,5);
                            },
                            textStyle: {
                                color: '#e5f8ff'
                            }
                        }
                    },
                    yAxis: {
                        type: 'value',
                        splitNumber:2,
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
                    series: [
                        {
                            name: '受理数量',
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
                            data:slywsl

                        },{
                            name: '办结数量',
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
                            data:bjywsl

                        }
                    ]
                });
            }
        });
    }

    //按事项性质分类当月线下受理办结业务数量
    jQuery.sxxzdyxxslbjywsl = function(){
        var sxlb = [];
        var slywsl = [];
        var bjywsl = [];
        var slywslCount = 0;
        var bjywslCount = 0;
        $.ajax({
            type : "post",
            async : true,
            url:sxxzdyxxslywslUrl,
            success:function(result){
                for(var i=0;i<result.slList.length;i++){
                    slywsl.push(result.slList[i].SL);
                    switch(result.slList[i].TYPE)
                    {
                        case 'JL':
                            sxlb.push('行政奖励');
                            break;
                        case 'ZS':
                            sxlb.push('行政奖励');
                            break;
                        case 'QT':
                            sxlb.push('其它权力');
                            break;
                        case 'GG':
                            sxlb.push('公共服务');
                            break;
                        case 'JF':
                            sxlb.push('行政给付');
                            break;
                        case 'JD':
                            sxlb.push('行政监督');
                            break;
                        case 'XK':
                            sxlb.push('行政许可');
                            break;
                        case 'QR':
                            sxlb.push('行政确认');
                            break;
                        case 'CJ':
                            sxlb.push('行政裁决');
                        default:

                    }
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywsl.push(result.bjList[i].SL);
                }
                for(var i=0;i<result.slList.length;i++){
                    slywslCount+=result.slList[i].SL;
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywslCount+=result.bjList[i].SL;
                }
                $("#sxxzdysldiv").html("当月线下受理数量：" + slywslCount + "<br/>" + "当月线下办结数量：" + bjywslCount);
                sxxzdyywslzzt.setOption({
                    color: ['#3dd3ba'],
                    grid: {
                        top: 20,
                        right: 0,
                        left: 20,
                        bottom: 0,
                        containLabel: true
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    xAxis: {
                        type: 'category',
                        data: sxlb,
                        axisLabel: {
                            interval: 0,
                            rotate: 55,
                            formatter:function(value)
                            {
                                return value.substring(0,5);
                            },
                            textStyle: {
                                color: '#e5f8ff'
                            }
                        }
                    },
                    yAxis: {
                        type: 'value',
                        splitNumber:2,
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
                    series: [
                        {
                            name: '受理数量',
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
                            data:slywsl

                        },{
                            name: '办结数量',
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
                            data:bjywsl

                        }
                    ]
                });
            }
        });
    }

    //按事项性质分类当年线上受理办结业务数量
    jQuery.sxxzdnxsslbjywsl = function(){
        var sxlb = [];
        var slywsl = [];
        var bjywsl = [];
        var slywslCount = 0;
        var bjywslCount = 0;
        $.ajax({
            type : "post",
            async : true,
            url:sxxzdnxsslywslUrl,
            success:function(result){
                for(var i=0;i<result.slList.length;i++){
                    slywsl.push(result.slList[i].SL);
                    switch(result.slList[i].TYPE)
                    {
                        case 'JL':
                            sxlb.push('行政奖励');
                            break;
                        case 'ZS':
                            sxlb.push('行政奖励');
                            break;
                        case 'QT':
                            sxlb.push('其它权力');
                            break;
                        case 'GG':
                            sxlb.push('公共服务');
                            break;
                        case 'JF':
                            sxlb.push('行政给付');
                            break;
                        case 'JD':
                            sxlb.push('行政监督');
                            break;
                        case 'XK':
                            sxlb.push('行政许可');
                            break;
                        case 'QR':
                            sxlb.push('行政确认');
                            break;
                        case 'CJ':
                            sxlb.push('行政裁决');
                        default:

                    }
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywsl.push(result.bjList[i].SL);
                }
                for(var i=0;i<result.slList.length;i++){
                    slywslCount+=result.slList[i].SL;
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywslCount+=result.bjList[i].SL;
                }
                $("#sxxzdnsldiv").html("当年线上受理数量：" + slywslCount + "<br/>" + "当年线上办结数量：" + bjywslCount);
                sxxzdnywslzzt.setOption({
                    color: ['#3dd3ba'],
                    grid: {
                        top: 20,
                        right: 0,
                        left: 20,
                        bottom: 0,
                        containLabel: true
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    xAxis: {
                        type: 'category',
                        data: sxlb,
                        axisLabel: {
                            interval: 0,
                            rotate: 55,
                            formatter:function(value)
                            {
                                return value.substring(0,5);
                            },
                            textStyle: {
                                color: '#e5f8ff'
                            }
                        }
                    },
                    yAxis: {
                        type: 'value',
                        splitNumber:2,
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
                    series: [
                        {
                            name: '受理数量',
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
                            data:slywsl

                        },{
                            name: '办结数量',
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
                            data:bjywsl

                        }
                    ]
                });
            }
        });
    }

    //按事项性质分类当年线下受理办结业务数量
    jQuery.sxxzdnxxslbjywsl = function(){
        var sxlb = [];
        var slywsl = [];
        var bjywsl = [];
        var slywslCount = 0;
        var bjywslCount = 0;
        $.ajax({
            type : "post",
            async : true,
            url:sxxzdnxxslywslUrl,
            success:function(result){
                for(var i=0;i<result.slList.length;i++){
                    slywsl.push(result.slList[i].SL);
                    switch(result.slList[i].TYPE)
                    {
                        case 'JL':
                            sxlb.push('行政奖励');
                            break;
                        case 'ZS':
                            sxlb.push('行政奖励');
                            break;
                        case 'QT':
                            sxlb.push('其它权力');
                            break;
                        case 'GG':
                            sxlb.push('公共服务');
                            break;
                        case 'JF':
                            sxlb.push('行政给付');
                            break;
                        case 'JD':
                            sxlb.push('行政监督');
                            break;
                        case 'XK':
                            sxlb.push('行政许可');
                            break;
                        case 'QR':
                            sxlb.push('行政确认');
                            break;
                        case 'CJ':
                            sxlb.push('行政裁决');
                        default:

                    }
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywsl.push(result.bjList[i].SL);
                }
                for(var i=0;i<result.slList.length;i++){
                    slywslCount+=result.slList[i].SL;
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywslCount+=result.bjList[i].SL;
                }
                $("#sxxzdnsldiv").html("当年线下受理数量：" + slywslCount + "<br/>" + "当年线下办结数量：" + bjywslCount);
                sxxzdnywslzzt.setOption({
                    color: ['#3dd3ba'],
                    grid: {
                        top: 20,
                        right: 0,
                        left: 20,
                        bottom: 0,
                        containLabel: true
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    xAxis: {
                        type: 'category',
                        data: sxlb,
                        axisLabel: {
                            interval: 0,
                            rotate: 55,
                            formatter:function(value)
                            {
                                return value.substring(0,5);
                            },
                            textStyle: {
                                color: '#e5f8ff'
                            }
                        }
                    },
                    yAxis: {
                        type: 'value',
                        splitNumber:2,
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
                    series: [
                        {
                            name: '受理数量',
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
                            data:slywsl

                        },{
                            name: '办结数量',
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
                            data:bjywsl

                        }
                    ]
                });
            }
        });
    }

    //按事项性质分类线上受理办结业务总数量
    jQuery.sxxzxsslbjywzsl = function(){
        var sxlb = [];
        var slywsl = [];
        var bjywsl = [];
        var slywslCount = 0;
        var bjywslCount = 0;
        $.ajax({
            type : "post",
            async : true,
            url:sxxzxsslywzslUrl,
            success:function(result){
                for(var i=0;i<result.slList.length;i++){
                    slywsl.push(result.slList[i].SL);
                    switch(result.slList[i].TYPE)
                    {
                        case 'JL':
                            sxlb.push('行政奖励');
                            break;
                        case 'ZS':
                            sxlb.push('行政奖励');
                            break;
                        case 'QT':
                            sxlb.push('其它权力');
                            break;
                        case 'GG':
                            sxlb.push('公共服务');
                            break;
                        case 'JF':
                            sxlb.push('行政给付');
                            break;
                        case 'JD':
                            sxlb.push('行政监督');
                            break;
                        case 'XK':
                            sxlb.push('行政许可');
                            break;
                        case 'QR':
                            sxlb.push('行政确认');
                            break;
                        case 'CJ':
                            sxlb.push('行政裁决');
                        default:

                    }
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywsl.push(result.bjList[i].SL);
                }
                for(var i=0;i<result.slList.length;i++){
                    slywslCount+=result.slList[i].SL;
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywslCount+=result.bjList[i].SL;
                }
                $("#sxxzzsldiv").html("线上受理总数量：" + slywslCount + "<br/>" + "线上办结总数量：" + bjywslCount);
                sxxzywzslzzt.setOption({
                    color: ['#3dd3ba'],
                    grid: {
                        top: 20,
                        right: 0,
                        left: 20,
                        bottom: 0,
                        containLabel: true
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    xAxis: {
                        type: 'category',
                        data: sxlb,
                        axisLabel: {
                            interval: 0,
                            rotate: 55,
                            formatter:function(value)
                            {
                                return value.substring(0,5);
                            },
                            textStyle: {
                                color: '#e5f8ff'
                            }
                        }
                    },
                    yAxis: {
                        type: 'value',
                        splitNumber:2,
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
                    series: [
                        {
                            name: '受理数量',
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
                            data:slywsl

                        },{
                            name: '办结数量',
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
                            data:bjywsl

                        }
                    ]
                });
            }
        });
    }

    //按事项性质分类线下受理办结业务总数量
    jQuery.sxxzxxslbjywzsl = function(){
        var sxlb = [];
        var slywsl = [];
        var bjywsl = [];
        var slywslCount = 0;
        var bjywslCount = 0;
        $.ajax({
            type : "post",
            async : true,
            url:sxxzxxslywzslUrl,
            success:function(result){
                for(var i=0;i<result.slList.length;i++){
                    switch(result.slList[i].TYPE)
                    {
                        case 'JL':
                            sxlb.push('行政奖励');
                            break;
                        case 'ZS':
                            sxlb.push('行政奖励');
                            break;
                        case 'QT':
                            sxlb.push('其它权力');
                            break;
                        case 'GG':
                            sxlb.push('公共服务');
                            break;
                        case 'JF':
                            sxlb.push('行政给付');
                            break;
                        case 'JD':
                            sxlb.push('行政监督');
                            break;
                        case 'XK':
                            sxlb.push('行政许可');
                            break;
                        case 'QR':
                            sxlb.push('行政确认');
                            break;
                        case 'CJ':
                            sxlb.push('行政裁决');
                        default:

                    }
                    slywsl.push(result.slList[i].SL);
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywsl.push(result.bjList[i].SL);
                }
                for(var i=0;i<result.slList.length;i++){
                    slywslCount+=result.slList[i].SL;
                }
                for(var i=0;i<result.bjList.length;i++){
                    bjywslCount+=result.bjList[i].SL;
                }
                $("#sxxzzsldiv").html("线下受理总数量：" + slywslCount + "<br/>" + "线下办结总数量：" + bjywslCount);
                sxxzywzslzzt.setOption({
                    color: ['#3dd3ba'],
                    grid: {
                        top: 20,
                        right: 0,
                        left: 20,
                        bottom: 0,
                        containLabel: true
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    xAxis: {
                        type: 'category',
                        data: sxlb,
                        axisLabel: {
                            interval: 0,
                            rotate: 55,
                            formatter:function(value)
                            {
                                return value.substring(0,5);
                            },
                            textStyle: {
                                color: '#e5f8ff'
                            }
                        }
                    },
                    yAxis: {
                        type: 'value',
                        splitNumber:2,
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
                    series: [
                        {
                            name: '受理数量',
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
                            data:slywsl

                        },{
                            name: '办结数量',
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
                            data:bjywsl

                        }
                    ]
                });
            }
        });
    }
}

//事项性质更多页面底部的数据表格 author zxp
jQuery.bjlTable = function () {
    $.ajax({
        type : "get",
        async : true,
        url:bjlTableUrl,
        success:function(result){
            var list1 = result['list1'];
            var list2 = result['list2'];
            var list3 = result['list3'];
            var list4 = result['list4'];

            // var xstotal = list1[1] + list2[1] + list3[1];
            // var xxtotal = list1[2] + list2[2] + list3[2];
            // var total = list1[3] + list2[3] + list3[3];
            // var totalswl = (xstotal / total * 100).toFixed(2)+"%";
            // var list4 = ['总量',xstotal,xxtotal,total,totalswl];
            // // console.log(totalswl);
            // // console.log(list1);
            // // console.log(list2);
            // // console.log(list3);

            var htmlStr = "<tr>";
            for(var i=0;i<list1.length;i++){
                htmlStr += "<td>"+list1[i] + "</td>";
            }
            htmlStr += "</tr><tr>";
            for(var i=0;i<list2.length;i++){
                htmlStr += "<td>"+list2[i] + "</td><";
            }
            htmlStr += "</tr><tr>";
            for(var i=0;i<list3.length;i++){
                htmlStr += "<td>"+list3[i] + "</td>";
            }
            htmlStr += "</tr><tr>";
            for(var i=0;i<list4.length;i++){
                htmlStr += "<td>"+list4[i] + "</td>";
            }
            htmlStr += "</tr>";

            $("#sxxzbox-tbody").html(htmlStr);


        }

    })

}

/*jQuery.sxxzTable = function(){
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#sxxzMorePageTable'
            ,url: sxxzTableDateUrl
            ,cols: [
                [
                    {field:'ORG_CODE', width:150, title: '单位编号',rowspan:3,align:'center'}
                    ,{field:'ORG_NAME', width:200, title: '单位名称',rowspan:3,align:'center'}
                    ,{field:'ITEM_NAME', width:300, title: '事项名称',rowspan:3,align:'center'}
                    ,{field:'TYPE', width:150, title: '事项性质',rowspan:3,align:'center',
                    templet: function(res){
                        if(res.TYPE=="XK"){
                            return "行政许可";
                        }else if(res.TYPE=="ZS"){
                            return "行政征收";
                        }else if(res.TYPE=="QR"){
                            return "行政确认";
                        }else if(res.TYPE=="JF"){
                            return "行政给付";
                        }else if(res.TYPE=="JL"){
                            return "行政奖励";
                        }else if(res.TYPE=="CJ"){
                            return "行政裁决";
                        }else if(res.TYPE=="QT"){
                            return "其它权力";
                        }else if(res.TYPE=="GG"){
                            return "公共服务";
                        }else if(res.TYPE=="JD"){
                            return "行政监督";
                        }else {
                            return "";
                        }

                    }
                }
                    ,{field:'', width:320, title: '全部',colspan:4,align:'center'}
                    ,{field:'SUBMIT_TIME', width:200, title: '最后回传时间',rowspan:3,align:'left',
                    templet:function (d) {
                        return formatDateAll(d.SUBMIT_TIME);
                    }
                }
                ],

                [
                    {field:'', width:160, title: '受理',colspan:2,align:'center'}
                    ,{field:'', width:160, title: '办结',colspan:2,align:'center'}
                ],

                [
                    {field:'QBSLXS', width:80, title: '线上',align:'center'}
                    ,{field:'QBSLXX', width:80, title: '线下',align:'center'}
                    ,{field:'QBBJXS', width:80, title: '线上',align:'center'}
                    ,{field:'QBBJXX', width:80, title: '线下',align:'center'}
                ]

            ]
            ,page: true
            ,limit: 7
            ,limits: [7]
        });
    });
}*/


var bmslmc = [];
var bmslsl = [];
//部门受理排名
jQuery.bmslpm = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:bmslpmUrl,
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ORG_NAME'){
						bmslmc.push(result[i][key]);
					}else if(key == 'SL'){
						bmslsl.push(result[i][key]);
					}
				}
			}
			rankingChart.setOption({
				color: ['#3dd3ba'],
			      grid: {
			          top: 10,
			          right: 0,
			          left: 0,
			          bottom: 0,
			          containLabel: true
			      },
			      tooltip: {
			          trigger: 'axis'
			      },
			      xAxis: {
			          type: 'category',
			          data: bmslmc,
			          axisLabel: {
			              interval: 0,
			              rotate: 50,
			              formatter:function(name)
	  	    	          {
	  	    	        	return (name.length > 5 ? (name.slice(0,5)+"...") : name ); 
	  	    	          },
			              textStyle: {
			                  color: '#e5f8ff'
			                  
			              }
			          }
			      },
			      yAxis: {
			          type: 'value',
			          splitNumber:2,
			          axisLine: {
			              show: false
			          },
			          axisLabel: {
			              textStyle: {
			                  color: '#e5f8ff',
			                  fontSize:'10',
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
			              name: '部门受理排名',
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
			              data: bmslsl
			          }
			      ]
			});
			bmslmc = [];
			bmslsl = [];
		}
	});
}
var bmbjmc = [];
var bmbjsl = [];
//部门办结排名
jQuery.bmbjpm = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:bmbjpmUrl,
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ORG_NAME'){
						bmbjmc.push(result[i][key]);
					}else if(key == 'SL'){
						bmbjsl.push(result[i][key]);
					}
				}
			}
			rankingChart.setOption({
				color: ['#3dd3ba'],
			      grid: {
			          top: 10,
			          right: 0,
			          left: 0,
			          bottom: 0,
			          containLabel: true
			      },
			      tooltip: {
			          trigger: 'axis'
			      },
			      xAxis: {
			          type: 'category',
			          data: bmbjmc,
			          
			          axisLabel: {
			              interval: 0,
			              rotate: 50,
			              formatter:function(name)
	  	    	          {
	  	    	        	return (name.length > 5 ? (name.slice(0,5)+"...") : name ); 
	  	    	          },
			              textStyle: {
			                  color: '#e5f8ff',
			               
			              }
			          }
			      },
			      yAxis: {
			          type: 'value',
			          splitNumber:2,
			          axisLine: {
			              show: false
			          },
			          axisLabel: {
			              textStyle: {
			                  color: '#e5f8ff',
			                  fontSize:'10',
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
			              name: '部门办结排名',
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
			              data: bmbjsl
			          }
			      ]
			});
			bmbjmc = [];
			bmbjsl = [];
		}
	});
}

var sxslqsmmc = [];
var sxslqsmsl = [];
var sxslArr = [];

//事项受理前十名词云
jQuery.sxslqsmcy = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:sxslqsmUrl,
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'NAME'){
						sxslqsmmc.push(result[i][key]);
					}else if(key == 'SL'){
						sxslqsmsl.push(result[i][key]);
					}
				}
			}
			for(var j=0;j<sxslqsmmc.length;j++){
				var sxslObj={};
				sxslObj.name = sxslqsmmc[j];
				sxslObj.value = sxslqsmsl[j];
				sxslArr.push(sxslObj);
			}
			topTen.setOption({
			    tooltip: {},
			    grid: {
			          top: 0,
			          right: 0,
			          left: 0,
			          bottom: 0,
			          containLabel: true
			    },
			    series: [ {
			      type: 'wordCloud',
			      gridSize: 2,
			      sizeRange: [10, 30],
			      rotationRange: [0,0],
			      shape: 'circle',
			      width: 500,
			      height: 180,
			      textStyle: {
			        normal: {
			          color: function () {
			            var colorArray = ['#9f850f','#cdae33','#c0b066','#ffe782']
			            var index = Math.floor(Math.random()*colorArray.length);
			            return colorArray[index]
			          }
			        },
			        emphasis: {
			          shadowBlur: 10,
			          shadowColor: '#333'
			        }
			      },
			      data: sxslArr
			    } ]
			});
			sxslqsmmc = [];
			sxslqsmsl = [];
			sxslArr = [];
		}
	});
}
var sxbjqsmmc = [];
var sxbjqsmsl = [];
var sxbjArr = [];

//事项办结前十名词云
jQuery.sxbjqsmcy = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:sxbjqsmUrl,
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'NAME'){
						sxbjqsmmc.push(result[i][key]);
					}else if(key == 'SL'){
						sxbjqsmsl.push(result[i][key]);
					}
				}
			}
			for(var j=0;j<sxbjqsmmc.length;j++){
				var sxbjObj = {};
				sxbjObj.name = sxbjqsmmc[j];
				sxbjObj.value = sxbjqsmsl[j];
				sxbjArr.push(sxbjObj);
			}
			topTen.setOption({
				tooltip: {},
		        series: [ {
		            type: 'wordCloud',
		            gridSize: 2,
				    sizeRange: [10, 30],
				    rotationRange: [0,0],
		            shape: 'circle',
		            width: 500,
		            height: 180,
		            textStyle: {
		                normal: {
		                    color: function () {
		                        var colorArray = ['#82d9ff','#69afcf','#3cc5ff','#00b3ff']
		                        var index = Math.floor(Math.random()*colorArray.length);
		                        return colorArray[index]
		                    }
		                },
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowColor: '#333'
		                }
		            },
		            data: sxbjArr
		        } ]
			});
			sxbjqsmmc = [];
			sxbjqsmsl = [];
			sxbjArr = [];
		}
	});
}

//当日线上变化趋势
jQuery.xsdrblcs = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:xsdrblcsUrl,
		success:function(result){
			var slsjList = [];
			var bjsjList = [];
			var xsslList = [];
			var xsbjList = [];
			var drslzl = 0;
			var drbjzl = 0;
			for(var i=0;i<result.xsdrslList.length;i++){
				for(var key in result.xsdrslList[i]){
					if(key == 'SJ'){
						slsjList.push(result.xsdrslList[i][key]);
					}else if(key == 'SXSL'){
						xsslList.push(result.xsdrslList[i][key]);
					}
				}
			}  
			
			for(var i=0;i<result.xsdrbjList.length;i++){
				for(var key in result.xsdrbjList[i]){
					if(key == 'SJ'){
						bjsjList.push(result.xsdrbjList[i][key]);
					}else if(key == 'SXSL'){
						xsbjList.push(result.xsdrbjList[i][key]);
					}
				}
			}
			
			for(var i=0;i<xsslList.length;i++){
				drslzl+=xsslList[i];
			}
			for(var i=0;i<xsbjList.length;i++){
				drbjzl+=xsbjList[i];
			}
			$("#xsslzs").html(drslzl);
			$("#xsbjzs").html(drbjzl);
			xsChart.setOption({
				grid: {
				      top: 30,
				      left: 0,
				      right: 0,
				      bottom: 0,
				      containLabel: true
				    },
				    xAxis: {
				      type: 'category',
				      data: slsjList,
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
				      data: ['受理', '办结'],
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
				      name: '受理',
				      data: xsslList,
				      color: '#0094fb',
				    },{
				      type: 'line',
				      name: '办结',
				      data: xsbjList,
				      color: '#ddb401',
				    }]
			});
		}
	});
}

//当月线上变化趋势
jQuery.xsdyblcs = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:xsdyblcsUrl,
		success:function(result){
			var slsjList = [];
			var bjsjList = [];
			var xsslList = [];
			var xsbjList = [];
			var dyslzl = 0;
			var dybjzl = 0;
			for(var i=0;i<result.xsdyslList.length;i++){
				for(var key in result.xsdyslList[i]){
					if(key == 'SJ'){
						slsjList.push(result.xsdyslList[i][key]);
					}else if(key == 'SXSL'){
						xsslList.push(result.xsdyslList[i][key]);
					}
				}
			}  
			
			for(var i=0;i<result.xsdybjList.length;i++){
				for(var key in result.xsdybjList[i]){
					if(key == 'SJ'){
						bjsjList.push(result.xsdybjList[i][key]);
					}else if(key == 'SXSL'){
						xsbjList.push(result.xsdybjList[i][key]);
					}
				}
			}  
			
			for(var i=0;i<xsslList.length;i++){
				dyslzl+=xsslList[i];
			}
			
			for(var i=0;i<xsbjList.length;i++){
				dybjzl+=xsbjList[i];
			}
			$("#xsslzs").html(dyslzl);
			$("#xsbjzs").html(dybjzl);
			xsChart.setOption({
				grid: {
				      top: 30,
				      left: 0,
				      right: 0,
				      bottom: 0,
				      containLabel: true
				    },
				    xAxis: {
				      type: 'category',
				      data: slsjList,
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
				      data: ['受理', '办结'],
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
				      name: '受理',
				      data: xsslList,
				      color: '#0094fb',
				    },{
				      type: 'line',
				      name: '办结',
				      data: xsbjList,
				      color: '#ddb401',
				    }]
			});
		}
	});
}

//当年线上变化趋势
jQuery.xsdnblcs = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:xsdnblcsUrl,
		success:function(result){
			var slsjList = [];
			var bjsjList = [];
			var xsslList = [];
			var xsbjList = [];
			var dnslzl =0;
			var dnbjzl =0;
			for(var i=0;i<result.xsdnslList.length;i++){
				for(var key in result.xsdnslList[i]){
					if(key == 'SJ'){
						slsjList.push(result.xsdnslList[i][key]);
					}else if(key == 'SXSL'){
						xsslList.push(result.xsdnslList[i][key]);
					}
				}
			}  
			
			for(var i=0;i<result.xsdnbjList.length;i++){
				for(var key in result.xsdnbjList[i]){
					if(key == 'SJ'){
						bjsjList.push(result.xsdnbjList[i][key]);
					}else if(key == 'SXSL'){
						xsbjList.push(result.xsdnbjList[i][key]);
					}
				}
			}  
			
			for(var i=0;i<xsslList.length;i++){
				dnslzl+=xsslList[i];
			}
			
			for(var i=0;i<xsbjList.length;i++){
				dnbjzl+=xsbjList[i];
			}
			$("#xsslzs").html(dnslzl);
			$("#xsbjzs").html(dnbjzl);
			xsChart.setOption({
				grid: {
				      top: 30,
				      left: 0,
				      right: 0,
				      bottom: 0,
				      containLabel: true
				    },
				    xAxis: {
				      type: 'category',
				      data: slsjList,
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
				      data: ['受理', '办结'],
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
				      name: '受理',
				      data: xsslList,
				      color: '#0094fb',
				    },{
				      type: 'line',
				      name: '办结',
				      data: xsbjList,
				      color: '#ddb401',
				    }]
			});
		}
	});
}

//当日线下变化趋势
jQuery.xxdrblcs = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:xxdrblcsUrl,
		success:function(result){
			var slsjList = [];
			var bjsjList = [];
			var slList = [];
			var bjList = [];
			var drslzl =0;
			var drbjzl =0;
			for(var i=0;i<result.xxdrslList.length;i++){
				for(var key in result.xxdrslList[i]){
					if(key == 'SJ'){
						slsjList.push(result.xxdrslList[i][key]);
					}else if(key == 'SXSL'){
						slList.push(result.xxdrslList[i][key]);
					}
				}
			}  
			
			for(var i=0;i<result.xxdrbjList.length;i++){
				for(var key in result.xxdrbjList[i]){
					if(key == 'SJ'){
						bjsjList.push(result.xxdrbjList[i][key]);
					}else if(key == 'SXSL'){
						bjList.push(result.xxdrbjList[i][key]);
					}
				}
			}  
			
			for(var i=0;i<slList.length;i++){
				drslzl+=slList[i];
			}
			
			for(var i=0;i<bjList.length;i++){
				drbjzl+=bjList[i];
			}
			$("#xxslzs").html(drslzl);
			$("#xxbjzs").html(drbjzl);
			xxChart.setOption({
				grid: {
				      top: 30,
				      left: 0,
				      right: 0,
				      bottom: 0,
				      containLabel: true
				    },
				    xAxis: {
				      type: 'category',
				      data: slsjList,
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
				      data: ['受理', '办结'],
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
				      name: '受理',
				      data: slList,
				      color: '#0094fb',
				    },{
				      type: 'line',
				      name: '办结',
				      data: bjList,
				      color: '#ddb401',
				    }]
			});
		}
	});
}

//当月线下变化趋势
jQuery.xxdyblcs = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:xxdyblcsUrl,
		success:function(result){
			var slsjList = [];
			var bjsjList = [];
			var slList = [];
			var bjList = [];
			var dyslzl = 0;
			var dybjzl = 0;
			for(var i=0;i<result.xxdyslList.length;i++){
				for(var key in result.xxdyslList[i]){
					if(key == 'SJ'){
						slsjList.push(result.xxdyslList[i][key]);
					}else if(key == 'SXSL'){
						slList.push(result.xxdyslList[i][key]);
					}
				}
			}  
			
			for(var i=0;i<result.xxdybjList.length;i++){
				for(var key in result.xxdybjList[i]){
					if(key == 'SJ'){
						bjsjList.push(result.xxdybjList[i][key]);
					}else if(key == 'SXSL'){
						bjList.push(result.xxdybjList[i][key]);
					}
				}
			}  
			
			for(var i=0;i<slList.length;i++){
				dyslzl+=slList[i];
			}
			
			for(var i=0;i<bjList.length;i++){
				dybjzl+=bjList[i];
			}
			$("#xxslzs").html(dyslzl);
			$("#xxbjzs").html(dybjzl);
			xxChart.setOption({
				grid: {
				      top: 30,
				      left: 0,
				      right: 0,
				      bottom: 0,
				      containLabel: true
				    },
				    xAxis: {
				      type: 'category',
				      data: slsjList,
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
				      data: ['受理', '办结'],
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
				      name: '受理',
				      data: slList,
				      color: '#0094fb',
				    },{
				      type: 'line',
				      name: '办结',
				      data: bjList,
				      color: '#ddb401',
				    }]
			});
		}
	});
}

//当年线下变化趋势
jQuery.xxdnblcs = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:xxdnblcsUrl,
		success:function(result){
			var slsjList = [];
			var bjsjList = [];
			var slList = [];
			var bjList = [];
			var dnslzl =0;
			var dnbjzl =0;
			for(var i=0;i<result.xxdnslList.length;i++){
				for(var key in result.xxdnslList[i]){
					if(key == 'SJ'){
						slsjList.push(result.xxdnslList[i][key]);
					}else if(key == 'SXSL'){
						slList.push(result.xxdnslList[i][key]);
					}
				}
			}  
			
			for(var i=0;i<result.xxdnbjList.length;i++){
				for(var key in result.xxdnbjList[i]){
					if(key == 'SJ'){
						bjsjList.push(result.xxdnbjList[i][key]);
					}else if(key == 'SXSL'){
						bjList.push(result.xxdnbjList[i][key]);
					}
				}
			}  
			
			for(var i=0;i<slList.length;i++){
				dnslzl+=slList[i];
			}
			
			for(var i=0;i<bjList.length;i++){
				dnbjzl+=bjList[i];
			}
			$("#xxslzs").html(dnslzl);
			$("#xxbjzs").html(dnbjzl);
			xxChart.setOption({
				grid: {
				      top: 30,
				      left: 0,
				      right: 0,
				      bottom: 0,
				      containLabel: true
				    },
				    xAxis: {
				      type: 'category',
				      data: slsjList,
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
				      data: ['受理', '办结'],
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
				      name: '受理',
				      data: slList,
				      color: '#0094fb',
				    },{
				      type: 'line',
				      name: '办结',
				      data: bjList,
				      color: '#ddb401',
				    }]
			});
		}
	});
}

jQuery.bmyjhongpai = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:bmyjhongpaiUrl,
		success:function(result){
			$("#bmyjhongpai").html(result.hpsl);
			for(var i=0;i<result.hpmxList.length;i++){
				if(i>1){
		     		   break;
		     	   }
				$("#hongpaitable").append(
						"<tr>" + 
						"<td>" + (i+1) + "</td>" + 
						"<td>" + result.hpmxList[i]['NAME'] + "</td>" + 
						"<td>" + result.hpmxList[i]['CSTS'] + "</td>" + 
						"<td>" + result.hpmxList[i]['SL'] + "</td>" + 
				        "</tr>"
				);
				
			}
			
		}
	});
}

jQuery.bmyjhuangpai = function(){
	$.ajax({
		type : "post",
	    async : true,   
		url:bmyjhuangpaiUrl,
		success:function(result){
           $("#bmyjhuangpai").html(result.hpsl);
           for(var i=0;i<result.hpmxList.length;i++){
        	   if(i>1){
        		   break;
        	   }
        	   $("#huangpaitable").append(
						"<tr>" + 
						"<td>" + (i+1) + "</td>" + 
						"<td>" + result.hpmxList[i]['NAME'] + "</td>" + 
						"<td>" + result.hpmxList[i]['CSTS'] + "</td>" + 
						"<td>" + result.hpmxList[i]['SL'] + "</td>" + 
				        "</tr>"
				);
        	   
		   }
		}
	});
}

//计算顶部echarts和底部数据表格之间的四个值
jQuery.zlxsxxswl = function(){
    $.ajax({
        type : "get",
        async : true,
        url:zlxsxxswlUrl,
        success:function(result){
			$("#tdsxzs").text(result['sbjqxjzs']);
			$("#tdxssl").text(result['sbjqxjxszs']);
			$("#tdxxsl").text(result['sbjqxjxxzs']);
			$("#tdswl").text(result['swl']);
        }
    });
}




//业务办理变化趋势
$(function () {
	 $(".panel-header ul li").click(function(){
		 $(this).addClass('active').siblings().removeClass('active');
		 if($(this).html()=='当日'){
			 jQuery.xsdrblcs();
			 jQuery.xxdrblcs();
		 }else if($(this).html()=='当月'){
			 jQuery.xsdyblcs();
			 jQuery.xxdyblcs();
		 }else if($(this).html()=='当年'){
			 jQuery.xsdnblcs();
			 jQuery.xxdnblcs();
		 }
	 });
});

//部门受理办结排名--受理/办结tab切换
$("body").on("click",".depart-accept-ranking .depart-ranking-title span",function(){
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    if(name == 'acceptOption'){
    	jQuery.bmslpm();
    }else if(name == 'handleOption'){
    	jQuery.bmbjpm();
    }
});

//事项受理前十名--受理办结tab切换
$("a[name='toptentab']").click(function(){
	$(this).css({"color":"#03c5d9"});
	$(this).siblings().css({"color":"#ffffff"});
	$(this).addClass('toptenactive').siblings().removeClass('toptenactive');
	$("#toptengd").css({"color":"#03c5d9"});
	if($(this).prop("id")=="toptensl"){
		jQuery.sxslqsmcy();
	}else if($(this).prop("id")=="toptenbj"){
		jQuery.sxbjqsmcy();
	}
});

//事项受理办结本日，点击切换	 start	author zxp
$("body").on("click",".chart-content .today .depart-ranking-title span",function(){
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    if(name == 'acceptOptionToday'){
    	//事项受理本日
    	jQuery.sxslbr();
    }else if(name == 'handleOptionToday'){
    	//事项办结本日
    	jQuery.sxbjbr();
    }
});
//事项受理办结本日，点击切换  end		author zxp

//事项受理办结本月，点击切换	 start	author zxp
$("body").on("click",".chart-content .thisMonth .depart-ranking-title span",function(){
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    if(name == 'acceptOptionMonth'){
    	//事项受理本月
    	jQuery.sxslby();
    }else if(name == 'handleOptionMonth'){
    	//事项办结本月
    	jQuery.sxbjby();
    }
});
//事项受理办结本月，点击切换  end		author zxp

//事项受理办结本年，点击切换	 start	author zxp
$("body").on("click",".chart-content .thisYear .depart-ranking-title span",function(){
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    if(name == 'acceptOptionYear'){
    	//事项受理本年
    	jQuery.sxslbn();
    }else if(name == 'handleOptionYear'){
    	//事项办结本年
    	jQuery.sxbjbn();
    }
});
//事项受理办结本年，点击切换  end		author zxp

//事项受理办结全部，点击切换	 start	author zxp
$("body").on("click",".chart-content .all .depart-ranking-title span",function(){
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    if(name == 'acceptOptionAll'){
    	//事项受理本年
    	jQuery.sxslqb();
    }else if(name == 'handleOptionAll'){
    	//事项办结本年
    	jQuery.sxbjqb();
    }
});

//部门受理办结今日，点击切换		author zxp
$("body").on("click",".chart-content .bmslbj-today .depart-ranking-title span",function(){
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    if(name == 'acceptOptionToday'){
    	jQuery.bmsljr();
    }else if(name == 'handleOptionToday'){
    	jQuery.bmbjjr();
    }
});
//部门受理办结本月，点击切换		author zxp
$("body").on("click",".chart-content .bmslbj-thisMonth .depart-ranking-title span",function(){
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    if(name == 'acceptOptionMonth'){
    	jQuery.bmslby();
    }else if(name == 'handleOptionMonth'){
    	jQuery.bmbjby();
    }
});
//部门受理办结本年，点击切换		author zxp
$("body").on("click",".chart-content .bmslbj-thisYear .depart-ranking-title span",function(){
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    if(name == 'acceptOptionYear'){
    	jQuery.bmslbn();
    }else if(name == 'handleOptionYear'){
    	jQuery.bmbjbn();
    }
});
//部门受理办结全部，点击切换		author zxp
$("body").on("click",".chart-content .bmslbj-all .depart-ranking-title span",function(){
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    if(name == 'acceptOptionAll'){
    	jQuery.bmslqb();
    }else if(name == 'handleOptionAll'){
    	jQuery.bmbjqb();
    }
});


$("#searchOrgName").click(function () {
    if(!clickFlag){
    	layer.msg("当前没有表格可搜索");
    	return;
	}
	//获取输入的内容
	var searchContent = $("#searContent").val();
    var table = layui.table;
    table.reload('dataGrid', {
        method: 'post'
        , where: {
            'orgName': searchContent,
        }
        , page: {
            curr: 1
        }
    });
});







//事项受理本日	author zxp
jQuery.sxslbr = function(){
	var maskToday = echarts.init(document.getElementById('mask-today'));
	var slItemNameList = [];
	var slTotalList = [];
	$.ajax({
		type:"get",
		async:true,
		url:sxslbrUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ITEM_NAME'){
						slItemNameList.push(result[i][key]);
					}else if(key == 'TOTAL'){
						slTotalList.push(result[i][key]);
					}
				}
			}
			maskToday.setOption({
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
			        data: slItemNameList,
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
			          name: '受理',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#003366'
			            }, {
			              offset: 1,
			              color: '#003366'
			            }]),
			            barBorderRadius: 5
			          },
			          data: slTotalList
			        }
			      ]
		    });
			
		},
		error:function(){
			//alert("请求失败");
		}
	
	});
}

//事项办结本日	author zxp
jQuery.sxbjbr = function(){
	var maskToday = echarts.init(document.getElementById('mask-today'));
	var bjItemNameList = [];
	var bjTotalList = [];
	$.ajax({
		type:"get",
		async:true,
		url:sxbjbrUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ITEM_NAME'){
						bjItemNameList.push(result[i][key]);
					}else if(key == 'TOTAL'){
						bjTotalList.push(result[i][key]);
					}
				}
			}
			maskToday.setOption({
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
			        data: bjItemNameList,
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
			          name: '办结',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#003366'
			            }, {
			              offset: 1,
			              color: '#003366'
			            }]),
			            barBorderRadius: 5
			          },
			          data: bjTotalList
			        }
			      ]
		    });
			
		},
		error:function(){
			//alert("请求失败");
		}
	
	});
}

//事项受理本月	author zxp
jQuery.sxslby = function(){
	var maskThisMonth = echarts.init(document.getElementById('mask-thisMonth'));
    var slbyItemNameList = [];
    var slbyTotalList = [];
    $.ajax({
		type:"get",
		async:true,
		url:sxslbyUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ITEM_NAME'){
						slbyItemNameList.push(result[i][key]);
					}else if(key == 'TOTAL'){
						slbyTotalList.push(result[i][key]);
					}
				}
			}
			maskThisMonth.setOption({
				color: ['#3dd3ba'],
			      grid: {
			        top: 20,
			        right: 0,
			        left: 10,
			        bottom: 0,
			        containLabel: true
			      },
			      tooltip: {
			        trigger: 'item',
			        position: 'right'
			      },
			      xAxis: {
			        type: 'category',
			        data: slbyItemNameList,
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
			          name: '受理',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#006699'
			            }, {
			              offset: 1,
			              color: '#006699'
			            }]),
			            barBorderRadius: 5
			          },
			          data: slbyTotalList
			        }
			      ]
		    });
		},
		error:function(){
			//alert("请求失败");
		}
	});
}

//事项办结本月	author zxp
jQuery.sxbjby = function(){
	var maskThisMonth = echarts.init(document.getElementById('mask-thisMonth'));
    var bjbyItemNameList = [];
    var bjbyTotalList = [];
    $.ajax({
		type:"get",
		async:true,
		url:sxbjbyUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ITEM_NAME'){
						bjbyItemNameList.push(result[i][key]);
					}else if(key == 'TOTAL'){
						bjbyTotalList.push(result[i][key]);
					}
				}
			}
			maskThisMonth.setOption({
				color: ['#3dd3ba'],
			      grid: {
			        top: 20,
			        right: 0,
			        left: 10,
			        bottom: 0,
			        containLabel: true
			      },
			      tooltip: {
			        trigger: 'item',
			        position: 'right'
			      },
			      xAxis: {
			        type: 'category',
			        data: bjbyItemNameList,
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
			          name: '办结',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#006699'
			            }, {
			              offset: 1,
			              color: '#006699'
			            }]),
			            barBorderRadius: 5
			          },
			          data: bjbyTotalList
			        }
			      ]
		    });
		},
		error:function(){
			//alert("请求失败");
		}
	});
}

//事项受理本年
jQuery.sxslbn = function(){
    //echarts柱形图
	var maskThisYear = echarts.init(document.getElementById('mask-thisYear'));
    var slbnItemNameList = [];
    var slbnTotalList = [];
    $.ajax({
		type:"get",
		async:true,
		url:sxslbnUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ITEM_NAME'){
						slbnItemNameList.push(result[i][key]);
					}else if(key == 'TOTAL'){
						slbnTotalList.push(result[i][key]);
					}
				}
			}
			maskThisYear.setOption({
				color: ['#3dd3ba'],
			      grid: {
			        top: 20,
			        right: 0,
			        left: 10,
			        bottom: 0,
			        containLabel: true
			      },
			      tooltip: {
			        trigger: 'item',
			        position: 'right'
			      },
			      xAxis: {
			        type: 'category',
			        data: slbnItemNameList,
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
			          name: '受理',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#4cabce'
			            }, {
			              offset: 1,
			              color: '#4cabce'
			            }]),
			            barBorderRadius: 5
			          },
			          data: slbnTotalList
			        }
			      ]
		    });
		},
		error:function(){
			//alert("请求失败");
		}
	});
}
//事项办结本年
jQuery.sxbjbn = function(){
    //echarts柱形图
	var maskThisYear = echarts.init(document.getElementById('mask-thisYear'));
    var bjbnItemNameList = [];
    var bjbnTotalList = [];
    $.ajax({
		type:"get",
		async:true,
		url:sxbjbnUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ITEM_NAME'){
						bjbnItemNameList.push(result[i][key]);
					}else if(key == 'TOTAL'){
						bjbnTotalList.push(result[i][key]);
					}
				}
			}
			maskThisYear.setOption({
				color: ['#3dd3ba'],
			      grid: {
			        top: 20,
			        right: 0,
			        left: 10,
			        bottom: 0,
			        containLabel: true
			      },
			      tooltip: {
			        trigger: 'item',
			        position: 'right'
			      },
			      xAxis: {
			        type: 'category',
			        data: bjbnItemNameList,
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
			          name: '办结',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#4cabce'
			            }, {
			              offset: 1,
			              color: '#4cabce'
			            }]),
			            barBorderRadius: 5
			          },
			          data: bjbnTotalList
			        }
			      ]
		    });
		},
		error:function(){
			//alert("请求失败");
		}
	});
}

//事项受理全部
jQuery.sxslqb = function(){
    //echarts柱形图
	var maskAll = echarts.init(document.getElementById('mask-all'));
    var slqbItemNameList = [];
    var slqbTotalList = [];
    $.ajax({
		type:"get",
		async:true,
		url:sxslqbUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ITEM_NAME'){
						slqbItemNameList.push(result[i][key]);
					}else if(key == 'TOTAL'){
						slqbTotalList.push(result[i][key]);
					}
				}
			}
			maskAll.setOption({
				color: ['#3dd3ba'],
			      grid: {
			        top: 20,
			        right: 0,
			        left: 10,
			        bottom: 0,
			        containLabel: true
			      },
			      tooltip: {
			        trigger: 'item',
			        position: 'left'
			      },
			      xAxis: {
			        type: 'category',
			        data: slqbItemNameList,
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
			          name: '受理',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#e5323e'
			            }, {
			              offset: 1,
			              color: '#e5323e'
			            }]),
			            barBorderRadius: 5
			          },
			          data: slqbTotalList
			        }
			      ]
		    });
		},
		error:function(){
			//alert("请求失败");
		}
	});
}

//事项办结全部
jQuery.sxbjqb = function(){
    //echarts柱形图
	var maskAll = echarts.init(document.getElementById('mask-all'));
    var slbjItemNameList = [];
    var slbjTotalList = [];
    $.ajax({
		type:"get",
		async:true,
		url:sxbjqbUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ITEM_NAME'){
						slbjItemNameList.push(result[i][key]);
					}else if(key == 'TOTAL'){
						slbjTotalList.push(result[i][key]);
					}
				}
			}
			maskAll.setOption({
				color: ['#3dd3ba'],
			      grid: {
			        top: 20,
			        right: 0,
			        left: 10,
			        bottom: 0,
			        containLabel: true
			      },
			      tooltip: {
			        trigger: 'item',
			        position: 'left'
			      },
			      xAxis: {
			        type: 'category',
			        data: slbjItemNameList,
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
			          name: '办结',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#e5323e'
			            }, {
			              offset: 1,
			              color: '#e5323e'
			            }]),
			            barBorderRadius: 5
			          },
			          data: slbjTotalList
			        }
			      ]
		    });
		},
		error:function(){
			//alert("请求失败");
		}
	});
}

//事项受理办结表格的方法渲染JS事件 author zxp	修改
jQuery.sxslbjTableJS = function(){
	var table = layui.table;
	//执行渲染
	table.render({
	   elem: '#sxslbjTable' //指定原始表格
	  ,height: 510 //容器高度
	  ,url: sxbmslbjTableDataUrl //异步数据接口	修改
	  ,cols: [
	       [	
				{field: 'ORG_NAME', title: '单位', rowspan:2,align:'center'}
			   ,{field: 'ITEM_NAME', title: '事项', rowspan:2,align:'center'}
			   ,{field: '', title: '今日', colspan:2,align:'center'}
			   ,{field: '', title: '本月', colspan:2,align:'center'}
			   ,{field: '', title: '本年', colspan:2,align:'center'}
			   ,{field: 'SUBMIT_TIME', title: '最后回传时间',align:'center', rowspan:2,
				   templet:function (d) {
					   return formatDateAll(d.SUBMIT_TIME);
				   }
				}
	       ],
	       [
				 {field: 'JRSL', title: '受理', event:'JRSL',align:'center'}
				,{field: 'JRBJ', title: '办结', event:'JRBJ',align:'center'}
				,{field: 'BYSL', title: '受理', event:'BYSL',align:'center'}
				,{field: 'BYBJ', title: '办结', event:'BYBJ',align:'center'}
				,{field: 'BNSL', title: '受理', event:'BNSL',align:'center'}
				,{field: 'BNBJ', title: '办结', event:'BNBJ',align:'center'}
	       ]
	  ]
    ,page: true
    ,limit: 10
    ,limits: [10]
	});
	//监听单元格事件	 author zxp
    table.on('tool(sxslbjTable)', function(obj){
    	var data = obj.data;
    	var tr = obj.tr;
		if(obj.event === 'JRSL'){
	        layer.open({
	            type: 2,
	            title: "详细信息",
	            skin:'p_window',
	            shade: [0.8, '#393D49'],
	            area: ['1200px', '600px'],
	            content: toThirdPageUrl+"?orgCode="+data.ORG_CODE
	            					   +"&orgName="+data.ORG_NAME
	            					   +"&itemName="+data.ITEM_NAME
	            					   +"&selectType=JRSL"
	            
	        });
		}else if(obj.event === 'JRBJ'){
			layer.open({
	            type: 2,
	            title: "详细信息",
	            skin:'p_window',
	            shade: [0.8, '#393D49'],
	            area: ['1200px', '600px'],
	            content: toThirdPageUrl+"?orgCode="+data.ORG_CODE
	            					   +"&orgName="+data.ORG_NAME
	            					   +"&itemName="+data.ITEM_NAME
	            					   +"&selectType=JRBJ"
	            
	        });
		}else if(obj.event === 'BYSL'){
			layer.open({
	            type: 2,
	            title: "详细信息",
	            skin:'p_window',
	            shade: [0.8, '#393D49'],
	            area: ['1200px', '600px'],
	            content: toThirdPageUrl+"?orgCode="+data.ORG_CODE
	            					   +"&orgName="+data.ORG_NAME
	            					   +"&itemName="+data.ITEM_NAME
	            					   +"&selectType=BYSL"
	            
	        });
		}else if(obj.event === 'BYBJ'){
			layer.open({
	            type: 2,
	            title: "详细信息",
	            skin:'p_window',
	            shade: [0.8, '#393D49'],
	            area: ['1200px', '600px'],
	            content: toThirdPageUrl+"?orgCode="+data.ORG_CODE
	            					   +"&orgName="+data.ORG_NAME
	            					   +"&itemName="+data.ITEM_NAME
	            					   +"&selectType=BYBJ"
	            
	        });
		}else if(obj.event === 'BNSL'){
			layer.open({
	            type: 2,
	            title: "详细信息",
	            skin:'p_window',
	            shade: [0.8, '#393D49'],
	            area: ['1200px', '600px'],
	            content: toThirdPageUrl+"?orgCode="+data.ORG_CODE
	            					   +"&orgName="+data.ORG_NAME
	            					   +"&itemName="+data.ITEM_NAME
	            					   +"&selectType=BNSL"
	            
	        });
		}else if(obj.event === 'BNBJ'){
			layer.open({
	            type: 2,
	            title: "详细信息",
	            skin:'p_window',
	            shade: [0.8, '#393D49'],
	            area: ['1200px', '600px'],
	            content: toThirdPageUrl+"?orgCode="+data.ORG_CODE
	            					   +"&orgName="+data.ORG_NAME
	            					   +"&itemName="+data.ITEM_NAME
	            					   +"&selectType=BNBJ"
	            
	        });
		}
    });
}

/*部门受理办结数据表格start 新增 author zxp*/
jQuery.bmslbjTableJS = function(){
	var table = layui.table;
	//执行渲染
	table.render({
	   elem: '#bmslbjTable' //指定原始表格
	  ,height: 510 //容器高度
	  ,url: sxbmslbjTableDataUrl //异步数据接口	修改
	  ,cols: [
	       [	
				{field: 'ORG_NAME', title: '单位', rowspan:2,align:'center'}
			   ,{field: 'ITEM_NAME', title: '事项', rowspan:2,align:'center'}
			   ,{field: '', title: '今日', colspan:2,align:'center'}
			   ,{field: '', title: '本月', colspan:2,align:'center'}
			   ,{field: '', title: '本年', colspan:2,align:'center'}
			   ,{field: 'SUBMIT_TIME', title: '最后回传时间',align:'center', rowspan:2,
				   templet:function (d) {
					   return formatDateAll(d.SUBMIT_TIME);
				   }
				}
	       ],
	       [
				 {field: 'JRSL', title: '受理', event:'JRSL',align:'center'}
				,{field: 'JRBJ', title: '办结', event:'JRBJ',align:'center'}
				,{field: 'BYSL', title: '受理', event:'BYSL',align:'center'}
				,{field: 'BYBJ', title: '办结', event:'BYBJ',align:'center'}
				,{field: 'BNSL', title: '受理', event:'BNSL',align:'center'}
				,{field: 'BNBJ', title: '办结', event:'BNBJ',align:'center'}
	       ]
	  ]
    ,page: true
    ,limit: 10
    ,limits: [10]
	});
	//监听单元格事件	 author zxp
    table.on('tool(bmslbjTable)', function(obj){
    	var data = obj.data;
    	var tr = obj.tr;
		if(obj.event === 'JRSL'){
	        layer.open({
	            type: 2,
	            title: "详细信息",
	            skin:'p_window',
	            shade: [0.8, '#393D49'],
	            area: ['1200px', '600px'],
	            content: toThirdPageUrl+"?orgCode="+data.ORG_CODE
	            					   +"&orgName="+data.ORG_NAME
	            					   +"&itemName="+data.ITEM_NAME
	            					   +"&selectType=JRSL"
	            
	        });
		}else if(obj.event === 'JRBJ'){
			layer.open({
	            type: 2,
	            title: "详细信息",
	            skin:'p_window',
	            shade: [0.8, '#393D49'],
	            area: ['1200px', '600px'],
	            content: toThirdPageUrl+"?orgCode="+data.ORG_CODE
	            					   +"&orgName="+data.ORG_NAME
	            					   +"&itemName="+data.ITEM_NAME
	            					   +"&selectType=JRBJ"
	            
	        });
		}else if(obj.event === 'BYSL'){
			layer.open({
	            type: 2,
	            title: "详细信息",
	            skin:'p_window',
	            shade: [0.8, '#393D49'],
	            area: ['1200px', '600px'],
	            content: toThirdPageUrl+"?orgCode="+data.ORG_CODE
	            					   +"&orgName="+data.ORG_NAME
	            					   +"&itemName="+data.ITEM_NAME
	            					   +"&selectType=BYSL"
	            
	        });
		}else if(obj.event === 'BYBJ'){
			layer.open({
	            type: 2,
	            title: "详细信息",
	            skin:'p_window',
	            shade: [0.8, '#393D49'],
	            area: ['1200px', '600px'],
	            content: toThirdPageUrl+"?orgCode="+data.ORG_CODE
	            					   +"&orgName="+data.ORG_NAME
	            					   +"&itemName="+data.ITEM_NAME
	            					   +"&selectType=BYBJ"
	            
	        });
		}else if(obj.event === 'BNSL'){
			layer.open({
	            type: 2,
	            title: "详细信息",
	            skin:'p_window',
	            shade: [0.8, '#393D49'],
	            area: ['1200px', '600px'],
	            content: toThirdPageUrl+"?orgCode="+data.ORG_CODE
	            					   +"&orgName="+data.ORG_NAME
	            					   +"&itemName="+data.ITEM_NAME
	            					   +"&selectType=BNSL"
	            
	        });
		}else if(obj.event === 'BNBJ'){
			layer.open({
	            type: 2,
	            title: "详细信息",
	            skin:'p_window',
	            shade: [0.8, '#393D49'],
	            area: ['1200px', '600px'],
	            content: toThirdPageUrl+"?orgCode="+data.ORG_CODE
	            					   +"&orgName="+data.ORG_NAME
	            					   +"&itemName="+data.ITEM_NAME
	            					   +"&selectType=BNBJ"
	            
	        });
		}
    });
	
}
/*部门受理办结数据表格end author zxp*/

/*部门受理办结，点击更多显示的弹出框，顶部echarts图 新增 start	author zxp*/
//部门受理今日
jQuery.bmsljr = function(){
	var maskToday = echarts.init(document.getElementById('bmslbj-mask-today'));
	var sljrOrgName = [];
	var sljrTotal = [];
	$.ajax({
		type:"get",
		async:true,
		url:bmsljrUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ORG_NAME'){
						sljrOrgName.push(result[i][key]);
					}else if(key == 'TOTAL'){
						sljrTotal.push(result[i][key]);
					}
				}
			}
			maskToday.setOption({
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
			        data: sljrOrgName,
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
			          name: '受理',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#003366'
			            }, {
			              offset: 1,
			              color: '#003366'
			            }]),
			            barBorderRadius: 5
			          },
			          data: sljrTotal
			        }
			      ]
		    });
			
		},
		error:function(){
			//alert("请求失败");
		}
	
	});
}
//部门办结今日
jQuery.bmbjjr = function(){
	var maskToday = echarts.init(document.getElementById('bmslbj-mask-today'));
	var bjjrOrgName = [];
	var bjjrTotal = [];
	$.ajax({
		type:"get",
		async:true,
		url:bmbjjrUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ORG_NAME'){
						bjjrOrgName.push(result[i][key]);
					}else if(key == 'TOTAL'){
						bjjrTotal.push(result[i][key]);
					}
				}
			}
			maskToday.setOption({
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
			        data: bjjrOrgName,
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
			          name: '办结',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#003366'
			            }, {
			              offset: 1,
			              color: '#003366'
			            }]),
			            barBorderRadius: 5
			          },
			          data: bjjrTotal
			        }
			      ]
		    });
			
		},
		error:function(){
			//alert("请求失败");
		}
	});
}
//部门受理本月
jQuery.bmslby = function(){
	var maskThisMonth = echarts.init(document.getElementById('bmslbj-mask-thisMonth'));
  var slbyOrgName = [];
  var slbyTotal = [];
  $.ajax({
		type:"get",
		async:true,
		url:bmslbyUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ORG_NAME'){
						slbyOrgName.push(result[i][key]);
					}else if(key == 'TOTAL'){
						slbyTotal.push(result[i][key]);
					}
				}
			}
			maskThisMonth.setOption({
				color: ['#3dd3ba'],
			      grid: {
			        top: 20,
			        right: 0,
			        left: 10,
			        bottom: 0,
			        containLabel: true
			      },
			      tooltip: {
			        trigger: 'item',
			        position: 'right'
			      },
			      xAxis: {
			        type: 'category',
			        data: slbyOrgName,
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
			          name: '受理',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#006699'
			            }, {
			              offset: 1,
			              color: '#006699'
			            }]),
			            barBorderRadius: 5
			          },
			          data: slbyTotal
			        }
			      ]
		    });
		},
		error:function(){
			//alert("请求失败");
		}
	});
}

//部门办结本月
jQuery.bmbjby = function(){
	var maskThisMonth = echarts.init(document.getElementById('bmslbj-mask-thisMonth'));
  var bjbyOrgName = [];
  var bjbyTotal = [];
  $.ajax({
		type:"get",
		async:true,
		url:bmbjbyUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ORG_NAME'){
						bjbyOrgName.push(result[i][key]);
					}else if(key == 'TOTAL'){
						bjbyTotal.push(result[i][key]);
					}
				}
			}
			maskThisMonth.setOption({
				color: ['#3dd3ba'],
			      grid: {
			        top: 20,
			        right: 0,
			        left: 10,
			        bottom: 0,
			        containLabel: true
			      },
			      tooltip: {
			        trigger: 'item',
			        position: 'right'
			      },
			      xAxis: {
			        type: 'category',
			        data: bjbyOrgName,
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
			          name: '办结',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#006699'
			            }, {
			              offset: 1,
			              color: '#006699'
			            }]),
			            barBorderRadius: 5
			          },
			          data: bjbyTotal
			        }
			      ]
		    });
		},
		error:function(){
			//alert("请求失败");
		}
	});
}

//部门受理本年
jQuery.bmslbn = function(){
	var maskThisYear = echarts.init(document.getElementById('bmslbj-mask-thisYear'));
  var slbnOrgName = [];
  var slbnTotal = [];
  $.ajax({
		type:"get",
		async:true,
		url:bmslbnUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ORG_NAME'){
						slbnOrgName.push(result[i][key]);
					}else if(key == 'TOTAL'){
						slbnTotal.push(result[i][key]);
					}
				}
			}
			maskThisYear.setOption({
				color: ['#3dd3ba'],
			      grid: {
			        top: 20,
			        right: 0,
			        left: 10,
			        bottom: 0,
			        containLabel: true
			      },
			      tooltip: {
			        trigger: 'item',
			        position: 'right'
			      },
			      xAxis: {
			        type: 'category',
			        data: slbnOrgName,
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
			          name: '受理',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#4cabce'
			            }, {
			              offset: 1,
			              color: '#4cabce'
			            }]),
			            barBorderRadius: 5
			          },
			          data: slbnTotal
			        }
			      ]
		    });
		},
		error:function(){
			//alert("请求失败");
		}
	});
}
//部门办结本年
jQuery.bmbjbn = function(){
	var maskThisYear = echarts.init(document.getElementById('bmslbj-mask-thisYear'));
  var bjbnOrgName = [];
  var bjbnTotal = [];
  $.ajax({
		type:"get",
		async:true,
		url:bmbjbnUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ORG_NAME'){
						bjbnOrgName.push(result[i][key]);
					}else if(key == 'TOTAL'){
						bjbnTotal.push(result[i][key]);
					}
				}
			}
			maskThisYear.setOption({
				color: ['#3dd3ba'],
			      grid: {
			        top: 20,
			        right: 0,
			        left: 10,
			        bottom: 0,
			        containLabel: true
			      },
			      tooltip: {
			        trigger: 'item',
			        position: 'right'
			      },
			      xAxis: {
			        type: 'category',
			        data: bjbnOrgName,
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
			          name: '办结',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#4cabce'
			            }, {
			              offset: 1,
			              color: '#4cabce'
			            }]),
			            barBorderRadius: 5
			          },
			          data: bjbnTotal
			        }
			      ]
		    });
		},
		error:function(){
			//alert("请求失败");
		}
	});
}

//部门受理全部
jQuery.bmslqb = function(){
	var maskAll = echarts.init(document.getElementById('bmslbj-mask-all'));
  var slqbOrgName = [];
  var slqbTotal = [];
  $.ajax({
		type:"get",
		async:true,
		url:bmslqbUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ORG_NAME'){
						slqbOrgName.push(result[i][key]);
					}else if(key == 'TOTAL'){
						slqbTotal.push(result[i][key]);
					}
				}
			}
			maskAll.setOption({
				color: ['#3dd3ba'],
			      grid: {
			        top: 20,
			        right: 0,
			        left: 10,
			        bottom: 0,
			        containLabel: true
			      },
			      tooltip: {
			        trigger: 'item',
			        position: 'left'
			      },
			      xAxis: {
			        type: 'category',
			        data: slqbOrgName,
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
			          name: '受理',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#e5323e'
			            }, {
			              offset: 1,
			              color: '#e5323e'
			            }]),
			            barBorderRadius: 5
			          },
			          data: slqbTotal
			        }
			      ]
		    });
		},
		error:function(){
			//alert("请求失败");
		}
	});
}

//部门办结全部
jQuery.bmbjqb = function(){
	var maskAll = echarts.init(document.getElementById('bmslbj-mask-all'));
  var bjqbOrgList = [];
  var bjqbTotal = [];
  $.ajax({
		type:"get",
		async:true,
		url:bmbjqbUrl,
		dataType:"json",
		success:function(result){
			for(var i=0;i<result.length;i++){
				for(var key in result[i]){
					if(key == 'ORG_NAME'){
						bjqbOrgList.push(result[i][key]);
					}else if(key == 'TOTAL'){
						bjqbTotal.push(result[i][key]);
					}
				}
			}
			maskAll.setOption({
				color: ['#3dd3ba'],
			      grid: {
			        top: 20,
			        right: 0,
			        left: 10,
			        bottom: 0,
			        containLabel: true
			      },
			      tooltip: {
			        trigger: 'item',
			        position: 'left'
			      },
			      xAxis: {
			        type: 'category',
			        data: bjqbOrgList,
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
			          name: '办结',
			          type: 'bar',
			          barWidth: 10,
			          itemStyle: {
			            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
			              offset: 0,
			              color: '#e5323e'
			            }, {
			              offset: 1,
			              color: '#e5323e'
			            }]),
			            barBorderRadius: 5
			          },
			          data: bjqbTotal
			        }
			      ]
		    });
		},
		error:function(){
			//alert("请求失败");
		}
	});
}
/*部门受理办结，点击更多显示的弹出框，顶部echarts图end	author zxp*/

//start-xlm-业务办理变化趋势
jQuery.org_list = function() {
	layui.use('table', function() {
		var table = layui.table;
		table.render({
			elem : '#table_org_list',
			url : orgListUrl,
            width:460,
            height:665,
			cols : [[
                {field : 'ID',width : 100,title : '序号'},
			    {field : 'ORG_NAME',width : 380,title : '部门名称'}

			]],
			page: true
		    ,even: true
		    ,limit: 15
		    ,limits: [15]
		});
		//监听行单击事件
		  table.on('row(table_org_list)', function(obj){
		    var data = obj.data;
		    var org_code = data.ORG_CODE;
		    var org_name = data.ORG_NAME;
		    $("#org_name").html(org_name);

		    inittrend(org_code);
	    	
	    	jQuery.day_online(org_code);
	    	jQuery.month_online(org_code);
	    	jQuery.year_online(org_code);
	    	
	    	jQuery.day_offline(org_code);
	    	jQuery.month_offline(org_code);
	    	jQuery.year_offline(org_code);
	    	
		    //标注选中样式
		    obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		  });
	});
}

$("#search2").click(function () {
    //获取输入的内容
    var searchContent = $("#searchOrgName2").val();
    var table = layui.table;
    table.reload('table_org_list', {
        method: 'post'
        , where: {
            'orgName': searchContent,
        }
        , page: {
            curr: 1
        }
    });
});


//初始化
function inittrend(org_code){
	//alert("org_code="+org_code);
	var pro_day1 = echarts.init(document.getElementById('pro_day_online'));
	var pro_month1 = echarts.init(document.getElementById('pro_month_online'));
	var pro_year1 = echarts.init(document.getElementById('pro_year_online'));
	
	var pro_day2 = echarts.init(document.getElementById('pro_day_offline'));
	var pro_month2 = echarts.init(document.getElementById('pro_month_offline'));
	var pro_year2 = echarts.init(document.getElementById('pro_year_offline'));

	jQuery.day_online = function(org_code){
		$.ajax({
			type : "post",
		    async : true,   
			url:onlineUrlDay,
			data:{"org_code":org_code},
			success:function(result){
			//	alert("day_online_accept.length="+result.day_online_accept.length);
				var slsjList = result.slsjList;
				var bjsjList = result.bjsjList;
				var xsslList = result.xsslList;
				var xsbjList = result.xsbjList;
				var drslzl = result.drslzl;
				var drbjzl = result.drbjzl;
				/*for(var i=0;i<result.day_online_accept.length;i++){
					for(var key in result.day_online_accept[i]){
						if(key == 'SJ'){
							slsjList.push(result.day_online_accept[i][key]);
						}else if(key == 'SXSL'){
							xsslList.push(result.day_online_accept[i][key]);
						}
					}
				}  
				
				for(var i=0;i<result.day_online_finish.length;i++){
					for(var key in result.day_online_finish[i]){
						if(key == 'SJ'){
							bjsjList.push(result.day_online_finish[i][key]);
						}else if(key == 'SXSL'){
							xsbjList.push(result.day_online_finish[i][key]);
						}
					}
				}  
				
				for(var i=0;i<xsslList.length;i++){
					drslzl+=xsslList[i];
				}
				for(var i=0;i<xsbjList.length;i++){
					drbjzl+=xsbjList[i];
				}*/
				if(xsslList.length > 0 || xsbjList.length > 0){
					pro_day1.setOption({
						grid: {
						      top: 30,
						      left: 0,
						      right: 0,
						      bottom: 0,
						      containLabel: true
						    },
						    xAxis: {
						      type: 'category',
						      data: slsjList,
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
						      data: ['受理', '办结'],
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
						      name: '受理',
						      data: xsslList,
						      color: '#0094fb',
						    },{
						      type: 'line',
						      name: '办结',
						      data: xsbjList,
						      color: '#ddb401',
						    }]
					});
				}
				
			}
		});
	}
	
	jQuery.day_offline = function(org_code){
		$.ajax({
			type : "post",
			async : true,   
			url:offlineUrlDay,
			data:{"org_code":org_code},
			success:function(result){
				//	alert("day_online_accept.length="+result.day_online_accept.length);
				var slsjList = [];
				var bjsjList = [];
				var xsslList = [];
				var xsbjList = [];
				var drslzl = 0;
				var drbjzl = 0;
				for(var i=0;i<result.day_offline_accept.length;i++){
					for(var key in result.day_offline_accept[i]){
						if(key == 'SJ'){
							slsjList.push(result.day_offline_accept[i][key]);
						}else if(key == 'SXSL'){
							xsslList.push(result.day_offline_accept[i][key]);
						}
					}
				}  
				
				for(var i=0;i<result.day_offline_finish.length;i++){
					for(var key in result.day_offline_finish[i]){
						if(key == 'SJ'){
							bjsjList.push(result.day_offline_finish[i][key]);
						}else if(key == 'SXSL'){
							xsbjList.push(result.day_offline_finish[i][key]);
						}
					}
				}  
				
				for(var i=0;i<xsslList.length;i++){
					drslzl+=xsslList[i];
				}
				for(var i=0;i<xsbjList.length;i++){
					drbjzl+=xsbjList[i];
				}
				pro_day2.setOption({
					grid: {
						top: 30,
						left: 0,
						right: 0,
						bottom: 0,
						containLabel: true
					},
					xAxis: {
						type: 'category',
						data: slsjList,
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
						data: ['受理', '办结'],
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
						name: '受理',
						data: xsslList,
						color: '#0094fb',
					},{
						type: 'line',
						name: '办结',
						data: xsbjList,
						color: '#ddb401',
					}]
				});
			}
		});
	}
	
	jQuery.month_online = function(org_code){
		$.ajax({
			type : "post",
			async : true,   
			url:onlineUrlMonth,
			data:{"org_code":org_code},
			success:function(result){
				//	alert("day_online_accept.length="+result.day_online_accept.length);
				var slsjList = [];
				var bjsjList = [];
				var xsslList = [];
				var xsbjList = [];
				var drslzl = 0;
				var drbjzl = 0;
				for(var i=0;i<result.month_online_accept.length;i++){
					for(var key in result.month_online_accept[i]){
						if(key == 'SJ'){
							slsjList.push(result.month_online_accept[i][key]);
						}else if(key == 'SXSL'){
							xsslList.push(result.month_online_accept[i][key]);
						}
					}
				}  
				
				for(var i=0;i<result.month_online_finish.length;i++){
					for(var key in result.month_online_finish[i]){
						if(key == 'SJ'){
							bjsjList.push(result.month_online_finish[i][key]);
						}else if(key == 'SXSL'){
							xsbjList.push(result.month_online_finish[i][key]);
						}
					}
				}  
				
				for(var i=0;i<xsslList.length;i++){
					drslzl+=xsslList[i];
				}
				for(var i=0;i<xsbjList.length;i++){
					drbjzl+=xsbjList[i];
				}
				pro_month1.setOption({
					grid: {
						top: 30,
						left: 0,
						right: 0,
						bottom: 0,
						containLabel: true
					},
					xAxis: {
						type: 'category',
						data: slsjList,
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
						data: ['受理', '办结'],
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
						name: '受理',
						data: xsslList,
						color: '#0094fb',
					},{
						type: 'line',
						name: '办结',
						data: xsbjList,
						color: '#ddb401',
					}]
				});
			}
		});
	}
	
	jQuery.month_offline = function(org_code){
		$.ajax({
			type : "post",
			async : true,   
			url:offlineUrlMonth,
			data:{"org_code":org_code},
			success:function(result){
				//	alert("day_online_accept.length="+result.day_online_accept.length);
				var slsjList = [];
				var bjsjList = [];
				var xsslList = [];
				var xsbjList = [];
				var drslzl = 0;
				var drbjzl = 0;
				for(var i=0;i<result.month_offline_accept.length;i++){
					for(var key in result.month_offline_accept[i]){
						if(key == 'SJ'){
							slsjList.push(result.month_offline_accept[i][key]);
						}else if(key == 'SXSL'){
							xsslList.push(result.month_offline_accept[i][key]);
						}
					}
				}  
				
				for(var i=0;i<result.month_offline_finish.length;i++){
					for(var key in result.month_offline_finish[i]){
						if(key == 'SJ'){
							bjsjList.push(result.month_offline_finish[i][key]);
						}else if(key == 'SXSL'){
							xsbjList.push(result.month_offline_finish[i][key]);
						}
					}
				}  
				
				for(var i=0;i<xsslList.length;i++){
					drslzl+=xsslList[i];
				}
				for(var i=0;i<xsbjList.length;i++){
					drbjzl+=xsbjList[i];
				}
				pro_month2.setOption({
					grid: {
						top: 30,
						left: 0,
						right: 0,
						bottom: 0,
						containLabel: true
					},
					xAxis: {
						type: 'category',
						data: slsjList,
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
						data: ['受理', '办结'],
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
						name: '受理',
						data: xsslList,
						color: '#0094fb',
					},{
						type: 'line',
						name: '办结',
						data: xsbjList,
						color: '#ddb401',
					}]
				});
			}
		});
	}
	
	jQuery.year_online = function(org_code){
		$.ajax({
			type : "post",
			async : true,   
			url:onlineUrlYear,
			data:{"org_code":org_code},
			success:function(result){
				//	alert("day_online_accept.length="+result.day_online_accept.length);
				var slsjList = [];
				var bjsjList = [];
				var xsslList = [];
				var xsbjList = [];
				var drslzl = 0;
				var drbjzl = 0;
				for(var i=0;i<result.year_online_accept.length;i++){
					for(var key in result.year_online_accept[i]){
						if(key == 'SJ'){
							slsjList.push(result.year_online_accept[i][key]);
						}else if(key == 'SXSL'){
							xsslList.push(result.year_online_accept[i][key]);
						}
					}
				}  
				
				for(var i=0;i<result.year_online_finish.length;i++){
					for(var key in result.year_online_finish[i]){
						if(key == 'SJ'){
							bjsjList.push(result.year_online_finish[i][key]);
						}else if(key == 'SXSL'){
							xsbjList.push(result.year_online_finish[i][key]);
						}
					}
				}  
				
				for(var i=0;i<xsslList.length;i++){
					drslzl+=xsslList[i];
				}
				for(var i=0;i<xsbjList.length;i++){
					drbjzl+=xsbjList[i];
				}
				pro_year1.setOption({
					grid: {
						top: 30,
						left: 0,
						right: 0,
						bottom: 0,
						containLabel: true
					},
					xAxis: {
						type: 'category',
						data: slsjList,
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
						data: ['受理', '办结'],
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
						name: '受理',
						data: xsslList,
						color: '#0094fb',
					},{
						type: 'line',
						name: '办结',
						data: xsbjList,
						color: '#ddb401',
					}]
				});
			}
		});
	}
	
	jQuery.year_offline = function(org_code){
		$.ajax({
			type : "post",
			async : true,   
			url:offlineUrlYear,
			data:{"org_code":org_code},
			success:function(result){
				//	alert("day_online_accept.length="+result.day_online_accept.length);
				var slsjList = [];
				var bjsjList = [];
				var xsslList = [];
				var xsbjList = [];
				var drslzl = 0;
				var drbjzl = 0;
				for(var i=0;i<result.year_offline_accept.length;i++){
					for(var key in result.year_offline_accept[i]){
						if(key == 'SJ'){
							slsjList.push(result.year_offline_accept[i][key]);
						}else if(key == 'SXSL'){
							xsslList.push(result.year_offline_accept[i][key]);
						}
					}
				}  
				
				for(var i=0;i<result.year_offline_finish.length;i++){
					for(var key in result.year_offline_finish[i]){
						if(key == 'SJ'){
							bjsjList.push(result.year_offline_finish[i][key]);
						}else if(key == 'SXSL'){
							xsbjList.push(result.year_offline_finish[i][key]);
						}
					}
				}  
				
				for(var i=0;i<xsslList.length;i++){
					drslzl+=xsslList[i];
				}
				for(var i=0;i<xsbjList.length;i++){
					drbjzl+=xsbjList[i];
				}
				pro_year2.setOption({
					grid: {
						top: 30,
						left: 0,
						right: 0,
						bottom: 0,
						containLabel: true
					},
					xAxis: {
						type: 'category',
						data: slsjList,
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
						data: ['受理', '办结'],
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
						name: '受理',
						data: xsslList,
						color: '#0094fb',
					},{
						type: 'line',
						name: '办结',
						data: xsbjList,
						color: '#ddb401',
					}]
				});
			}
		});
	}
}
//end-xlm-业务办理变化趋势

function initNicScroll(){
      $('.table-content').niceScroll({
      cursoropacitymin: 0,
      cursorcolor:"#0d57ab",
      cursorborder: '#0d57ab'
    });
    $('.table-content').getNiceScroll().resize();
}

/* 事项总览 */
jQuery.sxzl();
/* 可网上办理事项 */
jQuery.xsblsx();
/* 不可网上办理事项 */
jQuery.xxblsx();

jQuery.xxdrblcs();
jQuery.xsdrblcs();
jQuery.bmslpm();
jQuery.sxxz();
jQuery.xsjb();


jQuery.sxslqsmcy();
jQuery.bmyjhuangpai();
jQuery.bmyjhongpai();


//点击更多显示弹出框
$("body").on("click",".dialog",function () {
    var target = $(this).attr('data-target');
    $(".box[data-target='"+target+"']").siblings().removeClass('active');
    $(".box[data-target='"+target+"']").addClass('active');
    switch (target) {
        case 'sxzlbox':
        	//事项总览弹出框
            $(".mask-panel .box .panel-header a").removeClass('sxzlactive');
            //默认加载全部事项
            $("#qbsx").addClass('sxzlactive');
            jQuery.szbmsxgszzt('qbsx','','');
            jQuery.qxbmsxgszzt('qbsx','','');
            jQuery.szbmsxgsbzt('qbsx','','');
            jQuery.qxbmsxgsbzt('qbsx','','');
            jQuery.sxxzChart('qbsx','','');

            break;
        case 'sxxzbox':
            $(".depart-ranking-title").find("[name='acceptOption']").addClass('active').siblings().removeClass('active');
            initsxxztck();
            jQuery.sxxzdrxsslbjywsl();
            jQuery.sxxzdyxsslbjywsl();
            jQuery.sxxzdnxsslbjywsl();
            jQuery.sxxzxsslbjywzsl();
            //事项性质内页原先表格
            //jQuery.sxxzTable();
            //事项性质内页办件量表格
            jQuery.bjlTable();
            break;
        case 'bmyjpmbox':

            break;

        case 'sxsltoptenbox':
            //事项受理办结 start	author zxp
            $(".box .chart-content .today .depart-ranking-title span").siblings().removeClass('active');
            $(".box .chart-content .today .depart-ranking-title .acceptOptionToday").addClass('active');
            jQuery.sxslbr();

            $(".box .chart-content .thisMonth .depart-ranking-title span").siblings().removeClass('active');
            $(".box .chart-content .thisMonth .depart-ranking-title .acceptOptionMonth").addClass('active');
            jQuery.sxslby();

            $(".box .chart-content .thisYear .depart-ranking-title span").siblings().removeClass('active');
            $(".box .chart-content .thisYear .depart-ranking-title .acceptOptionYear").addClass('active');
            jQuery.sxslbn();

            $(".box .chart-content .all .depart-ranking-title span").siblings().removeClass('active');
            $(".box .chart-content .all .depart-ranking-title .acceptOptionAll").addClass('active');
            jQuery.sxslqb();

            jQuery.sxslbjTableJS();
            //事项受理	end	author zxp
            break;
        case 'bmslbjbox':
            //部门受理办结排名	start author zxp
            $(".box .chart-content .bmslbj-today .depart-ranking-title span").siblings().removeClass('active');
            $(".box .chart-content .bmslbj-today .depart-ranking-title .acceptOptionToday").addClass('active');
            jQuery.bmsljr();

            $(".box .chart-content .bmslbj-thisMonth .depart-ranking-title span").siblings().removeClass('active');
            $(".box .chart-content .bmslbj-thisMonth .depart-ranking-title .acceptOptionMonth").addClass('active');
            jQuery.bmslby();

            $(".box .chart-content .bmslbj-thisYear .depart-ranking-title span").siblings().removeClass('active');
            $(".box .chart-content .bmslbj-thisYear .depart-ranking-title .acceptOptionYear").addClass('active');
            jQuery.bmslbn();

            $(".box .chart-content .bmslbj-all .depart-ranking-title span").siblings().removeClass('active');
            $(".box .chart-content .bmslbj-all .depart-ranking-title .acceptOptionAll").addClass('active');
            jQuery.bmslqb();

            //部门受理办结数据表格
            jQuery.bmslbjTableJS();
            //部门受理办结排名	end author zxp
            break;
        //start-xlm-业务办理变化趋势
        case 'trend_box':
            //zzzz
            $(".depart-ranking-title").find("[name='acceptOption']").addClass('active').siblings().removeClass('active');
            jQuery.org_list();
            inittrend();

            jQuery.day_online();
            jQuery.month_online();
            jQuery.year_online();

            jQuery.day_offline();
            jQuery.month_offline();
            jQuery.year_offline();

            break;
        //end-xlm-业务办理变化趋势
    }
    $(".mask-panel").addClass('active');
});
//点击关闭按钮关闭弹出框
$("body").on("click",".close-btn",function () {
    $(this).parents('.mask-panel').removeClass('active');
});