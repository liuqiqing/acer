var ctx = $("#contextPath").val();
var spbjlxUrl = ctx + "/cityLevelController/spbjlx";
var sxzlslUrl = ctx + "/cityLevelController/sxzlsl";
var xsxxblsxqbsjUrl = ctx + "/cityLevelController/xsxxblsxqbsj";
var sxxzslUrl = ctx + "/cityLevelController/sxxzsl";
//部门受理办结
var jnsbmslUrl = ctx + "/cityLevelController/jnsbmsl";
var jnsbmbjUrl = ctx + "/cityLevelController/jnsbmbj";
//当日线上变化趋势
var drxsbhqsUrl = ctx + "/cityLevelController/drxsbhqs";
var drxxbhqsUrl = ctx + "/cityLevelController/drxxbhqs";
//当月线上变化趋势
var dyxsbhqsUrl = ctx + "/cityLevelController/dyxsbhqs";
var dyxxbhqsUrl = ctx + "/cityLevelController/dyxxbhqs";
//当年线上变化趋势
var dnxsbhqsUrl = ctx + "/cityLevelController/dnxsbhqs";
var dnxxbhqsUrl = ctx + "/cityLevelController/dnxxbhqs";
//市本级事项情况分类
var sbjsxqkflUrl = ctx + "/cityLevelController/sbjsxqkfl";
//市本级事项情况分类根据网办深度进行查询
var sbjsxqkflgjwbsdcxUrl = ctx + "/cityLevelController/sbjsxqkflgjwbsdcx";
//济南市事项受理前十名词云
var jnssxslqsmUrl = ctx + "/cityLevelController/jnssxslqsm";
//济南市事项办结前十名词云
var jnssxbjqsmUrl = ctx + "/cityLevelController/jnssxbjqsm";
//济南市事项性质分类饼图
var jnssxxzflbtUrl = ctx + "/cityLevelController/jnssxxzflbt";

//济南市部门受理排名
jQuery.jnsbmsl = function(){
	 $.ajax({
			type:"get",
			async:true,
			url:jnsbmslUrl,
			dataType:"json",
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
				          fontSize:12
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
//济南市部门办结排名
jQuery.jnsbmbj = function(){
	$.ajax({
		type:"get",
		async:true,
		url:jnsbmbjUrl,
		dataType:"json",
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
			          fontSize:12
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

//当日线上变化趋势
jQuery.drxsbhqs = function(){
	$.ajax({
		type : "get",
	    async : true,   
		url:drxsbhqsUrl,
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
jQuery.drxxbhqs = function(){
	$.ajax({
		type : "get",
	    async : true,   
		url:drxxbhqsUrl,
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
jQuery.dyxsbhqs = function(){
	$.ajax({
		type : "get",
	    async : true,   
		url:dyxsbhqsUrl,
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
jQuery.dyxxbhqs = function(){
	$.ajax({
		type : "get",
	    async : true,   
		url:dyxxbhqsUrl,
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
jQuery.dnxsbhqs = function(){
	$.ajax({
		type : "get",
	    async : true,   
		url:dnxsbhqsUrl,
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
jQuery.dnxxbhqs = function(){
	$.ajax({
		type : "get",
	    async : true,   
		url:dnxxbhqsUrl,
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

//zxp
//页面底部右侧词云显示-济南市事项受理前十
jQuery.jnssxslqsm = function () {
	$.ajax({
        type : "get",
        async : true,
        url:jnssxslqsmUrl,
		success:function (result) {
            var topTen = echarts.init(document.getElementById('top-ten'));
            var nameList = [];
            var valList = [];
            var sxslArr = [];
            for(var i=0;i<result.length;i++){
                for(var key in result[i]){
                    if(key == 'NAME'){
                        nameList.push(result[i][key]);
                    }else if(key == 'SL'){
                        valList.push(result[i][key]);
                    }
                }
            }
            for(var j=0;j<nameList.length;j++){
                var sxslObj={};
                sxslObj.name = nameList[j];
                sxslObj.value = valList[j];
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
                    sizeRange: [15, 60],
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

        }

	});


}
//页面底部右侧词云显示-济南市事项办结前十
jQuery.jnssxbjqsm = function () {
    $.ajax({
        type : "get",
        async : true,
        url:jnssxbjqsmUrl,
        success:function (result) {
            var topTen = echarts.init(document.getElementById('top-ten'));
            var nameList = [];
            var valList = [];
            var sxslArr = [];
            for(var i=0;i<result.length;i++){
                for(var key in result[i]){
                    if(key == 'NAME'){
                        nameList.push(result[i][key]);
                    }else if(key == 'SL'){
                        valList.push(result[i][key]);
                    }
                }
            }
            for(var j=0;j<nameList.length;j++){
                var sxslObj={};
                sxslObj.name = nameList[j];
                sxslObj.value = valList[j];
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
                    sizeRange: [15, 60],
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
                    data: sxslArr
                } ]
            });

        }

    });
}

//济南市事项性质分类饼图
jQuery.jnssxxzflbt = function (){
    $.ajax({
        type : "get",
        async : true,
        url:jnssxxzflbtUrl,
        success:function (result) {
        	var nameList = [];
			for (var i=0;i<result.length;i++){
				var _name = result[i]['name'];
				nameList.push(_name);
			}
            //初始化echarts饼图数据
        	var jnssxxzflbt = echarts.init(document.getElementById('jnssxxzflbt'));
            jnssxxzflbt.setOption({
                title : {
                    text: '',
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
                    top:0,
                    left:200,
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
                        name:'',
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
                        data:result
                    }
                ]

			});



        }

    });

}

//事项受理前十名--受理办结tab切换
jQuery.jnssxslqsm();
$("a[name='toptentab']").click(function(){
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    if($(this).prop("id")=="toptensl"){
        jQuery.jnssxslqsm();
    }else if($(this).prop("id")=="toptenbj"){
        jQuery.jnssxbjqsm();
    }
});

//查询按钮点击事件
function queryByConductDepth(){
	//拼接字符串
    var _val = "";
    var _name = "";
    //获取选中的checkbox
	$("#four-checkbox input[type='checkbox']").each(function () {
		//拿到每一个checkbox
		var _this = $(this);
		//判断是否选中
		if(_this.is(":checked")){
			//获取选中的value
			_val += _this.val()+","
			_name += _this.next().text() + ",";
		}
    });
	if(_val == ''){
		alert("最少选择一个进行查询");
		return;
	}
	//去掉最后一个逗号
    var name = _name.substring(0,_name.lastIndexOf(","))
	//点击查询后，将选中的chenbox名字赋值给html页面中
    //$("#conductDepthName").text("网办深度:" + name);
	//选中的checkbox的值
	var val = _val.substring(0,_val.lastIndexOf(","))
	//提交给后台进行查询数据
	$.ajax({
		url:sbjsxqkflgjwbsdcxUrl,
		type:'post',
		data:{'check_val':val},
        async : true,
        dataType:'json',
		success:function (result) {
			$("#YSQGKSX").text(result.YSQGKSX);
			$("#YSQGKKWSBL").text(result.YSQGKSXGJWBSDCX);
			var YSQGKSX = result.YSQGKSX;
			var YSQGKSXGJWBSDCX = result.YSQGKSXGJWBSDCX;
			$("#SBJFLWBL").text(YSQGKSX == 0 ? 0 : (YSQGKSXGJWBSDCX/YSQGKSX*100).toFixed(2)+"%");
			$("#SBJZTWBL").text(YSQGKSX == 0 ? 0 : (YSQGKSXGJWBSDCX/YSQGKSX*100).toFixed(2)+"%");
            //事项性质分类
            var sxxzflMap = result.SXSZFLMAP;
            $("#XK").text(sxxzflMap['XK']);
            $("#QR").text(sxxzflMap['QR']);
            $("#GG").text(sxxzflMap['GG']);
            $("#ZS").text(sxxzflMap['ZS']);
            $("#JF").text(sxxzflMap['JF']);
            $("#JD").text(sxxzflMap['JD']);
            $("#JL").text(sxxzflMap['JL']);
            $("#QT").text(sxxzflMap['QT']);
            $("#CJ").text(sxxzflMap['CJ']);
            //事项性质分类根据网办深度查询
            var sxxzflkwsblMap = result.SXSZFLGJWBSDCX;
            $("#XK_KWSBL").text(sxxzflkwsblMap['XK']);
            $("#QR_KWSBL").text(sxxzflkwsblMap['QR']);
            $("#GG_KWSBL").text(sxxzflkwsblMap['GG']);
            $("#ZS_KWSBL").text(sxxzflkwsblMap['ZS']);
            $("#JF_KWSBL").text(sxxzflkwsblMap['JF']);
            $("#JD_KWSBL").text(sxxzflkwsblMap['JD']);
            $("#JL_KWSBL").text(sxxzflkwsblMap['JL']);
            $("#QT_KWSBL").text(sxxzflkwsblMap['QT']);
            $("#CJ_KWSBL").text(sxxzflkwsblMap['CJ']);
            //分类网办率
            $("#XK_FLWBL").text(sxxzflMap['XK'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['XK'] / sxxzflMap['XK'] * 100).toFixed(2)+"%");
            $("#QR_FLWBL").text(sxxzflMap['QR'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['QR'] / sxxzflMap['QR'] * 100).toFixed(2)+"%");
            $("#GG_FLWBL").text(sxxzflMap['GG'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['GG'] / sxxzflMap['GG'] * 100).toFixed(2)+"%");
            $("#ZS_FLWBL").text(sxxzflMap['ZS'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['ZS'] / sxxzflMap['ZS'] * 100).toFixed(2)+"%");
            $("#JF_FLWBL").text(sxxzflMap['JF'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['JF'] / sxxzflMap['JF'] * 100).toFixed(2)+"%");
            $("#JD_FLWBL").text(sxxzflMap['JD'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['JD'] / sxxzflMap['JD'] * 100).toFixed(2)+"%");
            $("#JL_FLWBL").text(sxxzflMap['JL'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['JL'] / sxxzflMap['JL'] * 100).toFixed(2)+"%");
            $("#QT_FLWBL").text(sxxzflMap['QT'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['QT'] / sxxzflMap['QT'] * 100).toFixed(2)+"%");
            $("#CJ_FLWBL").text(sxxzflMap['CJ'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['CJ'] / sxxzflMap['CJ'] * 100).toFixed(2)+"%");
            //整体网办率
            $("#XK_ZTWBL").text((sxxzflkwsblMap['XK']/YSQGKSX * 100).toFixed(2)+"%")
            $("#QR_ZTWBL").text((sxxzflkwsblMap['QR']/YSQGKSX * 100).toFixed(2)+"%")
            $("#GG_ZTWBL").text((sxxzflkwsblMap['GG']/YSQGKSX * 100).toFixed(2)+"%")
            $("#ZS_ZTWBL").text((sxxzflkwsblMap['ZS']/YSQGKSX * 100).toFixed(2)+"%")
            $("#JF_ZTWBL").text((sxxzflkwsblMap['JF']/YSQGKSX * 100).toFixed(2)+"%")
            $("#JD_ZTWBL").text((sxxzflkwsblMap['JD']/YSQGKSX * 100).toFixed(2)+"%")
            $("#JL_ZTWBL").text((sxxzflkwsblMap['JL']/YSQGKSX * 100).toFixed(2)+"%")
            $("#QT_ZTWBL").text((sxxzflkwsblMap['QT']/YSQGKSX * 100).toFixed(2)+"%")
            $("#CJ_ZTWBL").text((sxxzflkwsblMap['CJ']/YSQGKSX * 100).toFixed(2)+"%")



        }


	});

}

//下载按钮点击事件
function cityLevelDownload(){
    //拼接字符串
    var _val = "";
    var _name = "网办深度：";
    //获取选中的checkbox
    $("#four-checkbox input[type='checkbox']").each(function () {
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
    window.location.href = ctx + "/cityLevelController/cityLevelDownload?checkVal="+val+"&checkName="+name;

}

$(function () {
	
	//审批办件类型
	$.ajax({
		url : spbjlxUrl,
		type:'get',
		async : true,
		dataType:'json',
		success:function(result){
			var nameList = [];
			for(var i=0;i<result.length;i++){
				nameList.push(result[i]['name']);
			}
			
			var chart1 = echarts.init(document.getElementById("chart1"));
			chart1.setOption({
			    title : {
			        x:'center',
			        textStyle: {
			        	color:'#dff2fd',
		                fontSize: 18,
		                fontWeight:'normal'
		            }
			        
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        orient: 'vertical',
			        left: 'right',
			        data: nameList,
			        textStyle:{
			        	color:'#dff2fd',
			        	fontSize : '16',
			        	fontWeight:'100'
			        }
			      
			    },
			    series : [
			        {
			            name: '审批办件类型',
			            type: 'pie',
			            radius : '55%',
			            center: ['50%', '60%'],
			            data:result,
			            itemStyle: {
			                emphasis: {
			                    shadowBlur: 10,
			                    shadowOffsetX: 0,
			                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			                }
			            },
				        
			        }
			    ]
			});
			
		}
		
	});
	
	//事项总览数量
	$.ajax({
		url : sxzlslUrl,
		type:'get',
		async : true,
		dataType:'json',
		success:function(result){
            direData = result.sxzlsl;
            var strArr = direData.toString().split('');
            var strList = '';
            for(var i = 0; i < strArr.length; i++){
                strList += "<li><span class='num'>" + strArr[i] + "</span></li>";
            }
            strList += "<li><span class='text'>个</span></li>";
            $("#chart2-num-ul").html(strList);
		}
	
	});
	
	//线上、线下、线上线下办理事项全部数据
	$.ajax({
		url : xsxxblsxqbsjUrl,
		type:'get',
		async : true,
		dataType:'json',
		success:function(result){
			//线上办理事项
			var card1 = echarts.init(document.getElementById('card-type1'));
			var card2 = echarts.init(document.getElementById('card-type2'));
			//var card3 = echarts.init(document.getElementById('card-type3'));
			//事项总览数量
			var sxzlsl = result.sxzlsl;
			//线上办理事项
			var xsblsx = result.xsblsx;
			var xsblsxbfb = (xsblsx/sxzlsl)*100;
			$("#xsblsx").html(xsblsxbfb.toFixed(2)+"%");
			//线下办理事项
			var xxblsx = result.xxblsx;
			var xxblsxbfb = (xxblsx/sxzlsl)*100;
			$("#xxblsx").html(xxblsxbfb.toFixed(2)+"%");
			//线上、线下办理事项
			//var xsxxblsx = result.xsxxblsx;
			//var xsxxblsxbfb = (xsxxblsx/sxzlsl)*100;
			//$("#xsxxblsx").html(xsxxblsxbfb.toFixed(2)+"%");
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
				      data: [xsblsx]
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
				      data: [sxzlsl]
				    }
				  ]
			});
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
			        data: [xxblsx]
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
			        data: [sxzlsl]
			      }
			    ]
			});
			/*card3.setOption({
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
			      data: ['线上线下皆可办理事项'],
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
			        data: [xsxxblsx]
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
			        data: [sxzlsl]
			      }
			    ]
			});*/
			
		}
	
	});
	
	//事项性质数量
	$.ajax({
		url : sxxzslUrl,
		type:'get',
		async : true,
		dataType:'json',
		success:function(result){
			var nameList = [];
			var valList = [];
			for(var key in result){
                switch(key){
					case 'CJ':
						nameList.push('行政裁决');
						break;
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
                    default:
                        break;

                }
                valList.push(result[key]);
			}
			/*for(var i=0;i<result.length;i++){
				var name = result[i]['TYPE'];
				switch(name){
					case 'GG':
						nameList.push('公共服务');
						break;
					case 'XK':
						nameList.push('行政许可');
						break;
					case 'QL':
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
					default:
						break;
					
				}
				var val = result[i]['SXXZSL']
				valList.push(val);
				
			}*/
			
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
			          fontSize:12
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
	
	jQuery.jnsbmsl();
	//部门受理办结排名--受理/办结tab切换
	$("body").on("click",".info-section.r-40.top-60 .depart-ranking-title",function(){
	    var name = $(this).attr("name");
	    $(this).addClass('active').siblings().removeClass('active');
	    if(name == 'acceptOption'){
	    	jQuery.jnsbmsl();
	    }else if(name == 'handleOption'){
	    	jQuery.jnsbmbj();
	    	
	    }
	});
	
	//当日线上变化趋势
	jQuery.drxsbhqs();
	//当日线下变化趋势
	jQuery.drxxbhqs();
	//业务办理变化趋势
	$("#ywblbhqs ul li").click(function(){
		 $(this).addClass('active').siblings().removeClass('active');
		 if($(this).html()=='当日'){
			 jQuery.drxsbhqs();
			 jQuery.drxxbhqs();
			 
		 }else if($(this).html()=='当月'){
			 jQuery.dyxsbhqs();
			 jQuery.dyxxbhqs();
			 
		 }else if($(this).html()=='当年'){
			 jQuery.dnxsbhqs();
			 jQuery.dnxxbhqs();
		 }
	 });
	
	

    initNicScroll();
    function initNicScroll(){
        $('.table-content').niceScroll({
            cursoropacitymin: 0,
            cursorcolor:"#0d57ab",
            cursorborder: '#0d57ab'
        });
        $('.table-content').getNiceScroll().resize();
    }

    //市本级事项情况分类数据表格 默认
	$.ajax({
        url : sbjsxqkflUrl,
        type:'get',
        async : true,
        dataType:'json',
        success:function(result){
            var _name = "";
            //获取选中的checkbox
            $("#four-checkbox input[type='checkbox']").each(function () {
                //拿到每一个checkbox
                var _this = $(this);
                //判断是否选中
                if(_this.is(":checked")){
                    _name += _this.next().text() + ",";
                }
            });
            //去掉最后一个逗号
            var name = _name.substring(0,_name.lastIndexOf(","))
            //赋值给页面
			//$("#conductDepthName").text("网办深度:" + name);
        	//依申请公开事项
        	var YSQGKSX = result.YSQGKSX;
        	//依申请公开可网上办理
        	var YSQGKKWSBL = result.YSQGKKWSBL;
        	//市本级分类网办率
        	var SBJFLWBL = (YSQGKKWSBL / YSQGKSX * 100).toFixed(2)+"%"
			//市本级整体网办率
        	var SBJZTWBL = (YSQGKKWSBL / YSQGKSX * 100).toFixed(2)+"%"
			$("#YSQGKSX").text(YSQGKSX);
			$("#YSQGKKWSBL").text(YSQGKKWSBL);
			$("#SBJFLWBL").text(SBJFLWBL);
			$("#SBJZTWBL").text(SBJZTWBL);
			//事项性质分类
            var sxxzflMap = result._sxxzflMap;
            $("#XK").text(sxxzflMap['XK']);
            $("#QR").text(sxxzflMap['QR']);
            $("#GG").text(sxxzflMap['GG']);
            $("#ZS").text(sxxzflMap['ZS']);
            $("#JF").text(sxxzflMap['JF']);
            $("#JD").text(sxxzflMap['JD']);
            $("#JL").text(sxxzflMap['JL']);
            $("#QT").text(sxxzflMap['QT']);
            $("#CJ").text(sxxzflMap['CJ']);
			//事项性质分类可网上办理
            var sxxzflkwsblMap = result._sxxzflkwsblMap;
            $("#XK_KWSBL").text(sxxzflkwsblMap['XK']);
            $("#QR_KWSBL").text(sxxzflkwsblMap['QR']);
            $("#GG_KWSBL").text(sxxzflkwsblMap['GG']);
            $("#ZS_KWSBL").text(sxxzflkwsblMap['ZS']);
            $("#JF_KWSBL").text(sxxzflkwsblMap['JF']);
            $("#JD_KWSBL").text(sxxzflkwsblMap['JD']);
            $("#JL_KWSBL").text(sxxzflkwsblMap['JL']);
            $("#QT_KWSBL").text(sxxzflkwsblMap['QT']);
            $("#CJ_KWSBL").text(sxxzflkwsblMap['CJ']);
			//分类网办率
			$("#XK_FLWBL").text(sxxzflMap['XK'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['XK'] / sxxzflMap['XK'] * 100).toFixed(2)+"%");
			$("#QR_FLWBL").text(sxxzflMap['QR'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['QR'] / sxxzflMap['QR'] * 100).toFixed(2)+"%");
			$("#GG_FLWBL").text(sxxzflMap['GG'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['GG'] / sxxzflMap['GG'] * 100).toFixed(2)+"%");
			$("#ZS_FLWBL").text(sxxzflMap['ZS'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['ZS'] / sxxzflMap['ZS'] * 100).toFixed(2)+"%");
			$("#JF_FLWBL").text(sxxzflMap['JF'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['JF'] / sxxzflMap['JF'] * 100).toFixed(2)+"%");
			$("#JD_FLWBL").text(sxxzflMap['JD'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['JD'] / sxxzflMap['JD'] * 100).toFixed(2)+"%");
			$("#JL_FLWBL").text(sxxzflMap['JL'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['JL'] / sxxzflMap['JL'] * 100).toFixed(2)+"%");
			$("#QT_FLWBL").text(sxxzflMap['QT'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['QT'] / sxxzflMap['QT'] * 100).toFixed(2)+"%");
			$("#CJ_FLWBL").text(sxxzflMap['CJ'] == 0 ? 0.00+"%" : (sxxzflkwsblMap['CJ'] / sxxzflMap['CJ'] * 100).toFixed(2)+"%");
			//整体网办率
			$("#XK_ZTWBL").text((sxxzflkwsblMap['XK']/YSQGKSX * 100).toFixed(2)+"%")
			$("#QR_ZTWBL").text((sxxzflkwsblMap['QR']/YSQGKSX * 100).toFixed(2)+"%")
			$("#GG_ZTWBL").text((sxxzflkwsblMap['GG']/YSQGKSX * 100).toFixed(2)+"%")
			$("#ZS_ZTWBL").text((sxxzflkwsblMap['ZS']/YSQGKSX * 100).toFixed(2)+"%")
			$("#JF_ZTWBL").text((sxxzflkwsblMap['JF']/YSQGKSX * 100).toFixed(2)+"%")
			$("#JD_ZTWBL").text((sxxzflkwsblMap['JD']/YSQGKSX * 100).toFixed(2)+"%")
			$("#JL_ZTWBL").text((sxxzflkwsblMap['JL']/YSQGKSX * 100).toFixed(2)+"%")
			$("#QT_ZTWBL").text((sxxzflkwsblMap['QT']/YSQGKSX * 100).toFixed(2)+"%")
			$("#CJ_ZTWBL").text((sxxzflkwsblMap['CJ']/YSQGKSX * 100).toFixed(2)+"%")
        }


	});


    //初始化济南市事项性质分类饼图
    jQuery.jnssxxzflbt();



});