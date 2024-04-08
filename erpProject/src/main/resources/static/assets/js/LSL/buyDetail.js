$(document).ready(function() {
	$(".pDeleteBtn").hide();
	$(".pModifyBtn").hide();
	$("#buyModify").hide();
	$("#buyComple").hide();
	$("#addBtn").hide();

	// 구매 취소 버튼 비활성화
	var selectedValue = $("#buyStatusSelect").val();

	var buyStatus = $("#buyStatusBox").text();
	console.log("buyStatus:", buyStatus);

	if (buyStatus !== "구매 진행중") {
		$("#buyStatusSelect").prop("disabled", true);

	}

	// 수정 버튼 숨김 	
	var buyStatus = $("#buyStatusBox").text().trim();

    if (buyStatus === "구매 진행중") {
        $("#buyModify").show();
        $("#buyComple").show();
    }


	// 수정 버튼 클릭 시 입력 필드 활성화
	$("#buyModify").click(function() {
		$("input[type='text']").removeAttr("disabled");
		$("textarea").removeAttr("disabled");
		$(".bdCnt").removeAttr("disabled");
		$(".pDeleteBtn").show();
		$(".pModifyBtn").show();
		$("#addBtn").show();
	});



	$("#addBtn").click(function() {
		var p_itemcode = $("#buyingItemSelect").val();
		var cust_no = $("#cust_no").val();
		var buy_date = $("#buy_date").val();

		console.log(p_itemcode);

		$.ajax({
			type: "GET",
			url: "/getProductList",
			data: {
				cust_no: cust_no,
				buy_date: buy_date
			},
			success: function(getProductList) {
				console.log(getProductList);

				var isExistingProduct = getProductList.some(function(product) {
					console.log("p_itemcode:", p_itemcode);
					console.log("product.p_itemcode:", product.p_itemcode);

					var existing = product.p_itemcode == p_itemcode;
					console.log("isExistingProduct:", existing);
					return existing;
				});

				if (isExistingProduct) {
					alert("이미 등록된 제품입니다.");
					$("#buyingItemSelect").val("item 1");
					$(".buyItemCnt").val("");
				} else {
					addProduct(p_itemcode, cust_no, buy_date);
				}
			},
			error: function(error) {
				console.log("에러 발생:", error);
			}
		});
	});

	// 제품 추가
	function addProduct(p_itemcode, cust_no, buy_date) {
		var bd_cnt = $("#bd_cnt").val();
		var selectedOption = $("#buyingItemSelect option:selected");
		var bd_price = selectedOption.data("buyprice");


		$.ajax({
			type: "POST",
			url: "/addProduct",
			data: {
				p_itemcode: p_itemcode,
				bd_cnt: bd_cnt,
				cust_no: cust_no,
				buy_date: buy_date,
				bd_price: bd_price
			},
			success: function(productDetail) {
				alert(bd_price);
				console.log("productData" + productDetail);
				// 등록 후 페이지 새로 고침 없이 제품 목록 갱신
				refreshProductList();
			},
			error: function(error) {
				console.log("에러 발생:", error);
			}
		});
	}

	// 삭제 버튼 클릭시 제품 삭제
	$(document).on("click", ".pDeleteBtn", function() {
		var cust_no = $("#cust_no").val();
		var buy_date = $("#buy_date").val();
		var p_itemcode = $(this).closest('.buyListItem').find('.p_itemcode').val();

		console.log(p_itemcode);

		var $deletedItem = $(this).closest("li");

		$.ajax({
			type: "POST",
			url: "/deleteProduct",
			data: {
				p_itemcode: p_itemcode,
				cust_no: cust_no,
				buy_date: buy_date
			},
			success: function(response) {
				console.log("삭제 완료", response);
				$deletedItem.remove(); // 삭제된 요소를 DOM에서 제거
			},
			error: function(error) {
				console.log("에러", error);
			}
		});
	});

	// 완료 버튼 클릭 시 입력 데이터 저장
	$("#buyComple").click(function() {
		$("input[type='text']").attr("disabled", "disabled");
		$("textarea").attr("disabled", "disabled");
		$(".bdCnt").attr("disabled", "disabled");
		$(".pDeleteBtn").hide();
		$(".pModifyBtn").hide();
		$("#addBtn").hide();

		// 필요한 데이터 수집
		var buy_note = $("#colNoteBox").val();
		var bd_cnt = $(this).closest('.buyListItem').find('.bdCnt').val();
		var cust_no = $("#cust_no").val();
		var buy_date = $("#buy_date").val();
		var p_itemcode = $(".p_itemcode").val();

		// 수정된 구매 데이터를 서버로 전송
		var buyModifyData = {
			buy_note: buy_note,
			bd_cnt: bd_cnt,
			cust_no: cust_no,
			buy_date: buy_date,
			p_itemcode: p_itemcode
		};

		console.log(buyModifyData);

		$.ajax({
			type: "POST",
			url: "/buyingModify",
			data: JSON.stringify(buyModifyData),
			dataType: 'json',
			contentType: 'application/json',
			success: function(response) {
				console.log("buyModifyData" + buyModifyData);
			},
			error: function(error) {
				console.log("전송 실패");
				console.log(error);
			}
		});
	});

	// 제품 수정 
	$(document).on("click", ".pModifyBtn", function() {
		var bd_cnt = $(this).closest('.buyListItem').find('.bdCnt').val();
		var cust_no = $("#cust_no").val();
		var buy_date = $("#buy_date").val();
		var p_itemcode = $(this).closest('.buyListItem').find('.p_itemcode').val();
		var bd_price = $(this).closest('.buyListItem').find('#p_buyprice').val();

		var productCntModify = {
			bd_cnt: bd_cnt,
			cust_no: cust_no,
			buy_date: buy_date,
			p_itemcode: p_itemcode,
			bd_price: bd_price
		};

		$.ajax({
			type: "POST",
			url: "/productCntModify",
			data: JSON.stringify(productCntModify),
			dataType: 'json',
			contentType: 'application/json',
			success: function(response) {
				console.log("buyModifyData", productCntModify);
			},
			error: function(error) {
				console.log("전송 실패");
				console.log(error);
			}
		});
	});

	$("#buyStatusSelect").change(function() {
		var cust_no = $("#cust_no").val();
		var buy_date = $("#buy_date").val();
		var buy_status = $(this).val();
		console.log(buy_status);

		console.log("buy_status >>" + buy_status);

		var buyStatusChange = {
			cust_no: cust_no,
			buy_date: buy_date,
			buy_status: buy_status
		};

		console.log("buyStatusChange >>" + JSON.stringify(buyStatusChange));

		$.ajax({
			type: "POST",
			url: "/buyStatusChange",
			data: JSON.stringify(buyStatusChange),
			dataType: 'json',
			contentType: 'application/json',
			success: function(response) {
				if (response == "1") {
					$("#buyStatusBox").text("구매 취소");
			
				} else if (response == "2") {
					$("#buyStatusBox").text("구매 완료");
		
				} else if (response == "5") {
					$("#buyStatusBox").text("수불 완료");
				
				} else if (response == "0") {
					$("#buyStatusBox").text("구매 진행중");
					
				}
				var selectedOptionText = $("#buyStatusSelect option:selected").text();
				$("#buyStatusBox").text(selectedOptionText);
			},
			error: function(error) {
				console.log("전송 실패");
				console.log(error);
			}
		});

		// 옵션 변경 후에도 구매 상태를 즉시 업데이트
		
	});

	async function refreshProductList() {
		var cust_no = $("#cust_no").val();
		var buy_date = $("#buy_date").val();

		try {
			var response = await fetch("/getProductList?cust_no=" + cust_no + "&buy_date=" + buy_date);
			var productList = await response.json();
			console.log(productList);

			// 제품 목록 갱신
			// 기존 목록에 새로 추가된 제품 추가하기
			productList.forEach(function(product) {
				// 각 제품에 대한 DOM 생성 및 추가 작업 수행
				var newItem = $('<li>').text(product.p_name);
				$('.productList').append(newItem);
			});
		} catch (error) {
			console.log("제품 목록 갱신 실패");
			console.log(error);
		}
	}

});
