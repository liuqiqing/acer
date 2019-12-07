$(function () {
    var chart1 = echarts.init(document.getElementById("chart1"));
    var chartOption1 = {
        title: {
            text: '一网服务进驻地区',
            textStyle: {
                color: '#fff',
            },
        },
        color: ['#37a2da', '#32c5e9', '#9fe6b8', '#ffdb5c', '#ff9f7f', '#fb7293', '#e7bcf3', '#8378ea'],
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        calculable: true,
        series: [
            {
                name: '一网服务进驻地区',
                type: 'pie',
                radius: [20, 60],
                center: ['44%', '50%'],
                roseType: 'area',
                data: [
                    {value: 24, name: '历下区'},
                    {value: 22, name: '市中区'},
                    {value: 23, name: '槐荫区'},
                    {value: 24, name: '天桥区'},
                    {value: 33, name: '历城区'},
                    {value: 25, name: '长清区'},
                    {value: 31, name: '章丘区'},
                    {value: 28, name: '济阳区'},
                    {value: 31, name: '莱芜区'},
                    {value: 25, name: '钢城区'},
                    {value: 30, name: '平阴县'},
                    {value: 31, name: '商河县'}
                ]
            }
        ]
    };
    chart1.setOption(chartOption1);


    // 事项清单公布情况
    var chart21 = echarts.init(document.getElementById("chart21"));
    var chartOption21 = {
        title: {
            text: '事项清单公布情况',
            textStyle: {
                color: '#fff',
            },
        },
        color: ["#fce659", "#51dcfa"],
        legend: {
            top: 20,
            data: ['清单类型'],
            textStyle: {
                color: "#fff"
            }
        },
        tooltip: {},
        grid: {
            top: 50,
            left: 40,
            right: 10
        },
        //权责清单4765 收费清单133 中介清单25 跑动次数清单3188
        xAxis: {
            type: 'category',
            data: ['权责清单', '收费清单', '中介清单', '跑动次数清单'],
            axisLine: {
                lineStyle: {
                    color: "#3f425a"
                }
            },
            axisLabel: {
                interval: 0,// 强制显示横坐标的标签的值
                color: "#fff"
            }
        },
        yAxis: [
            {
                type: 'value',
                axisLine: {
                    lineStyle: {
                        color: "#3f425a"
                    }
                },
                axisLabel: {
                    color: "#fff"
                },
                splitLine: {
                    lineStyle: {
                        color: ["#191e43"]
                    }
                }
            }
        ],
        series: [
            {
                name: '清单类型',
                data: [4752, 133, 25, 3188],
                type: 'bar',
                barWidth: 20,// 设置柱状图宽度
                color: '#EE3D11'

            },

        ]
    };
    chart21.setOption(chartOption21);

    // 公共服务清单公布情况
    var chart2 = echarts.init(document.getElementById("chart2"));
    var chartOption2 = {
        title: {
            text: '公共服务清单公布情况',
            textStyle: {
                color: '#fff',
            },
        },
        color: ["#fce659", "#51dcfa"],
        legend: {
            top: 20,
            data: ['公共服务'],
            textStyle: {
                color: "#fff"
            }
        },
        tooltip: {},
        grid: {
            top: 50,
            left: 40,
            right: 10
        },
        //公共教育9医疗卫生30住房保障16社会保障16民政27扶贫脱贫8
        xAxis: {
            type: 'category',
            data: ['公共教育', '医疗卫生', '住房保障', '社会保障', "民政", "扶贫脱贫"],
            axisLine: {
                lineStyle: {
                    color: "#3f425a"
                }
            },
            axisLabel: {
                rotate: 45, // 横坐标数据倾斜45度
                interval: 0,// 强制显示横坐标的标签的值
                color: "#fff"
            }
        },
        yAxis: [
            {
                type: 'value',
                axisLine: {
                    lineStyle: {
                        color: "#3f425a"
                    }
                },
                axisLabel: {
                    color: "#fff"
                },
                splitLine: {
                    lineStyle: {
                        color: ["#191e43"]
                    }
                }
            }
        ],
        series: [
            {
                name: '公共服务',
                data: [9, 30, 16, 16, 27, 8],
                type: 'bar',
                barWidth: 20,// 设置柱状图宽度
                color: '#4ad2ff'

            },

        ]
    };
    chart2.setOption(chartOption2);


    //  本月办件数量
    getkwsblsl();
    //  事项办结前十
    getsxbjqs();
    // 获取红黄牌数量
    gethhpsl();
    // 获取排队叫号数量
    getpdjh();
    // 获取排队叫号窗口排名前十
    getckqs();
    // 获取排队叫号等待平均时长
    getpddhsj();
    // 网办深度要素分类
    getwbsd();
    // 获取今日办结和受理数量
     getblslsl();
     // 获取网办率
    getwblv();

    initNicScroll();

    function initNicScroll() {
        $('.table-content').niceScroll({
            cursoropacitymin: 0,
            cursorcolor: "#0d57ab",
            cursorborder: '#0d57ab'
        });
        $('.table-content').getNiceScroll().resize();
    }


});

// //  本月办件数量
function getkwsblsl() {
    // 获取根路径
    var ctx = $("#contextPath").val();
    var kwsblsl = ctx + "/sxgl/tjcx";
    // var kwsblsl = ctx + "/sxbjqs";
    var arr = new Array();
    var date = new Date()
    var month = date.getMonth()
    $.ajax({
        type: "post",
        async: true,
        url: kwsblsl,
        success: function (result) {
            // //console.log(result)
            arr.push(result.ybjsl);
            arr.push(result.tjsl);
            arr.push(result.wssbl);
            arr.push(result.ycsll);
            // //console.log(arr)
            var chart41 = echarts.init(document.getElementById("chart41"));
            chart41.setOption({
                title: {
                    text: month+1+'月份办件数量',
                    textStyle: {
                        color: '#fff',
                    },
                },
                color: ["#fce659", "#51dcfa"],
                tooltip: {},
                grid: {
                    top: 50,
                    left: 60,
                    right: 10
                },
                xAxis: {
                    type: 'category',
                    //'网上可办事项',
                    data: ['办结数量', '退件数量', '网上申报量', '一窗受理量'],
                    axisLine: {
                        lineStyle: {
                            color: "#3f425a"
                        }
                    },
                    axisLabel: {
                        rotate: 45, // 横坐标数据倾斜45度
                        interval: 0,// 强制显示横坐标的标签的值
                        color: "#fff"
                    }
                },
                yAxis: [
                    {
                        type: 'value',
                        axisLine: {
                            lineStyle: {
                                color: "#3f425a"
                            }
                        },
                        axisLabel: {
                            color: "#fff"
                        },
                        splitLine: {
                            lineStyle: {
                                color: ["#191e43"]
                            }
                        }
                    }
                ],
                series: [
                    {
                        name: '数量',
                        data: arr,//  数据
                        type: 'bar',
                        barWidth: 20,// 设置柱状图宽度
                        color: '#F9AC3A'

                    },

                ]
            })
        },
        error: function (error) {

        }
    })
}

// 获取红黄牌数量
function gethhpsl() {
    // 获取根路径
    var ctx = $("#contextPath").val();
    var hhpsl = ctx + "/sxgl/hhpsl";
    // var kwsblsl = ctx + "/sxbjqs";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: hhpsl,
        success: function (result) {
            // //console.log(result)
            // 红牌result.hongpai
            arr.push({
                value: result.hongpai,
                name: "红牌数量",
                color: "#fff"
            });
            // 黄牌
            arr.push({
                value: result.huangpai,
                name: "黄牌数量",
                color: "#fff"
            });

            // //console.log(arr)
            var chart6 = echarts.init(document.getElementById("chart6"));
            chart6.setOption({
                title: {
                    text: '红牌/黄牌数量',
                    textStyle: {
                        color: '#fff',
                    },
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c}"
                },
                color: ["#c23531", "#fce659"],
                legend: {
                    orient: 'vertical',
                    color: "#fff",
                    show: true,
                    left: 'right',
                    itemWidth: 16,
                    itemHeight: 10,
                    textStyle: {
                        fontSize: 12,
                        color: '#fff'
                    },
                    data: ['红牌数量', '黄牌数量',]
                },
                grid: {
                    top: 50,
                    left: 60,
                    right: 10
                },
                series: [
                    {
                        name: '红牌/黄牌数量',
                        data: arr,//  数据
                        type: 'pie',
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
                                    fontSize: '16',
                                    fontWeight: 'bold'
                                }
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            }
                        },
                        // barWidth: 20,// 设置柱状图宽度
                        // color: '#EE3D11'

                    },

                ]
            })
        },
        error: function (error) {

        }
    })
}

// 获取事项办结前十
function getsxbjqs() {
// 获取根路径
    var ctx = $("#contextPath").val();
    var sxbjqs = ctx + "/sxgl/sxbjqs";
    var arr = new Array();
    var val = new Array();
    $.ajax({
        type: "post",
        async: true,
        url: sxbjqs,
        success: function (result) {
            // //console.log(result.list);
            var strList = '';
            for (var i = 0; i < result.list.length; i++) {
                strList += "<tr style='font-size: 15px'><td>" + (i + 1) + "</td><td><span title='" + result.list[i].ORGNAME + "'>" +
                    result.list[i].ITEMNAME + "</span></td><td>" + result.list[i].ORGNAME + "</td><td>" +
                    result.list[i].BJ + "</td></tr>"
            }
            // //console.log(strList)
            $(".table-content .table #strlist").html(strList);
        },
        error: function (error) {

        }
    })
}

// 获取排队叫号的数量
function getpdjh() {
    // 获取根路径
    var ctx = $("#contextPath").val();
    var pdjh = ctx + "/sxgl/getpdjhsl";
    var pdjhsrr = new Array();
    var arr = new Array();
    var arrs = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: pdjh,
        success: function (result) {
            // //console.log(result)
            pdjhsrr.push(result.pdjhsl);
            for (var i = 0; i < result.pdjhsl.length; i++) {
                arr.push(result.pdjhsl[i].sum)
                arrs.push(result.pdjhsl[i].Cstate)
            }

            // //console.log(arr)
            var chart3 = echarts.init(document.getElementById("chart3"));
            chart3.setOption({
                title: {
                    text: '当天排队叫号数量',
                    textStyle: {
                        color: '#fff',
                    },
                },
                color: ["#fce659", "#51dcfa"],
                legend: {
                    top: 20,
                    data: ['排队叫号数量'],
                    textStyle: {
                        color: "#fff"
                    }
                },
                tooltip: {},
                grid: {
                    top: 50,
                    left: 60,
                    right: 10
                },
                xAxis: {
                    type: 'category',
                    data: arrs,
                    axisLine: {
                        lineStyle: {
                            color: "#3f425a"
                        }
                    },
                    axisLabel: {
                        rotate: 45, // 横坐标数据倾斜45度
                        interval: 0,// 强制显示横坐标的标签的值
                        color: "#fff"
                    }
                },
                yAxis: [
                    {
                        type: 'value',
                        axisLine: {
                            lineStyle: {
                                color: "#3f425a"
                            }
                        },
                        axisLabel: {
                            color: "#fff"
                        },
                        splitLine: {
                            lineStyle: {
                                color: ["#191e43"]
                            }
                        }
                    }
                ],
                series: [
                    {
                        name: '数量',
                        data: arr,//  数据
                        type: 'bar',
                        barWidth: 20,// 设置柱状图宽度
                        color: '#FA7A5B'

                    },

                ]
            })
        },
        error: function (error) {

        }
    })
}

// 获取排队叫号窗口排名前十
function getckqs() {
    // 获取根路径
    var ctx = $("#contextPath").val();
    var pdjh = ctx + "/sxgl/getckqs";
    var pdjhsrr = new Array();
    var arr = new Array();
    var arrs = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: pdjh,
        success: function (result) {
            // //console.log(result)
            pdjhsrr.push(result.ckqs);
            for (var i = 0; i < result.ckqs.length; i++) {
                arr.push(result.ckqs[i].sum)
                arrs.push(result.ckqs[i].Cwno)
            }
            // //console.log(arr)
            var chart81 = echarts.init(document.getElementById("chart81"));
            chart81.setOption({
                title: {
                    text: '排队叫号窗口排名前十',
                    textStyle: {
                        color: '#fff',
                    },
                },
                color: ["#fce659", "#51dcfa"],
                legend: {
                    top: 20,
                    data: ['窗口排名前十'],
                    textStyle: {
                        color: "#fff"
                    }
                },
                tooltip: {},
                grid: {
                    top: 50,
                    left: 30,
                    right: 10
                },
                xAxis: {
                    type: 'category',
                    data: arrs,
                    axisLine: {
                        lineStyle: {
                            color: "#3f425a"
                        }
                    },
                    axisLabel: {
                        rotate: 45, // 横坐标数据倾斜45度
                        interval: 0,// 强制显示横坐标的标签的值
                        color: "#fff"
                    }
                },
                yAxis: [
                    {
                        type: 'value',
                        axisLine: {
                            lineStyle: {
                                color: "#3f425a"
                            }
                        },
                        axisLabel: {
                            color: "#fff"
                        },
                        splitLine: {
                            lineStyle: {
                                color: ["#191e43"]
                            }
                        }
                    }
                ],
                series: [
                    {
                        name: '数量',
                        data: arr,//  数据
                        type: 'bar',
                        barWidth: 15,// 设置柱状图宽度
                        color: '#C43C72'

                    },

                ]
            })
        },
        error: function (error) {

        }
    })
}

// 获取排队叫号等待平均时长
function getpddhsj() {
    // 获取根路径
    var ctx = $("#contextPath").val();
    var pddhsj = ctx + "/sxgl/getpddhsj";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: pddhsj,
        success: function (result) {
            var sum = 0;
            // //console.log(result);
            arr.push({
                value: result.a,
                name: "1-5分钟",
            });
            arr.push({
                value: result.b,
                name: "5-10分钟",
            });
            arr.push({
                value: result.c,
                name: "10-15分钟",
            });
            arr.push({
                value: result.d,
                name: "15-20分钟",
            });
            arr.push({
                value: result.e,
                name: "20-25分钟",
            });
            arr.push({
                value: result.f,
                name: "25-30分钟",
            });
            sum = result.a + result.b + result.c + result.d + result.e + result.f;
            // //console.log(sum)
            var chart8 = echarts.init(document.getElementById("chart8"));
            chart8.setOption({
                title: {
                    text: '排队叫号等待平均时长',
                    textStyle: {
                        color: '#fff',
                    },
                },
                tooltip: {
                    trigger: 'item',
                    formatter: function (params, ticket, callback) {//这是关键，在需要的地方加上就行了
                        // //console.log(params.value)
                        var num = (params.value / sum) * 100;
                        //百分比保留小数点后两位
                        var ss = params.name + '：平均时长' + params.value + '分钟<br/>' + '占比：' + num.toFixed(2) + '%'
                        return ss;
                    }
                },
                color: ["#eefa36", "#65f5fe", "#ffbe37", "#21beff", "#8b80f4", "#FF6600"],
                legend: {
                    orient: 'vertical',
                    color: "#fff",
                    show: true,
                    left: 'right',
                    itemWidth: 16,
                    itemHeight: 10,
                    textStyle: {
                        fontSize: 12,
                        color: '#fff'
                    },
                    data: ['1-5分钟', '5-10分钟', '10-15分钟', '15-20分钟', '20-25分钟', '25-30分钟']
                },
                grid: {
                    top: 60,
                    left: 30,
                    right: 60
                },
                series: [
                    {
                        name: '平均时长',
                        data: arr,//  数据
                        type: 'pie',
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
                                    fontSize: '16',
                                    fontWeight: 'bold'
                                }
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            }
                        },
                        // barWidth: 20,// 设置柱状图宽度
                        // color: '#EE3D11'
                    },

                ]
            })
        },
        error: function (error) {

        }
    })
}

// 网办深度要素分类
function getwbsd() {
    // 获取根路径
    var ctx = $("#contextPath").val();
    var wbsd = ctx + "/sxgl/getwbsd";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: wbsd,
        success: function (result) {
            var sum = 0;
            // //console.log(result);
            arr.push({
                value: result.a,
                name: "一级信息发布",
            });
            arr.push({
                value: result.b,
                name: "二级材料预审",
            });
            arr.push({
                value: result.c,
                name: "三级材料核验",
            });
            arr.push({
                value: result.d,
                name: "四级全程网办",
            });
            sum = result.a + result.b + result.c + result.d;
            // //console.log(sum)
            var chart7 = echarts.init(document.getElementById("chart7"));
            chart7.setOption({
                title: {
                    text: '网办深度分级展现',
                    textStyle: {
                        color: '#fff',
                    },
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{b}占比 : {d}% <br/> "+"数量：{c}"+"个"
                },
                grid: {
                    left: '3%',     //图表距离左右上下之间的距离
                    right: '4%',
                    top: '15%',
                    containLabel: true
                },
                series: [{
                    type: 'pie',
                    radius: ['40%', '50%'],
                    center: ['50%', '50%'],
                    color: ['#0E7CE2', '#FF8352', '#E271DE', '#F8456B'],
                    data: arr,
                    labelLine: {
                        normal: {
                            show: true,
                            length: 20,
                            length2: 20,
                            lineStyle: {
                                color: '#12EABE',
                                width: 2
                            }
                        }
                    },
                    label: {
                        normal: {
                            formatter: '{b|{c}}\n{hr|}\n{d|{d}%}',
                            rich: {
                                b: {
                                    fontSize: 20,
                                    color: '#12EABE',
                                    align: 'left',
                                    padding: 4
                                },
                                hr: {
                                    borderColor: '#12EABE',
                                    width: '100%',
                                    borderWidth: 2,
                                    height: 0
                                },
                                d: {
                                    fontSize: 20,
                                    color: '#fff',
                                    align: 'left',
                                    padding: 4
                                },
                                c: {
                                    fontSize: 20,
                                    color: '#fff',
                                    align: 'left',
                                    padding: 4
                                }
                            }
                        }
                    }
                }]
            })
        },
        error: function (error) {

        }
    })

}

// 获取今日办结和受理数量
function getblslsl() {
    // 获取根路径
    var ctx = $("#contextPath").val();
    var dtbjsl = ctx + "/sxgl/getdtbjsl";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: dtbjsl,
        success: function (result) {
            // //console.log(result);
            $("#jrslsl").html(result.spsl);
            $("#jrbjsl").html(result.spbj);
        },
        error: function (error) {

        }
    })
}

// 可网上办理事项数量和可网上办理率
function getwblv() {
    // 获取根路径
    var ctx = $("#contextPath").val();
    var wsblsl = ctx + "/sxgl/wsblsl";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: wsblsl,
        success: function (result) {
            // //console.log(result)
            $("#wsblsx").html(result.wsbl);
            var num = (result.wsbl/result.total)*100;
            var rate = num.toFixed(2) +"%"
            $("#wsbllv").html(rate);
        },
        error: function (error) {

        }
    })
}