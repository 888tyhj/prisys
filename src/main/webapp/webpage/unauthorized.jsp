<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/static/context/mytags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>没有权限</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%@ include file="/static/context/mycss.jsp"%>
	<style>.error{color:red;}</style>
</head>
<body>

<div class="error">您没有权限[${exception.message}]，请联系管理员！</div>
<div class="metro gray">
     <a href="${basePath}/" class="home"><i class="icon-home"></i> </a>
</div>
</body>
</html>