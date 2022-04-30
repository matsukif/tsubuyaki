<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<form action="/tsubuyaki/Login" method="post">
		名前:<input type="text" name="name"><br>
		PW:<input type="password"name="pass"><br>
		<input type="submit" value="login">
	</form>
</body>
</html>