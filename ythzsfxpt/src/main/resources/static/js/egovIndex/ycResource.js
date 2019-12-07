var ctx = $("#contextPath").val();
var day;
var month;
var year

// 一窗收件事项弹出框：下载
function qxZyQkDownload() {
    window.location.href = ctx + "/tyslcontroller/downloadsxlb";
}

// 日期格式化
function dateFormat(fmt, date) {
    var ret;
    var opt = {
        "Y+": date.getFullYear().toString(),        // 年
        "m+": (date.getMonth() + 1).toString(),     // 月
        "d+": date.getDate().toString(),            // 日
        "H+": date.getHours().toString(),           // 时
        "M+": date.getMinutes().toString(),         // 分
        "S+": date.getSeconds().toString()          // 秒
        // 有其他格式化字符需求可以继续添加，必须转化成字符串
    };
    for (var k in opt) {
        ret = new RegExp("(" + k + ")").exec(fmt);
        if (ret) {
            fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
        }
        ;
    }
    ;
    return fmt;
}

$(function () {
    var date = new Date();
    // /给一个bollen类型的值，初始位false/
    // // console.log(111111)
// 获取当天的一窗收件数量
    getycsjsl();
    // 获取一窗收件事项排名
    getycsjlb();
    // 获取窗口人员办件情况
    getckrybjqk(dateFormat("YYYY-mm-dd", date), "", "","15");
    // 各部门办件情况
    getbmblsl(dateFormat("YYYY-mm-dd", date), "", "", "15");

    //在办窗口统计
    getckxxqk(dateFormat("YYYY-mm-dd", date), "", "","15");
    getckxxqkss();

    var bollean = false;
    // /定时器功能，根据bollen来判断是否执行/
    var time = 1000 * 30;
    var setIntervalvalue = setInterval(function () {
        // debugger
        if (bollean) {
            // /定时器功能不执行并返回/
            clearInterval(setIntervalvalue);
            return;
        } else {
            // console.log(111111)
            var shijian = dateFormat("HH:MM:SS", new Date());
            // console.log(shijian)
            // 在这个区间内的都可以执行定时任务
            // 获取当天的一窗收件数量
            getycsjsl();
            // 获取一窗收件事项排名
            getycsjlb();
            // 获取窗口人员办件情况
            getckrybjqk(dateFormat("YYYY-mm-dd", date), "", "","15");
            // 各部门办件情况
            getbmblsl(dateFormat("YYYY-mm-dd", date), "", "", "15");

            //在办窗口统计
            getckxxqk(dateFormat("YYYY-mm-dd", date), "", "","15");




        }
    }, time);


    // 获取一窗收件一周的数量变化趋势
    getycsjqs();
    // 获取短信评价以及满意度
    getdxpjxx();


    // 各部门办件情况：切换tab页
    $("#bmbjqk ul li").click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        if ($(this).html() == '当日') {
            day = dateFormat("YYYY-mm-dd", date)
            getbmblsl(day, "", "", "15");
        } else if ($(this).html() == '当月') {
            month = dateFormat("YYYY-mm", date)
            getbmblsl("", month, "", "15");
        } else if ($(this).html() == '当年') {
            year = dateFormat("YYYY", date)
            getbmblsl("", "", year, "15");
        }
    });

    // 各窗口办件情况：切换tab页
    $("#ckbjqk ul li").click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        if ($(this).html() == '当日') {
            day = dateFormat("YYYY-mm-dd", date)
            getckrybjqk(day, "", "","15");
        } else if ($(this).html() == '当月') {
            month = dateFormat("YYYY-mm", date)
            getckrybjqk("", month, "","15");
        } else if ($(this).html() == '当年') {
            year = dateFormat("YYYY", date)
            getckrybjqk("", "", year,"15");
        }
    });
    // 点击更多现实弹出框
    $("body").on(
        "click",
        ".dialog",
        function () {
            var target = $(this).attr('data-target');
            $(".box[data-target='" + target + "']").siblings().removeClass('active');
            $(".box[data-target='" + target + "']").addClass('active');
            //// console.log(target)
            switch (target) {
                case 'cityzyProvidebox':
                    day = dateFormat("YYYY-mm-dd", date);
                    getbmblsl(day, "", "", "");// 当天的办部门办件数据列表
                    break;
                case 'shqshejzybox':
                    // jQuery.shqshjResourceQk_Prop(); // 申请省级资源情况
                    break;
                case 'shqcityzybox':
                    day = dateFormat("YYYY-mm-dd", date);
                    getckrysj(day, "", "","");//各窗口办件情况
                    break;
                case 'xzResourcebox':
                    day = dateFormat("YYYY-mm-dd", date);
                    downloadzbck(day, "", "","");//窗口下载
                    break;
                case 'xyResourcebox':
                    day = dateFormat("YYYY-mm-dd", date);
                    // 获取空闲窗口和在办窗口数量，以及详细情况
                    getckxxqk(day, "", "","");
                    break;
            }
            $(".mask-panel").addClass('active');
        });
    // 点击关闭按钮关闭弹出框
    $("body").on("click", ".close-btn", function () {
        $(this).parents('.mask-panel').removeClass('active');
    });

    // 各部门办件情况弹出框：Tab切换
    $("#cityzyProvide_propTab ul li").click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        if ($(this).html() == '当天') {
            day = dateFormat("YYYY-mm-dd", date)
            getbmblsl(day, "", "", "");
        } else if ($(this).html() == '当月') {
            month = dateFormat("YYYY-mm", date)
            getbmblsl("", month, "", "");
        } else if ($(this).html() == '当年') {
            year = dateFormat("YYYY", date)
            getbmblsl("", "", year, "");
        }
    });

    // 各窗口办件情况弹出框：Tab切换
    $("#shqcityzy_propTab ul li").click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        if ($(this).html() == '当天') {
            day = dateFormat("YYYY-mm-dd", date)
            getckrysj(day, "", "", "");
            // getfenyeshuju(day,"","","");
        } else if ($(this).html() == '当月') {
            month = dateFormat("YYYY-mm", date)
            getckrysj("", month, "", "");
            // getfenyeshuju("",month,"","");
        } else if ($(this).html() == '当年') {
            year = dateFormat("YYYY", date)
            getckrysj("", "", year, "");
            // getfenyeshuju("",month,"","");
        }
    });

});

// 各部门办件数量：下载
function cityzyProvideDownload() {
    var target = $("#cityzyProvide_propTab ul li[class='active']").attr("data-target");
    var date = new Date();
    switch (target) {
        case 'dt':
            window.location.href = ctx + "/tyslcontroller/downloadbmblsl?year=&month=&day=" + dateFormat("YYYY-mm-dd", date);
            break;
        case 'dy':
            window.location.href = ctx + "/tyslcontroller/downloadbmblsl?year=&month=" + dateFormat("YYYY-mm", date) + "&day=";
            break;
        case 'dn':
            window.location.href = ctx + "/tyslcontroller/downloadbmblsl?year=" + dateFormat("YYYY", date) + "&month=&day=";
            break;
    }
}

// 获取当天的一窗收件数量
function getycsjsl() {
    var ycsjsl = ctx + "/tyslcontroller/getycsjsl";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: ycsjsl,
        success: function (result) {
            //// console.log(result)
            $("#total_count").html(result.ycsjsl);
            $("#sum_success_times").html(0);
            $("#sum_failed_times").html(result.ycsjsl);
            $("#sum_benrishouli").html(result.brslsum);
            $("#sum_benribanje").html(result.brbjsum);
        },
        error: function (error) {

        }
    })
}

// 获取一窗收件一周的数量变化趋势
function getycsjqs() {
    var ycsjqs = ctx + "/tyslcontroller/getycsjqs";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: ycsjqs,
        success: function (result) {
            ////// console.log(result.ycsjqs);
            var arr = new Array();
            var arrs = new Array()
            for (var i = 0; i < result.ycsjqs.length; i++) {
                arr.push(result.ycsjqs[i].TIME);
                arrs.push(result.ycsjqs[i].SUM);
            }
            var chart3 = echarts.init(document.getElementById('chart3'));
            chart3.setOption({
                // title: {
                // 	text: '一窗收件变化趋势',
                // 	textStyle: {
                // 		color: '#fff',
                // 	},
                // },
                grid: {
                    top: '10%',
                    left: 0,
                    right: 0,
                    bottom: 0,
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    data: arr.reverse(),
                    axisLabel: {
                        interval: 0,
                        rotate: 30,
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
                            color: '#2e3450'
                        }
                    }
                },
                legend: {
                    data: ['收件数'],
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
                    data: arrs.reverse(),
                    color: '#0094fb'
                }]
            })

        },
        error: function (error) {

        }
    })
}

// 获取一窗收件事项排名
function getycsjlb() {
    var ycsjlb = ctx + "/tyslcontroller/getycsjlb";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: ycsjlb,
        data: {
            "page": 10
        },
        success: function (result) {
            //// console.log(result)
            if (result.ycsjlb.length > 0) {
                var qxHtml = "";
                for (var i = 0; i < result.ycsjlb.length; i++) {
                    qxHtml += "<tr>";
                    qxHtml += "<td style='width: 50px;'>" + (i + 1) + "</td>";
                    qxHtml += "<td width='350px' title='" + result.ycsjlb[i].ITEM_NAME + "' style='text-overflow: -o-ellipsis-lastline;" +
                        "overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical'>" + result.ycsjlb[i].ITEM_NAME + "</td>"; // 事项名称
                    qxHtml += "<td width='100px'>" + result.ycsjlb[i].TYPE + "</td>"; // 事项类型
                    qxHtml += "<td width='100px'>" + result.ycsjlb[i].REGION_NAME + "</td>"; // 收件区域
                    qxHtml += "<td width='120px'>" + result.ycsjlb[i].STATE + "</td>"; // 时间
                    qxHtml += "<td width='150px'>" + result.ycsjlb[i].RECEIVE_TIME + "</td>"; // 时间
                    qxHtml += "</tr>";
                }
                $("#body-lb").html(qxHtml)
            } else {
                $("#body-lb").html("暂无数据")
            }
        },
        error: function (error) {

        }
    })
}

// 获取各业务处室办件情况
function getbmblsl(day, mounth, year, page) {
    var bmblsl = ctx + "/tyslcontroller/getbmblsl";
    var arr = new Array();
    $.ajax({
        type: "get",
        url: bmblsl,
        data: {
            "day": day,
            "month": mounth,
            "year": year,
            "page": page
        },
        success: function (result) {
            //// console.log(result);
            var arr = new Array();
            var arrs = new Array();

            for (var i = 0; i < result.bmsl.length; i++) {
                arr.push(result.bmsl[i].ORG_NAME);
                arrs.push(result.bmsl[i].SUM)
            }
            ;
            // 获取图表 如果page是空的，说明要获取全部的部门数量。如果不是空的默认展示15条数据。
            if (page != "") {
                getcharts(arr, arrs);
            } else {
                //如果page是空的，说明要获取全部的部门数量，并生成列表
                var applyHtml = "";
                for (var i = 0; i < result.bmsl.length; i++) {
                    applyHtml += "<tr>";
                    applyHtml += "<td>" + (i + 1) + "</td>";
                    applyHtml += "<td class='shqshjResourceBM'>" + result.bmsl[i].ORG_NAME + "</td>"; // 部门名称
                    applyHtml += "<td>" + result.bmsl[i].SUM + "</td>"; // 被申请数（项）
                    applyHtml += "</tr>";
                }
                // htmlElement =applyHtml;
                $("#cityzyProvideProp tbody").html(applyHtml);
            }
        },
        error: function (error) {
        }
    })
}

// 获取各部门办件情况的图表
function getcharts(arr, arrs) {
    //显示数据，可修改
    var chart5 = echarts.init(document.getElementById("chart5"));
    var chartOption = {
        tooltip: {
            trigger: "axis"
        },
        xAxis: {
            data: arr,
            splitLine: {
                show: false
            },

            axisLabel: {
                inside: false,
                interval: 0,
                rotate: 40,
                textStyle: {
                    fontSize: '14',
                    color: '#ffffff'

                },
                formatter: function (name) {
                    return (name.length > 5 ? (name.slice(0, 5) + "...") : name);
                }
            }
        },
        yAxis: {
            splitLine: {
                show: true
            },
            axisLabel: {
                textStyle: {
                    color: '#ffffff'
                }
            },
            splitLine: {
                lineStyle: {
                    type: 'dashed',
                    color: '#2e3450'
                }
            }
        },
        series: [
            {
                name: '',
                type: 'bar',
                barWidth: 17,
                data: arrs,
                itemStyle: {
                    normal: {
                        label: {
                            show: true//是否展示
                        },
                        color: '#B49'
                    }
                }
            },
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    chart5.setOption(chartOption);
}




// 获取空闲窗口和在办窗口数量，以及详细情况 排队等待，完毕，数量
function getckxxqkss() {
    setTimeout(getckxxqkss,1000);
    var cktjsum = ctx + "/sxgl/cktjsum";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: cktjsum,
        success: function (result) {
            //// console.log(result)
            $("#sum_pdwb").html(result.pdwbsum);
            $("#sum_pddd").html(result.pdddsum);
            $("#sum_pdcl").html(result.pdclsum);
            $("#sum_kxck").html(result.kxcksum);
            $("#sum_ckzs").html(result.ckzssum);
        },

        error: function (error) {

        }
    })
}






//在办窗口切换
$("#xyResource_propTabs ul li").click(function () {
    var date = new Date()
    $(this).addClass('active').siblings().removeClass('active');
    if ($(this).html() == '当日') {
        day = dateFormat("YYYY-mm-dd", date)
        getckxxqk(day, "", "", "15");
    } else if ($(this).html() == '当月') {
        month = dateFormat("YYYY-mm", date)
        getckxxqk("", month, "", "15");
    } else if ($(this).html() == '当年') {
        year = dateFormat("YYYY", date)
        getckxxqk("", "", year, "15");
    }
});

// 获取空闲窗口和在办窗口数量，以及详细情况
function getckxxqk(day, mounth, year, page) {
    var ckrybj = ctx + "/tyslcontroller/getckxxqk";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: ckrybj,
        data:{
         "day": day,
            "month": mounth,
            "year": year,
            "page":"15"
        },
        success: function (result) {
             console.log(result.ckrybj)
            var arr = new Array();
            var arrs = new Array();
            for (var i = 0; i < result.ckrybj.length; i++) {
                arr.push(result.ckrybj[i].CODE);
                arrs.push({
                    "name":result.ckrybj[i].CODE,
                    "value":result.ckrybj[i].SUM
                })
            }
            ;
            var ckrybj = echarts.init(document.getElementById("ckrybj"));
            ckrybj.setOption({
               tooltip: {
                   trigger: "axis"
                },
                xAxis: {
                    data: arr,
                    splitLine: {
                        show: true
                   },

                    axisLabel: {
                        inside: true,
                       interval: 0,
                       rotate: 40,
                        textStyle: {
                            fontSize: '14',
                            color: '#ffffff'

                       },
                        formatter: function (name) {
                            return (name.length > 5 ? (name.slice(0, 5) + "...") : name);
                        }
                   }
                },
                yAxis: {
                    data: arrs,
                    splitLine: {
                        show: true
                    },
                    axisLabel: {
                        textStyle: {
                           color: '#ffffff'
                        }
                    },
                    splitLine: {
                        lineStyle: {
                            type: 'dashed',
                            color: '#2e3450'
                        }
                    }
                },
                series: [
                    {
                        name: '',
                        type: 'bar',
                        barWidth: 17,
                        data: arrs,
                       itemStyle: {
                            normal: {
                                label: {
                                    show: true//是否展示
                                },
                                color: '#B49'
                           }
                        }
                    },
               ]
            });
        },
        error: function (error) {

        }
    })
}




// 各窗口办件数量：下载
function gechuangkouDownload() {
    var target = $("#xyResource_propTabs ul li[class='active']").attr("data-target");
    var date = new Date();
    switch (target) {
        case 'day':
            window.location.href = ctx + "/tyslcontroller/downloadzbck?year=&month=&day=" + dateFormat("YYYY-mm-dd", date);
            break;
        case 'month':
            window.location.href = ctx + "/tyslcontroller/downloadzbck?year=&month=" + dateFormat("YYYY-mm", date) + "&day=";
            break;
        case 'year':
            window.location.href = ctx + "/tyslcontroller/downloadzbck?year=" + dateFormat("YYYY", date) + "&month=&day=";
            break;
    }
}






















// 展示在办窗口和空闲窗口的数据
function getzbcksl(id) {
    if (id == 1) {
        $("#cksl").html("在办窗口统计：")
        $('#xyResourceProp').show();
        $('#xyResourceTotalProp').hide();
    }
    if (id == 2) {
        $("#cksl").html("空闲窗口统计：")
        $('#xyResourceProp').hide();
        $('#xyResourceTotalProp').show();
    }

}

// 获取事项详情
function getdetails(name) {
    // console.log(111)
}

// 获取短信评价的数量以及满意度
function getdxpjxx() {
    var dxpjxx = ctx + "/tyslcontroller/getwspjxx";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: dxpjxx,
        success: function (result) {
            // console.log(result)
            var sum = 0;
            var sum1 = 0;
            var sum2 = 0;
            var sum3 = 0;
            var sum4 = 0;
            var arr = [{"name": "满意", "value": 0}, {"name": "基本满意", "value": 0}, {"name": "不满意", "value": 0}];
            var arrs = [{"name": "满意", "value": 0}, {"name": "基本满意", "value": 0}, {"name": "不满意", "value": 0}]
            // 网上评价
            for (var i = 0; i < result.wspj.length; i++) {
                sum += result.wspj[i].SUM
                if (result.dxpj[i].SCORETYPE == 1|| result.dxpj[i].SCORETYPE == 2) {
                    sum2 += result.dxpj[i].SUM;
                }
                if (result.wspj[i].SCORETYPE == 1) {
                    arr[0].value = result.wspj[i].SUM;
                }
                if (result.wspj[i].SCORETYPE == 2) {
                    arr[1].value = result.wspj[i].SUM;
                }
                if (result.wspj[i].SCORETYPE == 3) {
                    arr[2].value = result.wspj[i].SUM;
                }

            }
            // 短信评价
            for (var i = 0; i < result.dxpj.length; i++) {
                sum1 += result.dxpj[i].sum
                if (result.dxpj[i].msg == '满意'|| result.dxpj[i].msg == '基本满意') {
                    sum3 += result.dxpj[i].SUM;
                }
                if (result.dxpj[i].msg == '满意') {
                    arrs[0].value = result.dxpj[i].sum;
                }
                if (result.dxpj[i].msg == '基本满意') {
                    arrs[1].value = result.dxpj[i].sum;
                }
                if (result.dxpj[i].msg == '不满意') {
                    arrs[2].value = result.dxpj[i].sum;
                }

            }
            // console.log(arr);
            // console.log(arrs);
            // 网上评价
            getchartws(arr,sum);
            // 短信评价
            getchart(arrs,sum1);

            var arrss = new Array()
            arrss.push(
                {"name": "满意", "value":arr[0].value+ arr[0].value},
                {"name": "基本满意", "value": arr[1].value+ arr[1].value},
                {"name": "不满意", "value": arr[2].value+ arr[2].value}
            )
            // console.log(arrss)
            var total = 0;
            for (var i = 0; i <arrss.length ; i++) {
                total+=arrss[i].value
            }
            var nums = arrss[0].value+arrss[1].value
            var number = (nums / total) * 100;
            $("#ztmyd").html(number.toFixed(2)+"%")
            // 短信评价满意度
            var chart7 = echarts.init(document.getElementById("chart7"));
            chart7.setOption({
                tooltip: {
                    trigger: 'item',
                    formatter: function (params, ticket, callback) {//这是关键，在需要的地方加上就行了
                        // // console.log(params)
                        var num = (params.value / total) * 100;
                        //百分比保留小数点后两位
                        var ss = '满意度评价<br/>' + params.name + '&nbsp：' + params.value + '个' + '&nbsp占比：' + num.toFixed(2) + '%'
                        return ss;
                    }
                },
                color: ["#eefa36", "#65f5fe", "#ffbe37"],
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
                    data: ["满意", "基本满意", "不满意"]
                },
                grid: {
                    top: 80,
                    left: 60,
                    right: 10
                },
                series: [
                    {
                        name: '项目数量',
                        data: arrss,//  数据
                        type: 'pie',
                        radius: ['50%', '70%'],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }

                    },
                ]
            })
        },
        error: function (error) {

        }
    })
}

// 短信评价分别展示
function getchart(arr,sum) {
    // 短信评价满意度
    var chart8 = echarts.init(document.getElementById("chart8"));
    chart8.setOption({
        title: {
            text: '短信评价满意度',
            textStyle: {
                color: '#fff'
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: function (params, ticket, callback) {//这是关键，在需要的地方加上就行了
                // // console.log(params)
                var num = (params.value / sum) * 100;
                //百分比保留小数点后两位
                var ss = '满意度评价<br/>' + params.name + '&nbsp：' + params.value + '个' + '&nbsp占比：' + num.toFixed(2) + '%'
                return ss;
            }
        },
        color: ["#FF6600", "#65f5fe", "#ffbe37"],
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
            data: ["满意", "基本满意", "不满意"]
        },
        grid: {
            top: 80,
            left: 60,
            right: 10
        },
        series: [
            {
                name: '项目数量',
                data: arr,//  数据
                type: 'pie',
                radius: ['50%', '70%'],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }

            },
        ]
    })
}

// 网上评价分别展示
function getchartws(arr,sum) {
    // 网上评价满意度
    var chart9 = echarts.init(document.getElementById("chart9"));
    chart9.setOption({
        title: {
            text: '网上评价满意度',
            textStyle: {
                color: '#fff'
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: function (params, ticket, callback) {//这是关键，在需要的地方加上就行了
                // // console.log(params)
                var num = (params.value / sum) * 100;
                //百分比保留小数点后两位
                var ss = '满意度评价<br/>' + params.name + '&nbsp：' + params.value + '个' + '&nbsp占比：' + num.toFixed(2) + '%'
                return ss;
            }
        },
        color: ["#FF6600", "#65f5fe", "#ffbe37"],
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
            data: ["满意", "基本满意", "不满意"]
        },
        grid: {
            top: 80,
            left: 60,
            right: 10
        },
        series: [
            {
                name: '项目数量',
                data: arr,//  数据
                type: 'pie',
                radius: ['50%', '70%'],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }

            },
        ]
    })
}

// 获取窗口人员办件情况
function getckrybjqk(day, mounth, year,page) {
    var ycsjqs = ctx + "/tyslcontroller/getckrybjqk";
    $.ajax({
        type: "get",
        async: true,
        url: ycsjqs,
        data: {
            "day": day,
            "month": mounth,
            "year": year,
            "page": page
        },
        success: function (result) {
            // console.log(result.ckrybjqk);
            var arr = new Array();
            var arrs = new Array();
            for (var i = 0; i < result.ckrybjqk.length; i++) {
                arr.push(result.ckrybjqk[i].WINDOW_SHOW_CODE);
                arrs.push(result.ckrybjqk[i].SUM)
            }
            ;
            var chart6 = echarts.init(document.getElementById('chart6'));
            chart6.setOption({
                grid: {
                    top: '10%',
                    left: 0,
                    right: 0,
                    bottom: 0,
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    data: arr.reverse(),
                    axisLabel: {
                        interval: 0,
                        rotate: 30,
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
                            color: '#2e3450'
                        }
                    }
                },
                legend: {
                    data: ['收件数'],
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
                    type: 'bar',
                    name: '受理',
                    barWidth: 17,
                    data: arrs,
                    color: '#0094fb'
                }]
            })

        },
        error: function (error) {

        }
    })
}

// 获取窗口人员的弹出框的相关数据
function getckrysj(day, mounth, year, page) {
    // console.log(1111111)
    var bmblsl = ctx + "/tyslcontroller/getckrybjqk";
    var arr = new Array();
    $.ajax({
        type: "get",
        url: bmblsl,
        data: {
            "day": day,
            "month": mounth,
            "year": year,
            "page": page
        },
        success: function (result) {
            // console.log(result);
            // console.log(result.ckrybjqk);
            var arr = new Array();
            var arrs = new Array();
            for (var i = 0; i < result.ckrybjqk.length; i++) {
                arr.push(result.ckrybjqk[i].HANDLE_USER_NAME);
                arrs.push(result.ckrybjqk[i].NUM)
            };
            // 获取图表 如果page是空的，说明要获取全部的部门数量。如果不是空的默认展示15条数据。
            if (page != "") {
                getcharts(arr, arrs);
            } else {
                //如果page是空的，说明要获取全部的部门数量，并生成列表
                var applyHtml = "";
                for (var i = 0; i < result.ckrybjqk.length; i++) {
                    applyHtml += "<tr>";
                    applyHtml += "<td>" + (i + 1) + "</td>";
                    applyHtml += "<td class='shqshjResourceBM'>" + result.ckrybjqk[i].HANDLE_USER_NAME + "</td>"; // 部门名称
                    applyHtml += "<td>" + result.ckrybjqk[i].NUM + "</td>"; // 被申请数（项）
                    applyHtml += "</tr>";
                }
                // htmlElement =applyHtml;
                $("#shqcityResourceProp tbody").html(applyHtml);
            }
        },
        error: function (error) {
        }
    })
}


// fenye
function getfenyeshuju(day, mounth, year) {
    console.log(2222222222)
    var bmblsl = ctx + "/tyslcontroller/getckfycx";
    $.ajax({
        type: "get",
        url: bmblsl,
        data: {
            "day": day,
            "month": mounth,
            "year": year,
            "page": "",
            "pagess": "2"

        },
        success: function (result) {
            console.log(result);

        },
        error: function (error) {
        }
    })
}