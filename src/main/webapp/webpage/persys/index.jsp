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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
	<%@ include file="/static/context/mycss.jsp"%>
</head>
<!-- BEGIN BODY -->
<body class="fixed-top" id="fixed-top">
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
                           <span>系统管理</span>
                           <span class="divider">/</span>
                       </li>
                       <li class="active">
                                                                                   部门管理
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
					                <th data-options="field:'itemid',width:80">编号</th>
					                <th data-options="field:'productid',width:100">产品编号</th>
					                <th data-options="field:'listprice',width:80,align:'right'">市场价</th>
					                <th data-options="field:'unitcost',width:80,align:'right'">成本价</th>
					                <th data-options="field:'attr1',width:250">描述</th>
					                <th data-options="field:'status',width:60,align:'center'">状态</th>
					            </tr>
					        </thead>
					       </table>
					       <div id="tb" style="padding: 5px; height: auto;background-color: #ffffff;">
									    <div >
									          区域：
										<select style="width: 150px;" id="qy">
											  <option value="">全部</option>
										</select>
									          排污编号：
									    <input  type="text" style="width:150px;" id="pwbh"><%--
									         排污单位名称：
									    <input  type="text" style="width:150px;" id="name">
										--%><%--<a href="#" class="easyui-linkbutton" 
											onclick= "javascript: searchuser();" >查询</a>
							        	<a id="btn-edit" href="#" class="easyui-linkbutton" data-options="plain:false" 
							        	onclick="javascrpit:addtn()" style="margin-left: 15px;">新增</a>
							        	<a id="btn-edit" href="#" class="easyui-linkbutton" data-options="plain:false" 
							        	onclick="javascrpit:exportData()" style="margin-left: 15px;">导出</a>
							        	--%>
							        	<a href="javascript:void(0);" class="btn blue"><i class="icon-search"></i> 搜索</a>
							        	<a href="javascript:void(0);" class="btn btn-warning"><i class="icon-search"></i> 搜索</a>
							        	<a href="javascript:void(0);" class="btn btn-info"><i class="icon-search"></i> 查询</a>
							        	<a href="javascript:void(0);" class="btn btn-success"><i class="icon-ok"></i> 保存</a>
							        	<a href="javascript:void(0);" class="btn btn-primary"><i class="icon-pencil"></i> 编辑</a>
							        	<a href="javascript:void(0);" class="btn btn-danger"><i class="icon-trash "></i> 删除</a>
							        	<a href="javascript:void(0);" class="btn btn-warning"><i class="icon-plus icon-white"></i> 新增</a>
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
        <jsp:include page="/webpage/persys/footer.jsp"></jsp:include>
   <!-- END FOOTER -->

   <%@ include file="/static/context/myjs.jsp"%>
   <script type="text/javascript">
        /**
         * 表格
         */
        $('#dg').datagrid( {
            width: clientWidth-200,  
        	height: clientHeight-160, 
        	rownumbers : true,
        	singleSelect : true,
        	pagination : true,
        	pageSize : 20,
        	fitColumns: true,
        	url : 'table.json'
        });
   </script>
</body>
<!-- END BODY -->
</html>