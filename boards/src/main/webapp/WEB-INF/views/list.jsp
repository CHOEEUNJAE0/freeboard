<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>목록 페이지</title>
    <style>
    	h1{
    		text-align : center;
    	}
    
        a{
            text-decoration : none;
            text-align : center;
        }
        table{
           border-collapse: collapse;
           width: 1000px;    
           margin : 10px 50px; 	
           text-align: center;
        }
        td, th{
            border : 1px solid black;
            height: 50px;
        }
        th{
            font-size : 17px;
        }
        thead{
            font-weight: 700;
        }
        .table_wrap{
            margin : 50px 0 0 50px;
        }
        .no {
        	width : 5px;
        }
        .title {
        	width : 35px;
        }
	    .user_id {
        	width : 10px;
        }
        .created {
        	width : 25px;
        }
        .hits {
        	width : 5px;
        }
        .top_btn{
            font-size: 20px;
          	padding: 6px 12px;
          	background-color: #fff;
          	border: 1px solid #ddd;
          	font-weight: 600;
        }
        </style>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous">
</script>
    </head>
    <body>
        <h1>게시판 목록 📑</h1>
        
        <div class="table_wrap">
        <a href="/upload" class="top_btn">등록</a>
        <table>
            <thead>
                <tr>
                   <th class="no">번호</th>
                   <th class="title">제목</th>
                   <th class="user_id">작성자</th>
                   <th class="created">작성일</th>
                   <th class="hits">조회수</th>
                </tr>
            </thead>
               <!-- list, 배열 요소의 반복을 처리해주는 태크 c:foreach -->    
               <c:forEach items="${list}" var="list">
				<tr>
					<td><c:out value="${list.no}"/></td>
					<td>
						<!-- 제목 클릭 시 조회페이지로 이동 -->                 	
    				 <a class="move" href='/detail?no=<c:out value="${list.no}"/>'>
        				<c:out value="${list.title}"/>
    				</a>
						</td>
					<td><c:out value="${list.user_id}"/></td>
					<td><c:out value="${list.created}"/></td>
					<td><c:out value="${list.hits}"/></td>
				</tr>
			</c:forEach>
        </table>
        <form id="moveForm" method="get"></form>
		</div>
		 
<script>

$(document).ready(function(){
	let result = '<c:out value="${result}" />';
	
	checkAlert(result);
	console.log(resilt);
	
	function checkAlert(result) {
		if(result === ''){
			return;
		}
		if(result === "upload success") {
			alret("등록이 완료 되었습니다.");
		}
		if(result === "modify success") {
			alert("수정이 완료 되었습니다.");
		}
	}
}); 
let moveForm = $("#moveForm");

$(".move").on("click", function(e){
    e.preventDefault();
    
    moveForm.append("<input type='hidden' name='no' value='"+ $(this).attr("href")+ "'>");
    moveForm.attr("action", "/detail");
    moveForm.submit();
});


 
 
</script>
		
</body>
</html>