<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String bathPath = request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
			<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="<%=bathPath %>"><%=session.getAttribute("username")%></a>
			<!-- <input class="form-control form-control-dark w-100" type="text" placeholder="搜索学生" aria-label="Search"> -->
			<ul class="navbar-nav px-3">
				<li class="nav-item text-nowrap">
					<a class="nav-link" href="<%=bathPath %>/logout">注销登录</a>
				</li>
			</ul>
	</nav>


</body>
</html>