<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<link href="assets/css/LSL/buyDetail.css" rel="stylesheet">


 
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
	 <div class="buyDetail">
	 <label class="buyDetailLabel">구매 상세</label>
	 
	 <div class="titleBox">

		<button type="button" class="btn btn-primary" id="buyCancle">구매 취소</button>
		<div class="buyStatusBox">구매 진행중</div>
	 
	 	<div class="form-group" id="titleBox1">
		    <label for="detailTitle" id="detailTitleLabel">제목</label>
		    <input type="text" class="form-control" id="detailTitle" value="${buyingDetail.buy_title}">
		  	<label for="detailManager" id="detailManagerLabel">거래처</label>
		    <div  class="form-control" id="detailManager" >${buyingDetail.cust_name}</div>
		  </div>
		  <div class="form-group" id="titleBox1">
		    <label for="detailTitle" id="detailTitleLabel">구매 담당자</label>
		    <div class="form-control" id="detailTitle">${buyingDetail.managerName}</div>
		  	<label for="detailManager" id="detailManagerLabel">거래처 담당자</label>
		    <div  class="form-control" id="detailManager" >${buyingDetail.emp_name}</div>
		  </div>
		</div>

			  <div class="colNote">비고</div>
			  <textarea type="text"  class="colNoteBox">${buyingDetail.buy_note}</textarea>
			  
			  
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
		  
			 <div class="form-group" id="buyListItemsContainer">
		    <div class="custom-select" id="buyListItems">
		        <ul class="buyList">
		            <li class="buyListTitle">
		                <div>제품명</div>
		                <div>제품 가격</div>
		                <div>제품 수량</div>
		                <div>총 금액</div>
		            </li>
            <c:forEach var="productDetail" items="${productDetail}">
                <li class="buyListItem">
                    <div>${productDetail.p_name}</div>
                    <div>${productDetail.bd_price}</div>
                    <div>${productDetail.bd_cnt}</div>
                    <div>${productDetail.totalMoney}</div>
                    <button type="button" class="btn btn-primary" id="pDeleteBtn"> 삭제</button>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
	
   	<button type="button" class="btn btn-primary" id="buyModify">수정</button>
    <button type="button" class="btn btn-primary" id="buyComple">완료</button>
    </div> 
   
    <!-- ****** 공통 : 테이블 끝 ****** -->
   	 </div>
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
</body>
</html>