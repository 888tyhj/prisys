<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="jiancedata41" style="min-height:350px;"></div>
	
<script>
showHighcharts4();
function showHighcharts4(){
	$('#jiancedata41').highcharts({
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
	        text: ''
	    },
	    tooltip: {
	        pointFormat: '{series.data.name}<br>百分比：<b>{point.percentage:.1f}%</b><br>数量：<b>{point.y}</b>'
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            depth: 35,
	            dataLabels: {
	                enabled: true,
	                format: '{point.name}: {point.percentage:.1f}%'
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
	        data: [{"name":"自接站点","y":41534,"sliced":true,"selected":true},{"name":"接入站点","y":1684}]
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