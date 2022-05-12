<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>
	<h1>게시글 수정 페이지 입니다.</h1>
	<form action="/detail/modify" method="post">
		<div class="input_wrap">
			<label>제목</label>
				<input name="title">
		</div>		
		<div class="input_wrap">
			<label>내용</label>
				<textarea rows="100" name="content"></textarea>
		</div>
		<div class="input_wrap">
			<label>작성자</label>
				<input name="user_id">
		</div>
			<button class="btn">수정</button>
	</form>

</body>
</html>