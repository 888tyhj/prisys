<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
String year=request.getParameter("year");
%>
<div id="user2" style="min-height:350px;"></div>
<script>
var y="<%=year%>";
	$('#user2').highcharts({
        credits:{
		  enabled:false
		},
        chart: {
            type: 'spline'
        },
        title: {
            text: ''
        },
        xAxis: {
            categories: ['1月', '2月', '3月', '4月', '5月', '6月',
                '7月', '8月', '9月', '10月', '11月', '12月']
        },
        yAxis: {
            title: {
                text: y+'年登录次数统计'
            }
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        plotOptions: {
            spline: {
                marker: {
                    radius: 4,
                    lineColor: '#666666',
                    lineWidth: 1
                }
            }
        },
        series: [{
            name: '海陵区',
            data: [0,0,0,0,16,9,12,3,49,74,370,25]

        }, {
            name: '高港区',
            data: [0,0,0,28,245,599,736,340,257,284,329,51]
        }, {
            name: '姜堰区',
            data: [0,0,0,0,0,0,0,0,0,0,0,0]
        }, {
            name: '兴化市',
            data: [0,0,0,0,0,0,0,0,0,0,0,0]
        }, {
            name: '泰兴市',
            data: [0,0,0,0,0,0,38,90,38,19,50,27]
        }, {
            name: '靖江市',
            data: [0,0,0,2,0,0,30,70,34,29,40,0]
        }]
    });
</script>
