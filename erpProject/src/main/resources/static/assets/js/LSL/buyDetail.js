$(document).ready(function() {
	$(".pDeleteBtn").hide();
	$(".pModifyBtn").hide();
	$("#addBtn").hide();

	// 구매 취소 버튼 비활성화
	var buyStatus = $("#buyStatusBox").text();
	console.log("buyStatus:", buyStatus);

	if (buyStatus == "구매 완료") {
		$("#buyCancle").prop("disabled", true);
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
    var bd_price = $("#p_buyprice").val();

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
            console.log("productData" + productDetail);
            
            var newItem = `<li class="buyListItem">
                                <input type="hidden" id="p_buyprice" value="${productDetail.bd_price}">
                                <input type="hidden" class="p_itemcode" value="${productDetail.p_itemcode}">
                                <input value="${productDetail.p_itemcode}" disabled="disabled">
                                <input value="${productDetail.bd_price}" disabled="disabled">
                                <input class="bdCnt" value="${productDetail.bd_cnt}" disabled="disabled">
                                <input value="${productDetail.totalMoney}" disabled="disabled">
                                <button type="button" class="btn btn-primary pModifyBtn"> 수정</button>
                                <button type="button" class="btn btn-primary pDeleteBtn"> 삭제</button>
                            </li>`;
            $("#productList").append(newItem);
            $("#buyingItemSelect").val("item 1");
            $(".buyItemCnt").val("");
         
            
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

        var $deletedItem = $(this).closest("li"); // 삭제된 요소 참조

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



	$("#buyCancle").click(function() {
		var cust_no = $("#cust_no").val();
		var buy_date = $("#buy_date").val();

		var buyStatusChange = {
			cust_no: cust_no,
			buy_date: buy_date,

		};

		console.log("buyStatusChange >>" + JSON.stringify(buyStatusChange));

		$.ajax({
			type: "POST",
			url: "buyStatusChange",
			data: JSON.stringify(buyStatusChange),
			dataType: 'json',
			contentType: 'application/json',
			success: function(response) {
				if (response == "1") {
					$("#buyStatusBox").text("구매 취소");
				}
			},
			error: function(error) {
				console.log("전송 실패");
				console.log(error);
			}
		});
	});

});