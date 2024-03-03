<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.dxtn.erp.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<c:import url="../commonViews/header.jsp" var="head" />
<c:import url="../commonViews/sideBar.jsp" var="side" />
<c:import url="../commonViews/footer.jsp" var="foot" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사내 게시판</title>
</head>
<body>
	${head}
	<div style="display: flex">
		${side}
		<section>
		<div style="text-align: center;">
		<h1>게시판 목록</h1>
		<table style="width: 700px; margin: auto">
			<tr>
				<th style="width: 10%">번호</th>
				<th style="width: 50%">제목</th>
				<th style="width: 15%">작성자</th>
				<th style="width: 15%">등록일</th>
				<th style="width: 10%">조회수</th>
			</tr>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.boardId}</td>
					<td style="text-align: left"><a
						href="getBoard?seq=${board.boardId}">${board.boardTitle}</a></td>
					<td>${board.writer}</td>
					<td><fmt:formatDate value="${board.boardRegdate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
					<td>${board.boardViewCount}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="/board/boardcreate">새글 등록</a>
	</div>
		</section>
	</div>
	${foot}
</body>
</html>