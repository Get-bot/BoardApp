<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function BoardList() {
			location.href="boardlist";
		}
	       function Boardupdate() {
			location.href="boardupdate?bnumber="+${boardView.bnumber};
		}
	       function BoardDelete() {
				location.href="boarddelete?bnumber="+${boardView.bnumber};
			}

	</script>
</head>
<body>

	<table border="1">
	<tr>
		<th>글번호</th> <th>작성자</th> <th>제목</th>
		<th>내용</th><th>작성일자</th> <th>조회수</th></tr>
			<tr>
			<td>${boardView.bnumber}</td>
			<td>${boardView.bwriter}</td>
			<td>${boardView.btitle}</td>
			<td>${boardView.bcontents}</td>
			<td>${boardView.bdate}</td>
			<td>${boardView.bhits}</td>
			</tr> 
	</table> <br>
	<button onclick="BoardList()">글목록</button>
	<button onclick="Boardupdate()">글수정</button>
	<button onclick="BoardDelete()">글삭제</button>
	
</body>
</html>