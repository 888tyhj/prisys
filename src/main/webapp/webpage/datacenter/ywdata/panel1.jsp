<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="yewudata1" style="min-height:350px;"></div>
	
<script>
function showHighcharts1(year,title){
	$('#yewudata1').highcharts({
	    credits: {
	    	enabled: false
		},
	    chart: {
	        type: 'pie',
	        options3d: {
	            enabled: true,
	            alpha: 45,
	            beta: 0
	        }
	    },
	    title: {
	        text: title
	    },
	    tooltip: {
	        pointFormat: '{series.data.name}<br>百分比：<b>{point.percentage:.1f}%</b><br>数量：<b>{point.y}</b>'
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
	        }
	    },
	    colors:[
	            '#FF00FF',
	            '#0000FF'
	        ],
	    series: [{
	        type: 'pie',
	        name: '',
	        data: [
	                {"name":"综合决策支持数据","y":0,"sliced":true,"selected":true},
	                {"name":"收储可视化数据","y":0},
	                {"name":"储备粮远程监控数据","y":0},
	                {"name":"价格监测与分析数据","y":0},
	                {"name":"粮食应急保障数据","y":0},
	                {"name":"粮食仓储管理数据","y":0},
	                {"name":"原粮质量安全追溯数据","y":0},
	                {"name":"监督检查数据","y":0}
	              ]
	    }]
	});
}

/*$('#jiancedata42').highcharts({
    credits: {
    	enabled: false
	},
    chart: {
        type: 'pie',
        options3d: {
            enabled: true,
            alpha: 45,
            beta: 0
        }
    },
    title: {
        text: '接入站点异常/正常数据'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            depth: 35,
            dataLabels: {
                enabled: true,
                format: '{point.name}'
            }
        }
    },
    colors:[
            '#FF00FF',
            '#0000FF'
        ],
    series: [{
        type: 'pie',
        name: '接入站点',
        data: [
            {
                name: '异常数据',
                y: 41.5,
                sliced: true,
                selected: true
            },
            ['正常数据',   51.5]
        ]
    }]
});*/
</script>