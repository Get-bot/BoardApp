<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정</title>
<script >
	       function Boardupdate() {
			updateform.submit();
		}
 </script>
</head>
<body>
	<h2>MemberUpdate.jsp</h2>
	<form action="boardupdateprocess" method="post" name="updateform">
	 <h2>글번호 : <input type ="text" name = "bnumber" id="bnumber" value="${boardUpdate.bnumber}" readonly> </h2><br>
		작성자 : <input type="text" name="bwriter" id="bwriter" value="${boardUpdate.bwriter}"><br>
		제목 : <input type="text" name="btitle" id="btitle" value="${boardUpdate.btitle}"><br>
		내용 : <input type="text" name="bcontents" id="bcontents" value="${boardUpdate.bcontents}"><br>	
	</form>
	<button onclick="Boardupdate()">전송!</button>




</body>
</html>