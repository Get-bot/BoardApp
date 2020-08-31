<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function BoardList() {
			location.href="boardlist";
		}
	</script>
</head>
<body>
	<h1>BoardWrite(글 작성)</h1>
	<form action="boardwrite" method="post">
		작성자: <input type="text" id="bwriter" name="bwriter"><br/>
		제목: <input type="text" id="btitle" name="btitle"><br/>
		<!-- 글 내용: <input type="text" id="bcontents" name="bcontents"><br/> -->
		글 내용: <textarea rows="10" cols="10" name="bcontents" id="bcontents"></textarea><br />
		<input type="submit" value="작성">
	</form>
	<button onclick="BoardList()">글목록</button>
		
</body>
</html>