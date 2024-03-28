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

		<div class="detailBox">
			<div class="container">
			  <div class="row row-cols-4">
			    <div class="col">제목</div>
			    <div class="col"></div>
			    <div class="col">거래처 담당자</div>
			    <div class="col"></div>
			  </div>
			</div>
			<div class="container">
			  <div class="row row-cols-4">
			    <div class="col">구매 담당자</div>
			    <div class="col"></div>
			    <div class="col">거래처</div>
			    <div class="col"></div>
			  </div>
			</div>

		<form>
		  <div class="form-group">
		    <label for="exampleFormControlInput1">Email address</label>
		    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
		  </div>
		  <div class="form-group">
		    <label for="exampleFormControlSelect1">Example select</label>
		    <select class="form-control" id="exampleFormControlSelect1">
		      <option>1</option>
		      <option>2</option>
		      <option>3</option>
		      <option>4</option>
		      <option>5</option>
		    </select>
		  </div>
		  <div class="form-group">
		    <label for="exampleFormControlSelect2">Example multiple select</label>
		    <select multiple class="form-control" id="exampleFormControlSelect2">
		      <option>1</option>
		      <option>2</option>
		      <option>3</option>
		      <option>4</option>
		      <option>5</option>
		    </select>
		  </div>
		  <div class="form-group">
		    <label for="exampleFormControlTextarea1">Example textarea</label>
		    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
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