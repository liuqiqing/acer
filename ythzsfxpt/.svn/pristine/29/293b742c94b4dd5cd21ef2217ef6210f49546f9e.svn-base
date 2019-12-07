var currUrl = window.location.href;
var ss;

function getQueryString(name) {
    if (name.indexOf('id') < 0) {
        //  说明有corpId这个值
        return false;
    } else {
        var s1 = name.split('?')[1];
        var s2 = s1.split("&"); //  a=12,b=456,c=789
        var s3 = "";
        var s4 = "";
        for (var i = 0; i < s2.length; i++) {
            console.log(s2[i])
            if (s2[i].indexOf('id') > -1) {
                s3 = s2[i].split("=")[1]
            }
        }
        return s3;
    }
}

// 注销操作
$("#logout").click(function () {
    sessionStorage.clear();
    window.location.href = 'index.html';
});
var id = getQueryString(currUrl);
$(function () {
    var username = sessionStorage.getItem("username");
    var user = sessionStorage.getItem("user");
    console.log(username)
    //  如果缓存是空的，那么说明是没有登录状态
    if(username == null){
        $("#zwfwflag").hide();
        $("#gxjhflag").hide();
        $("#dsjflag").hide();
    }
    if (!username != "" || username != undefined) {
        if (user == "6B4047653EDC45F38314CF0BE744D85D") {
            $("#name").html(username);
            $("#shouyeflag").hide();
            $("#gxjhflag").hide();
            $("#dsjflag").hide();
        }
    }else{
        console.log(111)
        $("#zwfwflag").hide();
        $("#gxjhflag").hide();
        $("#dsjflag").hide();
    }

    //左右部分
    //实时更新
    var real = echarts.init(document.getElementById('real-time'));
    var time1 = {
        title: {
            text: '实时更新单位数',
            left: '0',
            bottom: 0,
            textStyle: {
                color: '#fff',
                fontSize: 15,
                fontWeight: 'normal'
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
                        value: 4,
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

    //非实时更新
    var nreal = echarts.init(document.getElementById('n-real-time'));
    var time2 = {
        title: {
            text: '非实时更新单位数',
            left: '0',
            bottom: 0,
            textStyle: {
                color: '#fff',
                fontSize: 15,
                fontWeight: 'normal'
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
                        value: 54,
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
                    position: 'outside',
                    formatter: '{b} \n{d}%{c}个',
                },
                labelLine: {
                    show: true
                },
                data: [
                    {
                        name: '无条件共享',
                        value: 420,
                        itemStyle: {
                            color: '#21beff'
                        }
                    },
                    {
                        name: '有条件共享',
                        value: 1260,
                        itemStyle: {
                            color: '#ffbe37'
                        }
                    }
                ]
            }
        ]
    };
    menu.setOption(chart);


    //共享资源利用情况
    var shareChart = echarts.init(document.getElementById('shareChart'));
    var shareOption = {
        grid: {
            top: 30,
            left: 20,
            right: 0,
            bottom: 0,
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: ['一月', '二月', '三月', '四月', '五月', '六月'],
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
            splitLine: {
                lineStyle: {
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
            data: [400, 250, 390, 300, 510, 420],
            color: '#0094fb',
        }, {
            type: 'line',
            name: '接口',
            data: [110, 110, 60, 180, 200, 80],
            color: '#ddb401',
        }, {
            type: 'line',
            name: '文件',
            data: [490, 560, 360, 420, 300, 420],
            color: '#5bdce5',
        }]
    };
    shareChart.setOption(shareOption);

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

    //共享资源部门排名
    var shareRankingChart = echarts.init(document.getElementById('share-ranking-chart'));
    var shareRankingOption = {
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
            data: ['环保厅', '工商局', '税务厅', '水利局', '体育局', '安监局'],
            axisLabel: {
                interval: 0,
                rotate: 30,
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
            splitLine: {
                lineStyle: {
                    type: 'dashed',
                    color: '#2e3450',
                }
            }
        },
        series: [
            {
                name: '共享资源部门排名',
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
                data: [580, 460, 430, 400, 380, 350]
            }
        ]
    };
    shareRankingChart.setOption(shareRankingOption);
});
