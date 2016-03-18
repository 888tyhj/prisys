<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="jiancedata3" style="min-height:350px;"></div>
<script>
$('#jiancedata3').highcharts({
    credits: {
    	enabled: false
	},
    chart: {
        type: 'area'
    },
    title: {
        text: ''
    },
    xAxis: {
    	categories: [
    	                '1',
    	                '2',
    	                '3',
    	                '4',
    	                '5',
    	                '6',
    	                '7',
    	                '8',
    	                '9',
    	                '10',
    	                '11',
    	                '12'
    	            ]
    },
    yAxis: {
        title: {
            text: '异常数据总量'
        },
        labels: {
            formatter: function() {
                return this.value / 1000 +'k';
            }
        }
    },
    tooltip: {
        pointFormat: '{series.name} 异常数据总量： <b>{point.y:,.0f}</b>'
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
        name: '水稻',
        color:'red',
        data: [null, null, 123 , 234, 345, 456, 235, 678, 640,521, 388,
        		222
        ]
    }]
});
</script>