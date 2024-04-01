<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<link href="assets/css/LSL/buyDetail.css" rel="stylesheet">

<<!-- datepicker 는 jquery 1.7.1 이상 bootstrap 2.0.4 이상 버전이 필요함 -->
<!-- jQuery가 먼저 로드 된 후 datepicker가 로드 되어야함.-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="resources/css/plugin/datepicker/bootstrap-datepicker.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/js/all.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="resources/js/plugin/datepicker/bootstrap-datepicker.js"></script>

<!--한국어  달력 쓰려면 추가 로드-->
 <script src="resources/js/plugin/datepicker/bootstrap-datepicker.ko.min.js"></script> 
 
 <link href="assets/js/LSL/buying.js">
 
<head>
<%@ include file="../configHead.jsp"%>
<style>
	.form-control {
		width: 250px;
		margin-left: 70px;
	}
	
	#registBtn {
		position: absolute;
	    right: 	100px;
	}

	#saveBtn {
		position: absolute;
		right: 120px;
	}
	
	.row {
		width: 93%;
		margin-left: 50px;
	}
	
	#registStockBeginBtn {
	    background-color: #d3d3d3; /* 클릭 시 회색 계열로 변경 */
	    border-color: #d3d3d3; /* 테두리 색상도 함께 변경 */
	    color: #fff; /* 텍스트 색상을 흰색으로 변경 */
	}
	
	
	
</style>


<script>
document.addEventListener("DOMContentLoaded", function() {
    // 페이지 로딩이 완료되면 실행될 함수

    var stockYearMonthDay = "${stock.st_year_month_day}";

    // 날짜 값을 입력란에 넣어주기
    if (stockYearMonthDay) {
    	var year = stockYearMonthDay.substring(0, 4); // 연도 추출
        var month = stockYearMonthDay.substring(4, 6); // 월 추출
        var day = stockYearMonthDay.substring(6, 8); // 일 추출
        var formattedDate = year + "-" + month + "-" + day; // "yyyy-MM-dd" 형식으로 변환
        
        // 날짜 값이 존재할 때만 처리
        var datePicker = document.getElementById("datePicker");
        datePicker.value = formattedDate; // 입력란에 날짜 값 넣기
    }
});

$(document).ready(function () {
	
 	$("#datePicker").change(function () {
        var selectedDate = $("#datePicker").val(); // 변경된 날짜 가져오기
        var year = selectedDate.substring(0, 4); // 연도 추출
        var month = selectedDate.substring(5, 7); // 월 추출
        var day = selectedDate.substring(8, 10); // 일 추출
        var formattedDate = year + month + day; // 형식 변환
        var emp_no = ${empData.emp_no};
        
        $.ajax({
            url: "lhsFormRegistStockBegin", // 컨트롤러 URL 설정
            type: "GET", // GET 또는 POST
            data: { 
            	st_year_month_day: formattedDate, // 선택된 날짜 값 전달
            	emp_no : emp_no
            },
            success: function (data) {
            	window.location.href = "lhsFormRegistStockBegin?st_year_month_day=" + formattedDate +"&emp_no=" + emp_no;
            },
            error: function (xhr, status, error) {
                // 오류 발생 시 처리할 코드 작성
                console.error("Error occurred:", error);
            }
        });
    });
 	
 	$(".itemCode").keypress(function(event) {
 	    // 입력된 키 코드 가져오기
 	    var keycode = (event.keyCode ? event.keyCode : event.which);
 	    var emp_no = ${empData.emp_no}
 	    // Enter 키의 keyCode 값은 13
 	    if (keycode == '13') {
 	        // Enter 키가 눌렸을 때 실행할 코드 작성
 	        // 제품코드 값 가져오기
 	        var itemCode = $(this).val();
 	        
 	        $.ajax({
 	            url: "lhsCheckNewItem",
 	            type: "GET",
 	            data: { 
 	                itemCode: itemCode,
 	               	emp_no: emp_no
 	            },
 	            success: function(data) {
 	               // 가져온 데이터를 각 입력란에 채워 넣기
 	               $(".itemName").val(data.itemName);
 	               $(".quantity").val(data.quantity);
 	               $(".manager").val(data.manager);
 	                
 	               $("#registBtn").click(function() {
 	                  // 입력된 값 가져오기
 	                  var itemCode = $(".itemCode").val();
 	                  var itemName = $(".itemName").val();
 	                  var quantity = $(".quantity").val();
 	                  var manager = $(".manager").val();
 	                  
 	                  // 리스트에 추가
 	                  var listItem = "<tr><td>" + itemCode + "</td><td class='itemName'></td>"+
 	                  					"<td class='quantity'></td><td class='manager'></td>"+
 	                  					"<td><button type='button' class='btn btn-danger deleteBtn'>삭제</button></td></tr>";
 	                  $("#resultList").append(listItem);
 	                  
 	                  // 입력란 비우기
 	                  $(".itemCode").val("");
 	                  $(".itemName").val("");
 	                  $(".quantity").val("");
 	                  $(".manager").val("");
 	              });
 	                
 	            },
 	            error: function(xhr, status, error) {
 	                // 오류 발생 시 처리할 코드 작성
 	                console.log("제품코드를 다시 입력해주세요");
 	            }
 	        });
 	    }
 	});
 	
 	
    // 삭제 버튼 클릭 시
    $(document).on("click", ".deleteBtn", function() {
        $(this).closest("tr").remove(); // 클릭된 버튼이 속한 행 삭제
    });
});

</script>
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
	 <div class="buyDetail">
	 <label class="buyDetailLabel">기초재고 등록</label>
	 
	 		<div class="searchBar">

			<div class="container-fluid">
	               <div class="row">
                       <div class="col">
                       		<form action="lhsFormRegistStockBegin" method="get">
                           		<button type="submit" class="btn btn-primary btn-block" id="registStockBeginBtn">기초재고 등록</button>
                           	</form>
                       </div>
                       <div class="col">
                       		<form action="lhsFormRegistStockSurvey" method="get">
                           		<button type="submit" class="btn btn-primary btn-block" id="registStockSurveyBtn">실사 재고조사 등록</button>
                           	</form>
                       </div>
                    </div>
			     <!-- datePicker -->
					<input type="date" id="datePicker" class="form-control" >
			  
			  </div>
		</div>
	 
	 <div class="titleBox">
	 
	 	<div class="form-group" id="titleBox1">
		    <label for="detailTitle" id="detailTitleLabel">제품코드</label>
		    <input type="text" class="form-control itemCode" id="detailTitle" placeholder="">
		  	<label for="detailManager" id="detailManagerLabel">제품명</label>
		    <input type="text" class="form-control itemName" id="detailManager" placeholder="" readonly>
		  </div>
		  <div class="form-group" id="titleBox1">
		    <label for="detailTitle" id="detailTitleLabel">수량</label>
		    <input type="text" class="form-control quantity" id="detailTitle" placeholder="" readonly>
		  	<label for="detailManager" id="detailManagerLabel">담당자</label>
		    <input type="text" class="form-control manager" id="detailManager" placeholder="" readonly>
		  </div>
	 
		   
		</div>

	
   	<button type="button" class="btn btn-primary" id="registBtn">등록</button>
  
   	</div>
   	<div class="text-center">
	   	<table class="table" style="margin-left: 70px; width: 80%; hegight: 30px;">
		    <thead>
		        <tr>
		            <th scope="col">제품코드</th>
		            <th scope="col">제품명</th>
		            <th scope="col">수량</th>
		            <th scope="col">담당자</th>
		            <th scope="col">삭제</th>
		        </tr>
		    </thead>
		    <tbody id="resultList"></tbody>
		</table>
	</div>   	
   	
    <button type="button" class="btn btn-primary" id="saveBtn">저장</button>
  
   
    <!-- ****** 공통 : 테이블 끝 ****** -->
   	 </div>
   	<!-- Footer 푸터 -->
   	<%@ include file="../footer.jsp"%> 
  </main>
</body>
</html>