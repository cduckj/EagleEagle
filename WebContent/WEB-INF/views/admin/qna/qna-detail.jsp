<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>와타시의 세상</title>
</head>
<body>
<table border="1">
<tr >
   <td>제목</td>
   <td colspan="3">${n.title}</td>
</tr>
<tr>
   <td>작성일</td>
   <td colspan="3">${n.regDate}</td>
</tr>
<tr>
   <td>작성자</td>
   <td>${n.member_id}</td>
</tr>
<tr>
   <td colspan="4">${n.content}</td>   
</tr>
</table>
<div>
	<a href="qna">목록</a>
	
	<a href="qna-edit?code=${n.code}">수정</a>
	
	<a href="qna-del?code=${n.code}">삭제</a>
</div>
</body>
</html>