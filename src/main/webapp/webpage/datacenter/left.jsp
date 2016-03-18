<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ include file="/static/context/mytags.jsp"%>
<div class="sidebar-scroll" >
          <div id="sidebar" class="nav-collapse collapse">
              <!-- BEGIN SIDEBAR MENU -->
              <ul class="sidebar-menu">
                  <li class="sub-menu active">
                      <a href="javascript:;" class="">
                          <i class="icon-th"></i>
                          <span>导航</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
                          <li id="shouye" ><a class="" href="${basePath}/forwardindex?url=datacenter/index">首页</a></li>
                          <li id="yhztjk" ><a class="" href="${basePath}/forwardindex?url=datacenter/userstate/index">用户状态监控</a></li>
                          <li id="yjztjk" ><a class="" href="${basePath}/forwardindex?url=datacenter/yjzt/index">硬件状态监控</a></li>
                          <li id="jcsjjk"><a class="" href="${basePath}/forwardindex?url=datacenter/jcsj/index">监测数据监控</a></li>
                          <li id="ywsjjk"><a class="" href="${basePath}/forwardindex?url=datacenter/ywdata/index">业务数据监控</a></li>
                          <li id="webfwqjk"><a class="" href="${basePath}/forwardindex?url=datacenter/webfwqdata/index">web服务器监控</a></li>
                          <li id="webcx"><a class="" href="${basePath}/forwardindex?url=datacenter/webcx/index">web程序监控</a></li>
                      </ul>
                  </li>
              </ul>
              <!-- END SIDEBAR MENU -->
          </div>
</div>