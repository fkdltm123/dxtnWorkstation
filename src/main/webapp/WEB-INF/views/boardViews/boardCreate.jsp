<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�系 �Խ���</title>
</head>
<body>
	${head}
	<div style="display: flex">
		${side}
		<section></section>
	</div>
	<div style="text-align: center;">
		<h3>�۾���</h3>
		<hr>
		<form action="insertBoard" method="post">
			<table style="width: 700px; margin: auto">
				<tr>
					<td width="70"
						style="background-color: dodgerblue; color: cornsilk">����</td>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td style="background-color: dodgerblue; color: cornsilk">�ۼ���</td>
					<td><input type="text" name="writer" /></td>
				</tr>
				<tr>
					<td style="background-color: dodgerblue; color: cornsilk">����</td>
					<td><textarea name="content" cols="40" rows="10"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="���" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	${foot}
</body>
</html>