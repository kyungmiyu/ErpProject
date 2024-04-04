<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<link href="assets/css/LSL/buying.css" rel="stylesheet">

<<!-- datepicker 는 jquery 1.7.1 이상 bootstrap 2.0.4 이상 버전이 필요함 -->
<!-- jQuery가 먼저 로드 된 후 datepicker가 로드 되어야함.-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="resources/css/plugin/datepicker/bootstrap-datepicker.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/js/all.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="resources/js/plugin/datepicker/bootstrap-datepicker.js"></script>

<!--한국어  달력 쓰려면 추가 로드-->
 <script src="resources/js/plugin/datepicker/bootstrap-datepicker.ko.min.js"></script> 
 
 <link href="assets/js/LSL/buying.js">
 
<head>
<%@ include file="../configHead.jsp"%>

<style>
	.upperButtonBar {
		position: relative;
	    margin-left: 20px;
		width: 100%;
	}
	
    .downer-btn {
        float: right; /* 오른쪽으로 부유(floating) */
        margin-left: 5px; /* 버튼 사이의 간격 설정 */
        font-size: 0.8rem;
		width: 100px;
		right: 40px;
    }
    
    .container-fluid {
    	
    }
    
    .table {
    	text-align: center;
    }
    
    #filterOptions {
		position:absolute;
		margin-left: 215px;
		bottom: 5px;
		width: 110px;

	}
    
   	.form-select {
		height: 35px;
	}
    
    #datePicker {
		text-align: center;
		width: 200px; /* 화면 폭의 절반을 차지하도록 설정 */
	}
		
</style>
<script>
document.addEventListener("DOMContentLoaded", function() {
    
    var stockYearMonthDay = "${rnpc.rnpc_year_month_day}";

    // 날짜 값을 입력란에 넣어주기
    if (stockYearMonthDay) {
    	var year = stockYearMonthDay.substring(0, 4); // 연도 추출
        var month = stockYearMonthDay.substring(4, 6); // 월 추출
        var day = stockYearMonthDay.substring(6, 8); // 일 추출
        var formattedDate = year + "-" + month + "-" + day; // "yyyy-MM-dd" 형식으로 변환
        
        // 날짜 값이 존재할 때만 처리
        var datePicker = document.getElementById("datePicker");
        datePicker.value = formattedDate; // 입력란에 날짜 값 넣기
    }
});

$(document).ready(function () {
	
	
 	$("#datePicker").change(function () {
        var selectedDate = $("#datePicker").val(); // 변경된 날짜 가져오기
        var year = selectedDate.substring(0, 4); // 연도 추출
        var month = selectedDate.substring(5, 7); // 월 추출
        var day = selectedDate.substring(8, 10); // 일 추출
        var formattedDate = year + month + day; // 형식 변환
        var emp_no = ${empData.emp_no};
        
        $.ajax({
            url: "lhsListRnPCondSurvey",
            type: "GET",
            data: { 
            	rnpc_year_month_day: formattedDate,
            	emp_no : emp_no
            },
            success: function (data) {
            	window.location.href = "lhsListRnPCondSurvey?rnpc_year_month_day=" + formattedDate
															+ "&emp_no=" + emp_no;
            },
            error: function (xhr, status, error) {
                console.error("Error occurred:", error);
            }
        });
    });
 	
	 $("#filterOptions").change(function () {
         // 선택된 날짜와 구분 값 가져오기
         var selectedDate = ${rnpc.rnpc_year_month_day}; // 변경된 날짜 가져오기
         var selectedOption = $("#filterOptions").val(); // 변경된 구분 가져오기
         var emp_no = ${empData.emp_no};

         $.ajax({
             url: "lhsListRnPCondSurvey", // 컨트롤러 URL 설정
             type: "GET", // GET 또는 POST
             data: { 
            	 rnpc_year_month_day: selectedDate,
            	 gubun: selectedOption,
                 emp_no: emp_no
             },
             success: function (data) {
            	 window.location.href = "lhsListRnPCondSurvey?rnpc_year_month_day=" + selectedDate 
            			 								+ "&gubun=" + selectedOption
            			 								+ "&emp_no=" + emp_no;
             },
             error: function (xhr, status, error) {
                 // 오류 발생 시 처리할 코드 작성
                 console.error("Error occurred:", error);
             }
         });
     });
    
});
</script>
</head>
<body>
 	<div class="min-height-300 bg-primary position-absolute w-100"></div>
 	<!-- Sidebar 사이드바 -->
  	<%@ include file="../sidebar.jsp"%>
	<main class="main-content position-relative border-radius-lg ">
 	<!-- Header 헤더 -->
 	<%@ include file="../header.jsp"%> 
    <div class="comm-body container-fluid py-4"> <!-- 메인 바디 -->
    
	 <!-- ****** 공통 : 테이블 시작 ****** -->
	
	 <!-- 이 아래부터는 파트별로 자유롭게 활용하시면 됩니다 -->
	 <div class="buyingList">
	 <label class="buyLabel">수불 월말 재고조사내역</label>
	  <!-- search bar -->
		<div class="searchBar">

			<div class="container-fluid">
			     <!-- datePicker -->
					<input type="date" id="datePicker" class="form-control" >
					<%-- <select class="form-select mr-2" name="gubun" id="filterOptions">
						<option value="all" 
							<c:if test ="${param.gubun == 'all'}">
								selected</c:if>>전체</option>
						<option value="ing" 
							<c:if test ="${param.gubun == 'ing'}">
								selected</c:if>>${rnpc.rnpc_filter }진행</option>
						<option value="complete" 
							<c:if test ="${param.gubun == 'complete'}">
								selected</c:if>>${rnpc.rnpc_filter }완료</option>
						<option value="close" 
							<c:if test ="${param.gubun == 'close'}">
								selected</c:if>>수불완료</option>
					</select> --%>
			  </div>
		</div>
		
		<div class="upperButtonBar">
			<button type="button" class="btn btn-primary" 
				onclick="location.href='lhsListRnPCondBuy?emp_no=${empData.emp_no }'">구매</button>
			<button type="button" class="btn btn-primary" 
				onclick="location.href='lhsListRnPCondSale?emp_no=${empData.emp_no }'">판매</button>
			<button type="button" class="btn btn-primary" 
				onclick="location.href='lhsListRnPCondMake?emp_no=${empData.emp_no }'">생산</button>
			<button type="button" class="btn btn-primary" 
				onclick="location.href='lhsListRnPCondSurvey?emp_no=${empData.emp_no }'">재고조사</button>
		</div>
		
		<c:set var="num" value="${page.total-page.start+1 }"></c:set>
			
		  <table class="table table-hover" id="table">
		  
			  <thead>
			    <tr>
			      <th scope="col">NO</th>
			      <th scope="col">구분</th>
			      <th scope="col">제품코드</th>
			      <th scope="col">제품명</th>
			      <th scope="col">창고수량</th>
			      <th scope="col">실수량</th>
			      <th scope="col">페기수량</th>
			      <th scope="col">등록일</th>
			    </tr>
			  </thead>
		  
		  <c:choose>
			<c:when test='${listRnPClosing == null or empty listRnPClosing}'>
				<td colspan="4">
					<p align="center">
						<b><span style=''>조회할 내역이 없습니다.</span></b>
					</p>
				</td>
			</c:when>
			
			<c:when test="${listRnPClosing != null }">
				<c:forEach var="closing" items="${listRnPClosing }">
				  <tbody>
				    <tr>
				      <th scope="row">${num }</th>
				      <td>${rnpc.rnpc_filter }</td>
				      <td>${closing.rnpc_itemcode }</td>
				      <td>${closing.rnpc_p_name }</td>
				      <td>${closing.rnpc_cnt }</td>
				      <td>${closing.rnpc_cnt_real }</td>
   				      <td>${closing.rnpc_cnt_disposal }</td>
				      <td>${closing.rnpc_regdate }</td>
				    </tr>
				  </tbody>
				  <c:set var="num" value="${num - 1 }"></c:set>
				  </c:forEach>
		  		</c:when>
			</c:choose>
			
		</table>
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<c:if test="${page.startPage > page.pageBlock }">
						<li class="page-item"><a class="page-link" href="lhsListRnPCondSurvey?currentPage=${page.startPage-page.pageBlock}
																							&emp_no=${empData.emp_no}&gubun=${param.gubun }
																							&rnpc_year_month_day=${rnpc.rnpc_year_month_day }">◁</a>
					</c:if>
					<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
						<li class="page-item"><a class="page-link" href="lhsListRnPCondSurvey?currentPage=${i}&emp_no=${empData.emp_no}&gubun=${param.gubun }
																							&rnpc_year_month_day=${rnpc.rnpc_year_month_day }">${i}</a>
					</c:forEach>
					<c:if test="${page.endPage < page.totalPage }">
						<li class="page-item"><a class="page-link" href="lhsListRnPCondSurvey?currentPage=${page.startPage+page.pageBlock}
																							&emp_no=${empData.emp_no}&gubun=${param.gubun }
																							&rnpc_year_month_day=${rnpc.rnpc_year_month_day }">▷</a>
					</c:if>	
				</ul>
			</nav>
			<c:if test="${empData.emp_role == 'role_admin'}">
				<c:if test="${today >0}">
					<button type="button" class="btn btn-primary downer-btn" id="buyProBtn3">월말마감</button>
				</c:if>
				<button type="button" class="btn btn-primary downer-btn" id="buyProBtn2">해제</button>
				<button type="button" class="btn btn-primary downer-btn" id="buyProBtn1">마감</button>
			</c:if>
    </div> 
   
    <!-- ****** 공통 : 테이블 끝 ****** -->
   	 </div>
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
</body>
</html>