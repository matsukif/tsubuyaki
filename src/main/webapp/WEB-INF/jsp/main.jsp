<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User,model.Mutter,java.util.List,java.sql.Timestamp,java.text.SimpleDateFormat" %>
<%
//セッションスコープからユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%>
<%
//リクエストスコープからつぶやき情報を取得
List<Mutter> mutterList = (List<Mutter>) request.getAttribute("mutterList") ; 
%>
   
<%
//日時のフォーマット変更のための準備
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
%>   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやき</title>
</head>

<body>
<h1>つぶやきメイン</h1>
<p>
	<%= loginUser.getName() %>さん、ログイン中<br>
	<a href="/tsubuyaki/Logout">ログアウト</a>
</p>
<p>
	<a href="/tsubuyaki/Main">更新</a>
</p>
<form action="/tsubuyaki/Main" method="post">
	<input type="text" name="text">
	<input type="submit" value="つぶやく">
</form>
<% if(request.getAttribute("errorMsg") != null) {%>
	<p><%= request.getAttribute("errorMsg") %></p><br>
<% } %>
<% for(Mutter mutter : mutterList){ %>
	<p><%= mutter.getUserName() %>：<%= mutter.getText() %>：<%= sdf.format(mutter.getDate()) %></p>
<% } %>
</body>
</html>