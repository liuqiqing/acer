$(function () {
    jrslbjsl()
    jrfwjkdycs()
    onlineConducts()
    countOrgs()
    hotOrgs()
    //共享交换数据提供部门左
    var department1 = echarts.init(document.getElementById('department1'));
    var departmentOption1 = {
        title: {
            text: '实时更新单位数',
            left: '0',
            bottom: 0,
            textStyle: {
                color: '#fff',
                fontSize: 14,
                fontWeight: 'normal'
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
                        value: 4,
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

    //共享交换数据提供部门右
    var department2 = echarts.init(document.getElementById('department2'));
    var departmentOption2 = {
        title: {
            text: '非实时更新单位数',
            left: 'center',
            bottom: 0,
            textStyle: {
                color: '#fff',
                fontSize: 14,
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

    //共享资源部门排名
    var ranking = echarts.init(document.getElementById('ranking'));
    var rankingOption = {
        color: ['#3dd3ba'],
        grid: {
            top: 20,
            left: 0,
            right: 20,
            bottom: 0,
            containLabel: true
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            type: 'category',
            data: ['环保厅', '工商局', '税务厅', '体育局', '安监局', '体育局'],
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
            splitNumber: 3,
            axisLabel: {
                textStyle: {
                    color: '#e5f8ff'
                }
            },
        },
        series: [
            {
                name: '接口健康度',
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
                data: [580, 420, 390, 300, 260, 180]
            }
        ]
    };
    ranking.setOption(rankingOption);

    //证件类型
    var card1 = echarts.init(document.getElementById('card-type1'));
    var type1 = {
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
            data: ['个人证明'],
            axisLine: {
                show: false
            },
            axisLabel: {
                show: false,
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
                data: [19]
            },
            {
                name: '总量',
                type: 'bar',
                z: 1,
                barWidth: 3,
                barGap: '-70%',
                itemStyle: {
                    color: '#4d6071'
                },
                data: [170]
            }
        ]
    };
    card1.setOption(type1);

    var card2 = echarts.init(document.getElementById('card-type2'));
    var type2 = {
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
            data: ['企业证明'],
            axisLine: {
                show: false
            },
            axisLabel: {
                show: false,
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
                data: [151]
            },
            {
                name: '总量',
                type: 'bar',
                z: 1,
                barWidth: 3,
                barGap: '-70%',
                itemStyle: {
                    color: '#4d6071'
                },
                data: [170]
            }
        ]
    };
    card2.setOption(type2);


    //数据目录总数和数据调用次数
    var CallingData = '58';

    var callingList = splitWord(CallingData);
    callingList += "<li><span class='text'>次</span></li>";
    $(".data-calling-list .num-list ul").html(callingList);


});

