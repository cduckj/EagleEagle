<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정 페이징</title>
</head>
<body>
	수정 페이지
	<form action="qna-edit" method="post">
		<fieldset>
			<legend>딧스 이즈 수정필드</legend>
			<tbody>
				<table border="1">
					<tr>
						<td>제목</td>
						<td colspan="3"><input type="text" name="title" value="${n.title}" /></td>
					</tr>
					<tr>
						<td>작성일</td>
						<td colspan="3"><fmt:formatDate pattern="yyyy년-MM월-dd일"
								value="${n.regDate}" /></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${n.member_id}</td>
					</tr>
					<tr>
						<td colspan="4"><textarea name = "content" rows="20" cols="60">${n.content}</textarea>
						</td>
					</tr>
				</table>
			</tbody>
			<div>
				<input type="hidden" name="code" value="${n.code}"/>
				<input type="submit" value="fire!!!!!!!!!" />
				<a href="qna-detail?code=${n.code}">런a웨이</a> 
			
			</div>
		</fieldset>
	</form>
</body>
</html>