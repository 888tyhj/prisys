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
	<script type="text/javascript">
	window.parent.reloadTree();
     //项目名称
    var basePath='${basePath}';
    </script>
<!-- BEGIN BODY -->
<body style="width:100%;height:100%;background-color: white;">
<table id="dg" data-options="toolbar:'#tb'">
	<thead>
		<tr>
			<th data-options="field:'name',width:80">组织机构名称</th>
			<th	data-options="field:'code',width:80,align:'center'">组织机构代码</th>
		</tr>
	</thead>
</table>
<div id="tb" style="padding: 5px; height: auto;">
	<div>
		<a href="javascript:void(0)" class="btn btn-blue"
			onclick="collapseAll()" style="margin-left:10px;">收缩所有</a> <a
			href="javascript:void(0)" class="btn btn-blue" onclick="expandAll()">展开所有</a>

	</div>
</div>
<div id="mm" class="easyui-menu" style="width:120px;">
	<div onclick="collapse()">收缩</div>
	<div onclick="expand()">展开</div>
</div>
<%@ include file="/static/context/myjs.jsp"%>
<script type="text/javascript">
$('#dg').treegrid( {
	width: clientWidth-10,  
	height: clientHeight-10,
	rownumbers : true,
	singleSelect : true,
	pagination : false,
	fitColumns: true,
	idField: 'id',
	treeField: 'name',
	onContextMenu: onContextMenu,
	url : basePath+'/organization/listPage'
});
function collapseAll(){
    $('#dg').treegrid('collapseAll');
}
function expandAll(){
   $('#dg').treegrid('expandAll');
}
function collapse(){
	var node = $('#dg').treegrid('getSelected');
	if (node){
	$('#dg').treegrid('collapse', node.id);
	}
}
function expand(){
	var node = $('#dg').treegrid('getSelected');
	if (node){
	$('#dg').treegrid('expand', node.id);
	}
}

function onContextMenu(e,row){
	       e.preventDefault();
	       $(this).treegrid('select', row.id);
	       $('#mm').menu('show',{
	           left: e.pageX,
	           top: e.pageY
	       });
}
</script>
</body>