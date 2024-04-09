<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../configHead.jsp"%>
<link href="assets/css/km/myPage.css" rel="stylesheet">
</head>
<body>
 	<div class="min-height-300 bg-primary position-absolute w-100"></div>
 	<!-- Sidebar 사이드바 -->
  	<%@ include file="../sidebar.jsp"%>
	<main class="main-content position-relative border-radius-lg ">
 	<!-- Header 헤더 -->
 	<%@ include file="../header.jsp"%> 

	<div class="main-body container-fluid py-4">
	<form action="/editEmployeeForm" method="post">
      <div class="row">
        <div class="col-md-8 h-100">
          <div class="card h-100">
            <div class="card-header pb-0">
              <div class="d-flex align-items-center">
                <p class="mb-0">EMPLOYEE</p>
              </div>
            </div>
            <div class="card-body">
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">사원번호</label>
                    <input class="form-control" type="text" value="${employee.empNo}" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">재직</label>
                    <input class="form-control" type="email" value="jesse@example.com" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">생년월일</label>
                    <input class="form-control" type="text" value="Jesse" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">입사일</label>
                    <input class="form-control" type="text" value="Lucky" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
              </div>
              <hr class="horizontal dark">
              <p class="text-uppercase text-sm">INFORMATION</p>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">Email</label>
                    <input class="form-control" type="text" value="Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">전화번호</label>
                    <input class="form-control" type="text" value="Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">주소</label>
                    <input class="form-control" type="text" value="New York" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">우편번호</label>
                    <input class="form-control" type="text" value="437300" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
              </div>
              <hr class="horizontal dark">
              <div class="row">
              <p class="text-uppercase text-sm">PASSWORD RESET</p>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="example-text-input" class="form-control-label">비밀번호</label>
                  <input class="form-control" type="text" value="437300" onfocus="focused(this)" onfocusout="defocused(this)">
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="example-text-input" class="form-control-label">비밀번호 확인</label>
                  <input class="form-control" type="text" value="437300" onfocus="focused(this)" onfocusout="defocused(this)">
                </div>
              </div>
            </div>
            <button class="btn btn-sm bg-gradient-primary btn-sm ms-auto d-lg-block mt-4">저장</button>
          </div>
          </div>
        </div>
        <div class="col-md-4 h-100">
          <div class="card card-profile h-100">
            <div class="bg-gradient-dark card-img-top">
              <div class="bg-transparent shadow-xl">
                <div class="overflow-hidden">
                  <img src="../assets/img/bggray.jpg" alt="Image placeholder" class="card-img-top">
                </div>
              </div>
            </div>
            <div class="row justify-content-center">
              <div class="col-4 col-lg-4 order-lg-2">
                <div class="mt-n4 mt-lg-n6 mb-4 mb-lg-0">
                    <img src="../assets/img/test.jpg" class="rounded-circle img-fluid border border-2 border-white">
                </div>
              </div>
            </div>
            <div class="card-header text-center border-0 pt-0 pt-lg-2 pb-4 pb-lg-3">
              <div class="d-flex justify-content-between">
                <a href="javascript:;" class="btn btn-sm btn-dark float-right mb-0 d-none d-lg-block ms-auto">권한</a>
              </div>
            </div>
            <div class="card-body pt-0 mb-4">
              <div class="text-center mt-4 mb-4">
                <h5>유경미</h5>
                <div class="h6 font-weight-300">
                  <i class="ni location_pin mr-2"></i>사원
                </div>
                <div class="h6 mt-4">
                  <i class="ni business_briefcase-24 mr-2 py-2"></i>인사팀
                </div>
                <div>
                  <i class="ni education_hat mr-2 py-2"></i>중앙판매회사
                </div>
              </div>
            </div>
        </div>
      </div>
    </div>
    </form>
   </div>
	
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
 </main>
 
</body>
</html>