<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../configHead.jsp"%>
</head>
<body>
 	<div class="min-height-300 position-absolute w-100" style="background-color: #172b4d;"></div>
 	<!-- Sidebar 사이드바 -->
  	<%@ include file="adminSidebar.jsp"%>
	<main class="main-content position-relative border-radius-lg ">
 	<!-- Header 헤더 -->
 	<%@ include file="adminHeader.jsp"%> 
    <div class="main-body container-fluid py-4">
    <!-- ***** -->	
    <div class="row">
        <div class="col-md-8 h-100">
        <div class="card h-100">
            <div class="card-header pb-0">
            <div class="d-flex align-items-center">
                <p class="mb-0 fw-bold">REGISTRATION</p>
            </div>
            </div>
            <div class="card-body">
            <div class="row">
                <p class="text-uppercase text-sm">Information</p>
                <div class="col-md-6">
                <div class="form-group">
                    <label for="example-text-input" class="form-control-label">ID</label>
                    <input class="form-control" type="text" value="lucky.jesse" onfocus="focused(this)" onfocusout="defocused(this)">
                </div>
                </div>
                <div class="col-md-6">
                    <label for="example-text-input" class="form-control-label">status</label>
                    <select class="form-select" aria-label="Default select example">
                        <option value="1" selected>재직</option>
                        <option value="2">휴직</option>
                        <option value="3">퇴사</option>
                    </select>
                </div>
                <div class="col-md-6">
                <div class="form-group">
                    <label for="example-text-input" class="form-control-label">birth</label>
                    <input class="form-control datepicker" placeholder="Please select date" type="text" onfocus="focused(this)" onfocusout="defocused(this)">
                </div>
                </div>
                <div class="col-md-6">
                <div class="form-group">
                    <label for="example-date-input" class="form-control-label">Date</label>
                    <input class="form-control" type="date" value="2018-11-23" id="example-date-input">
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
                <input type="text" placeholder="Success" class="form-control is-valid" />
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                <label for="example-text-input" class="form-control-label">Password Again</label>
                <input type="email" placeholder="Error Input" class="form-control is-invalid" />
                </div>
            </div>
            </div>
            <div class="button-row d-flex">
                <button class="btn btn-dark ms-auto mb-0 js-btn-next">저장</button>
            </div>
        </div>
        </div>
        </div>
        <div class="col-md-4 h-100">
            <div class="card h-100">
                <div class="card-header pb-0">
                <div class="d-flex align-items-center">
                    <p class="mb-0">INFORMATION</p>
                </div>
                </div>
                <div class="card-body">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group position-relative">
                            <img src="../assets/img/test.jpg" class="rounded-circle img-fluid border border-2 border-white">
                            <a href="javascript:;" class="btn btn-sm btn-icon-only bg-gradient-light mb-n2 me-n2 position-absolute bottom-8 end-10">
                                <i class="fa fa-pen top-0" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Edit image" aria-hidden="true" data-bs-original-title="Edit Image" aria-label="Edit Image"></i><span class="sr-only">Edit Image</span>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-6"></div>
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
                <div class="button-row d-flex">
                    <button class="btn btn-outline-dark ms-auto mb-0 js-btn-next">비밀번호 초기화</button>
                    <button class="btn btn-dark ms-2 mb-0 js-btn-next">저장</button>
                </div>
            </div>
            </div>
            </div>
    </div>
</div>
	
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
  
   	<!--   Back to Top   -->
	<div class="fixed-plugin">
	<a class="fixed-plugin-button text-dark position-fixed px-3 py-2">
	    <i class="ni ni-bold-up"> </i>
	</a>
	</div>
  
</body>
</html>