<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>course::modify</title>
	</head>
	<body>
		<h3>course 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/college/course/list.do">목록이동</a>
		
		<form action="/ch10/college/course/modify.do" method="post">
			<table border="1">
				<tr>
					<td>강좌번호</td>
					<td><input type="number" name="cs_id" readonly value="${courseDTO.cs_id}" placeholder="강좌번호 입력"/></td>
				</tr>
				<tr>
					<td>강좌명</td>
					<td><input type="text" name="cs_name" value="${courseDTO.cs_name}" placeholder="강좌명 입력"/></td>
				</tr>
				<tr>
					<td>취득학점</td>
					<td><input type="number" name="cs_credit" value="${courseDTO.cs_credit}" placeholder="취득학점 입력"/></td>
				</tr>
				<tr>
					<td>개설학과</td>
					<td><input type="text" name="cs_dept" value="${courseDTO.cs_dept}" placeholder="개설학과 입력"/></td>
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