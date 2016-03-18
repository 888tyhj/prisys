<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/static/context/mytags.jsp"%>
                	<form action="#" method="post" id="form12">
						    <table class="table_jjval" style="width:99%;">
											<input type="hidden"  name="id" id="id"/>
											<input type="hidden"  name="state" id="state" value="2"/>
											<input type="hidden"  name="createtime" id="createtime"/>
										    <tr height="45">
										    	<td style="width:20%;" class="td_left">任务名称：</td>
										    	<td style="width:30%;">
										    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
										    		data-options="required:true" missingMessage="请输入任务名称" 
										    		type="text"  id="name" name="name"  
										    		onkeypress="return noNumbers(event)"  maxlength="100" >
										    	</td>
										    </tr>
										    <tr height="45">
										    	<td style="width:20%;" class="td_left">bean名称：</td>
										    	<td style="width:30%;">
										    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
										    		data-options="required:true" missingMessage="请输入bean名称"
										    		type="text"  id="beanName" name="beanName"  
										    		onkeypress="return noNumbers(event)"  maxlength="100" >
										    	</td>
										    </tr>
										    <tr height="45">
										    	<td style="width:20%;" class="td_left">方法名称：</td>
										    	<td style="width:30%;">
										    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
										    		data-options="required:true" missingMessage="请输入方法名称"
										    		type="text"  id="methodName" name="methodName"  
										    		onkeypress="return noNumbers(event)"  maxlength="100" >
										    	</td>
										    </tr>
										    <tr height="45">
										    	<td style="width:20%;" class="td_left">调度表达式：</td>
										    	<td style="width:30%;">
										    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
										    		data-options="required:true" missingMessage="请输入调度表达式"
										    		type="text"  id="expression" name="expression"  
										    		onkeypress="return noNumbers(event)"  maxlength="100" >
										    	</td>
										    </tr>
										    <tr height="45">
										    	<td style="width:20%;" class="td_left">开始时间：</td>
										    	<td style="width:30%;">
										    		<input style="margin-left:5px;width:150px;"   
										    		type="text"  id="starttime" name="starttime"  
										    		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate"  maxlength="100" >
										    	</td>
										    </tr>
										    <tr height="45">
										    	<td style="width:20%;" class="td_left">结束时间：</td>
										    	<td style="width:30%;">
										    		<input style="margin-left:5px;width:150px"  
										    		type="text"  id="endtime" name="endtime"  
										    		onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate"  maxlength="100" >
										    	</td>
										    </tr>
										    <tr height="45">
										    	<td style="width:20%;" class="td_left">备注：</td>
										    	<td style="width:30%;">
										    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
										    		type="text"  id="remark" name="remark"  
										    		onkeypress="return noNumbers(event)"  maxlength="100" >
										    	</td>
										    </tr>
										</table>
						</form>
						<script>
						    
						</script>
