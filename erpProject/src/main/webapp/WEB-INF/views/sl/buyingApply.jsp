<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<link href="assets/css/LSL/buyingApply.css" rel="stylesheet">
 
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
	 <div class="buyingApply">
	 <label class="buyingApplyLabel">구매 등록</label>
	 
	 <div class="titleBox">

		<button type="button" class="btn btn-primary" id="buyApply">주문 등록</button>
		
	 
	 	<div class="form-group" id="titleBox1">
		    <label for="detailTitle" id="detailTitleLabel">제목</label>
		    <input type="text" class="form-control" id="detailTitle1" placeholder="구매전표_YYYYMMDD_거래처명">
		  	<label for="detailManager" id="detailManagerLabel">거래처</label>
		    <input type="text" class="form-control" id="detailManager1" placeholder="거래처를 검색하세요.">
            <button type="button" class="btn btn-primary" id="customerSearchBtn">검색</button>
		  </div>
		  <div class="form-group" id="titleBox1">
		    <label for="detailTitle" id="detailTitleLabel">구매 담당자</label>
		    <input type="text" class="form-control" id="detailTitle2" placeholder="">
		  	<label for="detailManager" id="detailManagerLabel">거래처 담당자</label>
		    <input type="text" class="form-control" id="detailManager2" placeholder="">
		  </div>
		</div>

        <!-- 거래처 검색 팝업창 -->
        <div class="customerSearchPopup">
            <p>거래처 검색</p>
            <input type="text" class="cusSearchBox"  placeholder="거래처명을 입력하세요."/>
            <div class="cusSearchName"></div>
            <p type="button" id="cusSearchXBtn">X</p>
            <button type="button" class="btn btn-primary" id="cusSearchBtn">검색</button>
            <button type="button" class="btn btn-primary" id="cusChioceBtn" >선택</button>



        </div>
			  

			  <div class="colNote">비고</div>
			  <textarea type="text"  class="colNoteBox" placeholder="구매 특이사항을 적어주세요"></textarea>

              <div class="buyItemSelectBox">
                <p>제품</p>
                <select class="form-control" name="choices-button" id="buyingItemSelect" placeholder="Departure">
                    <option value="item 1" selected="">Brazil</option>
                    <option value="Choice 2">Bucharest</option>
                    <option value="Choice 3">London</option>
                    <option value="Choice 4">USA</option>
                  </select>
                 <p>수량</p>
                 <input type="text" class="buyItemCnt" placeholder="수량을 입력하세요"/>
                 <button type="button" class="btn btn-primary" id="addBtn" >추가</button>
              </div>
		  
		 <div class="buyList">
		    <ul class="buyListTitle">
		        <li>제품명</li>
		        <li>제품 가격</li>
		        <li>제품 수량</li>
		        <li>총 금액</li>
		    </ul>
		</div>
		  
		<div class="form-group" id="buyListItemsContainer">
			<div class="custom-select" id="buyListItems">
				<div class="custom-option"></div>
				<div class="custom-option"></div>
				<div class="custom-option"></div>
				<div class="custom-option"></div>
                <button type="button" class="btn btn-primary" id="buyItemDeleteBtn">삭제</button>
			</div>
		</div>
    </div> 
   
    <!-- ****** 공통 : 테이블 끝 ****** -->
   	 </div>
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="assets/js/LSL/buyingApply.js"></script>
  
</body>
</html>