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
	<style type="text/css">
	   .login-wrap .single-size {
				width: 180px;
	   }
	   .span12 {
	      width:100%;
	   }
	   .span12 a span{
	      font-size:14px;
	      font-weight: bold;
	   }
	</style>
</head>
<body class="lock" style="background:url('${basePath}/static/login/img/background.png')">
    <div class="lock-header">
        <!-- BEGIN LOGO -->
        <a class="center" id="logo" href="${basePath}/forwardindex?url=lsscksh/index">
            <img class="center" alt="logo" src="${basePath}/static/login/img/loginlogo.png">
        </a>
        <!-- END LOGO -->
    </div>
    <div class="login-wrap">
       <div class="span12">
	        <div class="metro single-size purple">
	            <a href="${basePath}/forwardindex?url=gis/index" class="social-link">
	               <i class="icon-skype"></i>
	                <span>地理信息系统</span>
	            </a>
	        </div>
	        <div class="metro single-size yellow">
	            <a href="${basePath}/forwardindex?url=zhjczz/index"  class="social-link">
	                <i class="icon-skype"></i>
	                <span>粮食综合决策支持系统</span>
	            </a>
	        </div>
	        <div class="metro single-size green">
	            <a href="${basePath}/forwardindex?url=lsscksh/index" class="social-link">
	                <i class="icon-skype"></i>
	                <span>粮食收储可视化管理系统</span>
	            </a>
	        </div>
	        <div class="metro single-size red">
	            <a href="${basePath}/forwardindex?url=zblycjk/index" class="social-link">
	                <i class="icon-skype"></i>
	                <span>储备粮远程监管系统</span>
	            </a>
	        </div>
	        <div class="metro single-size blue">
	            <a href="${basePath}/forwardindex?url=jgjcyfx/index" class="social-link">
	                <i class="icon-skype"></i>
	                <span>价格监测与分析系统</span>
	            </a>
	        </div>
        </div>
        <div class="span12">
	        <div class="metro single-size deep-red">
	            <a href="${basePath}/forwardindex?url=yjbzxt/index" class="social-link">
	                <i class="icon-skype"></i>
	                <span>粮食应急保障信息系统</span>
	            </a>
	        </div>
	        <div class="metro single-size navy-blue">
	            <a href="${basePath}/forwardindex?url=lsccgl/index" class="social-link">
	                <i class="icon-skype"></i>
	                <span>粮食仓储管理系统</span>
	            </a>
	        </div>
	        <div class="metro single-size terques">
	            <a href="${basePath}/forwardindex?url=ylzlaq/index" class="social-link">
	                <i class="icon-skype"></i>
	                <span>原粮质量安全追溯系统</span>
	            </a>
	        </div>
	        <div class="metro single-size yellow">
	            <a href="${basePath}/forwardindex?url=jdjc/jcxx/index" class="social-link">
	                <i class="icon-skype"></i>
	                <span>监督检查执法系统</span>
	            </a>
	        </div>
	        <div class="metro single-size purple">
	            <a href="${basePath}/forwardindex?url=datacenter/index" class="social-link">
	                <i class="icon-skype"></i>
	                <span>数据中心</span>
	            </a>
	        </div>
        </div>
        <div class="login-footer">
            <div class="remember-hint pull-left">
                <!-- <input type="checkbox" id=""> 记住密码 -->
            </div>
            <div class="forgot-hint pull-right">
                <a href="${basePath}/logout"><i class="icon-off"></i> 退出</a>
            </div>
        </div>
    </div>
</body>
</html>