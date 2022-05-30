<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
     	.pageInfo{
      		list-style : none;
      		display: inline-block;
    		margin: 50px 0 0 100px;      
  		}
  		.pageInfo li{
     		float: left;
    		font-size: 20px;
    		margin-left: 18px;
    		padding: 7px;
    		font-weight: 500;
  		}
 	a:link {color:black; text-decoration: none;}
 	a:visited {color:black; text-decoration: none;}
	a:hover {color:black; text-decoration: underline;}
	.active{
			background-color:#cdd5ec;
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
    				 <a class="move" href='<c:out value="${list.no}"/>'>
        				<c:out value="${list.title}"/>
    				</a>
						</td>
					<td><c:out value="${list.user_id}"/></td>
					<td><c:out value="${list.created}"/></td>
					<td><c:out value="${list.hits}"/></td>
				</tr>
			</c:forEach>
        </table>
        
        <div class="pageInfo_wrap">
        	<div class="pageInfo_area">
        		<ul id="pageInfo" class="pageInfo">
        		<!-- 이전 페이지 버튼 -->
        		<c:if test="${pageMaker.prev}">
        			<li class="pageInfo_btn_previous"><a href="${pageMaker.startPage-1}">이전</a></li>
        		</c:if>
        		
        			<!-- 각 번호 페이지 버튼 -->
                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                    <li class="pageInfo_btn" ${pageMaker.cri.pageNum == num ? "active":""}" ><a href="${num}">${num}</a></li>
                </c:forEach>
                
                <!-- 다음 페이지 버튼 -->
                <c:if test="${pageMaker.next}">
                	<li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1}">다음</a></li>
                </c:if>
                </ul>
           	 </div>
           </div>
        

        
        <!-- pageNum이랑 amount 정보를 전송하기 위한 부분 -->
        <form id="moveForm" method="get">
        	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
        	<input type="hidden" name="amount" value="${pageMaker.cri.amount }"> 
        </form>
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
		if(result === "delete success") {
			alret("삭제가 완료 되었습니다.");
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
 //a 태그 동작 멉춤 -> form 내부에 pageNum 관련 input 태그의 value 속성값을 클릭한 a태그의 페이지 번호 삽입
 //->form 태그 안에 action 속성 추가 및 /list를 속성값으로 추가 ->form 태그 서버 전송
 $(".pageInfo a").on("click", function(e){
	 e.preventDefault();
     moveForm.find("input[name='pageNum']").val($(this).attr("href"));
     moveForm.attr("action", "/list");
     moveForm.submit();
     
 });
 
 
 
</script>
		
</body>
</html>