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
                                                                                   日志管理
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
								                <th data-options="field:'opertype',width:50,align:'center'" >操作类型</th>
								                <th data-options="field:'content',width:100" >操作内容</th>
								                <th data-options="field:'createip',width:80,align:'left'" >ip地址</th>
								                <th data-options="field:'createuser',width:50,align:'center'" >操作用户</th>
								                <th data-options="field:'methodName',width:200" >方法名</th>
								                <th data-options="field:'params',width:200" >请求方法参数</th>
								                <th data-options="field:'createtime',width:100" >创建时间</th>
								                <!-- <th data-options="field:'tools',width:120,align:'center',formatter:rowformater" >操作</th> -->
								            </tr>
								        </thead>
								    </table>
								    <div id="tb" style="padding: 5px; height: auto;">
									    <div >
									    <span class="input-prepend"><span class="add-on">操作类型：</span>
											<select style="width:100px;" id="opertype">
											    <option value="">全部</option>
											    <option>登录</option>
											    <option>更新</option>
											    <option>删除</option>
											</select>
										</span>
									    <span class="input-prepend"><span class="add-on">操作用户：</span>
											<input type="text" id="username" style="width:150px;" class="m-wrap" maxlength="20" 
											          onkeypress="return noNumbers(event)">
										</span>
									    <span class="input-prepend"><span class="add-on">操作内容：</span>
											<input type="text" id="content" style="width:150px;" class="m-wrap" maxlength="20" 
											          onkeypress="return noNumbers(event)">
										</span>
									          
										<a href="#" onclick= "javascript: searchuser();" class="btn btn-info"><i class="icon-search"></i> 查询</a>
								    </div>
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
	  showLeftStyle("log");
	  /**
	   * 表格
	   */
	  $('#dg').datagrid( {
	  	width: clientWidth-200,  
	  	height: clientHeight-180,
	  	rownumbers : true,
	  	singleSelect : true,
	  	pagination : true,
	  	pageSize : 20,
	  	fitColumns: true,
	  	//nowrap:false,
	  	url : basePath+'/log/listPage'
	  });
	  //主列表查询
	  function searchuser() {
	  	var opertype=$('#tb #opertype').val();
	  	var username=$('#tb #username').val();
	  	var content=$('#tb #content').val();
	  	var v="";
	  	if(opertype!=""){
	  		v+=" and opertype = '"+opertype+"' ";
	  	}
	  	if(username!=""){
	  		v+=" and createuser like '%"+username.trim()+"%' ";
	  	}
	  	if(content!=""){
	  		v+=" and content like '%"+content.trim()+"%' ";
	  	}
	  	$("#dg").datagrid("options").queryParams["param"] =v;
	  	$("#dg").datagrid("reload");
	  }

   </script>
</body>
</html>