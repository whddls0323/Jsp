<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user6::list</title>
	</head>
	<body>
		<h3>User6 목록</h3>
		
		<a href="/ch09">처음으로</a>
		<a href="/ch09/user6/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>시퀀스</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>주소</th>
				<th>관리</th>
			</tr>	
			<c:forEach var="dto" items="${requestScope.dtoList}"> 
				<tr>			
					<td>${dto.getSeq()}</td>				
					<td>${dto.getName()}</td>
					<td>${dto.getGender().equals("M") ? "남자" : "여자"}</td>
					<td>${dto.getAge()}</td> 
					<td>${dto.getAddr()}</td>
					<td>
						<a href="/ch09/user6/modify.do?seq=${dto.getSeq()}">수정</a>
						<a href="/ch09/user6/delete.do?seq=${dto.getSeq()}">삭제</a>
					</td>
				</tr>	
			</c:forEach>	
		</table>		
	</body>
</html>