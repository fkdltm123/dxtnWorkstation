<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../commonViews/header.jsp" var="head"/>
<c:import url="../commonViews/sideBar.jsp" var="side"/>
<c:import url="../commonViews/footer.jsp" var="foot"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DXTN Workstation Project</title>
</head>
<body>
	${head}
	<div style="display: flex">
		${side}
		<section class="container">
			<h1>DXTN WORKSTATION PROJECT</h1>
			<hr>
			<h2>Login</h2>
			<form action="login" method="post">
			  <div class="row mb-3">
			    <label for="inputMemberId" class="col-sm-2 col-form-label">ID</label>
			    <div class="col-sm-4">
			      <input type="email" class="form-control" id="inputMemberId" name="memberId">
			    </div>
			  </div>
			  <div class="row mb-3">
			    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			    <div class="col-sm-4">
			      <input type="password" class="form-control" id="inputPassword" name="memberPassword">
			    </div>
			  </div>
			  <button type="button" class="btn btn-secondary">회원가입</button>
			  <button type="button" class="btn btn-secondary">ID/password 찾기</button>
			  <button type="submit" class="btn btn-primary">로그인</button>
			</form>
		</section>
	</div>
	<%-- ${foot} --%>
</body>
</html>