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
<script>
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"
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
					<td><c:out value="${list.title}"/></td>
					<td><c:out value="${list.user_id}"/></td>
					<td><c:out value="${list.created}"/></td>
					<td><c:out value="${list.hits}"/></td>
				</tr>
			</c:forEach>
        </table>
		</div>
		 
<script>
    $(document).ready(function(){
    
        let result = '<c:out value="${result}"/>'; //서버로부터 전달받은 값을 저장하기 위한 변수 선언
     	checkAlert(result);   					//result에 담긴 값이 아무것도 없을 경우 실행 되지 않고
        function checkAlert(result){			//값이 있을 경우 어떠한 메세지가 있는지 체크 한 뒤 게시판 등록 완료 메세지 띄움
        	if(result === '') {					//작성한 함수를 호출, 인자 값으로는 서버로부터 전달 받은 값인 result를 부여
        		return;
        	}
        if(result === "BoardUpload success") {
        		alret("등록이 완료 되었습니다.");	
       	 }
        }
    });
 
</script>
		
</body>
</html>