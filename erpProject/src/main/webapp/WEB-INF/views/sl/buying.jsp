
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
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="resources/js/plugin/datepicker/bootstrap-datepicker.js"></script>

<!--한국어  달력 쓰려면 추가 로드-->
 <script src="resources/js/plugin/datepicker/bootstrap-datepicker.ko.min.js"></script> 
 
 <link href="assets/js/LSL/buying.js">
 
<head>
<%@ include file="../configHead.jsp"%>
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
	 <label class="buyLabel">구매 조회</label>
	  <!-- search bar -->
		<div class="searchBar">
		
			<div class="container-fluid">
			     <!-- datePicker -->	    
				<input type="date" id="datePicker" class="form-control" >
				
			     <form>
			      <input class="form-control me-2" id="search" type="search" placeholder="Search" aria-label="Search">
			     <button class="btn btn-primary" id ="searchBtn"  type="submit">검색</button>
			  </form>
			  <select class="form-control" id="optionBox" name="choices-button" id="choices-button" placeholder="Departure">
				  <option value="Choice 1" selected="">진행 상태</option>
				  <option value="Choice 2">구매 진행중</option>
				  <option value="Choice 3">구매 취소</option>
				  <option value="Choice 4">구매 완료</option>
				</select>
			  
			  </div>
		</div>
	
		  <table class="table table-hover" id="table">
		  <thead>
		    <tr>
		      <th scope="col">NO</th>
		      <th scope="col">제목</th>
		      <th scope="col">거래처</th>
		      <th scope="col">등록 날짜</th>
		      <th scope="col">담당자</th>
		      <th scope="col">제품 수</th>
		      <th scope="col">총 수량</th>
		      <th scope="col">총 금액</th>
		      <th scope="col">진행 상태</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row">1</th>
		      <td>Mark</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		    </tr>
		    <tr>
		      <th scope="row">2</th>
		      <td>Mark</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		    </tr>
		    <tr>
		  </tbody>
		</table>
		<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<li class="page-item"><a class="page-link" href="#">◁</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">▷</a></li>
							</ul>
						</nav>
		<button type="button" class="btn btn-primary" id="buyProBtn">구매 신청</button>
    </div> 
   
    <!-- ****** 공통 : 테이블 끝 ****** -->
   	 </div>
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
</body>
</html>
