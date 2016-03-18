/**
 * 显示左面导航
 */
showLeftStyle("resource");

var dialogWidth=800;
var dialogHeight=485;

var saveurl="";

/**
 * 表格
 */
$('#dg').treegrid( {
	width: clientWidth-200,  
	height: clientHeight-180,
	rownumbers : true,
	singleSelect : true,
	pagination : false,
//	pageSize : 20,
	fitColumns: true,
	idField: 'id',
	treeField: 'name',
	onContextMenu: onContextMenu,
	url : basePath+'/resource/listPage'
});
//主列表查询
function searchuser() {
	var username=$('#tb #name').val();
	var v=" ";
	if(username!=""){
		v+=" and name like '%"+username.trim()+"%' ";
	}
	$("#dg").treegrid("options").queryParams["param"] =v;
	$("#dg").treegrid("reload");
}
function  formattype(value, row){
	if(value=="menu"){
		return ' <button  class="btn btn-mini btn-primary"><i class="icon-menu icon-white"></i>菜单</button>';
	}else if(value=="button"){
		return ' <button  class="btn btn-mini btn-success"><i class="icon-button icon-white"></i>按钮</button>';
	}
}
//新增
function addtn(id){
	saveurl=basePath+'/resource/create';
    $('#dd').dialog({
       iconCls:'icon-plus',
	    title: '添加子节点',
	    width: dialogWidth,
	    height: dialogHeight,
	    closed: false,
	    cache: false,
	    resizable:true,
	    href: basePath+'/resource/'+id+'/addpage',
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
function bianji(id) {
	saveurl=basePath+'/resource/'+id+'/update';
	$('#dd').dialog({
	       iconCls:'icon-pencil',
		    title: '修改菜单信息',
		    width: dialogWidth,
		    height: dialogHeight,
		    closed: false,
		    cache: false,
		    resizable:true,
		    href: basePath+'/resource/'+id+'/editpage',
		    modal: true,
            onLoad:function(){
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
				 		$('#dg').treegrid('reload');
						$('#dd').dialog('close');
				}  else if (data=='1') {
					    $.messager.alert('提示信息','您输入的子名称已存在，请重新输入！','error');
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
function deleteRecord(id){
    $.messager.confirm('删除记录', '确认删除吗?<font color="red">将会同时删除子节点数据</font>', function(r){
   	 if (r){
   		 showProcess(true, '温馨提示', '正在提交数据...');
   		 $.post(basePath+'/resource/'+id+'/delete',null,function(json){
   			     showProcess(false);
				 if(json=="删除成功"){
		              $.messager.alert('提示信息','删除成功!','info',function () {
		                $('#dg').treegrid('reload');
                     });
				 }else{
					 $.messager.alert('提示信息','删除失败!','error');
				 }
			});
   	  }
    });
}
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
