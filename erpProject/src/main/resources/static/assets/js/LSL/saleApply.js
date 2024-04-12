$(document).ready(function() {

	// 거래처 모달 처리 
	$("#close").click(function() {
		$("#customerSearchModal").modal("hide");
	});

	$("#customerSearchBtn").click(function() {
		$('#customerSearchModal').modal('show');
	});

	$('#customerSearchModal').on('hidden.bs.modal', function() {
		$(".cusSearchBox").val("");
		$(".cusSearchName").val("");
	});


	$("#makeClose").click(function() {
		$("#orderModal").modal("hide");

		$("#m_sdate").val("");
		$("#md_quantity").val("");
		$("#md_worker").val("");
	});

	fetchManagerList();




	// 매니저 리스트 
	function fetchManagerList() {
		var dept_no = $("#dept_no").val();

		$.ajax({
			type: "POST",
			url: "/getManagerList",
			data: { dept_no: dept_no },
			success: function(managerList) {
				managerList.forEach(function(manager) {
					var option = $("<option>")
						.val(manager.emp_name)
						.text(manager.emp_name);
					$("#s_manager").append(option);
					var m_option = $("<option>")
						.val(manager.emp_no) 
						.text(manager.emp_name); 
					$("#m_manager").append(m_option);
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
		var cust_type = $("#cust_type").val();

		$.ajax({
			url: "/customerSearch",
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify({ keyword: keyword, cust_type: cust_type }),
			success: function(response) {
				console.log(response);

				$(".cusSearchName").text(response.cust_name);

				$(".cusSearchName").click(function() {
					var selectedCustomer = $(this).text();
					console.log(selectedCustomer);
					$('#customerSearchModal').modal('hide');

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




	// 판매 제품 추가 
	$("#addBtn").click(function() {
		var p_itemcode = $("#saleItemSelect").val();
		var f_id = $("#saleItemSelect option:selected").data("fid");
		var p_name = $("#saleItemSelect option:selected").text();
		var st_quantity = $("#saleItemSelect option:selected").data("stquantity");
		var sd_cnt = $("#sd_cnt").val();
		var sd_price = $("#saleItemSelect option:selected").data("saleprice");
		var totalMoney = sd_cnt * sd_price;

		// 이미 등록된 상품인지 확인
		var isExistingProduct = false;
		$(".saleListItem").each(function() {
			if ($(this).find(".p_itemcode").val() === p_itemcode) {
				isExistingProduct = true;
				return false;
			}
		});


		if (!isExistingProduct) {
			var newItemHTML = `
                <li class="saleListItem">
                    <input type="hidden" class="p_itemcode" name="p_itemcode" value="${p_itemcode}">
                    <input type="hidden" class="f_id" name="f_id" value="${f_id}">
                    <input class = "p_name" value="${p_name}" disabled="disabled">
                    <input value="${st_quantity}" disabled="disabled">
                    <input value="${sd_price}"name="sd_price" disabled="disabled">
                    <input class="sdCnt" value="${sd_cnt}" name="sd_cnt">
                    <input value="${totalMoney}" disabled="disabled">
                    ${st_quantity < 100 ? '<button type="button" class="btn btn-primary pOrderBtn" id="pOrderBtn">발주</button>' : ''}
                    <button type="button" class="btn btn-primary pDeleteBtn">삭제</button>
                </li>
            `;
			$("#saleItemSelect").val("item 1");
			$(".saleItemCnt").val("");
			$(".saleList").append(newItemHTML);
		} else {
			alert("이미 등록된 상품입니다.");
			$("#saleItemSelect").val("item 1");
			$(".saleItemCnt").val("");
		}
	});

	$(document).on('click', '#pOrderBtn', function() {
		var listItem = $(this).closest('.saleListItem');

		var p_itemcode = listItem.find('.p_itemcode').val();
		var p_name = listItem.find('.p_name').val();
		var f_id = listItem.find('.f_id').val();

		var f_name_input = $("#f_name");

		if (f_id == "10001") {
			f_name_input.val("A동 공장");
		} else if (f_id == "10002") {
			f_name_input.val("B동 공장");
		}

		$('#p_itemcode').val(p_itemcode);
		$('#p_name').val(p_name);
		$('#f_id').val(f_id);


		$('#orderModal').modal('show');
	});


	// 제품 리스트 삭제 
	$(document).on("click", ".pDeleteBtn", function() {
		$(this).closest(".saleListItem").remove();
	});
	

	// 모달 저장 버튼 클릭 이벤트
	$("#orderModal").on("click", ".btn-primary", function() {

		var today = new Date();
		var formattedDate = today.toISOString().slice(0, 10).replace(/-/g, '');
		var m_sdate = formattedDate;
		var m_manager = $("#m_manager").val();
		var m_note = $("#m_note").val();


		$.ajax({
			type: "POST",
			url: "/makeRequest",
			contentType: 'application/json',
			data: JSON.stringify({
				m_sdate: m_sdate,
				m_manager: m_manager,
				m_note: m_note
			}),
			success: function(response) {
				console.log("데이터 삽입 성공:", response);
				$('#orderModal').modal('hide');
				$("#pOrderBtn").addClass("btn-danger").prop("disabled", true);
			},
			error: function(error) {
				console.error("데이터 삽입 실패:", error);
			}
		});
	});

	// 구매 등록 
	$("#saleApplyBtn").click(function() {
		var s_title = $("#s_title").val();
		var s_note = $("#s_note").val();
		var cust_no = $("#cust_no").val();
		var emp_no = $("#emp_no").val();
		var s_manager = $("#s_manager").val();
		
		

		var today = new Date();
		var formattedDate = today.toISOString().slice(0, 10).replace(/-/g, '');
		var s_date = formattedDate;

		// 발주 버튼 상태에 따라 판매 상태 변경
		var s_status = $("#pOrderBtn").hasClass("btn-danger") ? 2 : 0;

		// 제품 목록 수집
		var productList = [];

		$(".saleListItem").each(function() {
			var p_itemcode = $(this).find(".p_itemcode").val();
			var sd_price = $(this).find("[name='sd_price']").val();
			var sd_cnt = $(this).find(".sdCnt").val();
			var cust_no = $("#cust_no").val();

			productList.push({
				p_itemcode: p_itemcode,
				sd_price: sd_price,
				sd_cnt: sd_cnt,
				cust_no: cust_no,
				s_date: s_date
			});
		console.log(productList);
		});

		$.ajax({
			type: "POST",
			url: "/saleApplyWrite",
			contentType: 'application/json',
			data: JSON.stringify({
				s_title: s_title,
				s_note: s_note,
				cust_no: cust_no,
				s_date: s_date,
				emp_no: emp_no,
				s_manager: s_manager,
				s_status: s_status, 
				productList: productList
			}),
			success: function(response) {
				console.log("판매 등록 성공:", response);

				var redirectURL = "http://localhost:8587/saleDetail?cust_no=" + cust_no + "&s_date=" + s_date;
				window.location.href = redirectURL;
			},
			error: function(error) {
				console.error("판매 등록 실패:", error);
			}
		});
	});

});

