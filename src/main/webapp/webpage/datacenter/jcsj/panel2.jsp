<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="jiancedata2" style="min-height:350px;"></div>
<script>
showHighcharts();
function showHighcharts(){
	$('#jiancedata2').highcharts({
	    credits: {
	    	enabled: false
		},
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: ''
	    },
	    xAxis: {
	    	categories: ['水稻', '小麦', '玉米', '大豆', '粮油']
	    },
	    yAxis: {
	        title: {
	            text: '更新数据总量'
	        },
	        labels: {
	            formatter: function() {
	                return this.value;
	            }
	        }
	    },
	    tooltip: {
	        pointFormat: '更新数据总量： <b>{point.y:,.0f}</b>'
	    },
	    plotOptions: {
	        area: {
	            marker: {
	                enabled: false,
	                symbol: 'circle',
	                radius: 2,
	                states: {
	                    hover: {
	                        enabled: true
	                    }
	                }
	            }
	        }
	    },
	    series: [{
	        name: '统计数据项',
	        data: [43218,0,84934,147161,2527]
	    }]
	});
}
</script>