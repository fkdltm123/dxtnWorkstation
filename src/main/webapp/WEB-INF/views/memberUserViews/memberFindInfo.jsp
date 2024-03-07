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
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
	function selectFindType(e) {
		var idSearchRow = document.getElementById("idSearchRow");
		var passwordSearchRow = document.getElementById("passwordSearchRow");
		if(e.value === "0"){
			idSearchRow.style = "display:flex;"
			passwordSearchRow.style = "display:none;"
		} else {
			idSearchRow.style = "display:none;"
			passwordSearchRow.style = "display:flex;"
		}
	}
	
	async function findMember(){
		const findType = $('input[name=findType]:checked').val();
		
		const data = {
				findType : findType,
				residentId : $('#inputResidentId').val(),
		};
		if(findType === "0"){
			data.firstName = $('#inputFirstName').val();
			data.lastName = $('#inputLastName').val();
		} else {
			data.memberId = $('#inputMemberId').val();
		}
		
		const response = await fetch('findMember', {
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
		alert(memberInfo.msg);
	}
	
</script>
<body>
	${head}
	<div style="display: flex">
		${side}
		<section class="container">
			<h1>DXTN WORKSTATION PROJECT</h1>
			<h2>Find Member</h2>
			<form method="post" class="col border-end">
			  	<div class="row mb-3 mx-3">
			  		<div class="col-sm-2 form-check">
				  		<label class="form-check-label" for="radioFindType1">ID 조회</label>
				  		<input class="form-check-input" type="radio" id="radioFindType1" name="findType" value="0" checked onclick="selectFindType(this);">
			  		</div>
			  		<div class="col-sm-2 form-check">
				  		<label class="form-check-label" for="radioFindType2">Password 조회</label>
				  		<input class="form-check-input" type="radio" id="radioFindType2" name="findType" value="1" onclick="selectFindType(this);">
			  		</div>
			  	</div>
				  <div class="row mb-3" id="idSearchRow">
					  <div class="col-sm-4">
						  <div class="row mb-3">
						    <label for="inputLastName" class="col-sm-4 col-form-label">성</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" id="inputLastName" name="lastName">
						    </div>
						  </div>
					  </div>
					  <div class="col-sm-4">
						  <div class="row mb-3">
						    <label for="inputFirstName" class="col-sm-4 col-form-label">이름</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" id="inputFirstName" name="firstName">
						    </div>
						  </div>
					  </div>
				  </div>
				  <div class="row mb-3" id="passwordSearchRow" style="display:none">
					  <div class="col-sm-8">
						  <div class="row mb-3">
						    <label for="inputMemberId" class="col-sm-2 col-form-label">ID</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="inputMemberId" name="memberId">
						    </div>
						  </div>
					  </div>
				  </div>
				  <div class="row mb-3">
					  <div class="col-sm-8">
						  <div class="row mb-3">
						    <label for="inputResidentNo" class="col-sm-2 col-form-label">주민등록번호</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="inputResidentId" name="residentId" placeholder="'-' 제외" maxlength="13">
						    </div>
						  </div>
					  </div>
				  </div>
				  <div class="row">
					  <button type="button" onClick="findMember();" class="btn btn-primary offset-sm-7 col-sm-1">조회</button>
				  </div>
			</form>
		</section>
	</div>
</body>
</html>