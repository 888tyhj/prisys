<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="yewudata2" style="min-height:350px;"></div>
	
<script>
function showHighcharts2(year,title,type){
	            var t="s1";
	             var data='{"s1":{"xname":["用户状态","硬件状态","监测数据","业务数据"],"yvalues":[0,0,0,0]}}';
				var json= eval("("+data+")");
				var xname;
				var yvalues;
				if(t=="s1"){
					xname=json.s1.xname;
					yvalue=json.s1.yvalues;
				}
				if(t=="s2"){
					xname=json.s2.xname;
					yvalue=json.s2.yvalues;
				}
				if(t=="s3"){
					xname=json.s3.xname;
					yvalue=json.s3.yvalues;
				}
				if(t=="s4"){
					xname=json.s4.xname;
					yvalue=json.s4.yvalues;
				}
				if(t=="s5"){
					xname=json.s5.xname;
					yvalue=json.s5.yvalues;
				}
		    	$("#yewudata2").highcharts({
		    		title: {
		                text: title
		            },
		            chart: {
		                type: 'column'
		            },
		            credits:{
					  enabled:false
					},
					legend: {
						enabled:false
					},
		            xAxis: {
		                categories: xname,
		                labels: {  
	                    rotation: -45, //字体倾斜  
	                    align: 'right'
	                	} 
		            },
		            yAxis: {
		                title: {
		                    text: ""
		                }
		            },
		            tooltip: {
		            	headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		                    '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
		                footerFormat: '</table>',
		                shared: true,
		                useHTML: true
		            },
		            plotOptions: {
		            	column: {
	                        dataLabels: {
	                            enabled: true,
	                            style:{
	                                size:50
	                            }
	                        },
	                        pointPadding: 0.2,
			                borderWidth: 0,
			                pointWidth: 5,
	                        enableMouseTracking: true//是否显示title  
	                    }
	                },  
		            series:[{name:"汇总情况",data:yvalue}]
		        });
	}

</script>