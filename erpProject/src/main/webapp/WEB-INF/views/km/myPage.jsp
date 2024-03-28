<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
 	<!-- 메인 바디 -->
	<div class="main-body container-fluid py-4">
	<!-- ***** -->	
      <div class="row">
        <div class="col-md-8 h-100">
          <div class="card h-100">
            <div class="card-header pb-0">
              <div class="d-flex align-items-center">
                <p class="mb-0">Information</p>
              </div>
            </div>
            <div class="card-body">
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">ID</label>
                    <input class="form-control" type="text" value="lucky.jesse" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">status</label>
                    <input class="form-control" type="email" value="jesse@example.com" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">birth</label>
                    <input class="form-control" type="text" value="Jesse" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">hiredate</label>
                    <input class="form-control" type="text" value="Lucky" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
              </div>
              <hr class="horizontal dark">
              <p class="text-uppercase text-sm">Contact Information</p>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">Email</label>
                    <input class="form-control" type="text" value="Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">phone</label>
                    <input class="form-control" type="text" value="Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">address</label>
                    <input class="form-control" type="text" value="New York" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="example-text-input" class="form-control-label">Post code</label>
                    <input class="form-control" type="text" value="437300" onfocus="focused(this)" onfocusout="defocused(this)">
                  </div>
                </div>
              </div>
              <hr class="horizontal dark">
              <div class="row">
              <p class="text-uppercase text-sm">About me</p>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="example-text-input" class="form-control-label">Password</label>
                  <input class="form-control" type="text" value="437300" onfocus="focused(this)" onfocusout="defocused(this)">
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="example-text-input" class="form-control-label">Password Again</label>
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
                  <img src="../assets/img/bg-profile.jpg" alt="Image placeholder" class="card-img-top">
                </div>
              </div>
            </div>
            <div class="row justify-content-center">
              <div class="col-4 col-lg-4 order-lg-2">
                <div class="mt-n4 mt-lg-n6 mb-4 mb-lg-0">
                  <a href="javascript:;">
                    <img src="../assets/img/test.jpg" class="rounded-circle img-fluid border border-2 border-white">
                  </a>
                </div>
              </div>
            </div>
            <div class="card-header text-center border-0 pt-0 pt-lg-2 pb-4 pb-lg-3">
              <div class="d-flex justify-content-between">
                <a href="javascript:;" class="btn btn-sm btn-info mb-0 d-none d-lg-block">Connect</a>
                <a href="javascript:;" class="btn btn-sm btn-info mb-0 d-block d-lg-none"><i class="ni ni-collection"></i></a>
                <a href="javascript:;" class="btn btn-sm btn-dark float-right mb-0 d-none d-lg-block">Message</a>
                <a href="javascript:;" class="btn btn-sm btn-dark float-right mb-0 d-block d-lg-none"><i class="ni ni-email-83"></i></a>
              </div>
            </div>
            <div class="card-body pt-0">
              <div class="row">
                <div class="col">
                  <div class="d-flex justify-content-center">
                    <div class="d-grid text-center">
                      <span class="text-lg font-weight-bolder">22</span>
                      <span class="text-sm opacity-8">Friends</span>
                    </div>
                    <div class="d-grid text-center mx-4">
                      <span class="text-lg font-weight-bolder">10</span>
                      <span class="text-sm opacity-8">Photos</span>
                    </div>
                    <div class="d-grid text-center">
                      <span class="text-lg font-weight-bolder">89</span>
                      <span class="text-sm opacity-8">Comments</span>
                    </div>
                  </div>
                </div>
              </div>
              <div class="text-center mt-4">
                <h5>유경미</h5>
                <div class="h6 font-weight-300">
                  <i class="ni location_pin mr-2"></i>사원
                </div>
                <div class="h6 mt-4">
                  <i class="ni business_briefcase-24 mr-2 py-2"></i>인사관리팀
                </div>
                <div>
                  <i class="ni education_hat mr-2 py-2"></i>중앙판매회사
                </div>
              </div>
            </div>
          
        </div>
      </div>
    </div>
   </div>
<!-- ***** -->	
	
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
 </main>
</body>
</html>