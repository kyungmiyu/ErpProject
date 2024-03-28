<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<!-- datepicker 는 jquery 1.7.1 이상 bootstrap 2.0.4 이상 버전이 필요함 -->
<!-- jQuery가 먼저 로드 된 후 datepicker가 로드 되어야함.-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="resources/css/plugin/datepicker/bootstrap-datepicker.css">

<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.ko.min.js" integrity="sha512-L4qpL1ZotXZLLe8Oo0ZyHrj/SweV7CieswUODAAPN/tnqN3PA1P+4qPu5vIryNor6HQ5o22NujIcAZIfyVXwbQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<head>
<%@ include file="../configHead.jsp"%>

<style type="text/css">
td {
  transition: background-color 0.3s ease; /* 0.3초 동안 부드럽게 변경 */
}

td:hover {
  background-color: rgba(0, 0, 0, 0.075);
}
</style>
</head>

<body>
 	<div class="min-height-300 bg-primary position-absolute w-100"></div>
  	<%@ include file="../sidebar.jsp"%><!-- Sidebar 사이드바 -->
	<main class="main-content position-relative border-radius-lg ">
 	<%@ include file="../header.jsp"%><!-- Header 헤더 -->
    <div class="comm-body container-fluid py-4"> <!-- 메인 바디 -->
    
		 <!-- ****** 공통 : 테이블 시작 ****** -->
	 	 <!-- 이 아래부터는 파트별로 자유롭게 활용하시면 됩니다 -->
		<div>
			<h1>생산게시판</h1>
		</div>
		
		<!-- 생산 리스트 게시판 -->
		<div class="card">
		  <div class="table-responsive">
		    <table class="table align-items-center mb-0 table-hover">
		      <thead>
		        <tr>
		          <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">No</th>
		          <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">작업지시번호</th>
		          <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">작업상태</th>
		          <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">제품명</th>
		          <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">작업자</th>
		          <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">작업지시일자</th>
		          <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">작업완료일자</th>
		        </tr>
		      </thead>
		      <tbody>
		        <tr>
		          <td class="text-center">
		          	<h6 class="mb-0 text-xs">1</h6>
		          </td>
		          <td class="text-center">
		          	<h6 class="mb-0 text-xs">100001</h6>
		          </td>
		          <td class="text-center">
		          	<h6 class="mb-0 text-xs">완료</h6>
		          </td>
		          <td class="text-center">
		          	<h6 class="mb-0 text-xs">새우깡</h6>
		          </td>
		          <td class="text-center">
		          	<h6 class="mb-0 text-xs">오뚜기</h6>
		          </td>
		          <td class="text-center">
		          	<h6 class="mb-0 text-xs">2024-03-26</h6>
		          </td>
		          <td class="text-center">
		          	<h6 class="mb-0 text-xs">2024-03-26</h6>
		          </td>
		        </tr>
	
		      </tbody>
		    </table>
		  </div>
		</div>
		 	 	
		
		<!-- 페이징 -->
		<nav aria-label="Page navigation example" class="mt-3 mb-3">
		  <ul class="pagination justify-content-center">
		    <li class="page-item disabled">
		      <a class="page-link" href="javascript:;" tabindex="-1">
		        <i class="fa fa-angle-left"></i>
		        <span class="sr-only">Previous</span>
		      </a>
		    </li>
		    <li class="page-item"><a class="page-link" href="javascript:;">1</a></li>
		    <li class="page-item active"><a class="page-link" href="javascript:;">2</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:;">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="javascript:;">
		        <i class="fa fa-angle-right"></i>
		        <span class="sr-only">Next</span>
		      </a>
		    </li>
		  </ul>
		</nav>
		
		<!-- 생산 등록 버튼 -->
		<div class="d-flex justify-content-end">
			<button type="button" class="btn btn-primary" id="buyProBtn" onclick="location.href='makeRequest'">생산 요청</button>
		</div>
    

   
    <!-- ****** 공통 : 테이블 끝 ****** -->
   	 </div>
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
</body>
</html>