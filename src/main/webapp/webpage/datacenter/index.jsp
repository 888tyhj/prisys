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
	<style>
	  .metro-nav .metro-nav-block{
	     width:23.5%;
	  }
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
                           <span>首页</span>
                       </li>
                   </ul>
                   <!-- END PAGE TITLE & BREADCRUMB-->
               </div>
            </div>
            <!-- END PAGE HEADER-->
            <!-- BEGIN PAGE CONTENT-->
               <div class="row-fluid user_fluid">
                   <div class="span12">
                       <!-- BEGIN BASIC PORTLET-->
                            <div id="dashboard">
								<!-- BEGIN DASHBOARD STATS -->
			
								<div class="row-fluid">
									<div class="metro-nav">
						                    <div class="metro-nav-block nav-block-orange">
						                        <a data-original-title="" href="#">
						                            <i class="icon-user"></i>
						                            <div class="info">1</div>
						                            <div class="status">在线用户数</div>
						                        </a>
						                    </div>
						                    <div class="metro-nav-block nav-olive">
						                        <a data-original-title="" href="#">
						                            <i class="icon-bell"></i>
						                            <div class="info">0</div>
						                            <div class="status">服务报警</div>
						                        </a>
						                    </div>
						                    <div class="metro-nav-block nav-block-yellow">
						                        <a data-original-title="" href="#">
						                            <i class="icon-globe"></i>
						                            <div class="info">4</div>
						                            <div class="status">监控数据异常</div>
						                        </a>
						                    </div>
						                    <div class="metro-nav-block nav-block-red">
						                        <a data-original-title="" href="#">
						                            <i class="icon-comments"></i>
						                            <div class="info">2</div>
						                            <div class="status">通知</div>
						                        </a>
						                    </div>
						                </div>
			
								</div>
			
								<!-- END DASHBOARD STATS -->
								<div class="clearfix"></div>
			
								<div class="row-fluid">
									<div class="span12">
										<!-- BEGIN PORTLET-->
										<div class="span7">
									
																<!-- BEGIN PORTLET-->
									
																<div class="widget blue">
									
																	<div class="widget-title">
									
																		<h4><i class="icon-bar-chart"></i>电信机房、粮食局分布</h4>
									
																	</div>
									
																	<div class="portlet-body">
																			<!-- <iframe style="width:100%;height:700px;" src="http://10.249.191.138/zabbix/map.php?noedit=1&sysmapid=1&width=500&height=100&curtime=1446787962525&severity_min=0&sid=2de06c1185381e63&screenid=16&updateProfile=1&period=3600&stime=20161105115637" scrolling="auto" frameborder="no" border="0" marginwidth="0" id="iframe_zabbix" marginheight="0" ></iframe>
																	</div> -->
																	    <div class="text-center">
																	      <img alt="" src="${basePath}/webpage/datacenter/img/map.png" style="border:none;">
									                                    </div>
									                                </div>
																</div>
									
																<!-- END PORTLET-->
									
															</div>
															
															<div class="span5">
									
																<!-- BEGIN PORTLET-->
																
																<div class="widget blue">

																	<div class="widget-title">
									
																		<h4><i class="icon-signal"></i>监控主机内存</h4>
									
																	</div>
									
																	<div class="widget-body">
																		<!-- <iframe style="width:100%;height:300px;" src="http://10.249.191.138/zabbix/chart2.php?graphid=534&period=3600&stime=20161105160113&updateProfile=1&profileIdx=web.screens&profileIdx2=534&sid=c89e8b9139918104&width=400&height=100" scrolling="auto" frameborder="no" border="0" marginwidth="0" id="iframe_zabbix_jiainkong" marginheight="0" ></iframe>
																	 -->
									                                     <img alt="" src="${basePath}/webpage/datacenter/img/chart2.png" style="border:none;">
																	</div>
									
																</div>
									
																<div class="widget blue">
									
																	<div class="widget-title">
									
																		<h4><i class="icon-bar-chart"></i>监控主机CPU</h4>
									
																	</div>
									
																	<div class="widget-body">
																			<!-- <iframe style="width:100%;height:300px;" src="http://10.249.191.138/zabbix/chart3.php?sid=2de06c1185381e63&graphid=524&name=Zabbix+server%3A+CPU+load&yaxismin=0.0000&yaxismax=100.0000&templateid=433&show_work_period=1&show_triggers=1&graphtype=0&show_legend=1&show_3d=0&percent_left=0.0000&percent_right=0.0000&ymin_type=1&ymax_type=0&ymin_itemid=0&ymax_itemid=0&flags=0&gitems%5B0%5D%5Bgitemid%5D=1720&gitems%5B0%5D%5Bgraphid%5D=524&gitems%5B0%5D%5Bitemid%5D=23296&gitems%5B0%5D%5Bdrawtype%5D=0&gitems%5B0%5D%5Bsortorder%5D=0&gitems%5B0%5D%5Bcolor%5D=009900&gitems%5B0%5D%5Byaxisside%5D=0&gitems%5B0%5D%5Bcalc_fnc%5D=2&gitems%5B0%5D%5Btype%5D=0&gitems%5B1%5D%5Bgitemid%5D=1721&gitems%5B1%5D%5Bgraphid%5D=524&gitems%5B1%5D%5Bitemid%5D=23297&gitems%5B1%5D%5Bdrawtype%5D=0&gitems%5B1%5D%5Bsortorder%5D=1&gitems%5B1%5D%5Bcolor%5D=000099&gitems%5B1%5D%5Byaxisside%5D=0&gitems%5B1%5D%5Bcalc_fnc%5D=2&gitems%5B1%5D%5Btype%5D=0&gitems%5B2%5D%5Bgitemid%5D=1722&gitems%5B2%5D%5Bgraphid%5D=524&gitems%5B2%5D%5Bitemid%5D=23295&gitems%5B2%5D%5Bdrawtype%5D=0&gitems%5B2%5D%5Bsortorder%5D=2&gitems%5B2%5D%5Bcolor%5D=990000&gitems%5B2%5D%5Byaxisside%5D=0&gitems%5B2%5D%5Bcalc_fnc%5D=2&gitems%5B2%5D%5Btype%5D=0&hosts%5B0%5D%5Bhostid%5D=10084&items%5B23296%5D%5Bitemid%5D=23296&items%5B23296%5D%5Bdrawtype%5D=0&items%5B23296%5D%5Bsortorder%5D=0&items%5B23296%5D%5Bcolor%5D=009900&items%5B23296%5D%5Byaxisside%5D=0&items%5B23296%5D%5Bcalc_fnc%5D=2&items%5B23296%5D%5Btype%5D=0&items%5B23296%5D%5Bkey_%5D=system.cpu.load%5Bpercpu%2Cavg1%5D&items%5B23297%5D%5Bitemid%5D=23297&items%5B23297%5D%5Bdrawtype%5D=0&items%5B23297%5D%5Bsortorder%5D=1&items%5B23297%5D%5Bcolor%5D=000099&items%5B23297%5D%5Byaxisside%5D=0&items%5B23297%5D%5Bcalc_fnc%5D=2&items%5B23297%5D%5Btype%5D=0&items%5B23297%5D%5Bkey_%5D=system.cpu.load%5Bpercpu%2Cavg5%5D&items%5B23295%5D%5Bitemid%5D=23295&items%5B23295%5D%5Bdrawtype%5D=0&items%5B23295%5D%5Bsortorder%5D=2&items%5B23295%5D%5Bcolor%5D=990000&items%5B23295%5D%5Byaxisside%5D=0&items%5B23295%5D%5Bcalc_fnc%5D=2&items%5B23295%5D%5Btype%5D=0&items%5B23295%5D%5Bkey_%5D=system.cpu.load%5Bpercpu%2Cavg15%5D&width=400&height=100&legend=1&updateProfile=1&profileIdx=web.screens&profileIdx2=16&period=3600&stime=20161105115637&screenid=16&curtime=1446788023492" scrolling="auto" frameborder="no" border="0" marginwidth="0"  marginheight="0" ></iframe>
																	 -->
																	     <img alt="" src="${basePath}/webpage/datacenter/img/chart3.png" style="border:none;">
																	</div>
									
																</div>
																
																<!-- END PORTLET-->
									
															</div>
										<!-- END PORTLET-->
									</div>
								</div>
							</div>
                       <!-- END BASIC PORTLET-->
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
    //项目名称
   var basePath='${basePath}';
   showLeftStyle("shouye");
   $("#main-content").height(clientHeight+80);
   </script>
</body>
<!-- END BODY -->
</html>