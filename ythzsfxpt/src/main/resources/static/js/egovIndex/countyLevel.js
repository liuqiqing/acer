var ctx = $("#contextPath").val();
// 区县事项总览
var qxsxzlUrl = ctx + "/countyLevelController/qxsxzl"; // 区县事项总览
// 线上、线下、线上线下办理事项全部数据
var xsblsxUrl = ctx + "/countyLevelController/xsxxblsxqbsj";
// 信息公开数、依申请公开事项数
var xxgysqgksxkUrl =  ctx + "/countyLevelController/xxgkNumYsqgksxNum";
// 依申请公开可网上办理事项统计
var ysqgkkwsblsxtjUrl = ctx + "/countyLevelController/ysqgkkwsblsxtjList";
// 事项性质
var sxxzslUrl = ctx + "/countyLevelController/sxxzsl";
// 区县部门受理办结
var qxbmslUrl = ctx + "/countyLevelController/qxbmsl";
var qxbmbjUrl = ctx + "/countyLevelController/qxbmbj";
//事项性质：已发布、可网上办理数
var sxxzsyjwsblsUrl = ctx + "/countyLevelController/sxxzsyjwsbls";
//当日线上变化趋势
var drxsbhqsUrl = ctx + "/countyLevelController/drxsbhqs";
var drxxbhqsUrl = ctx + "/countyLevelController/drxxbhqs";
//当月线上变化趋势
var dyxsbhqsUrl = ctx + "/countyLevelController/dyxsbhqs";
var dyxxbhqsUrl = ctx + "/countyLevelController/dyxxbhqs";
//当年线上变化趋势
var dnxsbhqsUrl = ctx + "/countyLevelController/dnxsbhqs";
var dnxxbhqsUrl = ctx + "/countyLevelController/dnxxbhqs";
// 全区县事项数据总览
var sxsjzlUrl = ctx + "/countyLevelController/sxsjzl";
var qxsxzl =0; // 事项总数
var xian="全区县";


//事项总览数量
function sxzlsl(ego){
	var county = ego;
	$.ajax({
		url : qxsxzlUrl,
		type:'get',
		async : true,
		dataType:'json',
		data:{"county":county},
		success:function(result){
			qxsxzl = result.qxsxzl;
		    $("#item-total-num").html(qxsxzl);
		}
	
	});
}
// 线上、线下、线上线下办理事项全部数据
function xsblsx(ego){
	var county = ego;
	$.ajax({
		url : xsblsxUrl,
		type:'get',
		async : true,
		dataType:'json',
		data:{"county":county},
		success:function(result){
			var qxsxzl = result.qxsxzl; // 事项总览数量
			
			 
			
			var xsblsx = result.xsblsx*1;// 线上
			var xsblsx_rate = xsblsx/qxsxzl * 100;
			
			var xxblsx = result.xxblsx; // 线下
			var xxblsx_rate = xxblsx/qxsxzl * 100;
			
		    $("#xsblsx").html(xsblsx); // 线上
		    $("#xsblsx-rate").html(xsblsx_rate.toFixed(2)+'%');
		    $("#xxblsx").html(xxblsx); // 线下
		    $("#xxblsx-rate").html(xxblsx_rate.toFixed(2)+'%');
		}
	
	});
}

// 信息公开、依申请公开的事项
function xxgkysqgksx(ego){
	var county = ego;
	$.ajax({
		url : xxgysqgksxkUrl,
		type:'get',
		async : true,
		dataType:'json',
		data:{"county":county},
		success:function(result){
			// var qxsxzl = result.qxsxzl; // 事项总览数量
			var xxgk = result.xxgkNum;
			var xxgk_rate = xxgk/qxsxzl* 100;
			var ysqsx = result.ysqgksxNum;
			var ysqsx_rate = ysqsx/qxsxzl* 100;
			
		    $("#xxgk").html(xxgk); // 信息公开
		    $("#xxgk-rate").html(xxgk_rate.toFixed(2)+'%');
		    $("#ysqsx").html(ysqsx); // 依申请公开事项
		    $("#ysqsx-rate").html(ysqsx_rate.toFixed(2)+'%');
		
		}
	
	});
}
//依申请公开可网上办理事项统计 
function ysqgkkwsblsxtjList(){
	$.ajax({
		url : ysqgkkwsblsxtjUrl,
		type:'get',
		async : true,
		dataType:'json',
		success:function(result){
			for(var i=0;i<result.length;i++){
				var html=" <li>";
				html+="<span class='num-thin case-num-second'>"+(i+1)+"</span>" ;  
				html+="<span class='case-name'>"+result[i]['REGIONNAME']+"</span>";
				html+="<span class='num-thin case-sta'>"+result[i]['WSBLNUM']+"</span>";
				html+="</li>";
				$("#ysqkgkwsblsxtj").append(html);
				
			} 
		}
	
	});
}
// 区县事项性质
function qxsxxz(ego){
	var county = ego;
	//事项性质数量
	$.ajax({
		url : sxxzslUrl,
		type:'get',
		async : true,
		dataType:'json',
		data:{"county":county},
		success:function(result){
			var nameList = [];
			var valList = [];
			for(var key in result){
				var name = key;
				switch(name){
					case 'GG':
						nameList.push('公共服务');
						break;
					case 'XK':
						nameList.push('行政许可');
						break;
					case 'QT':
						nameList.push('其它权力');
						break;
					case 'QR':
						nameList.push('行政确认');
						break;
					case 'JL':
						nameList.push('行政奖励');
						break;
					case 'JD':
						nameList.push('行政监督');
						break;
					case 'JF':
						nameList.push('行政给付');
						break;
					case 'ZS':
						nameList.push('行政征收');
						break;
					case 'CJ':
						nameList.push('行政裁决');
						break;
					default:
						break;
					
				}
				var val = result[key];
				valList.push(val);
			}
			
			var chart3 = echarts.init(document.getElementById("chart3"));
			chart3.setOption({
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
			      data: nameList,
			      axisLabel: {
			        interval: 0,
			        rotate: 45,
			        textStyle: {
			          color: '#e5f8ff',
			          fontSize:16
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
			        data:valList
			      }
			    ]
		   });
			
		}
		
	});
	
}

// 全区县事项性质和网上办理
function sxxzsyjwsbls(ego){
	
	var county = ego;
	//事项性质数量
	$.ajax({
		url : sxxzsyjwsblsUrl,
		type:'get',
		async : true,
		dataType:'json',
		data:{"county":county},
		success:function(result){
			var _PublishMap = result["sxxzsyjwsbls_Publish"];// 已发布
			var _onLineMap = result["sxxzsyjwsbls_onLine"];// 可网上办理
			// 循环遍历map
			var i =1;
			var htmlTr = "";
			if($("#sxxzsyjwsbls_tBody  tr:eq(0)").html!=""){
				$("#sxxzsyjwsbls_tBody").html("");
			}
			for(var key in _PublishMap){
					htmlTr = "<tr>"
					// 第一个td
					if(i==1){
						htmlTr +="<td class='top-three'>";
						htmlTr +="<img src='static/img/countyLevel/left/first-bg.png' alt='first'>";
					}else if(i==2){
						htmlTr +="<td class='top-three'>";
						htmlTr +="<img src='static/img/countyLevel/left/second-bg.png' alt='first'>";
					}else if(i==3){
						htmlTr +="<td class='top-three'>";
						htmlTr +="<img src='static/img/countyLevel/left/third-bg.png' alt='first'>";
					}else{
						htmlTr +="<td class='num-thin'>"+i;
					}
					htmlTr +="</td>";
					// 第二个td
					var name='';
					switch(key){
					case 'XK':
						name ='许可';
						break;
					case 'ZS':
						name ='征收';
						break;
					case 'QR':
						name ='确认';
						break;
					case 'JF':
						name ='给付';
						break;
					case 'JL':
						name ='奖励';
						break;
					case 'CJ':
						name = '裁决';
						break;
					case 'QT':
						name = '其他';
						break;	
					case 'GG':
						name = '服务';
						break;
					case 'JD':
						name ='监督';
						break;
					default:
						break;
				    }
					htmlTr +="<td class='name'>"+ name+"</td>"
					// 第三个td
					htmlTr += "<td>";
					htmlTr += "<div class='bar-container' id='divNum"+i+"' style='width: 80%;'></div>";
					htmlTr += "</div>";
					htmlTr += "</td>";
					// 第四个 td--已发布
					htmlTr +="<td><em class='num-thin'>"+ _PublishMap[key] +"</em></td>";
					// 第5个td---可网上办理
					var online=0;
					for(var key1 in _onLineMap){
						if(key==key1){
							online = _onLineMap[key1];
							htmlTr +="<td><em class='num-thin'>"+ _onLineMap[key1] +"</em></td>";
							break;
						}
					}
					// 生成echart 图
					htmlTr += "</tr>";
					$("#sxxzsyjwsbls_tBody").append(htmlTr);
					createChart(key,i,_PublishMap[key],online);
					i++;
			}
		}
	});
}

// 生成比例图
function createChart(key,i,val1,val2){
	var card1 = echarts.init(document.getElementById('divNum'+i));
	card1.setOption({
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
		    data: [val1],
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
		      barWidth: 12,
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
		      data: [val2]
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
		      data: [val1]
		    }
		  ]
	});
}

//当日线上变化趋势
jQuery.drxsbhqs = function(county){
	$.ajax({
		type : "get",
	    async : true,   
		url:drxsbhqsUrl,
		dataType:'json',
		data:{"county":county},
		success:function(result){
			var xsslList = [];
			var xsbjList = [];
			var slsjList = [];
			var bjsjList = [];
			var drslzl = 0;
			var drbjzl = 0;
			for(var i=0;i<result.drxsslcsList.length;i++){
				for(var key in result.drxsslcsList[i]){
					if(key == 'SJ'){
						slsjList.push(result.drxsslcsList[i][key]);
					}else if(key == 'SXSL'){
						xsslList.push(result.drxsslcsList[i][key]);
					}
				}
			}
			for(var i=0;i<result.drxsbjcsList.length;i++){
				for(var key in result.drxsbjcsList[i]){
					if(key == 'SJ'){
						bjsjList.push(result.drxsbjcsList[i][key]);
					}else if(key == 'SXSL'){
						xsbjList.push(result.drxsbjcsList[i][key]);
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
			var pro1 = echarts.init(document.getElementById('ywblbhqs-pro1'));
			pro1.setOption({
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
jQuery.drxxbhqs = function(county){
	$.ajax({
		type : "get",
	    async : true,   
		url:drxxbhqsUrl,
		dataType:'json',
		data:{"county":county},
		success:function(result){
			var xxslList = [];
			var xxbjList = [];
			var slsjList = [];
			var bjsjList = [];
			var drslzl = 0;
			var drbjzl = 0;
			
			for(var i=0;i<result.drxxslcsList.length;i++){
				for(var key in result.drxxslcsList[i]){
					if(key == 'SJ'){
						slsjList.push(result.drxxslcsList[i][key]);
					}else if(key == 'SXSL'){
						xxslList.push(result.drxxslcsList[i][key]);
					}
				}
			}
			for(var i=0;i<result.drxxbjcsList.length;i++){
				for(var key in result.drxxbjcsList[i]){
					if(key == 'SJ'){
						bjsjList.push(result.drxxbjcsList[i][key]);
					}else if(key == 'SXSL'){
						xxbjList.push(result.drxxbjcsList[i][key]);
					}
				}
			} 
			for(var i=0;i<xxslList.length;i++){
				drslzl+=xxslList[i];
			}
			for(var i=0;i<xxbjList.length;i++){
				drbjzl+=xxbjList[i];
			}
			$("#xxslzs").html(drslzl);
			$("#xxbjzs").html(drbjzl);
			var pro2 = echarts.init(document.getElementById('ywblbhqs-pro2'));
			pro2.setOption({
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
				      data: xxslList,
				      color: '#0094fb',
				    },{
				      type: 'line',
				      name: '办结',
				      data: xxbjList,
				      color: '#ddb401',
				    }]
			});
		}
	});
}

//当月线上变化趋势
jQuery.dyxsbhqs = function(county){
	$.ajax({
		type : "get",
	    async : true,   
		url:dyxsbhqsUrl,
		dataType:'json',
		data:{"county":county},
		success:function(result){
			var xsslList = [];
			var xsbjList = [];
			var slsjList = [];
			var bjsjList = [];
			var dyslzl = 0;
			var dybjzl = 0;
			for(var i=0;i<result.dyxsslcsList.length;i++){
				for(var key in result.dyxsslcsList[i]){
					if(key == 'SJ'){
						slsjList.push(result.dyxsslcsList[i][key]);
					}else if(key == 'SXSL'){
						xsslList.push(result.dyxsslcsList[i][key]);
					}
				}
			}
			for(var i=0;i<result.dyxsbjcsList.length;i++){
				for(var key in result.dyxsbjcsList[i]){
					if(key == 'SJ'){
						bjsjList.push(result.dyxsbjcsList[i][key]);
					}else if(key == 'SXSL'){
						xsbjList.push(result.dyxsbjcsList[i][key]);
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
			var pro1 = echarts.init(document.getElementById('ywblbhqs-pro1'));
			pro1.setOption({
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

//当月线下变化趋势
jQuery.dyxxbhqs = function(county){
	$.ajax({
		type : "get",
	    async : true,   
		url:dyxxbhqsUrl,
		dataType:'json',
		data:{"county":county},
		success:function(result){
			var xxslList = [];
			var xxbjList = [];
			var slsjList = [];
			var bjsjList = [];
			var dyslzl = 0;
			var dybjzl = 0;
			
			for(var i=0;i<result.dyxxslcsList.length;i++){
				for(var key in result.dyxxslcsList[i]){
					if(key == 'SJ'){
						slsjList.push(result.dyxxslcsList[i][key]);
					}else if(key == 'SXSL'){
						xxslList.push(result.dyxxslcsList[i][key]);
					}
				}
			}
			for(var i=0;i<result.dyxxbjcsList.length;i++){
				for(var key in result.dyxxbjcsList[i]){
					if(key == 'SJ'){
						bjsjList.push(result.dyxxbjcsList[i][key]);
					}else if(key == 'SXSL'){
						xxbjList.push(result.dyxxbjcsList[i][key]);
					}
				}
			} 
			for(var i=0;i<xxslList.length;i++){
				dyslzl+=xxslList[i];
			}
			for(var i=0;i<xxbjList.length;i++){
				dybjzl+=xxbjList[i];
			}
			$("#xxslzs").html(dyslzl);
			$("#xxbjzs").html(dybjzl);
			var pro2 = echarts.init(document.getElementById('ywblbhqs-pro2'));
			pro2.setOption({
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
				      data: xxslList,
				      color: '#0094fb',
				    },{
				      type: 'line',
				      name: '办结',
				      data: xxbjList,
				      color: '#ddb401',
				    }]
			});
		}
	});
}

//当年线上变化趋势
jQuery.dnxsbhqs = function(county){
	$.ajax({
		type : "get",
	    async : true,   
		url:dnxsbhqsUrl,
		dataType:'json',
		data:{"county":county},
		success:function(result){
			var xsslList = [];
			var xsbjList = [];
			var slsjList = [];
			var bjsjList = [];
			var dnslzl = 0;
			var dnbjzl = 0;
			for(var i=0;i<result.dnxsslcsList.length;i++){
				for(var key in result.dnxsslcsList[i]){
					if(key == 'SJ'){
						slsjList.push(result.dnxsslcsList[i][key]);
					}else if(key == 'SXSL'){
						xsslList.push(result.dnxsslcsList[i][key]);
					}
				}
			}
			for(var i=0;i<result.dnxsbjcsList.length;i++){
				for(var key in result.dnxsbjcsList[i]){
					if(key == 'SJ'){
						bjsjList.push(result.dnxsbjcsList[i][key]);
					}else if(key == 'SXSL'){
						xsbjList.push(result.dnxsbjcsList[i][key]);
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
			var pro1 = echarts.init(document.getElementById('ywblbhqs-pro1'));
			pro1.setOption({
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

//当年线下变化趋势
jQuery.dnxxbhqs = function(county){
	$.ajax({
		type : "get",
	    async : true,   
		url:dnxxbhqsUrl,
		dataType:'json',
		data:{"county":county},
		success:function(result){
			var xxslList = [];
			var xxbjList = [];
			var slsjList = [];
			var bjsjList = [];
			var dnslzl = 0;
			var dnbjzl = 0;
			
			for(var i=0;i<result.dnxxslcsList.length;i++){
				for(var key in result.dnxxslcsList[i]){
					if(key == 'SJ'){
						slsjList.push(result.dnxxslcsList[i][key]);
					}else if(key == 'SXSL'){
						xxslList.push(result.dnxxslcsList[i][key]);
					}
				}
			}
			for(var i=0;i<result.dnxxbjcsList.length;i++){
				for(var key in result.dnxxbjcsList[i]){
					if(key == 'SJ'){
						bjsjList.push(result.dnxxbjcsList[i][key]);
					}else if(key == 'SXSL'){
						xxbjList.push(result.dnxxbjcsList[i][key]);
					}
				}
			} 
			for(var i=0;i<xxslList.length;i++){
				dnslzl+=xxslList[i];
			}
			for(var i=0;i<xxbjList.length;i++){
				dnbjzl+=xxbjList[i];
			}
			$("#xxslzs").html(dnslzl);
			$("#xxbjzs").html(dnbjzl);
			var pro2 = echarts.init(document.getElementById('ywblbhqs-pro2'));
			pro2.setOption({
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
				      data: xxslList,
				      color: '#0094fb',
				    },{
				      type: 'line',
				      name: '办结',
				      data: xxbjList,
				      color: '#ddb401',
				    }]
			});
		}
	});
}




//业务办理变化趋势
$("#ywblbhqs ul li").click(function(){
	 $(this).addClass('active').siblings().removeClass('active');
	 if(xian=="全区县"){
		 xian = null; 
	 }
	 if($(this).html()=='当日'){
		 jQuery.drxsbhqs(xian);
		 jQuery.drxxbhqs(xian);
		 
	 }else if($(this).html()=='当月'){
		 jQuery.dyxsbhqs(xian);
		 jQuery.dyxxbhqs(xian);
		 
	 }else if($(this).html()=='当年'){
		 jQuery.dnxsbhqs(xian);
		 jQuery.dnxxbhqs(xian);
	 }
 });
//区县部门受理排名
function qxbmsl(county){
	 $.ajax({
			type:"get",
			async:true,
			url:qxbmslUrl,
			dataType:"json",
			data:{"county":county},
			success:function(result){
				var nameList = [];
				var valList = [];
				for(var i=0;i<result.length;i++){
					var name = result[i]['ORG_NAME']
					nameList.push(name);
					var val = result[i]['SL']
					valList.push(val);
				}
				
				var chart4 = echarts.init(document.getElementById("chart4"));
				chart4.setOption({
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
				      data: nameList,
				      axisLabel: {
				        interval: 0,
				        rotate: 45,
				        textStyle: {
				          color: '#e5f8ff',
				          fontSize:16
				        },
				        formatter:function(name){
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
				        data:valList
				      }
				    ]
			   });
			}
	 });
	
	
	
}
//区县部门办结排名
 function qxbmbj(county){
	$.ajax({
		type:"get",
		async:true,
		url:qxbmbjUrl,
		dataType:"json",
		data:{"county":county},
		success:function(result){
			var nameList = [];
			var valList = [];
			for(var i=0;i<result.length;i++){
				var name = result[i]['ORG_NAME']
				nameList.push(name);
				var val = result[i]['SL']
				valList.push(val);
			}
			var chart4 = echarts.init(document.getElementById("chart4"));
			chart4.setOption({
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
			      data: nameList,
			      axisLabel: {
			        interval: 0,
			        rotate: 45,
			        textStyle: {
			          color: '#e5f8ff',
			          fontSize:16
			        },
			        formatter:function(name){
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
			        data:valList
			      }
			    ]
		   });
		}
 });
}

 // 全区县依申请公开事项数据总览
 function sxsjzl(county,depth,tableId){
	 $("#"+tableId).html("");
	 $.ajax({
		 type:"post",
		 url:sxsjzlUrl,
		 dataType:'json',
		 data:{"county":county,"depth":depth},
		 success:function(result){
			 var ysqgksxNum = result['ysqgksxNum']; // 依申请事项数
			 var xsblsx =  result['xsblsx']; // 可网上办理数
			 var flwb_rate = (ysqgksxNum ==0||xsblsx==0)?('0.00'+'%'):((xsblsx/ ysqgksxNum * 100).toFixed(2)+'%'); // 各分类网办率
			 var ztwb_rate = (ysqgksxNum ==0||xsblsx==0)?('0.00'+'%'):((xsblsx/ ysqgksxNum * 100).toFixed(2)+'%'); // 整体网办率
			 var htmlTr ="<tr >";
			 htmlTr +="<td colspan='2'>事项情况</th>";
				 htmlTr +="<td>"+ ysqgksxNum+"</td>";
				 htmlTr +="<td>"+xsblsx+"</td>"
				 htmlTr +="<td>"+flwb_rate+"</td>";
				 htmlTr +="<td>"+ ztwb_rate+"</td>";
				 htmlTr +="</tr>";
			 // tr 循环
			 var _PublishMap = result["sxxzsyjwsbls_Publish"];// 依申请
			 var _onLineMap = result["sxxzsyjwsbls_onLine"];// 可网上办理
			 var i=1;
			 for(var key in _PublishMap){
				 var name='';
					switch(key){
					case 'XK':
						name ='行政许可';
						break;
					case 'ZS':
						name ='行政征收';
						break;
					case 'QR':
						name ='行政确认';
						break;
					case 'JF':
						name ='行政给付';
						break;
					case 'JL':
						name ='行政奖励';
						break;
					case 'CJ':
						name = '行政裁决';
						break;
					case 'QT':
						name = '其他权力';
						break;	
					case 'GG':
						name = '公共服务';
						break;
					case 'JD':
						name ='行政监督';
						break;
					default:
						break;
				    }
				 htmlTr += "<tr>";	
					if(i==1){
						htmlTr += "<td rowspan='9'>事项性质</td>"		
					}
				htmlTr +="<td><span>"+name+"</span></td>";
				// 依申请
				var publishNum = _PublishMap[key]==null? 0:_PublishMap[key];
				htmlTr +="<td>"+publishNum+"</td>";
				// 网上办理
				var onLineNum = 0;
				for(var key1 in _onLineMap){
					if(key1==key){
						onLineNum = _onLineMap[key1]==null? 0:_onLineMap[key1];
						break;
					}
				}
				htmlTr +="<td>"+onLineNum+"</td>";
				// 各分类网办率
				var rate1 = (publishNum ==0||onLineNum==0) ?('0.00'+'%'):((onLineNum/publishNum *100).toFixed(2)+'%') ;
				htmlTr +="<td>"+rate1 +"</td>";
				// 整体网办率
				var rate2 = (ysqgksxNum ==0||onLineNum==0)?('0.00'+'%'):((onLineNum/ysqgksxNum *100).toFixed(2)+'%'); 
				htmlTr +="<td>"+rate2+"</td>";
				htmlTr += "</tr>";
				i++;
			 }
			 $("#"+tableId).html(htmlTr);
			 
		 }
	 });
 }

 // 点击查询按钮触发事件
 $("#btn-input").on("click",function(){
	 // 循环选中的checkbox的值
	 var i=0;
	 var depth = ""; // 网办深度
	 var depth_title=""; // 表格表头标题
	 $("input[name='searchCheckbox']:checkbox").each(function(){ 
                if(this.checked){
                   //  window.alert("你选了："+ $('input[type=checkbox]:checked').length+"个，其中有："+$(this).val());
                 var val = $(this).val();
                 depth_title +=$(this).next().text()+",";
           		 depth+=val+",";
           		 i++;
                }
            });
	 // 当选中项数为0时，默认显示1,2,4
	 if(i==0){
		 alert("网办深度不能为空");
		 return;
		/* sxsjzl(null,null,"sxAddTr"); 
		 $("#check1").prop("checked",true);// 默认选中1,2,4
		 $("#check4").prop("checked",true);*/
		 
	 }else{
		 var depth = depth.substring(0,depth.length-1);
		 var depth_title = depth_title.substring(0,depth_title.length-1);
		 if(depth=="1,2,4"){
			 $("#th_title").html(""); 
			 $("#th_title").html("可网上办理数"); 
		 }else if(depth=="1,2,3,4"){
			 $("#th_title").html(""); 
			 $("#th_title").html("查看全部"); 
		 }else{
			 $("#th_title").html(""); 
			 $("#th_title").html(depth_title); 
		 }
		
		 if(xian=="全区县"){
			 xian = null; 
		 }
		 $("#sxAddTr").html("");
		 sxsjzl(xian,depth,"sxAddTr");
	 }
 });
//部门受理办结排名--受理/办结tab切换
$("body").on("click",".panel-body .depart-ranking-title span",function(){
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    if(name == 'acceptOption'){
    	qxbmsl(null);
    }else if(name == 'handleOption'){
    	qxbmbj(null);
    	
    }
});
// 点击更多加载依申请事项数据
function moreSearch(depth,checkType){
	// 全区县
	sxsjzl(null,depth,"qxsxAddTr"); 
	// 历城区
	sxsjzl("历城区",depth,"lchqsxAddTr"); 
	// 历下区
	sxsjzl("历下区",depth,"lxqsxAddTr"); 
	// 市中区
	sxsjzl("市中区",depth,"shzqsxAddTr");
	// 高新区
	sxsjzl("高新区",depth,"gxqsxAddTr");
	// 天桥区
	sxsjzl("天桥区",depth,"tqqsxAddTr");
	// 槐荫区
	sxsjzl("槐荫区",depth,"hyqsxAddTr");
	// 章丘区
	sxsjzl("章丘区",depth,"zhqqsxAddTr");
	// 长清区
	sxsjzl("长清区",depth,"chqqsxAddTr");
	// 济阳区
	sxsjzl("济阳区",depth,"jyqsxAddTr");
	// 商河区
	sxsjzl("商河县",depth,"shhqsxAddTr");
	// 平阴县
	sxsjzl("平阴县",depth,"pyxsxAddTr");
	// checkType:1 选中1,2,4
	if(checkType==1){
		 $("#check_1").prop("checked",true);// 默认选中1,2,4
		 $("#check_2").prop("checked",true);
		 $("#check_4").prop("checked",true);
	}
	
}
//下载按钮点击事件
function countyLevelDownload(){
    //拼接字符串
    var _val = "";
    var _name = "";
    //获取选中的checkbox
    $("input[name='moreCheckbox']:checkbox").each(function() {
        //拿到每一个checkbox
        var _this = $(this);
        //判断是否选中
        if(_this.is(":checked")){
            //获取选中的value
            _val += _this.val()+","
            _name += _this.next().text() + ",";
        }
    });
    //去掉最后一个逗号
    var val = _val.substring(0,_val.lastIndexOf(","))
    var name = _name.substring(0,_name.lastIndexOf(","))
    //alert(val);
    //alert(name);
    window.location.href = ctx + "/countyLevelController/countyLevelDownload?checkVal="+val+"&checkName="+name;
}


$(function(){
	// 事项总览数量
	sxzlsl(null);
	// 线上、线下、线上线下办理事项全部数据
	 xsblsx(null);
	// 信息公开、依申请公开的事项
	xxgkysqgksx(null);
	//依申请公开可网上办理事项统计 
	ysqgkkwsblsxtjList();
	// 区县事项性质
	qxsxxz(null);
	// 区县事项受理
	qxbmsl(null);
	// 事项性质：已发布、可网上办理数
	 sxxzsyjwsbls(null);
	//当日线上变化趋势
	 jQuery.drxsbhqs(null);
	 //当日线下变化趋势
	 jQuery.drxxbhqs(null);
	 
	// 全区县依申请公开事项数据总览
	 $("#check1").attr("checked",true);
	 $("#check2").attr("checked",true);
	 $("#check4").attr("checked",true);
	 sxsjzl(null,null,"sxAddTr");
	 


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
	    //let mapChart = echarts.getInstanceByDom(document.getElementById('center-map'));
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
	                areaColor: '#0241ad',
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
	                selectedMode : 'single',
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
	    mapChart.clear();
	    mapChart.setOption(myOption,true);
	    mapChart.on('click', function(params) {
		var county = params.name;
		xian = county;
		if(county !='莱芜区' && county !='钢城区') {
			// 事项总览数量---part1
			$("#dynamic_qqxsx_title").html(county + "事项");
			sxzlsl(county);
			// 线上、线下、线上线下办理事项全部数据
			xsblsx(county);
			// 信息公开、依申请公开的事项
			xxgkysqgksx(county);
			// 全区县事项性质---part2
			$("#dynamic_qqxshxxzh_title").html(county + "事项性质");
			qxsxxz(county);
			// 事项性质：已发布、可网上办理数--- part3
			$("#qqxshxxzhNum_Online_title").html(county + "事项性质和网上办理");
			$("#sxxzsyjwsbls_tBody").html("");
			sxxzsyjwsbls(county);
			// 当日线上变化趋势 -- part4
			$("#qxxywblbhqsh_title").html(county + "业务办理变化趋势");
			jQuery.drxsbhqs(county);
			// 当日线下变化趋势
			jQuery.drxxbhqs(county);
			// 全区县部门受理办结排名----part5
			$("#qqxbmsl_title").html(county + "部门受理办结排名");
			qxbmsl(county);

			// 全区县依申请公开事项数据总览--part6
			$("#qqxyshqgksxzl_title").html(county + "依申请公开事项数据总览");
			$("#check1").attr("checked", true);
			$("#check4").attr("checked", true);
			$("#sxAddTr").html("");
			sxsjzl(county, null, "sxAddTr");
		}
	});
    
	// 初始化滚动条
    initNicScroll();
    function initNicScroll(){
        $('.table-content').niceScroll({
            cursoropacitymin: 0,
            cursorcolor:"#0d57ab",
            cursorborder: '#0d57ab'
        });
        $('.table-content').getNiceScroll().resize();
    }
    // 弹出框
  //点击更多现实弹出框
    $("body").on("click",".dialog",function () {
      var target = $(this).attr('data-target');
      $(".box[data-target='"+target+"']").siblings().removeClass('active');
      $(".box[data-target='"+target+"']").addClass('active');
      moreSearch(null,1);
      $('#table_content_prop').niceScroll({
          cursoropacitymin: 0,
          cursorcolor:"#0d57ab",
          cursorborder: '#0d57ab'
      });
      $('#table_content_prop').getNiceScroll().resize();
      
      switch (target) {
        case 'bmyjpmbox':
        	break;
      }
      $(".mask-panel").addClass('active');
    });
    //点击关闭按钮关闭弹出框
    $("body").on("click",".close-btn",function () {
      $(this).parents('.mask-panel').removeClass('active');
    });
    
	
	// 点击更多中的查询按钮触发事件
	$("#btn_input_1").on("click", function() {
		// 循环选中的checkbox的值
		var i = 0;
		var depth = ""; // 网办深度
		var depth_title = ""; // 表格表头标题
		$("input[name='moreCheckbox']:checkbox").each(function() {
			if (this.checked) {
				var val = $(this).val();
				depth_title += $(this).next().text() + ",";
				depth += val + ",";
				i++;
			}
		});
		// 当选中项数为0时，默认显示1,2,4
		if (i == 0) {
			 alert("网办深度不能为空");
			 return;
			 // moreSearch(null, 1);
		} else {
			var depth = depth.substring(0, depth.length - 1);
			var depth_title = depth_title.substring(0, depth_title.length - 1);
			$("#th_title_qx").html("");
			$("#th_title_lchq").html("");
			$("#th_title_lxq").html("");
			$("#th_title_shzq").html("");
			$("#th_title_tqq").html("");
			$("#th_title_hyq").html("");
			$("#th_title_zhqq").html("");
			$("#th_title_chqq").html("");
			$("#th_title_jyq").html("");
			$("#th_title_shhq").html("");
			$("#th_title_pyx").html("");
			$("#th_title_gxq").html("");
			if (depth == "1,2,4") {
				$("#th_title_qx").html("可网上办理数");
				$("#th_title_lchq").html("可网上办理数");
				$("#th_title_lxq").html("可网上办理数");
				$("#th_title_shzq").html("可网上办理数");
				$("#th_title_tqq").html("可网上办理数");
				$("#th_title_hyq").html("可网上办理数");
				$("#th_title_zhqq").html("可网上办理数");
				$("#th_title_chqq").html("可网上办理数");
				$("#th_title_jyq").html("可网上办理数");
				$("#th_title_shhq").html("可网上办理数");
				$("#th_title_pyx").html("可网上办理数");
				$("#th_title_gxq").html("可网上办理数");

			} else if (depth == "1,2,3,4") {
				$("#th_title_qx").html("查看全部");
				$("#th_title_lchq").html("查看全部");
				$("#th_title_lxq").html("查看全部");
				$("#th_title_shzq").html("查看全部");
				$("#th_title_tqq").html("查看全部");
				$("#th_title_hyq").html("查看全部");
				$("#th_title_zhqq").html("查看全部");
				$("#th_title_chqq").html("查看全部");
				$("#th_title_jyq").html("查看全部");
				$("#th_title_shhq").html("查看全部");
				$("#th_title_pyx").html("查看全部");
				$("#th_title_gxq").html("查看全部");
			} else {
				$("#th_title_qx").html(depth_title);
				$("#th_title_lchq").html(depth_title);
				$("#th_title_lxq").html(depth_title);
				$("#th_title_shzq").html(depth_title);
				$("#th_title_tqq").html(depth_title);
				$("#th_title_hyq").html(depth_title);
				$("#th_title_zhqq").html(depth_title);
				$("#th_title_chqq").html(depth_title);
				$("#th_title_jyq").html(depth_title);
				$("#th_title_shhq").html(depth_title);
				$("#th_title_pyx").html(depth_title);
				$("#th_title_gxq").html(depth_title);
			}
			moreSearch(depth, 2); // 2 代表checkbox选中项
		}
	});

});