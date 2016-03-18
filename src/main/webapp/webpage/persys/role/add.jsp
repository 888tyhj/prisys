<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/static/context/mytags.jsp"%>
<form action="#" method="post" id="form12">
             <table class="table_jjval" style="width:99%;">
					<input type="hidden"  name="id" id="id"/>
					<input type="hidden"  name="available" id="available" value="true"/>
					<input type="hidden"  name="resourceIds" id="resourceIds" />
				    <tr height="45">
				    	<td style="width:20%;" class="td_left">名称：</td>
				    	<td style="width:30%;">
				    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
				    		data-options="required:true" missingMessage="请输入名称" 
				    		type="text"  id="name" name="name"  
				    		onkeypress="return noNumbers(event)"  maxlength="100" >
				    	</td>
				    </tr>
				    <tr height="45">
				    	<td style="width:20%;" class="td_left">标识：</td>
				    	<td style="width:30%;">
				    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
				    		data-options="required:true" missingMessage="请输入标识" 
				    		type="text"  id="role" name="role"  
				    		onkeypress="return noNumbers(event)"  maxlength="100" >
				    	</td>
				    </tr>
				    <tr height="45">
				    	<td style="width:20%;" class="td_left">角色描述：</td>
				    	<td style="width:30%;">
				    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
				    		type="text"  id="description" name="description"  
				    		onkeypress="return noNumbers(event)"  maxlength="100" >
				    	</td>
				    </tr>
		   </table>
</form>
