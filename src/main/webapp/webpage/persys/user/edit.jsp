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
    <style>
        ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:200px;overflow-y:scroll;overflow-x:auto;}
    </style>

</head>
<body>

    <form:form method="post" commandName="user">
        <form:hidden path="id"/>
        <form:hidden path="salt"/>
        <form:hidden path="locked"/>

        <c:if test="${op ne '新增'}">
            <form:hidden path="password"/>
        </c:if>

        <div class="form-group">
            <form:label path="username">用户名：</form:label>
            <form:input path="username"/>
        </div>

        <c:if test="${op eq '新增'}">
            <div class="form-group">
                <form:label path="password">密码：</form:label>
                <form:password path="password"/>
            </div>
        </c:if>

        <div class="form-group">
            <form:label path="organizationId">所属组织：</form:label>
            <form:hidden path="organizationId"/>
            <input type="text" id="organizationName" name="organizationName" value="${zhangfn:organizationName(user.organizationId)}" readonly>
            <a id="menuBtn" href="#">选择</a>
        </div>


        <div class="form-group">
            <form:label path="roleIds">角色列表：</form:label>
            <form:select path="roleIds" items="${roleList}" itemLabel="description" itemValue="id" multiple="true"/>
            (按住shift键多选)
        </div>
         
        <form:button>${op}</form:button>

    </form:form>


    <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
        <ul id="tree" class="ztree" style="margin-top:0; width:160px;"></ul>
    </div>

    <script src="${basePath}/static/js/jquery-1.11.0.min.js"></script>
    <script src="${basePath}/static/JQuery zTree v3.5.15/js/jquery.ztree.all-3.5.min.js"></script>
    <script>
        $(function () {
            var setting = {
                view: {
                    dblClickExpand: false
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                callback: {
                    onClick: onClick
                }
            };

            var zNodes =[
                <c:forEach items="${organizationList}" var="o">
                    <c:if test="${not o.rootNode}">
                        { id:${o.id}, pId:${o.parentId}, name:"${o.name}"},
                    </c:if>
                </c:forEach>
            ];

            function onClick(e, treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree"),
                        nodes = zTree.getSelectedNodes(),
                        id = "",
                        name = "";
                nodes.sort(function compare(a,b){return a.id-b.id;});
                for (var i=0, l=nodes.length; i<l; i++) {
                    id += nodes[i].id + ",";
                    name += nodes[i].name + ",";
                }
                if (id.length > 0 ) id = id.substring(0, id.length-1);
                if (name.length > 0 ) name = name.substring(0, name.length-1);
                $("#organizationId").val(id);
                $("#organizationName").val(name);
                hideMenu();
            }

            function showMenu() {
                var cityObj = $("#organizationName");
                var cityOffset = $("#organizationName").offset();
                $("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

                $("body").bind("mousedown", onBodyDown);
            }
            function hideMenu() {
                $("#menuContent").fadeOut("fast");
                $("body").unbind("mousedown", onBodyDown);
            }
            function onBodyDown(event) {
                if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
                    hideMenu();
                }
            }

            $.fn.zTree.init($("#tree"), setting, zNodes);
            $("#menuBtn").click(showMenu);
        });
    </script>

</body>
</html>