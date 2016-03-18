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
                           <span>导航</span>
                           <span class="divider">/</span>
                       </li>
                       <li class="active">
                                                                                   用户状态监控
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
							  			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<div class="row-fluid">
				        <div class="span5">
		                    <!-- BEGIN CHART PORTLET-->
		                    <div class="widget green">
		                        <div class="widget-title">
		                            <h4><i class="icon-bullhorn"></i> 实时在线信息</h4>
		                            <span class="tools">
		                                <a href="javascript:alertOnLineUsers()" class="btn btn-warning">详情</a>
		                                <div id="userOnLine_dialog" class="easyui-dialog" data-options="buttons: '#userOnLine_dialog #dlg-buttons',closed:true">
												<div id="dlg-buttons">
													<button class="btn" onclick= "javascript: $('#userOnLine_dialog').dialog('close');"><i class="icon-remove"></i>关闭</button>
												</div>
									    </div>
		                            </span>
		                        </div>
		                        <div class="widget-body">
		                            <div id="user1" style="min-height:350px;"></div>
		                        </div>
		                    </div>
		                    <!-- END CHART PORTLET-->
		                    <div class="widget blue">
			                        <div class="widget-title">
			                            <h4><i class="icon-signal"></i> 月登录信息</h4>
			                            <span class="tools">
			                                <select id="userLogin_year" onchange="javascript:userLogin_onchange()" style="padding:0px;width:80px;height:25px;">
												<option>2015</option>
												<option>2014</option>
												<option>2013</option>
												<option>2012</option>
											</select><a href="javascript:alertUserLoginDetails()" class="btn btn-warning">详情</a>
											<div id="userLogin_dialog" class="easyui-dialog" data-options="buttons: '#userLogin_dialog #dlg-buttons',closed:true">
												<div id="dlg-buttons">
													<button class="btn" onclick= "javascript: $('#userLogin_dialog').dialog('close');"><i class="icon-remove"></i>关闭</button>
												</div>
											</div>
			                            </span>
			                        </div>
			                        <div class="widget-body">
			                            <div id="panel_userLoginCounts"></div>
			                        </div>
			                 </div>
		                </div>

						
						<div class="span7">

							<!-- BEGIN PORTLET-->
                               <div class="widget purple">
			                        <div class="widget-title">
			                            <h4><i class="icon-bar-chart"></i> 用户操作统计 </h4>
			                         <span class="tools">
			                         </span>
			                            <!-- <div class="update-btn">
			                                <a href="javascript:;" class="btn update-easy-pie-chart"><i class="icon-repeat"></i> Update</a>
			                            </div> -->
			                        </div>
			                        <div class="widget-body">
			                                      <div id="tb" style="padding: 5px; height: auto">
														<div>
																		<span class="input-prepend"><span class="add-on">用户名：</span>
																			<input type="text" id="uname" class="m-wrap" maxlength="20" onkeypress="return noNumbers(event)">
																		</span>
																		<span class="input-prepend"><span class="add-on">角色名：</span>
																			<input type="text" id="rname" class="m-wrap" maxlength="20" onkeypress="return noNumbers(event)">
																		</span>
																		<a href="javascript:searchlogs();" id="search_gydbs"  class="btn btn-info"><i class="icon-search"></i> 搜索</a>
																	</div>
													</div>
														<table  id="dg" style="margin: 0 auto">
															<thead>
																<tr>
																	<th data-options="field:'0',width:50">
																		用户名
																	</th>
																	<th data-options="field:'1',width:50">
																		角色名
																	</th>
																	<th data-options="field:'3',width:80">
																		所属模块
																	</th>
																	<th data-options="field:'4',width:80">
																		操作名
																	</th>
																	<th data-options="field:'2',width:150">
																		操作url
																	</th>
																	<th data-options="field:'5',width:100">
																		操作ip
																	</th>
																	<th data-options="field:'6',width:100">
																		操作时间
																	</th>
																</tr>
															</thead>
														</table>
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
   showLeftStyle("yhztjk");
   $("#main-content").height(clientHeight+150);
   
   function userLogin_onchange(){
		$("#panel_userLoginCounts").panel('refresh',basePath+'/webpage/datacenter/userstate/systemalarm_users_logincounts.jsp?year='+$("#userLogin_year").val());
	}
	function alertOnLineUsers(){
		$("#userOnLine_dialog").dialog({
			title:'在线用户详情',
			resizable:true,
			iconCls:'icon-user',
			height:600,
			width:800,
			modal:true,
			closed: false,
			href:basePath+"/webpage/datacenter/userstate/systemalarm_users_onlinedetails.jsp"
		});
	}

	function alertUserLoginDetails(){
		$("#userLogin_dialog").dialog({
			title:$("#userLogin_year").val()+'用户登录详情',
			resizable:true,
			iconCls:'icon-user',
			height:600,
			width:800,
			modal:true,
			closed: false,
			href:basePath+"/webpage/datacenter/userstate/systemalarm_users_onlinedetails2.jsp"
		});
	}
	function searchlogs(){
		$('#dg').datagrid('load',{
	        username: $('#uname').val(),  
	        rname: $('#rname').val(),
	        start: "2014-01-01",
	        end:"2014-09-19"
		});
	}
	$(function () {
		$('#dg').datagrid( {
			height:700,
			rownumbers : true,
			singleSelect : true,
			pagination : true,
			pageSize : 20,
			fitColumns: true,
			url : basePath+'/webpage/datacenter/userstate/table.json',
			queryParams:{
	        	start: "2014-01-01",
		        end:"2014-09-19"
			}
		});

		$('#user1').highcharts({
           credits:{
			  enabled:false
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
	            pointFormat: '{series.name}: <b>{point.y}</b>'
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
	        series: [{
	            type: 'pie',
	            name: '在线用户数',
	            data: [
	                   ['海陵区',   45.0],
	                   ['高港区',       26.8],
	                   {
	                       name: '姜堰区',
	                       y: 12.8,
	                       sliced: true,
	                       selected: true
	                   },
	                   ['兴化市',    8.5],
	                   ['泰兴市',     6.2],
	                   ['靖江市',   0.7]
	               ]
	        }]
	    });

		$("#panel_userLoginCounts").panel({href:basePath+'/webpage/datacenter/userstate/systemalarm_users_logincounts.jsp?year='+$("#userLogin_year").val(),border:false});
		

	});
   </script>
</body>
<!-- END BODY -->
</html>