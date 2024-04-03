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
	#filterOptions {
		position:absolute;
		margin-left: 260px;
		bottom: 5px;
		width: 100px;
	}
	.form-select {
		height: 36px;
	}
		
</style>
<script>
$(document).ready(function () {
    	
	$("#datePicker, #filterOptions").change(function () {
        var selectedDate = $("#datePicker").val(); // 변경된 날짜 가져오기
        var selectedOption = $("#filterOptions").val(); // 변경된 구분 가져오기
        var year = selectedDate.substring(0, 4); // 연도 추출
        var month = selectedDate.substring(5, 7); // 월 추출
        var formattedDate = year + month; // 형식 변환

        // 날짜만 선택된 경우에는 구분 선택 여부에 상관 없이 새 URL로 이동
        if (selectedDate && !selectedOption) {
            window.location.href = "lhsListStock?st_year_month=" + formattedDate;
        } else if (selectedDate && selectedOption) { // 날짜와 구분이 모두 선택된 경우에만 새 URL로 이동
            window.location.href = "lhsListStock?st_year_month=" + formattedDate + "&gubun=" + selectedOption;
        }

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
	 <label class="buyLabel">월 재고 조회 </label>
	  <!-- search bar -->
		<div class="searchBar">

			<div class="container-fluid">
			     <!-- datePicker -->
			     	<input type="hidden" id="selectedMonth" name="selectedMonth" value="${stock.st_year_month}">    
					<input type="month" id="datePicker" class="form-control" >
				<form action="lhsListStock" id="formCateSearch2" method="get">
			   		<select class="form-select mr-2" name="gubun" id="filterOptions">
						<option value="all" 
							<c:if test ="${param.gubun == 'all'}">
								selected</c:if>>전체</option>
						<option value="begin" 
							<c:if test ="${param.gubun == 'begin'}">
								selected</c:if>>기초</option>
						<option value="end" 
							<c:if test ="${param.gubun == 'end'}">
								selected</c:if>>기말</option>
					</select>
				</form>
	
			  </div>
		</div>
		
		<c:set var="num" value="${page.total-page.start+1 }"></c:set>
		
	  <table class="table table-hover" id="table">
		  <thead>
		    <tr>
		      <th scope="col">NO</th>
		      <th scope="col">구분</th>
		      <th scope="col">제품코드</th>
		      <th scope="col">제품명</th>
		      <th scope="col">수량</th>
		      <th scope="col">등록일</th>
		    </tr>
		  </thead>
		  
		  <c:choose>
		  
			<c:when test='${listStock == null or empty listStock}'>
				<td colspan="4">
					<p align="center">
						<b><span style=''>조회할 내역이 없습니다.</span></b>
					</p>
				</td>
			</c:when>
			
			<c:when test="${listStock != null }">
				<c:forEach var="stock" items="${listStock }">
				  <tbody>
				    <tr>
				      <th scope="row">${num }</th>
				      <td>${stock.st_begin_end_gubun }</td>
				      <td>${stock.p_itemcode }</td>
				      <td>${stock.p_name }</td>
				      <td>${stock.st_quantity }</td>
				      <td>${stock.st_regdate }</td>
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
					<li class="page-item"><a class="page-link" href="lhsListStock?currentPage=${page.startPage-page.pageBlock}&gubun=${param.gubun }">◁</a>
				</c:if>
				<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
					<li class="page-item"><a class="page-link" href="lhsListStock?currentPage=${i}&gubun=${param.gubun }">${i}</a>
				</c:forEach>
				<c:if test="${page.endPage < page.totalPage }">
					<li class="page-item"><a class="page-link" href="lhsListStock?currentPage=${page.startPage+page.pageBlock}&gubun=${param.gubun }">▷</a>
				</c:if>	
			</ul>
		</nav>
		
		<button type="button" class="btn btn-primary" id="buyProBtn">관리</button>
    </div> 
   
    <!-- ****** 공통 : 테이블 끝 ****** -->
   	 </div>
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
</body>
</html>