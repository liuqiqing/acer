var ctx = $("#contextPath").val();
// 点击查询按钮触发事件
$("#btn-input").on("click", function () {
    // 循环选中的checkbox的值
    var i = 0;
    var depth = ""; // 网办深度
    var depth_title = ""; // 表格表头标题
    $("input[name='searchCheckbox']:radio").each(function () {
        if (this.checked) {
            //  window.alert("你选了："+ $('input[type=checkbox]:checked').length+"个，其中有："+$(this).val());
            var val = $(this).val();
            if (val == 1) {
                $('#ywzt_title').html("立项用地规划许可")
            } else if (val == 2) {
                $('#ywzt_title').html("工程建设许可")
            } else if (val == 3) {
                $('#ywzt_title').html("施工许可")
            } else if (val == 4) {
                $('#ywzt_title').html("竣工验收")
            } else {
                $('#ywzt_title').html("并行办理")
            }
            //console.log(val)
            getywzttj(val);
        }
    });
});
//部门受理办结排名--受理/办结tab切换
$("body").on("click", ".panel-body .depart-ranking-title span", function () {
    var name = $(this).attr("name");
    $(this).addClass('active').siblings().removeClass('active');
    if (name == 'acceptOption') {
        // qxbmsl(null);
    } else if (name == 'handleOption') {
        qxbmbj(null);

    }


});

// 点击更多加载依申请事项数据
function moreSearch(depth, checkType) {
    if (checkType == 1) {
        $("#check_1").prop("checked", true);// 默认选中1,2,4
        $("#check_2").prop("checked", true);
        $("#check_4").prop("checked", true);
    }

}

//下载按钮点击事件
function countyLevelDownload() {
    //拼接字符串
    var _val = "";
    var _name = "";
    // 获取选中的checkbox
    $("input[name='moreCheckbox']:checkbox").each(function () {
        //拿到每一个checkbox
        var _this = $(this);
        //判断是否选中
        if (_this.is(":checked")) {
            //获取选中的value
            _val += _this.val() + ","
            _name += _this.next().text() + ",";
        }
    });
    //去掉最后一个逗号
    var val = _val.substring(0, _val.lastIndexOf(","))
    var name = _name.substring(0, _name.lastIndexOf(","))

    window.location.href = ctx + "/countyLevelController/countyLevelDownload?checkVal=" + val + "&checkName=" + name;
}


$(function () {
    var mapchar = new Array();
    // 获取项目总数和总投资额
    getprojectsum();
    // 获取项目类别、项目类型
    getprojectlb();
    //各区县项目数量
    ysqgkkwsblsxtjList();
    // 申报情况统计
    getsbqktj();
    // 全区县依申请公开事项数据总览
    $("#check1").attr("checked", true);
    $('#ywzt_title').html("立项用地规划许可")
    // 业务状态统计
    getywzttj(1);
    // 每月联办业务受理数
    getlbywsls();
    // 项目列表
    getprojectlist();


    // 弹出框
    //点击更多现实弹出框
    $("body").on("click", ".dialog", function () {
        var target = $(this).attr('data-target');
        $(".box[data-target='" + target + "']").siblings().removeClass('active');
        $(".box[data-target='" + target + "']").addClass('active');
        moreSearch(null, 1);
        $('#table_content_prop').niceScroll({
            cursoropacitymin: 0,
            cursorcolor: "#0d57ab",
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
    $("body").on("click", ".close-btn", function () {
        $(this).parents('.mask-panel').removeClass('active');
    });


    // 点击更多中的查询按钮触发事件
    $("#btn_input_1").on("click", function () {
        // 循环选中的checkbox的值
        var i = 0;
        var depth = ""; // 网办深度
        var depth_title = ""; // 表格表头标题
        $("input[name='moreCheckbox']:checkbox").each(function () {
            if (this.checked) {
                var val = $(this).val();
                depth_title += $(this).next().text() + ",";
                depth += val + ",";
                i++;
            }
        });

    });

});

// 获取项目总数、投资总额
function getprojectsum() {
    var projectsum = ctx + "/blspController/getprojectsum";
    $.ajax({
        type: "get",
        url: projectsum,
        success: function (result) {
            // //console.log(result)
            // 项目总数
            $("#item-total-num").html(result.sum);
            // s市本级项目数
            $("#jnssum").html(result.jnssum);
            // 区县项目数
            $("#qxsuum").html(result.qxsum);
            // 总投资额
            $("#ysqsx").html(result.total.toFixed(2));
            // 公共投资
            $("#xsblsx").html(result.ggjs);
            // 社会投资
            $("#xxblsx").html(result.shtz);
        },
        error: function (error) {

        }
    })
}

// 获取项目类别、项目类型
function getprojectlb() {
    var projectlb = ctx + "/blspController/getprojectlb";
    var arr = new Array();
    var arrs = new Array();
    var arr1 = new Array();
    var arr1s = new Array();
    var zjfb = new Array();
    var zjfbs = new Array();
    $.ajax({
        type: "get",
        url: projectlb,
        success: function (result) {
            // //console.log(result.xmlx)
            var sum = 0;
            var sum1 = 0;
            var sum2 = 0;
            // 项目类别
            for (var i = 0; i < result.xmlb.length; i++) {
                arr.push(result.xmlb[i].PROJECT_CATEGORY);
                arrs.push({
                    value: result.xmlb[i].SUM,
                    name: result.xmlb[i].PROJECT_CATEGORY
                })
                sum += result.xmlb[i].SUM;
            }
            // 项目类型
            for (var i = 0; i < result.xmlx.length; i++) {
                arr1.push(result.xmlx[i].PROJECT_TYPE);
                arr1s.push({
                    value: result.xmlx[i].SUM,
                    name: result.xmlx[i].PROJECT_TYPE
                })
                sum1 += result.xmlx[i].SUM;
            }
            // 项目资金分布
            for (var i = 0; i < result.zjfb.length; i++) {
                zjfb.push(result.zjfb[i].TOTAL_AMOUNT);
                zjfbs.push({
                    value: result.zjfb[i].TOTAL,
                    name: result.zjfb[i].TOTAL_AMOUNT
                })
                sum2 += result.zjfb[i].TOTAL;
            }
            // 项目类别
            xmlb(arr, arrs, sum)
            // 项目类型
            xmlx(arr1, arr1s, sum1);
            // 资金分布
            xmzjfb(zjfb, zjfbs, sum2);
        },
        error: function (error) {

        }
    })
}

// 项目类别
function xmlb(arr, arrs, sum) {
    var chart1 = echarts.init(document.getElementById("ywblbhqs-pro1"));
    chart1.setOption({
        title: {
            text: '项目类别',
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
                var ss = '项目数量：' + params.value + '个<br/>' + '占比：' + num.toFixed(2) + '%'
                return ss;
            }
        },
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
            data: arr.reverse()
        },
        grid: {
            top: 80,
            left: 60,
            right: 10
        },
        series: [
            {
                name: '项目数量',
                data: arrs,//  数据
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
            },
        ]
    })
}

// 项目类型
function xmlx(arr, arrs, sum1) {
    var chart2 = echarts.init(document.getElementById("ywblbhqs-pro2"));
    chart2.setOption({
        title: {
            text: '项目类型',
            textStyle: {
                color: '#fff',
            },
        },
        tooltip: {
            trigger: 'item',
            formatter: function (params, ticket, callback) {//这是关键，在需要的地方加上就行了
                // //console.log(params.value)
                var num = (params.value / sum1) * 100;
                //百分比保留小数点后两位
                var ss = '项目数量：' + params.value + '个<br/>' + '占比：' + num.toFixed(2) + '%'
                return ss;
            }
        },
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
            data: arr.reverse()
        },
        grid: {
            top: 80,
            left: 60,
            right: 10
        },
        series: [
            {
                name: '项目数量',
                data: arrs,//  数据
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
}

// 资金分布
function xmzjfb(arr, arrs, sum2) {
    var chart3 = echarts.init(document.getElementById("ywblbhqs-pro3"));
    chart3.setOption({
        title: {
            text: '投资金额',
            textStyle: {
                color: '#fff',
            },
        },
        tooltip: {
            trigger: 'item',
            formatter: function (params, ticket, callback) {//这是关键，在需要的地方加上就行了
                // //console.log(params.value)
                var num = (params.value / sum2) * 100;
                //百分比保留小数点后两位
                var ss = '项目数量：' + params.value + '个<br/>' + '占比：' + num.toFixed(2) + '%'
                return ss;
            }
        },
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
            data: arr.reverse()
        },
        grid: {
            top: 80,
            left: 60,
            right: 10
        },
        series: [
            {
                name: '项目数量',
                data: arrs,//  数据
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
            },
        ]
    })
}

function convertData(data) {
    var res = [];
    var geoJinan = {
        "槐荫区": [116.85, 36.67],
        "历下区": [117.11, 36.65],
        "市中区": [116.91, 36.55],
        "天桥区": [116.98, 36.81],
        "历城区": [117.25, 36.7],
        "章丘区": [117.53, 36.72],
        "长清区": [116.75, 36.52],
        "平阴县": [116.45, 36.28],
        "济阳区": [117.15, 37.055],
        "莱芜区": [117.67, 36.22],
        "钢城区": [117.80, 36.07],
        "商河县": [117.15, 37.27]
    };
    for (var i = 0; i < data.length; i++) {
        var geoCoord = geoJinan[data[i].name];
        if (geoCoord) {
            var label_pos = ['30%', '30%'],
                label_padding = 0,
                label_bg = 'transparent';
            switch (data[i].name) {
                case '章丘区':
                    label_pos = [-25, -60];
                    break;
                case '天桥区':
                    label_pos = [30, -50];
                    break;
                case '商河县':
                    label_pos = [30, 0];
                    break;
                case '市中区':
                    label_pos = [-25, 30];
                    break;
                case '高新区':
                    label_pos = [-25, 30];
                    break;
                case '平阴县':
                    label_pos = [-25, -60];
                    break;
                case '历城区':
                    label_pos = [-15, -60];
                    break;
                case '历下区':
                    label_pos = [-25, -60];
                    break;
                case '长清区':
                    label_pos = [-25, -60];
                    break;
                case '槐荫区':
                    label_pos = [-25, -60];
                    break;
                case '莱芜区':
                    label_pos = [-25, -60];
                    break;
                case '钢城区':
                    label_pos = [-25, -60];
                    break;
            }
            res.push({
                name: data[i].name,
                value: geoCoord.concat(data[i].value),
                label: {
                    normal: {
                        show: false,
                        fontSize: 10,
                        color: '#fff38f',
                        formatter: function (param) {
                            return param.name;
                        },
                        position: label_pos
                    }
                }
            });
        }
    }
    return res;
}

// 各区县项目数量
function ysqgkkwsblsxtjList() {
    var qxsl = ctx + "/blspController/getqhxmsl";
    var mapchar = new Array();
    var mapchart = new Array();
    $.ajax({
        url: qxsl,
        type: 'get',
        async: true,
        dataType: 'json',
        success: function (result) {
            //console.log(result)
            var map = [{"name": "章丘区", "value": 0},
                {"name": "天桥区", "value": 0},
                {"name": "商河县", "value": 0},
                {"name": "市中区", "value": 0},
                {"name": "高新区", "value": 0},
                {"name": "平阴县", "value": 0},
                {"name": "济阳区", "value": 0},
                {"name": "历城区", "value": 0},
                {"name": "历下区", "value": 0},
                {"name": "长清区", "value": 0},
                {"name": "槐荫区", "value": 0},
                {"name": "莱芜区", "value": 0},
                {"name": "钢城区", "value": 0}]
            for (var i = 0; i < map.length; i++) {
                var isIn = false;
                for (var j = 0; j < result.qhxmsl.length; j++) {
                    if (map[i].name == result.qhxmsl[j].REGIONNAME) {
                        isIn = true;
                        map[i].value = result.qhxmsl[j].SUM
                    }
                }
                if (!isIn) {
                    map[i].value = 0;
                }
            }
            // 展示地图左侧列表数据
            for (var i = 0; i < map.length; i++) {
                var html = " <li>";
                html += "<span class='num-thin case-num-second'>" + (i + 1) + "</span>";
                html += "<span class='case-name'>" + map[i].name + "</span>";
                html += "<span class='num-thin case-sta'>" + map[i].value + "</span>";
                html += "</li>";
                $("#ysqkgkwsblsxtj").append(html);

            }
            // 获取地图的数据
            getmapdata(map);

        }

    });
}

// 获取地图的数据
function getmapdata(data) {
    //综合调度指挥中心map
    var mapChart = echarts.init(document.getElementById('center-map'), 'theme');
    var myOption = {
        tooltip: {
            trigger: 'item',
            formatter: function (params, ticket, callback) {//这是关键，在需要的地方加上就行了
                // //console.log(params)
                // var num = (params.value / sum1) * 100;
                //百分比保留小数点后两位
                var ss = '济南项目分布</br>' + params.name + '</br>项目数量：' + params.value[2] + "个"
                return ss;
            }
        },
        geo: {
            map: 'jinan',
            name: '济南市',
            roam: false,
            regionHeight: 3,
            itemStyle: {
                areaColor: '#0241ad',
                color: '#0241ad',
                opacity: 0.9,
                borderWidth: 1,
                borderColor: '#0181af'
            },
            label: {
                show: true,
                textStyle: {
                    color: '#fff', //地图初始化区域字体颜色
                    fontSize: 15,
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
                        fontSize: 15,
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
        },
        series: [
            {
                type: 'effectScatter',
                coordinateSystem: 'geo',
                zlevel: 2,
                symbolSize: 8,// 调整中心点的大小
                data: convertData(data),// 鼠标悬浮数据展示
                showEffectOn: 'render',
                rippleEffect: {
                    brushType: 'fill'
                },
                hoverAnimation: true,
                itemStyle: {
                    normal: {
                        color: '#CBD58A',
                        shadowColor: '#80c1c9'
                    }
                }
            }
        ]
    };
    mapChart.clear();
    mapChart.setOption(myOption, true);
    // 点击地图切换不同的区划，并展示相应的数据
    mapChart.on('click', function (params) {
        var county = params.name;
        // xian = county;
        console.log(params)
        $("#qxsxs").html(county+"事项数");
        $("#dynamic_qqxshxxzh_title").html(county+"收件办件统计");
        $("#qqxbmsl_title").html(county+"业务办理变化趋势");
        $("#qqxyshqgksxzl_title").html(county+"各部门事项情况");
        $("#qxxywblbhqsh_title").html(county+"各部门事项情况");
        $("#qqxshxxzhNum_Online_title").html(county+"事项信息展示");

    })
}

// 申报情况统计
function getsbqktj() {
    var sbqktj = ctx + "/blspController/getsbqktj";
    var sbqk = new Array();
    $.ajax({
        type: "get",
        url: sbqktj,
        success: function (result) {
            //console.log(result.sbqk)
            sbqk = result.sbqk;
            var arr = new Array();
            var sum = 0;
            for (var i = 0; i < sbqk.length; i++) {
                sum += sbqk[i].SUM;
                if (sbqk[i].BIZ_STATE == "99") {
                    arr.push({
                        "name": "办结量",
                        "value": sbqk[i].SUM
                    })
                }
            }
            arr.push({
                "name": "收件量",
                "value": sum
            })
            //console.log(arr)
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
                    data: ["办结量", "收件量"],
                    axisLabel: {
                        interval: 0,
                        // rotate: 45,
                        textStyle: {
                            color: '#e5f8ff',
                            fontSize: 16
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
                        name: '申报统计',
                        type: 'bar',
                        barWidth: 20,
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
                        data: arr
                    }
                ]
            });
        },
        error: function (error) {

        }
    })
}


// 业务状态统计
function getywzttj(id) {
    var ywzt = ctx + "/blspController/getywzttj";
    var ywzttj = new Array();
    $.ajax({
        type: "get",
        url: ywzt,
        data: {
            "stageid": id
        },
        success: function (result) {
            //console.log(result.ywzttj)
            ywzttj = result.ywzttj;
            var map = [{"name": "立项申请", "value": 0},
                {"name": "受理", "value": 0},
                {"name": "不予受理", "value": 0},
                {"name": "补齐补正", "value": 0},
                {"name": "挂起", "value": 0},
                {"name": "办结", "value": 0},
                {"name": "退件", "value": 0},
                {"name": "作废", "value": 0}]
            for (var i = 0; i < map.length; i++) {
                var isIn = false;
                for (var j = 0; j < ywzttj.length; j++) {
                    if (map[i].name == ywzttj[j].STATE) {
                        isIn = true;
                        map[i].value = ywzttj[j].SUM
                    }
                }
                if (!isIn) {
                    map[i].value = 0;
                }
            }
            //console.log(map)
            var ywzttj = echarts.init(document.getElementById("ywzttj"));
            ywzttj.setOption({
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
                    data: ["立项申请", "受理", "不予受理", "补齐补正", "挂起", "办结", "退件", "作废"],
                    axisLabel: {
                        interval: 0,
                        rotate: 45,
                        textStyle: {
                            color: '#e5f8ff',
                            fontSize: 15
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
                        name: '项目数量',
                        type: 'bar',
                        barWidth: 20,
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
                        data: map
                    }
                ]
            });
        },
        error: function (error) {

        }
    })
}

// 每月联办业务受理数
function getlbywsls() {
    var ywsls = ctx + "/blspController/getlbywsls";
    var arr = new Array();
    $.ajax({
        type: "get",
        url: ywsls,
        success: function (result) {
            //console.log(result.lbywsls)
            arr = result.lbywsls;
            var arr1 = new Array();
            var arr2 = new Array();
            for (var i = 0; i < arr.length; i++) {
                arr1.push(arr[i].APPLY_TIME)
                arr2.push(arr[i].SUM)
            }
            var chart4 = echarts.init(document.getElementById("chart4"));
            chart4.setOption({
                grid: {
                    top: 30,
                    left: 0,
                    right: 0,
                    bottom: 0,
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    data: arr1,
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
                    data: ['联办业务受理数'],
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
                    name: '联办业务受理数',
                    data: arr2,
                    color: '#0094fb',
                }]
            });
        },
        error: function (error) {

        }
    })
}

//  获取项目数量
function getprojectlist() {
    var ywsls = ctx + "/blspController/getprojectlist";
    var arr = new Array();
    $.ajax({
        type: "get",
        url: ywsls,
        success: function (result) {
            //console.log(result.projectlist)
            arr = result.projectlist;
            var htmlTr = "";
            for (var i = 0; i < arr.length; i++) {
                if (i == 0) {
                    htmlTr += "<tr><td class='top-three' width='20px'>";
                    htmlTr += "<img src='static/img/countyLevel/left/first-bg.png' alt='first'>"
                        + "<td class='name' title='" + arr[i].PROJECT_NAME + "'>" + arr[i].PROJECT_NAME + "</td>"
                        + "<td><em class='num-thin'>" + arr[i].APPLY_DATE + "</em></td>"
                        + "</tr>"
                } else if (i == 1) {
                    htmlTr += "<tr><td class='top-three' width='20px'>";
                    htmlTr += "<img src='static/img/countyLevel/left/second-bg.png' alt='first'>"
                        + "<td class='name' title='" + arr[i].PROJECT_NAME + "'>" + arr[i].PROJECT_NAME + "</td>"
                        + "<td><em class='num-thin'>" + arr[i].APPLY_DATE + "</em></td>"
                        + "</tr>"
                } else if (i == 2) {
                    htmlTr += "<tr><td class='top-three' width='20px'>";
                    htmlTr += "<img src='static/img/countyLevel/left/third-bg.png' alt='first'>"
                        + "<td class='name' title='" + arr[i].PROJECT_NAME + "'>" + arr[i].PROJECT_NAME + "</td>"
                        + "<td><em class='num-thin'>" + arr[i].APPLY_DATE + "</em></td>"
                    "</tr>"
                } else {
                    htmlTr += "<tr><td class='num-thin' width='20px'>" + i
                        + "<td class='name' title='" + arr[i].PROJECT_NAME + "'>" + arr[i].PROJECT_NAME + "</td>"
                        + "<td><em class='num-thin'>" + arr[i].APPLY_DATE + "</em></td>"
                        + "</tr>"
                }
            }
            //console.log(htmlTr)
            $("#sxxzsyjwsbls_tBody").html(htmlTr);

        },
        error: function (error) {

        }
    })
}