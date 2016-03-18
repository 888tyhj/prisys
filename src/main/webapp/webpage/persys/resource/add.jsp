<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/static/context/mytags.jsp"%>
<form action="#" method="post" id="form12">
             <table class="table_jjval" style="width:99%;">
					<input type="hidden"  name="id" id="id"/>
					<input type="hidden"  name="available" id="available" value="true"/>
					<input type="hidden"  name="_parentId" id="parentId" />
					<input type="hidden"  name="parentId" id="parentId"  value="${parent.id}"/>
					<input type="hidden"  name="parentIds" id="parentIds" value="${parentIds}"/>
				    <tr height="45">
				    	<td style="width:20%;" class="td_left">父节点名称：</td>
				    	<td style="width:30%;">
				    		<input style="margin-left:5px;width:90%;" id="parentName" 
				    		type="text"  value="${parent.name}" readonly="readonly">
				    	</td>
				    </tr>
				    <tr height="45">
				    	<td style="width:20%;" class="td_left">子名称：</td>
				    	<td style="width:30%;">
				    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
				    		data-options="required:true" missingMessage="请输入子名称" 
				    		type="text"  id="name" name="name"  
				    		onkeypress="return noNumbers(event)"  maxlength="100" >
				    	</td>
				    </tr>
				    <tr height="45">
				    	<td style="width:20%;" class="td_left">类型：</td>
				    	<td style="width:30%;">
				    		&nbsp;&nbsp;<select id="type" name="type" style="width:90%;">
							    		<c:forEach items="${types}" var="role">
							    		     <option value="${role}">${role.info}</option>
							    		 </c:forEach>
							    	</select>
				    	</td>
				    </tr>
				    <tr height="45">
				    	<td style="width:20%;" class="td_left">URL路径：</td>
				    	<td style="width:30%;">
				    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
				    		type="text"  id="url" name="url"  
				    		onkeypress="return noNumbers(event)"  maxlength="100" >
				    	</td>
				    </tr>
				    <tr height="45">
				    	<td style="width:20%;" class="td_left">权限字符串：</td>
				    	<td style="width:30%;">
				    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
				    		type="text"  id="permission" name="permission"  
				    		onkeypress="return noNumbers(event)"  maxlength="100" >
				    	</td>
				    </tr>
		   </table>
</form>
