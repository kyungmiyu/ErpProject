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

		<!-- 생산 요청 게시판 -->
		<div>
			<h1>생산 요청 게시판</h1>
		</div>
		
		<form>
		    <div class="form-group">
		        <label for="example-text-input" class="form-control-label">Text</label>
		        <input class="form-control" type="text" value="John Snow" id="example-text-input">
		    </div>
		    <div class="form-group">
		        <label for="example-search-input" class="form-control-label">Search</label>
		        <input class="form-control" type="search" value="Tell me your secret ..." id="example-search-input">
		    </div>
		    <div class="form-group">
		        <label for="example-email-input" class="form-control-label">Email</label>
		        <input class="form-control" type="email" value="@example.com" id="example-email-input">
		    </div>
		    <div class="form-group">
		        <label for="example-url-input" class="form-control-label">URL</label>
		        <input class="form-control" type="url" value="" id="example-url-input">
		    </div>
		    <div class="form-group">
		        <label for="example-tel-input" class="form-control-label">Phone</label>
		        <input class="form-control" type="tel" value="40-(770)-888-444" id="example-tel-input">
		    </div>
		    <div class="form-group">
		        <label for="example-password-input" class="form-control-label">Password</label>
		        <input class="form-control" type="password" value="password" id="example-password-input">
		    </div>
		    <div class="form-group">
		        <label for="example-number-input" class="form-control-label">Number</label>
		        <input class="form-control" type="number" value="23" id="example-number-input">
		    </div>
		    <div class="form-group">
		        <label for="example-datetime-local-input" class="form-control-label">Datetime</label>
		        <input class="form-control" type="datetime-local" value="2018-11-23T10:30:00" id="example-datetime-local-input">
		    </div>
		    <div class="form-group">
		        <label for="example-date-input" class="form-control-label">Date</label>
		        <input class="form-control" type="date" value="2018-11-23" id="example-date-input">
		    </div>
		    <div class="form-group">
		        <label for="example-month-input" class="form-control-label">Month</label>
		        <input class="form-control" type="month" value="2018-11" id="example-month-input">
		    </div>
		    <div class="form-group">
		        <label for="example-week-input" class="form-control-label">Week</label>
		        <input class="form-control" type="week" value="2018-W23" id="example-week-input">
		    </div>
		    <div class="form-group">
		        <label for="example-time-input" class="form-control-label">Time</label>
		        <input class="form-control" type="time" value="10:30:00" id="example-time-input">
		    </div>
		    <div class="form-group">
		        <label for="example-color-input" class="form-control-label">Color</label>
		        <input class="form-control" type="color" value="#5e72e4" id="example-color-input">
		    </div>
		</form>
		
		
		<!-- 생산 요청 게시판 - 저장, 삭제, 목록 버튼 -->
		<div class="d-flex justify-content-end">
			<button type="button" class="btn btn-primary" id="buyProBtn" onclick="location.href='makeSave'">저장</button>
			<button type="button" class="btn btn-primary" id="buyProBtn" onclick="location.href='makeDelelte'">삭제</button>
			<button type="button" class="btn btn-primary" id="buyProBtn" onclick="location.href='makeMain'">목록</button>
		</div>
    

   
    <!-- ****** 공통 : 테이블 끝 ****** -->
   	 </div>
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
</body>
</html>