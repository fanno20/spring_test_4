<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>${member.id}</p>
<c:if test="${member != null}">
	<a href="/test4/member/logout.me">LOGOUT</a>
</c:if>
<c:if test="${member == null}">
	<a href="/test4/member/loginF.me">LOGIN</a><br>
	<a href="/test4/member/joinF.me">회원가입</a><br>
</c:if>
</body>
</html>
