<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>

	<form action="member-login" method="post">

		<fieldset>
			<legend>로그인 필드</legend>
			<table border="1">
				<tbody>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id" value="${id}"/></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pwd" value="${pwd}" /></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
		<input type="submit" value="로그인" /> <input type="reset" value="취소" />
	</form>

${m.id}

</body>
</html>