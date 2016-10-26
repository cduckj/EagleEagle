<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>

<link href="../css/style.css" type="text/css" rel="stylesheet" />
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
</head>
<body id="joinBody">

	<div id="header">
		<header> </header>
	</div>
	<div>
		<h1>회원가입 페이지</h1>
		<form action="member-join" method="post">
			<fieldset>
				<legend>회원가입 입력 필드</legend>
				<div class = "joinForm">
					<table border="1" id="joinTable">
						<tbody>
							<tr>
								
								<td colspan="3"><input name="id" type="text" placeholder="이메일 주소"
									value="${m.id}" /></td>
							</tr>
							<tr>
								
								<td colspan="3"><input name="pwd" type="password" placeholder="비밀번호"
									value="${m.pwd}" /></td>
							</tr>
							<tr>
								
								<td colspan="3"><input name="nickName" type="text" placeholder="닉네임"
									value="${m.nickName}" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div>
					<input type="hidden" name="isAdmin" value="${m.isAdmin}" /> <input
						type="hidden" name="regDate" value="${m.regDate}" /> 
						<div id="joinButtonBox">
						<input
						id="joinButton" type="submit" value=""/>
						</div>
					<%-- <a href="notice-detail?code=${n.code}">취소</a> --%>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>