<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/static/context/mytags.jsp"%>
                	<form action="#" method="post" id="form12">
						    <table class="table_jjval" style="width:99%;">
											<input type="hidden"  name="id" id="id"/>
											<input type="hidden"  name="salt" id="salt"/>
											<input type="hidden"  name="locked" id="locked"/>
											<input type="hidden"  name="isshow" id="isshow"/>
											<input type="hidden"  name="password" id="password"/>
										    <tr height="45">
										    	<td style="width:20%;" class="td_left">用户名：</td>
										    	<td style="width:30%;">
										    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
										    		data-options="required:true" missingMessage="请输入用户名" 
										    		type="text"  id="username" name="username"  
										    		onkeypress="return noNumbers(event)"  maxlength="100"  readonly="readonly">
										    	</td>
										    </tr>
										    <!-- <tr height="45">
										    	<td style="width:20%;" class="td_left">密码：</td>
										    	<td style="width:30%;">
										    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
										    		data-options="required:true" missingMessage="请输入密码" 
										    		type="password"  id="password" name="password"  
										    		onkeypress="return noNumbers(event)"  maxlength="100" >
										    	</td>
										    </tr> -->
										    <tr height="45">
										    	<td style="width:20%;" class="td_left">真实姓名：</td>
										    	<td style="width:30%;">
										    		<input style="margin-left:5px;width:90%;"  class="easyui-validatebox" 
										    		data-options="required:true" missingMessage="请输入真实姓名" 
										    		type="text"  id="realname" name="realname"  
										    		onkeypress="return noNumbers(event)"  maxlength="100" >
										    	</td>
										    </tr>
										    <tr height="45">
										    	<td style="width:20%;" class="td_left">所属组织：</td>
										    	<td style="width:30%;" colspan="3">
										    		&nbsp;&nbsp;<input style="margin-left:5px;width:250px;"  class="easyui-combotree" 
										    		 data-options="
										    		       url:basePath+'/organization/ajaxtree',
										    		       method:'post',
										    		       required:true
										    		       "
										    		  missingMessage="请选择组织"        
										    		type="text"  id="organizationId" name="organizationId"  
										    		onkeypress="return noNumbers(event)"  />
										    	</td>
										    </tr>
										    <tr height="45">
										    	<td style="width:20%;" class="td_left">所属角色：</td>
										    	<td style="width:30%;">
										    		&nbsp;&nbsp;<select id="roleIds" name="roleIds" style="width:90%;" 
										    		>
										    		 <c:forEach items="${roleList}" var="role">
										    		     <option value="${role.role}">${role.name}</option>
										    		 </c:forEach>
										    		</select>
										    	</td>
										    </tr>
										</table>
						</form>
						<script>
						    
						</script>
