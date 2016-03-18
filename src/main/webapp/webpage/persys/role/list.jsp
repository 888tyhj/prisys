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
	<style type="text/css">
	   .icon-list{
	      color: green;
	      padding-top:2px;
	      padding-left:2px;
	   }
	   .icon-list:before{
	      width:16px;
	      height:16px;
	   }
	   .icon-tags{
	      padding-top:4px;
	      padding-left:4px;
	   }
	</style>
     <script type="text/javascript">
	   //项目名称
	  var basePath='${basePath}';
	  </script>
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
                                                                                  角色管理
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
                       <div class="easyui-layout"  id="layout-id"  >
					        <div data-options="region:'center',split:true,title:'',collapsible:false" style="width:800px" >
						             <table id="dg" data-options="toolbar:'#tb'" fit="true">
									        <thead>
									            <tr>
									                <th data-options="field:'name',width:50" >角色名称</th>
									                <th data-options="field:'role',width:50" >标识</th>
									                <th data-options="field:'description',width:150,align:'left'" >角色描述</th>
									                <th data-options="field:'tools',width:100,align:'center',formatter:rowformater" >操作</th>
									            </tr>
									        </thead>
									    </table>
									    <div id="tb" style="padding: 5px; height: auto;">
										    <div >
										    <span class="input-prepend"><span class="add-on">角色名称：</span>
												<input type="text" id="name" style="width:150px;" class="m-wrap" maxlength="20" 
												          onkeypress="return noNumbers(event)">
											</span>
										          
											<a href="#" onclick= "javascript: searchuser();" class="btn btn-info"><i class="icon-search"></i> 查询</a>
									        <shiro:hasPermission name="role:create">
								               <a href="javascript:void(0);" onclick="addtn()" 
								                   class="btn btn-warning" style="margin-left:50px;">
								                   <i class="icon-plus icon-white"></i> 添加</a>
								            </shiro:hasPermission>
									    </div>
									  </div>
					        </div>
					        <div data-options="region:'east',title:'拥有的资源',split:true" style="width:300px;" >
					                  <shiro:hasPermission name="role:resource">
						                  <div style="height:25px;border-bottom:1px solid #ccc;background:#F5F5F5;
						                            padding-bottom:10px;padding-top:10px;">
										         <a href="javascript:void(0);" onclick="savetree()" 
										                   class="btn btn-success" style="margin-left:10px;">
									                   <i class="icon-ok"></i> 保存</a>
									      </div>
								      </shiro:hasPermission>
								      <div id="mm" class="easyui-menu" style="width: 120px;">
										<div onclick="expand()" id="expand">展开</div>
										<div onclick="collapse()" id="collapse">折叠</div>
									  </div>
								      <div id="tree_div" style="margin-top:10px;background-color: white;overflow: auto;">
								         <ul id="treeDemo" class="ztree"></ul>
									 </div>
					        </div>
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
	  
	  $("#layout-id").height(clientHeight-180);
	  $("#layout-id").width(clientWidth-200);
	  function  rowformater(value,row,index){
	  	    var str='';
	    <shiro:hasPermission name="role:update">
          str+='<a href="javascript:void(0);" onclick="bianji(\''+index+'\')" class="btn btn-mini btn-primary" style="margin-right:10px;"><i class="icon-pencil"></i> 修改</a>';
	    </shiro:hasPermission>
	
	    <shiro:hasPermission name="role:delete">
	       str+='<a href="javascript:void(0);" onclick="deleteRecord(\''+index+'\')" class="btn btn-mini btn-danger" style="margin-right:10px;"><i class="icon-trash "></i> 删除</a>';
	    </shiro:hasPermission>
	    
	    <shiro:hasPermission name="role:resource">
	       str+='<a href="javascript:void(0);" onclick="addPanel(\''+index+'\')" class="btn btn-mini btn-success" style="margin-right:10px;"><i class="icon-reorder "></i> 分配资源</a>';
	    </shiro:hasPermission>
	  	  
		 return str;
	    };
		
		$(function(){
			var setting = {
					check: {
						enable: true ,
						chkboxType : { "Y" : "ps", "N" : "ps" }
					},
					data: {
						simpleData: {
							enable: true
						}
					}
					/*callback: {
						onCheck: zTreeOnCheck
					}*/
			};
			var zNodes =[
			                <c:forEach items="${resourceList}" var="r">
			                     <c:choose>
			                       <c:when test="${r._parentId==0}">  
			                          { id:${r.id}, pId:${r._parentId}, name:"${r.name}", open:true, iconSkin:"pIcon01"},
			                       </c:when>
			                       <c:otherwise> 
					                       <c:if test="${r.type=='menu'}">
					                          { id:${r.id}, pId:${r._parentId}, name:"${r.name}", open:true, iconSkin:"pIcon03"},
						                   </c:if>
					                       <c:if test="${r.type=='button'}">
					                          { id:${r.id}, pId:${r._parentId}, name:"${r.name}", open:true, iconSkin:"icon07"},
						                   </c:if>
			                       </c:otherwise>
			                    </c:choose>
			                </c:forEach>
			            ];
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		
		function zTreeOnCheck(event, treeId, treeNode) {
		    alert(treeNode.tId + ", " + treeNode.name + "," + treeNode.checked);
		};
		function savetree2(){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			//取消全部勾选
			//treeObj.checkAllNodes(false);
			//获取所有选中（checkbox）的节点
			var nodes = treeObj.getCheckedNodes(true);
			$.each(nodes, function(i,n){
			    alert(n.id+", "+n.name+", "+n.tId);
			});
			
			//var node = treeObj.getNodeByTId("treeDemo_12");
			/*var node = treeObj.getNodesByParam("id",12, null);
			alert(node[0].name+", "+node[0].id);
			treeObj.checkNode(node[0], true, true);*/
		}
		
   </script>
	<script type="text/javascript"
		src="${basePath}/static/js/persys/role.js"></script>
</body>
</html>