<%@page import="web.model.ReviewModel"%>
<%@page import="web.dao.mybatis.MyBatisReviewDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/reset.css" type="text/css" rel="stylesheet" />
<link href="css/review.css" type="text/css" rel="stylesheet" />
<title>리뷰왕</title>

</head>
<body>
	<header id="header">
	<div class="content-container">
		과제문서작업 <a href="">뒤로가기/닫기</a>
	</div>

	</header>
	<!--  "여기에 되돌아갈 파일링크하시면됩니다" -->
	<div id="body">

		<div class="img">이미지자리</div>
		<div class="admin">
			사용자정보자리<br /> 사용법<br /> 1 들어감<br /> 2 클릭<br /> 3 잘쓰면됨<br />
			리뷰왕리뷰<br /> -select 문 수정필요-<br />
			<c:forEach var="n" items="${list}">
				${n.content}
				
				</c:forEach>

		</div>

		<div>
			<div class="hitreview">
				<h1>사용자리뷰</h1>
				<c:forEach var="n" items="${hituserlist}">
					<ul>
						<li>${n.writer}</li>
						<li>${n.content  }</li>
						<li><fmt:formatDate pattern="yyyy.MM.dd hh:mm"
								value="${n.regdate}" /></li>
					</ul>
				</c:forEach>
				<div id="note-form">
					<form action="review" method="post">
						<fieldset>
							<legend></legend>
							<textarea name="content">${n.content}</textarea>
							<input type="submit" value="등록" />
						</fieldset>
					</form>
				</div>
			</div>

			<div class="review">
				<c:forEach var="n" items="${userlist}">
					<li>${n.writer}</li>
					<li>${n.content}</li>
					<li><fmt:formatDate pattern="yyyy-MM-dd" value="${n.regdate}" /></li>
				</c:forEach>

				<!--  <input type="hidden" name="q" value="1"/>  -->
				<c:if test="${empty param.p }">
					<c:set var="page" value="1" />
				</c:if>

				<c:if test="${not empty param.p }">
					<c:set var="page" value="${param.p }" />
				</c:if>
				<c:set var="start" value="${page-(page-1)%5}" />
				<c:set var="end"
					value="${fn:substringBefore((count%10==0?count/10:count/10+1),'.')}" />

				
				
				<div class="sort">
				
					<div>${page}/${end}page</div>
					<div>
						<a href="review?p=${(start>=1)?1:start-5}">페이지이전 </a>
						 <a href="review?p=${(start>=1)?1:start-1}">이전 </a>
					</div>
					<ul>
						<c:forEach var="i" begin="0" end="4">
							<c:if test="${start+i<=end}">
								<c:if test="${page == start+i}">
									<li><a href="review?p= ${start+i} " class="strong">${start+i}</a></li>
								</c:if>

								<c:if test="${page != start+i }">
									<li><a href="review?p=${start+i}">${start+i}</a></li>
								</c:if>
							</c:if>
						</c:forEach>
					</ul>
					<div>
						<a href="review?p=${start+1}"> 다음</a> 
						<a href="review?p=${start+5}"> 페이지다음</a>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>