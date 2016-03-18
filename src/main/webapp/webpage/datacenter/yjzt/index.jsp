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
	   .icon-btn .badge {
		    position: absolute;
		    top: 0px;
		    right: 0px;
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
                           <span>导航</span>
                           <span class="divider">/</span>
                       </li>
                       <li class="active">
                                                                                   硬件状态监控
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
				<div class="row-fluid">

						<div class="span4">

							<!-- BEGIN TAB PORTLET-->
                    <div class="widget widget-tabs green">
                        <div class="widget-title">
                            <h4><i class="icon-reorder"></i> 服务器列表</h4>
                        </div>
                        <div class="widget-body">
                            <div class="tabbable ">
                                <ul class="nav nav-tabs">
                                    <li><a href="#widget_tab2" data-toggle="tab">粮食局机房</a></li>
                                    <li class="active"><a href="#widget_tab1" data-toggle="tab">电信机房</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="widget_tab1">
                                       <div class="row-fluid">
													<a href="javascript:changeyingjian('101');" class="icon-btn span6">
														<i class="icon-facetime-video"></i>
														<div>波利、海康视频流媒体</div>
														<span class="badge badge-success">ip:101</span>
													</a>
													<a href="javascript:changeyingjian('102');" class="icon-btn span6">
														<i class="icon-group"></i>
														<div>web应用集群</div>
														<span class="badge badge-success">102</span>
													</a>
												</div>
												
												<div class="row-fluid">
													<a href="javascript:changeyingjian('103');" class="icon-btn span6">
														<i class="icon-folder-open"></i>
														<div>文件、权限等</div>
														<span class="badge badge-success">103</span>
													</a>
													<a href="javascript:changeyingjian('105');" class="icon-btn span6">
														<i class="icon-wrench"></i>
														<div>博恩、工具应用</div>
														<span class="badge badge-success">105</span>
													</a>
												</div>
												
												<div class="row-fluid">
													<a href="javascript:changeyingjian('106');" class="icon-btn span6">
														<i class="icon-globe"></i>
														<div>老GIS服务器</div>
														<span class="badge badge-success">106</span>
													</a>
													<a href="javascript:changeyingjian('107');" class="icon-btn span6">
														<i class="icon-barcode"></i>
														<div>老数据库</div>
														<span class="badge badge-success">107</span>
													</a>
												</div>
												
												<div class="row-fluid">
													<a href="javascript:changeyingjian('108');" class="icon-btn span6">
														<i class="icon-retweet"></i>
														<div>数据交换服务器</div>
														<span class="badge badge-success">108</span>
													</a>
													<a href="javascript:changeyingjian('110');" class="icon-btn span6">
														<i class="icon-facetime-video"></i>
														<div>波利视频流媒体</div>
														<span class="badge badge-success">110</span>
													</a>
												</div>
												
												<div class="row-fluid">
													<a href="javascript:changeyingjian('114');" class="icon-btn span6">
														<i class="icon-facetime-video"></i>
														<div>波利视频流媒体</div>
														<span class="badge badge-success">114</span>
													</a>
													<a href="javascript:changeyingjian('211');" class="icon-btn span6">
														<i class="icon-globe"></i>
														<div>新GIS服务器</div>
														<span class="badge badge-success">211</span>
													</a>
												</div>
												
												<div class="row-fluid">
													<a href="javascript:changeyingjian('212');" class="icon-btn span6">
														<i class="icon-barcode"></i>
														<div>新数据库</div>
														<span class="badge badge-success">212</span>
													</a>
												</div>
                                    </div>
                                    <div class="tab-pane" id="widget_tab2">
                                        <div class="row-fluid">
													<a href="javascript:changeyingjian('101');" class="icon-btn span6">
														<i class="icon-facetime-video"></i>
														<div>波利视频流媒体</div>
														<span class="badge badge-success">114</span>
													</a>
													<a href="javascript:changeyingjian('101');" class="icon-btn span6">
														<i class="icon-globe"></i>
														<div>新GIS服务器</div>
														<span class="badge badge-success">211</span>
													</a>
												</div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- END TAB PORTLET-->
						</div>
						
						<div class="span8">

							<!-- BEGIN PORTLET-->

							<div class="widget purple">
								
								<div class="widget-title">
		                            <h4><i class="icon-bar-chart"></i>101服务器概况 </h4>
		                         <span class="tools">
		                            <a href="${basePath}/webpage/datacenter/yjzt/yjxx/101.txt" id="serverdetails" target="_blank" class="btn btn-warning">详情</a>
		                         </span>
		                        </div>
		                        <div class="widget-body">
									
									<table class="table table-striped table-bordered table-advance table-hover">
	
										<tbody id="servercontent">
										
											<tr>
	
												<td>处理器(CPU)</td>
	
												<td>AMD Opteron(皓龙) 6212 八核 (X2)</td>
	
												<td>主	板</td>
	
												<td class="hidden-480">惠普 主板</td>
	
											</tr>
	
											<tr>
	
												<td>内	存</td>
	
												<td>16 GB</td>
	
												<td>硬	盘</td>
	
												<td class="hidden-480">惠普 Wom</td>
	
											</tr>
	
											<tr>
	
												<td>显	卡</td>
	
												<td>ATI ES1000 ( 64 MB / 惠普 )</td>
	
												<td>显示器</td>
	
												<td class="hidden-480">-/-</td>
	
											</tr>
	
											<tr>
	
												<td>光驱</td>
	
												<td>惠普 DV-28S-Y DVD光驱</td>
	
												<td>机箱</td>
	
												<td class="hidden-480">-/-</td>
											</tr>
	
										</tbody>
	
									</table>

								</div>

							</div>

							<!-- END PORTLET-->
							
							<!-- BEGIN PORTLET-->

							<div class="portlet paddingless">

								<div class="row-fluid">
									
															<div class="span12">
									
																<!-- BEGIN PORTLET-->
									
																<div class="widget blue">
									
																	<div class="widget-title">
									
																		<h4><i class="icon-bar-chart"></i> 主机CPU</h4>
									
																	</div>
									
																	<div class="widget-body">
																			<!-- <iframe style="width:100%;height:420px;" 
																			src="http://10.249.191.138/zabbix/screens.php?sid=2de06c1185381e63&form_refresh=1&fullscreen=1&elementid=21&groupid=8&hostid=10107" scrolling="auto" frameborder="no" border="0" marginwidth="0" id="iframe_zabbix_cpu" marginheight="0" ></iframe>
																	 -->
																	    <div class="text-center">
																	     <img alt="" src="${basePath}/webpage/datacenter/img/chart3.png" style="border:none;">
																	    </div>
																	</div>
									
																</div>
									
																<!-- END PORTLET-->
									
															</div>
														</div>

							</div>

							<!-- END PORTLET-->

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
    //项目名称
   var basePath='${basePath}';
   showLeftStyle("yjztjk");
   //$("#main-content").height(clientHeight);
   
   function changeyingjian(ip){
			/*$.post("systemalarm_yingjian/server.json",null,function(data){
				var json=eval("("+data+")");
				$.each(json.rows,function(i,n){
					if(ip==n.ip){
						$("#iframe_zabbix_jiainkong").attr('src',n.zabbixurl);
						$("#servertitle").html('<i class="icon-bar-chart"></i>'+n.ip+'服务器概况');
						$("#serverdetails").attr("href","systemalarm_yingjian/"+n.ip+".txt");
						$("#servercontent").html('<tr>'+
								
								'<td>处理器(CPU)</td>'+

								'<td>'+n.cpu+'</td>'+

								'<td>主	板</td>'+

								'<td class="hidden-480">'+n.zhuban+'</td>'+

							'</tr>'+

							'<tr>'+

								'<td>内	存</td>'+

								'<td>'+n.neicun+'</td>'+

								'<td>硬	盘</td>'+

								'<td class="hidden-480">'+n.yingpan+'</td>'+

							'</tr>'+

							'<tr>'+

								'<td>显	卡</td>'+

								'<td>'+n.xianka+'</td>'+

								'<td>显示器</td>'+

								'<td class="hidden-480">'+n.xianshiqi+'</td>'+

							'</tr>'+

							'<tr>'+

								'<td>光驱</td>'+

								'<td>'+n.guangqu+'</td>'+

								'<td>机箱</td>'+

								'<td class="hidden-480">'+n.jixiang+'</td>'+
							'</tr>');
					}
				});
			});*/
		}
   </script>
</body>
<!-- END BODY -->
</html>