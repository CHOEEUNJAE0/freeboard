<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>새 글 작성하기</title>

</head>
<body>
	<h1>게시글 등록 페이지 입니다.</h1>
	<form action="/upload" method="post">
		<div class="input_wrap">
			<label>제목</label>
				<input name="title">
		</div>		
		<div class="input_wrap">
			<label>내용</label>
				<textarea rows="30" name="content"></textarea>
		</div>
		<div class="input_wrap">
			<label>작성자</label>
				<input name="user_id">
		</div>
			<button class="btn">등록</button>
	</form>
	<script>

		
	</script>
</body>
</html>