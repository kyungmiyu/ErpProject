<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	 <div class="buyDetail">
	 <label class="buyDetailLabel">구매 등록</label>
	
	 
	 	<div class="titleBox">
	  	<button type="button" class="btn btn-primary .customerSearchBtn" id="customerSearchBtn"> 검색</button>
		  	<input type="hidden" name="cust_type" id="cust_type" value="1">  
			<input type="hidden" name="dept_no" id="dept_no" value="3">  	
			<input type="hidden" name="cust_no" id="cust_no" />
			<input type="hidden" name="emp_no" id="emp_no" />
			<!-- <input type="hidden" name="buy_manager" id="buy_manager" /> -->
	 	<div class="form-group" id="titleBox1">
		    <label for="detailTitle" id="detailTitleLabel" >제목</label>
		    <input class="form-control" id="buy_title" name="buy_title" placeholder="구매전표_YYYYMMDD_거래처명" />
		  	<label for="detailManager" id="detailManagerLabel" >거래처</label>
		    <input  class="form-control" id="cust_name" name="cust_no" value="" placeholder="거래처를 검색하세요." disabled="disabled" />
		  </div>
		  <div class="form-group" id="titleBox1">
		    <label for="detailTitle" id="detailTitleLabel">구매 담당자</label>
		    <select class="form-control " id="buy_manager">
		     <option value="" selected>담당자 선택하세요</option>
			</select>

		  	<label for="detailManager" id="detailManagerLabel" >거래처 담당자</label>
		    <input  class="form-control" id="emp_name" disabled="disabled" />
		  </div>
		</div>
		<div class="colNote">비고</div>
			 <textarea class="colNoteBox"  id="buy_note" name="buy_note" ></textarea>
			 <button type="submit" class="btn btn-primary" id="buyApplyBtn">구매 등록</button>
	
		
		<div class="customerSearchPopup">
            <p>거래처 검색</p>
            <input type="text" class="cusSearchBox" name="keyword" placeholder="거래처명을 입력하세요."/>
            <div class="cusSearchName"></div>
            <p id="cusSearchXBtn">X</p>
            <button type="button" class="btn btn-primary" id="cusSearchBtn">검색</button>
        </div>
		
			
			<div class="buyItemSelectBox">
                <p>제품</p>
                <select class="form-control" name="choices-button" id="buyingItemSelect">
                    <option value="item 1" selected="">제품 선택</option>
                    <c:forEach items="${productList}" var="productList">
						<option value="${productList.p_itemcode}" data-buyprice="${productList.p_buyprice}">${productList.p_name}</option>               
						 </c:forEach>                  
                  </select>
                  
                 <p>수량</p>
                 <input type="text" class="buyItemCnt" id="bd_cnt"  name="bd_cnt" />
                 <button type="button" class="btn btn-primary" id="addBtn" >추가</button>
             </div>
		  
			 <div class="form-group" id="buyListItemsContainer">
		   		 <div class="custom-select" id="buyListItems">
		        <ul class="buyList">
		            <li class="buyListTitle">
		                <div>제품명</div>
		                <div>제품 가격</div>
		                <div>제품 수량</div>
		                <div>총 금액</div>
		            </li>
        </ul>
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