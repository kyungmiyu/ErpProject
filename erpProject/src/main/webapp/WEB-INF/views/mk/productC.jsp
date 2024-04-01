<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>

<head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
function previewImage(input) {
    // 파일이 선택되었는지 확인
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function(e) {
            // 읽기 성공 시 이미지 미리보기 업데이트
            $('#imagePreview').attr('src', e.target.result);
            $('#imagePreviewContainer').show();
        }
        
        // 선택된 파일 읽기
        reader.readAsDataURL(input.files[0]);
    }
}
</script>




      
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


				<!--===========제품 등록 ===============-->
			
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
						<!-- 이미지 업로드 필드 -->
						<form action="writeProduct" method="post" name="product" enctype="multipart/form-data">
							<div class="form-group">
							    <label for="uploadFile">이미지 업로드</label>
							    <input type="file" class="form-control" name="uploadFile" id="uploadFile" aria-describedby="inputGroupFileAddon04" aria-label="Upload" onchange="previewImage(this);">
							</div>
							
							<!-- 이미지 미리보기를 위한 컨테이너 -->
							<div id="imagePreviewContainer" style="display:none;">
							    <img id="imagePreview" style="width: 200px; height: 200px;" alt="Image Preview"/>
							</div>

							
							

							<!-- 이미지등록 끝 -->
								

								
							
								
									<div class="row">
										<div class="col-md-6">
										<!-- 제품 코드 -->
											<div class="form-group">
												<label for="p_name">제품명</label> 
												<input
													type="text" class="form-control"
													name ="p_name">
											</div>
											<!-- 제품 대분류  -->
											<div class="form-group">
												<label for="pro_category">제품 대분류</label> 
												<input
													type="text" class="form-control"
													name="pro_category"
													id="pro_category">
											</div>
											
										
											<!-- 매출가격  -->
											<div class="form-group">
												<label for="p_saleprice">매출 가격</label> 
												<input
													type="text" class="form-control"
													id="p_saleprice"
													name="p_saleprice">
											</div>
											
											
											<!-- 공장구분 -> 공장생산 제품 0 , 구매제품1 -->
											<div class="form-group">
												<label for="p_fac_gubun">공장구분</label> 
												<input
													type="text" class="form-control"
													id="p_fac_gubun"
													name="p_fac_gubun">
											</div>
									

										</div>
										<div class="col-md-6">
									
										
										<!-- 제품 공장 : 공장 리스트 검색해서 뿌려주기 -->
											
											<div class="form-group">
												<label for="f_id">제품공장</label>
												 <input
													type="text" class="form-control"
													name="f_id"
													id="f_id">
											</div>
											<!-- 제품 중분류  -->
											<div class="form-group">
												<label for="pro_midcategory">제품 중분류</label>
												 <input
													type="text" class="form-control"
													id="pro_midcategory"
													name="pro_midcategory">
											</div>
											
											<!-- 매입가격 -->
											<div class="form-group">
												<label for="p_buyprice">매입가격</label> 
												<input
													type="text" class="form-control"
													id="p_buyprice">
											</div>
											
											
											<!-- 제품상세  -->
											<div class="p_content">
												<label for="p_content">제품상세</label> 
												<input
													type="text" class="form-control"
													id="p_content"
													name="p_content">
											</div>
											
											
					
										</div>

									</div>

									<!-- 버튼 -->
									<div class="text-right">
										<button class="btn btn-primary" type="submit">저장</button>
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