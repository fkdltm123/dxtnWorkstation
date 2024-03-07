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

	function checkPassword(){
		const password = $('#inputMemberPassword').val();
		const passwordChk = $('#inputMemberPasswordCheck').val();
		
		if(password === null || password === '' || passwordChk === null || passwordChk === ''){
			return false;
		} else if(password !== passwordChk){
			return false;
		}
		return true;
	}
	
	async function joinMember(){
		
		if(!checkPassword()){
			alert('패스워드를 확인해주세요');
			return false;
		};
		
		const data = {
				memberId : $('#inputMemberId').val(),
				memberPassword : $('#inputMemberPassword').val(),
				memberPasswordCheck : $('#inputMemberPasswordCheck').val(),
				lastName : $('#inputLastName').val(),
				firstName : $('#inputFirstName').val(),
				residentId : $('#inputResidentId').val(),
				phoneNo : $('#inputPhoneNo').val(),
				email : $('#inputEmail').val(),
				address1 : $('#inputAddress1').val(),
				address2 : $('#inputAddress2').val(),
				addressDetail : $('#inputAddressDetail').val(),
				hireDate : $('#inputHireDate').val(),
				departmentNo : $('#inputDepartmentNo').val(),
				rankNo : $('#inputRankNo').val(),
		};
		
		const response = await fetch('joinMember', {
			method: 'POST',
			headers: {
				'Content-Type' : 'application/json',
			},
			body: JSON.stringify(data),
		});
		if (response.status === 200){
			callBackJoinMember(await response.json());
		} else{
			alert('fail');
		}
	}
	
	function callBackJoinMember(response){
		alert(response.msg);
		if(response.result === "success"){
			location.href = "login";
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
			<h2>Join</h2>
			<form class="row g-3" method="post" action="join">
			  <div class="col-md-4">
			    <label for="inputMemberId" class="form-label">ID</label>
			    <input type="text" class="form-control" id="inputMemberId" name="memberId">
			  </div>
			  <div class="col-md-4">
			    <label for="inputMemberPassword" class="form-label">Password</label>
			    <input type="password" class="form-control" id="inputMemberPassword" name="memberPassword">
			  </div>
			  <div class="col-md-4">
			    <label for="inputMemberPasswordCheck" class="form-label">Password 확인</label>
			    <input type="password" class="form-control" id="inputMemberPasswordCheck" name="memberPasswordCheck" onchange="checkPassword();">
			  </div>
			  <div class="col-md-4">
			    <label for="inputLastName" class="form-label">성</label>
			    <input type="text" class="form-control" id="inputLastName" name="lastName">
			  </div>
			  <div class="col-md-4">
			    <label for="inputFirstName" class="form-label">이름</label>
			    <input type="text" class="form-control" id="inputFirstName" name="firstName">
			  </div>
			  <div class="col-md-4">
			    <label for="inputResidentId" class="form-label">주민등록번호</label>
			    <input type="text" class="form-control" id="inputResidentId" name="residentId" placeholder="'-' 제외">
			  </div>
			  <div class="col-md-4">
			    <label for="inputPhoneNo" class="form-label">전화번호</label>
			    <input type="text" class="form-control" id="inputPhoneNo" name="phoneNo" placeholder="'-' 제외">
			  </div>
			  <div class="col-md-8">
			    <label for="inputEmail" class="form-label">Email</label>
			    <input type="email" class="form-control" id="inputEmail" name="email">
			  </div>
			  <div class="col-3">
			    <label for="inputAddress1" class="form-label">도시</label>
			    <input type="text" class="form-control" id="inputAddress1" name="address1" placeholder="ex)세종특별자치시">
			  </div>
			  <div class="col-3">
			    <label for="inputAddress2" class="form-label">도로명 주소</label>
			    <input type="text" class="form-control" id="inputAddress2" name="address2" placeholder="ex)한누리대로 000">
			  </div>
			  <div class="col-md-6">
			    <label for="inputAddressDetail" class="form-label">상세 주소</label>
			    <input type="text" class="form-control" id="inputAddressDetail" name="addressDetail" placeholder="00오피스텔 100호">
			  </div>
			  <div class="col-md-4">
			    <label for="inputHireDate" class="form-label">입사일</label>
			    <input type="date" class="form-control" id="inputHireDate" name="hireDate">
			  </div>
			  <div class="col-md-4">
			    <label for="inputDepartmentNo" class="form-label">부서</label>
			    <select id="inputDepartmentNo" class="form-select" name="departmentNo">
			      <option value="10" selected>DT 사업본부</option>
			      <option value="20">Cloud 사업본부</option>
			      <option value="30">Solution 사업본부</option>
			      <option value="40">경영관리본부</option>
			    </select>
			  </div>
			  <div class="col-md-4">
			    <label for="inputRankNo" class="form-label">직급</label>
			    <select id="inputRankNo" class="form-select" name="rankNo">
			      <option value="10" selected>주임</option>
			      <option value="20">선임</option>
			      <option value="30">책임</option>
			      <option value="40">수석</option>
			      <option value="50">이사</option>
			      <option value="60">상무</option>
			      <option value="70">전무</option>
			      <option value="80">부사장</option>
			    </select>
			  </div>
			  <div class="col-12">
			    <button type="button" onclick="joinMember();" class="btn btn-primary">회원가입</button>
			  </div>
			</form>
		</section>
	</div>
	${foot}
</body>
</html>