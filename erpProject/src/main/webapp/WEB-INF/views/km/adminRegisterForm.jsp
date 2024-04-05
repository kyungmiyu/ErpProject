<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<form action="/registration" method="post">
				<div class="row">
					<div class="col-md-12 h-100">
						<div class="card h-100">
							<div class="card-header pb-0">
								<div class="d-flex align-items-center">
									<p class="mb-0 fw-bold">REGISTRATION</p>
								</div>
							</div>
							<div class="card-body">
								<div class="row">
									<p class="text-uppercase text-sm">ACCOUNT</p>
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-text-input" class="form-control-label">사원번호</label>
											<input class="form-control" name="emp_name" type="text"
												value="" onfocus="focused(this)"
												onfocusout="defocused(this)">
										</div>
									</div>
									<div class="col-md-6">
										<label for="example-text-input" class="form-control-label">status</label>
										<select class="form-select" name="emp_status" aria-label="Default select example">
											<option value="1" selected>재직</option>
											<option value="2">휴직</option>
											<option value="3">퇴사</option>
										</select>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-date-input" class="form-control-label">입사일자</label>
											<input class="form-control" name="emp_hiredate" type="text" value="" id="example-date-input">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-date-input" class="form-control-label">퇴사일자</label>
											<input class="form-control" name="emp_retiredDate" type="text" value="" id="example-date-input">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-text-input" class="form-control-label">계정 사용 여부</label>
											<div class="d-flex pt-2 ml-1">
												<div class="form-check col-md-5">
													<input class="form-check-input" name="emp_enabled" type="checkbox" value="" id="fcustomCheck1" checked="">
													<label class="custom-control-label" for="customRadio1">활성화</label>
												</div>
												<div class="form-check col-md-5">
													<input class="form-check-input" name="emp_enabled" type="checkbox" value="" id="fcustomCheck2" checked="">
													<label class="custom-control-label" for="customRadio2">비활성화</label>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-text-input" class="form-control-label">권한</label>
											<select class="form-select" name="emp_role" aria-label="Default select example">
												<option value="1" selected>일반</option>
												<option value="2">담당자</option>
												<option value="3">관리자</option>
											</select>
										</div>
									</div>
								</div>
								<hr class="horizontal dark">
								<p class="text-uppercase text-sm">DEPARTMENT</p>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-text-input" class="form-control-label">부서명</label>
											<input type="hidden" name="dept_name" value=""> 
											<input type="hidden" name="dept_no" value=""> 
											<select class="form-select" aria-label="Default select example">
												<option selected>선택하세요</option>
												<option value="1">경영</option>
												<option value="2">인사</option>
												<option value="3">구매</option>
												<option value="4">생산</option>
												<option value="5">물류</option>
												<option value="6">영업</option>
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-text-input" class="form-control-label">직책</label>
											<input type="hidden" name="comm_mcd" value=""> 
											<input type="hidden" name="comm_content " value=""> 
											<select class="form-select" aria-label="Default select example">
												<option selected>선택하세요</option>
												<option value="10">사장</option>
												<option value="20">부장</option>
												<option value="30">차장</option>
												<option value="40">과장</option>
												<option value="50">대리</option>
												<option value="60">사원</option>
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-text-input" class="form-control-label">부서 전화번호</label> 
											<input class="form-control" name="dept_tel" type="text"value="" onfocus="focused(this)" onfocusout="defocused(this)">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-text-input" class="form-control-label">부서 존재 여부</label> 
											<select class="form-select" name="dept_enabled" aria-label="Default select example">
												<option value="1" selected>Y</option>
												<option value="2">N</option>
											</select>
										</div>
									</div>
								</div>

								<hr class="horizontal dark">
								<p class="text-uppercase text-sm">INFORMATION</p>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-text-input" class="form-control-label">이름</label>
											<input class="form-control" type="text" value="" onfocus="focused(this)" onfocusout="defocused(this)">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-date-input" class="form-control-label">생년월일</label>
											<input class="form-control" name="emp_birth" type="text" value="" id="example-date-input">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-text-input" class="form-control-label">Email</label>
											<input class="form-control" type="email" placeholder="name@example.com" value="" onfocus="focused(this)" onfocusout="defocused(this)">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-text-input" class="form-control-label">전화번호</label>
											<div class="d-flex">
												<input type="text" name="emp_phone1" class="form-control form-control w-33">- 
												<input type="text" name="emp_phone2" class="form-control form-control w-33">- 
												<input type="text" name="emp_phone3" class="form-control form-control w-33">
											</div>
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

									<div class="col-md-6">
										<div class="form-group">
											<label for="example-text-input" class="form-control-label">비밀번호</label>
											<input type="text" name="emp_password" placeholder="Success" class="form-control is-valid" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="example-text-input" class="form-control-label">비밀번호 확인</label> 
											<input type="text" name="emp_password2" placeholder="Error Input" class="form-control is-invalid" />
										</div>
									</div>

									<div class="button-row d-flex">
										<button class="btn btn-outline-dark ms-auto mb-0 js-btn-next">비밀번호 초기화</button>
										<input type="submit" class="btn btn-dark ms-2 mb-0 js-btn-next" value="저장" />
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

	<!--   Back to Top   -->
	<div class="fixed-plugin">
		<a class="fixed-plugin-button text-dark position-fixed px-3 py-2">
			<i class="ni ni-bold-up"> </i>
		</a>
	</div>

</body>
</html>