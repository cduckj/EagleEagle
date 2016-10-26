<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eagle</title>
</head>
<body>
	<h1>등록 페이지</h1>
	<form action="notice-reg" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>제목</td>
				<td colspan="3"><input type="text" name="title"
					value="${n.title}" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3"><input type="file" name="file"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="content" rows="20" cols="60">${n.content}</textarea>
				</td>
			</tr>

		</table>
		<div>
			<input type="submit" value="등록" /> <a href="notice">취소</a>
		</div>
	</form>

</body>
</html>