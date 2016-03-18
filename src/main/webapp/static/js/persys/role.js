/**
 * 显示左面导航
 */
showLeftStyle("role");

var dialogWidth=580;
var dialogHeight=420;

var saveurl="";

/**
 * 表格
 */
$('#dg').datagrid( {
	width: clientWidth-200,  
	height: clientHeight-180,
	rownumbers : true,
	singleSelect : true,
	pagination : true,
	pageSize : 20,
	fitColumns: true,
	//onClickRow : addPanel,
	url : basePath+'/role/listPage'
});
//主列表查询
function searchuser() {
	var username=$('#tb #name').val();
	var v="";
	if(username!=""){
		v+=" and name like '%"+username.trim()+"%' ";
	}
	$("#dg").datagrid("options").queryParams["param"] =v;
	$("#dg").datagrid("reload");
}

//新增
function addtn(){
	saveurl=basePath+'/role/create';
    $('#dd').dialog({
       iconCls:'icon-plus',
	    title: '新增角色',
	    width: dialogWidth,
	    height: dialogHeight,
	    closed: false,
	    cache: false,
	    resizable:true,
	    href: basePath+'/role/addpage',
	    modal: true,
	    onLoad:function(){
		}
	});
	//$('#dd').dialog('refresh', 'addpwk.jsp');
}
function savedd(){
	save(saveurl);
}

//编辑
function bianji(index) {
	var rows = $('#dg').datagrid('getRows');
    var row = rows[index];
	saveurl=basePath+'/role/'+row.id+'/update';
	$('#dd').dialog({
	       iconCls:'icon-pencil',
		    title: '修改角色',
		    width: dialogWidth,
		    height: dialogHeight,
		    closed: false,
		    cache: false,
		    resizable:true,
		    href: basePath+'/role/addpage',
		    modal: true,
            onLoad:function(){
		    	$('#form12').form('load', row);
		    }
		});
		//$('#dd').dialog('refresh', 'addpwk.jsp');
}

function save(url) {
		$('#form12').form('submit', {
			url : url,
			onSubmit : function() {
				//进行表单验证
				//如果返回false阻止提交
				var flag = $(this).form('validate');
				if (flag) {
					showProcess(true, '温馨提示', '正在提交数据...');
				}
				return flag
			},
			success : function(data) {
				showProcess(false);
				if (data=='录入成功'||data=='修改成功') {
						$.messager.alert('提示信息','提交成功！','info');
				 		$('#dg').datagrid('reload');
						$('#dd').dialog('close');
				}  else if (data=='1') {
					    $.messager.alert('提示信息','您输入的名称已存在，请重新输入！','error');
				}  else if (data=='2') {
					    $.messager.alert('提示信息','您输入的标识已存在，请重新输入！','error');
				}  else{
						$.messager.alert('提示信息','提交失败！','error');
					}
				},
				error:function (data){
					alert(data);
				}
		});
}
//删除
function deleteRecord(index){
	var rows = $('#dg').datagrid('getRows');
    var row = rows[index];
    $.messager.confirm('删除记录', '确认删除吗?', function(r){
   	 if (r){
   		 showProcess(true, '温馨提示', '正在提交数据...');
   		 $.post(basePath+'/role/'+row.id+'/delete',null,function(json){
   			     showProcess(false);
				 if(json=="删除成功"){
		              $.messager.alert('提示信息','删除成功!','info',function () {
		                $('#dg').datagrid('reload');
                     });
				 }else{
					 $.messager.alert('提示信息','删除失败!','error');
				 }
			});
   	  }
    });
}
/**
 * 分配资源
 * @param index
 */
function addPanel(index){
	
    var rows = $('#dg').datagrid('getRows');
    var row = rows[index];
   
    var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
   //取消所有被选中的
    treeObj.checkAllNodes(false);
    
//    var nodes = $('#tree_id').tree('getChecked');
//    for(var i=0; i<nodes.length; i++){
//    	$('#tree_id').tree('uncheck', nodes[i].target);
//    }

//    for (var i = 0; i < arr.length; i++) {
//    	var node = $('#tree_id').tree('find', arr[i].trim());
//    	$('#tree_id').tree('check', node.target);
//	}
    
    $('#layout-id').layout('panel', 'east').panel({ title: '【'+row.name+'】拥有的资源' });
    showProcess(true, '温馨提示', '正在处理数据...');
	$.post(basePath+'/roleres/listPage',{roleId:row.id},function(json){
		 showProcess(false);
		 $.each(json, function(i,n){
//			    var node = $('#tree_id').tree('find', n.resID);
//		    	$('#tree_id').tree('check', node.target);
			    var nodes = treeObj.getNodesByParam("id",n.resID, null);
				treeObj.checkNode(nodes[0], true);
		 })
	});
}

/**操作树**/
$("#tree_div").height(clientHeight-290);
function clicktree() {
	//var node = $('#tree_id').tree('getSelected');
	//$("#show_word_id").attr('src',basePath+'/organization/'+node.attributes.id+'/maintain');
}
function collapse() {
	var node = $('#tree_id').tree('getSelected');
	$('#tree_id').tree('collapse', node.target);
}
function expand() {
	var node = $('#tree_id').tree('getSelected');
	$('#tree_id').tree('expand', node.target);
}
function reloadTree(){
	$('#tree_id').tree('reload');
}
/**保存tree**/
function  savetree(){
	var row = $('#dg').datagrid('getSelected');
	if(row==null){
		alert("请先指定角色！");
		return;
	}
//	var nodes = $('#tree_id').tree('getChecked');
	var ids="";
//	for(var i=0; i<nodes.length; i++){
//		var node=nodes[i];
//		var id=node.id;
//		if(id){
//			if(ids==""){
//				ids=node.id;
//			}else{
//				ids+=","+node.id;
//			}
//		}
//    }
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	//取消全部勾选
	//treeObj.checkAllNodes(false);
	//获取所有选中（checkbox）的节点
	var nodes = treeObj.getCheckedNodes(true);
	$.each(nodes, function(i,n){
		var node=n;
		var id=node.id;
		if(id){
			if(ids==""){
				ids=node.id;
			}else{
				ids+=","+node.id;
			}
		}
	});
	showProcess(true, '温馨提示', '正在提交数据...');
	$.post(basePath+'/roleres/create',{resIds:ids, roleId:row.id},function(json){
		 showProcess(false);
		 if(json=="录入成功"){
             $.messager.alert('提示信息','保存成功!','info',function () {
	                $('#dg').datagrid('reload');
	                //取消所有被选中的
	                treeObj.checkAllNodes(false);
             });
		 }else{
			 $.messager.alert('提示信息','保存失败!','error');
		 }
	});
}

