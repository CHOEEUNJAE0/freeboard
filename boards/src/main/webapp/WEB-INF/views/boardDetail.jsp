<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

	
    <title>목록 페이지</title>
    <style>
<style type="text/css">
.input_wrap{
	padding: 5px 20px;
}
label{
    display: block;
    margin: 10px 0;
    font-size: 20px;	
}
input{
	padding: 5px;
    font-size: 17px;
}
textarea{
	width: 800px;
    height: 200px;
    font-size: 15px;
    padding: 10px;
}
.btn{
  	display: inline-block;
    font-size: 22px;
    padding: 6px 12px;
    background-color: #fff;
    border: 1px solid #ddd;
    font-weight: 600;
    width: 140px;
    height: 41px;
    line-height: 39px;
    text-align : center;
    margin-left : 30px;
    cursor : pointer;
}
.btn_wrap{
	padding-left : 80px;
	margin-top : 50px;
}
</style>
<script>
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"
</script>
    </head>
    <body>
        <h1> 상세페이지 📑</h1>
        
        <div class="input_wrap">
        	<label>글 번호</label>
        		<input name="no" readonly="readonly" value='<c:out value="${boardmapper.no}"/>'>
        </div>	
        <div class="input_wrap">
        	<label>글 제목</label>
        		<input name="title" readonly="readonly" value='<c:out value="${boardmapper.title}"/>'>
        </div>
        <div class="input_wrap">
        	<label>작성자</label>
        		<input name="user_id" readonly="readonly" value='<c:out value="${boardmapper.user_id}"/>'>
        </div>		
        <div class="input_wrap">
        	<label>작성일</label>
        		<input name="created" readonly="readonly" value='<c:out value="${boardmapper.created}"/>'>
        </div>		 
       	<div class="input_wrap">
        	<label>조회수</label>
        		<input name="hits" readonly="readonly" value='<c:out value="${boardmapper.hits}"/>'>
        </div>
        <div class="btn_wrap">
			<a class="btn" id="list_btn">목록 페이지</a> 
			<a class="btn" id="modify_btn">수정 하기</a>
		</div>
		<form id="infoForm" action="/list/modify" method="get">
			<input type="hidden" id="no" name="no" value='<c:out value="${boardmapper.no}"/>'>
		</form>
        	
<script>
    let form = $("infoForm");
    
    $("list_btn").on("click", function(e){
    		form.find("#no").remove();
    		form.attr("action","/list");
    		form.submit();
    });
 
    $(""modify_btn).on("click", funtion(e){
    		form.attr("action", "/detail/modify");
    		form.submit();
    });
</script>
		
</body>
</html>