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
<script>
	
	async function login(){
		
		const data = {
				memberId : $('#inputMemberId').val(),
				memberPassword : $('#inputMemberPassword').val(),
		};
		
		const response = await fetch('login', {
			method: 'POST',
			headers: {
				'Content-Type' : 'application/json',
			},
			body: JSON.stringify(data),
		});
		if (response.status === 200){
			callBackFindMember(await response.json());
		} else{
			alert('fail');
		}
	}
	
	function callBackFindMember(memberInfo){
		if(memberInfo.result === "success"){
			alert('로그인 되었습니다.');
			location.href = '/';			
		} else {
			alert(memberInfo.msg);
		}
	}

</script>
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
			      <input type="text" class="form-control" id="inputMemberId" name="memberId">
			    </div>
			  </div>
			  <div class="row mb-3">
			    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			    <div class="col-sm-4">
			      <input type="password" class="form-control" id="inputMemberPassword" name="memberPassword">
			    </div>
			  </div>
			  <a  class="btn btn-secondary" href="joinMember">회원가입</a>
			  <a class="btn btn-secondary" href="findMember">ID/password 찾기</a>
			  <button type="button" onclick="login();" class="btn btn-primary">로그인</button>
			</form>
		</section>
	</div>
	<%-- ${foot} --%>
</body>
</html>