<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>

<%	//セッションスコープからユーザー情報を取得
	User loginUser = (User) session.getAttribute("loginUser");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン結果</title>
</head>
<body>
	<h1>ログイン結果</h1>
	<% if(loginUser != null) {%>
	<p>ログインに成功しました　おめでとう！</p>
	<p>ようこそ<%= loginUser.getName() %>さん</p>
	<p>つぶやきの世界へ！</p>
	<a href="/tsubuyaki/Main">つぶやき投稿・閲覧へ</a>
	<% }else{%>
	<p>ログインに失敗しました</p>
	<a href="/tsubuyaki/index.jsp">ログイン画面へ</a>
	<% } %>
	

</body>
</html>