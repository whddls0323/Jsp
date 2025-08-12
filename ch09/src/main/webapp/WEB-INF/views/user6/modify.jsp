<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user6::modify</title>
	</head>
	<body>
		<h3>User6 수정</h3>
		
		<a href="/ch09">처음으로</a>
		<a href="/ch09/user6/list.do">목록이동</a>
		
		<form action="/ch09/user6/modify.do" method="post">
			<table border="1">
				<tr>
					<td>시퀀스</td>
					<td><input type="number" name="seq" value="${user6DTO.seq}" placeholder="시퀀스 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user6DTO.name}" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<label><input type="radio" name="gender" value="M" ${user6DTO.gender.equals("M") ? "checked" : ""}/>남자</label>
						<label><input type="radio" name="gender" value="F" ${user6DTO.gender.equals("F") ? "checked" : ""}/>여자</label>
					</td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="${user6DTO.age}" placeholder="나이 입력"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="${user6DTO.addr}" placeholder="주소 입력"/></td>
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