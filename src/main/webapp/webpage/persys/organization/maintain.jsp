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
<body style="background-color:white;">
<form action="#" method="post" id="form12">
             <table class="table_jjval" style="width:60%;">
					<input type="hidden"  name="id" id="id" value="${organization.id}"/>
					<input type="hidden"  name="available" id="available" value="${organization.available}"/>
					<input type="hidden"  name="_parentId" id="_parentId" value="${organization._parentId }"/>
					<input type="hidden"  name="parentId" id="parentId"  value="${parentId}"/>
					<input type="hidden"  name="parentIds" id="parentIds" value="${organization.parentIds}"/>
				    <tr height="45">
				    	<td style="width:20%;" class="td_left">名称：</td>
				    	<td style="width:80%;">
				    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
				    		data-options="required:true" missingMessage="请输入名称" 
				    		type="text"  id="name" name="name"  value="${organization.name}"
				    		onkeypress="return noNumbers(event)"  maxlength="100" >
				    	</td>
				    </tr>
				    <tr height="45">
				    	<td style="width:20%;" class="td_left">机构代码：</td>
				    	<td style="width:80%;">
				    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
				    		data-options="required:true" missingMessage="请输入机构代码"
				    		type="text"  id="code" name="code"  value="${organization.code}"
				    		onkeypress="return noNumbers(event)"  maxlength="100" >
				    	</td>
				    </tr>
		   </table>
		   <div style="margin-top:10px;width:100%;">
			   <shiro:hasPermission name="organization:update">
	             <button id="updateBtn" class="btn btn-primary"><i class="icon-pencil"></i> 修改</button>
	           </shiro:hasPermission>
	
	           <shiro:hasPermission name="organization:delete">
	               <button id="deleteBtn" class="btn btn-danger"><i class="icon-trash "></i> 删除</button>
	           </shiro:hasPermission>
	
		        <shiro:hasPermission name="organization:create">
		            <button id="appendChildBtn" class="btn btn-warning"><i class="icon-plus icon-white"></i> 添加子节点</button>
		        </shiro:hasPermission>
	
	        <%-- <shiro:hasPermission name="organization:update">
	            <c:if test="${not organization.rootNode}">
	            <form:button id="moveBtn" class="btn btn-primary"><i class="icon-pencil"></i> 移动节点</form:button>
	            </c:if>
	        </shiro:hasPermission> --%>
	        </div>
</form>


    <%-- <form:form id="form" method="post" commandName="organization">
        <form:hidden path="id"/>
        <form:hidden path="available"/>
        <form:hidden path="_parentId"/>
        <form:hidden path="parentIds"/>
        <input type="hidden" name="parentId" value="${parentId}">
        
        <table class="table_jjval" style="width:50%;margin-bottom:10px;">
            <tr height="45">
		    	<td style="width:10%;" class="td_left">名称：</td>
		    	<td style="width:30%;">
		    		&nbsp;<form:input path="name" style="width:80%;" />
		    	</td>
		    </tr>
            <tr height="45">
		    	<td style="width:10%;" class="td_left">机构代码：</td>
		    	<td style="width:30%;">
		    		&nbsp;<form:input path="code" style="width:80%;" />
		    	</td>
		    </tr>
        </table>
        
        
    </form:form> --%>
    
    <%@ include file="/static/context/myjs.jsp"%>
    <script>
        $(function() {
            $("#updateBtn").click(function() {
            	save("${basePath}/organization/${organization.id}/update");
                return false;
            });
            $("#deleteBtn").click(function() {
                deleteRecord();
                return false;
            });

            $("#appendChildBtn").click(function() {
                location.href="${basePath}/organization/${organization.id}/appendChild";
                return false;
            });

            $("#moveBtn").click(function() {
                location.href="${basePath}/organization/${organization.id}/move";
                return false;
            });
        });
        
        function save(url) {
    		$('#form12').form('submit', {
    			url : url,
    			onSubmit : function() {
    				//进行表单验证
    				//如果返回false阻止提交
    				var flag = $(this).form('validate');
    				if (flag) {
    					top.showProcess(true, '温馨提示', '正在提交数据...');
    				}
    				return flag
    			},
    			success : function(data) {
    				top.showProcess(false);
    				if (data=='录入成功'||data=='修改成功') {
    						top.$.messager.alert('提示信息','提交成功！','info',function () {
      		            	  redirectUrl();
                            });
    				}   else if (data=='1') {
    					top.$.messager.alert('提示信息','您输入的名称已存在，请重新输入！','error');
    				}  else if (data=='2') {
    					top.$.messager.alert('提示信息','您输入的机构代码已存在，请重新输入！','error');
    				}  else{
    					top.$.messager.alert('提示信息','提交失败！','error');
    					}
    				},
    				error:function (data){
    					alert(data);
    				}
    		});
      }
      //删除
        function deleteRecord(){
        	top.$.messager.confirm('删除记录', '确认删除吗?<font color="red">将会同时删除子节点数据</font>', function(r){
           	 if (r){
           		top.showProcess(true, '温馨提示', '正在提交数据...');
           		 $.post('${basePath}/organization/${organization.id}/delete',null,function(json){
           			 top.showProcess(false);
        				 if(json=="删除成功"){
        					 top.$.messager.alert('提示信息','删除成功!','info',function () {
        		            	  redirectUrl();
                             });
        				 }else{
        					 top.$.messager.alert('提示信息','删除失败!','error');
        				 }
        			});
           	  }
            });
        }
      function redirectUrl(){
    	  window.location.href="${basePath}/organization/listRight";
      }
    </script>
</body>
</html>