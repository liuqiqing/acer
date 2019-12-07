//登记单位数
var djdwsUrl = ctx + '/libIndexController/djdws';
//证照目录
var zzmlUrl = ctx + '/libIndexController/zzml';
//按照目录统计
var amltjUrl = ctx + '/libIndexController/amltj';
//证照数据与未签章数据
var zzsjywqzsjUrl = ctx + '/libIndexController/zzsjywqzsj';
//证照模版统计-按主题统计
var zzmbtjazttjUrl = ctx + '/libIndexController/zzmbtjazttj';
//证照统计表格数据
var zztjTableDataUrl = ctx + '/libIndexController/zztjTableData';


$(function () {
	//获取登记单位数		author zxp
	$.ajax({
		url : djdwsUrl,
		async : true,
		dataType : 'json',
		success : function(result){
			var djdws_div = echarts.init(document.getElementById('djdws-real-time'));
			djdws_div.setOption({
		        title: {
		            text: '登记单位总数',
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
		                center: ['50%', '35%'],
		                radius: ['55%', '70%'],
		                hoverAnimation: false,
		                label: {
		                    show: false
		                },
		                labelLine: {
		                    show: false
		                },
		                data: [
		                    {
		                        value: result.djdws,
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
	
	function splitWord(str){
		  var strArr = str.split('');
		  var strList = '';
		
		  for(var i = 0; i < strArr.length; i++){
		      strList += "<li><span class='num'>" + strArr[i] + "</span></li>";
		  }
		  return strList;
    }
	
	//证照目录
	$.ajax({
		url : zzmlUrl,
		async : true,
		dataType : 'json',
		success : function(result){
			var zzmlzs = result.ZZMLZS.toString();
			var direList = splitWord(zzmlzs);
			
			direList += "<li><span class='text'>个</span></li>";
			$("#zzmlzs").html(direList);
			$("#zzmlzz").text(result.ZZMLZZ);
			$("#zzmlpw").text(result.ZZMLPW);
			$("#zzmlcl").text(result.ZZMLCL);
			
			var pic1 = echarts.init(document.getElementById('pic-type1'));
			pic1.setOption({
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
			        data: [result.ZZMLZZ]
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
			        data: [result.ZZMLZS]
			      }
			    ]
		  });
		    
		  var pic2 = echarts.init(document.getElementById('pic-type2'));
		  pic2.setOption({
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
		        data: [result.ZZMLPW]
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
		        data: [result.ZZMLZS]
		      }
		    ]
		  });
			  
		  var pic3 = echarts.init(document.getElementById('pic-type3'));
		  pic3.setOption({
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
		        data: [result.ZZMLCL]
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
		        data: [result.ZZMLZS]
		      }
		    ]
		  });
		}
	});
	
	//证照数据与未签章数据
	$.ajax({
		url : zzsjywqzsjUrl,
		async : true,
		dataType : 'json',
		success : function(res){
			$("#zpmValidNum").text(res.ZPM_VALID_NUM);
			$("#zValidNum").text(res.Z_VALID_NUM);
			$("#pValidNum").text(res.P_VALID_NUM);
			$("#mValidNum").text(res.M_VALID_NUM);
			$("#zpmUnsignNum").text(res.ZPM_UNSIGN_NUM);
			$("#zUnsignNum").text(res.Z_UNSIGN_NUM);
			$("#pUnsignNum").text(res.P_UNSIGN_NUM);
			$("#mUnsignNum").text(res.M_UNSIGN_NUM);
			
		}
		
	});
	
	//证照模版统计-按主题统计
	$.ajax({
		url : zzmbtjazttjUrl,
		async : true,
		dataType : 'json',
		success:function(res){
			var nameList = [];
			for(var i=0;i<res.length;i++){
				nameList.push(res[i]['name']);
			}
			
			var zzmbtjAzttj = echarts.init(document.getElementById('zzmbtjazttj'));
			zzmbtjAzttj.setOption({
			    title : {
			        text: '按主题统计',
			        x:'center',
			        textStyle:{
			        	color:'#dff2fd',
			        	fontSize : '18',
			        	fontWeight:'500'
			        }
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			    	type: 'scroll',
			    	orient: 'vertical',
			    	top:30,
			    	left:150,
			        x : 'center',
			        y : 'bottom',
			        data : nameList,
			        textStyle:{
			        	color:'#dff2fd',
			        	fontSize : '12',
			        	fontWeight:'100'
			        }
			    },
			    calculable : true,
			    series : [
			        {
			            name:'模版主题统计',
			            type:'pie',
			            radius : [30, 70],
			            center : ['30%', '50%'],
			            roseType : 'radius',
			            label: {
			                normal: {
			                    show: false
			                },
			                emphasis: {
			                    show: false
			                }
			            },
			            lableLine: {
			                normal: {
			                    show: false
			                },
			                emphasis: {
			                    show: true
			                }
			            },
			            data:res
			        }
			    ]
			});
			
		}
		
	});



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

  //数据目录总数
  var direData = "221";
  var direList = splitWord(direData);
  direList += "<li><span class='text'>个</span></li>";
  $(".data-dire-list .num-list ul").html(direList);

  //电子证照库上报目录情况
    /*$('.data-monitor-scroll').vTicker({
        speed: 700,
        pause: 3000,
        showItems: 5,
        animation: 'fade',
        mousePause: true,
        height: 0,
        direction: 'up'
    });*/

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

//证照目录弹出框
jQuery.zzmlTableJS = function(){
    var table = layui.table;
    //执行渲染
    table.render({
        elem: '#zzmlTable'
        ,height: 700
        ,url: amltjUrl
        ,cols: [
            [
                {field: 'DEPT_NAME', title: '颁发单位',align:'center'}
                ,{field: 'LICENSE_TYPE_NAME', title: '目录名称',align:'center'}
                ,{field: 'CATEGORY', title: '类型',align:'center',
					templet: function(res){
						if(res.CATEGORY=="licence"){
							return "证照";
						}else if(res.CATEGORY=="approval"){
							return "批文";
						}else if(res.CATEGORY=="material"){
							return "材料";
						}else if(res.CATEGORY=="reply"){
                            return "批复";
                        }else {
							return "";
						}

					}
			 	 }
                ,{field: 'UPDATE_CLASS', title: '更新频率',align:'center',
                templet: function(res){
                    if(res.UPDATE_CLASS=="timely"){
                        return "实时";
                    }else if(res.UPDATE_CLASS=="daily"){
                        return "每日";
                    }else if(res.UPDATE_CLASS=="weekly"){
                        return "每周";
                    }else if(res.UPDATE_CLASS=="monthly"){
                        return "每月";
                    }else if(res.UPDATE_CLASS=="yearly"){
                        return "每年";
                    }else {
                        return "其他";
                    }

                }
				}
                ,{field: 'COUNT', title: '证照总数',align:'center'}
                ,{field: 'UNSIGN_COUNT', title: '未签章数',align:'center'}
                ,{field: 'LAST_TIME', title: '最近数据时间',align:'center',
						templet:function (d) {
							return formatDateAll(d.LAST_TIME);
						}
                 }
            ]

        ]
        ,page: true
        ,even: true
        ,limit: 15
        ,limits: [15]
    });

}

//证照统计弹出框数据
jQuery.zztjTableJS = function(){
	var table = layui.table;
	//执行渲染
	table.render({
	   elem: '#zztjTable' //指定原始表格
	  ,height: 700 //容器高度
	  ,url: zztjTableDataUrl //异步数据接口	修改
	  ,cols: [
	       [	
				{field: 'DEPTNAME', title: '部门名称',rowspan:2,align:'center'}
			   ,{field: '', title: '证照类型数',colspan:3,align:'center'}
			   ,{field: '', title: '证照数据数',colspan:3,align:'center'}
			   ,{field: '', title: '未签章数据数',colspan:3,align:'center'}
	       ],
	       [  
				 {field: 'TEMPLATELICENSE', title: '证照',align:'center'}
				,{field: 'TEMPLATEAPPROVAL', title: '批文',align:'center'}
				,{field: 'TEMPLATEMATERIAL', title: '材料',align:'center'}
				,{field: 'VALIDLICENSE', title: '证照',align:'center'}
				,{field: 'VALIDAPPROVAL', title: '批文',align:'center'}
				,{field: 'VALIDMATERIAL', title: '材料',align:'center'}
				,{field: 'UNSIGNLICENSE', title: '证照',align:'center'}
				,{field: 'UNSIGNAPPROVAL', title: '批文',align:'center'}
				,{field: 'UNSIGNMATERIAL', title: '材料',align:'center'}
	       ]
	  ]
    ,page: true
    ,even: true
    ,limit: 15
    ,limits: [15]
	});
	
}

//点击更多显示弹出框
$("body").on("click",".dialog",function () {
	var target = $(this).attr('data-target');
	$(".box[data-target='"+target+"']").siblings().removeClass('active');
	$(".box[data-target='"+target+"']").addClass('active');
	switch (target) {
		case 'zztj':
			//证照统计表格数据
			jQuery.zztjTableJS();
			break;
		case 'zzml':
            jQuery.zzmlTableJS();
            break;
	}
	$(".mask-panel").addClass('active');
	
});

//点击关闭按钮关闭弹出框
$("body").on("click",".close-btn",function () {
  $(this).parents('.mask-panel').removeClass('active');
});










