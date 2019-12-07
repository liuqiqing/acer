$(function () {
    var chart1 = echarts.init(document.getElementById("chart1"));
    var chartOption1 = {
        color:["#fce659","#51dcfa"],
        legend:{
            bottom:0,
            textStyle:{
                color:"#fff"
            }
        },
        tooltip:{},
        grid:{
            top:20,
            left:50,
            right:70
        },
        xAxis: {
            type: 'category',
            data: ['荣誉', '失信', '黑名单', '资质'],
            axisLine:{
                lineStyle:{
                    color:"#3f425a"
                }
            },
            axisLabel:{
                color:"#fff"
            }
        },
        yAxis: [
            {
                type: 'value',
                axisLine:{
                    lineStyle:{
                        color:"#3f425a"
                    }
                },
                axisLabel:{
                    color:"#fff"
                },
                splitLine:{
                    lineStyle:{
                        color:["#191e43"]
                    }
                }
            },
            {
                type: 'value',
                axisLine:{
                    lineStyle:{
                        color:"#3f425a"
                    }
                },
                axisLabel:{
                    color:"#fff"
                },
                splitLine:{
                    show:false,
                    lineStyle:{
                        color:["#191e43"]
                    }
                }
            },
        ],
        series: [
            {
                name:'个人条数',
                yAxisIndex:1,
                data: [220000, 500000, 25000, 20000],

                type: 'line'
            },
            {
                name:'法人条数',
                yAxisIndex:1,
                data: [20000, 390000, 120000,20000],
                type: 'line'
            },
            {
                name:'个人项',
                data: [50, 20, 5, 25,],
                type: 'bar'
            },
            {
                name:'法人项',
                data: [60, 45, 5, 30,],
                type: 'bar'
            },

        ]
    };
    chart1.setOption(chartOption1);


    var chart2 = echarts.init(document.getElementById("chart2"));
    var chartOption2 = {
        color: ['#37a2da','#32c5e9','#9fe6b8','#ffdb5c','#ff9f7f','#fb7293','#e7bcf3','#8378ea'],
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        calculable : true,
        series : [
            {
                name:'法人库',
                type:'pie',
                radius : [20, 60],
                center:['44%','50%'],
                roseType : 'area',
                data:[
                    {value:10, name:'住宿餐饮'},
                    {value:25, name:'房地产业'},
                    {value:15, name:'信息技术服务业'},
                    {value:25, name:'租赁和商务服务'},
                    {value:20, name:'教育业'},
                    {value:35, name:'金融业'},
                    {value:30, name:'其他服务业'},
                    {value:40, name:'批发零售业'},
                    {value:20, name:'电力热力燃气'},
                    {value:35, name:'建筑业'},
                    {value:30, name:'制造业'},
                    {value:40, name:'采矿业'},
                    {value:30, name:'农林牧渔'},
                    {value:40, name:'仓储邮政业'}
                ]
            }
        ]
    };
    chart2.setOption(chartOption2);




    var chart3 = echarts.init(document.getElementById("chart3"));
    var chartOption3 = {
        grid: [{
            show: false,
            left: '4%',
            top: 10,
            bottom: 10,
            containLabel: true,
            width: '40%'
        }, {
            show: false,
            left: '52%',
            top:10,
            bottom: 30,
            width: '2%'
        }, {
            show: false,
            right: '4%',
            top: 10,
            bottom: 10,
            containLabel: true,
            width: '40%'
        }],
        xAxis: [{
            splitNumber: 2,
            type: 'value',
            inverse: true,
            axisLine: {
                show: false,
            },
            axisTick: {
                show: false,
            },
            position: 'bottom',
            axisLabel: {
                show: true,
                textStyle: {
                    color: '#ccc',
                    fontSize: 12
                }
            },
            splitLine: {
                show: false,
                lineStyle: {
                    color: '#57617f',
                    width: 1,
                    type: 'solid'
                }
            }
        }, {
            gridIndex: 1,
            show: false,
        }, {
            gridIndex: 2,
            splitNumber: 2,
            type: 'value',
            axisLine: {
                show: false,
            },
            axisTick: {
                show: false,
            },
            position: 'bottom',
            axisLabel: {
                show: true,
                textStyle: {
                    color: '#ccc',
                    fontSize: 12,
                },
            },
            splitLine: {
                show: false,
                lineStyle: {
                    color: '#57617f',
                    width: 1,
                    type: 'solid',
                },
            },
        }, ],
        yAxis: [{
            type: 'category',
            inverse: true,
            position: 'right',
            axisLine: {
                show: false,
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                show: false,
            },
            data: [],

        }, {
            gridIndex: 1,
            type: 'category',
            inverse: true,
            position: 'center',
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                show: true,
                align: 'center',
                color:'#fff'
            },
            data: ['彝族', '德昂族', '哈尼族', '傣族', '壮族'],
        }, {
            gridIndex: 2,
            type: 'category',
            inverse: true,
            position: 'left',
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                show: false,
            },
            data: [],
        }, ],
        series: [{
            name: '引进',
            type: 'bar',
            barGap: 20,
            barWidth: '20',
            stack: '入',
            itemStyle: {
                normal: {
                    color: '#73B7FF'
                }
            },
            data: ['6666', '5700', '5600', '4000', '2500']
        }, {
            name: '调入',
            type: 'bar',
            barGap: 20,
            barWidth: '20',
            stack: '入',
            itemStyle: {
                normal: {
                    color: '#2B81FE'
                }
            },
            data: ['6666', '5700', '5600', '4000', '2500']
        }, {
            name: '离职',
            type: 'bar',
            barGap: 20,
            barWidth: '20',
            stack: '出',
            itemStyle: {
                normal: {
                    color: '#FFA300'
                }
            },
            xAxisIndex: 2,
            yAxisIndex: 2,
            data: ['6000', '5700', '5600', '4000', '2500'],
        }, {
            name: '调出',
            type: 'bar',
            barGap: 20,
            barWidth: '20',
            stack: '出',
            itemStyle: {
                normal: {
                    color: '#05D37E'
                }
            },
            xAxisIndex: 2,
            yAxisIndex: 2,
            data: ['6000', '5700', '5600', '4000', '2500'],
        }]
    };
    chart3.setOption(chartOption3);


    var chart4 = echarts.init(document.getElementById("chart4"));
    var chartOption4 = {
        color:['#2B81FE','#73B7FF','#fce659","#51dcfa','#05D37E'],
        tooltip: {
            trigger: 'item',
            formatter: "{b}: {c}"
        },
        calculable: true,
        series: [{
            name: '资产接入',
            type: 'treemap',
            width:'90%',
            height:'80%',
            roam: false, //是否开启拖拽漫游（移动和缩放）
            nodeClick: false,//点击节点后的行为,false无反应
            label: {
                normal: {
                    textStyle: {fontWeight: 'bold',fontSize: '14',}
                }
            },
            itemStyle: {
                normal: {
                    label: {
                        show: true,
                        formatter: "{b}"
                    },
                    borderWidth: 1,
                    borderColor: '#ffffff',
                },
                 emphasis: {
                     label: {
                         show: true
                     },
                     color: '#FFA300',
                     borderWidth: 3,
                 }
            },
            data: [
                { value: 60,name: '防火墙',},
                { value: 60, name: '应用系统',},
                { value: 10, name: '安全设备',},
                { value: 10, name:'终端行为', },
                { value: 10, name: '业务系统',}
            ]
        }]
    };
    chart4.setOption(chartOption4);


    var chart5 = echarts.init(document.getElementById("chart5"));
    var chartOption5={
        color: ['#00c2ff', '#f9cf67', '#e92b77'],
        legend: {
            show: true,
            // icon: 'circle',//图例形状
            bottom: 15,
            center: 0,
            itemWidth: 14, // 图例标记的图形宽度。[ default: 25 ]
            itemHeight: 14, // 图例标记的图形高度。[ default: 14 ]
            itemGap: 21, // 图例每项之间的间隔。[ default: 10 ]横向布局时为水平间隔，纵向布局时为纵向间隔。
            textStyle: {
                fontSize: 14,
                color: '#ade3ff'
            },
            data: ['2016', '2017', '2018'],
        },
        radar: [{
            indicator: [{
                text: '科技创新联盟',
                max: 100
            },
                {
                    text: '科技成果转化中心',
                    max: 100
                },
                {
                    text: '工程技术中心',
                    max: 100
                },
                {
                    text: '新型研发机构',
                    max: 100
                },
                {
                    text: '科技创孵化器',
                    max: 100
                }
            ],

            textStyle: {
                color: 'red'
            },
            center: ['50%', '50%'],
            radius: 70,
            startAngle: 90,
            splitNumber: 3,
            orient: 'horizontal', // 图例列表的布局朝向,默认'horizontal'为横向,'vertical'为纵向.
            // shape: 'circle',
            // backgroundColor: {
            //     image:imgPath[0]
            // },
            name: {
                formatter: '{value}',
                textStyle: {
                    fontSize: 14, //外圈标签字体大小
                    color: '#fff' //外圈标签字体颜色
                }
            },
            splitArea: { // 坐标轴在 grid 区域中的分隔区域，默认不显示。
                show: true,
                areaStyle: { // 分隔区域的样式设置。
                    color: ['#141c42', '#141c42'], // 分隔区域颜色。分隔区域会按数组中颜色的顺序依次循环设置颜色。默认是一个深浅的间隔色。
                }
            },
            // axisLabel:{//展示刻度
            //     show: true
            // },
            axisLine: { //指向外圈文本的分隔线样式
                lineStyle: {
                    color: '#153269'
                }
            },
            splitLine: {
                lineStyle: {
                    color: '#113865', // 分隔线颜色
                    width: 1, // 分隔线线宽
                }
            }
        }, ],
        series: [{
            name: '雷达图',
            type: 'radar',
            itemStyle: {
                emphasis: {
                    lineStyle: {
                        width: 4
                    }
                }
            },
            data: [{
                name: '2016',
                value: [85, 65, 55, 90, 82],
                areaStyle: {
                    normal: { // 单项区域填充样式
                        color: {
                            type: 'linear',
                            x: 0, //右
                            y: 0, //下
                            x2: 1, //左
                            y2: 1, //上
                            colorStops: [{
                                offset: 0,
                                color: '#00c2ff'
                            }, {
                                offset: 0.5,
                                color: 'rgba(0,0,0,0)'
                            }, {
                                offset: 1,
                                color: '#00c2ff'
                            }],
                            globalCoord: false
                        },
                        opacity: 1 // 区域透明度
                    }
                },
                symbolSize: 2.5, // 单个数据标记的大小，可以设置成诸如 10 这样单一的数字，也可以用数组分开表示宽和高，例如 [20, 10] 表示标记宽为20，高为10。
                label: {                    // 单个拐点文本的样式设置
                    normal: {
                        show: true,             // 单个拐点文本的样式设置。[ default: false ]
                        position: 'top',        // 标签的位置。[ default: top ]
                        distance: 2,            // 距离图形元素的距离。当 position 为字符描述值（如 'top'、'insideRight'）时候有效。[ default: 5 ]
                        color: '#6692e2',          // 文字的颜色。如果设置为 'auto'，则为视觉映射得到的颜色，如系列色。[ default: "#fff" ]
                        fontSize: 14,           // 文字的字体大小
                        formatter:function(params) {
                            return params.value;
                        }
                    }
                },
                itemStyle: {
                    normal: { //图形悬浮效果
                        borderColor: '#00c2ff',
                        borderWidth: 2.5
                    }
                },
                // lineStyle: {
                //     normal: {
                //         opacity: 0.5// 图形透明度
                //     }
                // }
            }, {
                name: '2017',
                value: [50, 20, 45, 30, 75],
                symbolSize: 2.5,
                itemStyle: {
                    normal: {
                        borderColor: '#f9cf67',
                        borderWidth: 2.5,
                    }
                },
                areaStyle: {
                    normal: { // 单项区域填充样式
                        color: {
                            type: 'linear',
                            x: 0, //右
                            y: 0, //下
                            x2: 1, //左
                            y2: 1, //上
                            colorStops: [{
                                offset: 0,
                                color: '#f9cf67'
                            }, {
                                offset: 0.5,
                                color: 'rgba(0,0,0,0)'
                            }, {
                                offset: 1,
                                color: '#f9cf67'
                            }],
                            globalCoord: false
                        },
                        opacity: 1 // 区域透明度
                    }
                },
                // lineStyle: {
                //     normal: {
                //         opacity: 0.5// 图形透明度
                //     }
                // }
            }, {
                name: '2018',
                value: [37, 80, 12, 50, 25],
                symbolSize: 2.5,
                itemStyle: {
                    normal: {
                        borderColor: '#e92b77',
                        borderWidth: 2.5,
                    }
                },
                areaStyle: {
                    normal: { // 单项区域填充样式
                        color: {
                            type: 'linear',
                            x: 0, //右
                            y: 0, //下
                            x2: 1, //左
                            y2: 1, //上
                            colorStops: [{
                                offset: 0,
                                color: '#e92b77'
                            }, {
                                offset: 0.5,
                                color: 'rgba(0,0,0,0)'
                            }, {
                                offset: 1,
                                color: '#e92b77'
                            }],
                            globalCoord: false
                        },
                        opacity: 1 // 区域透明度
                    }
                }
            }]
        }, ]
    };
    chart5.setOption(chartOption5);


    var chart6 = echarts.init(document.getElementById("chart6"));
    var chartOption6 =  {
        color:["#eefa36","#65f5fe","#ffbe37","#21beff","#8b80f4"],
        tooltip : {
            trigger: 'item',
            formatter: "{b} : {c} ({d}%)"
        },
        legend: {
            show:true,
            orient: 'horizontal',
            left: 'left',
            itemWidth: 16,
            itemHeight: 10,
            textStyle:{
                fontSize:12,
                color:'#fff'
            },
            icon:'bar',
            data: ["社会组织法人", "企业法人", "行政机关法人", "事业单位法人", "其他法人"]
        },
        grid:{
            top:0,
            bottom:0,
            left:0,
            right:0
        },
        series : [
            {
                name: '社会组织法人',
                type: 'pie',
                radius : ['30%', '35%'],
                center:['50%','60%'],
                hoverAnimation: false,
                label: {
                    normal: {
                        show:false,
                        position: 'inner'
                    }
                },
                data:[
                    {
                        value:'50',
                        name:'社会组织法人',
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.8)',
                                normal: {
                                    color: '#dc1439'
                                }
                            }
                        }
                    },
                    {
                        value:'100',
                        tooltip : {
                            show:false
                        },
                        itemStyle: {
                            normal: {
                                color: 'rgba(33,45,76,.5)'
                            }
                        }
                    }
                ]
            },
            {
                name: '企业法人',
                type: 'pie',
                radius : ['40%', '45%'],
                center:['50%','60%'],
                hoverAnimation: false,
                label: {
                    normal: {
                        show:false,
                        position: 'inner'
                    }
                },
                data:[
                    {
                        value:'200',
                        name:'企业法人',
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.8)',
                                normal: {
                                    color: '#dc1439'
                                }
                            }
                        }
                    },
                    {
                        value:'100',
                        tooltip : {
                            show:false
                        },
                        itemStyle: {
                            normal: {
                                color: 'rgba(33,45,76,.5)'
                            }
                        }
                    }
                ]
            },
            {
                name: '行政机关法人',
                type: 'pie',
                radius : ['50%', '55%'],
                center:['50%','60%'],
                hoverAnimation: false,
                label: {
                    normal: {
                        show:false,
                        position: 'inner'
                    }
                },
                data:[
                    {
                        value:'500',
                        name:'行政机关法人',
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.8)',
                                normal: {
                                    color: '#dc1439'
                                }
                            }
                        }
                    },
                    {
                        value:'100',
                        tooltip : {
                            show:false
                        },
                        itemStyle: {
                            normal: {
                                color: 'rgba(33,45,76,.5)'
                            }
                        }
                    }
                ]
            },
            {
                name: '事业单位法人',
                type: 'pie',
                radius : ['60%', '65%'],
                center:['50%','60%'],
                hoverAnimation: false,
                label: {
                    normal: {
                        show:false,
                        position: 'inner'
                    }
                },
                data:[
                    {
                        value:'800',
                        name:'事业单位法人',
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.8)',
                                normal: {
                                    color: '#dc1439'
                                }
                            }
                        }
                    },
                    {
                        value:'100',
                        tooltip : {
                            show:false
                        },
                        itemStyle: {
                            normal: {
                                color: 'rgba(33,45,76,.5)'
                            }
                        }
                    }
                ]
            },
            {
                name: '其他法人',
                type: 'pie',
                radius : ['70%', '75%'],
                center:['50%','60%'],
                hoverAnimation: false,
                label: {
                    normal: {
                        show:false,
                        position: 'inner'
                    }
                },
                data:[
                    {
                        value:'800',
                        name:'其他法人',
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.8)',
                                normal: {
                                    color: '#dc1439'
                                }
                            }
                        }
                    },
                    {
                        value:'100',
                        tooltip : {
                            show:false
                        },
                        itemStyle: {
                            normal: {
                                color: 'rgba(33,45,76,.5)'
                            }
                        }
                    }
                ]
            },
        ]
    };
    chart6.setOption(chartOption6);


    var chart7 = echarts.init(document.getElementById("chart7"));
    var chartOption7 ={
        tooltip: {
            trigger: 'item',
            formatter: "{b} : {d}% <br/> {c}"
        },
        series: [{
            type: 'pie',
            radius: ['40%', '50%'],
            center: ['50%', '50%'],
            color: ['#0E7CE2', '#FF8352', '#E271DE', '#F8456B', '#00FFFF', '#4AEAB0'],
            data: [{
                value: 335,
                name: '五保'
            },
                {
                    value: 310,
                    name: '低保'
                },
                {
                    value: 234,
                    name: '残疾'
                },
                {
                    value: 235,
                    name: '失独'
                },
                {
                    value: 254,
                    name: '重点优抚'
                },
                {
                    value: 174,
                    name: '突出贡献'
                }
            ],
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
                    formatter: '{c|{c}}\n{hr|}\n{d|{d}%}',
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
    };
    chart7.setOption(chartOption7);


    var chart8 = echarts.init(document.getElementById("chart8"));
    var chartOption8 ={
        title: [{
            text: '到期贷款余额（累计）',
            x:'35%',
            y:'86%',
            textStyle: {
                fontSize: '17',
                color: '#ffffff'
            }
        },
            {
                text: '到期余额笔数（累计）',
                x:'35%',
                y:'2%',
                textStyle: {
                    fontSize: '17',
                    color: '#ffffff'
                }
            },
            {
                text: '500万' ,
                x: '17%',
                y: '24%',
                textStyle: {
                    fontSize: '14',
                    color: '#ffffff'
                }
            },
            {
                text: '1000万' ,
                x: '22%',
                y: '36%',
                textStyle: {
                    fontSize: '14',
                    color: '#ffffff'
                }
            },
            {
                text: '1500万' ,
                x: '30%',
                y: '53%',
                textStyle: {
                    fontSize: '14',
                    color: '#ffffff'
                }
            },
            {
                text: '7000万' ,
                x: '40%',
                y: '68%',
                textStyle: {
                    fontSize: '14',
                    color: '#ffffff'
                }
            },
            {
                text: '7000笔' ,
                x: '46%',
                y: '22%',
                textStyle: {
                    fontSize: '14',
                    color: '#ffffff'
                }
            },
            {
                text: '1500笔' ,
                x: '55%',
                y: '38%',
                textStyle: {
                    fontSize: '14',
                    color: '#ffffff'
                }
            },
            {
                text: '1000笔' ,
                x: '60%',
                y: '52%',
                textStyle: {
                    fontSize: '14',
                    color: '#ffffff'
                }
            },
            {
                text: '500笔' ,
                x: '67%',
                y: '65%',
                textStyle: {
                    fontSize: '14',
                    color: '#ffffff'
                }
            }
        ],
        backgroundColor:'#0e2147',
        grid: {
            left: '3.8%',
            top:'10%',
            right: '7%',
            bottom: '12%',
            containLabel: true
        },
        xAxis:[{
            name:'',
            show: false
        },
            {
                name:'',
                show: false,
                inverse: true
            }],
        yAxis: [{
            name: '',
            data: ['0-180天', '0-90天', '0-60天', '0-30天'],
            axisTick: {show: false},
            axisLine: {show: false},
            axisLabel:{
                textStyle:{
                    color: 'rgba(255,255,255,0.8)',
                    fontSize:'14',
                },
            }
        },
            {
                name: '',
                data: ['0-180天', '0-90天', '0-60天', '0-30天'],
                axisTick: {show: false},
                axisLine: {show: false},
                axisLabel:{
                    textStyle:{
                        color: 'rgba(255,255,255,0.8)',
                        fontSize:'14',
                    },
                },
                position: 'right',
                inverse: true
            }],
        series: [{
            name: 'hill',
            type: 'pictorialBar',
            barCategoryGap: '0%',
            symbol: 'path://M730 250 L730 325 L770 325 Z',
            label:{
                normal:{
                    show:false,
                    formatter: '500万',
                    textStyle:{
                        fontSize:'16',
                        color:'#ffffff'
                    }
                }
            },
            itemStyle: {
                normal: {
                    color: '#d0a00e'
                }
            },
            data: [0, 0, 0 ,10],
            z: 4
        },
            {
                name: 'hill',
                type: 'pictorialBar',
                barCategoryGap: '0%',
                symbol: 'path://M730 250 L730 325 L770 325 L750 250 Z',
                label:{
                    normal:{
                        show:false,
                        formatter: '1000万',
                        textStyle:{
                            fontSize:'16',
                            color:'#ffffff'
                        }
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#eb7f00'
                    }
                },
                data: [0, 0, 20, 0],
                z: 4
            },
            {
                name: 'hill',
                type: 'pictorialBar',
                barCategoryGap: '0%',
                symbol: 'path://M730 250 L730 325 L770 325 L756.5 250 Z',
                label:{
                    normal:{
                        show:false,
                        formatter: '1500万',
                        textStyle:{
                            fontSize:'16',
                            color:'#ffffff'
                        }
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#eb4800'
                    }
                },
                data: [0, 30, 0, 0],
                z: 4
            },
            {
                name: 'hill',
                type: 'pictorialBar',
                barCategoryGap: '0%',
                symbol: 'path://M730 250 L730 325 L770 325 L760 250 Z',
                label:{
                    normal:{
                        show:false,
                        formatter: '7000万',
                        textStyle:{
                            fontSize:'16',
                            color:'#ffffff'
                        }
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#eb2100'
                    }
                },
                data: [40, 0, 0, 0],
                z: 4
            },
            {
                name: 'hill',
                type: 'pictorialBar',
                barCategoryGap: '0%',
                symbol: 'path://M730 250 L770 250 L730 325  Z',
                label:{
                    normal:{
                        show:false,
                        formatter: '500笔',
                        textStyle:{
                            fontSize:'16',
                            color:'#ffffff'
                        }
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#76ec99'
                    }
                },
                data: [0, 0, 0 ,10],
                xAxisIndex: 1,
                yAxisIndex: 1,
                z: 4
            },
            {
                name: 'hill',
                type: 'pictorialBar',
                barCategoryGap: '0%',
                symbol: 'path://M730 250 L730 325 L750 325 L770 250 Z',
                label:{
                    normal:{
                        show:false,
                        formatter: '1000笔',
                        textStyle:{
                            fontSize:'16',
                            color:'#ffffff'
                        }
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#3cb371'
                    }
                },
                data: [0, 0, 20 ,0],
                xAxisIndex: 1,
                yAxisIndex: 1,
                z: 4
            },
            {
                name: 'hill',
                type: 'pictorialBar',
                barCategoryGap: '0%',
                symbol: 'path://M730 250 L730 325 L750 325 L760 250 Z',
                label:{
                    normal:{
                        show:false,
                        formatter: '1500笔',
                        textStyle:{
                            fontSize:'16',
                            color:'#ffffff'
                        }
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#35935e'
                    }
                },
                data: [0, 30, 0 ,0],
                xAxisIndex: 1,
                yAxisIndex: 1,
                z: 4
            },
            {
                name: 'hill',
                type: 'pictorialBar',
                barCategoryGap: '0%',
                symbol: 'path://M730 250 L730 325 L760 325 L770 250 Z',
                label:{
                    normal:{
                        show:false,
                        formatter: '7000笔',
                        textStyle:{
                            fontSize:'16',
                            color:'#ffffff'
                        }
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#2e744b'
                    }
                },
                data: [40, 0, 0 ,0],
                xAxisIndex: 1,
                yAxisIndex: 1,
                z: 4
            }]
    };
    chart8.setOption(chartOption8)


    initNicScroll();
    function initNicScroll(){
        $('.table-content').niceScroll({
            cursoropacitymin: 0,
            cursorcolor:"#0d57ab",
            cursorborder: '#0d57ab'
        });
        $('.table-content').getNiceScroll().resize();
    }


});