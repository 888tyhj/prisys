<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/static/context/mytags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><%=qxTitle%></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%@ include file="/static/context/mycss.jsp"%>
</head>
<!-- BEGIN BODY -->
<body class="fixed-top">
   <!-- BEGIN HEADER -->
     <jsp:include page="/webpage/persys/head.jsp"></jsp:include>
   <!-- END HEADER -->
   <!-- BEGIN CONTAINER -->
   <div id="container" class="row-fluid">
      <!-- BEGIN SIDEBAR -->
           <jsp:include page="/webpage/persys/left.jsp"></jsp:include>
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
                           <span id="home_title">系统管理</span>
                           <span class="divider">/</span>
                       </li>
                       <li class="active">
                                                                                   用户管理
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
                                   <table id="dg" data-options="toolbar:'#tb'">
								        <thead>
								            <tr>
								                <th data-options="field:'username',width:80" >用户名</th>
								                <th data-options="field:'realname',width:80" >真实名</th>
								                <th data-options="field:'orgName',width:80,align:'left'" >所属组织</th>
								                <th data-options="field:'roleName',width:100" >角色列表</th>
								                <!-- <th data-options="field:'tools',width:120,align:'center',formatter:rowformater" >操作</th> -->
								            </tr>
								        </thead>
								    </table>
								    <div id="tb" style="padding: 5px; height: auto;">
									    <div >
									    <span class="input-prepend"><span class="add-on">用户名：</span>
											<input type="text" id="username" style="width:150px;" class="m-wrap" maxlength="20" 
											          onkeypress="return noNumbers(event)">
										</span>
									          
										<a href="#" onclick= "javascript: searchuser();" class="btn btn-info"><i class="icon-search"></i> 查询</a>
							        	<shiro:hasPermission name="user:create">
										    <a href="javascript:void(0);" onclick="addtn()" class="btn btn-warning" style="margin-left:50px;"><i class="icon-plus icon-white"></i>新增</a>
										</shiro:hasPermission>
										<shiro:hasPermission name="user:update">
								           <a href="javascript:void(0);" onclick="bianji()" class="btn btn-primary" style="margin-left:10px;"><i class="icon-pencil"></i> 修改</a>
									    </shiro:hasPermission>
									
										  <shiro:hasPermission name="user:delete">
										      <a href="javascript:void(0);" onclick="deleteRecord()" class="btn btn-danger" style="margin-left:10px;"><i class="icon-trash "></i> 删除</a>
										  </shiro:hasPermission>
										
										  <shiro:hasPermission name="user:update">
										      <a href="javascript:void(0);" onclick="changepassword()" class="btn btn-warning" style="margin-left:10px;"><i class="icon-tag"></i> 改密</a>
										  </shiro:hasPermission>
								    </div>
								    <!-- 弹出框开始 -->
								 <div id="dd" class="easyui-dialog" data-options="buttons: '#dd #dlg-buttons',closed:true">
									<div id="dlg-buttons">
										<button class="btn btn-success" onclick= "savedd()"><i class="icon-ok"></i>提交</button>
										<button class="btn btn-danger" onclick= "javascript: $('#dd').dialog('close');"><i class="icon-remove"></i>关闭</button>
									</div>
								</div>
								<!-- 弹出框结束 -->
						  </div>
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
        <jsp:include page="/webpage/persys/footer.jsp"></jsp:include>
   <!-- END FOOTER -->
   <%@ include file="/static/context/myjs.jsp"%>
   <script type="text/javascript">
	   //项目名称
	  var basePath='${basePath}';
      function  rowformater(value,row,index){
    	  var str='';
    	  <shiro:hasPermission name="user:update">
	        str+='<a href="${basePath}/user/${user.id}/update" class="btn btn-primary" style="margin-right:10px;"><i class="icon-pencil"></i> 修改</a>';
		  </shiro:hasPermission>
		
		  <shiro:hasPermission name="user:delete">
		      str+='<a href="${basePath}/user/${user.id}/delete" class="btn btn-danger" style="margin-right:10px;"><i class="icon-trash "></i> 删除</a>';
		  </shiro:hasPermission>
		
		  <shiro:hasPermission name="user:update">
		      str+='<a href="${basePath}/user/${user.id}/changePassword" class="btn btn-warning"><i class="icon-tag"></i> 改密</a>';
		  </shiro:hasPermission>
		  return str;
      }
   </script>
	<script type="text/javascript"
		src="${basePath}/static/js/persys/user.js"></script>
</body>
</html>