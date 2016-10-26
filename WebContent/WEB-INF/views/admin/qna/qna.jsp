<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
.strong {
	color: red;
	text-decoration: none; /* 언더라인 없애는거 */
	font-size: 1.2em; /* 1.2배 */
}
</style>
</head>
<body>
	<h1>
		<a href="">QNA 게시판</a>
	</h1>



	<form action="qna" method="get">
		<filedset> <select name="t">
			<option value="none">분류선택</option>

			<c:if test="${param.t=='title'}">
				<option value="title" selected="selected">제목</option>
			</c:if>
			<c:if test="${param.t!='title'}">
				<option value="title">제목</option>
			</c:if>

			<c:if test="${param.t=='content'}">
				<option value="content" selected="selected">내용</option>
			</c:if>
			<c:if test="${param.t!='content'}">
				<option value="content">내용</option>
			</c:if>

			<c:if test="${param.t=='member_id'}">
				<option value="member_id" selected="selected">작성자</option>
			</c:if>
			<c:if test="${param.t!='member_id'}">
				<option value="member_id">작성자</option>
			</c:if>




		</select> <label>검색어</label> <input name="q" value="${param.q}" /> <!-- header와   request에있는 애들 뽑아올수있음.    request.getParamter("q") -->
		<input type="submit" value="검색" /> </filedset>
	</form>


	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>

			</tr>
		</thead>

		<tbody>
			<c:forEach var="n" items="${list}">
				<tr>
					<td>${n.code}</td>
					<td><a href="qna-detail?code=${n.code}">${n.title}</a></td>
					<td>${n.member_id}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${n.regDate}" />
					</td>

				</tr>
			</c:forEach>

		</tbody>
	</table>

	<c:if test="${empty param.p}">
		<c:set var="page" value="1" />
	</c:if>
	<c:if test="${not empty param.p}">
		<c:set var="page" value="${param.p}" />
	</c:if>

	<c:set var="start" value="${page-(page-1)%5}" />
	<c:set var="end"
		value="${fn:substringBefore((count%10==0?count/10:count/10+1),'.')}" />


	<div>
	${page} / ${end}pages
	</div>

	<div>
		<a href="qna-reg">글쓰기</a>
	</div>
	<div>





		<div>
			<a href="qna?p=${(start==1)?1:start-1}&t=${param.t}&q=${param.q}">이전</a>
		</div>
		<ul>
			<c:forEach var="i" begin="0" end="4">
				<c:if test="${start+i <= end}">
					<c:if test="${start+i==page}">
						<!-- empty : null가 빈문자인지 비교함 -->
						<li><a href="qna?p=${start+i}&t=${param.t}&q=${param.q}"
							Class="strong">${start+i}</a></li>
						<!-- ★항상 보여지는것은 삼박자로 이루어져야함  p,t,q가 없든 있든 같이 받아져야함. -->
					</c:if>
					<c:if test="${start+i!=page}">
						<li><a href="qna?p=${start+i}&t=${param.t}&q=${param.q}">${start+i}</a></li>
					</c:if>
				</c:if>
			</c:forEach>



		</ul>
		<div>
			<a href="qna?p=${start+5}&t=${param.t}&q=${param.q}">다음</a>
			
			<a href="main">메인으로</a>

		</div>
	</div>

</body>
</html>