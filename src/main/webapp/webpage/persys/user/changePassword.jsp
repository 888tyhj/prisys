<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/static/context/mytags.jsp"%>
<form action="#" method="post" id="form12">
	<table class="table_jjval" style="width:99%;">
	   <tr height="45">
	 	<td style="width:20%;" class="td_left">新密码：</td>
	 	<td style="width:30%;">
	 		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
	 		data-options="required:true" missingMessage="请输入密码" 
	 		type="password"  id="newPassword" name="newPassword"  
	 		onkeypress="return noNumbers(event)"  maxlength="100" >
	    	</td>
	    </tr>
	</table>
</form>