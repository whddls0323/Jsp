<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user5::modify</title>
	</head>
	<body>
		<h3>User5 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/user5/list.do">목록이동</a>
		
		<form action="/ch10/user5/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="seq" readonly value="${user5DTO.seq}" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user5DTO.name}" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="text" name="gender" value="${user5DTO.gender}" placeholder="성별 입력"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age" value="${user5DTO.age}" placeholder="나이 입력"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="${user5DTO.addr}" placeholder="주소 입력"/></td>
				</tr>
				<tr>					
					<td colspan="2" align="right">
						<input type="submit" value="수정하기"/>
					</td>
				</tr>			
			</table>
		</form>			
	</body>
</html>