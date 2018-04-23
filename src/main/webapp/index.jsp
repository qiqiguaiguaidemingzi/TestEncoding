<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring4 MVC</title>
</head>
<body>
 ${msg},<br /> 用户名：${username},密码：${passwd }

<form action="test/postData" method="post">
	<input type="text" name="username">
	<input type="submit" value="提交">
</form>
</body>
</html>