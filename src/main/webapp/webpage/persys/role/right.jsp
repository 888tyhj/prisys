<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/static/context/mytags.jsp"%>
<div style="height:25px;border-bottom:1px solid #ccc;background:#F5F5F5;
					                            padding-bottom:10px;padding-top:10px;">
								         <a href="javascript:void(0);" onclick="addtn()" 
								                   class="btn btn-success" style="margin-left:10px;">
								                   <i class="icon-ok"></i> 保存</a>
								      </div>
								      <div id="mm" class="easyui-menu" style="width: 120px;">
										<div onclick="expand()" id="expand">展开</div>
										<div onclick="collapse()" id="collapse">折叠</div>
									  </div>
								      <div id="tree_div" style="margin-top:10px;background-color: white;overflow: auto;">
								         <ul id="tree_id" class="easyui-tree" 
											data-options="
											         url:basePath+'/resource/ajaxtree',
											         method: 'post',
											         animate: true,
											         checkbox:true,lines:true,
											         onClick:clicktree,
											         onContextMenu: function(e,node){
												          e.preventDefault();
												          $(this).tree('select',node.target);
												          $('#mm').menu('show',{
												              left: e.pageX,
												              top: e.pageY
												          });
												     },
											         onLoadSuccess:function(node, data){
											            var node = $('tree_id').tree('find', 1);
											            alert(node.target);
											            $('tree_id').tree('select', node.target);
											         }
											 "></ul>
</div>
<script>
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