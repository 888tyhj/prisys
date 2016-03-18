<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>登录</title>
   <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/login/cloud.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
		    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
			$(window).resize(function(){  
		        $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		    }); 
	   });  
	</script>
    <style>
    .error{color:red;}
         *{font-size:9pt;border:0;margin:0;padding:0;}
		body{font-family:'微软雅黑'; margin:0 auto;min-width:980px;}
		ul{display:block;margin:0;padding:0;list-style:none;}
		li{display:block;margin:0;padding:0;list-style: none;}
		img{border:0;}
		dl,dt,dd,span{margin:0;padding:0;display:block;}
		a,a:focus{text-decoration:none;color:#000;outline:none;blr:expression(this.onFocus=this.blur());}
		a:hover{color:#00a4ac;text-decoration:none;}
		table{border-collapse:collapse;border-spacing: 0;}
		cite{font-style:normal;}
		h2{font-weight:normal;}
        /*cloud*/
		#mainBody {width:100%;height:100%;position:absolute;z-index:-1;}
		.cloud {position:absolute;top:0px;left:0px;width:100%;height:100%;background:url('<%=basePath%>static/login/img/cloud.png') no-repeat;z-index:1;opacity:0.5;}
		#cloud2 {z-index:2;}
        /*login*/
		.logintop{height:47px; position:absolute; top:0; background:url('<%=basePath%>static/login/img/loginbg1.png') repeat-x;z-index:100; width:100%;}
		.logintop span{color:#fff; line-height:47px; background:url('<%=basePath%>static/login/img/loginsj.png') no-repeat 21px 18px; text-indent:44px; color:#afc5d2; float:left;}
		.logintop ul{float:right; padding-right:30px;}
		.logintop ul li{float:left; margin-left:20px; line-height:47px;}
		.logintop ul li a{color:#afc5d2;}
		.logintop ul li a:hover{color:#fff;}
		.loginbody{background:url('<%=basePath%>static/login/img/loginbg3.png') no-repeat center center; width:100%; height:585px; overflow:hidden; position:absolute; top:47px;}
		.systemlogo{background:url('<%=basePath%>static/login/img/loginlogo1.png') no-repeat center;width:100%; height:71px; margin-top:75px;}
		.loginbox{width:692px; height:336px; background:url('<%=basePath%>static/login/img/logininfo.png') no-repeat; margin-top:30px;}
		.loginbox ul{margin-top:88px; margin-left:285px;}
		.loginbox ul li{margin-bottom:25px;}
		.loginbox ul li label{color:#687f92; padding-left:25px;}
		.loginbox ul li label a{color:#687f92;}
		.loginbox ul li label a:hover{color:#3d96c9;}
		.loginbox ul li label input{margin-right:5px;}
		.loginuser{width:299px; height:48px; background:url('<%=basePath%>static/login/img/loginuser.png') no-repeat; border:none; line-height:48px; padding-left:44px; font-size:14px; font-weight:bold;}
		.loginpwd{width:299px; height:48px; background:url('<%=basePath%>static/login/img/loginpassword.png') no-repeat; border:none;line-height:48px; padding-left:44px; font-size:14px; color:#90a2bc;}
		.loginbtn{width:111px;height:35px; background:url('<%=basePath%>static/login/img/buttonbg.png') repeat-x; font-size:14px; font-weight:bold; color:#fff;cursor:pointer; line-height:35px;}
		.loginbm{height:50px; line-height:50px; text-align:center; background:url('<%=basePath%>static/login/img/loginbg2.png') repeat-x;position:absolute; bottom:0; width:100%; color:#0b3a58;}
		.loginbm a{font-weight:bold;color:#0b3a58;}
		.loginbm a:hover{color:#fff;}
    </style>
</head>
<body style="background-color:#1c77ac; background-image:url(${pageContext.request.contextPath}/static/login/img/light.png); 
      background-repeat:no-repeat; background-position:center top; overflow:hidden;">
<div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span></span>    
    <ul>
    <li><a href="javascript:void(0);"></a></li>
    <li><a href="javascript:void(0);"></a></li>
    <li><a href="javascript:void(0);"></a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    <form action="" method="post">
    <ul>
    <%-- <shiro:principal/> --%>
    <li><input name="username" value="admin" type="text" class="loginuser" 
          onclick="JavaScript:this.value=''"/></li>
    <li><input name="password" type="password" class="loginpwd" value="123456" onclick="JavaScript:this.value=''"/></li>
    <li><input  type="submit" class="loginbtn" value="登录"   /><label>
    <input name="rememberMe" type="checkbox" />自动登录</label><label></label></li>
    </ul>
    </form>
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有  2015  <a href="javascript:void(0);">yangl</a></div>

<%-- <div class="error">${error}
<c:if test="${not empty param.kickout}">您被踢出登录。</c:if>
</div>
<form action="" method="post">
    用户名：<input type="text" name="username" value="<shiro:principal/>"><br/>
    密码：<input type="password" name="password"><br/>
    自动登录：<input type="checkbox" name="rememberMe" value="true"><br/>
    <input type="submit" value="登录">
</form> --%>

</body>
</html>