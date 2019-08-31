<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>GET: /classinfo</h1>
<form method="get" action="<%= request.getContextPath() %>/classinfo">
	
	<input type="submit" />
</form>

<h1>POST: /classinfo</h1>
<form method="post" action="<%= request.getContextPath() %>/classinfo">
班级：	<input type="text" name="classname" /><br />
专业：	<input type="text" name="subject" /><br />
院系：	<input type="text" name="dept" /><br />
	<input type="submit" />
</form>

<h1>PUT: /classinfo</h1>
<form method="POST" action="<%= request.getContextPath() %>/classinfo">

<input type="hidden" name="_method" value="put" />

id:		<input type="text" name="id" /><br />
班级：	<input type="text" name="classname" /><br />
专业：	<input type="text" name="subject" /><br />
院系：	<input type="text" name="dept" /><br />
	<input type="submit" />
</form>

<h1>DELETE: /classinfo</h1>
<form method="POST" action="<%= request.getContextPath() %>/classinfo">
<input type="hidden" name="_method" value="delete" />
id: <input type="text" name="id" /><br />
	<input type="submit" />
</form>
</body>
</html>