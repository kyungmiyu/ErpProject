$(document).ready(function() {
	$("#customerSearchBtn").click(function() {
		$(".customerSearchPopup").css("display", "block");
	});

	$("#cusSearchXBtn").click(function() {
		$(".customerSearchPopup").css("display", "none");
		$(".cusSearchName").val("");
		$(".cusSearchBox").val("");
	});

	fetchManagerList();

	// 매니저 리스트 
	function fetchManagerList() {
		$.ajax({
			type: "GET",
			url: "/getManagerList",
			contentType: "application/json",
			success: function(managerList) {
				managerList.forEach(function(manager) {
					var option = $("<option>")
						.val(manager.emp_no)
						.text(manager.emp_name);
					$("#managerName").append(option);
					$("#buy_manager").val(manager.emp_name);
				});
			},
			error: function(error) {
				console.log("에러 발생:", error);
			}
		});
	}

	// 거래처 검색 
	$("#cusSearchBtn").click(function() {
		var keyword = $(".cusSearchBox").val();

		$.ajax({
			url: "/customerSearch",
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify({ keyword: keyword }),
			success: function(response) {
				console.log(response);

				$(".cusSearchName").text(response.cust_name);

				$(".cusSearchName").click(function() {

					var selectedCustomer = $(this).text();

					console.log(selectedCustomer);
					$(".customerSearchPopup").css("display", "none");

					$("#cust_name").val(response.cust_name);
					$("#emp_name").val(response.emp_name);
					$("#cust_no").val(response.cust_no);
					$("#emp_no").val(response.emp_no);

					$(".cusSearchName").val("");
					$(".cusSearchBox").val("");
				});
			},
			error: function(error) {
				console.error("검색 요청 실패: " + error);
			}
		});
	});

	$("#addBtn").click(function() {
		var p_itemcode = $("#buyingItemSelect").val();
		var p_name = $("#buyingItemSelect option:selected").text();
		var bd_cnt = $("#bd_cnt").val();
		var bd_price = $("#buyingItemSelect option:selected").data("buyprice");
		var totalMoney = bd_cnt * bd_price;

		// 이미 등록된 상품인지 확인
		var isExistingProduct = false;
		$(".buyListItem").each(function() {
			if ($(this).find(".p_itemcode").val() === p_itemcode) {
				isExistingProduct = true;
				return false; // 중복된 상품이 있으면 반복문 종료
			}
		});

		if (!isExistingProduct) {
			var newItemHTML = `
                <li class="buyListItem">
                    <input type="hidden" class="p_itemcode" value="${p_itemcode}">
                    <input value="${p_name}" disabled="disabled">
                    <input value="${bd_price}" disabled="disabled">
                    <input class="bdCnt" value="${bd_cnt}" >
                    <input value="${totalMoney}" disabled="disabled">
                    <button type="button" class="btn btn-primary pModifyBtn">수정</button>
                    <button type="button" class="btn btn-primary pDeleteBtn">삭제</button>
                </li>
            `;
			$("#buyingItemSelect").val("item 1");
			$(".buyItemCnt").val("");
			$(".buyList").append(newItemHTML);
		} else {
			alert("이미 등록된 상품입니다.");
			$("#buyingItemSelect").val("item 1");
			$(".buyItemCnt").val("");
		}
	});

	// 수정 버튼 클릭 이벤트
	$(document).on("click", ".pModifyBtn", function() {
		var $productItem = $(this).closest(".buyListItem");
		var p_itemcode = $productItem.find(".p_itemcode").val();
		var p_name = $productItem.find("input:eq(1)").val();
		var bd_cnt = $productItem.find("input:eq(3)").val();
		var bd_price = $productItem.find("input:eq(2)").val();
		var totalMoney = $productItem.find("input:eq(4)").val();

		console.log("수정할 제품 정보:", p_itemcode, p_name, bd_cnt, bd_price, totalMoney);
	});

	// 제품 리스트 삭제 
	$(document).on("click", ".pDeleteBtn", function() {
		$(this).closest(".buyListItem").remove();
	});

	$("#buyApplyBtn").click(function() {
    // 필요한 데이터 수집
    var buy_title = $("#buy_title").val();
    var buy_note = $("#buy_note").val();
    var cust_no = $("#cust_no").val();
    var emp_no = $("#emp_no").val();
    var buy_manager = $("#buy_manager").val();
    var buy_date = new Date().toISOString().slice(0, 8);

    // 제품 목록 수집
    var productList = [];
    $(".product").each(function() {
        var p_itemcode = $(this).find(".p_itemcode").val();
        var bd_price = $(this).find(".bd_price").val();
        var bd_cnt = $(this).find(".bd_cnt").val();
        productList.push({
            p_itemcode: p_itemcode,
            bd_price: bd_price,
            bd_cnt: bd_cnt
        });
    });

    $.ajax({
        type: "POST",
        url: "/buyingApplyWrite",
        contentType: "application/json",
        data: JSON.stringify({
            buy_title: buy_title,
            buy_note: buy_note,
            cust_no: cust_no,
            emp_no: emp_no,
            buy_manager: buy_manager,
            buy_date: buy_date,
            productList: productList
        }),
        success: function(response) {
            console.log("구매 등록 성공:", response);
        },
        error: function(error) {
            // 오류 발생 시 처리 방법 (예: 오류 메시지 표시)
            console.error("구매 등록 실패:", error);
        }
    });
});
});