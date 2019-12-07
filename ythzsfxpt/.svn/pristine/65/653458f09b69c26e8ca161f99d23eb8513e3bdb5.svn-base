// var jrslbjUrl = ctx + "/indexController/jrslbjsl";
var jrslbjUrl = ctx + "/sxgl/getdtbjsl";
var jrfwjkdycsUrl = ctx + "/indexController/jrfwjkdycs";
var onlineConduct = ctx + "/indexController/onlineConduct";
var countOrg = ctx + "/indexController/countOrg";
var hotOrg = ctx + "/indexController/hotOrg";

//共享资源部门排名
function hotOrgs(){
	$.ajax({
		type : "post",
		async : true,   
		url:hotOrg,
		success:function(result){
			var shareRankingChart = echarts.init(document
					.getElementById('ranking'));
			var shareRankingOption = {
				color : [ '#3dd3ba' ],
				grid : {
					top : 20,
					right : 0,
					left : 20,
					bottom : 0,
					containLabel : true
				},
				tooltip : {
					trigger : 'axis'
				},
				xAxis : {
					type : 'category',
					// data: ['环保厅', '工商局', '税务厅', '水利局','体育局', '安监局'],
					data : result.xAxisData,
					axisLabel : {
						interval : 0,
						rotate : 0,
						textStyle : {
							color : '#e5f8ff'
						}
					}
				},
				yAxis : {
					type : 'value',
					axisLine : {
						show : false
					},
					axisLabel : {
						textStyle : {
							color : '#e5f8ff'
						}
					},
					splitLine : {
						lineStyle : {
							type : 'dashed',
							color : '#2e3450',
						}
					}
				},
				series : [ {
					name : '共享资源部门排名',
					type : 'bar',
					barWidth : 10,
					itemStyle : {
						color : new echarts.graphic.LinearGradient(0, 0, 0,
								1, [ {
									offset : 0,
									color : '#59e9fe'
								}, {
									offset : 1,
									color : '#0ca2ff'
								} ]),
						barBorderRadius : 5
					},
					data : result.seriesData,
				} ]
			};
			shareRankingChart.setOption(shareRankingOption);
		},
		error : function(errorMsg) {
			
		}
	});
}
//共享交换数据提供部门数:文件，接口，库表 
function countOrgs(){
	$.ajax({
		type : "post",
	    async : true,   
		url:countOrg,
		success:function(result){
			 //共享交换数据提供部门左
		    var department1 = echarts.init(document.getElementById('department1'));
		    var departmentOption1 = {
		        title: {
		            text: '文件部门数',
		            left: '0',
		            bottom: 0,
		            textStyle: {
		                color: '#fff',
		                fontSize: 14,
		                fontWeight:'normal'
		            }
		        },
		        legend: {
		            show: false
		        },
		        series: [
		            {
		                type: 'pie',
		                center: ['40%', '40%'],
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
		                        //value: 4,
		                        value: result.countFileOrg,
		                        label: {
		                            show: true,
		                            color: '#fff',
		                            position: 'center',
		                            fontSize: 16,
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
		                        value: 58,
		                        itemStyle: {
		                            color: '#808183'
		                        }
		                    }
		                ]
		            }
		        ]
		    };
		    department1.setOption(departmentOption1);

		    //共享交换数据提供部门中
		    var department2 = echarts.init(document.getElementById('department2'));
		    var departmentOption2 = {
		        title: {
		            text: '库表部门数',
		            left: 'center',
		            bottom: 0,
		            textStyle: {
		                color: '#fff',
		                fontSize: 14,
		                fontWeight:'normal'
		            }
		        },
		        legend: {
		            show: false
		        },
		        series: [
		            {
		                type: 'pie',
		                center: ['50%', '40%'],
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
		                        //value: 54,
		                        value: result.countDbTableOrg,
		                        label: {
		                            show: true,
		                            color: '#fff',
		                            position: 'center',
		                            fontSize: 16,
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
		                        value: 4,
		                        itemStyle: {
		                            color: '#808183'
		                        }
		                    }
		                ]
		            }
		        ]
		    };
		    department2.setOption(departmentOption2);
		    //共享交换数据提供部门右
		    var department3 = echarts.init(document.getElementById('department3'));
		    var departmentOption3 = {
		        title: {
		            text: '接口部门数',
		            left: 'center',
		            bottom: 0,
		            textStyle: {
		                color: '#fff',
		                fontSize: 14,
		                fontWeight:'normal'
		            }
		        },
		        legend: {
		            show: false
		        },
		        series: [
		            {
		                type: 'pie',
		                center: ['50%', '40%'],
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
		                        //value: 54,
		                        value: result.countServiceOrg,
		                        label: {
		                            show: true,
		                            color: '#fff',
		                            position: 'center',
		                            fontSize: 16,
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
		                        value: 4,
		                        itemStyle: {
		                            color: '#808183'
		                        }
		                    }
		                ]
		            }
		        ]
		    };
		    department3.setOption(departmentOption3);
		},
		error : function(errorMsg) {
	       
	    }
	});
}
//事项网办深度：线上事项数量、线下事项数量  
 function onlineConducts(){
	$.ajax({
		type : "post",
		async : true,   
		url:onlineConduct,
		success:function(result){
			$("#count_online").html(result.count_online);
			$("#count_offline").html(result.count_offline);
		},
		error : function(errorMsg) {
			
		}
	});
}
//今日受理办结数量
function jrslbjsl(){
	$.ajax({
		type : "get",
		async : true,   
		url:jrslbjUrl,
		success:function(result){
			$("#jrslsl").html(result.spsl);
			$("#jrbjsl").html(result.spbj);
		},
		error : function(errorMsg) {
			// alert("今日办结受理数量调用失败！");
		}
	});
}
//今日服务接口调用次数
function jrfwjkdycs(){
	$.ajax({
		type : "post",
	    async : true,   
		url:jrfwjkdycsUrl,
		success:function(result){
			var direData = result.jrfwjkdycs;
			var strArr = direData.toString().split('');
		    var strList = '';
		    for(var i = 0; i < strArr.length; i++){
		        strList += "<li><span class='num'>" + strArr[i] + "</span></li>";
		    }
		    strList += "<li><span class='text'>次</span></li>";
		    $(".data-dire-list .num-list ul").html(strList);
		},
		error : function(errorMsg) {
	       //alert("今日办结受理数量调用失败！");
	    }
	});
}

// window.setInterval(jrslbjsl(),1000);
// window.setInterval(jrfwjkdycs(),1000);
// window.setInterval(onlineConduct(),1000);
// window.setInterval(countOrg(),1000);
// window.setInterval(hotOrg(),1000);

