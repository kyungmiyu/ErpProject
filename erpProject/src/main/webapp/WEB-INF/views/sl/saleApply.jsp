<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<link href="assets/css/LSL/saleApply.css" rel="stylesheet">
 
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="assets/img/favicon.png">
<title>ERP PROJECT</title>

<!--     Fonts and icons     -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
<!-- Nucleo Icons -->
<link href="assets/css/nucleo-icons.css" rel="stylesheet" />
<link href="assets/css/nucleo-svg.css" rel="stylesheet" />

<!-- Font Awesome Icons -->
<script defer src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
<link href="assets/css/nucleo-svg.css" rel="stylesheet" />
<!-- CSS Files -->
<link id="pagestyle" href="assets/css/argon-dashboard.css?v=2.0.4" rel="stylesheet" />
<!-- Github buttons -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
<!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<script defer src="assets/js/argon-dashboard.min.js?v=2.0.4"></script>

<!-- Google Icons -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!--
=========================================================
* Argon Dashboard 2 - v2.0.4
=========================================================

* Product Page: https://www.creative-tim.com/product/argon-dashboard
* Copyright 2022 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://www.creative-tim.com/license)
* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->
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
	 <div class="saleDetail">
	 <label class="saleDetailLabel">판매 등록</label>
	 
	 
	 	<div class="titleBox">
	  	<button type="button" class="btn btn-primary .customerSearchBtn" id="customerSearchBtn"> 검색</button>
		  	<input type="hidden" name="cust_type" id="cust_type" value="0"> 
			<input type="hidden" name="dept_no" id="dept_no" value="104">  	
			<input type="hidden" name="cust_no" id="cust_no" />
			<input type="hidden" name="emp_no" id="emp_no" />
			<!-- <input type="hidden" name="buy_manager" id="buy_manager" /> -->
	 	<div class="form-group" id="titleBox1">
		    <label for="detailTitle" id="detailTitleLabel" >제목</label>
		    <input class="form-control" id="s_title" name="s_title" placeholder="판매전표_YYYYMMDD_거래처명" />
		  	<label for="detailManager" id="detailManagerLabel" >거래처</label>
		    <input  class="form-control" id="cust_name" name="cust_no" value="" placeholder="거래처를 검색하세요." disabled="disabled" />
		  </div>
		  <div class="form-group" id="titleBox1">
		    <label for="detailTitle" id="detailTitleLabel">판매 담당자</label>
		    <select class="form-control " id="s_manager">
		     <option value="" selected>담당자를 선택하세요</option>
			</select>

		  	<label for="detailManager" id="detailManagerLabel" >거래처 담당자</label>
		    <input  class="form-control" id="emp_name" disabled="disabled" />
		  </div>
		</div>
		<div class="colNote">비고</div>
			 <textarea class="colNoteBox"  id="s_note" name="s_note" ></textarea>
			 <button type="submit" class="btn btn-primary" id="saleApplyBtn">판매 등록</button>

		<div class="modal fade" id="customerSearchModal" tabindex="-1" role="dialog" aria-labelledby="customerSearchModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="customerSearchModalLabel">거래처 검색</h5>
					</div>
					<div class="modalbody">
						<input type="text" class="cusSearchBox" id="cusSearchBox" name="keyword" placeholder="거래처명을 입력하세요."/>
						<div class="cusSearchName"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal" id="close">닫기</button>
						<button type="button" class="btn btn-primary" id="cusSearchBtn">검색</button>
					</div>
				</div>
			</div>
		</div>
			
			<div class="saleItemSelectBox">
                <p>제품</p>
                <select class="form-control" name="choices-button" id="saleItemSelect">
                    <option value="item 1" selected="">제품 선택</option>
                    <c:forEach items="${productList}" var="productList">
						<option value="${productList.p_itemcode}" data-saleprice="${productList.p_saleprice}", data-stquantity="${productList.st_quantity}" data-fid="${productList.f_id}">${productList.p_name}</option>               
						 </c:forEach>                  
                  </select>
                  
                 <p>수량</p>
                 <input type="text" class="saleItemCnt" id="sd_cnt"  name="sd_cnt" />
                 <button type="button" class="btn btn-primary" id="addBtn" >추가</button>
             </div>
		  
			 <div class="form-group" id="saleListItemsContainer">
		   		 <div class="custom-select" id="saleListItems">
		        <ul class="saleList">
		            <li class="saleListTitle">
		                <div>제품명</div>
						<div>재고 수량</div>
		                <div>제품 가격</div>
		                <div>제품 수량</div>
		                <div>총 금액</div>
		            </li>
        </ul>
    </div>
</div>


	<!-- 생산 요청 모달 -->
	<div class="modal fade" id="orderModal" tabindex="-1" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="orderModalLabel">발주 요청</h5>
				</div>
				<div class="modal-body">
					<div class="col">
					  <div class="mb-3">
						  <label for="form-select" class="form-control-label">작업지시상태</label>
						  <select class="form-select" name="m_status" required aria-label="select example" disabled="disabled" >
							<option value="1">1.영업생산요청</option>
						  </select>
						  <div class="invalid-feedback">Example invalid select feedback</div>
					   </div>
					</div>
					<div class="col">
						<div class="mb-3">
						  <label for="form-select" class="form-control-label">수불마감구분</label>
						  <select class="form-select" name="rpnc_gubun" required aria-label="select example" id="form-select" disabled="disabled">
							<option value="0">0.마감전</option>
						   </select>
						  <div class="invalid-feedback">Example invalid select feedback</div>
						</div>
					</div>
					<div class="form-group">
						<label for="m_sdate" class="form-control-label">작업지시일자</label>
						<input class="form-control" type="date" name="m_sdate" placeholder="작업지시일자을 입력" id="m_sdate">
					</div>
					<div class="form-group">
						<label for="f_name" class="form-control-label">공장명</label>
						<input class="form-control" type="text" name="f_name" id="f_name" readonly>
					</div>
					<div class="form-group">
						<label for="p_itemcode" class="form-control-label">제품코드</label>
						<input class="form-control" type="number" name="p_itemcode" id="p_itemcode" disabled="disabled">
					</div>
					<div class="form-group">
						<label for="p_name" class="form-control-label">제품명</label>
						<input class="form-control" type="text" name="p_name" id="p_name" disabled="disabled">
					</div>
					<div class="form-group">
						<label for="md_quantity" class="form-control-label">지시수량</label>
						<input class="form-control" type="number" name="md_quantity" placeholder="지시수량을 입력" id="md_quantity">
					</div>
					<div class="form-group">
						<label for="md_quantity" class="form-control-label">비고</label>
						<input class="form-control" type="text" name="m_note" placeholder="비고" id="m_note">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal" id="makeClose">닫기</button>
					<button type="button" class="btn btn-primary">저장</button>
				</div>
			</div>
		</div>
	</div>

	
    </div> 
   
    <!-- ****** 공통 : 테이블 끝 ****** -->
   	 </div>
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="assets/js/LSL/saleApply.js"></script>
  <!--   Core JS Files   -->
  <script src="./assets/js/core/popper.min.js"></script>
  <script src="./assets/js/core/bootstrap.min.js"></script>
  <script src="./assets/js/plugins/perfect-scrollbar.min.js"></script>
  <script src="./assets/js/plugins/smooth-scrollbar.min.js"></script>
  <script src="./assets/js/plugins/chartjs.min.js"></script>
  <script src="assets/js/plugins/chartjs.min.js"></script>
  
  
  
</body>
</html>