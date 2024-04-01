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

		
</style>
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
	 <label class="buyLabel">수불 내역 </label>
	  <!-- search bar -->
		<div class="searchBar">

			<div class="container-fluid">
			     <!-- datePicker -->
			     <form>	    
					<input type="date" id="datePicker" class="form-control" >
				</form>
			     <!-- <button class="btn btn-primary" id ="searchBtn"  type="submit">검색</button> -->
	
			  
			  </div>
		</div>
		
		<div class="upperButtonBar">
			<button type="button" class="btn btn-primary" id="buyProBtn0">구매</button>
			<button type="button" class="btn btn-primary" id="buyProBtn00">판매</button>
			<button type="button" class="btn btn-primary" id="buyProBtn000">생산</button>
			<button type="button" class="btn btn-primary" id="buyProBtn0000">재고조사</button>
		</div>
	
		  <table class="table table-hover" id="table">
		  <thead>
		    <tr>
		      <th scope="col">NO</th>
		      <th scope="col">날짜</th>
		      <th scope="col">구분</th>
		      <th scope="col">제품코드</th>
		      <th scope="col">제품명</th>
		      <th scope="col">수량</th>
		      <th scope="col">담당자</th>
		      <th scope="col">등록일</th>
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
			<button type="button" class="btn btn-primary downer-btn" id="buyProBtn3">월말마감</button>
			<button type="button" class="btn btn-primary downer-btn" id="buyProBtn2">해제</button>
			<button type="button" class="btn btn-primary downer-btn" id="buyProBtn1">마감</button>
    </div> 
   
    <!-- ****** 공통 : 테이블 끝 ****** -->
   	 </div>
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
</body>
</html>