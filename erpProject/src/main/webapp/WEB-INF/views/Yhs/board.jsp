	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../configHead.jsp"%>
<style>
@import
	url('https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css')
	;

.card-title {
	font-family: 'NanumSquare', sans-serif;
	color: #0D6DFD;
	font-weight: bold;
}

.search-bar {
	min-width: 360px;
	padding-top: 10px;
	font-family: 'NanumSquare', sans-serif;
	position: absolute; /* 절대 위치로 설정 */
	top: 30px; /* 상단에 배치 */
	right: -40px; /* 우측 여백 설정 */
	margin-bottom: 40px; /* 서치바 아래 여백 설정 */
}

@media ( max-width : 1199px) {
	.search-bar {
		position: fixed;
		top: 50px;
		left: 0;
		right: 0;
		padding-top: 20px;
		padding-bottom: 20px;
		box-shadow: 0px 0px 15px 0px rgba(1, 41, 112, 0.1);
		background: white;
		z-index: 9999;
		transition: 0.3s;
		visibility: hidden;
		opacity: 0;
	}
	.search-bar-show {
		top: 60px;
		visibility: visible;
		opacity: 1;
	}
}

.search-form {
	width: 100%;
}

.search-form input {
	border: 0;
	font-size: 14px;
	color: #012970;
	border: 1px solid rgba(1, 41, 112, 0.2);
	padding: 7px 38px 7px 8px;
	border-radius: 3px;
	transition: 0.3s;
	width: 300px;
}

.search-form input:focus, .search-form input:hover {
	outline: none;
	box-shadow: 0 0 10px 0 rgba(1, 41, 112, 0.15);
	border: 1px solid rgba(1, 41, 112, 0.3);
}

.search-form button {
	border: 0;
	padding: 0;
	margin-left: -30px;
	background: none;
}

.search-form button i {
	color: #012970;
}

/*--------------------------------------------------------------
# Search Bar
--------------------------------------------------------------*/
.section {
	font-family: 'NanumSquare', sans-serif;
}

.nav-link {
	font-weight: bold;
	font-size: large;
}

.table thead th {
	padding: 12px;
	text-align: center;
	border-bottom: 1px solid #0D6DFD;
	font-weight: bold;
	color: #0D6DFD;
}

.table tbody tr {
	text-align: center;
}

.btn-msg-primary {
	color: #0d6efd;
	background-color: transparent;
	border: 1px solid #0D6DFD;
	border-radius: 7px; /* 모서리를 둥글게 만들기 */
	padding: 2px 15px;
	transition: background-color 0.3s ease; /* 부드러운 전환을 위한 트랜지션 추가 */
}

.btn-msg-primary:hover {
	background-color: #B52BFC; /* 마우스를 올렸을 때의 배경색 */
	color: #ffffff; /* 마우스를 올렸을 때의 텍스트 색상 */
	border: 1px solid #B52BFC;
}

.floatright {
	float: right;
}
</style>
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
     <div class="row">
        <div class="col-12">
          <div class="card mb-4">
            <div class="card-header pb-0">
              <h6>공지사항</h6>
            </div>
            <div class="card-body px-0 pt-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                      <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">제목</th>
                      <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">사원번호</th>
                      <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">글번호</th>
                      <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">작성일</th>
                      <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">조회수</th>
                      <%--<th class="text-secondary opacity-7"></th> --%>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${listBoard}" var="board">
	                  <tr>
			          <td class="text-center">
			          	<h6 class="mb-0 text-xs"><a href="boardContents?b_no=${board.b_no}">${board.b_name}</a></h6>		
			          </td>
			         <td class="text-center">
			          	<h6 class="mb-0 text-xs">${board.emp_no}</h6>
			          </td>
			          <td class="text-center">
			          	<h6 class="mb-0 text-xs">${board.b_no}</h6>
			          </td>
			          <td class="text-center">
			          	<h6 class="mb-0 text-xs"><fmt:formatDate value="${board.b_regdate}"
													pattern="yyyy-MM-dd" />
						</h6>
			          </td>
			          <td class="text-center">
			          	<h6 class="mb-0 text-xs">${board.b_hit}</h6>
			          </td>
			        </tr>
		        </c:forEach>
                  </tbody>
                </table>
                               <%--  <nav aria-label="Page navigation example">
					    <ul class="pagination justify-content-center">
					        <c:if test="${page.startPage > page.pageBlock}">
					            <!-- "이전" 페이지 링크 -->
					            <li class="page-item">
					                <a class="page-link" href="board?currentPage=${page.startPage - page.pageBlock}">이전</a>
					            </li>
					        </c:if>
					        
					        <c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
					            <!-- 페이지 번호 링크 -->
					            <li class="page-item ${param.currentPage == i ? 'active' : ''}">
					                <a class="page-link" href="board?currentPage=${i}">${i}</a>
					            </li>
					        </c:forEach>
					        
					        <c:if test="${page.endPage < page.totalPage}">
					            <!-- "다음" 페이지 링크 -->
					            <li class="page-item">
					                <a class="page-link" href="board?currentPage=${page.startPage + page.pageBlock}">다음</a>
					            </li>
					        </c:if>
					    </ul>
					</nav> --%>
                	<div class="d-flex justify-content-center">
			         	<ul class="pagination">
							<c:if test="${page.startPage>paging.pageBlock }">
								<li class="page-item"><a class="page-link"
											href="board?currentPage=${page.startPage-page.pageBlock }"><</a>
								</li>
							</c:if>
							<c:forEach var="i" begin="${page.startPage }"
							end="${page.endPage }">
							<li class="page-item"><a class="page-link"
							href="board?currentPage=${i }">${i }</a>
							</li>
							</c:forEach>
							<c:if test="${page.endPage < page.totalPage }">
								<li class="page-item"><a class="page-link"
									href="board?currentPage=${page.startPage+paging.pageBlock }">></a>
								</li>
							</c:if>
						</ul>
			        	</div>

					<div class="d-flex justify-content-end">
			                  <a href="boardForm">
			                    <button type="button" class="btn-msg-primary">
			                      글작성
			                    </button>
			                  </a>
			                </div>
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