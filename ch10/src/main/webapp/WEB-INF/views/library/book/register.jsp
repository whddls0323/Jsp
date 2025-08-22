<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Library/Book::register</title>
	</head>
	<body>
		<h3>Library/Book 등록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/library/book/list.do">목록이동</a>
		
		<form action="/ch10/library/book/register.do" method="post">
			<table border="1">
				<tr>
					<td>도서번호</td>
					<td><input type="number" name="book_id" placeholder="도서번호 입력"/></td>
				</tr>
				<tr>
					<td>도서명</td>
					<td><input type="text" name="title" placeholder="도서명 입력"/></td>
				</tr>
				<tr>
					<td>저자</td>
					<td><input type="text" name="author" placeholder="저자 입력"/></td>
				</tr>
				<tr>
					<td>출판사</td>
					<td><input type="text" name="publisher" placeholder="출판사 입력"/></td>
				</tr>
				<tr>
					<td>대출여부</td>
					<td><input type="text" name="available" placeholder="대출여부 입력"/></td>
				</tr>
				<tr>
					<td>도서 등록일</td>
					<td><input type="date" name="reg_date" placeholder="도서 등록일 입력"/></td>
				</tr>
				<tr>					
					<td colspan="2" align="right">
						<input type="submit" value="등록하기"/>
					</td>
				</tr>			
			</table>		
		</form>
	</body>
</html>