<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ include file="/static/context/mytags.jsp"%>
<div class="sidebar-scroll" >
          <div id="sidebar" class="nav-collapse collapse">
              <!-- BEGIN SIDEBAR MENU -->
              <ul class="sidebar-menu">
                  <c:forEach items="${menus}" var="m">
						 <li class="sub-menu">
		                      <a href="javascript:;" class="">
		                          <i class="icon-th"></i>
		                          <span>${m.text}</span>
		                          <span class="arrow"></span>
		                      </a>
		                      <ul class="sub">
		                         <c:forEach items="${m.children}" var="chi">
										<li id="${chi.attributes.url}"><a class="" href="${basePath}/${chi.attributes.url}"
										      >${chi.text}</a></li>
								 </c:forEach>
		                      </ul>
	                     </li>
				  </c:forEach>
                  <%-- <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon-th"></i>
                          <span>系统管理</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
						  <li id="organization"><a class="" href="${basePath}/organization">组织机构管理</a></li>
                          <li id="user"><a class="" href="${basePath}/user">用户管理</a></li>
                          <li id="role"><a class="" href="${basePath}/role">角色管理</a></li>
                          <li id="resource"><a class="" href="${basePath}/resource">菜单管理</a></li>
                      </ul>
                  </li> --%>
              </ul>
              <!-- END SIDEBAR MENU -->
          </div>
</div>