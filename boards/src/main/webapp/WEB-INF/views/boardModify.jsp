<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous">
</script>
</head>
<body>
	<!-- 수정은 list페이지도 같이 수정 해줘야 한다. boardDetail.jsp를 복붙한다.-->
	<h1> 상세페이지 📑</h1>
        
        <form id="modifyForm" action="/detail/modify" method="post">
    	    
        <div class="input_wrap">
        	<label>글 번호</label>
        		<input name="no" readonly="readonly" value='<c:out value="${detail.no}"/>'>
        </div>	
        <div class="input_wrap">
        	<label>글 제목</label>
        		<input name="title" value='<c:out value="${detail.title}"/>'>
        </div>
		<div class="input_wrap">
			<label>게시판 내용</label>
				<textarea rows="10" name="content"> <c:out value="${detail.content}"/></textarea>
		</div>
        <div class="input_wrap">
        	<label>작성자</label>
        		<input name="user_id" readonly="readonly" value='<c:out value="${detail.user_id}"/>'>
        </div>		
        <div class="input_wrap">
        	<label>작성일</label>
        		<input name="created" readonly="readonly" value='<c:out value="${detail.created}"/>'>
        </div>		 
       	<div class="input_wrap">
        	<label>조회수</label>
        		<input name="hits" readonly="readonly" value='<c:out value="${detail.hits}"/>'>
        </div>
        <div class="btn_wrap">
			<a class="btn" id="list_btn">목록 페이지</a> 
			<a class="btn" id="modify_btn">수정</a>
			<a class="btn" id="cancel_btn">취소</a>
		</div>
		</form>
		
		<form id="infoForm" action="/detail/modify" method="get">
			<input type="hidden" id="no" name="no" value='<c:out value="${detail.no}"/>'>
		</form>
<script>
	let form = $('#infoForm'); //페이지 이동 form (list 페이지 이동)
	let mForm = $('#modifyForm'); //페이지 데이터 수정 form
	
	//목록 페이지 이동 버튼
	$("#list_btn").on("click", function(e){
		form.find("#no").remove();
		form.attr("action", "/list");
		form.submit();
	});
	
	//수정 버튼
	$("#modify_btn").on("click", function(e){
		mForm.submit();
		});
	
	//수정 취소 버튼
	$("#cancel_btn").on("click", function(e){
		form.attr("action", "/detail");
	});



</script>
		
</body>
</html>