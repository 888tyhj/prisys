/**
 * 显示左面导航
 */
showLeftStyle("sysjob");

var dialogWidth=700;
var dialogHeight=485;

var saveurl="";

/**
 * 表格
 */
$('#dg').datagrid( {
	width: clientWidth-200,  
	height: clientHeight-180,
	rownumbers : true,
	singleSelect : true,
	pagination : false,
	//pageSize : 20,
	fitColumns: true,
	url : basePath+'/sysjob/listPage'
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
	saveurl=basePath+'/sysjob/create';
    $('#dd').dialog({
       iconCls:'icon-user',
	    title: '录入',
	    width: dialogWidth,
	    height: dialogHeight,
	    closed: false,
	    cache: false,
	    resizable:true,
	    href: basePath+'/sysjob/addpage',
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
function bianji() {
	var row = $('#dg').datagrid('getSelected');
	if(row==null){
		$.messager.alert('提示信息','请选择一条记录!','info');
		return;
	}
	saveurl=basePath+'/sysjob/update';
	$('#dd').dialog({
	       iconCls:'icon-user',
		    title: '编辑',
		    width: dialogWidth,
		    height: dialogHeight,
		    closed: false,
		    cache: false,
		    resizable:true,
		    href: basePath+'/sysjob/addpage',
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
					    $.messager.alert('提示信息','您输入的bean不存在，请重新输入！','error');
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
function deleteRecord(){
	var row = $('#dg').datagrid('getSelected');
	if(row==null){
		$.messager.alert('提示信息','请选择一条记录!','info');
		return;
	}
    $.messager.confirm('删除记录', '确认删除吗?', function(r){
   	 if (r){
   		 showProcess(true, '温馨提示', '正在提交数据...');
   		 $.post(basePath+'/quartz/'+row.id+'/delete',null,function(json){
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

//启动任务
function yunxing(id){
    $.messager.confirm('温馨提示', '确认启动吗?', function(r){
   	 if (r){
   		 showProcess(true, '温馨提示', '正在提交数据...');
   		 $.post(basePath+'/quartz/'+id+'/execute',null,function(json){
   			     showProcess(false);
				 if(json=="成功加入"){
		              $.messager.alert('提示信息','启动成功!','info',function () {
		                $('#dg').datagrid('reload');
                     });
				 }else{
					 $.messager.alert('提示信息','启动失败!','error');
				 }
			});
   	  }
    });
}
//停止
function  tingzhi(id){
	$.messager.confirm('温馨提示', '确认停止吗?', function(r){
	   	 if (r){
	   		 showProcess(true, '温馨提示', '正在提交数据...');
	   		 $.post(basePath+'/quartz/'+id+'/stop',null,function(json){
	   			     showProcess(false);
					 if(json=="成功加入"){
			              $.messager.alert('提示信息','已成功停止!','info',function () {
			                $('#dg').datagrid('reload');
	                     });
					 }else{
						 $.messager.alert('提示信息','停止失败!','error');
					 }
				});
	   	  }
	    });
}
