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
		<section>
			<h1>DXTN WORKSTATION PROJECT</h1>
		</section>
	</div>
	${foot}
</body>
</html>