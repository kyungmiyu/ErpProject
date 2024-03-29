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
		    <input type="text" class="form-control" id="detailTitle" placeholder="">
		  	<label for="detailManager" id="detailManagerLabel">거래처</label>
		    <input type="text" class="form-control" id="detailManager" placeholder="">
		  </div>
		  <div class="form-group" id="titleBox1">
		    <label for="detailTitle" id="detailTitleLabel">구매 담당자</label>
		    <input type="text" class="form-control" id="detailTitle" placeholder="">
		  	<label for="detailManager" id="detailManagerLabel">거래처 담당자</label>
		    <input type="text" class="form-control" id="detailManager" placeholder="">
		  </div>
	 
		   
		</div>
			  

			  <div class="colNote">비고</div>
			  <textarea type="text"  class="colNoteBox" placeholder="구매 특이사항을 적어주세요"></textarea>

		  
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