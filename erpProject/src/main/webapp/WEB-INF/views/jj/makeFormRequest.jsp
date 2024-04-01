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

legend {
  background-color: #000;
  color: #fff;
  padding: 3px 6px;
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

		<!-- 생산 요청 게시판123 -->
		<div class="card col-6">
			<div class="table-responsive">
				<div class="form-group">
					<h2>생산 요청 게시판</h2>
				</div>
				<form>
				  <div class="row">
					  <div class="col">
						  <label for="example-text-input" class="form-control-label">작업지시번호 M_NUM</label>
						  <input class="form-control" type="number" value="${jj_Make_detail.m_num}" id="example-text-input" readonly>
					  </div>
				      <div class="col">
				        <div class="mb-3">
				        	<label for="form-select" class="form-control-label">작업지시상태 MD_STATUS</label>
						    <select class="form-select" required aria-label="select example" id="form-select">
						      <option value="">선택사항</option>
						      <option value="0">0.생산요청</option>
						      <option value="1">1.영업생산요청</option>
						      <option value="2">2.생산중</option>
						      <option value="3">3.생산완료</option>
						      <option value="5">5.수불완료</option>
						    </select>
						    <div class="invalid-feedback">Example invalid select feedback</div>
						 </div>
				      </div>
				  </div>
					<fieldset>
    					<legend>관리자 입력란</legend>
					    <div class="form-group">
					        <label for="example-search-input" class="form-control-label">작업순번 MD_NUM</label>
					        <input class="form-control" type="number" value="" placeholder="작업순번" id="example-search-input">
					    </div>
					    <div class="form-group">
					        <label for="example-tel-input" class="form-control-label">작업지시일자 MD_DATE</label>
					        <input class="form-control" type="date" value="" placeholder="작업지시일자을 입력" id="example-tel-input">
					    </div>
					    <div class="form-group">
					        <label for="example-email-input" class="form-control-label">제품코드 P_ITEMCODE</label>
					        <input class="form-control" type="number" value="" placeholder="제품코드를 입력" id="example-email-input">
					    </div>
					    <div class="form-group">
					        <label for="example-url-input" class="form-control-label">제품명 P_NAME</label>
					        <input class="form-control" type="text" value="" placeholder="제품명을 입력" id="example-url-input">
					    </div>
					    <div class="form-group">
					        <label for="example-password-input" class="form-control-label">지시수량 MD_QUANTITY</label>
					        <input class="form-control" type="number" value="" placeholder="지시수량을 입력" id="example-password-input">
					    </div>
				    </fieldset>
				    <fieldset>
    					<legend>작업자 입력란</legend>
					    <div class="form-group">
					        <label for="example-number-input" class="form-control-label">작업자 MD_WORKER</label>
					        <input class="form-control" type="text" value="" placeholder="담당 작업자를 입력" id="example-number-input">
					    </div>
					    <div class="form-group">
					        <label for="example-datetime-local-input" class="form-control-label">작업인원 MD_WORKER_NUM</label>
					        <input class="form-control" type="number" value="" placeholder="작업인원수를 입력" id="example-datetime-local-input">
					    </div>
					    <div class="form-group">
					        <label for="example-date-input" class="form-control-label">작업완료일자 MD_WORK_DATE</label>
					        <input class="form-control" type="date" value="" placeholder="작업완료일자" id="example-date-input">
					    </div>
					    <div class="form-group">
					        <label for="example-month-input" class="form-control-label">생산수량 MD_PRO_QUANTITY</label>
					        <input class="form-control" type="number" value="" placeholder="생산수량을 입력" id="example-month-input">
					    </div>
					    <div class="form-group">
					        <label for="example-month-input" class="form-control-label">비고 MD_NOTE</label>
					        <input class="form-control" type="text" value="" placeholder="작업 특이사항을 입력" id="example-month-input">
					    </div>
				    </fieldset>
				    
				    <!-- 생산 요청 게시판 - 저장, 삭제, 목록 버튼 -->
					<div class="d-flex justify-content-end">
						<button type="button" class="btn btn-primary" id="buyProBtn" onclick="location.href='makeSave'">저장</button>
						<button type="button" class="btn btn-primary" id="buyProBtn" onclick="location.href='makeDelelte'">삭제</button>
						<button type="button" class="btn btn-primary" id="buyProBtn" onclick="location.href='makeMain'">목록</button>
					</div>
				</form>


			</div>
		</div>
				

    

   
    <!-- ****** 공통 : 테이블 끝 ****** -->
   	 </div>
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
</body>
</html>