<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>customer::modify</title>
	</head>
	<body>
		<h3>customer 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/bank/customer/list.do">목록이동</a>
		
		<form action="/ch10/bank/customer/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="c_id" readonly value="${customerDTO.c_id}" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>고객명</td>
					<td><input type="text" name="c_name" value="${customerDTO.c_name}" placeholder="고객명 입력"/></td>
				</tr>
				<tr>
					<td>고객구분</td>
					<td><input type="number" name="c_type" value="${customerDTO.c_type}" placeholder="고객구분 입력"/></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="c_hp" value="${customerDTO.c_hp}" placeholder="전화번호 입력"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="c_addr" value="${customerDTO.c_addr}" placeholder="주소 입력"/></td>
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