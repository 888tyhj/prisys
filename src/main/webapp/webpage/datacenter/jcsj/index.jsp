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
                                                                                   监测数据监控
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
	
									<h4><i class="icon-reorder"></i>异常数据信息</h4>
									<div class="tools">
										<div class="btn-group pull-right" data-toggle="buttons-radio">
											<input onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"
											     id="jiancedata1_timebox" name="jiancedata1_timebox" value="" style="width:100px"/>
										</div>
										
									</div>
								</div>
	
								<div class="widget-body">
									
									<div id="jiancedata1_panel" style="min-height:350px;"></div>
	
								</div>
	
							</div>
							
							<div class="widget green">

								<div class="widget-title">
	
									<h4><i class="icon-reorder"></i>日异常数据总量</h4>
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
											<button class="btn btn-warning" onclick="clickButton2(4,this,3)">6个月</button>
											<button class="btn btn-warning" onclick="clickButton2(12,this,3)">全年</button>
										</div>

									</div>
	
								</div>
	
								<div class="widget-body">
									
									<div id="jiancedata3_panel" style="min-height:350px;"></div>
	
								</div>
	
							</div>

							<!-- END PORTLET-->

					</div>
					
					<div class="span6 column sortable">

							<!-- BEGIN PORTLET-->
							
							<div class="widget green">

								<div class="widget-title">
	
									<h4><i class="icon-reorder"></i>日更新数据总量</h4>
									<div class="tools">

										<div class="btn-group" id="group_btn2">
										    <input onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" 
										    id="jiancedata2_timebox" name="jiancedata2_timebox" 
										    style="width:100px;margin-right:10px;"/>
										         至
										    <input onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" 
										    id="jiancedata3_timebox" name="jiancedata3_timebox" 
										    value="" 
										    style="width:100px;margin-right:10px;"/>
											<button class="btn active btn-warning" onclick="clickButton2(1,this,2)">近1天</button>
											<button class="btn btn-warning" onclick="clickButton2(2,this,2)">近2天</button>
											<button class="btn btn-warning" onclick="clickButton2(3,this,2)">近3天</button>
											<!-- <button class="btn mini" onclick="clickButton2(7,this,2)">近7天</button> -->
											<!-- <button class="btn mini" onclick="clickButton2(30,this,2)">近30天</button> -->
										</div>

									</div>
								</div>
	
								<div class="widget-body">
									
									<div id="jiancedata2_panel" style="min-height:350px;"></div>
	
								</div>
	
							</div>

							<!-- END PORTLET-->
							<!-- BEGIN PORTLET-->
							
							<div class="widget green">

								<div class="widget-title">
	
									<h4><i class="icon-reorder"></i>水稻自接与非自接对比</h4>
									
									<div class="tools">

										<div class="btn-group" id="group_btn4">
										    <input onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" id="jiancedata2_timebox" name="jiancedata2_timebox" 
										    style="width:100px;margin-right:10px;"/>
										         至
										    <input onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" id="jiancedata3_timebox" name="jiancedata3_timebox" 
										      value="" 
										    style="width:100px;margin-right:10px;"/>
											<button class="btn active btn-warning" onclick="clickButton2(1,this,4)">近1天</button>
											<button class="btn btn-warning" onclick="clickButton2(2,this,4)">近2天</button>
											<!-- <button class="btn mini" onclick="clickButton2(3,this,4)">近3天</button> -->
											<!-- <button class="btn mini" onclick="clickButton2(7,this,4)">近7天</button>
											<button class="btn mini" onclick="clickButton2(30,this,4)">近30天</button> -->
										</div>

									</div>
	
								</div>
	
								<div class="widget-body">
									<div id="jiancedata4_panel" style="min-height:350px;"></div>
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
    //项目名称
   var basePath='${basePath}';
   showLeftStyle("jcsjjk");
    $("#main-content").height(clientHeight+150);
    
    
    var now = new Date(); 
	var nowStr = now.format("yyyy-MM-dd");
	var nearDate=0;
	var startDate=getPreNDate(nowStr,1);
	var endDate=nowStr;
	$(function () {
		$("#jiancedata1_panel").panel({href:basePath+'/forwardindex?url=datacenter/jcsj/panel1',border:false});
		$("#jiancedata2_panel").panel({href:basePath+'/forwardindex?url=datacenter/jcsj/panel2',border:false});
		$("#jiancedata3_panel").panel({href:basePath+'/forwardindex?url=datacenter/jcsj/panel3',border:false});
		$("#jiancedata4_panel").panel({href:basePath+'/forwardindex?url=datacenter/jcsj/panel4',border:false});
	});
	
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