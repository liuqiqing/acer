$(function(){
    //左右部分
    

    //数据调用监控--垂直滚动部分
    $('.data-monitor-scroll').vTicker({
        speed: 700,
        pause: 3000,
        showItems: 5,
        animation: 'fade',
        mousePause: true,
        height: 0,
        direction: 'up'
    });

    
});

var url = ctx + "/shareIndex/statistics";
var urlUse = ctx + "/shareIndex/statisticsUse";

jQuery.statistics = function() {
	$.ajax({
		type : "post",
		async : true,
		url : url,
		success : function(result) {
			$("#total_count").html(result.total_count);
			$("#sum_success_times").html(result.sum_success_times);
			$("#sum_failed_times").html(result.sum_failed_times);
			$("#total_cata_count").html(result.sum_failed_times);
			$("#count_db_table").html(result.count_db_table);
			$("#count_file").html(result.count_file);
			$("#total_service").html(result.total_service);
			$("#total_org").html(result.total_org);
			// 热门资源排名
			$("#hotSource_no1").html(result.cata_name0);
			$("#hotSource_no2").html(result.cata_name1);
			$("#hotSource_no3").html(result.cata_name2);
			$("#hotSource_no4").html(result.cata_name3);
			$("#hotSource_no5").html(result.cata_name4);
			// 共享资源部门排名
			if (true) {
				var shareRankingChart = echarts.init(document
						.getElementById('share-ranking-chart'));
				var shareRankingOption = {
					color : [ '#3dd3ba' ],
					grid : {
						top : 10,
						right : 20,
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
							rotate : 30,
							textStyle : {
								color : '#e5f8ff'
							},
							formatter: function (name) {
		                        return (name.length > 5 ? (name.slice(0,5)+"...") : name ); 
		                    },

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
			}
			if(true){
				//数据目录总数
			    var menu = echarts.init(document.getElementById('menu-chart'));
			    var chart = {
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
			                    formatter:'{b} \n{d}%{c}个',
			                },
			                labelLine: {
			                    show: true
			                },
			                data: [
			                    {
			                        name:'无条件共享',
			                        value: result.total_cata_count_nocondition,
			                        itemStyle: {
			                            color: '#21beff'
			                        }
			                    },
			                    {
			                        name:'有条件共享',
			                        value: result.total_cata_count_condition,
			                        itemStyle: {
			                            color: '#ffbe37'
			                        }
			                    }
			                ]
			            }
			        ]
			    };
			    menu.setOption(chart);
			}
			
			//已上传接口单位数
		    var real = echarts.init(document.getElementById('real-time'));
		    var time1 = {
		        title: {
		            text: '已挂载接口单位数',
		            left: '0',
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
		                        //value: 4,
		                        value: result.countOrgService,
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
		    };
		    real.setOption(time1);

		     //未上传接口单位数
		    var nreal = echarts.init(document.getElementById('n-real-time'));
		    var time2 = {
		        title: {
		            text: '未挂载接口单位数',
		            left: '0',
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
//		                        value: 54,
		                        value: result.countOrgNoService,
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
		                        value: 4,
		                        itemStyle: {
		                            color: '#808183'
		                        }
		                    }
		                ]
		            }
		        ]
		    };
		    nreal.setOption(time2);
			
			//共享度排名-部门名称
			$("#share_org_no1").html(result.organ_name0);
			$("#share_org_no1").attr("title",result.organ_name0);
			$("#share_org_no2").html(result.organ_name1);
			$("#share_org_no2").attr("title",result.organ_name1);
			$("#share_org_no3").html(result.organ_name2);
			$("#share_org_no3").attr("title",result.organ_name2);
			$("#share_org_no4").html(result.organ_name3);
			$("#share_org_no4").attr("title",result.organ_name3);
			$("#share_org_no5").html(result.organ_name4);
			$("#share_org_no5").attr("title",result.organ_name4);
			$("#share_org_no6").html(result.organ_name5);
			$("#share_org_no6").attr("title",result.organ_name5);
			$("#share_org_no7").html(result.organ_name6);
			$("#share_org_no7").attr("title",result.organ_name6);
			$("#share_org_no8").html(result.organ_name7);
			$("#share_org_no8").attr("title",result.organ_name7);
			//共享度排名-占比
			$("#share_org_no1_percent").html(result.count_cata_percent0);
			$("#share_org_no2_percent").html(result.count_cata_percent1);
			$("#share_org_no3_percent").html(result.count_cata_percent2);
			$("#share_org_no4_percent").html(result.count_cata_percent3);
			$("#share_org_no5_percent").html(result.count_cata_percent4);
			$("#share_org_no6_percent").html(result.count_cata_percent5);
			$("#share_org_no7_percent").html(result.count_cata_percent6);
			$("#share_org_no8_percent").html(result.count_cata_percent7);
		},
		error : function(errorMsg) {
			// alert("error！");
		}
	});
}


jQuery.statisticsUse = function() {
	$.ajax({
		type : "post",
		async : true,
		url : urlUse,
		success : function(result) {
			//共享资源利用情况--每月
		    var shareChart = echarts.init(document.getElementById('shareChart'));
		    var shareOption ={
		        grid: {
		            top: 30,
		            left: 20,
		            right: 0,
		            bottom: 0,
		            containLabel: true
		        },
		        xAxis: {
		            type: 'category',
		            data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
		            //data: result.monthData,
		            axisLabel: {
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
		            data: ['库表', '接口', '文件'],
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
		            name: '库表',
		            data: result.dbtableData,
		            //data: [400, 250, 390, 300, 510, 420, 300, 510, 420, 300, 510, 420],
		            color: '#0094fb',
		        },{
		            type: 'line',
		            name: '接口',
		           // data: [110, 110, 60, 180, 200, 80, 180, 200, 80, 180, 200, 200],
		            data: result.serviceData,
		            color: '#ddb401',
		        },{
		            type: 'line',
		            name: '文件',
		            data: result.fileData,
		            //data: [490, 560, 360, 420, 300, 420, 420, 300, 420, 420, 300, 420],
		            color: '#5bdce5',
		        }]
		    };
		    shareChart.setOption(shareOption);
		},
		error : function(errorMsg) {
			// alert("error！");
		}
	});
}

window.setInterval(jQuery.statistics, 1000);
window.setInterval(jQuery.statisticsUse, 1000);
