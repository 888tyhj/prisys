<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- <div style="margin-top:10px;vertical-align: middle;height:35px;">
    <div style="float:left">文档名称：<input  type="text" style="width:180px;" id="wdmc_search"></div>
    <div style="float:left;margin-left:5px;"><a href="#" class="icon-new-search" onclick= "javascript: searchuser();"></a></div>
</div>
<div style="margin-top:10px;vertical-align: middle;height:35px;border-top:1px solid #C2E3F6;">
   <div style="float:left;margin-left:10px;"><a href="#" class="icon-new-file" onclick= "javascript: addtn();"></a></div>
   <div style="float:left;margin-left:10px;"> <a href="#" class="icon-new-word" onclick= "javascript: uploadword();"></a></div>
</div> -->
<div id="mm" class="easyui-menu" style="width: 120px;">
    <%--<div onclick="addarea()" data-options="iconCls:'icon-add'" id="add_m">新增</div>
	--%>
	<!-- <div onclick="editSztb()" data-options="iconCls:'icon-edit'">编辑</div>
	<div onclick="deleteRecord()" data-options="iconCls:'icon-cancel'">删除</div> -->
	<%--<div class="menu-sep"></div>--%>
	<div onclick="expand()" id="expand">展开</div>
	<div onclick="collapse()" id="collapse">折叠</div>
</div>
<div id="tree_div" style="margin-top:10px;background-color: white;overflow: auto;">
<ul id="tree_id" class="easyui-tree" 
data-options="
         url:basePath+'/organization/ajaxtree',
         method: 'post',
         animate: true,
         onClick:clicktree,
         onContextMenu: function(e,node){
            if(node.text!='根目录'){
              e.preventDefault();
              $(this).tree('select',node.target);
              $('#mm').menu('show',{
                  left: e.pageX,
                  top: e.pageY
              });
            }
         },
         onLoadSuccess:function(node, data){
            var node = $('tree_id').tree('find', 1);
            alert(node.target);
            $('tree_id').tree('select', node.target);
         }
 "></ul>
 </div>
 <script type="text/javascript">
    $("#tree_div").height(clientHeight-300);
	function clicktree() {
		var node = $('#tree_id').tree('getSelected');
        $("#show_word_id").attr('src',basePath+'/organization/'+node.attributes.id+'/maintain');
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
</script>