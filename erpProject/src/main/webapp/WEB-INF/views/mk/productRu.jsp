<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<!--jquery -->
<script type="text/javascript" src="js/jquery.js"></script>
<!-- js -->
<script type="text/javascript">
<%-- function getDeptName(pDeptno) {
	console.log(pDeptno);	
	// alert("pDeptno->"+pDeptno); 
	// 행동강령 :  Ajax로 부서번호 보내고 부서명 받음
 	 $.ajax(
    		 {
   				url:"<%=request.getContextPath()%>/getDeptName",  
   				data:{deptno : pDeptno},
   				dataType:'text',
   				success:function(deptName){
   					// alert("success ajax Data->"+deptName); 
   					$('#deptName').val(deptName);     /*  input Tag */
   					$('#msg').html(deptName);         /* span  id Tag */
   				}
   			}
 	 );		
} --%>

</script>
<head>
<%@ include file="../configHead.jsp"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/all.css">

</head>
<style>
/* 필터와 입력창 높이 조절 */
.form-floating .form-select, .form-floating .form-control {
	height: calc(2.2rem + 2px); /* 기본 높이를 줄임 */
	padding: .375rem .75rem; /* 패딩 조정으로 내부 텍스트 높이 조정 */
	font-size: .875rem; /* 필요에 따라 폰트 사이즈 조절 */
}

/* 라벨과 입력창 사이의 간격 줄임 */
.form-floating>label {
	padding: 0 .75rem; /* 라벨의 패딩을 줄임 */
	font-size: .875rem; /* 라벨의 폰트 사이즈 조절 */
	line-height: 1.2; /* 라벨의 라인 높이 조정 */
}

/* 입력 그룹 버튼의 높이와 패딩 조절 */
.input-group>.form-control, .input-group>.btn {
	height: calc(2.2rem + 2px); /* 버튼과 입력창 높이 일치 */
}

/* 버튼 내 아이콘 크기 조절 */
.input-group .btn .fas {
	font-size: .875rem; /* 아이콘 사이즈 조절 */
}

.pagination .page-link {
	border: none !important; /* 테두리 제거 */
	background: none !important;
} /* 배경색 제거, 필요에 따라 */
</style>

<body>
	<div class="min-height-300 bg-primary position-absolute w-100"></div>
	<!-- Sidebar 사이드바 -->
	<%@ include file="../sidebar.jsp"%>
	<main class="main-content position-relative border-radius-lg ">
		<!-- Header 헤더 -->
		<%@ include file="../header.jsp"%>
		<div class="comm-body container-fluid py-4">
			<!-- 메인 바디 -->
			<!-- ****** 공통 : 테이블 시작 ****** -->
			<!-- 이 아래부터는 파트별로 자유롭게 활용하시면 됩니다 -->
			<div class="row">
				<!-- 첫번째  -->
				<div class="col-4">
					<div class="card mb-4">
						<div class="card-header pb-0">

							<!--content name  -->
							<h6 class="mb-4">제품 조회</h6>


							<!--검색 및 필터  -->

							<div class="container">
								<!-- 필터 행 -->
								<div class="row">
									<div class="col">
										<div class="form-floating">
											<select class="form-select" id="filter1"
												aria-label="Filter 1">
												<option selected>카테고리</option>
												<option value="101">간편식</option>
												<option value="102">냉동식품</option>
												<option value="103">커피 및 차</option>
												<option value="104">탄산음료</option>
												<option value="105">주스</option>
												<option value="106">우유 및 유제품</option>
											</select>
									
										</div>
									</div>
									<div class="col">
										<div class="form-floating">
											<select class="form-select" id="filter2"
												aria-label="Filter 2">
												<option selected>판매여부</option>
												<option value="0">취급중</option>
												<option value="1">취급안함</option>
											
											</select>
									
										</div>
									</div>
								</div>
								<!-- 검색 행 -->
								<div class="row mt-2">
									<div class="col">
										<div class="input-group">
											<input type="text" class="form-control" placeholder="입력..."
												aria-label="Search" aria-describedby="button-addon2">
											<button class="btn btn-outline-secondary" type="button"
												id="button-addon2">
												<i class="fas fa-search"></i>
												<!-- FontAwesome 돋보기 아이콘 -->
											</button>
										</div>
									</div>
								</div>
							</div>




						</div>
						<div class="card-body px-0 pt-0 pb-2">

							<!--table-->
							<div class="table-responsive p-2">
							
								<table class="table align-items-center mb-0">
									<thead>
										<tr>
											<th
												class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">제품명</th>
											<th
												class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">제품코드</th>
											<th
												class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">카테고리</th>
											<th
												class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">판매여부</th>

										</tr>
									</thead>
									<tbody>
									<!-- jsp 데이터 리스터 반복문으로 출력  -->
									<c:forEach var="pr" items="${listProduct}">
										<tr>
											<td>
												<div class="d-flex px-2 py-1">
					
													<div class="d-flex flex-column justify-content-center">
														<!--상품이름을 클릭하면 해당 상세페이지가 옆에 뜨도록 함 -->
														<a href="#" onclick="ProductDetail('${pr.p_itemcode}')">
														<h6 class="mb-0 text-sm">${pr.p_name}</h6>
														</a>
													</div>
												</div>
											</td>
											<td>
												<p class="text-xs font-weight-bold mb-0">${pr.p_itemcode}</p>

											</td>
											<td class="align-middle text-center text-sm">
							
											<span class="badge badge-sm bg-gradient-success">
											<c:if test = "${pr.pro_midcategory == 101}">
											간편식
											</c:if>
											<c:if test = "${pr.pro_midcategory == 102}">
											냉동식품
											</c:if>
											<c:if test = "${pr.pro_midcategory == 103}">
											커피 및 차
											</c:if>
											<c:if test = "${pr.pro_midcategory == 104}">
											탄산음료
											</c:if>
											<c:if test = "${pr.pro_midcategory == 105}">
											주스
											</c:if>
											<c:if test = "${pr.pro_midcategory == 106}">
											우유 및 유제품
											</c:if>
											
											</span>
											
											</td>
											
								<%-- 				<c:if test ="${pr.p_itemcode ==0}">
												<p class="text-xs font-weight-bold mb-0">취급중</p>
											</c:if>
											<c:if test ="${pr.p_itemcode ==1}">
												<p class="text-xs font-weight-bold mb-0">취급안함</p>
											</c:if> --%>
											
											
											<td class="align-middle text-center">
											
											<span
												class="text-secondary text-xs font-weight-bold">
												<c:if test ="${pr.p_isdeleted==0}">
												취급중
												</c:if>
												<c:if test ="${pr.p_isdeleted==1}">
												취급안함
												</c:if>
												</span>
											
											
											
											
											</td>
											
											

										</tr>
						
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>

						<!-- 페이징 -->
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<li class="page-item"><a class="page-link" href="#">Pre</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">Next</a></li>
							</ul>
						</nav>
						<!-- 페이징 끝 -->
					</div>
				</div>






				<!--===========제품상세 ===============-->
				<div class="col-8">
					<div class="card mb-4">
						<div class="card-header pb-0">
							<!--content name  -->
							<h6>제품 상세</h6>
						</div>
						<div class="card-body px-0 pt-0 pb-2">

							<!--table-->
							<div class="table-responsive p-4">
						<!-- img-->
						<img src="../upload/jinnoodle.jpg" class="img-thumbnail" style="width: 200px; height: 200px;" alt="...">

						<!-- img end -->
								<!-- <form>
									<div class="form-group">
										<label for="exampleFormControlInput1">Email address</label> <input
											type="email" class="form-control"
											id="exampleFormControlInput1" placeholder="name@example.com">
									</div>
									
										<div class="form-group">
										<label for="exampleFormControlInput1">Email address</label> <input
											type="email" class="form-control"
											id="exampleFormControlInput1" placeholder="name@example.com">
									</div>
									
										<div class="form-group">
										<label for="exampleFormControlInput1">Email address</label> <input
											type="email" class="form-control"
											id="exampleFormControlInput1" placeholder="name@example.com">
									</div>
									
										<div class="form-group">
										<label for="exampleFormControlInput1">Email address</label> <input
											type="email" class="form-control"
											id="exampleFormControlInput1" placeholder="name@example.com">
									</div>
									
									<div class="form-group">
										<label for="exampleFormControlInput1">Email address</label> <input
											type="email" class="form-control"
											id="exampleFormControlInput1" placeholder="name@example.com">
									</div>
									
								
									
								</form> -->
								
								<form>
					    <div class="row">
					        <div class="col-md-6">
					            <div class="form-group">
					                <label for="exampleFormControlInput1">제품코드</label> 
					                <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
					            </div>
					            <div class="form-group">
					                <label for="exampleFormControlInput2">제품 대분류</label> 
					                <input type="email" class="form-control" id="exampleFormControlInput2" placeholder="name@example.com">
					            </div>
					            <div class="form-group">
					                <label for="exampleFormControlInput3">제품공장</label> 
					                <input type="email" class="form-control" id="exampleFormControlInput3" placeholder="name@example.com">
					            </div>
					              <div class="form-group">
					                <label for="exampleFormControlInput3">매출 가격</label> 
					                <input type="email" class="form-control" id="exampleFormControlInput3" placeholder="name@example.com">
					            </div>
					              <div class="form-group">
					                <label for="exampleFormControlInput3">판매상태</label> 
					                <input type="email" class="form-control" id="exampleFormControlInput3" placeholder="name@example.com">
					            </div>
					             <div class="form-group">
					                <label for="exampleFormControlInput3">등록날짜</label> 
					                <input type="email" class="form-control" id="exampleFormControlInput3" placeholder="name@example.com">
					            </div>
					            
					        </div>
					        <div class="col-md-6">
					            <div class="form-group">
					                <label for="exampleFormControlInput4">제품명</label> 
					                <input type="email" class="form-control" id="exampleFormControlInput4" placeholder="name@example.com">
					            </div>
					            <div class="form-group">
					                <label for="exampleFormControlInput5">제품 중분류</label> 
					                <input type="email" class="form-control" id="exampleFormControlInput5" placeholder="name@example.com">
					            </div>
					            <div class="form-group">
					                <label for="exampleFormControlInput6">공장구분</label> 
					                <input type="email" class="form-control" id="exampleFormControlInput6" placeholder="name@example.com">
					            </div>
					            <div class="form-group">
					                <label for="exampleFormControlInput7">매입가격</label> 
					                <input type="email" class="form-control" id="exampleFormControlInput7" placeholder="name@example.com">
					            </div>
					            <div class="form-group">
					                <label for="exampleFormControlInput7">판매 담당자</label> 
					                <input type="email" class="form-control" id="exampleFormControlInput7" placeholder="name@example.com">
					            </div>
					         
					        </div>
					        
					    </div>
					    
					    <!-- 버튼 -->
					    <div class="text-right">
					    <button class="btn btn-primary" type="button">저장</button>
					 </div>
					
					    
					    
					</form>
													


							</div>




						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- ****** 공통 : 테이블 끝 ****** -->

		<!-- Footer 푸터 -->
		<%@ include file="../footer.jsp"%>
	</main>
</body>

</html>