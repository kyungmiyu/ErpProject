$(document).ready(function() {
    $("#buyModify").click(function() {
        $("input[type='text']").removeAttr("disabled");
        $("textarea").removeAttr("disabled");
    });

    $("#addBtn").click(function() {
        var p_itemcode= $("#buyingItemSelect").val();
        var bd_cnt = $("#bd_cnt").val();
        var cust_no = $("#cust_no").val();
        var buy_date = $("#buy_date").val();
         
        alert('p_itemcode->'+p_itemcode);
       alert('bd_cnt->'+bd_cnt);
       alert('cust_no->'+cust_no);
       alert('p_itemcode->'+p_itemcode);
       alert('buy_date->'+buy_date);

            
 

        $.ajax({
            type: "POST",
            url: "/addProduct",
            data: {
	            p_itemcode: p_itemcode,
	            bd_cnt: bd_cnt,
	            cust_no:cust_no,
	            buy_date: buy_date
            },
            success: function(response) {
                console.log("productData" + productData);
                $("#buyingItemSelect").val("item 1");
                $(".buyItemCnt").val("");
            },
            error: function(error) {
                console.log("에러 발생:", error);
            }
        });
    });

    $("#buyComple").click(function() {
        $("input[type='text']").attr("disabled", "disabled");
        $("textarea").attr("disabled", "disabled");

        var buy_note = $(".colNoteBox").val();
        var p_name = $("#buyingItemSelect").val();
        var bd_cnt = $(".buyItemCnt").val();

        const buyModifyData = {
            buy_note: buy_note,
            p_name: p_name,
            bd_cnt: bd_cnt
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
});
