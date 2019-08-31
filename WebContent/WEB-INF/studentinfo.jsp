<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>GET: /student</h1>
<form method="get" action="<%= request.getContextPath() %>/student">
	
	<input type="submit" />
</form>

<h1>POST: /student</h1>
<form method="post" action="<%= request.getContextPath() %>/student">
名字：	<input type="text" name="sname" /><br />
性别 0 1：	<input type="text" name="sex" /><br />
班级 班级id：	<input type="text" name="class" /><br />
入学日期		<input type="text" name="date" /><br />
	<input type="submit" />
</form>

<h1>PUT: /student</h1>
<form method="POST" action="<%= request.getContextPath() %>/student">

<input type="hidden" name="_method" value="put" />
学生id: <input type="text" name="sid" /><br />
名字：	<input type="text" name="sname" /><br />
性别 0 1：	<input type="text" name="sex" /><br />
班级 班级id：	<input type="text" name="class" /><br />
入学日期		<input type="text" name="date" /><br />
	<input type="submit" />
</form>

<h1>DELETE: /student</h1>
<form method="POST" action="<%= request.getContextPath() %>/student">
<input type="hidden" name="_method" value="delete" />
学生id: <input type="text" name="sid" /><br />
	<input type="submit" />
</form>
</body>
</html>