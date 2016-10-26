<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eagle</title>
</head>
<body>
   <h1> <a href="">Eagle</a></h1>
  
   <form action = "notice" method="get"> <!-- 누가 처리하게 할래?, 검색해서 목록을 달라고 하는거니까 get. 검색은 무조건 get이야 -->
         <fieldset>
            <select name = "t"><!-- 콤보박스 넣을꺼야 야호 , t는 type-->
               <option value="NONE">분류선택</option>

				<c:if test="${param.t=='TITLE'}">
					<option value="TITLE" selected="selected">제목</option>
				</c:if>
				<c:if test="${param.t!='TITLE'}">
					<!--ELSE가 없으므로 != 표시해준다  -->
					<option value="TITLE">제목</option>
				</c:if>


				<c:if test="${param.t=='MEMBER_ID'}">
                  <option value="MEMBER_ID" selected="selected" >작성자</option>
               </c:if>
               <c:if test="${param.t!='MEMBER_ID'}"> <!--ELSE가 없으므로 != 표시해준다  -->
                  <option value="MEMBER_ID" >작성자</option>
               </c:if>
               
               
               
               <option value="CONTENT" <c:if test =" ${param.t=='CONTENT'}"> selected="selected" </c:if>>내용</option> 
               <!--이건 한 줄로 조건을 걸어버린것  -->
            
                <!-- <option value="TITLE" selected="selected"> selected를 그렇게 하면 기본적으로
               제목이 나오게 해버리겠다는 의미이다 -->
               
               
               
               
               <!-- selected 제목 내용 작성자에 다 넣었는데 분류 조건에 맞게 검색이 되도록 만들기 위함이다  -->
            </select>
            
            <label>검색어</label>
            <input name = "q" value ="${param.q}" /> <!-- q는 query -->
            <input type="submit" value="검색" />
         </fieldset>
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
					<td><a href="notice-detail?code=${n.code}"> ${n.title}</a></td>
					<td>${n.member_id}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${n.regDate}" />
					</td>
					<td>${n.hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:if test="${empty param.p }">
		<c:set var="p" value="1" />
		<!-- param.p empty -> 1page  -->
	</c:if>
	<c:if test="${not empty param.p }">
		<c:set var="p" value="${param.p}" />
	</c:if>
	<c:set var="start" value="${p-(p-1)%5}" />
	<c:set var="end" value="${fn:substringBefore((count%10==0?count/10:count/10+1),'.')}" />


	<div>
		${p}/${end} pages
	</div>

	<div>
        <a href ="notice-reg?code=${n.code}">글쓰기</a>
     </div>

	<div>




		<div>
			<a href="notice?p=${(start==1)?1:start-1}&t=${param.t}&q=${param.q}">이전</a>
		</div>
		<ul>
			<c:forEach var="i" begin="0" end="4">
				<!-- p는 페이지..?!  -->
				<c:if test="${start+i <=end }" >
					<c:if test="${param.p==start+i}">
						<li><a href="notice?p=${start+i}&t=${param.t}&q=${param.q}"
							class="strong">${start+i}</a></li>
						<!--현재 페이지와 같은 녀석은 이런아이  -->
					</c:if>
					<c:if test="${param.p!=start+i}">
						<li><a href="notice?p=${start+i}&t=${param.t}&q=${param.q}">${start+i}</a></li>
						<!-- 같지 않은 녀석은 이 아이  -->
					</c:if>
				</c:if>
			</c:forEach>
		</ul>
		<div>
			<a href="notice?p=${start+5}">다음</a> 
			<a href="main">메인으로</a>

		</div>
	</div>

</body>
</html>