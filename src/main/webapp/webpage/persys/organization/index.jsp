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
	<script type="text/javascript">
     //项目名称
    var basePath='${basePath}';
    </script>
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
                                                                                   组织机构管理
                       </li>
                   </ul>
                   <!-- END PAGE TITLE & BREADCRUMB-->
               </div>
            </div>
            <!-- END PAGE HEADER-->
            <!-- BEGIN PAGE CONTENT-->
               <div class="row-fluid user_fluid">
                    <div class="span12" >
                         <!-- BEGIN BASIC PORTLET-->
						<%-- <iframe name="tree" class="ui-layout-west"
						        src="${basePath}/organization/tree" frameborder="0" scrolling="auto"></iframe>
						<iframe name="content" class="ui-layout-center"
						        src="" frameborder="0" scrolling="auto"></iframe> --%>
						    <div class="easyui-layout"  id="layout-id">
									        <div data-options="region:'west',split:true,title:'组织机构',collapsible:false,href:'${basePath}/organization/left'" style="width:300px">
									        </div>
									        <div data-options="region:'center',title:'操作页面',href:'${basePath}/organization/right'" style="padding:10px" >
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
<script type="text/javascript" src="${basePath}/static/js/persys/organization.js"></script>
</body>
</html>