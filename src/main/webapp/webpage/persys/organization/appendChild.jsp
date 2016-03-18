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
					<input type="hidden"  name="id" id="id" value="${child.id}"/>
					<input type="hidden"  name="available" id="available" value="${child.available}"/>
					<input type="hidden"  name="_parentId" id="_parentId" value="${child._parentId }"/>
					<input type="hidden"  name="parentIds" id="parentIds" value="${child.parentIds}"/>
					<tr height="45">
				    	<td style="width:10%;" class="td_left">父节点名称：</td>
				    	<td style="width:30%;">
				    		&nbsp;${parent.name}
				    	</td>
				    </tr>
				    <tr height="45">
				    	<td style="width:20%;" class="td_left">子节点名称：</td>
				    	<td style="width:80%;">
				    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
				    		data-options="required:true" missingMessage="请输入子节点名称" 
				    		type="text"  id="name" name="name"  value="${child.name}"
				    		onkeypress="return noNumbers(event)"  maxlength="100" >
				    	</td>
				    </tr>
				    <tr height="45">
				    	<td style="width:20%;" class="td_left">机构代码：</td>
				    	<td style="width:80%;">
				    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
				    		data-options="required:true" missingMessage="请输入机构代码"
				    		type="text"  id="code" name="code"  value="${child.code}"
				    		onkeypress="return noNumbers(event)"  maxlength="100" >
				    	</td>
				    </tr>
		   </table>
		   <div style="margin-top:10px;width:100%;">
	             <button id="addBtn" class="btn btn-warning"><i class="icon-plus icon-white"></i> 新增子节点</button>
	       </div>
</form>
<%@ include file="/static/context/myjs.jsp"%>
<script>
        $(function() {
            $("#addBtn").click(function() {
            	save("${basePath}/organization/${parent.id}/appendChild");
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
    				}  else if (data=='1') {
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
      function redirectUrl(){
    	  window.location.href="${basePath}/organization/listRight";
      }
    </script>
</body>
</html>