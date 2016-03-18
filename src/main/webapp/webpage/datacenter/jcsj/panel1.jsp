<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/static/context/mytags.jsp"%>
<div id="jiancedata1" style="min-height:350px;"></div>
<script>
var data='{"error":[19,0,42,48,35],"all":[97,22,67,67,138]}';
data=eval("("+data+")");

	$('#jiancedata1').highcharts({
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
	            text: '数据量'
	        }
	    },
	    credits: {
	        enabled: false
	    },
	    tooltip: {
        	headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y}条</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: { 
        	series: {
        		cursor: 'pointer', 
	        	point: {
		        	events: {
		        		click: function (e) {
        					alertJiancedata1();
		        		}
		        	}
	        	}
        	},
            column: {  
                dataLabels: {  
                    enabled: true  
                },  
                enableMouseTracking: true//是否显示title  
            }  
        },  
        series: [{
	        name: '异常数据',
	        color: 'red', 
	        data: data.error
	    }, {
	        name: '总数据',
	        color: 'blue', 
	        data: data.all
	    }]

	});

    function alertJiancedata1(){
    	/*$("#jiancedata1_dialog").dialog({
			title:'异常数据详情',
			resizable:true,
			iconCls:'icon-align-right',
			height:600,
			width:800,
			modal:true,
			closed: false
		});*/
    }
</script>
<div id="jiancedata1_dialog" class="easyui-dialog" data-options="buttons: '#jiancedata1_dialog #dlg-buttons',closed:true">

						<!--BEGIN TABS-->

						<div class="tabbable tabbable-custom tabbable-full-width">

							<ul class="nav nav-tabs">

								<li class="active"><a href="#tab_1_1" data-toggle="tab">水位</a></li>

								<li><a href="#tab_1_2" data-toggle="tab">雨量</a></li>

								<li><a href="#tab_1_3" data-toggle="tab">闸位</a></li>

								<li><a href="#tab_1_4" data-toggle="tab">泵机</a></li>

								<li><a href="#tab_1_5" data-toggle="tab">取水量</a></li>
								
								<li><a href="#tab_1_6" data-toggle="tab">地下水</a></li>
								
								<li><a href="#tab_1_7" data-toggle="tab">水质</a></li>
								
								<li><a href="#tab_1_8" data-toggle="tab">GPS</a></li>

							</ul>

							<div class="tab-content">
							
								<div class="tab-pane  active" id="tab_1_1">
									<table class="table table-condensed table-hover">
				
														<thead>
					
															<tr>
					
																<th>#</th>
					
																<th>公共编号</th>
																<th>更新时间</th>
					
															</tr>
					
														</thead>
					
														<tbody>
															
															<c:forEach var="users" items="${jiancedata1_details['shuiwei']}" varStatus="c">
						
																<tr>
						
																	<td>${c.count}</td>
						
																	<td>${users[0]}</td>
																	<td class="hidden-480"><span class="label label-success">${users[1]}</span></td>
						
						
																</tr>
															</c:forEach>
														</tbody>
					
													</table>
								</div>
								
								<div class="tab-pane " id="tab_1_2">
									<table class="table table-condensed table-hover">
				
														<thead>
					
															<tr>
					
																<th>#</th>
					
																<th>站点编号</th>
																<th>站点名称</th>
																<th >更新时间</th>
																
					
															</tr>
					
														</thead>
					
														<tbody>
															
															<c:forEach var="users" items="${jiancedata1_details['yuliang']}" varStatus="c">
						
																<tr>
						
																	<td>${c.count}</td>
						
																	<td>${users[0]}</td>
						
																	<td>${users[1]}</td>
						
																	<td class="hidden-480"><span class="label label-success">${users[2]}</span></td>
						
						
																</tr>
															</c:forEach>
														</tbody>
					
													</table>
								</div>
								
								<div class="tab-pane " id="tab_1_3">
									<table class="table table-condensed table-hover">
				
														<thead>
					
															<tr>
					
																<th>#</th>
					
																<th>闸泵站编号</th>
																<th>站点名称</th>
																<th >更新时间</th>
																<th >闸门开度</th>
					
															</tr>
					
														</thead>
					
														<tbody>
															
															<c:forEach var="users" items="${jiancedata1_details['zhawei']}" varStatus="c">
						
																<tr>
						
																	<td>${c.count}</td>
						
																	<td>${users[0]}</td>
						
																	<td>${users[1]}</td>
						
																	<td class="hidden-480"><span class="label label-success">${users[2]}</span></td>
																	
																	<td>${users[3]}</td>
						
						
																</tr>
															</c:forEach>
														</tbody>
					
													</table>
								</div>
								
								<div class="tab-pane " id="tab_1_4">
									<table class="table table-condensed table-hover">
				
														<thead>
					
															<tr>
					
																<th>#</th>
					
																<th>闸泵站编号</th>
																<th>站点名称</th>
																<th >更新时间</th>
					
															</tr>
					
														</thead>
					
														<tbody>
															
															<c:forEach var="users" items="${jiancedata1_details['bengji']}" varStatus="c">
						
																<tr>
						
																	<td>${c.count}</td>
						
																	<td>${users[0]}</td>
						
																	<td>${users[1]}</td>
						
																	<td class="hidden-480"><span class="label label-success">${users[2]}</span></td>
						
																</tr>
															</c:forEach>
														</tbody>
					
													</table>
								</div>
								
								<div class="tab-pane " id="tab_1_5">
									<table class="table table-condensed table-hover">
				
														<thead>
					
															<tr>
					
																<th>#</th>
					
																<th>企业编码</th>
																<th>企业名称</th>
																<th >测站代码</th>
																<th >更新时间</th>
					
															</tr>
					
														</thead>
					
														<tbody>
															
															<c:forEach var="users" items="${jiancedata1_details['qushuiliang']}" varStatus="c">
						
																<tr>
						
																	<td>${c.count}</td>
						
																	<td>${users[0]}</td>
						
																	<td>${users[1]}</td>
																	
																	<td>${users[3]}</td>
						
																	<td class="hidden-480"><span class="label label-success">${users[2]}</span></td>
						
																</tr>
															</c:forEach>
														</tbody>
					
													</table>
								</div>
								
								<div class="tab-pane " id="tab_1_6">
									<table class="table table-condensed table-hover">
				
														<thead>
					
															<tr>
					
																<th>#</th>
					
																<th>测站代码</th>
																<th>监测井名称</th>
																<th >实时水位</th>
																<th >更新时间</th>
					
															</tr>
					
														</thead>
					
														<tbody>
															
															<c:forEach var="users" items="${jiancedata1_details['dxs']}" varStatus="c">
						
																<tr>
						
																	<td>${c.count}</td>
						
																	<td>${users[0]}</td>
						
																	<td>${users[1]}</td>
																	
																	<td>${users[3]}</td>
						
																	<td class="hidden-480"><span class="label label-success">${users[2]}</span></td>
						
																</tr>
															</c:forEach>
														</tbody>
					
													</table>
								</div>
								
								<div class="tab-pane " id="tab_1_7">
									<table class="table table-condensed table-hover">
				
														<thead>
					
															<tr>
					
																<th>#</th>
					
																<th>测点编码</th>
																<th>测点名称</th>
																<th >更新时间</th>
					
															</tr>
					
														</thead>
					
														<tbody>
															
															<c:forEach var="users" items="${jiancedata1_details['shuizhi']}" varStatus="c">
						
																<tr>
						
																	<td>${c.count}</td>
						
																	<td>${users[0]}</td>
						
																	<td>${users[1]}</td>
																	
																	<td class="hidden-480"><span class="label label-success">${users[2]}</span></td>
						
																</tr>
															</c:forEach>
														</tbody>
					
													</table>
								</div>
								
								<div class="tab-pane " id="tab_1_8">
									<table class="table table-condensed table-hover">
				
														<thead>
					
															<tr>
					
																<th>#</th>
					
																<th>保洁船名称</th>
																<th >更新时间</th>
					
															</tr>
					
														</thead>
					
														<tbody>
															
															<c:forEach var="users" items="${jiancedata1_details['gps']}" varStatus="c">
						
																<tr>
						
																	<td>${c.count}</td>
						
																	<td>${users[0]}</td>
						
																	
																	<td class="hidden-480"><span class="label label-success">${users[1]}</span></td>
						
																</tr>
															</c:forEach>
														</tbody>
					
													</table>
								</div>

							</div>

						</div>

													
													<div id="dlg-buttons">
														<button class="btn" onclick= "javascript: $('#jiancedata1_dialog').dialog('close');"><i class="icon-remove"></i>关闭</button>
													</div>
												</div>