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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
	<%@ include file="/static/context/mycss.jsp"%>
</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
    <div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">北部区域</div>
    <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">南部区域</div>
    <div data-options="region:'west',split:true,title:'导航菜单'" style="width:200px;padding:10px;">
         
    </div>
    <div data-options="region:'center',title:''" id="mainPanel">
          <div class="easyui-tabs" style="" fit="true">
	        <div title="关于" style="padding:10px">
	            <p style="font-size:14px">jQuery EasyUI框架能够让你轻松构建Web页面.</p>
	            <ul>
	                <li>easyui是一套基于JQuery的用户界面插件集合.</li>
	                <li>easyui为构建现代流行的交互式体验JavaScript应用程序提供了基本功能.</li>
	                <li>使用easyui你不需要写很多javascript代码，你通常只需要写一些html标签来定义用户界面.</li>
	                <li>完美支持HTML5.</li>
	                <li>easyui能够有效地节省你的开发时间.</li>
	                <li>easyui很简单但是很强大.</li>
	            </ul>
	        </div>
	        <div title="帮助" data-options="closable:true" style="padding:10px">
	                                   这是帮助内容.
	        </div>
            </div>
    </div>
    <%@ include file="/static/context/myjs.jsp"%>
    <script type="text/javascript">
            var index = 0;
            function addPanel(){
                index++;
                $('#mainPanel').tabs('add',{
                    title: '选项卡'+index,
                    content: '<div style="padding:10px">内容'+index+'</div>',
                    closable: true
                });
            }

    </script>
</body>
</html>