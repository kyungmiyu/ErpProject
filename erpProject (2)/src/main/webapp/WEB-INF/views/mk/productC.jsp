<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

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
			

				<!--===========제품상세 ===============-->
				<div class="col-10">
					<div class="card mb-4">
						<div class="card-header pb-0">
							<!--content name  -->
							<h6>제품 등록</h6>
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