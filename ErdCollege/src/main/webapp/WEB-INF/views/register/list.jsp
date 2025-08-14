<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>수강목록</title>
	</head>
	<body>
		<h3>수강목록</h3>
		
		<a href="/ErdCollege">처음으로</a>
		
		<table border="1">
			<tr>
				<th>학생번호</th>
				<th>강좌번호</th>
				<th>중간고사점수</th>
				<th>기말고사점수</th>
				<th>총점</th>
				<th>평점</th>
				<th>관리</th>
			</tr>			
			
			<c:forEach var="dto" items="${dtoList}">
				<tr>
					<td>${dto.regStdNo}</td>
					<td>${dto.regLecNo}</td>
					<td>${dto.regMidScore}</td>
					<td>${dto.regFinalScore}</td>
					<td>${dto.regTotalScore}</td>
					<td>${dto.regGrade}</td>
					<td>					
						<a href="/ErdCollege/register/modify.do?regStdNo=${dto.regStdNo}&regLecNo=${dto.regLecNo}">수정</a>					
						<a href="/ErdCollege/register/delete.do?regStdNo=${dto.regStdNo}&regLecNo=${dto.regLecNo}">삭제</a>
					</td>
				</tr>		
			</c:forEach>	
		</table>		
	</body>
</html>