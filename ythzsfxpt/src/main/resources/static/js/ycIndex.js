$(function () {
    getycsjsl();
    getycsjlb();
    getycsjqs();
})

// 一窗收件事项弹出框：下载
function qxZyQkDownload() {
    window.location.href = ctx + "/tyslcontroller/downloadsxlb";
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
            $("#total_count").html(result.ycsjsl);
            $("#sum_success_times").html(0);
            $("#sum_failed_times").html(result.ycsjsl);
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
            "page": 15
        },
        success: function (result) {
            //console.log(result)
            if (result.ycsjlb.length > 0) {
                var qxHtml = "";
                for (var i = 0; i < result.ycsjlb.length; i++) {
                    qxHtml += "<tr>";
                    qxHtml += "<td style='width: 60px;'>" + (i + 1) + "</td>";
                    qxHtml += "<td width='300px' title='" + result.ycsjlb[i].ITEM_NAME + "' style='display: block;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;'>" + result.ycsjlb[i].ITEM_NAME + "</td>"; // 事项名称
                    qxHtml += "<td width='120px'>" + result.ycsjlb[i].TYPE + "</td>"; // 事项类型
                    qxHtml += "<td width='120px'>" + result.ycsjlb[i].REGION_NAME + "</td>"; // 收件区域
                    qxHtml += "<td width='120px'>" + result.ycsjlb[i].STATE + "</td>"; // 时间
                    qxHtml += "<td width='150px'>" + result.ycsjlb[i].SUBMIT_TIME + "</td>"; // 时间
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

// 获取一窗收件一周的数量变化趋势
function getycsjqs() {
    var ycsjqs = ctx + "/tyslcontroller/getycsjqs";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: ycsjqs,
        success: function (result) {
            //console.log(result.ycsjqs);
            var arr = new Array();
            var arrs = new Array()
            for (var i = 0; i < result.ycsjqs.length; i++) {
                arr.push(result.ycsjqs[i].TIME);
                arrs.push(result.ycsjqs[i].SUM);
            }
            var chart3 = echarts.init(document.getElementById('chart3'));
            chart3.setOption({
                title: {
                    text: '一窗收件变化趋势',
                    textStyle: {
                        color: '#fff',
                    },
                },
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
                            color: '#2e3450',
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
                    color: '#0094fb',
                }]
            })

        },
        error: function (error) {

        }
    })
}

// 获取一窗收件一周的数量变化趋势
function getbmblsl() {
    var bmblsl = ctx + "/tyslcontroller/getbmblsl";
    var arr = new Array();
    $.ajax({
        type: "get",
        async: true,
        url: ycsjqs,
        success: function (result) {
            //console.log(result.ycsjqs);
            var arr = new Array();
            var arrs = new Array()
            for (var i = 0; i < result.ycsjqs.length; i++) {
                arr.push(result.ycsjqs[i].TIME);
                arrs.push(result.ycsjqs[i].SUM);
            }
            var chart3 = echarts.init(document.getElementById('chart3'));
            chart3.setOption({
                title: {
                    text: '一窗收件变化趋势',
                    textStyle: {
                        color: '#fff',
                    },
                },
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
                            color: '#2e3450',
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
                    color: '#0094fb',
                }]
            })

        },
        error: function (error) {

        }
    })
}


// 点击更多现实弹出框
$("body").on("click", ".dialog", function () {
    var target = $(this).attr('data-target');
    $(".box[data-target='" + target + "']").siblings().removeClass('active');
    $(".box[data-target='" + target + "']").addClass('active');
    console.log(target)
    switch (target) {
        case 'shqshejzybox':
            // jQuery.shqshjResourceQk_Prop(); // 申请省级资源情况
            break;
        case 'shqcityzybox':
            // jQuery.shqcityResourceQk_Prop("0"); // 申请市级资源情况
            break;
        case 'cityzyProvidebox':
            // jQuery.cityzyProvideQk_Prop("0");// 市级资源提供响应情况
            break;
        case 'xyResourcebox':
            // jQuery.xyZyQk_Prop("3");// 现有资源数
            break;
    }
    $(".mask-panel").addClass('active');
});

// 点击关闭按钮关闭弹出框
$("body").on("click", ".close-btn", function () {
    $(this).parents('.mask-panel').removeClass('active');
});

