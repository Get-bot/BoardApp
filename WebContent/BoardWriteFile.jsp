<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성파일</title>
	<script>
		function BoardList() {
			location.href="boardlist";
		}
	</script>
</head>
<body>
	<h1>BoardWrite(글 작성 파일첨부)</h1>
	<form action="boardwritefile" method="post" name="writefrom" enctype="multipart/form-data">
		작성자: <input type="text" id="bwriter" name="bwriter"><br/>
		제목: <input type="text" id="btitle" name="btitle"><br/>
		글내용: <textarea rows="10" cols="30" name="bcontents" id="bcontents"></textarea><br />
		첨부파일: <input type="file" name="bfile" id="bfile">
		<input type="submit" value="작성">
	</form>
	<button onclick="BoardList()">글목록</button>
		
</body>
</html>