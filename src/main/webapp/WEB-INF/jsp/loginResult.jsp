<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>

<%	//セッションスコープからユーザー情報を取得
	User loginUser = (User) session.getAttribute("LoginUser");

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
	<% }else{%>
	<p>ログインに失敗しました</p>
	<% } %>
	
	<a href="/tsubuyaki/index.jsp">ログイン画面へ</a>
	
	<% session.invalidate(); %>
	
</body>
</html>