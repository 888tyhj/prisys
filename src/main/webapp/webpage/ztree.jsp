<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/static/context/mytags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><%=title%></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%@ include file="/static/context/mycss.jsp"%>
	    
</head>
<body style="background-color: white;">
<ul id="treeDemo" class="ztree"></ul>
<button onclick="clickt()">点击</button>
<%@ include file="/static/context/myjs.jsp"%>
<SCRIPT type="text/javascript">
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
			{ id:1, pId:0, name:"展开、折叠 自定义图标不同", open:true, iconSkin:"pIcon01"},
			{ id:11, pId:1, name:"叶子节点1", iconSkin:"icon01"},
			{ id:12, pId:1, name:"叶子节点2", iconSkin:"icon02"},
			{ id:13, pId:1, name:"叶子节点3", iconSkin:"icon03"},
			{ id:2, pId:0, name:"展开、折叠 自定义图标相同", open:true, iconSkin:"pIcon02"},
			{ id:21, pId:2, name:"叶子节点1", iconSkin:"icon04"},
			{ id:22, pId:2, name:"叶子节点2", iconSkin:"icon05"},
			{ id:23, pId:2, name:"叶子节点3", iconSkin:"icon06"},
			{ id:3, pId:0, name:"不使用自定义图标", open:true },
			{ id:31, pId:3, name:"叶子节点1"},
			{ id:32, pId:3, name:"叶子节点2"},
			{ id:33, pId:3, name:"叶子节点3"}
		];
		

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		
		function zTreeOnCheck(event, treeId, treeNode) {
		    alert(treeNode.tId + ", " + treeNode.name + "," + treeNode.checked);
		};
		function clickt(){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			//取消全部勾选
			//treeObj.checkAllNodes(false);
			//获取所有选中（checkbox）的节点
			/*var nodes = treeObj.getCheckedNodes(true);
			$.each(nodes, function(i,n){
			    alert(n.id+", "+n.name+", "+n.tId);
			});*/
			
			//var node = treeObj.getNodeByTId("treeDemo_12");
			var node = treeObj.getNodesByParam("id",12, null);
			alert(node[0].name+", "+node[0].id);
			treeObj.checkNode(node[0], true, true);
		}
	</SCRIPT>
</body>
</html>