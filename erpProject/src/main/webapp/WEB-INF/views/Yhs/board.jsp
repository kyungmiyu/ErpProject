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
                      <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">댓글수</th>
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
			          	<h6 class="mb-0 text-xs">${board.b_regdate}</h6>
			          </td>
			          <td class="text-center">
			          	<h6 class="mb-0 text-xs">${board.b_hit}</h6>
			          </td>
			          <td class="text-center">
			          	<h6 class="mb-0 text-xs">${board.b_reply_no}</h6>
			          </td> 
			        </tr>
		        </c:forEach>
                  </tbody>
                </table>
                
                <nav aria-label="Page navigation example">
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
					</nav>
					
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