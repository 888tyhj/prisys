<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="yewudata4" style="min-height:350px;">
	<table  id="yewudata4_dg" style=" min-height:500px;margin: 0 auto">
															<thead>
																<tr>
																	<th data-options="field:'3',width:50">
																		数据类型
																	</th>
																	<th data-options="field:'4',width:50">
																		数据名称
																	</th>
																	<th data-options="field:'0',width:80">
																		提交单位
																	</th>
																	<th data-options="field:'6',width:80">
																		提交时间
																	</th>
																</tr>
															</thead>
														</table>
</div>
<script>
$('#yewudata4_dg').datagrid( {
	rownumbers : true,
	singleSelect : true,
	fitColumns: true,
	url : basePath+'/webpage/datacenter/ywdata/table.json',
	queryParams:{
    	message: "防汛检查"
	}
});
function changeYewudata4(){
	$('#yewudata4_dg').datagrid('load',{
        message: $("#yewudata4_select").val()
	});  
}
</script>