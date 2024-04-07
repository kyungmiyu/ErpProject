<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../configHead.jsp"%>
<script defer src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	function submitSearchForm(){
		if ($('input[name="searchValue"]').val() == null) {
			alert('검색어를 입력해주세요');
			return false;
		} else {
			$('form[name="searchForm"]').submit();
		}
		
	}
</script>
</head>
<body>
	<div class="min-height-300 position-absolute w-100" style="background-color: #172b4d;"></div>
	<!-- Sidebar 사이드바 -->
	<%@ include file="adminSidebar.jsp"%>
	<main class="main-content position-relative border-radius-lg ">
		<!-- Header 헤더 -->
		<%@ include file="adminHeader.jsp"%>

		<div class="main-body container-fluid py-4">

			<!-- ***************************************************************** -->
			<div class="row">
				<div class="col-12">
					<div class="card mb-4">
						<div class="card-header pb-0">
							<h6>Information</h6>
						</div>
						 <div class="col-auto">
				            <div class="bg-white border-radius-lg d-flex me-2">
				            <form action="/listEmployeeProc" name="searchForm" method="POST">
				              	<select class="form-select" name="searchType">
								  <option value="A" selected>전체</option>
								  <option value="E">사원</option>
								  <option value="D">부서명</option>
								</select>
							 	<input type="text" name="searchValue" class="form-control border-0 ps-3" placeholder="검색어를 입력하세요">
				              	<input type="button" onclick="submitSearchForm()" value="Search" class="btn bg-gradient-primary my-1 me-1" />
				            </form>
				            </div>
				          </div>
						<div class="card-body px-0 pt-0 pb-2">
							<div class="table-responsive p-0">
								<table class="table align-items-center mb-0">
									<thead>
										<tr>
											<th class="text-uppercase text-secondary text-xs font-weight-bolder opacity-7">사원 정보</th>
											<th class="text-uppercase text-secondary text-xs font-weight-bolder opacity-7 ps-2">부서명 / 직책</th>
											<th class="text-center text-uppercase text-secondary text-xs font-weight-bolder opacity-7">상태</th>
											<th class="text-center text-uppercase text-secondary text-xs font-weight-bolder opacity-7">입사일</th>
											<th class="text-secondary opacity-7"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listEmployee}" var="employee">
											<tr>
												<td>
													<div class="d-flex px-2 py-1">
														<div>
															<img src="../assets/img/test.jpg" class="avatar avatar-sm me-3" alt="user1">
														</div>
														<div class="d-flex flex-column justify-content-center">
															<h6 class="mb-0 text-sm">${employee.empName}</h6>
															<p class="text-xs text-secondary mb-0">${employee.empEmail}</p>
														</div>
													</div>
												</td>
												<td>
													<p class="text-xs font-weight-bold mb-0">${employee.empJobName}</p>
													<p class="text-xs text-secondary mb-0">부서명</p>
												</td>
												<td class="align-middle text-center text-sm"><span
													class="badge badge-sm bg-gradient-success">${employee.empRole}</span>
												</td>
												<td class="align-middle text-center"><span
													class="text-secondary text-xs font-weight-bold">${employee.empHireDate}</span>
												</td>
												<td class="align-middle">
													<a href="/employeeEditForm?empNo=${employee.empNo}" class="text-secondary font-weight-bold text-xs"
															data-toggle="tooltip" data-original-title="Edit user"> Edit </a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- ***************************************************************** -->
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