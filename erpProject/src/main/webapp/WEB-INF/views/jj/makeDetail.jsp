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
		<div class="card col-6 w-75 p-5 float-end">
			<div class="table-responsive">
				<div class="form-group">
					<h2>생산 상세 게시글</h2>
				</div>
				
				  <div class="row">
					  <div class="col">
						  <label for="example-text-input" class="form-control-label">작업지시번호 m_num</label>
						  <input class="form-control" type="number" value="${jjmakeDetail.m_num}" id="example-text-input" readonly>
					  </div>
				      <div class="col">
				        <div class="mb-3">
				        	<label for="form-select" class="form-control-label">작업지시상태 md_status</label>
						    <select class="form-select" required aria-label="select example" id="form-select">
						      <option value="">선택사항</option>
						      <option value="${jjmakeDetail.md_status}" <c:if test="${jjmakeDetail.md_status eq '생산요청'}">selected</c:if>>0.생산요청</option>
						      <option value="${jjmakeDetail.md_status}" <c:if test="${jjmakeDetail.md_status eq '영업생산요청'}">selected</c:if>>1.영업생산요청</option>
						      <option value="${jjmakeDetail.md_status}" <c:if test="${jjmakeDetail.md_status eq '생산중'}">selected</c:if>>2.생산중</option>
						      <option value="${jjmakeDetail.md_status}" <c:if test="${jjmakeDetail.md_status eq '생산완료'}">selected</c:if>>3.생산완료</option>
						      <option value="${jjmakeDetail.md_status}" <c:if test="${jjmakeDetail.md_status eq '수불완료'}">selected</c:if>>5.수불완료</option>
						    </select>
						    <div class="invalid-feedback">Example invalid select feedback</div>
						 </div>
				      </div>
				      <div class="col">
				      	<div class="mb-3">
				        	<label for="form-select" class="form-control-label">수불마감구분 rpnc_gubun</label>
						    <select class="form-select" name="md_status" required aria-label="select example" id="form-select">
						      <option value="">선택사항</option>
						      <option value="${jjmakeDetail.rpnc_gubun}" <c:if test="${jjmakeDetail.rpnc_gubun eq '0'}">selected</c:if>>0.마감전</option>
						      <option value="${jjmakeDetail.rpnc_gubun}" <c:if test="${jjmakeDetail.rpnc_gubun eq '1'}">selected</c:if>>1.가마감</option>
						      <option value="${jjmakeDetail.rpnc_gubun}" <c:if test="${jjmakeDetail.rpnc_gubun eq '2'}">selected</c:if>>2.마감</option>
						     </select>
						    <div class="invalid-feedback">Example invalid select feedback</div>
				      	</div>
				      </div>
				  </div>
					<fieldset>
    					<legend>관리자 입력란</legend>
					    <div class="form-group">
					        <label for="example-search-input" class="form-control-label">작업순번 md_num</label>
					        <input class="form-control" type="number" value="${jjmakeDetail.md_num}" placeholder="작업순번" id="example-search-input">
					    </div>
					    <div class="form-group">
					        <label for="example-tel-input" class="form-control-label">작업지시일자 md_date</label>
					        <input class="form-control" type="date" value="${jjmakeDetail.md_date}" placeholder="작업지시일자을 입력" id="example-tel-input">
					    </div>
					    <div class="form-group">
					        <label for="form-select" class="form-control-label">공장명 f_name</label>
						    <select class="form-select" name="select_md_status" required aria-label="select example" id="form-select" disabled>
						      <option value="">선택사항</option>
						      <option value="${jjmakeDetail.f_id}" <c:if test="${jjmakeDetail.f_id eq '10001'}">selected</c:if> >A동 공장</option>
						      <option value="${jjmakeDetail.f_id}" <c:if test="${jjmakeDetail.f_id eq '10002'}">selected</c:if>>B동 공장</option>
						     </select>
					    </div>
					    <div class="form-group">
					        <label for="example-email-input" class="form-control-label">제품코드 p_itemcode</label>
					        <input class="form-control" type="number" value="${jjmakeDetail.p_itemcode}" placeholder="제품코드를 입력" id="example-email-input">
					    </div>
					    <div class="form-group">
					        <label for="example-url-input" class="form-control-label">제품명 p_name</label>
					        <input class="form-control" type="text" value="${jjmakeDetail.p_name}" placeholder="제품명을 입력" id="example-url-input">
					    </div>
					    <div class="form-group">
					        <label for="example-password-input" class="form-control-label">지시수량 md_quantity</label>
					        <input class="form-control" type="number" value="${jjmakeDetail.md_quantity}" placeholder="지시수량을 입력" id="example-password-input">
					    </div>
				    </fieldset>
				    <fieldset>
    					<legend>작업자 입력란</legend>
					    <div class="form-group">
					        <label for="example-number-input" class="form-control-label">작업자 md_worker</label>
					        <input class="form-control" type="text" value="${jjmakeDetail.md_worker}" placeholder="담당 작업자를 입력" id="example-number-input">
					    </div>
					    <div class="form-group">
					        <label for="example-datetime-local-input" class="form-control-label">작업인원 md_worker_num</label>
					        <input class="form-control" type="number" value="${jjmakeDetail.md_worker_num}" placeholder="작업인원수를 입력" id="example-datetime-local-input">
					    </div>
					    <div class="form-group">
					        <label for="example-date-input" class="form-control-label">작업완료일자 md_work_date</label>
					        <input class="form-control" type="date" value="${jjmakeDetail.md_work_date}" placeholder="작업완료일자" id="example-date-input">
					    </div>
					    <div class="form-group">
					        <label for="example-month-input" class="form-control-label">생산수량 md_pro_quantity</label>
					        <input class="form-control" type="number" value="${jjmakeDetail.md_pro_quantity}" placeholder="생산수량을 입력" id="example-month-input">
					    </div>
					    <div class="form-group">
					        <label for="example-month-input" class="form-control-label">비고 md_note</label>
					        <input class="form-control" type="text" value="${jjmakeDetail.md_note}" placeholder="작업 특이사항을 입력" id="example-month-input">
					    </div>
				    </fieldset>
				    
				    <!-- 생산 요청 게시판 - 저장, 삭제, 목록 버튼 -->
					<div class="d-flex justify-content-end">
						<button type="button" class="btn btn-primary" id="buyProBtn" onclick="location.href='makeSave'">저장</button>
						<button type="button" class="btn btn-primary" id="buyProBtn" onclick="location.href='jjmakeDelete?m_num=${md.m_num}'">삭제</button>
						<button type="button" class="btn btn-primary" id="buyProBtn" onclick="location.href='makeMain'">목록</button>
					</div>
				


			</div>
		</div>
				

    

   
    <!-- ****** 공통 : 테이블 끝 ****** -->
   	 </div>
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
</body>
</html>