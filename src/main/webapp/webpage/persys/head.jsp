<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ include file="/static/context/mytags.jsp"%>
<style>
 #header .brand{
    width:1000px;
    color:white;
    font-size:30px;
    padding-left:50px;
    font-family: "黑体";
 }
</style>
<div id="header" class="navbar navbar-inverse navbar-fixed-top">
       <!-- BEGIN TOP NAVIGATION BAR -->
       <div class="navbar-inner">
           <div class="container-fluid">
               <!--BEGIN SIDEBAR TOGGLE-->
	              <!--  <div class="sidebar-toggle-box hidden-phone">
	                   <div class="icon-reorder tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
	               </div> -->
               <!--END SIDEBAR TOGGLE-->
               <!-- BEGIN LOGO -->
               <a class="brand" href="javascript:void(0);">
                                                           通用管理平台系统
                   <%-- <img src="${basePath}/static/bootstrap/img/logo.png" alt="Metro Lab" /> --%>
               </a>
               <!-- END LOGO -->
               
               <!-- END  NOTIFICATION -->
               <div class="top-nav ">
                   <ul class="nav pull-right top-menu" >
                       <!-- BEGIN USER LOGIN DROPDOWN -->
                       <li class="dropdown">
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                               <img src="${basePath}/static/bootstrap/img/avatar-mini.png" alt="">
                               <span class="username"> 科员</span>
                               <b class="caret"></b>
                           </a>
                           <ul class="dropdown-menu extended logout">
                               <li><a href="javascript:void(0)" onclick="showLoginUserDialog()"><i class="icon-user"></i> 我的信息</a></li>
                               <li><a href="${basePath}/"><i class="icon-mail-reply"></i> 返回首页</a></li>
                               <li><a href="${basePath}/logout"><i class="icon-off"></i> 退出</a></li>
                           </ul>
                       </li>
                       <!-- END USER LOGIN DROPDOWN -->
                   </ul>
                   <!-- END TOP NAVIGATION MENU -->
               </div>
           </div>
       </div>
       <!-- END TOP NAVIGATION BAR -->
 </div>
 
 <div id="showLoginUserDialog" class="easyui-dialog" data-options="buttons: '#showLoginUserDialog #dlg-buttons',closed:true">
		<div id="dlg-buttons">
			<button class="btn btn-danger" onclick= "javascript: $('#showLoginUserDialog').dialog('close');"><i class="icon-remove"></i>关闭</button>
		</div>
 </div>
