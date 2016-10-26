<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="qna-reg" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>딧스 이즈 입력필드</legend>
			<tbody>
				<table border="1">
					<tr>
						<td>제목</td>
						<td colspan="3"><input type="text" name="title"
							value="${n.title}" /></td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td colspan="3"><input type="file" name="file"></td>
					</tr>
					<tr>
						<td colspan="2"><textarea name="content" rows="20" cols="60">${n.content}</textarea>
						</td>
					</tr>
				</table>
			</tbody>
			<div>
				<%-- <input type="hidden" name="code" value="${n.code}"/> --%>
				<input type="submit" value="fire!!!!!!!!!" /> <a href="qna">런a웨이</a>

			</div>
		</fieldset>
	</form>
</body>
</html>