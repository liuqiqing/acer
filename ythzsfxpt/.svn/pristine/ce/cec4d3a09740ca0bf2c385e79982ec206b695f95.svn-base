var ctx = $("#contextPath").val();
// 资源类型统计--chart2
var resourceTypeTjUrl =ctx + "/shareResourceController/resourceTypeTj";
// 各部门可共享资源目录数--chart1
var bmCatalogTjUrl =ctx + "/shareResourceController/bmCatalogTj";
// 现有资源数:资源总数、库表、数据量、接口、文件
var xyResourceTjUrl = ctx + "/shareResourceController/xybResourceTj";
// 申请省级资源情况:申请接口数、累计接口调用数
var shqshjResourceQkUrl = ctx + "/shareResourceController/shqshjResourceQk";
// 申请市级资源情况:申请资源数（项） 、申请接口数（个）、累计接口调用（次） 
var applyCityResourceQKUrl = ctx + "/shareResourceController/applyCityResourceQK";
// 市级资源提供响应情况 : 资源、接口
var cityZyProvideQKUrl = ctx + "/shareResourceController/cityZyProvideQK";
// 区县资源情况
var qxZyQkUrl = ctx + "/shareResourceController/qxZyQk";

//资源类型统计
jQuery.resourceTypeTj = function(){
	 $.ajax({
			type:"get",
			async:true,
			url:resourceTypeTjUrl,
			dataType:"json",
			success:function(result){
			var dataArray = new Array();
			var cataLogNum = 0;// 目录数
			var i =0;
			for(var key in result){
				var item = new Object();
				switch(key){
				case 'count_db_table': item.name = "库表";item.value= result[key];break;
				case 'count_file': item.name = "文件";item.value= result[key];break;
				case 'total_service': item.name = "接口";item.value= result[key];break;
				default:break;
				}
				dataArray[i] = item;
				i++;
			}
			
var chart2 = echarts.init(document.getElementById("chart2"));
var chartOption2 = {
		title : {
            text: '资源类型统计',
            x:'center',
            textStyle: {
                fontSize: '17',
                color: '#ffffff'
            }
        },	
        color: ['#0E7CE2', '#F8456B', '#002B00', '#4AEAB0'],
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            itemWidth: 16,
            itemHeight: 10,
            textStyle:{
                fontSize:12,
                color:'#fff'
            },
            data:['库表','接口','文件']
        },
        series: [
            {
                name:'资源类型',
                type:'pie',
                radius: ['50%', '70%'],
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
                data:dataArray
            }
        ]
    };
chart2.setOption(chartOption2);
			}
			});
}

// 各部门可共享资源目录数
jQuery.bmCatalogTj = function(){
	 $.ajax({
			type:"get",
			async:true,
			url:bmCatalogTjUrl,
			dataType:"json",
			success:function(result){
			var dataArrayName = new Array(); // 部门名称
			var cataLogNum = new Array(); // 目录数
			var yMax = 500; // y轴最大数
			for(var i = 0;i<result.length;i++){
				dataArrayName[i] =result[i]["name"] ;
				cataLogNum[i] = result[i]["cataLogNum"] ;
				if(i==0){
					yMax = 100+  result[0]["cataLogNum"] ;
				}
			}
			var dataAxis =dataArrayName; // x 轴数据
			var data = cataLogNum; // 柱状图数据
			var endPercent = (6 / dataAxis.length) * 100; // 设置最后长度
			var dataShadow = []; 
			for (var i = 0; i < data.length; i++) {
			    dataShadow.push(yMax);
			}
			var chart1 = echarts.init(document.getElementById("chart1"));
		    var chartOption1 =  {
		    	    title: {
		    	        text: '市级部门可共享资源目录数统计',
		    	        x:'center',
		                textStyle: {
		                    fontSize: '17',
		                    color: '#ffffff'
		                }
		    	    },
		    	    xAxis: {
		    	        data: dataAxis,
		    	        axisLabel: {
		    	            inside: false,
		    	            interval:0,
                            rotate:30,
		    	            textStyle: {
		    	            	fontSize:'14',
		    	                color: '#fff'
		    	            },
					        formatter:function(name){
		  	    	        	return (name.length > 5 ? (name.slice(0,5)+"...") : name ); 
		  	    	        },
		    	        },
		    	        axisTick: {
		    	            show: false
		    	        },
		    	        axisLine: {
		    	            show: false
		    	        },
		    	        z: 10
		    	    },
		    	    yAxis: {
		    	        axisLine: {
		    	            show: false
		    	        },
		    	        axisTick: {
		    	            show: false
		    	        },
		    	        axisLabel: {
		    	            textStyle: {
		    	             color: '#ffffff'
		    	            }
		    	        },
		    	        splitLine:{
					        lineStyle:{
						          type: 'dashed',
						          color: '#2e3450',
						        }
						      }
		    	    },
		    	    tooltip : {
		    	        trigger: 'axis',
		    	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		    	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		    	        },
		    	        formatter: function (params) {
		    	            var tar;
		    	            if (params[1].value != '-') {
		    	                tar = params[1];
		    	            }
		    	            else {
		    	                tar = params[0];
		    	            }
		    	            return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
		    	        }
		    	    },
		    	    dataZoom: [//给x轴设置滚动条  
	                           {  
	                               start:0,//默认为0  
	                               end: endPercent,  
	                               type: 'slider',  
	                               show: true,  
	                               xAxisIndex: [0],  
	                               handleSize: 0,//滑动条的 左右2个滑动条的大小  
	                               height: 8,//组件高度  
	                               left: 50, //左边的距离  
	                               right: 40,//右边的距离  
	                               bottom: 26,//右边的距离  
	                               handleColor: '#ddd',//h滑动图标的颜色  
	                               handleStyle: {  
	                                   borderColor: "#cacaca",  
	                                   borderWidth: "1",  
	                                   shadowBlur: 2,  
	                                   background: "#ddd",  
	                                   shadowColor: "#ddd",  
	                               },  
	                               fillerColor: new echarts.graphic.LinearGradient(1, 0, 0, 0, [{  
	                                   //给颜色设置渐变色 前面4个参数，给第一个设置1，第四个设置0 ，就是水平渐变  
	                                   //给第一个设置0，第四个设置1，就是垂直渐变  
	                                   offset: 0,  
	                                   color: '#1eb5e5'  
	                               }, {  
	                                   offset: 1,  
	                                   color: '#5ccbb1'  
	                               }]),  
	                               backgroundColor: '#D9D919',//两边未选中的滑动条区域的颜色  
	                               showDataShadow: false,//是否显示数据阴影 默认auto  
	                               showDetail: false,//即拖拽时候是否显示详细数值信息 默认true  
	                               handleIcon: 'M-292,322.2c-3.2,0-6.4-0.6-9.3-1.9c-2.9-1.2-5.4-2.9-7.6-5.1s-3.9-4.8-5.1-7.6c-1.3-3-1.9-6.1-1.9-9.3c0-3.2,0.6-6.4,1.9-9.3c1.2-2.9,2.9-5.4,5.1-7.6s4.8-3.9,7.6-5.1c3-1.3,6.1-1.9,9.3-1.9c3.2,0,6.4,0.6,9.3,1.9c2.9,1.2,5.4,2.9,7.6,5.1s3.9,4.8,5.1,7.6c1.3,3,1.9,6.1,1.9,9.3c0,3.2-0.6,6.4-1.9,9.3c-1.2,2.9-2.9,5.4-5.1,7.6s-4.8,3.9-7.6,5.1C-285.6,321.5-288.8,322.2-292,322.2z',  
	                               filterMode: 'filter'
	                           },  
	                           //下面这个属性是里面拖到  
	                           {  
	                               type: 'inside',  
	                               show: true,  
	                               xAxisIndex: [0],  
	                               start: 0,//默认为1  
	                               end: 50
	                           },  
	                       ],
		    	    series: [
		    	        { // For shadow
		    	            type: 'bar',
		    	            itemStyle: {
		    	                normal: {color: 'rgba(0,0,0,0.05)'}
		    	            },
		    	            barGap:'-100%',
		    	            barCategoryGap:'40%',
		    	            data: dataShadow,
		    	            animation: false
		    	        },
		    	        {
		    	            type: 'bar',
		    	            itemStyle: {
		    	                normal: {
		    	                    color: new echarts.graphic.LinearGradient(
		    	                        0, 0, 0, 1,
		    	                        [
		    	                            {offset: 0, color: '#83bff6'},
		    	                            {offset: 0.5, color: '#188df0'},
		    	                            {offset: 1, color: '#188df0'}
		    	                        ]
		    	                    ),
		    	        		label: {
									show: true, //开启显示
									position: 'top', //在上方显示
									textStyle: { //数值样式
										color: 'black',
										fontSize: 16,
										color:'#ffffff'
									}
								}
		    	                },
		    	                emphasis: {
		    	                    color: new echarts.graphic.LinearGradient(
		    	                        0, 0, 0, 1,
		    	                        [
		    	                            {offset: 0, color: '#2378f7'},
		    	                            {offset: 0.7, color: '#2378f7'},
		    	                            {offset: 1, color: '#83bff6'}
		    	                        ]
		    	                    )
		    	                }
		    	            },
		    	            data: data
		    	        }
		    	    ]
		    	};
		    chart1.setOption(chartOption1);
		    	// Enable data zoom when user click bar.
		    	var zoomSize = 6;
		    	chart1.on('click', function (params) {
		    	    console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
		    	    chart1.dispatchAction({
		    	        type: 'dataZoom',
		    	        startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
		    	        endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
		    	    });
		    	});
			}
			});
}
// 现有资源数 :资源数、有效库表、数据量、接口、文件
jQuery.xyResourceTj = function(){
	$.ajax({
		type:'get',
		url:xyResourceTjUrl,
		async:true,
		dataType:'json',
		success:function(result){
			// 资源数
			var zyTjList = result["zyTjList"];
			var dataZy = []; // 资源数
			var dataZyBM =[]; // 资源部门名称
			var rowsZy = zyTjList.length;
			if(rowsZy>15){
				rowsZy = 15;
			}else if(rowsZy !=0 && rowsZy<=15){
				rowsZy =  zyTjList.length;
			}
			for(var i=0;i<rowsZy;i++){
				dataZy.push(zyTjList[i]["zyNum"]);
				dataZyBM.push(zyTjList[i]["organ_name"]);
			}
			// 有效库表
			var kbTjList = result["kbTjList"];
			var dataKb = []; // 库表
			var dataKbBM =[]; // 库表部门名称
			var rowsKb = kbTjList.length;
			if(rowsKb>15){
				rowsKb = 15;
			}else if(rowsKb !=0 && rowsKb<=15){
				rowsKb =  kbTjList.length;
			}
			for(var i=0;i<rowsKb;i++){
				dataKb.push(kbTjList[i]["kbNum"]);
				dataKbBM.push(kbTjList[i]["organ_name"]);
			}
			// 数据量
			var shjLTjList = result["shjLTjList"];
			var dataShj =[]; 
			var dataShjLBM =[]; // 数据量部门名称
			var rowsShjL = shjLTjList.length;
			if(rowsShjL>10){
				rowsShjL = 10;
			}else if(rowsShjL !=0 && rowsShjL<=10){
				rowsShjL =  shjLTjList.length;
			}
			for(var i=0;i<rowsShjL;i++){
				dataShj.push(shjLTjList[i]["shjNum"]);
				dataShjLBM.push(shjLTjList[i]["organ_name"]);
			}
			// 接口
			var jkTjList = result["jkTjList"];
			var dataJk = [];
			var dataJKBM =[];
			var rowsJk = jkTjList.length;
			if(rowsJk>15){
				rowsJk = 15;
			}else if(rowsJk !=0 && rowsJk<=15){
				rowsJk =  jkTjList.length;
			}
			
			for(var i=0;i<rowsJk;i++){
				dataJk.push(jkTjList[i]["jkNum"]);
				dataJKBM.push(jkTjList[i]["organ_name"]);
			}
			// 文件
			var wjTjList =  result["wjTjList"];
			var dataWj = [];
			var dataWjBM =[];
			var rowsWj = wjTjList.length;
			if(rowsWj>15){
				rowsWj = 15;
			}else if(rowsWj !=0 && rowsWj<=15){
				rowsWj =  wjTjList.length;
			}
			for(var i=0;i<rowsWj;i++){
				dataWj.push(wjTjList[i]["wjNum"]);
				dataWjBM.push(wjTjList[i]["organ_name"]);
			}
			//显示数据，可修改
		    var chart3 = echarts.init(document.getElementById("chart3"));
		    var chartOption3 =  {
		            title: {
		            	text : '市级部门现有资源统计 ',
		            	left:'20px',
		            	textStyle : {
		            		fontSize : '17',
		            		color : '#ffffff'
		            	}
		            	},
		            tooltip: {
		                 trigger: "axis",  
		            },
		            legend: {
		                itemWidth:15,  
		                itemHeight:15,  
		                data:['资源数','库表','数据量','接口','文件'],
		                textStyle: {
		                    color: '#ffffff'          // 图例文字颜色
		               },
		               selected : {
		            	   '库表' : false,
		                   '数据量' : false,
		                   '接口' : false,
		                   '文件':false
		               },
		               selectedMode : "single"
		            },
		            xAxis: {
		                data: dataZyBM,
		                splitLine:{
		                    show:false,
		                },
		        
		                axisLabel: {
		                	inside: false,
			    	         interval:0,
	                         rotate:40,
		    	            textStyle: {
		    	            	fontSize:'14',
		    	             color: '#ffffff'
		    	            	 
		    	            },
					        formatter:function(name){
		  	    	        	return (name.length > 5 ? (name.slice(0,5)+"...") : name ); 
		  	    	        },
		    	        }
		            },
		            yAxis: {
		                 splitLine:{
		                    show:true,
		                },
		                axisLabel: {
		    	            textStyle: {
		    	             color: '#ffffff'
		    	            }
		    	        },
					      splitLine:{
						        lineStyle:{
						          type: 'dashed',
						          color: '#2e3450',
						        }
						      }
		            },
		            series: [{
		                name: '资源数',
		                type: 'bar',
		                barWidth : 25,
		                data: dataZy,
		                itemStyle:{
		                    normal:{
		                        label: {
		                            show: true,//是否展示
		                        },
		                        color:'#238E23'
		                    }
		                }
		            },
		                     
		              {
		                name: '库表',
		                type: 'bar',
		                barWidth : 25,
		                data: dataKb,
		                itemStyle:{
		                    normal:{
		                        label: {
		                            show: true,//是否展示
		                        },
		                        color:'#B49'
		                    }
		                }
		            },
		            {
		                name: '数据量',
		                type: 'bar',
		                barWidth : 25,
		                data: dataShj,
		                 itemStyle:{
		                    normal:{
		                        label: {
		                            show: true,//是否展示
		                        },
		                       
		                        color:'#3366FF'
		                    }
		                }
		            },
		                {
		                name: '接口',
		                type: 'bar',
		                barWidth : 25,
		                data: dataJk,
		                 itemStyle:{
		                    normal:{
		                        label: {
		                            show: true,//是否展示
		                        },
		                        color:'#e5323e'
		                    }
		                }
		                },
		                {
		                name: '文件',
		                type: 'bar',
		                barWidth : 25,
		                data: dataWj,
		                 itemStyle:{
		                    normal:{
		                        label: {
		                            show: true,//是否展示
		                        },
		                        color:'#238E23'
		                    }
		                }
		                
		            }
		                ]
		        };
		     // 使用刚指定的配置项和数据显示图表。
		     chart3.setOption(chartOption3,true);
		    // 图例选中事件
		    chart3.on('legendselectchanged', function(obj) {
		        var selected = obj.selected;
		        var legend = obj.name;
						        
				switch (legend) {
				 case '资源数':
							chartOption3.xAxis.data = dataZyBM;// 修改x轴数据
							chartOption3.series[0].data = dataZy;// 修改数据
							chartOption3.legend.selected = {'资源数':true,'库表' : false,'数据量' : false,'接口' : false,'文件' : false};// 修改图例选中状态
							chart3.setOption(chartOption3);// 重新加载图表  
							break;
		       case '库表':	chartOption3.xAxis.data=dataKbBM;// 修改x轴数据
		        				chartOption3.series[0].data=dataKb;// 修改数据
		        				chartOption3.legend.selected = {'资源数':false,'库表':true,'数据量':false,'接口':false,'文件':false};// 修改图例选中状态
		        				chart3.setOption(chartOption3);// 重新加载图表  
		        				break;
		        case '数据量':chartOption3.xAxis.data=dataShjLBM;
		        			  chartOption3.series[0].data= dataShj;
		        			  chartOption3.legend.selected = {'资源数':false,'库表':false,'数据量':true,'接口':false,'文件':false};
		        			  chart3.setOption(chartOption3);// 重新加载图表  
		        				break;
		        case '接口':	chartOption3.xAxis.data=dataJKBM;
		        			chartOption3.series[0].data= dataJk;
		        			 chartOption3.legend.selected = {'资源数':false,'库表':false,'数据量':false,'接口':true,'文件':false};
		        			chart3.setOption(chartOption3);// 重新加载图表  
		        			break;
		        case '文件':chartOption3.xAxis.data=dataWjBM;
    						chartOption3.series[0].data= dataWj;
    						chartOption3.legend.selected = {'资源数':false,'库表':false,'数据量':false,'接口':false,'文件':true};
    						chart3.setOption(chartOption3);// 重新加载图表  
    						break;
		        }
				 chart3.resize();
		    });
		}
	});
}
// 现有资源数弹出框初始化
jQuery.xyZyQk_Prop = function(type){
	$("#xyResourceProp tbody").html("");
	$("#xyResourceTotalProp tbody").html("");
	$("#thName").html("");
	$.ajax({
		type:'get',
		url:xyResourceTjUrl,
		async:true,
		dataType:'json',
		success:function(result){
			var htmlElement = "";
			if(type=="0"){
				$("#xyResourceTotalProp").css("display","none");
				$("#xyResourceProp").css("display","table");
				$("#thName").html("库表数(张)");
				$("#shjLNum").css("display","block");
				// 有效库表、数据量
				var kbTjList = result["kbTjList"];
				
				var dataKb = []; // 库表
				var dataKbBM =[]; // 库表部门名称
				var dataShj =[]; // 数据量
				var rowsKb = kbTjList.length;
				for(var i=0;i<rowsKb;i++){
					dataKb.push(kbTjList[i]["kbNum"]);
					dataKbBM.push(kbTjList[i]["organ_name"]);
					dataShj.push(kbTjList[i]["shjNum"]);
				}
				
				// 生成html
				var gen_html = "";
				for(var i=0;i<dataKbBM.length;i++){
					gen_html +="<tr>";
					gen_html +="<td>"+(i+1)+"</td>";
					gen_html +="<td class='bmNameLeft'>"+dataKbBM[i]+"</td>"; // 部门名称
					gen_html +="<td>"+dataKb[i]+"</td>"; // 库表
					gen_html +="<td>"+dataShj[i]+"</td>"; // 数据量
					gen_html +="</tr>";
				}
				htmlElement = gen_html;
				
			}else if(type=="1"){
				$("#xyResourceTotalProp").css("display","none");
				$("#xyResourceProp").css("display","table");
				$("#thName").html("接口(个)");
				$("#shjLNum").css("display","none");
				// 接口
				var jkTjList = result["jkTjList"];
				var dataJk = [];
				var dataJKBM =[];
				var rowsJk = jkTjList.length;
				for(var i=0;i<rowsJk;i++){
					dataJk.push(jkTjList[i]["jkNum"]);
					dataJKBM.push(jkTjList[i]["organ_name"]);
				}
				// 生成html
				htmlElement = generateHtml(dataJKBM,dataJk);
			}else if(type=="2"){
				$("#xyResourceTotalProp").css("display","none");
				$("#xyResourceProp").css("display","table");
				$("#thName").html("文件(类)");
				$("#shjLNum").css("display","none");
				// 文件
				var wjTjList =  result["wjTjList"];
				var dataWj = [];
				var dataWjBM =[];
				var rowsWj = wjTjList.length;
				for(var i=0;i<rowsWj;i++){
					dataWj.push(wjTjList[i]["wjNum"]);
					dataWjBM.push(wjTjList[i]["organ_name"]);
				}
				// 生成html
				htmlElement = generateHtml(dataWjBM,dataWj);
			}else if(type=="3"){
				$("#xyResourceProp").css("display","none");
				$("#xyResourceTotalProp").css("display","table");
				// 资源总数
				var zyTjList =  result["zyTjList"];
				var dataWj = [];
				var dataWjBM =[];
				var rowsZy = zyTjList.length;
				var htmlstr = "";
				for(var i=0;i<rowsZy;i++){
					htmlstr +="<tr>";
					htmlstr +="<td>"+(i+1)+"</td>";
					htmlstr +="<td class='bmNameLeft'>"+zyTjList[i]["organ_name"]+"</td>"; // 部门名称
					htmlstr +="<td>"+zyTjList[i]["zyNum"]+"</td>"; // 资源
					htmlstr +="<td>"+zyTjList[i]["kbNum"]+"</td>"; // 库表（张）
					htmlstr +="<td>"+zyTjList[i]["jkNum"]+"</td>"; // 接口（个）
					htmlstr +="<td>"+zyTjList[i]["wjNum"]+"</td>"; // 文件（类）
					htmlstr +="</tr>";
				}
				$("#xyResourceTotalProp tbody").append(htmlstr);
			}
			if(type!="3"){
				$("#xyResourceProp tbody").append(htmlElement);	
			}
			
		}
	});
	
}

// 生成html
function generateHtml(bmList,dataList){
	var gen_html = "";
	for(var i=0;i<bmList.length;i++){
		gen_html +="<tr>";
		gen_html +="<td>"+(i+1)+"</td>";
		gen_html +="<td class='bmNameLeft'>"+bmList[i]+"</td>"; // 部门名称
		gen_html +="<td>"+dataList[i]+"</td>"; // 数据
		gen_html +="</tr>";
	}
	return gen_html;
}
// 现有资源弹出框：下载
function xyResourceDownload(){
	window.location.href = ctx + "/shareResourceController/xyResourceDownload";
}
// 申请省级资源情况:申请接口数、 累计接口调用
jQuery.shqshjResourceQk = function(type){
	$("#shqshjResource tbody").html("");
	$.ajax({
		type:'get',
		url:shqshjResourceQkUrl,
		async:true,
		dataType:'json',
		success:function(result){
				var shQzyList = result["shQzyList"]; // 申请资源数
				var ljJkDyList = result["ljJkDyList"];// 累计接口调用
				var rowsShQzy = shQzyList.length;
				var rowsLj = ljJkDyList.length;
				
					if(rowsLj>5){
						rowsLj = 5;
					}else if(rowsLj!=0 && rowsLj<=5){
						rowsLj = ljJkDyList.length;
					}
				var applyHtml = "";
				for(var i=0;i<rowsLj;i++){
					var applyNum = 0;
					for(var j=0;j<rowsShQzy;j++){
						if(ljJkDyList[i]["organ_name"]==shQzyList[j]["organ_name"]){
							applyNum = shQzyList[j]["applyNum"];
							break;
						}else{
							applyNum = 0;
						}
					}
					applyHtml +="<tr>";
					applyHtml +="<td>"+(i+1)+"</td>";
					applyHtml +="<td class='shqshjResourceBM'>"+ljJkDyList[i]["organ_name"]+"</td>"; // 部门名称
					applyHtml +="<td>"+applyNum+"</td>"; // 申请资源数 
					applyHtml +="<td>"+ ljJkDyList[i]["JkNum"] +"</td>"; // 累计接口调用次数  
					applyHtml +="</tr>";
				}
				htmlElement =applyHtml; 
			$("#shqshjResource tbody").append(htmlElement);
			}
	});
}
//申请省级资源情况弹出框初始化
jQuery.shqshjResourceQk_Prop = function(){
	$("#shqshjResourceProp tbody").html("");
	$.ajax({
		type:'get',
		url:shqshjResourceQkUrl,
		async:true,
		dataType:'json',
		success:function(result){
			var shQzyList = result["shQzyList"]; // 申请资源数
			var ljJkDyList = result["ljJkDyList"];// 累计接口调用
			var rowsShQzy = shQzyList.length;
			var rowsLj = ljJkDyList.length;
			var applyHtml = "";
			for(var i=0;i<rowsShQzy;i++){
				var ljJkNum = 0;
				for(var j=0;j<rowsLj;j++){
					if(shQzyList[i]["organ_name"]==ljJkDyList[j]["organ_name"]){
						ljJkNum = ljJkDyList[j]["JkNum"];
						break;
					}else{
						ljJkNum = 0;
					}
				}
				applyHtml +="<tr>";
				applyHtml +="<td>"+(i+1)+"</td>";
				applyHtml +="<td class='shqshjResourceBM'>"+shQzyList[i]["organ_name"]+"</td>"; // 部门名称
				applyHtml +="<td>"+shQzyList[i]["applyNum"]+"</td>"; // 申请接口数 
				applyHtml +="<td>"+ljJkNum+"</td>"; // 累计接口调用 
				applyHtml +="</tr>";
			}
			$("#shqshjResourceProp tbody").append(applyHtml);
		}
	});
	
}

//申请省级资源情况弹出框：下载
function shQShjZyDownload(){
	window.location.href = ctx + "/shareResourceController/shQShjZyDownload";
}
// 申请市级资源情况:申请资源数（项） 、申请接口数（个）、累计接口调用（次） 
jQuery.applyCityResourceQK = function(){
	$.ajax({
		type:'get',
		url:applyCityResourceQKUrl,
		async:true,
		dataType:'json',
		success:function(result){
			// 申请资源数（项）
			var applyZyList = result["applyZyList"];
			var dataApplyZy = []; // 数据
			var dataZyBM =[]; // 部门名称
			var rowsZy = applyZyList.length;
			if(rowsZy>8){
				rowsZy = 8;
			}else if(rowsZy !=0 && rowsZy<=8){
				rowsZy =  applyZyList.length;
			}
			for(var i=0;i<rowsZy;i++){
				dataApplyZy.push(applyZyList[i]["zyNum"]);
				dataZyBM.push(applyZyList[i]["organ_name"]);
			}
			// 申请接口数（个）
			var applyJkList = result["applyJkList"];
			var dataApplyJk =[]; 
			var dataJkLBM =[]; // 数据量部门名称
			var rowsJk = applyJkList.length;
			if(rowsJk>8){
				rowsJk = 8;
			}else if(rowsJk !=0 && rowsJk<=8){
				rowsJk =  applyJkList.length;
			}
			for(var i=0;i<rowsJk;i++){
				dataApplyJk.push(applyJkList[i]["jkNum"]);
				dataJkLBM.push(applyJkList[i]["organ_name"]);
			}
			// 累计接口调用（次）
			var totalJkDyList = result["totalJkDyList"];
			var dataTotalJk = [];
			var dataTotalJKBM =[];
			var rowstjJk = totalJkDyList.length;
			if(rowstjJk>8){
				rowstjJk = 8;
			}else if(rowstjJk !=0 && rowstjJk<=8){
				rowstjJk =  totalJkDyList.length;
			}
			
			for(var i=0;i<rowsJk;i++){
				dataTotalJk.push(totalJkDyList[i]["ljjkNum"]);
				dataTotalJKBM.push(totalJkDyList[i]["organ_name"]);
			}
		
			//显示数据，可修改
		    var chart7 = echarts.init(document.getElementById("chart7"));
		    var chartOption7 =  {
		            title: {
		            	text : '申请市级资源情况 ',
		            	textStyle : {
		            		fontSize : '17',
		            		color : '#ffffff'
		            	}
		            	},
		            tooltip: {
		                 trigger: "axis",  
		            },
		            legend: {
		                itemWidth:15,  
		                itemHeight:15,  
		                data:['申请资源数','申请接口数','累计接口调用'],
		                textStyle: {
		                    color: '#ffffff'          // 图例文字颜色
		               },
		               selected : {
		                   '申请接口数' : false,
		                   '累计接口调用' : false,
		               },
		               selectedMode : "single"
		            },
		            xAxis: {
		                data: dataZyBM,
		                splitLine:{
		                    show:false,
		                },
		        
		                axisLabel: {
		                	inside: false,
			    	         interval:0,
	                         rotate:40,
		    	            textStyle: {
		    	            	fontSize:'14',
		    	             color: '#ffffff'
		    	            	 
		    	            },
					        formatter:function(name){
		  	    	        	return (name.length > 5 ? (name.slice(0,5)+"...") : name ); 
		  	    	        },
		    	        }
		            },
		            yAxis: {
		                 splitLine:{
		                    show:true,
		                },
		                axisLabel: {
		    	            textStyle: {
		    	             color: '#ffffff'
		    	            }
		    	        },
					      splitLine:{
						        lineStyle:{
						          type: 'dashed',
						          color: '#2e3450',
						        }
						      }
		            },
		            series: [{
		                name: '申请资源数',
		                type: 'bar',
		                barWidth : 25,
		                data: dataApplyZy,
		                itemStyle:{
		                    normal:{
		                        label: {
		                            show: true,//是否展示
		                        },
		                        color:'#3FBB49'
		                    }
		                }
		            },
		            {
		                name: '申请接口数',
		                type: 'bar',
		                barWidth : 25,
		                data: dataApplyJk,
		                 itemStyle:{
		                    normal:{
		                        label: {
		                            show: true,//是否展示
		                        },
		                        color:'#FF8849'
		                    }
		                }
		            },
		                {
		                name: '累计接口调用',
		                type: 'bar',
		                barWidth : 25,
		                data: dataTotalJk,
		                 itemStyle:{
		                    normal:{
		                        label: {
		                            show: true,//是否展示
		                        },
		                        color:'#B49'
		                    }
		                }
		                }
		                ]
		        };
		        // 使用刚指定的配置项和数据显示图表。
		    chart7.setOption(chartOption7,true);
		   // 图例选中事件
		    chart7.on('legendselectchanged', function(obj) {
		        var selected = obj.selected;
		        var legend = obj.name;
		        switch(legend){
		        case '申请资源数':
		        				chartOption7.xAxis.data=dataZyBM;
		        				chartOption7.series[0].data=dataApplyZy;
		        				chartOption7.legend.selected = {'申请资源数':true,'申请接口数':false,'累计接口调用':false};
		        				chart7.setOption(chartOption7,true);
		        				break;
		        case '申请接口数':chartOption7.xAxis.data=dataJkLBM;
		        			  chartOption7.series[0].data= dataApplyJk;
		        			  chartOption7.legend.selected = {'申请资源数':false,'申请接口数':true,'累计接口调用':false};
		        				chart7.setOption(chartOption7,true);
		        				break;
		        case '累计接口调用':chartOption7.xAxis.data=dataTotalJKBM;
		        				chartOption7.series[0].data= dataTotalJk;
		        				chartOption7.legend.selected = {'申请资源数':false,'申请接口数':false,'累计接口调用':true};
		        				chart7.setOption(chartOption7,true);
		        				break;
		      
		        }
		        chart7.resize();
		    });
		}
	});
}
// 申请市级资源情况弹出框初始化
jQuery.shqcityResourceQk_Prop = function(type){
	$("#shqcityResourceProp tbody").html("");
	$.ajax({
		type:'get',
		url:applyCityResourceQKUrl,
		async:true,
		dataType:'json',
		success:function(result){
			var htmlElement ="";
			// type:"0" 申请资源数Tab ，"1"表示申请接口数、累计接口调用Tab
			if(type=="0"){
				$("#applyZyTh").html("申请资源数（项）");
				$("#applyJkTh").css("display","none");
				var applyZyList = result["applyZyList"];
				var rowsShQzy = applyZyList.length;
				var applyHtml = "";
				for(var i=0;i<rowsShQzy;i++){
					applyHtml +="<tr>";
					applyHtml +="<td>"+(i+1)+"</td>";
					applyHtml +="<td class='shqshjResourceBM'>"+applyZyList[i]["organ_name"]+"</td>"; // 部门名称
					applyHtml +="<td>"+applyZyList[i]["zyNum"]+"</td>"; // 申请资源数 
					applyHtml +="<td>"+applyZyList[i]["zyCount"]+"</td>"; // 申请数 （次）
					applyHtml +="<td>"+applyZyList[i]["tgCount"]+"</td>"; // 申请通过数 （次）
					applyHtml +="<td>"+applyZyList[i]["bhCount"]+"</td>"; // 申请驳回数 （次）
					applyHtml +="</tr>";
				}
				htmlElement =applyHtml; 
			}else if(type=="1"){
				$("#applyZyTh").html("申请接口数（个）");
				$("#applyJkTh").html("累计接口调用（次）");
				$("#applyJkTh").css("display","block");
				var applyJkList = result["applyJkList"]; // 申请接口数
				var totalJkDyList = result["totalJkDyList"]; // 累计申请接口数
				var rowsJkDy = applyJkList.length;
				var rowsTotalJk = totalJkDyList.length;
				var jkHtml = "";
				for(var i=0;i<rowsJkDy;i++){
					
					jkHtml +="<tr>";
					jkHtml +="<td>"+(i+1)+"</td>";
					jkHtml +="<td class='shqshjResourceBM'>"+applyJkList[i]["organ_name"]+"</td>"; // 部门名称
					jkHtml +="<td>"+applyJkList[i]["jkNum"]+"</td>"; // 申请接口数
					jkHtml +="<td>"+applyJkList[i]["jkCount"]+"</td>"; // 申请数 （次）
					jkHtml +="<td>"+applyJkList[i]["tgCount"]+"</td>"; // 申请通过数 （次）
					jkHtml +="<td>"+applyJkList[i]["bhCount"]+"</td>"; // 申请驳回数 （次）
					jkHtml +="<td>"+applyJkList[i]["ljjkNum"]+"</td>"; // 累计接口调用数
					jkHtml +="</tr>";
				}
				htmlElement =jkHtml; 
			}
			
			$("#shqcityResourceProp tbody").append(htmlElement);
		}
	});
}
//申请市级资源情况弹出框：下载
function shqCityzyDownload(){
	window.location.href = ctx + "/shareResourceController/shqCityzyDownload";
}
// 市级资源提供响应情况 : 资源
jQuery.cityZyProvideQK = function() {
	var chart5 = echarts.init(document.getElementById("chart5"));
	$.ajax({
		type:'get',
		url:cityZyProvideQKUrl,
		async:true,
		dataType:'json',
		success : function(result) {
			var bShqZyList = result["bShqZyList"]; // 资源：被申请项数
			var bShqZyCshList = result["bShqZyCshList"]; // 资源：被申请次数
			var bShqZyTgList = result["bShqZyTgList"]; // 资源：被申请通过次数
			var bmArray = []; // 部门
			var bShqZy = [];// 被申请项数
			var bShqZyCount = [];// 被申请次数
			var bShqZyTgCount = [];// 被申请通过次数
			var rows = bShqZyList.length;
			// 默认显示5个部门的数据
			if(rows>5){
				rows = 5;
			}
			for(var i = 0;i<rows;i++){
				var bm = bShqZyList[i]["organ_name"];
				bmArray.push(bm);
				bShqZy.push(bShqZyList[i]["bzy"]);// 被申请项数
				var bShqCount = 0
				for(var j =0;j<bShqZyCshList.length;j++){
					if(bm == bShqZyCshList[j]["organ_name"]){
						bShqCount = bShqZyCshList[j]["bshzy"];
						break;
					}
				}
				bShqZyCount.push(bShqCount);// 资源：被申请次数
				var bShqTgCount = 0;
				for(var k =0;k<bShqZyTgList.length;k++){
					if(bm == bShqZyTgList[k]["organ_name"]){
						bShqTgCount = bShqZyTgList[k]["bshtgzy"];
						break;
					}
				}
				bShqZyTgCount.push(bShqTgCount);// 资源：被申请通过次数
			}
			var posList = [ 'left', 'right', 'top', 'bottom', 'inside',
					'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
					'insideTopLeft', 'insideTopRight', 'insideBottomLeft',
					'insideBottomRight' ];

			app.configParameters = {
				rotate : {
					min : -90,
					max : 90
				},
				align : {
					options : {
						left : 'left',
						center : 'center',
						right : 'right'
					}
				},
				verticalAlign : {
					options : {
						top : 'top',
						middle : 'middle',
						bottom : 'bottom'
					}
				},
				position : {
					options : echarts.util.reduce(posList, function(map, pos) {
						map[pos] = pos;
						return map;
					}, {})
				},
				distance : {
					min : 0,
					max : 100
				}
			};

			app.config = {
				rotate : 90,
				align : 'left',
				verticalAlign : 'middle',
				position : 'insideBottom',
				distance : 15,
				onChange : function() {
					var labelOption = {
						normal : {
							rotate : app.config.rotate,
							align : app.config.align,
							verticalAlign : app.config.verticalAlign,
							position : app.config.position,
							distance : app.config.distance
						}
					};
				}
			};

			var labelOption = {
				normal : {
					show : true,
					position : app.config.position,
					distance : app.config.distance,
					align : app.config.align,
					verticalAlign : app.config.verticalAlign,
					rotate : app.config.rotate,
					formatter : '{c}  {name|{a}}',
					fontSize : 16,
					rich : {
						name : {
							textBorderColor : '#fff'
						}
					}
				}
			};
			var chartOption5 = {
				color : [ '#B49', '#006699', '#e5323e' ],
				title : {
					text : '市级资源提供情况 ',
					textStyle : {
						fontSize : '17',
						color : '#ffffff'
					}
				},
				tooltip : {
					trigger : 'axis',
					axisPointer : {
						type : 'shadow'
					}
				},
				legend : {
					data : [ '被申请项数', '被申请次数', '被申请通过次数' ],
					textStyle : {
						color : '#ffffff' // 图例文字颜色
					},
				},
				calculable : true,
				xAxis : [ {
					type : 'category',
					splitLine : {
						show : false,
					},
					axisLabel : {
						inside : false,
						interval : 0,
						rotate : 40,
						textStyle : {
							fontSize : '14',
							color : '#ffffff'
						},
						formatter:function(name){
	  	    	        	return (name.length > 5 ? (name.slice(0,5)+"...") : name ); 
	  	    	        },
					},
			        
					axisTick : {
						show : false
					},
					data : bmArray // x轴数据

				}

				],

				yAxis : [

				{
					type : 'value',
					splitLine : {
						show : true,
					},
					axisLabel : {
						textStyle : {
							color : '#ffffff'
						}
					},
				      splitLine:{
					        lineStyle:{
					          type: 'dashed',
					          color: '#2e3450',
					        }
					      }
				}

				],
				series : [ {
					name : '被申请项数',
					type : 'bar',
					barGap : 0,
					data : bShqZy,
					itemStyle:{
	                    normal:{
	                        label: {
	                            show: true,//是否展示
	                        },
	                    }
	                },
				},
				{
					name : '被申请次数',
					type : 'bar',
					data : bShqZyCount,
					itemStyle:{
	                    normal:{
	                        label: {
	                            show: true,//是否展示
	                        },
	                    }
	                },
				},
				{
					name : '被申请通过次数',
					type : 'bar',
					data : bShqZyTgCount,
					itemStyle:{
	                    normal:{
	                        label: {
	                            show: true,//是否展示
	                        },
	                    }
	                },
				} ]
			};
			chart5.setOption(chartOption5);
		}
	});
	
}

// 市级资源提供响应情况弹出框初始化
jQuery.cityzyProvideQk_Prop = function(type){
	$("#cityzyProvideProp tbody").html("");
	$.ajax({
		type:'get',
		url:cityZyProvideQKUrl,
		async:true,
		dataType:'json',
		success:function(result){
			var htmlElement ="";
			// type:"0" 资源数Tab ，"1" 接口数Tab
			if(type=="0"){
				$("#bmCss").css("width","");
				var bShqZyList = result["bShqZyList"]; // 资源：被申请项数
				var bShqZyCshList = result["bShqZyCshList"]; // 资源：被申请次数
				var bShqZyTgList = result["bShqZyTgList"]; // 资源：被申请通过次数
				var bmArray = []; // 部门
				var bShqZy = [];// 被申请项数
				var bShqZyCount = [];// 被申请次数
				var bShqZyTgCount = [];// 被申请通过次数
				var rows = bShqZyList.length;
				// 默认显示5个部门的数据
				for(var i = 0;i<rows;i++){
					var bm = bShqZyList[i]["organ_name"];
					bmArray.push(bm);
					bShqZy.push(bShqZyList[i]["bzy"]);// 被申请项数
					var bShqCount = 0
					for(var j =0;j<bShqZyCshList.length;j++){
						if(bm == bShqZyCshList[j]["organ_name"]){
							bShqCount = bShqZyCshList[j]["bshzy"];
							break;
						}
					}
					bShqZyCount.push(bShqCount);// 资源：被申请次数
					var bShqTgCount = 0;
					for(var k =0;k<bShqZyTgList.length;k++){
						if(bm == bShqZyTgList[k]["organ_name"]){
							bShqTgCount = bShqZyTgList[k]["bshtgzy"];
							break;
						}
					}
					bShqZyTgCount.push(bShqTgCount);// 资源：被申请通过次数
				}
				var applyHtml = "";
				for(var i=0;i<rows;i++){
					applyHtml +="<tr>";
					applyHtml +="<td>"+(i+1)+"</td>";
					applyHtml +="<td class='shqshjResourceBM'>"+bmArray[i]+"</td>"; // 部门名称
					applyHtml +="<td>"+bShqZy[i]+"</td>"; // 被申请数（项） 
					applyHtml +="<td>"+bShqZyCount[i]+"</td>"; // 被申请次数（次）
					applyHtml +="<td>"+bShqZyTgCount[i]+"</td>"; // 被申请通过次数（次） 
					applyHtml +="</tr>";
				}
				htmlElement =applyHtml; 
			}else if(type=="1"){
				
				var bShqJkList = result["bShqJkList"]; // 资源：被申请项数
				var bShqJkCshList = result["bShqJkCshList"]; // 资源：被申请次数
				var bShqJkTgList = result["bShqJkTgList"]; // 资源：被申请通过次数
				var bmArray = []; // 部门
				var bShqJk = [];// 被申请项数
				var bShqJkCount = [];// 被申请次数
				var bShqJkTgCount = [];// 被申请通过次数
				var rows = bShqJkList.length;
				// 默认显示5个部门的数据
				for(var i = 0;i<rows;i++){
					var bm = bShqJkList[i]["org_name"];
					bmArray.push(bm);
					bShqJk.push(bShqJkList[i]["bjkNum"]);// 被申请项数
					var bShqCount = 0
					for(var j =0;j<bShqJkCshList.length;j++){
						if(bm == bShqJkCshList[j]["org_name"]){
							bShqCount = bShqJkCshList[j]["bjkCount"];
							break;
						}
					}
					bShqJkCount.push(bShqCount);// 资源：被申请次数
					var bShqTgCount = 0;
					for(var k =0;k<bShqJkTgList.length;k++){
						if(bm == bShqJkTgList[k]["org_name"]){
							bShqTgCount = bShqJkTgList[k]["btgCount"];
							break;
						}
					}
					bShqJkTgCount.push(bShqTgCount);// 资源：被申请通过次数
				}
				var applyHtml = "";
				for(var i=0;i<rows;i++){
					applyHtml +="<tr>";
					applyHtml +="<td>"+(i+1)+"</td>";
					applyHtml +="<td class='shqshjResourceBM'>"+bmArray[i]+"</td>"; // 部门名称
					applyHtml +="<td>"+bShqJk[i]+"</td>"; // 被申请数（项） 
					applyHtml +="<td>"+bShqJkCount[i]+"</td>"; // 被申请次数（次）
					applyHtml +="<td>"+bShqJkTgCount[i]+"</td>"; // 被申请通过次数（次） 
					applyHtml +="</tr>";
				}
				htmlElement =applyHtml; 
			}
			
			$("#cityzyProvideProp tbody").append(htmlElement);
		}
	});
}
// 市级资源提供响应情况弹出框：下载
function cityzyProvideDownload(){
	window.location.href = ctx + "/shareResourceController/cityZyProvideDownload";
}
// 区县资源情况
jQuery.qxZyQk = function(){
	$("#qxzyqkTable tbody").html("");
	$.ajax({
		type:"post",
		url:qxZyQkUrl,
		async:true,
		dataType:"json",
		success:function(result){
			var zyList = result["zyList"]; // 数据资源目录总数
			var gzZymLListN = result["gzZymLListN"]; // 已挂接资源目录数（新）
			// 注释原因：旧表往新表中导数据，表处于数据整理阶段，暂且暂停。
			// var gzZymLListO = result["gzZymLListO"]; // 已挂接资源目录数（旧）
			var gzJkList = result["gzJkList"]; // 接口
			var gzKbList = result["gzKbList"]; // 库表
			var rowsQx = zyList.length;
			var qxHtml = "";
			for(var i=0;i<rowsQx;i++){
					// 已挂接：文件（新）
				var gzZymL = 0;
				for(var j = 0;j<gzZymLListN.length;j++){
					if(gzZymLListN[j]["region_name"]==zyList[i]["region_name"]){
						gzZymL = gzZymLListN[j]["zygjNum_x"];
						break;
					}
				}
				// 已挂接：文件（旧）---旧表往新表中导数据，表处于数据整理阶段，暂且暂停对旧表数据的统计。
				/*for(var k = 0;k<gzZymLListO.length;k++){
					if(gzZymLListO[k]["region_name"]==zyList[i]["region_name"]){
						gzZymL += gzZymLListO[k]["zygjNum_o"];
						break;
					}
				}*/
				// 已挂接：接口
				for(var k = 0;k<gzJkList.length;k++){
				if(gzJkList[k]["region_name"]==zyList[i]["region_name"]){
					gzZymL += gzJkList[k]["qxjkNum"];
					break;
				    }
			     }
				// 已挂接：库表--仅为济南市数据
				for(var j = 0;j<gzKbList.length;j++){
				if(gzKbList[j]["region_name"]==zyList[i]["region_name"]){
					gzZymL += gzKbList[j]["jnkbNum"];
					break;
				    }
			     }
				// 已挂接百分比
				var percent = (gzZymL==0||zyList[i]["zymlNum"]==0)?('0.00'+'%'):((gzZymL/zyList[i]["zymlNum"] *100).toFixed(2)+'%')
				qxHtml +="<tr>";
				qxHtml +="<td>"+(i+1)+"</td>";
				qxHtml +="<td><span title='"+zyList[i]["organ_name"]+"'>"+zyList[i]["region_name"]+"</td>"; // 部门名称
				qxHtml +="<td>"+zyList[i]["zymlNum"]+"</td>"; // 数据资源目录总数
				qxHtml +="<td>"+gzZymL+"</td>"; // 已挂接资源目录数
				qxHtml +="<td>"+percent+"</td>"; // 已挂接百分比
				qxHtml +="</tr>";
			}
		$("#qxzyqkTable tbody").append(qxHtml);
		}
	});
}
// 区县资源情况：下载
function qxZyQkDownload(){
	window.location.href = ctx + "/shareResourceController/qxZyQkDownload";
}
$(function () {
	// 资源类型统计--echart2
	jQuery.resourceTypeTj();
	// 各部门可共享资源目录数 --echart1
	 jQuery.bmCatalogTj();
	// 现有资源数:库表、数据量、接口、文件--echart3
	 jQuery.xyResourceTj();
	// 申请省级资源情况:申请资源数
	 jQuery.shqshjResourceQk();
	// 申请市级资源情况:申请资源数（项） 、申请接口数（个）、累计接口调用（次）
	jQuery.applyCityResourceQK();
	
	// 申请市级资源情况弹出框：Tab切换
	$("#shqcityzy_propTab ul li").click(function() {
		$(this).addClass('active').siblings().removeClass('active');
		if ($(this).html() == '申请资源数') {
			jQuery.shqcityResourceQk_Prop("0");
		} else if ($(this).html() == '申请接口数') {
			jQuery.shqcityResourceQk_Prop("1");
		}
	});
	// 市级资源提供响应情况 : 资源
	jQuery.cityZyProvideQK();
	
	// 现有资源使用弹出框：Tab切换
	$("#xyResource_propTab ul li").click(function() {
		$(this).addClass('active').siblings().removeClass('active');
		if ($(this).html() == '库表数') {
			jQuery.xyZyQk_Prop("0");
		}else if ($(this).html() == '接口') {
			jQuery.xyZyQk_Prop("1");
		}else if ($(this).html() == '文件') {
			jQuery.xyZyQk_Prop("2");
		}else if ($(this).html() == '资源总数') {
			jQuery.xyZyQk_Prop("3");
		}
	});
	// 市级资源提供响应情况弹出框：Tab切换
	$("#cityzyProvide_propTab ul li").click(function() {
		$(this).addClass('active').siblings().removeClass('active');
		if ($(this).html() == '资源') {
			jQuery.cityzyProvideQk_Prop("0");
		} else if ($(this).html() == '接口') {
			jQuery.cityzyProvideQk_Prop("1");
		}
	});
	// 区县资源情况
	jQuery.qxZyQk();
	
	// 点击更多现实弹出框
	$("body").on(
			"click",
			".dialog",
			function() {
				var target = $(this).attr('data-target');
				$(".box[data-target='" + target + "']").siblings().removeClass('active');
				$(".box[data-target='" + target + "']").addClass('active');
				
				switch (target) {
				case 'shqshejzybox':
					jQuery.shqshjResourceQk_Prop(); // 申请省级资源情况
					break;
				case 'shqcityzybox':
					jQuery.shqcityResourceQk_Prop("0"); // 申请市级资源情况
					break;
				case 'cityzyProvidebox':
					jQuery.cityzyProvideQk_Prop("0");// 市级资源提供响应情况
					break;
				case 'xyResourcebox':
					jQuery.xyZyQk_Prop("3");// 现有资源数
					break;
				}
				$(".mask-panel").addClass('active');
			});
	// 点击关闭按钮关闭弹出框
	$("body").on("click", ".close-btn", function() {
		$(this).parents('.mask-panel').removeClass('active');
	});
	
	    
	/*// 滚动条
	 initNicScroll();
	// 滚动条
	 function initNicScroll(){
	     $('.table-content').niceScroll({
	         cursoropacitymin: 0,
	         cursorcolor:"#0d57ab",
	         cursorborder: '#0d57ab'
	     });
	     $('.table-content').getNiceScroll().resize();
	 }*/
});