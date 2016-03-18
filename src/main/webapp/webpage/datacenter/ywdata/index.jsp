<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/static/context/mytags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><%=title%></title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
	<%@ include file="/static/context/mycss.jsp"%>
	<script type="text/javascript">
	   //项目名称
	   var basePath='${basePath}';
	</script>
	<style>
	  
	</style>
</head>
<!-- BEGIN BODY -->
<body class="fixed-top" id="fixed-top">
   <!-- BEGIN HEADER -->
     <jsp:include page="/webpage/datacenter/head.jsp"></jsp:include>
   <!-- END HEADER -->
   <!-- BEGIN CONTAINER -->
   <div id="container" class="row-fluid">
      <!-- BEGIN SIDEBAR -->
           <jsp:include page="/webpage/datacenter/left.jsp"></jsp:include>
      <!-- END SIDEBAR -->
      <!-- BEGIN PAGE -->  
      <div id="main-content">
         <!-- BEGIN PAGE CONTAINER-->
         <div class="container-fluid" >
            <!-- BEGIN PAGE HEADER-->   
            <div class="row-fluid">
               <div class="span12">
                  <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                   <!-- <h3 class="page-title">
                   </h3> -->
                   <ul class="breadcrumb">
                       <li class="icon-home">
                           <span>导航</span>
                           <span class="divider">/</span>
                       </li>
                       <li class="active">
                                                                                   业务数据监控
                       </li>
                   </ul>
                   <!-- END PAGE TITLE & BREADCRUMB-->
               </div>
            </div>
            <!-- END PAGE HEADER-->
            <!-- BEGIN PAGE CONTENT-->
               <div class="row-fluid user_fluid">
                   <div class="span12">
                       <!-- BEGIN 主体-->
                        <div id="dashboard">
                              <!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<div class="row-fluid ui-sortable" id="sortable_portlets">
					<div class="span6 column sortable">

							<!-- BEGIN PORTLET-->
							
							<div class="widget green">

								<div class="widget-title">
	
									<h4><i class="icon-reorder"></i>各类业务数据新增及更新量</h4>
									<div class="tools">
										<div class="btn-group">
											<input type="text" id="start" class="Wdate" style="width:85px"  
											onfocus="WdatePicker({onpicking:function(dp){queryDG(dp.cal.getNewDateStr())},dateFmt:'yyyy-MM'})"/>
										</div>
									</div>
	
								</div>
	
								<div class="widget-body">
									
									<div id="yewudata1_panel" style="min-height:350px;"></div>
	
								</div>
	
							</div>
							
							<div class="widget green">

								<div class="widget-title">
	
									<h4><i class="icon-reorder"></i>月汇总数据</h4>
									<div class="tools">

										<div class="btn-group" id="group_btn3">
												<select  style="padding:0;width:100px;height:25px;">
													<option value="全部">水稻</option>
													<option value="全部">小麦</option>
													<option value="全部">玉米</option>
													<option value="全部">大豆</option>
													<option value="全部">粮油</option>
												</select>
											<button class="btn active btn-warning" onclick="clickButton2(1,this,3)">1个月</button>
											<button class="btn btn-warning" onclick="clickButton2(2,this,3)">2个月</button>
											<button class="btn btn-warning" onclick="clickButton2(3,this,3)">3个月</button>
											<button class="btn btn-warning" onclick="clickButton2(6,this,3)">6个月</button>
											<button class="btn btn-warning" onclick="clickButton2(12,this,3)">全年</button>
										</div>

									</div>
	
								</div>
	
								<div class="widget-body">
									
									<div id="data3"></div>
	
								</div>
	
							</div>

							<!-- END PORTLET-->

					</div>
					
					<div class="span6 column sortable">

							<!-- BEGIN PORTLET-->
							
							<div class="widget green">

								<div class="widget-title">
	
									<h4><i class="icon-reorder"></i>月汇总数据量</h4>
									<div class="tools">
										<div class="btn-group">
											<select onchange="javascript:changeYewudata2();"  id="yewudata2_select" 
											   style="padding:0;width:150px;height:25px;">
													<option >综合决策支持</option>
													<option >收储可视化</option>
													<option >储备粮远程监控</option>
													<option >价格监测与分析</option>
													<option >粮食应急保障</option>
													<option >粮食仓储管理</option>
													<option >原粮质量安全追溯</option>
													<option >监督检查</option>
											</select>
										</div>
									</div>
								</div>
	
								<div class="widget-body">
									
									<div id="yewudata2_panel" style="min-height:350px;"></div>
	
								</div>
	
							</div>

							<!-- END PORTLET-->
							<!-- BEGIN PORTLET-->
							
							<div class="widget green">

								<div class="widget-title">
	
									<h4><i class="icon-reorder"></i>详细数据类别</h4>
									
									<div class="tools">

										<div class="btn-group">
												<select onchange="javascript:changeYewudata4();"  id="yewudata4_select" 
												    style="padding:0;width:150px;height:25px;">
													<option >综合决策支持</option>
													<option >收储可视化</option>
													<option >储备粮远程监控</option>
													<option >价格监测与分析</option>
													<option >粮食应急保障</option>
													<option >粮食仓储管理</option>
													<option >原粮质量安全追溯</option>
													<option >监督检查</option>
												</select>
										</div>

									</div>
	
								</div>
	
								<div class="widget-body">
									<div class="row-fluid">

										<div class="span12">
										
											<div id="jiancedata4_panel" style="min-height:350px;"></div>

										</div>

									</div>
	
								</div>
	
							</div>

							<!-- END PORTLET-->

					</div>
					
					</div>
					
				</div>

			<!-- END PAGE CONTAINER-->    

		<!-- END PAGE -->

	<!-- END CONTAINER -->
					    </div>
                       <!-- END 主体-->
                   </div>
               </div>
            <!-- END PAGE CONTENT-->         
         </div>
         <!-- END PAGE CONTAINER-->
      </div>
      <!-- END PAGE -->  
   </div>
   <!-- END CONTAINER -->
       
   <!-- BEGIN FOOTER -->
        <jsp:include page="/webpage/datacenter/footer.jsp"></jsp:include>
   <!-- END FOOTER -->

   <%@ include file="/static/context/myjs.jsp"%>
   <script type="text/javascript">
   showLeftStyle("ywsjjk");
   $("#main-content").height(clientHeight+200);
   
   
   $(function () {
		var nowDate=new Date();
		var jiancedate=nowDate.format("yyyy-MM");
		$("#start").val(jiancedate);
		
		$("#yewudata1_panel").panel({
			href: basePath+'/forwardindex?url=datacenter/ywdata/panel1',
			border:false,
			 onLoad:function(){
				 showHighcharts1(jiancedate,jiancedate+"各类业务数据新增及跟新量");
            }	
		});
		$("#yewudata2_panel").panel({
			href:basePath+'/forwardindex?url=datacenter/ywdata/panel2',
			border:false,
			 onLoad:function(){
				 showHighcharts2(jiancedate,jiancedate+"月汇总数据量","3");
            }	
		});
		$("#jiancedata4_panel").panel({href:basePath+'/forwardindex?url=datacenter/ywdata/panel4',border:false});

		 $('#data2').highcharts({
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
		                text: '更新数据总量'
		            },
		            labels: {
		                formatter: function() {
		                    return this.value / 1000 +'k';
		                }
		            }
		        },
		        tooltip: {
		            pointFormat: '{series.name} 更新数据总量： <b>{point.y:,.0f}</b>'
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
		            data: [null, null, 6 , 11, 32, 110, 235, 369, 640,521, 488,
		            		363
		            ]
		        }]
		    });

		 $('#data3').highcharts({
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

		 $('#data41').highcharts({
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
		            text: '自建站点异常/正常数据'
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
		            name: '自建站点',
		            data: [
		                {
		                    name: '异常数据',
		                    y: 18,
		                    sliced: true,
		                    selected: true
		                },
		                ['正常数据',   82]
		            ]
		        }]
		    });

		 $('#data42').highcharts({
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
		    });
		    
	});
	function queryDG(year){
		showHighcharts1(year,year+"各类业务数据新增及跟新量");
		showHighcharts2(year,year+"月汇总数据量","3");
	}
	function changeYewudata2(){
		showHighcharts2($("#start").val(),$("#start").val()+"月汇总数据量","3");
	}
  
	function clickButton2(value,obj,qx){
        $("#group_btn"+qx+" button").attr("class","btn btn-warning");
        $(obj).attr("class","btn active btn-warning");
        /*nearDate=value;
        $("#jiancedata"+qx+"_panel").panel('refresh','systemalarm_jiancedata_panel'+qx+'.jsp');
        $("#group_btn"+qx+" #jiancedata2_timebox").datebox('setValue',getPreNDate(endDate,value));
        $("#group_btn"+qx+" #jiancedata3_timebox").datebox('setValue',nowStr);*/
    }
   </script>
</body>
<!-- END BODY -->
</html>